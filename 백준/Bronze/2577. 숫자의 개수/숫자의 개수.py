num_list = []
A = int(input())
B = int(input())
C = int(input())
num = str(A*B*C)
for i in range(10):
  word_count = num.count(str(i))
  num_list.append(word_count)
for i in num_list:
  print(i)