package General;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Principal {

	public static void main(String[] args) {

		try {
			FileOutputStream archivo = new FileOutputStream("QUIJOTE_HASH.DAT");
			ObjectOutputStream oos = new ObjectOutputStream(archivo);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			String datos = "En un lugar de la Mancha cuyo nombre no quiero acordarme,\n"+
						   "no ha mucho tiempo que vivia un hidalgo de los de lanza en \n"+
						   "astillero,adarga antigua,rocin flaco y galgo corredor.Una olla \n"+
						   "de algo mas vaca que carnero,salpicon las mas noches, duelos y quebrantos \n"+
						   "los sabados,lantejas los viernes,algun palomino deañadidura \n"+
						   "los domingos,consumian las tres partes de su hacienda.EL resto della \n"+
						   "concluian sayo de velarte, calzas de velludo para las fiestas con \n"+
						   "sus pantulos de lo mismo, y los dias de entresemana se honraba con su \n"+
						   "vellori de lo mas fino.";
			byte dataBytes[]= datos.getBytes();
			md.update(dataBytes);
			byte resumen[]= md.digest();
			
			oos.writeObject(resumen);
			oos.close();
			archivo.close();
			System.out.println("Resumen SHA-256 del Quijote creado con exito");
			System.out.println("Resumen: ");//APARARICION DEL RESUMEN
		}catch(IOException e) {e.printStackTrace();
		}catch(NoSuchAlgorithmException e) {e.printStackTrace();}
		
		}
	}



