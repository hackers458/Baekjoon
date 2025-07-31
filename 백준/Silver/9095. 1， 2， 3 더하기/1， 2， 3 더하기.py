import sys
input = sys.stdin.readline
m  = int(input())
def num_count(a):

    if a == 1:
        return 1
    elif a == 2:
        return 2
    elif a == 3:
        return 4
    else:
        D[1] = 1
        D[2] = 2
        D[3] = 4
        for i in range(4, a + 1):
            D[i] = D[i - 1] + D[i - 2] + D[i - 3]
        return D[a]
for _ in range(m):
    a = int(input())
    D = [0] * (a + 1)
    x = num_count(a)
    print(x)
