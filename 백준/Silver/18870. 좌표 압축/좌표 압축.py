import sys
input = sys.stdin.readline
N = int(input())
num1 = list(map(int,input().split()))
num = sorted(num1)
num_dict = {}
result= [0] * (N+1)
result [0] = 0
num_dict[num[0]] = 0
a = 0
for i in range(1,N):
    if num[i] == num[i-1]:
        num_dict[num[i]] = a
    else:
        a+=1
        num_dict[num[i]] = a
for i in num1:
    print(num_dict[i],end=" ")
