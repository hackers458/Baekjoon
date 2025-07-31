import sys
Time = int(input())
num1 = []
num2 = []
for i in range(Time):
  a,b = map(int, sys.stdin.readline().split())
  num1.append(a)
  num2.append(b)
for i in range(Time):
  print('Case #%d: %d + %d = %d'%(i+1,num1[i],num2[i],num1[i]+num2[i]))