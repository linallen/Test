# TODO: Add comment
# 
# Author: Allen
###############################################################################

#install.packages(kernlab)

library(kernlab)

data = matrix(0,nrow=4,ncol=4)

data[1,1]=2
data[1,2]=1

data[2,1]=1
data[2,2]=2

data[3,3]=2
data[3,4]=1

data[4,3]=1
data[4,4]=2

#sc <- specc(data, centers=2)
#plot(data, col=sc, pch=4)            # estimated classes (x)
#points(data, col=obj$classes, pch=5) # true classes (<>)

