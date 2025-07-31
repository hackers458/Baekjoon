import sys
import math
input = sys.stdin.readline

N,M = map(int,input().split())
Floyd_Warshall = [[55555555 for i in range(N+1)] for j in range(N+1)] # 큰 수로 초기화
for i in range(0,N+1):
    Floyd_Warshall[i][i] = 0
for _ in range(M):
    a,b = map(int,input().split())
    Floyd_Warshall[a][b] = min(Floyd_Warshall[a][b],1)
    Floyd_Warshall[b][a] = min(Floyd_Warshall[b][a],1)# 연결
for i in range(1,N+1): # 플루이드 워셜
    for j in range(1,N+1):
        for k in range(1,N+1):
            Floyd_Warshall[j][k] = min(Floyd_Warshall[j][k],Floyd_Warshall[j][i] + Floyd_Warshall[i][k])
b = 55555
answer = 0
for i in range(1,N+1):
    a = 0
    for j in range(1,N+1):
        if Floyd_Warshall[j][i] != 55555555 and Floyd_Warshall[j][i] !=0:
            a += Floyd_Warshall[j][i]
    if a < b:
        b = a
        answer = i
print(answer)


