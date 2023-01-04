from queue import PriorityQueue
#짝수일 경우 
    #큐가 없어질때까지 
        #꺼내기
        #꺼내기
        #tmp = num1*num2
        #sum+=tmp
#홀수일 경우 
    #큐가 없어질때까지 
        #꺼내기
        #꺼낸 값이 0이 아닌 경우 
            #꺼내기
            #tmp = num1*num2
            #sum+=tmp
        #꺼낸 값이 0인 경우 
            #sum+=num1 

def showQueue():
    for _ in range(num):
        print(queue.get())

num = int(input())
queue = PriorityQueue()
sum =0 
for _ in range(num):
    queue.put(int(input()))
if queue.qsize() % 2 == 1:
    while not queue.empty():
        num1 = queue.get()
        num2 = queue.get() 
        tmp = num1+num2
        sum += tmp 
else:
    while not queue.empty():
        num1 = queue.get() 
        if(num1 == 0):
            sum+=num1
        else: 
            num2 = queue.get() 
            tmp = num1+num2
            sum += tmp 


print(sum)