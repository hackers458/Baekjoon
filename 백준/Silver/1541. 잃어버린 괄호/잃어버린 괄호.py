import sys
input = sys.stdin.readline

answer = input().strip()
minus_index = []
yaho = []
plus = []
sum1 = []
result = 0
x = 0
for i in answer:
    if i == "-":
        minus_index.append(x)
    x+=1
a = 0
if minus_index:
    while True:
        if minus_index[a] == minus_index[-1]:
            yaho.append(answer[minus_index[a] + 1:x])
            break
        else:
            yaho.append(answer[minus_index[a] + 1:minus_index[a + 1]])
        a += 1

    for i in yaho:
        sum1.append(list(map(int, i.split("+"))))
    for i in sum1:
        result -= sum(i)
    sum1 = []




if not minus_index:
    plus.append(answer)
else:
    plus.append(answer[0:minus_index[0]])


for i in plus:
    sum1.append(list(map(int, i.split("+"))))
for i in sum1:
    result += sum(i)
print(result)