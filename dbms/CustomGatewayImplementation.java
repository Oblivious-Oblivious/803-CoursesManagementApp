package dbms;

import java.util.ArrayList;

import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

import dbms.custom.src.CustomDB;

public class CustomGatewayImplementation implements DBMSGateway {
    private CustomDB db;

    public CustomGatewayImplementation(String dbname) {
        this.db = new CustomDB(dbname);
    }

    @Override
    public void save(Schema item) {
        this.db.save(item);
    }

    @Override
    public Schema get_by_id(String id) {
        return this.db.get_by_id(id);
    }

    @Override
    public ArrayList<Schema> get_all_items() {
        return this.db.get_all_items();
    }

    @Override
    public void update(String id, Schema new_item) {
        this.db.update(id, new_item);
    }

    @Override
    public void delete(String id) {
        this.db.delete(id);
    }
}
