public class BankAccount 
{

    private String accountNumber;
    private String accountName;
    private double Balance;
    
    BankAccount(String accNumber, String accName)
    {
        accountNumber = accNumber;
        accountName = accName;
        Balance = 0;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public double getBalance()
    {
        return Balance;
    }

    public boolean depositAmount(double Amount)
    {
        double currentBalance = Balance;
        Balance += Amount;
        if(Balance != currentBalance)
        {
            return true;
        }
        return false;
    }

    public boolean withdrawAmount(double Amount)
    {
        if((Balance - Amount) < 0)
        {
            return false;
        }
        double currentBalance = Balance;
        Balance -= Amount;
        if(Balance != currentBalance)
        {
            return true;
        }
        return false;
    }

}