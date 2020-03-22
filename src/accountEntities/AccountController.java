package accountEntities;

import java.util.ArrayList;

import accountEntities.Account;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class AccountController {

    private ArrayList<Account> accountArrayList;


    public AccountController() {

        Account accountAdmin1 = new Account("admin1", "12345", true);
        Account accountAdmin2 = new Account("admin2", "123456", true);

        Account accountUser1 = new Account("user1", "123", false);
        Account accountUser2 = new Account("user2", "1234", false);

        accountArrayList = new ArrayList<>();
        accountArrayList.add(accountAdmin1);
        accountArrayList.add(accountAdmin2);
        accountArrayList.add(accountUser1);
        accountArrayList.add(accountUser2);

    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }

    public Multimap<String, String> getAccountsUsernamesWithPasswords(){
        Multimap<String, String> usernamePasswordList = ArrayListMultimap.create();
        for (Account account : accountArrayList) {
            usernamePasswordList.put(account.getName(),account.getPassword());
            }
        return usernamePasswordList;
    }

    public Multimap getIfAdmin(){
        Multimap<String, Boolean> adminCheck = ArrayListMultimap.create();
        for (Account account : accountArrayList){
            adminCheck.put(account.getName(), account.isAdmin());
        }
        return  adminCheck;
    }

    public boolean checkUsername(String username){
        return getAccountsUsernamesWithPasswords().containsKey(username);
    }
    public boolean checkPassword(String username, String password) {return getAccountsUsernamesWithPasswords().containsEntry(username, password);}
    public boolean checkIfAdmin(String username){return getIfAdmin().containsEntry(username, true);}
}
