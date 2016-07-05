'''
Created on Apr 5, 2016

@author: Allen
'''
import numpy as np

a = np.array(range(10), float)
a = a.reshape((5, 2))
np.seterr(all='ignore')

pi = np.pi

a = np.arange(15).reshape(3, 5)

print(a)

