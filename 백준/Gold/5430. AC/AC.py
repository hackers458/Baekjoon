import sys
input = sys.stdin.readline
from collections import deque
T = int(input())


def r(isReverse):
    if isReverse == False:
        return True
    else:
        return False

def d():
    global array
    global array_reverse
    global isReverse
    if not array:
        return True
    else:
        if isReverse == True:
            array.pop()
            array_reverse.popleft()
        else:
            array.popleft()
            array_reverse.pop()
        return False



for i in range(T):
    inputCommand = list(input().strip())
    array_size = int(input())
    array = input().strip().strip("[").strip("]")
    isReverse = False
    isError = False
    if array == "":
        for j in inputCommand:
            if j == "D":
                isError = True
                break
        if isError == True:
            print("error")
        else:
            print("[]")
    else:
        array_reverse = deque(reversed(deque(array.split(","))))
        array = deque(array.split(","))
        for j in inputCommand:
            if j == "R":
                isReverse = r(isReverse)
            elif j == "D":
                isError = d()
                if isError == True:
                    break
        if isError == True:
            print("error")
        else:
            if not array:
                print("[]")
            else:
                if isReverse == True:
                    print("["+",".join(array_reverse)+"]")
                else:
                    print("["+",".join(array)+"]")
