import sys
from collections import deque


n,m = map(int,input().split())
square = []
dfs = deque()
zero_square = [[0 for k in range(m)] for i in range(n)]
visit = [[False for k in range(m)] for i in range(n)]
for _ in range(n):
    x = list(map(int,input().split()))
    if 2 in x:
        two_index = [_,x.index(2)] # 값이 2인 좌표이며 각각 y,x좌표이다.
    square.append(x)

visit[two_index[0]][two_index[1]] = True
dfs.append(two_index)
temp = deque()
num = 1

while True:
    if dfs:
        if dfs[0][0] !=n-1:
            if visit[dfs[0][0] + 1][dfs[0][1]] == False and square[dfs[0][0] + 1][dfs[0][1]] != 0:
                zero_square[dfs[0][0] + 1][dfs[0][1]] = num
                temp.append([dfs[0][0] + 1, dfs[0][1]])
                visit[dfs[0][0] + 1][dfs[0][1]] = True
        if dfs[0][0] !=0:
            if visit[dfs[0][0] - 1][dfs[0][1]] == False and square[dfs[0][0] - 1][dfs[0][1]] != 0:
                zero_square[dfs[0][0] - 1][dfs[0][1]] = num
                temp.append([dfs[0][0] - 1, dfs[0][1]])
                visit[dfs[0][0] - 1][dfs[0][1]] = True
        if dfs[0][1] != m-1:
            if visit[dfs[0][0]][dfs[0][1] + 1] == False and square[dfs[0][0]][dfs[0][1] + 1] != 0:
                zero_square[dfs[0][0]][dfs[0][1] + 1] = num
                temp.append([dfs[0][0], dfs[0][1] + 1])
                visit[dfs[0][0]][dfs[0][1] + 1] = True
        if dfs[0][1] != 0:
            if visit[dfs[0][0]][dfs[0][1] - 1] == False and square[dfs[0][0]][dfs[0][1] - 1] != 0:
                zero_square[dfs[0][0]][dfs[0][1] - 1] = num
                temp.append([dfs[0][0], dfs[0][1] - 1])
                visit[dfs[0][0]][dfs[0][1] - 1] = True
        dfs.popleft()
    else:
        dfs = temp
        temp = deque()
        num+=1
    if not dfs and not temp:
        break
for i in range(n):
    for j in range(m):
        if visit[i][j] == False and square[i][j] == 1:
            zero_square[i][j] = -1

for i in zero_square:
    for j in i:
        print(j,end=" ")
    print()