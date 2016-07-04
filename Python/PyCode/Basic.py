'''
Created on 4 Jul 2016

@author: Allen
'''

def add(a,b):
    return a+b

def addFixedValue(a):
    y = 5
    return y + a
  
print(add(1,2))
print(addFixedValue(1)) 

i = 1
for i in range(1, 10):
    if i <= 5 :
        print(i, 'is smaller or equal then 5.\n'),
    else:
        print(i, 'is larger then 5.\n'), 

import sys
print(sys.version)