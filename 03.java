class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber,String accountHolder,double balance){
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	public void setAccountNumber(int accountNumber){
		this.accountNumber = accountNumber;
	}
	public void setAccountHolder(String accountHolder){
		this.accountHolder = accountHolder;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public String getAccountHolder(){
		return accountHolder;
	}
	public double getBalance(){
		return balance;
	}
	
	public void withdraw(double amount)throws Exception{
		if(balance >= amount){
			balance -= amount;
			System.out.println("Rs "+amount+" is been withdrawed from your account.");
			System.out.println("Current balance is Rs "+balance);
			
		}
		else{
			throw new Exception("Insufficient Balance!!");
		}
	}
}

class Bank{
	BankAccount[] account = new BankAccount[5];
	int accCounter=0;
	
	public void addBankAccount(int accountNumber,String accountHolder,double balance){
		account[accCounter] = new BankAccount(accountNumber,accountHolder,balance);
		accCounter++;
	}
	
	public void withdrawAmount(int accountNumber, double amount){
		for(int i=0; i<accCounter; i++){
			if(account[i].getAccountNumber() == accountNumber){
				try{
					account[i].withdraw(amount);
				}
				catch(Exception e){
					System.out.println("Exception is "+e.getMessage());
				}
			}
		}
	}
	
	public void displayDetails(){
		System.out.println("Account Number\tAccount Holder\t\tBalance");
		for(int i=0; i<accCounter; i++){
			System.out.println(account[i].getAccountNumber()+"\t\t"+account[i].getAccountHolder()+"\t\t\t"+account[i].getBalance());
		}
	}
}

class Main{
	public static void main(String[] args){
		Bank b1 = new Bank();
		b1.addBankAccount(1001,"Alice",5000.0);
		b1.addBankAccount(1002,"Bob",3000.0);
		b1.withdrawAmount(1001,6000.0);
		b1.withdrawAmount(1002,3000.0);
		b1.displayDetails();
	}
}
