package ContadorCompartido;

public class ContadorHilo extends Thread {
    private Contador cont;
    ContadorHilo(String h_nombre,Contador h_cont){
        super(h_nombre);
        this.cont=h_cont;
    }
    //Método para incrementar el contador
    public void run(){
        for (int i=0;i<3;i++)
        {
            try{
                int a=cont.getContador();
                sleep((long)(Math.random()*10));
                cont.setContador(a+1);
                System.out.println(getName()+ " - contador: "+cont.getContador());
                sleep((long)(Math.random()*10));
            }catch (InterruptedException e){
                System.out.println("Interrupción del hilo...");
            }
        }
        System.out.println("Fin "+getName()+ "...");
    }
}