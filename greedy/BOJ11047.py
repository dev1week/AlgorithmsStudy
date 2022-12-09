numCoin, target = map(int, input().split())
coins = []

for _ in range(numCoin):
    coins.append(int(input()))

coins.sort(reverse=True)
count = 0 
for coin in coins:

    while target>=coin:
        target -= coin 
        count +=1 
        # target -= coin 
        # count += 
    if target == 0:
        print(count)
        break 

