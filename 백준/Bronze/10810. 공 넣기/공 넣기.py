baguni = [] #바구니 생성
N,M = map(int,input().split()) # 바구니의 개수와 몇 줄에 걸쳐서 넣을지 설정 N,M


for i in range(N): # 바구니 초기화
  baguni.append(0)


def put_ball(i,j,k): # i번 바구니부터 j번 바구니까지 k번의 공넣기 
  for m in range(i-1,j): # i번부터 j번까지 공 넣는 반복문 
    baguni[m] = k # i번부터 j번까지 공 넣기


for i in range(M):
  i,j,k = map(int,input().split()) # 시작 바구니와 끝 바구니, k번의 공 설정
  put_ball(i,j,k) # 바구니 함수를 M번동안 실행

print(*baguni) # 각 바구니에 들어 있는 공 표시