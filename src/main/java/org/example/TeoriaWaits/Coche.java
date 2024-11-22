package org.example.TeoriaWaits;

public class Coche {

    private String nom;
    private boolean clau;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isClau() {
        return clau;
    }

    public void setClau(boolean clau) {
        this.clau = clau;
    }

    public Coche(String nom) {
        this.nom = nom;

    }
    public boolean inCocheDisponible() {
        if(clau) {
            return true;
        }else{
            return false;
        }
    }

    public void usarCoche(int tempUsCotche, String llocUsCoche){
        try{
            //imprime mensaje indicando que el cpche esta en uso
            System.out.println("["+Thread.currentThread().getName()+"] Usando Coche "+getNom() + "para ir a "+llocUsCoche+ " durante "+tempUsCotche);
            Thread.sleep(tempUsCotche);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void agafaCoche(){
        //simula un temps abans de agafar el cotche como ocupado
        for(int i  = 0; i<2000000; i++){

        }
        this.clau = false; //cambia el estado del coche
        System.out.println(Thread.currentThread().getName()+ "agafant coche "+this.nom );
    }

    public void deixaCotche(){
        System.out.println(Thread.currentThread().getName()+ "deixa coche "+this.nom);
        this.clau = true;//el coche esta disponible
    }

    public synchronized void metodoWait(){
        try{
          while(!inCocheDisponible()){//mientras no este disponible
              System.out.println(Thread.currentThread().getName() +" metodoWait el coche no esta disponible >>");
              wait();

          }
          agafaCoche();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized  void metodeCambiaEstatClau(){
        deixaCotche();
        System.out.println(Thread.currentThread().getName() + " metodoCanviaEstadoWait el coche esta disponible");
        notifyAll();
    }
}
