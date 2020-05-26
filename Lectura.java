import java.io.*;
class Lectura
{
   public static int readInt()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data="0";}
      int valor = Integer.parseInt(data);
      return valor;
   }
   
   public static String readString()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data=" ";}
      return data;
   }
   
   public static char readChar()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data=" ";}
      char valor = data.charAt(0);
      return valor;
   }
   
   public static double readDouble()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data="0";}
      double valor = Double.parseDouble(data);
      return valor;
   }
   
   public static float readFloat()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data="0";}
      float valor = Float.parseFloat(data);
      return valor;
   }
   
   public static short readShort()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data="0";}
      short valor = Short.parseShort(data);
      return valor;
   }
   
   public static byte readByte()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data="0";}
      byte valor = Byte.parseByte(data);
      return valor;
   }
   
   public static long readLong()
   {
      DataInputStream h = new DataInputStream(System.in);
      String data;
      try
      {
         data = h.readLine();
      }
      catch(IOException e){data="0";}
      long valor = Long.parseLong(data);
      return valor;
   }
}