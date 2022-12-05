from collections import deque 
n,m = map(int, input().split())

map = [] 

visited = [[False for _ in range(m)] for _ in range(n)]

for _ in range(n):
    map.append(list(input()))

depth = [[0 for _ in range(m)]for _ in range(n)]
#def BFF(startY, startX):
    # 1이면서 not visited 일 경우 
        # 큐에 넣기 
        # visited 처리 
    # 큐가 있는 동안 
        # 큐 가져오기 cuurent 
        #current의 상하좌우
            # 도착 지점이면 
                # count 값 반환 
            # 1이면서 not visited  큐에 넣기 
dx = [-1, 1, 0, 0]
dy = [0,0,1,-1]

def BFS(startY, startX):
    queue = deque() 
    count = 0 
    if map[startY][startX] == "1" and not visited[startY][startX]:
        queue.append([startY,startX])
        visited[startY][startX] = True 
        depth[startY][startX] = 1 
    while queue:
        current = queue.popleft() 
        currentY = current[0]
        currentX = current[1]
        for _ in range(4):
            x = currentX + dx[_]
            y = currentY + dy[_]
            if x == m-1 and y == n-1:
                depth[y][x] = depth[currentY][currentX]+1
                return
            elif 0<=x<=m-1 and 0<=y<=n-1:
                if not visited[y][x] and map[y][x]=="1" :
                    queue.append([y,x]) 
                    visited[y][x] =True
                    depth[y][x] = depth[currentY][currentX]+1


BFS(0,0)
print(depth[n-1][m-1])