
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DBReadWrite {

	
	
	public static  ArrayList<Storable> dbRead(){
			try{
				FileInputStream fis = new FileInputStream("C:/StorageApplication/items.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				@SuppressWarnings("unchecked")
				ArrayList<Storable> items = (ArrayList<Storable>) ois.readObject();
				ois.close();
				fis.close();
				return items;
			}
			catch(IOException ioe){
				ioe.printStackTrace();
				return null;
			}
			catch(ClassNotFoundException c){
				System.out.println("Class not found");
				c.printStackTrace();
				return null;
			}
	}
	
	public static void dbWrite(ArrayList<Storable> obj){

				try{
					File dir = new File("C:/StorageApplication");
					if (!dir.exists()){
						dir.mkdir();	
					}
					FileOutputStream fileOut= new FileOutputStream("C:/StorageApplication/items.ser");
					ObjectOutputStream out= new ObjectOutputStream(fileOut);
					out.writeObject(obj);
					out.close();
					fileOut.close();
					}
				catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
}
