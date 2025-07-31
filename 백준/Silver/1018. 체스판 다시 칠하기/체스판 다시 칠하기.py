ideal1_chess = "BWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWB"
ideal2_chess = "WBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBW"


def right_chess(eight_chess):
    num_chess1 = 0
    num_chess2 = 0
    j = 0
    for i in eight_chess:
        if i == ideal1_chess[j]:  # 첫 번째의 경우
            j += 1
        else:
            num_chess1 += 1
            j += 1

    j = 0
    for i in eight_chess:
        if i == ideal2_chess[j]:  # 두 번째의 경우
            j += 1
        else:
            num_chess2 += 1
            j += 1
    if num_chess1 > num_chess2:
        return num_chess2
    else:
        return num_chess1


a = 0
b = 0
chess = []
eight_chess = ""
result_chess = []
N, M = map(int, input().split())  # 행 렬 초기화
j = 0

for i in range(N):  # 체스판 설정
    BW = input()  # 총 NxM 체스판을 배열로
    chess.append(BW)










while True:
    try:
        for a in range(0, M - 7):
            for b in range(0, N - 7):
                for i in range(b, b + 8):
                    eight_chess = eight_chess + chess[i][a:a + 8]
                result_chess.append(right_chess(eight_chess))
                eight_chess = ""
        result_chess.sort()
        print(result_chess[0])
        break

    except IndexError:
        break
