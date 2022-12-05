##### 푸는 중 

# 문풀 
#인접행렬 만든 후 
#모든 노드에 대해 DFS => 최대 깊이 구하기 
#5 안넘을 경우 문제에서 제시한 친구 관계 없는 것으로 간주함 

# 인접 행렬 만들기 
nodeNum, edgeNum = map(int, input().split())
adjcList = [[]for _ in range(nodeNum)]
visited = [False for _ in range(nodeNum)]
depth = 0 
for _ in range(edgeNum):
    node1, node2 = map(int, input().split())
    adjcList[node1].append(node2)
    adjcList[node2].append(node1)

depth = 0 
print(adjcList)
#DFS(start)
    #방문 처리 
    #깊이 1회 추가 
    #start 인접 노드에 대하여 
        #방문안했으면 
            #DFS()

def DFS(start, depth):
    visited[start] = True 
    for neighbor in adjcList[start]:
        if not visited[neighbor]:
            DFS(neighbor, depth+1)
# 궁금증 : 1번 케이스 
    # 0-4-3-5 를 먼저 순회하면 
    # 0-4-7-3-5 를 가지 못하고 
    # 0-4-7-2만 갈 수 있게 됨 
    # 0-4-7-3-5를 우선적으로 순회하게 하는 방법? 
#오풀이 
    # depth를 전역변수로 선언 후 DFS 실행 때마다 ++연산 수행 시 
    # 깊이를 세는 것이 아니라 탐색한 횟수를 세게 되는 것과 동일함 

for node in range(nodeNum): 
    DFS(node, 0)
    print(f"{node}, {depth}")



#메인 
#모든 노드에 대하여 
    #depth = 0 
    #방문 안했으면 
        #DFS() 
