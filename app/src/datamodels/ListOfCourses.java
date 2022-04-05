package app.src.datamodels;

import java.util.ArrayList;

public class ListOfCourses {
    private ArrayList<Course> list;

    public ListOfCourses() {
        this.list = new ArrayList<Course>();
    }

    public int size() {
        return this.list.size();
    }

    public Course item_at(int index) {
        return this.list.get(index);
    }

    public void add(Course item) {
        this.list.add(item);
    }
}
