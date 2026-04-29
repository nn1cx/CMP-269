class PaymentMethod:
    totalTransactions = 0

    def __init__(self, accountHolder, balance):
        self.accountHolder = accountHolder
        self.balance = balance

    def incrementTotalTransactions(self):
        PaymentMethod.totalTransactions += 1

    #def validateAccount(self):
    #def processPayment(self, amount):

class CreditCard(PaymentMethod):
    def __init__(self, accountHolder, balance, creditLimit):
        super().__init__(accountHolder, balance)
        self.creditLimit = creditLimit

    def processPayment(self, amount):
        if amount > (self.balance + self.creditLimit):
            print("Transaction Declined")
        else:
            if amount > self.balance:
                remaining = amount - self.balance
                self.balance = 0
                self.creditLimit -= remaining
            else:
                self.balance -= amount
            super().incrementTotalTransactions()
            print(f"Transaction of ${amount} approved.")

    def getPaymentStatus(self):
        return f"Account Holder: {self.accountHolder}, Balance: {self.balance}, Credit Limit: {self.creditLimit}"

    def validateAccount(self):
        print(f"Validating credit card for {self.accountHolder}...")
        print("Credit Card Validated.")

class MealPlan(PaymentMethod):
    def __init__(self, accountHolder, balance):
        super().__init__(accountHolder, balance)

    def processPayment(self, amount):
        if amount > self.balance:
            print("Insufficient funds in meal plan account.")
        else:
            self.balance -= amount
            print(f"Transaction of ${amount} processed.")
            super().incrementTotalTransactions()

    def validateAccount(self):
        print(f"Meal plan for {self.accountHolder} is valid.") if self.balance > 0 else print(f"Insufficient funds in meal plan account.")

    def getPaymentStatus(self):
        return f"Account Holder: {self.accountHolder}, Meal Plan Balance: {self.balance}"

if __name__ == "__main__":
    paymentQueue = []
    paymentQueue.append(CreditCard("Alice", 500.0, 1000.0))
    paymentQueue.append(MealPlan("Alice", 300.0))

    for persons in paymentQueue:
        persons.processPayment(50.0)

    print(f"Total transactions: {PaymentMethod.totalTransactions}")
