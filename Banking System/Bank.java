import java.util.*;

public class Bank {

    private ArrayList<BankAccount> List = new ArrayList<>();
    Scanner inputScanner = new Scanner(System.in);

    public ArrayList<BankAccount> getAllAccount() {
        return List;
    }

    public int getTotal() {
        return List.size();
    }

    public BankAccount getItem(String S) {
        for (BankAccount BC : List) {
            if (BC.getAccountNumber().equals(S)) {
                return BC;
            }
        }
        return null;
    }

    public boolean addAccount(String accNumber, String accName) {
        for (BankAccount BC : List) {
            if (BC.getAccountNumber().equals(accNumber)) {
                return false;
            }
        }
        List.add(new BankAccount(accNumber, accName));
        return true;
    }

    public boolean depositMoney(String S, double Amount) {
        for (BankAccount BC : List) {
            if (BC.getAccountNumber().equals(S)) {
                if (BC.depositAmount(Amount)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean withdrawMoney(String S, double Amount) {
        for (BankAccount BC : List) {
            if (BC.getAccountNumber().equals(S)) {
                if (BC.withdrawAmount(Amount)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean removeAccount(String S) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getAccountNumber().equals(S)) {
                List.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayOptions() {
        int optionChosen;
        try {
            Thread.sleep(375);
        } catch (InterruptedException e) {
        }
        System.out.print(
                "\n1 - View All Accounts\n2 - Deposit Amount\n3 - Withdraw Amount\n4 - Delete Account\n5 - Add Account\n6 - Search For Account\n7 - Exit System\n\nSelect One Of The Following Options: ");
        try {
            Scanner mainInput = new Scanner(System.in);
            optionChosen = mainInput.nextInt();
            while (optionChosen > 7 || optionChosen < 1) {
                System.out.print("\nInvalid Option! Please Choose Again: ");
                optionChosen = mainInput.nextInt();
            }
            switch (optionChosen) {
                case 1:
                    displayAccounts();
                    break;
                case 2:
                    displayDeposit();
                    break;
                case 3:
                    displayWithdraw();
                    break;
                case 4:
                    displayDelete();
                    break;
                case 5:
                    displayAdd();
                    break;
                case 6:
                    displaySearch();
                    break;
                case 7:
                    System.out.println();
                    System.exit(0);
            }
        } catch (InputMismatchException e) {
            displayOptions();
        }

    }

    public void displayAccounts() {
        System.out.println("\n==== Displaying All Accounts ====\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        for (BankAccount BC : getAllAccount()) {
            System.out.println("=================================");
            System.out.println("Account Name: " + BC.getAccountName());
            System.out.println("Account Number: " + BC.getAccountNumber());
            System.out.println("Account Balance: £" + BC.getBalance());
            try {
                Thread.sleep(375);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("=================================");
        System.out.println("Total Number Of Accounts: " + getTotal());
        System.out.println("=================================");
        displayOptions();
    }

    public void displayDeposit() {
        try {
            System.out.print("\nEnter Acc. Number To Deposit To: ");
            inputScanner.nextLine();
            String accountToDepositTo = inputScanner.nextLine();
            System.out.print("Enter Amount To Deposit (In £): ");
            double amountToDeposit = inputScanner.nextDouble();
            BankAccount getAccount = getItem(accountToDepositTo.toUpperCase());
            double balanceBefore = getAccount.getBalance();
            Thread.sleep(375);
            if (getAccount.depositAmount(amountToDeposit)) {
                System.out.println("\n=================================\nDeposited Into Account: "
                        + accountToDepositTo.toUpperCase());
                System.out.println("=================================\nBalance Before: £" + balanceBefore
                        + "\nBalance After: £" + getAccount.getBalance() + "\n=================================");
            } else {
                System.out.println("\n=========================================\nFailed To Deposit £" + amountToDeposit
                        + " Into The Account " + accountToDepositTo.toUpperCase()
                        + "\n=========================================");
            }
        } catch (Exception e) {
            System.out.println(
                    "\n==========================================================\nError: No Account With This Acc. Number or Acc. Name Found\n==========================================================");
        }
        displayOptions();
    }

    public void displayWithdraw() {
        try {
            System.out.print("\nEnter Acc. Number To Withdraw From: ");
            inputScanner.nextLine();
            String accountToWithdrawFrom = inputScanner.nextLine();
            System.out.print("Enter Amount To Withdraw (In £): ");
            double amountToWithdraw = inputScanner.nextDouble();
            BankAccount getAccount = getItem(accountToWithdrawFrom.toUpperCase());
            double balanceBefore = getAccount.getBalance();
            Thread.sleep(375);
            if (getAccount.withdrawAmount(amountToWithdraw)) {
                System.out.println("\n=================================\nWithdrawn From Account: "
                        + accountToWithdrawFrom.toUpperCase());
                System.out.println("=================================\nBalance Before: £" + balanceBefore
                        + "\nBalance After: £" + getAccount.getBalance() + "\n=================================");
            } else {
                System.out.println("\n=========================================\nFailed To Withdraw £"
                        + amountToWithdraw + " From The Account " + accountToWithdrawFrom.toUpperCase()
                        + "\n=========================================");
            }
        } catch (Exception e) {
            System.out.println(
                    "\n==========================================================\nError: No Account With This Acc. Number or Acc. Name Found\n==========================================================");
        }
        displayOptions();
    }

    public void displayDelete() {
        try {
            System.out.print("\nEnter Acc. Number Of The Account To Delete: ");
            inputScanner.nextLine();
            String accountToDelete = inputScanner.nextLine();
            BankAccount getAccount = getItem(accountToDelete.toUpperCase());
            System.out.print(
                    "Are You Sure You Want To Delete The Account Of " + accountToDelete.toUpperCase() + " (Y/N)? ");
            char yesOrNo = inputScanner.next().charAt(0);
            if (yesOrNo == 'y' || yesOrNo == 'Y') {
                Thread.sleep(375);
                if (removeAccount(accountToDelete.toUpperCase())) {
                    System.out.println("\n=================================");
                    System.out.println("Deleted The Account Number: " + getAccount.getAccountNumber());
                    System.out.println("=================================");
                } else {
                    System.out.println("\n=========================================");
                    System.out.println("Failed To Delete The Account Number: " + getAccount.getAccountNumber());
                    System.out.println("=========================================");
                }
            }
        } catch (Exception e) {
            System.out.println(
                    "\n==========================================================\nError: No Account With This Acc. Number or Acc. Name Found\n==========================================================");
        }
        displayOptions();
    }

    public void displayAdd() {
        System.out.print("\nEnter Acc. Name Of The Account To Add: ");
        inputScanner.nextLine();
        String accountToAdd = inputScanner.nextLine();
        System.out
                .print("Are You Sure You Want To Add The Account With Name " + accountToAdd.toUpperCase() + " (Y/N)? ");
        char yesOrNo = inputScanner.next().charAt(0);
        if (yesOrNo == 'y' || yesOrNo == 'Y') {
            try {
                Thread.sleep(375);
                if (addAccount(generateAccountNumber(), accountToAdd.toUpperCase())) {
                    System.out.println("\n=================================");
                    System.out.println(
                            "Created New Account:\nAccount Number: " + List.get(getTotal() - 1).getAccountNumber()
                                    + "\nAccount Name: " + List.get(getTotal() - 1).getAccountName());
                    System.out.println("=================================");
                } else {
                    System.out.println("\n=========================================");
                    System.out.println("Failed To Create New Account For: " + accountToAdd.toUpperCase());
                    System.out.println("=========================================");
                }
            } catch (InterruptedException e) {
            }
        }
        displayOptions();
    }

    public void displaySearch() {
        try {
            System.out.print("\nEnter Acc. Number Of The Account To Find: ");
            inputScanner.nextLine();
            String accountToSearch = inputScanner.nextLine();
            BankAccount getAccount = getItem(accountToSearch.toUpperCase());
            Thread.sleep(375);
            System.out.println("\n=================================");
            System.out.println("Account Name: " + getAccount.getAccountName());
            System.out.println("Account Number: " + getAccount.getAccountNumber());
            System.out.println("Account Balance: £" + getAccount.getBalance());
            System.out.println("=================================");
        } catch (Exception e) {
            System.out.println(
                    "\n==========================================================\nError: No Account With This Acc. Number or Acc. Name Found\n==========================================================");
        }
        displayOptions();
    }

    public String generateAccountNumber() {
        String randomGenerator = "ABCDEFGHIJKLM01234NOPQRSTUVWXYZ56789";
        final int ACCOUNT_NUM_LENGTH = 4;
        StringBuilder stringBuilder = new StringBuilder();
        Random randomChar = new Random();
        for (int j = 0; j < ACCOUNT_NUM_LENGTH; j++) {
            stringBuilder.append(randomGenerator.charAt(randomChar.nextInt(randomGenerator.length())));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Bank Lloyds = new Bank();
        String[] customerNames = { "Amna Illian", "Ben Aaron", "Lance Young", "Joe Root", "Ali Hasan", "Sophie Clinch",
                "Jonathon Payne", "Ellyse Perry" };
        for (int i = 0; i < customerNames.length; i++) {
            Lloyds.addAccount(Lloyds.generateAccountNumber(), customerNames[i].toUpperCase());
        }
        System.out.println("\n=== Welcome To The Management Of The Banking System ===");
        Lloyds.displayOptions();
    }

}