import sys
from collections import deque
input = sys.stdin.readline
M,N,H = map(int,input().split())
tomato_top = []
dx =[0,1,-1,0]
dy =[1,0,0,-1]
dh =[-1,1]
tomato_visit = [[[False for i in range(M)] for j in range(N)]for k in range(H)]
tomato_deque = deque()
for i in range(H):
    tmp_tomato = []
    for j in range(N):
        tmp = list(map(int,input().split()))
        for k in range(M):
            if tmp[k] == 1:
                tomato_deque.append([i,j,k])
                tomato_visit[i][j][k] = True
        tmp_tomato.append(tmp)
    tomato_top.append(tmp_tomato)
result = 0
while True:
    tmp_deque = deque()
    for t in tomato_deque: # h,y,x
        for i in range(4):
            if 0<=t[1]+dy[i]<=N-1 and 0<=t[2]+dx[i] <=M-1:
                y = t[1]+dy[i]
                x = t[2]+dx[i]
                if tomato_top[t[0]][y][x] == 0 and tomato_visit[t[0]][y][x] == False:
                    tomato_top[t[0]][y][x] =1
                    tomato_visit[t[0]][y][x] = True
                    tmp_deque.append([t[0],y,x])
        for j in range(2):
            if 0<=t[0]+dh[j]<=H-1:
                h = t[0]+dh[j]
                if tomato_top[h][t[1]][t[2]] == 0 and tomato_visit[h][t[1]][t[2]] == False:
                    tomato_top[h][t[1]][t[2]] = 1
                    tomato_visit[h][t[1]][t[2]] = True
                    tmp_deque.append([h,t[1],t[2]])
    tomato_deque = tmp_deque
    if not tomato_deque and not tmp_deque:
        break
    else:
        result +=1
for i in tomato_top:
    for j in i:
        for k in j:
            if k == 0:
                result = -1
                break
print(result)


