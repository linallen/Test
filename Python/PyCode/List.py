class Point:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    def __str__(self):
        return "x = " + str(self.x) + " y = " + str(self.y)
    def __add__(self,other):
        p = Point()
        p.x = self.x+other.x
        p.y = self.y+other.y
        return p
    def show(self):
        print("hello?")
    def lower(self,txt):
        return txt.lower()
        
p1 = Point(3,4)
p2 = Point(2,3)
print(p1)
print(p1.y)
print(p1+p2) 
p1.show()
print(p1.lower("GOOD"))