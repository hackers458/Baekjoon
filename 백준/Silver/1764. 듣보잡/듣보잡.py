import sys
input = sys.stdin.readline
N,M = map(int,input().strip().split())
N_list = []
for _ in range(N):
    N_list.append(input().strip())
result = []
for _ in range(M):
    result.append(input().strip())
N_list = set(N_list)
result = set(result)



wow = tuple(sorted(N_list.intersection(result)))
print(len(wow))
for j in wow:
    print(j)