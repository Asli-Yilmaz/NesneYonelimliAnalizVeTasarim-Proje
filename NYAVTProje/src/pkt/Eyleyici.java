package pkt;

public class Eyleyici implements IEyleyici{


    @Override
    public void sogutucuAc() {
        System.out.println("Sogutucu açılıyor...");
        Zaman.bekle();
        System.out.println("Sogutucu acıldı.");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu kapatılıyor...");
        Zaman.bekle();
        System.out.println("Sogutucu kapatıldı.");
    }
}
