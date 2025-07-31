def AZword(word):
  a = len(word)
  temp = word[0] + word[a-1]
  return temp


T = int(input())
result = []

for i in range(T):
  word = input()
  result.append(AZword(word))

for i in result:
  print(i)