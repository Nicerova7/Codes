x = []
b = []

def countdiv(n, a):
    global x
    if(n%a == 0):
        x.append(a)
    if(n == a):
        return None
    countdiv(n,a+1)

def dividers(n):
    if(n == 0):
        return None
    countdiv(n,1)

def isPrime(n,i=2):
    if(n == 1):
        return False
    if(n == 2):
        return True
    if(n%i == 0):
        return False
    if(i*i > n):
        return True
    return isPrime(n,i+1)
    
def bool(i):
    global x
    global b
    if(i == len(x)):
        return None
    else:
        if(isPrime(x[i])):
            b[i] = True
        else:
            b[i] = False
        bool(i+1)

def accum(s):
    global x
    if(s == len(x)):
        return 0
    else:
        if(isPrime(x[s])):
            return x[s]+accum(s+1)
        else:
            return accum(s+1)

def funcion(n):
    global x
    global b
    if(n == 0):
        print( "End" )
        return None
    else:
        dividers(n) # Find dividers 
        print(x)   
        b = [True]*len(x) # 
        bool(0)
        sumprimes = accum(0)
        x = []
        b = []
        funcion(n-sumprimes) #3) again but less prime numbers
     
funcion(12) # example with 12








    
