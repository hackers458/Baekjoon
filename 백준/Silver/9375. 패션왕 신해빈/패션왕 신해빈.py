import sys
input = sys.stdin.readline
m  = int(input())
for i in range(m):
    n = int(input())
    cloth_list = [[] for i in range(31)]
    for j in range(n):
        a,b = input().split()
        for i in range(31):
            if not cloth_list[i]:
                cloth_list[i].append(b)
                cloth_list[i].append(a)
                break
            elif cloth_list[i][0] == b:
                cloth_list[i].append(a)
                break
            else:
                continue
    h = 1
    for i in range(31):
        if not cloth_list[i]:
            break
        else:
            h = h*len(cloth_list[i])
    h-=1
    print(h)