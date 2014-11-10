#Muhammad Mustadi
#Euclid Algorithm
#p25

m = raw_input('Insert M: ')

n = raw_input('Insert N: ')

r=-1

while r!=0:
    r = m % n
    if r==0:
        print('GCD is' + str(n))
    else:
        m=n
        n=r
