


# 트리의 지름은 노드 중 두 노드 사이의 거리가 가장 긴 것 

# BFS(노드) -> 끝까지의 길이 
    # not visited[노드]
        # 방문처리 
        # 큐에 넣기 
        # befoNode = 노드
    # while 큐 
        # for nodeInfo in adjcList[노드]
            # not visited nodeInfo[0] 
                # 방문처리 
                # 큐에 넣기
                # distance[nodeInfo[1]] =distance[befoNode] +nodeInfo[2] 
                # befoNode = nodeInfo[0]
from collections import deque
nodeNum = int(input())

adjcList = [[] for _ in range(nodeNum+1)]
visited =[False for _ in range(nodeNum+1)]
distance = [0 for _ in range(nodeNum+1)]

for _ in range(nodeNum):
    data = deque(map(int, input().split()))
    node = data.popleft()
    while data:
        if data[0] == -1:
            break
        adjcNode = data.popleft()
        weight = data.popleft()
        adjcList[node].append([adjcNode, weight])


def BFS(start):
    queue = deque()
    if not visited[start]:
        visited[start] = True 
        queue.append(start)
    while queue:
        current = queue.popleft()
        for nodeInfo in adjcList[current]:
            nextNode = int(nodeInfo[0])
            nodeDistance = int(nodeInfo[1])
            if not visited[nextNode]:
                visited[nextNode] = True
                queue.append(nextNode)
                distance[nextNode]=distance[current] + nodeDistance


BFS(1)
nextTarget = distance.index(max(distance))
visited =[False for _ in range(nodeNum+1)]
distance = [0 for _ in range(nodeNum+1)]
BFS(nextTarget)
print(max(distance))
# BFS(임의의 노드)
# distacne 최대값을 가지는 인덱스 반환 
# 인덱스에서 BFS 시작 
# distance 최대값 반환 