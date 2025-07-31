while True:
  triangle = list(map(int,input().split())) #a는 밑변 b는 높이 c는 빗변이라고 가정
  triangle.sort(reverse=True) # 오름차순으로 정리
  if triangle[0] == 0:
    break
  elif triangle[0]**2 == triangle[1]**2 + triangle[2]**2:
    print("right")
  else:
    print("wrong")