package pkt;

import java.util.concurrent.ThreadLocalRandom;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{


    private double sicaklik;

    public int sicaklikOlc(){
        System.out.println("Ortam Sıcaklığı ölçülüyor....");
        Zaman.bekle();
        int min=-40;
        int max=60;

        int sicaklik = ThreadLocalRandom.current().nextInt(min, max + 1);
        return sicaklik;


    }


}
