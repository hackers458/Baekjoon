def coordinate(x,y):
    if x*y>0:
        if x>0:
            print('1')
        else:
            print('3')
    else:
        if x>y:
            print('4')
        else:
            print('2')
        

a = input()
b = input()
x = int(a)
y = int(b)


coordinate(x,y)