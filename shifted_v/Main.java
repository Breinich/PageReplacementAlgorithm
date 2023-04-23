package shifted_v;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Fifo fifo = new Fifo();
        Frame a  = new Frame("A");
        Frame b  = new Frame("B");
        Frame c  = new Frame("C");
        fifo.addFrame(a);
        fifo.addFrame(b);
        fifo.addFrame(c);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] input = s.split(",");

        int sum = 0;
        for (String n:
             input) {
            sum += fifo.addPage(Integer.parseInt(n));
        }
        System.out.print("\n"+sum);
    }
}
