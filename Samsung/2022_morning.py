NM = 25
DICE_MAP = [] 
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
    n, m = map(int, input().split())
    for _ in range(n):
        DICE_MAP.append([])
    for _ in range(n):
        DICE_MAP[_]=(list(map(int, input().split())))

if __name__ =="__main__":
    create_map()
    print(DICE_MAP)