package Tema6.Ejercicio8;

public class AtaqueBolaFuego implements AtaqueAvanzado {
    private final int poderMagico;

    public AtaqueBolaFuego(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    @Override
    public int iCoste() {
        return iDamageMagico()+iDamageFisico()* 2;
    }

    @Override
    public int iDamageFisico() {
        return 0;
    }

    @Override
    public int iDamageMagico() {
        return poderMagico * 4;
    }

    @Override
    public int idamageInflingido() {
        return (2 * iDamageMagico())+(2*iDamageMagico());
    }

    @Override
    public void iLanzar() {
        System.out.println("Ha lanzado ataque bola de fuego " + idamageInflingido() + " coste de " + iCoste());
    }
}
