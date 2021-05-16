package pkt;

import java.util.Scanner;

public class AkilliCihaz {

    private int seriNo;
    private String marka;
    Garanti garanti;
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IBilgiSistemi bilgiSistemi;

    ISubject agArayuzu=new AgArayuzu();
    Ekran ekran=new Ekran();



    public AkilliCihaz(AkilliCihazBuilder builder ) {
        this.marka=builder.marka;
        this.seriNo= builder.seriNo;
        this.garanti=builder.garanti;
        eyleyici = new Eyleyici();
        sicaklikAlgilayici = new SicaklikAlgilayici();
        bilgiSistemi = new PostgreSQLVeritabani();
        agArayuzu.attach(ekran);

    }
    public void garantiUzat(int yil){
        garanti.garantiSuresiniUzat(yil);
    }

    public void basla() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanici adinizi giriniz.");
        String kullaniciAdi = scanner.next();
        System.out.println("Sifrenizi giriniz.");
        int sifre = scanner.nextInt();

        if (bilgiSistemi.kullaniciDogrula(kullaniciAdi, sifre)) {
            int islem;
            do {
                islem = ekran.menu();
                if (islem == 0) {
                    System.out.println("Lütfen geçerli bir işlem numarası giriniz.");
                }
                else{
                    switch (islem) {
                        case 1:
                            eyleyici.sogutucuAc();
                            break;
                        case 2:
                            eyleyici.sogutucuKapat();
                            break;
                        case 3:
                            agArayuzu.notify(sicaklikAlgilayici.sicaklikOlc());
                            break;
                        case 4:
                            System.out.println("Yeni sifrenizi giriniz.");
                            sifre=scanner.nextInt();
                            bilgiSistemi.sifreDegistir(kullaniciAdi,sifre);
                            break;
                        case 5:
                            System.out.println("Program kapatılıyor.");
                            break;
                    }
                }
            }while (islem==0 || islem!=5);
        }else{
            System.out.println("lutfen giris bilgilerinizi kontrol ediniz.");
        }
    }
    public static class AkilliCihazBuilder
    {
        private int seriNo;
        private String marka;
        Garanti garanti;

        public AkilliCihazBuilder(String marka, int seriNo) {
            this.marka = marka;
            this.seriNo = seriNo;
        }
        public AkilliCihazBuilder garanti (int garantiSuresi) {
            this.garanti=new Garanti(garantiSuresi);
            return this;
        }
        //Return the finally consrcuted Dikdortgen object
        public AkilliCihaz build() {

            return new AkilliCihaz(this);
        }

    }
}