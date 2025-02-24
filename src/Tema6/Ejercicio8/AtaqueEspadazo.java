package Tema6.Ejercicio8;

public class AtaqueEspadazo implements AtaqueAvanzado {
    private int fuerza;

    public AtaqueEspadazo(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int iCoste() {
        return 2*iDamageMagico()+iDamageFisico();
    }

    @Override
    public int iDamageFisico() {
        return fuerza*3;
    }

    @Override
    public int iDamageMagico() {
        return 0;
    }

    @Override
    public int idamageInflingido() {
        return (2*iDamageFisico())+(2*iDamageMagico());
    }

    @Override
    public void iLanzar() {
        System.out.println("Ha lanzado ataque bola de fuego " + idamageInflingido() + " coste de " + idamageInflingido());
    }

}
