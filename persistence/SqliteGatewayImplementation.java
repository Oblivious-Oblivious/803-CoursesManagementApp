package persistence;

import java.util.ArrayList;

import app.src.entities.PersistenceGateway;
import app.src.entities.Identifiable;

public class SqliteGatewayImplementation implements PersistenceGateway {
    @Override
    public void save(Identifiable item) {}

    @Override
    public Identifiable get_by_id(String id) {
        return null;
    }

    @Override
    public ArrayList<Identifiable> get_all_items() {
        return null;
    }

    @Override
    public void update(String id, Identifiable new_item) {}

    @Override
    public void delete(String id) {}
}
