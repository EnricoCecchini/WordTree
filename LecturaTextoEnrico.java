/***************************
Enrico Cecchini Rivera
531059
22 de Mayo, 2020
Proyecto Final 2: Arbol de Texto
Objetivo: Crear un programa que lea un archivo de texto txt y genere otro archivo txt
          donde se despliegue una palabra y la cantidad de veces que se repite en el
          texto leido. Las palabras se deben almacenar en un arbol y desplegarse en 
          orden alfabetico.
          
Codigo de Honor: Doy mi palabra que he realizado esta actividad con integridad academica.          
***************************/

/*
   Nota: El archivo txt se lee del disco d:\\ y ahi en el mismo disco se escribe el archivo nuevo
*/

//Clase Nodo del programa
import java.io.*;
import java.util.*;

class Nodo
{
   String palabra;
   int frec;
   Nodo izq;
   Nodo der;
   
   //Constructor de Nodo
   public Nodo(String palabra)
   {
      setPalabra(palabra);
      this.frec = 1;
      this.izq = null;
      this.der = null;
   }
   
   //SET y GET de los atributos del Nodo
   public void setPalabra(String palabra)
   {
      this.palabra = palabra;
   }
   public String getPalabra()
   {
      return palabra;
   }
   
   public int getFrec()
   {
      return frec;
   }
   
   //Metodo para incrementar la frecuencia
   public void addFrec()
   {
      frec++;
   }
   
   public Nodo getIzq()
   {
      return izq;
   }
   
   public Nodo getDer()
   {
      return der;
   }
}

//Clase de ABB del programa
class ABB
{
   Nodo raiz;
   
   //Constructor del arbol
   public ABB()
   {
      raiz = null;
   }
   
   //Metodo para obtener la raiz del arbol
   public Nodo getRaiz()
   {
      return raiz;
   }
   
   //Metodo para determinar si el arbol esta vacio
   public boolean vacio()
   {
      if(raiz == null)
         return true;
      else
         return false;
   }
   
   //Metodo para agregar palabras al arbol
   public void addPalabra(String palabra)
   {
      Nodo nuevo = new Nodo(palabra);
      //Agrega la raiz si el arbol esta vacio
      if(vacio())
      {
         raiz = nuevo;
      }
      //Agrega las palabras en su lugar si el arbol no esta vacio
      else
      {
         Nodo aux = raiz;
         Nodo padre;
         while(true)
         {
            padre = aux;
            //Aumenta la frecuencia si la palabra ya esta en el arbol
            if(palabra.toLowerCase().compareTo(aux.getPalabra().toLowerCase()) == 0)
            {
               aux.addFrec();
               return;
            }
            //Agrega la palabra a la izquierda del nodo
            else if(palabra.toLowerCase().compareTo(aux.getPalabra().toLowerCase()) < 0)
            {
               aux = aux.izq;
               if(aux == null)
               {
                  padre.izq = nuevo;
                  return;
               }
            }
            //Agrega la palabra a la derecha del nodo
            else if(palabra.toLowerCase().compareTo(aux.getPalabra().toLowerCase()) > 0)
            {
               aux = aux.der;
               if(aux == null)
               {
                  padre.der = nuevo;
                  return;
               }
            }
         }
      }     
   }
   
   //Metodo para recorrer el arbol en orden alfabetico
   public void recorrer(Nodo nodo, String textoWrite)
   {
      String palabraCont = "";
      if(nodo != null)
      {
         recorrer(nodo.izq, textoWrite);
         palabraCont = nodo.getPalabra() + "\t\t\t" + nodo.getFrec();
         System.out.println(nodo.getPalabra() + "\t\t\t" + nodo.getFrec());
         EscribirTexto.escribirTxt(palabraCont, textoWrite);
         
         recorrer(nodo.der, textoWrite);

      }
   }
}
   
class LecturaTextoEnrico
{
   public static void main(String args[])
   {
      ABB arbol = new ABB();
      
      //El programa lee un archivo en el disco D, para buscar el archivo en otro disco hay que cambiarle
      System.out.println("Introduce el nombre del texto que deseas leer del disco D");
      String textoLeer = Lectura.readString();
      //El programa escribe un archivo en el disco D, para crear el archivo en otro disco hay que cambiarle
      System.out.println("Introduce el nombre del texto al que deseas escribir en el disco D");
      String textoWrite = Lectura.readString();
      LecturaTexto l1 = new LecturaTexto();
      String texto = l1.leerTxt(textoLeer);
      String skip = " ";
      StringTokenizer  st = new StringTokenizer (texto, skip);
      //Se separan las palabras del texto y se agregan al arbol
      //Ambas formas funcionan, pero el split con el ciclo genera una linea en blanco al inicio
      while(st.hasMoreTokens())
      
      {
         arbol.addPalabra(st.nextToken());
      }
      /*
      String listaPalabras [] = texto.split(" ");
      int cont = 0;
      while(cont < listaPalabras.length)
      {
         arbol.addPalabra(listaPalabras[cont]);
         cont++;
      }*/
      Nodo nodo = arbol.getRaiz();
      
      arbol.recorrer(nodo, textoWrite);

      
   }
}

class LecturaTexto
{
   public String leerTxt(String textoLeer)
   {
      File f;
      FileInputStream file;
      InputStreamReader f1;
      BufferedReader f2;
      String var = "";
      String newVar = "";
      //Variable donde see guarda la ruta del archivo a leer en el disco D
      String dirRead = "d:\\" + textoLeer;
      //String dirWrite = "d:\\" + textoEscribir;
      try
      {
         f = new File(dirRead);
         file = new FileInputStream(f);
         f1 = new InputStreamReader(file);
         f2 = new BufferedReader(f1);
         while(newVar != null)
         {
         newVar = f2.readLine();
         var += " " + newVar;
         }
      
      }
      catch(IOException e)
      {
         System.out.println("No se encontro el archivo a leer");  
      }
      
      return var;
   }
}   

class EscribirTexto
{
   public static void escribirTxt(String palabraCont, String textoWrite)
   {
      File newFile;
      String var = palabraCont;
      
      //Variable donde see guarda la ruta del archivo a leer en el disco D
      String dirWrite = "D:\\" + textoWrite;
      try{
         newFile=new File(dirWrite);
         FileWriter writeTxt = new FileWriter(newFile, true);
         //Crea un nuevo archivo txt si no existe
         if(!newFile.exists())
         {
            newFile.createNewFile();
         }
         
         //Escribe la palabra y frecuencia en el txt
         writeTxt.write(palabraCont + "\n");
         writeTxt.close();
      }
      catch(IOException e)
      {
         System.out.println("No se encontro el archivo a escribir");  
      }
   }
}