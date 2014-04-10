/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reynas8;

import java.util.Scanner;

/**
 *
 * @author Mau
 */
public class Reynas 
{   
    private static boolean[] fila;  
    private static int n;
   
   public Reynas(int nf) 
   {
       
   }

   //metodo para obtener la posicion 
public static void getPosition(int fila,int columna[],boolean a[],boolean diagArriba[],boolean diagAbajo[],int numero){
    int j;
       
    if(fila==numero){
    Reynas tab = new Reynas(8);
    tab.Tablero(columna,numero);
    System.out.println();
    System.out.println();
    }
      
    for(j=0;j<n;++j){
        if(a[j] && diagArriba[(numero-1)+fila-j] && diagAbajo[fila+j])
        
        {//si hay oportunidad hacemos otra llamada para colocar la siguiente reyna
            columna[fila]=j;

            diagArriba[(numero-1)+fila-j]=diagAbajo[fila+j]=a[j]=false;
            getPosition(fila+1,columna,a,diagArriba,diagAbajo,n);//llamada a colocar a la siguienete reyna
            diagArriba[(numero-1)+fila-j]=diagAbajo[fila+j]=a[j]=true;
            
        }
        
        }
    }

   

 public void Tablero(int posicion[],int n)
 {
     
        for(int fil=0; fil<n; fil++) 
    {
            
           for(int a=0;a<n*2;++a)
                        System.out.print("-");
                        System.out.print("\n");
                for(int col=0; col<n; col++) 
        {
                        if(posicion[col]==fil)
                            System.out.print("|*");
                        else
                            System.out.print("| ");
                    
        }
            System.out.print("|\n");
      
    }
                         for(int a=0;a<n*2;++a)
                             System.out.print("-");
                             System.out.print("\n");
}
 
 public static void main(String args[])
{
    do
    {
         System.out.printf("INGRESA UN NUMERO: ");
                Scanner entrada=new Scanner(System.in);
                        n=entrada.nextInt();
    }
    while(n<4);
    
            int col[]=new int[n];
            int i;
            boolean diagArriba[] =new boolean[(n*2)-1];
            boolean diagAbajo[]=new boolean[(n*2)-1];
            fila=new boolean[n];
    
    for(i=0;i<(n*2)-1;++i)
    {
        if(i<n)
           fila[i]=true;
                    diagArriba[i]=diagAbajo[i]=true;
    }
 
                        getPosition(0,col,fila,diagArriba,diagAbajo,n);
    
  
    
}
 
 
}

