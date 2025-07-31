import sys
from collections import deque
input = sys.stdin.readline
m  = int(input())
n = int(input())
pq = deque()
com_stack = [[] for i in range(m+1)]
check = [False]*(m+1)

for _ in range(n):
    a,b = map(int,input().split())
    com_stack[a].append(b)
    com_stack[b].append(a)

virus = 0

pq.append(1)
while True:
    check[pq[0]] = True
    for i in com_stack[pq[0]]:
        if check[pq[0]] == True and check[i] == True:
            continue
        else:
            pq.append(i)
            check[i] = True
    virus+=1
    pq.popleft()
    if not pq:
        break
print(virus-1)

