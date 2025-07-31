T_size = []
T_result = []
N = int(input()) # 참여한 인원 수
T_size = list(map(int,input().split())) # 참여한 인원들의 필요한 사이즈 수
T,P = map(int,input().split()) #T와 P는 각각 티셔츠와 펜이 몇 묶음이 있는지 알려줌



for i in T_size:
  a,b = divmod(i,T)
  if i==0:
    T_result.append(0)
  elif i%T==0:
    T_result.append(a)
  else:
    T_result.append(a+1)


T_result = sum(T_result)

a,b = divmod(N,P)
print(T_result)
print(a,b)
