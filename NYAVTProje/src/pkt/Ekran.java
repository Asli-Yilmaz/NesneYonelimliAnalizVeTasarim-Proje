package pkt;

import java.util.Scanner;

public class Ekran implements IObserver,IEkran{


    public int menu() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("---------Yapmak istediğiniz işlemi seçiniz.----------");
        System.out.println("1.Sogutucuyu aç.");
        System.out.println("2.Sogutucuyu kapat.");
        System.out.println("3.Ortam sıcaklıgını ölç.");
        System.out.println("4.Şifre değistir.");
        System.out.println("5.Cıkıs");
        return this.islemDogrulama(scanner.nextInt());

    }
    public int islemDogrulama(int islem) {
        if(islem<1||islem>5){
            return 0;
        }
        else {
            return islem;
        }

    }

    @Override
    public void update(int sicaklik) {
        System.out.println("Ölçülen ortam sıcaklığı "+sicaklik+" °C ");
    }
}
