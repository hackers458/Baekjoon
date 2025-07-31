a = 1
b = 1
stack = []
while(True):
    a,b = map(int, input().split())
    stack.append(a+b)
    if a == b == 0:
        stack.pop()
        break
for i in stack:
    print(i)