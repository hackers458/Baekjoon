import sys
from queue import PriorityQueue
input = sys.stdin.readline
N = int(input())


pq = PriorityQueue()

for i in range(N):
    a = int(input())
    if a!=0:
        pq.put((abs(a),a))
    else:
        if pq.empty() == True:
            print(0)
        else:
            print(pq.get()[1])