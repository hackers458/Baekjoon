import sys
# 입출력 값이 많기 때문에 시간초과를 방지하기 위해 설정
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
count = [0 for _ in range(10001)]

for _ in range(N):
    n = int(input())
    count[n] += 1	# 입력받은 자연수에 해당하는 배열값을 +1 해준다

for i in range(1, 10001):
    for j in range(count[i]):	# count[i]의 값만큼 출력 반복
        print(str(i))
        print("\n")