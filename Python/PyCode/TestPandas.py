'''
Created on Apr 5, 2016

if there are import errors, just run it!

@author: Allen
'''
import numpy as np
import pandas as pd

obj = pd.Series([4, 7, -5, 3])

a = np.array(range(10), float)
a = a.reshape((5, 2))
np.seterr(all='ignore')

pi = np.pi

a = np.arange(15).reshape(3, 5)

# print(a)
# print(pi)
# print(np.e)
print(obj)
print(a)


