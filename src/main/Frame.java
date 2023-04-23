package main;

public class Frame {
    String name;
    int page = 0;
    boolean used = false;
    boolean locked = false;
    boolean dirty = false;
    int lockCtDown = 3;


    public Frame(String name) {
        this.name = name;
    }

    public int addPage(int p) {

        if (locked) {
            return -1;
        }
        if (used) {
            used = false;
            return 0;
        }

        if (p > 0) page = p;
        else if (p < 0) {
            page = -p;
            dirty = true;
        } else {
            return -1;
        }
        locked = true;
        lockCtDown = 3;
        return 1;
    }

    public boolean checkPage(int p) {
        if (page == Math.abs(p)) {
            if (p < 0) dirty = true;
            used = true;
            locked = false;

            return true;
        }
        if (locked) {
            if (lockCtDown == 0) locked = false;
            else lockCtDown--;

        }
        return false;
    }

    public String getName() {
        return name;
    }

}
