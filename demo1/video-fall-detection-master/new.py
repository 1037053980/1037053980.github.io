#Based on Zed code - Person Fall detection using raspberry pi camera and opencv lib. Link: https://www.youtube.com/watch?v=eXMYZedp0Uo

import cv2
import time

cap = cv2.VideoCapture('queda.mp4')
time.sleep(2)

fgbg = cv2.createBackgroundSubtractorMOG2()
j = 0
while(1):
    ret, frame = cap.read()

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    fgmask = fgbg.apply(gray)

    contours, _ = cv2.findContours(fgmask, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    if contours:
        areas = []

        for contour in contours:
            ar = cv2.contourArea(contour)
            areas.append(ar)
        
        max_area = max(areas or [0])

        max_area_index = areas.index(max_area)

        cnt = contours[max_area_index]

        M = cv2.moments(cnt)
        
        x, y, w, h = cv2.boundingRect(cnt)  # 检测人体范围，用矩形表示，获得x,y,x+w,y+h，四个坐标

        cv2.drawContours(fgmask, [cnt], 0, (255,255,255), 3, maxLevel = 0)
        
        if h < w:   # 当人体矩形的宽度大于高度，计数器加一，每一帧判断一次
            j += 1
            
        if j > 2:  # 连续的4帧宽度大于高度，则判断为跌倒
            print("fall")
            cv2.putText(frame, 'Fall', (x, y), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (0,0,255), 2)
            cv2.rectangle(frame,(x,y),(x+w,y+h),(0,0,255),2)   # 检测出跌倒后，用红色框出人体

        if h > w:    # 高度大于宽度，计数器清零
            j = 0
            cv2.putText(frame, 'Stand', (x, y), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (0, 255, 0), 2)
            cv2.rectangle(frame,(x,y),(x+w,y+h),(0,255,0),2)   # 未检测出跌倒，用绿色框出人体

        cv2.imshow('video', frame)
    
        if cv2.waitKey(33) == 27:
            break
cv2.destroyAllWindows()