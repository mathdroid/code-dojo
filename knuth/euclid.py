#Muhammad Mustadi
#Euclid Algorithm
#p25
import math
print ('Find GCD between two integers!')
m = int(raw_input('Insert M (integer 1): '))

n = int(raw_input('Insert N (integer 2): '))

r=-1

while r!=0:
    r = m % n
    if r==0:
        print('GCD is ' + str(n))
    else:
        m=n
        n=r
