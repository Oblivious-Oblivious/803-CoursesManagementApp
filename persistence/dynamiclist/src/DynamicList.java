package persistence.dynamiclist.src;

import java.util.ArrayList;

import app.src.entities.Schema;

public class DynamicList {
    private ArrayList<Schema> list;

    public DynamicList() {
        this.list = new ArrayList<Schema>();
    }

    public void save(Schema item) {
        this.list.add(item);
    }

    public Schema get_by_id(String id) {
        for(Schema item : this.list)
            if(item.get_id().equals(id))
                return item;
        return null;
    }

    public ArrayList<Schema> get_all_items() {
        return this.list;
    }

    public void update(String id, Schema new_item) {
        for(int i = 0; i < this.list.size(); i++)
            if(this.list.get(i).get_id().equals(id))
                this.list.set(i, new_item);
    }

    public void delete(String id) {
        for(int i = 0; i < this.list.size(); i++)
            if(this.list.get(i).get_id().equals(id))
                this.list.remove(i);
    }
}
