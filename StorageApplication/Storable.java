import java.io.Serializable;

public class Storable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String type;
	private String location;
	private String quantity;

	public Storable(String type, String location, String quantity) {
		this.type = type;
		this.location = location;
		this.quantity = quantity;
	}
	
	public void setType(String type){
		if(type != ""){
			this.type = type;
		}
		else{
			System.out.println("Το πεδίο είναι κενό, παρακαλώ δώστε ένα όνομα για το αντικείμενο");
		}	
	}
	
	public String getType(){
		return type;
	}
	
	public void setLocation(String location){
		if(location != ""){
			this.location = location;
		}
		else{
			System.out.println("Το πεδίο είναι κενό, παρακαλώ δώστε μια θέση για το αντικείμενο");
		}
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setQuantity(String quantity){
		if(quantity != ""){
			this.quantity = quantity;
		}
		else{
			System.out.println("Το πεδίο είναι κενό, παρακαλώ δώστε την ποσότητα του αντικείμενο");
		}
	}
	
	public String getQuantity(){
		return quantity;
	}
}