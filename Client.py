class Client: 
    
    def __init__(self, user, name, cel, mail, store, password, nOrders):
        self.user = user
        self.name = name
        self.cel = cel
        self.mail = mail
        self.store = store
        self.password = password
        self.nOrders = nOrders

    def getName (self):
        return self.name

    def getCel (self): 
        return self.cel

    def getMail (self):
        return self.mail

    def getStore (self):
        return self.store

    def getPassword (self):
        return self.password

    def newOrder (self):
        self.nOrders = self.nOrders + 1

    def getNumberOrders (self):
        return self.nOrders