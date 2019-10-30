
package actividad_so;

 
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Actividad_so {

         
    public static void main(String[] args) {
         
       // Asignacion de quamtums 
        int quantum = 5; 
        int contador = 0;
        int num1;
        int num2;
        int num3;
        int num4;
        int num5;
        Scanner sc = new Scanner(System.in);
 
        TreeMap<Integer,Integer> ejecucion = new TreeMap<Integer,Integer>(); 
        TreeMap<Integer,Integer> rrtemp = new TreeMap<Integer,Integer>(); 
         
     // asignacion de rafagas de tiempo a procesos
        System.out.println("Inserte tiempo Proceso a");
           num1 = sc.nextInt();
        System.out.println("Inserte tiempo Proceso b");
           num2 = sc.nextInt();
        System.out.println("Inserte tiempo Proceso c");
           num3 = sc.nextInt();
        System.out.println("Inserte tiempo Proceso d");
           num4 = sc.nextInt();
        System.out.println("Inserte tiempo Proceso e");
           num5 = sc.nextInt();
           
        
        
        ejecucion.put(1,num1);
        ejecucion.put(2,num2);
        ejecucion.put(3,num3);
        ejecucion.put(4,num4);
        ejecucion.put(5,num5);
  
         
         
        System.out.println("Procesos con ms"+ejecucion);
        System.out.println("No. procesos activos "+ejecucion.size());
 
                  while(ejecucion.isEmpty() !=true)
            {
                 
                for(int bb=1;bb<=ejecucion.size();bb++)
                {
                    int menosqua = 0;
                     
                    contador = quantum;
                  
                 
                    menosqua = ejecucion.get(bb);
                    while(contador !=0)
                    {
                         if(menosqua !=0 && menosqua >=0)
                       {
                                 
                             ejecucion.put(bb, menosqua);
                             System.out.println("Num_proceso "+bb+" iniciado "+ejecucion.get(bb)+" Milisegundos");
                             try {
                                    Thread.sleep(ejecucion.get(bb)*10);
                                 } catch(InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                    }
 
                        }else{
                                if(menosqua==0)
                                {
                                    System.out.println("Num_proceso  "+bb+" terminado "+ejecucion.get(bb)+" Milisegundos ");                                    
                                     System.out.println("Num_proceso  Promedio "+(ejecucion.get(bb)*quantum/bb)+" Milisegundos ");
                                    ejecucion.remove(bb);
                                    int sumador=0;
                                     for (Map.Entry entry : ejecucion.entrySet()) 
                                    {
                                    sumador++;    
                                    
                                    int entrada = Integer.parseInt(entry.getValue().toString());
                                    rrtemp.put(sumador, entrada);
                                    
                                    }
                                   ejecucion.clear();
                                                              
                                    
                                    for(int xdf=1;xdf<=rrtemp.size();xdf++)
                                    {
                                        ejecucion.put(xdf, rrtemp.get(xdf));
                                    }
                                    
                                    rrtemp.clear();
                                  
                                     
                                     
                                }
                             }
                        menosqua--;
                        contador--;
                       
                    }
                    
                }
            }
         System.out.println("Quantum "+(num1+ num2+num3+num4+num5/quantum)+" .");
         
     
  
    }
}
    

