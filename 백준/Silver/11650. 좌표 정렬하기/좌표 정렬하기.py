import sys
N = int(input())
dot_list = []
for i in range(N):
    dot_list.append(list(map(int,sys.stdin.readline().strip().split())))
a = sorted(dot_list)
for j in a:
    print(*j)