student_list = []
stack = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
a = 28
while a>0:
  b = int(input())
  student_list.append(b)
  a = a-1
result = list(set(stack)-set(student_list))
result.sort()
print(result[0])
print(result[1])