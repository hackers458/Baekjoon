import sys
input = sys.stdin.readline
N = int(input().strip())
N_list= list(map(int,input().strip().split()))
N_list.sort()
coin_stack = [0]
cointime = 0
for j in N_list:
    cointime = cointime + j + sum(coin_stack)
    coin_stack.append(j)
print(cointime)