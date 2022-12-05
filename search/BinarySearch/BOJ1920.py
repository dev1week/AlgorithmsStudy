numData = int(input())
data = list(map(int, input().split()))
data.sort() 
queryNum = int(input())
queryData = list(map(int, input().split()))

print(data)

def BinarySearch(target):
    center = len(data) // 2
    left = 0
    right = len(data)
    while(True):

        if target == data[center]:
            return 1
        elif target > data[center]:
            left = center
            center = (right + left)//2
        elif target < data[center]:
            right = center
            center = (right + left)//2
        if (right<=center or center<=left):
            if target == data[center]:
                return 1 
            return 0 
    # while(true)
        # if target == data[center]:
            # return 1
        # elif target > data[center]:
            # 오른쪽으로 범위 변경
        # elif target < data[center]:
            # 왼쪽으로 범위 변경

for target in queryData:
    print(BinarySearch(target))