#도시 x로 부터 출발해 최단거리가 k인 모든 도시의 번호 출력 

def createGraph():
    cityMap = [[] for _ in range(nodeNum+1)]
    for _ in range(edgeNum):
        idx, value = map(int, input().split())
        cityMap[idx].append(value)  
    return cityMap 
if __name__ == "__main__":
    nodeNum, edgeNum, length, start = map(int, input().split())
    cityMap = createGraph() 
    
    