# Programacion  hilos
## Teoria
### Compartir recursos con bloque dependiente del ESTADO

#### Sincronizacion con `wait` y `Notify`

- Java ofrece los metodos `wait` , `Notify` y `NotifyAll` de la clase **Object**
para permitir la sincronizacion de los hilos

#### Explicacion de los metodos
- **`wai()`**
  - Se utiliza para suspender un hilo en ejecucion hasta
   que se cumpla un condicion especificaç
  - Retiene el hilo en la zona de ExclusionMutua (EM)
  - Lo envia a la cola de espera cambiando su estado a **espera**
  - El hilo queda a la espera de un `Notify` o `NotifyAll` para 
  pasar al estado preparado


- **`Notify()`**
  - Notifica a un hilo que se encuentra en esperaa
  - El hilo pasa de **espera** a **preparado**b
  - Desbloquea al hilo que esta esperando sobre el objeto
  compartido tras la ejecucion de `wait`

- **`NotifyAll()`**
  - NOtifica a todos los hilos en espera pasando a **preparados**
  
Los 3 metodos tienen que ejecutarse sobre el objeto que tiene el bloqueo. 
Por tanto, deben de hacerse dentro de un bloque `synchronized` 

### Ejemplo de codigo

```java

private boolean condicionEjecucionHilo;
public synchronized void metodoWait(){

    try {
        while (!condicionEjecucionHilo) {
            wait();
        }
        condicionEjecucionHilo = false;
        //****************************
        // SECCION CRITICA
        // Codigo en exclusion mutua
        //****************************


    }catch (InterruptedException e){
        System.out.println(e);
    }

    public synchronized void metodoCambioCondicion(){

        condicionEjecucionHilo = true;

        notify();

    }

}

```
Estos dos metodos deben de estar organizados para proteger el acceso
a la secion critica

    -Primero el `metodoWait()` bloquea el hilo
    -Segundo `metodoCanviCondicion()` desbloquea el hilo

Solo 1 hilo puede acceder simultaneamente a la seccion critica

### Consideracion sobre la programacion de Metodos espera  y notificacion

1. **EL metodo `metodoWait()` debe ejecutarse sincronizado**
    La seccion critica puede ejecutarse al finl del metodo o extraerse 
    como otro metodo invocado
   2. **EL metodo `metodoCambioCondicion()` modifica el valor de la condicion
   `condicionEjecucionHilo`utilizada en el while del metodo anterior** y notifica 
   el cambio para liberar los hilos
3. ** Un hilo liberado con `notify()` pasara a preparado**
4. **Cuando un hilo pasa por `wait()` entra en espera inmediatamente**

