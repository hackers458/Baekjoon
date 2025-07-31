global sum
sum = 0
def money(a,b):
  global sum
  a = int(a)
  b = int(b)
  sum = sum + a*b

cost = int(input())
time = int(input())
for i in range(time):
  a,b = input().split()
  money(a,b)
if sum == cost:
  print('Yes')
else:
  print('No')
  