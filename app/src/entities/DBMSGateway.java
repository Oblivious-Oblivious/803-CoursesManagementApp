package app.src.entities;

import java.util.ArrayList;

public interface DBMSGateway {
    public void save(Schema item);
    public Schema get_by_id(String id);
    public ArrayList<Schema> get_all_items();
    public void update(String id, Schema new_item);
}
