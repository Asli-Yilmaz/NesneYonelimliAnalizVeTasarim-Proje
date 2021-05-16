package pkt;

public class Garanti {
    private int normalGarantiSuresi;
    private int uzatilmisGarantiSuresi;

    public Garanti(int normalGarantiSuresi) {
        this.normalGarantiSuresi = normalGarantiSuresi;

    }

    public int getNormalGarantiSuresi() {
        return normalGarantiSuresi;
    }

    public void setNormalGarantiSuresi(int normalGarantiSuresi) {
        this.normalGarantiSuresi = normalGarantiSuresi;
    }

    public int getUzatilmisGarantiSuresi() {
        return uzatilmisGarantiSuresi;
    }

    public void setUzatilmisGarantiSuresi(int uzatilmisGarantiSuresi) {
        this.uzatilmisGarantiSuresi = uzatilmisGarantiSuresi;
    }

    public void garantiSuresiniUzat(int normalGarantiSuresi){
        this.uzatilmisGarantiSuresi=normalGarantiSuresi+3;
    }


}
