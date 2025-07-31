import sys
N = int(input())
num_list = [0]*31


def banolim(i):
    if i - int(i) >= 0.5:
        return int(i)+1
    else:
        return int(i)
if N == 0:
    print(0)
else:
    num_expect = banolim((N / 100) * 15)
    for _ in range(0, N):
        a = int(sys.stdin.readline())
        num_list[a] +=1
    a = 0
    for i in range(1,num_expect*2+1):
            if i > num_expect:
                if i == num_expect+1:
                    a = 30
                while True:
                    if num_list[a] == 0:
                        a -=1
                    else:
                        break
                num_list[a] -=1
            else:
                while True:
                    if num_list[a] == 0:
                        a +=1
                    else:
                        break
                num_list[a] -=1
    x = 0
    for j in range(1,31):
        x = x+ j*num_list[j]
    print(banolim(x/sum(num_list)))

