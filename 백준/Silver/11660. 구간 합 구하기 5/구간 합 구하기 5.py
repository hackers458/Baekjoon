import sys
input = sys.stdin.readline

N,M = map(int,input().strip().split())
A = [[0]*(N+1)]
D = [[0]*(N+1) for _ in range(N+1)]

for i in range(N):
    A_row = [0] + [int(x) for x in input().split()]
    A.append(A_row)
for j in range(1,N+1):
    for k in range(1,N+1):
        D[j][k] = D[j-1][k] + D[j][k-1] - D[j-1][k-1] + A[j][k]


for k in range(M):
    x1,y1,x2,y2 = map(int,input().split())
    result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
    print(result)