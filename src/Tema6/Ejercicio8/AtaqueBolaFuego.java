package Tema6.Ejercicio8;

public class AtaqueBolaFuego implements AtaqueAvanzado {
    private int poderMagico;

    public AtaqueBolaFuego(){
        poderMagico=0;
    }

    public AtaqueBolaFuego(int poderMagico)throws Exception {
        if (poderMagico>0) {
            this.poderMagico = poderMagico;
        }else{
            throw new Exception("El valor no puede ser negativo");
        }
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico)throws Exception {
        if (poderMagico>0) {
            this.poderMagico = poderMagico;
        }else{
            throw new Exception("El valor no puede ser negativo");
        }
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
