import sys,copy

input = sys.stdin.readline

N = int(input())

Q = []

for _ in range(N) :
    power, weigh = map(int,input().split())
    Q.append([power,weigh])


maxi = cnt = 0 
def backtracks(i,arr,cnt) :
    global maxi

    if i == N : 
        
        maxi = max(maxi,cnt)
        return
    if arr[i][0] <= 0 :
        backtracks(i+1,arr,cnt)

    for j in range(N) :
        res = 0
        if (i == 0 and i != j) or (j != i and arr[i][0] >0 and arr[j][0] > 0)  :
            arr[i][0] = arr[i][0] - arr[j][1]
            arr[j][0] = arr[j][0] - arr[i][1]
            if arr[i][0] <= 0 :
                res+=1
            if arr[j][0] <= 0 :
                res +=1
            backtracks(i+1,arr,cnt+res)
            arr[i][0] = arr[i][0] + arr[j][1]
            arr[j][0] = arr[j][0] + arr[i][1]
        else :
            if not (i==0 and j ==0) :
                backtracks(i+1,arr,cnt)

backtracks(0,Q,0)

print(maxi)