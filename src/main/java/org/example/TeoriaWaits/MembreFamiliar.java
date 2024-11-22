package org.example.TeoriaWaits;

public class MembreFamiliar implements Runnable{

    int tempUsCoche;
    String llocUsCoche;
    Coche coche;

    public MembreFamiliar(int tempUsCoche, String llocUsCoche, Coche coche) {
        this.tempUsCoche = tempUsCoche;
        this.llocUsCoche = llocUsCoche;
        this.coche = coche;

        System.out.println(Thread.currentThread().getName() + "crear el membre Familiar");
    }

    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + "necsita el coche "+coche.getNom()+ " para ir "+llocUsCoche + " durant "+tempUsCoche+ " sec");
//
//        //verifica si el coche esta disponibl
//        if(coche.inCocheDisponible()){
//            coche.agafaCoche();
//            coche.usarCoche(tempUsCoche, llocUsCoche);
//            coche.deixaCotche();
//        }else{
//            System.out.println(Thread.currentThread().getName() + "el coche no esta disponible");
//        }
//
//
//    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "necsita el coche "+coche.getNom()+ " para ir "+llocUsCoche + " durant "+tempUsCoche+ " sec");
        coche.metodoWait();
        coche.usarCoche(tempUsCoche, llocUsCoche);
         coche.metodeCambiaEstatClau();
    }
}
