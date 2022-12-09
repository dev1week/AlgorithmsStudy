from queue import PriorityQueue

cardList = PriorityQueue() 


cardNum = int(input())
for _ in range(cardNum):
    cardList.put(int(input()))


#우선순위 큐가 하나 남을 때까지
    #첫번째값 꺼내기 
    #두번째값 꺼내기 
    # 두개 더해서 다시 큐에 넣기 

result = 0 
while (cardList.qsize()>1):
    num1 = cardList.get()
    num2 = cardList.get() 
    sum = num1+num2
    result += sum 
    cardList.put(sum)


print(result)



