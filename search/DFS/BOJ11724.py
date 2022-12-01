def DFS(start):
    visited[start] = True 
    for neighbor in adjcList[start]:
        if not visited[neighbor]:
            DFS(neighbor)


nodeNum, edgeNum = map(int,input().split())
adjcList = [[]for _ in range(nodeNum+1)]  
visited = [False for _ in range(nodeNum+1)]
for idx in range(edgeNum):
    node1, node2 = map(int,input().split())
    adjcList[node1].append(node2)
    adjcList[node2].append(node1)

count =0 
for node in range(1,nodeNum):
    if not visited[node]:
        DFS(node)
        count +=1 

print(count)