import sys
input = sys.stdin.readline
import math

T = int(input())

for _ in range(T):
    n = int(input())
    nums = []

    for i in range(n+1):
        for j in range(n+1):
            for k in range(n+1):
                if 1*i+2*j+3*k == n:
                    nums.append([i,j,k])
                    break
                if 1*i+2*j+3*k > n:
                    break
    
    real = 0
    
    for s in range(len(nums)):
        real += math.factorial(nums[s][0]+nums[s][1]+nums[s][2])/(math.factorial(nums[s][0])*math.factorial(nums[s][1])*math.factorial(nums[s][2]))

    print(int(real))