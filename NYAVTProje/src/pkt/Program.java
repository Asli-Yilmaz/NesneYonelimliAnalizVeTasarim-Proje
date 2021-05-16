package pkt;

public class Program {

    public static void main(String args[]){

        AkilliCihaz sogutucu=new AkilliCihaz.AkilliCihazBuilder("Xmarka",642)
                .garanti(2)
                .build();
        sogutucu.basla();

     /*AkilliCihaz sogutucu2=new AkilliCihaz.AkilliCihazBuilder("Ymarka",602)
                .build();*/

    }
}
