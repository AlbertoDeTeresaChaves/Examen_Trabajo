package General2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;

public class Principal {

	public static void main(String[] args) {
 
				try {
					
				
				FileInputStream fileout = new FileInputStream("QUIJOTE_HASH.DAT");
				ObjectInputStream dataOS = new ObjectInputStream(fileout);
				Object o = dataOS.readObject();
				String datos = (String)o;
				System.out.println("Datos:" + datos);
				o = dataOS.readObject();
				byte resumeOriginal[] = (byte[]) o;
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(datos.getBytes());
				byte resumenActual[] = md.digest();
				
				if(MessageDigest.isEqual(resumenActual,resumeOriginal))
					System.out.println("\nDATOS VALIDOS");
				else
					System.out.println("\n DAOTOS N VALIDOS");
				dataOS.close();
				fileout.close();
				
				
			}catch(Exception e) {e.printStackTrace();}
			
		 
		}
}


