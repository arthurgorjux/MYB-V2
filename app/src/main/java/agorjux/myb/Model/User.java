package agorjux.myb.Model;

/**
 * Created by agorjux on 18/09/16.
 */
public class User {

    int id;
    String username;
    String mail;
    String name;

    public User(int id, String username, String mail, String name){
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.name = name;
    }
}
