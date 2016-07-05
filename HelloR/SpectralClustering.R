## Cluster the spirals data set.

#install.packages(kernlab)

library(kernlab)

data = matrix(1:100,nrow=10)

data[1,1]


sc <- specc(data, centers=2)
plot(data, col=sc, pch=4)            # estimated classes (x)
#points(data, col=obj$classes, pch=5) # true classes (<>)

