# Metodos sincronizados

    -Se encargar de definir la seccion criítica
    -Es la seccoin de codigo del objeto compartido a la que intentan
    acceder varios hilos al mismo tiempo
    -Hemos de sincronizarlo para que solo haya un hilo ejecutandose

Cada vez que el hilo intenta acceder al metodo syncronizafo, pregunta
si ya esta en posesion de  algun hilo. Si si espera, si no Pasa

-con palabra _syncronized_

```java
private int c = 0;
public synchronized void incrementa(){
    c = c+1;
}
```

# Bloques sincronizados
-No necesarios metodos. En el maismo codigo la palanbra _syncronized_ seguida
del objeto

```java
    synchronized(objeto){
    //seccion critica
        }
```