package RevatureBank;

public interface Bank{

    float getBalance();

    void deposit(float dollars);

    void withdraw(float dollars);

    void transfer(float dollars);
}
