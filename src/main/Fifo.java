package main;

import java.util.LinkedList;


public class Fifo {
    LinkedList<Frame> frames;

    public Fifo() {
        frames = new LinkedList<>();
    }

    public void addFrame(Frame f) {
        frames.add(f);
    }

    int addPage(int p) {

        boolean found = false;

        for (Frame f : frames) {
            if (f.checkPage(p)) {
                System.out.print("-");
                found = true;
            }
        }

        if (found) return 0;
        int j = 0;
        for (int i = 0; i < frames.size() * 2; i++) {
            int s = frames.get(j).addPage(p);
            if (s == 1) {
                System.out.print(frames.get(j).getName());
                frames.add(frames.remove(j));
                return 1;
            } else if (s == -1) {
                j++;
            } else {
                frames.add(frames.remove(j));
            }

            if (j == frames.size()) {
                System.out.print("*");
                break;
            }
        }

        return 1;
    }
}
