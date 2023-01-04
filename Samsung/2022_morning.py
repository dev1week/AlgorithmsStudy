NM = 25
DICE_MAP = [] 
DIRECTIONS = [[1,0], [0,1],[-1,0],[0,-1]]
visit = [[0 for _ in range(NM)] for _ in range(NM)]
points = [[0 for _ in range(NM)] for _ in range(NM)]
global groupCount 
groupCount = 0 

class Dice:
    def __init__(self):
        self.x = 0
        self.y =0
        self.num[6] =[]
        self.dir =0
        
    def get_bottom(self):
        pass
    def move():
        pass

def create_map():
    for _ in range(n):
        DICE_MAP.append([])
    for _ in range(n):
        DICE_MAP[_]=(list(map(int, input().split())))

# 점수를 기록 
def dfs(x,y,point, visit_flag):
    visit[x][y]= visit_flag
    points[x][y] = point
    global groupCount 
    groupCount +=1 
    for dir in DIRECTIONS:
        tmp_x = x + dir[0]
        tmp_y = y + dir[1]
        if(0<tmp_x<n and 0<tmp_y<n):
            if(not visit[tmp_x][tmp_y]==visit_flag):
                if(DICE_MAP[tmp_x][tmp_y] == DICE_MAP[x][y]):
                    dfs(tmp_x, tmp_y, point, visit_flag)

def pro():
    # 점수맵 그리기 
    for i in range(n):
        for j in range(n):
            #점수맵을 계산한 적 있다면 넘어감 
            if points[i][j] ==0 : 
                groupCount  =0
                #dfs(x,y,point, visit_flag)
                #인접한 칸의 개수 세기 
                dfs(i, j, 0,1)
                #점수 구하기 
                dfs(i,j,groupCount*DICE_MAP[i][j], 2)


if __name__ =="__main__":
    n, m = map(int, input().split())
    create_map()
    pro()
    print(points)



