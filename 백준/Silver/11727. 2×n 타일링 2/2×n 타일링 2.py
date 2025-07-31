import sys
input = sys.stdin.readline
N = int(input())
S = [0] * (1001)
S[1] = 1
S[2] = 3

for i in range(3,N+1):
    S[i] = S[i-1] + (S[i-2])*2
    S[i] = S[i] % 10007
print(S[N])