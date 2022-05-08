package persistence;

import java.util.ArrayList;

import app.src.entities.PersistenceGateway;
import app.src.entities.Schema;
import persistence.dynamiclist.src.DynamicList;

public class DynamicListGatewayImplementation implements PersistenceGateway {
    private DynamicList list;

    public DynamicListGatewayImplementation() {
        this.list = new DynamicList();
    }

    @Override
    public void save(Schema item) {
        this.list.save(item);
    }

    @Override
    public Schema get_by_id(String id) {
        return this.list.get_by_id(id);
    }

    @Override
    public ArrayList<Schema> get_all_items() {
        return this.list.get_all_items();
    }

    @Override
    public void update(String id, Schema new_item) {
        this.list.update(id, new_item);
    }

    @Override
    public void delete(String id) {
        this.list.delete(id);
    }
}
