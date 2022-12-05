numData = int(input())
data = list(map(int, input().split()))

queryNum = int(input())
queryData = list(map(int, input().split()))


def BinarySearch(target):
    center = len(numData) // 2
    left = 0
    right = len(numData)
    while(left < center < right):
        if target == data[center]:
            return 1
        elif target > data[center]:
            left = center
            center = (right + left)//2
            pass
        elif target < data[center]:
            right = center
            center = (right + left)//2
    # while(true)
        # if target == data[center]:
            # return 1
        # elif target > data[center]:
            # 오른쪽으로 범위 변경
        # elif target < data[center]:
            # 왼쪽으로 범위 변경

for target in queryData:
    BinarySearch(target)