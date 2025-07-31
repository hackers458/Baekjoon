def plus(a,b):
    x = int(a)
    y = int(b)
    sums.append(x+y)
time = int(input())
sums = []
while time>0:
    a,b = input().split()
    plus(a,b)
    time = time-1
for i in sums:
    print(i)