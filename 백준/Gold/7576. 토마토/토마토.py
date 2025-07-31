import sys
from collections import deque
input = sys.stdin.readline

M,N = map(int,input().split()) #가로 세로
dx = [-1,1,0,0]
dy = [0,0,1,-1]
tomato_que = deque()
temp = deque()

tomato = []

for i in range(0,N):
    a = list(map(int,input().split()))
    for j in range(0,M):
        if a[j] == 1:
            tomato_que.append([i,j]) # y x
    tomato.append(a)

date = 0
while True:
    if not tomato_que and not temp:
        break
    else:
        date+=1
        temp = deque()
        for i in tomato_que:
            for j in range(4):
                if i[1] + dx[j] >= 0 and i[1] + dx[j] <= M - 1 and i[0] + dy[j] >= 0 and i[0] + dy[j] <= N - 1:
                    if tomato[i[0] + dy[j]][i[1] + dx[j]] == 0:
                        temp.append([i[0] + dy[j], i[1] + dx[j]])
                        tomato[i[0] + dy[j]][i[1] + dx[j]] = date
        tomato_que = temp
x = 0
for i in tomato:
    if 0 in i:
        x= 1
if x == 1:
    print(-1)
else:
    print(date-1)


