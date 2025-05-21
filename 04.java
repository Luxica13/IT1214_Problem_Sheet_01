class Ticket{
	private int ticketNumber;
	private String customerName;
	private int seatNumber;
	
	Ticket(int ticketNumber,String customerName,int seatNumber){
		this.ticketNumber = ticketNumber;
		this.customerName = customerName;
		this.seatNumber = seatNumber;
	}
	
	public void setTicketNumber(int ticketNumber){
		this.ticketNumber = ticketNumber;
	}
	public void setCustomerName(String CustomerName){
		this.customerName = customerName;
	}
	public void setSeatNumber(int seatNumber){
		this.seatNumber = seatNumber;
	}
	public int getTicketNumber(){
		return ticketNumber;
	}
	public String getCustomerName(){
		return customerName;
	}
	public int getSeatNumber(){
		return seatNumber;
	}
	
}

class BookingSystem{
	Ticket[] tickets = new Ticket[10];
	int ticketCounter = 0;
	
	private boolean isSeatTaken(int seatNumber) {
        for (int i = 0; i < ticketCounter; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                return false;
            }
        }
        return true;
    }
	
	public void bookTicket(int ticketNumber,String customerName,int seatNumber){
		if(ticketCounter < 10 && isSeatTaken(seatNumber)){
			tickets[ticketCounter] = new Ticket(ticketNumber,customerName,seatNumber);
			System.out.println("Booking Successful!!");
			ticketCounter++;
		}
		else{
			System.out.println("seat not available!!");
		}
	}
	
	public void cancelTicket(int ticketNumber){
		for(int i=0; i<ticketCounter; i++){
			if(tickets[i].getTicketNumber() == ticketNumber){
			System.out.println("Cancelling the ticket!!");
			tickets[i] = tickets[ticketCounter-1];
			tickets[ticketCounter-1] = null;
			ticketCounter--;
			break;
			}
			else{
				System.out.println("Tickets not found!!");
			}
		}
	}
	
	public void displayBooking(){
		System.out.println("Ticket Number\t\tCustomer Name\t\tSeat Number");
		for (int i = 0; i < ticketCounter; i++) {
            System.out.println(tickets[i].getTicketNumber()+"\t\t\t"+tickets[i].getCustomerName()+"\t\t\t"+tickets[i].getSeatNumber());
        }
	}
}

class TicketBookingApp{
	public static void main(String[] args){
		BookingSystem system = new BookingSystem();
		
		
			system.bookTicket(1,"John",4);
			system.bookTicket(2,"Kevin",6);
			system.bookTicket(3,"Ben",1);
			
			system.displayBooking();
			system.cancelTicket(1);
			system.bookTicket(5, "Bella", 4);
			system.bookTicket(105, "David", 1);
		
			system.displayBooking();
		
	}
}
