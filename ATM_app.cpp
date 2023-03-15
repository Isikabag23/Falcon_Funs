#include<iostream>
using namespace std;
void showMenu()
{
    std::cout << "********** MENU **********" << std::endl;
    std::cout << "1.Check BankBalance  " << std::endl;
    std::cout << "2.Deposite Amount :" << std::endl;
    std::cout << "3.Withdraw Amount : " << std::endl;
    std::cout << "4.--EXIT--" << std::endl;
    std::cout << "------------------------------------" << std::endl;
    
}
int main()
{
    //Check balance ,Deposite,witdrawl
    int option;
    double balance =1000;
    do {
    
    showMenu();
    std::cout << "Choose your option : " << std::endl;
    std::cin >> option;
    //system("cls");
    
    //using switch-break case
    switch (option)
    {
        case 1 : std::cout << "Current BankBalance is  " << balance <<  std::endl;
        case 2 : std::cout << "Enter the Amount you want to Deposite : " << std::endl;
        double depositeamount ;
        std::cin >> depositeamount;
        balance+=depositeamount;
        break;
        case 3  : std::cout << "Enter the Amount  you want to Withdraw : " << std::endl;
        double withdrawAmount ;
        std::cin >> withdrawAmount;
        if (withdrawAmount <= balance)
        balance-=withdrawAmount;
        else
        {
            std::cout << "Not Enough Money in your bank " << std::endl;
            break;
        }
        
    }
    }
    while (option!=4);
    return 0;
}