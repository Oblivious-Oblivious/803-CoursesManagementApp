package dbms.custom.src;

import java.util.ArrayList;

import app.src.entities.Schema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class CustomDB {
    private ArrayList<Schema> db = null;
    private String dbname;

    private void read_db_file() {
        try {
            this.db = new ArrayList<Schema>();
            FileInputStream fd = new FileInputStream(this.dbname);
            ObjectInputStream in = new ObjectInputStream(fd);
            this.db = (ArrayList)in.readObject();
            in.close();
            fd.close();
        }
        catch(IOException e) {}
        catch(ClassNotFoundException e) {}
    }

    private void write_db_file() {
        try {
            FileOutputStream fd = new FileOutputStream(this.dbname);
            ObjectOutputStream out = new ObjectOutputStream(fd);
            out.writeObject(this.db);
            out.close();
            fd.close();
        }
        catch(IOException e) {}
    }

    public CustomDB(String dbname) {
        this.db = new ArrayList<Schema>();
        this.dbname = "dbms/custom/src/" + dbname + ".db";
        
        try {
            FileOutputStream fd = new FileOutputStream(this.dbname);
            fd.close();
        }
        catch(IOException e) {}
    }

    public void save(Schema item) {
        this.db.add(item);
        write_db_file();
    }

    public Schema get_by_id(String id) {
        read_db_file();

        for(Schema item : this.db)
            if(item.get_id().equals(id))
                return item;
        return null;
    }

    public ArrayList<Schema> get_all_items() {
        read_db_file();

        return this.db;
    }

    public void update(String id, Schema new_item) {
        read_db_file();

        for(int i = 0; i < this.db.size(); i++)
            if(this.db.get(i).get_id().equals(id))
                this.db.set(i, new_item);

        write_db_file();
    }
}
