package shifted_v;

import java.util.LinkedList;


public class Fifo {
    LinkedList<Frame> frames;

    public Fifo(){
        frames = new LinkedList<>();
    }
    public void addFrame(Frame f){
        frames.add(f);
    }

    int addPage(int p){

        boolean found = false;
        int turn = 0;
        for (Frame f: frames ) {
            if(f.checkPage(p)) {
                System.out.print("-");
                found = true;
                turn++;
            }
            if(!found)
                turn++;
        }
        for(int i = 0; i < turn; i++)
            frames.add(frames.removeFirst());
        if (found)
            return 0;

        for(int i = 0; i<frames.size()*2;i++){
            Frame tmp = frames.removeFirst();
            if(tmp.addPage(p) == 1) {
                System.out.print(tmp.getName());
                frames.add(tmp);
                return 1;
            }

            frames.add(tmp);
        }
        System.out.print("*");


        return 1;
    }
}
