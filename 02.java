class Vehicle{
	private String licensePlate;
	private String ownerName;
	private int hoursParked;
	
	Vehicle(String licensePlate,String ownerName,int hoursParked){
		this.licensePlate = licensePlate;
		this.ownerName = ownerName;
		this.hoursParked = hoursParked;
	}
	
	public void setLicensePlate(String licensePlate){
		this.licensePlate = licensePlate;
	}
	public void setOwnerName(String ownerName){
		this.ownerName = ownerName;
	}
	public void setHoursParked(int hoursParked){
		this.hoursParked = hoursParked;
	}
	public String getLicensePlate(){
		return licensePlate;
	}
	public String getOwnerName(){
		return ownerName;
	}
	public int getHoursParked(){
		return hoursParked;
	}
}

class ParkingLot{
	Vehicle[] vehicle = new Vehicle[5];
	int vehicleCounter=0;
	
	public void addVehicle(String licensePlate,String ownerName,int hoursParked){
		vehicle[vehicleCounter] = new Vehicle(licensePlate,ownerName,hoursParked);
		vehicleCounter++;
	}
	
	public void removeVehicle(String licensePlate){
		int i;
		for(i=0; i<vehicleCounter; i++){
			if(vehicle[i].getLicensePlate() == licensePlate){
				for(int j=i; j<vehicleCounter; j++){
					vehicle[j] = vehicle[j+1];
				}
				vehicleCounter--;
				break;
			}
		}
	}
	
	public void displayDetails(){
		System.out.println("License plate\tOwner's Name\t\tHours Parked");
		for(int i=0; i<vehicleCounter; i++){
			System.out.println(vehicle[i].getLicensePlate()+"\t\t"+vehicle[i].getOwnerName()+"\t\t"+vehicle[i].getHoursParked());
		}
	}
}
class Main{
	public static void main(String[] args){
		ParkingLot p1 = new ParkingLot();
		p1.addVehicle("ABC123","John Doe",2);
		p1.addVehicle("XYZ789","Jane Smith",4);
		p1.addVehicle("LMN456","Bob Brown",1);
		System.out.println("Details before removal of a vehicle:");
		p1.displayDetails();
		p1.removeVehicle("XYZ789");
		System.out.println("Details after removal of a vehicle:");
		p1.displayDetails();
	}
}
