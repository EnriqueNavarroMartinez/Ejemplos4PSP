package org.example.RepasoHilos;

public class HiloCadena extends Thread{

    private ObjetoCompartido objeto;
    String cad;

    public HiloCadena(ObjetoCompartido objeto, String cadena){
        this.objeto = objeto;
        this.cad = cadena;
    }

    //Metodo Run
//    public void run(){
//        for( int i = 0; i<10; i++){
//            objeto.pintaCadena(cad);
//            try{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }




//    public void run(){
//        synchronized (objeto){ //no se mezclan a y b
//            for(int i = 0; i < 10; i++){
//                objeto.pintaCadena(cad);
//            }
//        }
//    }

    public void run(){
        synchronized (objeto){
            for(int i = 0; i < 10; i++){

                objeto.pintaCadena(cad);
                objeto.notify();
                try{
                    objeto.wait();
                    //cuando llamamos a wait cualquier hilo
                    //que queira acceder a sc va a poder acceder
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            objeto.notifyAll();
        }
    }
}
