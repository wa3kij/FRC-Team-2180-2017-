'''
Created on Nov 9, 2016

@author: micro
'''
import cv2
import numpy as np

camera = cv2.VideoCapture(0)
  
def detect(image):
    #convert the image to grayscale
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    
    #compute the Scharr gradient magnitude representation of the images
    #in both the x and y direction
    gradX = cv2.Sobel(gray,ddepth = cv2.CV_32F, dx = 1, dy = 0, ksize=-1)
    gradY = cv2.Sobel(gray,ddepth = cv2.CV_32F, dx = 0, dy = 1, ksize=-1)
    
    #subtract the y-gradient from the x-gradient
    gradient = cv2.subtract(gradX, gradY)
    gradient = cv2.convertScaleAbs(gradient)
    
    #blur and threshold the image
    blurred = cv2.blur(gradient, (9,9))
    (_, thresh) = cv2.threshold(blurred, 225, 225, cv2.THRESH_BINARY)
    
    #construct a closing kernel and apply it to the threshold image
    kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (21,7))
    closed = cv2.morphologyEx(thresh, cv2.MORPH_CLOSE, kernel)
    
    #perform a series of erosions and dilations
    closed = cv2.erode(closed, None, iterations=4)
    closed = cv2.dilate(closed, None, iterations=4)
    
    #find the contours in the threshold image
    (_,cnts,_) = cv2.findContours(closed.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    
    #if no contours were found, return None
    if len(cnts) == 0:
        return None
    
    #otherwise, sort the contours by area and compute the rotated
    #bounding box of the largest contour
    c = sorted(cnts, key=cv2.contourArea, reverse=True)[0]
    rect = cv2.minAreaRect(c)
    box = np.int0(cv2.boxPoints(rect))
    
    #return the bounding box of the barcode
    return box

#keep looping over all the frames
while True:
    (grabbed, frame) = camera.read()
    
    #call detect function to detect barcode
    box = detect(frame)

    #if a barcode was found, draw a bounding box on the frame
    cv2.drawContours(frame, [box], -1, (0,255,0), 2)
    
    cv2.imshow('Frame', frame)
    key = cv2.waitKey(1) & 0xFF
    
    #if the 'q' key is pressed, stop webcam and exit loop
    if key == ord('q'):
        break
    
camera.release()
cv2.destroyAllWindows()