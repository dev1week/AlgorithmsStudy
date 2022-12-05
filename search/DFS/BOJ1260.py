from collections import deque

nodeNum, edgeNum, start = map(int, input().split())
visited =[False for _ in range(nodeNum+1)]
graph = [[]for _ in range(nodeNum+1)]

def BFS(start):
    queue = deque()
    queue.append(start)
    visited[start] = True 
    while queue: 
        current = queue.popleft()
        
        print(current)
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)

for _ in range(edgeNum):
    node1, node2 = map(int,input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

BFS(start)
