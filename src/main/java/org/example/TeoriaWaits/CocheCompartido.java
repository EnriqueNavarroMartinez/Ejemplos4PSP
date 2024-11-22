package org.example.TeoriaWaits;

public class CocheCompartido {
    public static void main(String[] args) {
        //3 personas quieres coger
        Coche fiesta = new Coche("Ford fiesta");

        //crear a la familia

        Thread filPare = new Thread(new MembreFamiliar(10000, "treballar", fiesta));
        Thread filMare = new Thread(new MembreFamiliar(65000, "botiga", fiesta));
        Thread filFilla = new Thread(new MembreFamiliar(5000, "iniversitat", fiesta));

        filPare.start();
        filMare.start();
        filFilla.start();

        try{
            filPare.join();
            filMare.join();
            filFilla.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
