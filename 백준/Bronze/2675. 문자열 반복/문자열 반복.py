def rep_word(R,S):
  a = len(S)
  temp_word = ''
  for i in S:
    temp_word = temp_word + i*R
  return temp_word
  


T = int(input())
Word_list = []


for i in range(T):
  R,S = input().split()
  R = int(R)
  Word_list.append(rep_word(R,S))


for i in Word_list:
  print(i)