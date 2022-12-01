#DFS
#자릿수 같은지 확인 
    #현재 수 출력
#else 
    #1,3,5,7,9에 대해서 반복 
        # 숫자*10+idx가 소수  
            #DFS(숫자*10+idx)
N = int(input())            
def DFS(number):
    if numLen(number) == N:
        print(number)
        return 
    else: 
        for i in [1,3,5,7,9]:
            if isPrime(number*10+i):
                DFS(number*10+i)
# IsPrime(숫자):
    #for 1~숫자//2 
        #if 숫자 % idx == 0 
            #return False 
    #return True 

def isPrime(number):
    if number == 0:
        return False
    if number == 1:
        return False
    for i in range(2, number//2):
        if number%i == 0 :
            return False 
    return True 

def numLen(number):
    return len(str(number))

for _ in [2,3,5,7]:
    DFS(_)