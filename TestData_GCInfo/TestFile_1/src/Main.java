import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ----- For loop that fills an array with 50 million integers----- //
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        List<Integer> numberList_2 = new ArrayList<Integer>();

        int bigNum = 100000; //50000000

        long startTimeLoop = System.nanoTime();
        for(int i = 0; i < bigNum; i++) {
            numberList.add(i);
        }
        long endTimeLoop = System.nanoTime();
        System.out.println("numberList has been filled");
        long numberList_fill_duration = ((endTimeLoop - startTimeLoop)/1000000);  //returned in milliseconds //Divide by 1,000,000,000 to get seconds.
        long numberList_fill_duration_seconds = ((endTimeLoop - startTimeLoop)/1000000000);

        System.out.println("numberList fill duration = " + numberList_fill_duration + " ms");
        System.out.println("numberList fill duration = " + numberList_fill_duration_seconds + " s");

        // ----- Copy above array list ----- //
        numberList_2 = numberList;
        numberList_2 = numberList_2.subList(0,(bigNum / 4));
        System.out.println("Just copied");

        // ----- While loop that runs for 2 minutes ----- //
        int time = 5; //seconds

        long startTimeWhile = System.nanoTime();
        while(time > 0) {
            ArrayList<Integer> numberList_3 = new ArrayList<Integer>();
            numberList_3 = numberList;
            String LoremIpsum = "Lorem ipsum dolor sit amet, ut sea liber conceptam quaerendum, labore ornatus quaestio in vis. Usu ad decore altera. Te autem maluisset dissentias pri, mel no pericula splendide. Omittantur consectetuer pri ut, est in idque movet urbanitas. Ei nam graecis tacimates quaerendum, aeterno numquam minimum vel ei. Eos minim iisque constituto in, per ea veri persius mentitum.";

            numberList_3.remove(1);

            System.out.println("here" + time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
        long endTimeWhile = System.nanoTime();

        long while_loop_duration = ((endTimeWhile - startTimeWhile)/1000000);  //returned in milliseconds //Divide by 1,000,000,000 to get seconds.
        long while_loop_duration_seconds = ((endTimeWhile - startTimeWhile)/1000000000);

        boolean ret = GCInformation.printGCInfo();
        System.out.println("GCI information " + ret);

        System.out.println("while loop duration = " + while_loop_duration + " ms");
        System.out.println("while loop duration = " + while_loop_duration_seconds + " s");

//        boolean ret = GCInformation.printGCInfo();
    }
}



