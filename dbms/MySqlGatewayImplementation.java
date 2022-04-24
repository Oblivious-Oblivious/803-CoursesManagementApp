package dbms;

import java.util.ArrayList;

import app.src.entities.DBMSGateway;
import app.src.entities.Schema;

public class MySqlGatewayImplementation implements DBMSGateway {
    @Override
    public void save(Schema item) {}

    @Override
    public Schema get_by_id(String id) {
        return null;
    }

    @Override
    public ArrayList<Schema> get_all_items() {
        return null;
    }

    @Override
    public void update(String id, Schema new_item) {}

    @Override
    public void delete(String id) {}
}
