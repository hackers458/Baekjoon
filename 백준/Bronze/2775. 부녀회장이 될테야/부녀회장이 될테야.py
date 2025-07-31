aprt_next = []
aprt_under = []
sum = 0

def apart(aprt_under,n): #k-1층까지 인원들을 구함
    global sum
    global aprt_next
    for i in range(0,n):
        sum=sum+aprt_under[i]
        aprt_next.append(sum)
    aprt_under = aprt_next
    aprt_next = []
    sum = 0
    return aprt_under












T = int(input())


for i in range(T):
    k = int(input()) #k는 층 1,1,3
    n = int(input()) #n은 호
    aprt_under = []
    for i in range(0, n):  # 0층 1~n호까지 초기화
        aprt_under.append(i+1)
    for i in range(k):
        aprt_under = apart(aprt_under,n)
    print(aprt_under[n-1])