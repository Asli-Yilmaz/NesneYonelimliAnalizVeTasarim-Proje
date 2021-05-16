package pkt;

public interface IBilgiSistemi {
    public boolean kullaniciDogrula(String kullaniciAdi , int sifre);
    public void sifreDegistir(String kullaniciAdi,int sifre);

}
