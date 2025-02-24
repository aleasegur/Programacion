package Tema6.Ejercicio8;

public class AtaqueEspadazoEncantado implements AtaqueAvanzado{
    private int poderMag,fuerza;

    public AtaqueEspadazoEncantado(){
        poderMag=0;
        fuerza=0;
    }

    public AtaqueEspadazoEncantado(int poderMag, int fuerza) {
        this.poderMag = poderMag;
        this.fuerza = fuerza;
    }

    public int getPoderMag() {
        return poderMag;
    }

    public void setPoderMag(int poderMag) {
        this.poderMag = poderMag;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int iDamageMagico() {
        return poderMag*2;
    }

    @Override
    public int iDamageFisico() {
        return fuerza*2;
    }

    @Override
    public int iCoste() {
        return 2*(iDamageFisico()+iDamageFisico());
    }

    @Override
    public int idamageInflingido() {
        return (2*iDamageFisico())+(2*iDamageMagico());
    }

    @Override
    public void iLanzar() {
        System.out.println("Ha lanzado un atque espadazo encantado con "+idamageInflingido()+" de daño con coste "+iCoste());
    }
}
