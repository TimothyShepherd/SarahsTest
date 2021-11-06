package RevatureBank;

public class SavingsAccount implements Bank{

    float balance;

    @Override
    public float getBalance(){
        return 0;
    }

    @Override
    public void deposit(float dollars){
        balance += dollars;
    }

    @Override
    public void withdraw(float dollars){
        balance -= dollars;
    }

    @Override
    public void transfer(float dollars){
        balance -= dollars;
    }
}
