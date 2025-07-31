N = int(input())
subject = list(map(int,input().split()))
subject.sort()
print((sum(subject)/subject[N-1]*100/N))