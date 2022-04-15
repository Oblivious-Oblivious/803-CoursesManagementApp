package dbms.custom.src;

import java.util.HashMap;
import java.io.*;

public class CustomDB<T> {
    private HashMap<String, T> db = null;
    private String dbname;

    public CustomDB(String dbname) {
        this.db = new HashMap<String, T>();
        this.dbname = "dbms/custom/src/" + dbname;
        // try {
        //     File fd = new File(this.dbname);
        //     fd.createNewFile();
        // }
        // catch(IOException e) {
        //     e.printStackTrace();
        // }
    }

    public void add(String id, T item) {
        this.db.put(id, item);

        // try {
        //     FileOutputStream fdout = new FileOutputStream(this.dbname);
        //     ObjectOutputStream out = new ObjectOutputStream(fdout);
        //     out.writeObject(item);
        //     out.close();
        //     fdout.close();
        // }
        // catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    public T get(String id) {
        return this.db.get(id);
    }
    public HashMap<String, T> get_all_items() {
        return this.db;
    }
    public void update(String id, T item) {
        this.db.replace(id, item);
    }
    public boolean login(String username, String password) {
        LoginToken l = new LoginToken(username, password);
        for(T item : this.db.values()) {
            LoginToken current_token = (LoginToken)item;
            if(l.equals(current_token))
                return true;
        }

        return false;
    }
}