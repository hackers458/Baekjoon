import sys
N = int(input())
cm = []
kg = []
rank = []
for i in range(N):
   a,b = map(int, sys.stdin.readline().strip().split())
   cm.append(a)
   kg.append(b)
x=0
y=0
f=1
for a,b in zip(cm,kg):
    for c,d in zip(cm,kg):
        if a <c and b <d:
            if c>x and d<y:
                x = c
                y = d
                f+=1
            else:
                x = c
                y = d
                f += 1
        elif a == c and b == d:
            continue
        else:
            continue
    rank.append(f)
    x=0
    y=0
    f=1
for i in rank:
    print(i)
