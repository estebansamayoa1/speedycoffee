
class Coffee: 

    def __init__ (self, kind, sugar, milk, extra):
        self.kind = kind
        self.sugar = sugar
        self.milk = milk
        self.extra = extra

    def getKind (self): 
        return self.kind

    def getSugar (self):
        return self.sugar

    def getMilk (self):
        return self.milk

    def getExtra (self):
        return self.extra