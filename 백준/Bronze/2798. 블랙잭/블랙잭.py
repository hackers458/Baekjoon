N,M = map(int,input().split())
card_list = []
card_sum_list = []
card_list = list(map(int,input().split()))
card_list.sort()
a= 0
try:
    for i in range(0,N-2): # 가장 작은 카드 ~ 가장 큰 카드
        for j in range(i+1,N-1): # 두번째로 작은 카드 ~ 가장 큰 카드 -1
            for k in range(j+1,N): # 세번째로 작은 카드~ 가장 큰 카드 -2
                a = card_list[i]+card_list[j]+card_list[k]
                card_sum_list.append(a)
    card_sum_list.sort()
    for i in card_sum_list:
        if i <= M:
            a = i
    print(a)


except a<M:
    print("초과")