import sys

input = sys.stdin.readline


N,M = map(int,input().split())

adj = [[] for _ in range(N+1)]

for _ in range(N-1) :
    a,b,cost = map(int,input().split()) 
    adj[a].append((b,cost))
    adj[b].append((a,cost))


def dfs(i,b,cnt) :
    if i == b : 
        print(cnt)
        return cnt

    for j,cost in adj[i] :
        if not visited[j] :
            visited[i] = True
            dfs(j,b,cnt+cost)
            visited[i] = False
    return

for _ in range(M) :
    a,b = map(int,input().split())
    cnt = 0
    visited=[False]*(N+1)
    dfs(a,b,0)