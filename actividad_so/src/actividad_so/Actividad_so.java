
package actividad_so;

 
import java.util.Map;
import java.util.TreeMap;


public class Actividad_so {

         
    public static void main(String[] args) {
         
       // Asignacion de quamtums 
        int quantum = 5; 
        int contador = 0;
 
        TreeMap<Integer,Integer> ejecucion = new TreeMap<Integer,Integer>(); 
        TreeMap<Integer,Integer> rrtemp = new TreeMap<Integer,Integer>(); 
         
     // asignacion de rafagas de tiempo a procesos
     
        
        ejecucion.put(1,53);
        ejecucion.put(2,20);
        ejecucion.put(3,15);
        ejecucion.put(4,10);
        ejecucion.put(5,53);
  
         
         
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
                                    //System.out.println("LLeno->>>>><<<<<<<<<<>>>"+ejecucion);
                                     
                                     
                                }
                             }
                        menosqua--;
                        contador--;
                    }
                }
            }
         System.out.println("Tiempo "+ejecucion+" ms.");
         System.out.println("No. procesos "+ejecucion.size());
  
    }
}
    

