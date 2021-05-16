package pkt;

import java.sql.*;
import java.util.concurrent.Callable;

public class PostgreSQLVeritabani implements IBilgiSistemi{


   private Connection Baglan(){
       Connection conn=null;
       try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
                   "postgres", "sifre");
           if (conn != null)
               System.out.println("Veritabanına bağlandı!");
           else
               System.out.println("Bağlantı girişimi başarısız!");

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return conn;
   }

    @Override
    public boolean kullaniciDogrula(String kullaniciAdi, int sifre) {
        Connection conn= Baglan();
        //KullaniciHesabi kullaniciHesabi = null;
        boolean dogrulama=true;

        String sql = "SELECT *  FROM \"HesapBilgileri\" WHERE \"kullaniciAdi\"='" + kullaniciAdi + "' AND sifre=" + sifre;

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                //***** Bağlantı sonlandırma *****
            conn.close();
            boolean sonuc=rs.next();

            if(sonuc){
                do{
                        kullaniciAdi=rs.getString("kullaniciAdi");
                        sifre  = rs.getInt("sifre");
                }while(rs.next());

            }
            else{
                System.out.println("\nKullanici Dogrulamasi Basarisiz!");
                dogrulama=false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dogrulama;
    }

    @Override
    public void sifreDegistir(String kullaniciAdi,int sifre) {

        String sql = "UPDATE \"HesapBilgileri\" SET \"sifre\"= "+ sifre +
                " WHERE \"kullaniciAdi\"='"+ kullaniciAdi+"'";
        Connection conn=this.Baglan();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
            System.out.println("Sifreniz başarılı bir şekilde değiştirilmiştir.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
}
