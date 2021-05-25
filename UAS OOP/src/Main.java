import java.util.*;
import java.util.concurrent.locks.*;
import java.util.Scanner;
import java.util.regex.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Main {
	private Lock obj = new ReentrantLock();
	private Condition switchUser = obj.newCondition();
	Scanner sc = new Scanner(System.in);
	ArrayList<Users> userList = new ArrayList<Users>();

	public static void main(String[] args) {
		new Main();
	} 
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		String sDate1="31/12/1998";  
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		Administrator a = new Administrator("Budi", "Jl. Hatimu", "08746674888", "budi@gmail.com", "Bekasi", 2000000.00, date1, "Staff");
		Users u = new Users(a);
		userList.add(u);
		Mahasiswa m = new Mahasiswa("Andi", "Jl. Park", "08646666789", "andi@gmail.com", 2017);
		Users u1 = new Users(m);
		userList.add(u1);
		Dosen d = new Dosen("Cici", "Jl. Delta", "08657899372", "cici@gmail.com", "Kemanggisan", 1900000.00, date1, "Lektor", 10);
		Users u2 = new Users(d);
		userList.add(u2);
		
		Thread t1 = new Thread(u);
		Thread t2 = new Thread(u1);
		Thread t3 = new Thread(u2);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			} catch(InterruptedException e) {
			System.out.println(e);
			}
	}
	
	public static boolean isValid(String s) 
    {  
        Pattern p = Pattern.compile("(0/91)?[8][0-9]{11}");
        
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    } 
  
		
	
	
	public class Users implements Runnable
	{
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public String getOffice() {
			return office;
		}
		public void setOffice(String office) {
			this.office = office;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getAcademic() {
			return academic;
		}
		public void setAcademic(String academic) {
			this.academic = academic;
		}
		public int getTeachHour() {
			return teachHour;
		}
		public void setTeachHour(int teachHour) {
			this.teachHour = teachHour;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getUserClass() {
			return userClass;
		}
		public void setUserClass(String userClass) {
			this.userClass = userClass;
		}
		String name;
		String phone;
		String address;
		String email;
		int year;
		String office;
		double salary;
		Date date;
		String academic;
		int teachHour;
		String title;
		String userClass;
		
		public Users(Orang o)
		{
			this.name = o.getName();
			this.phone = o.getPhone();
			this.address = o.getAddress();
			this.email = o.getEmail();
			
			if(o.getClass().toString() == "Mahasiswa")
			{
				this.year = ((Mahasiswa) o).getYear();
				this.userClass = ((Mahasiswa)o).getClassName();
			}
			
			else if(o.getClass().toString() == "Dosen")
			{
				this.office = ((Dosen)o).getOffice();
				this.salary = ((Dosen)o).getSalary();
				this.date = ((Dosen)o).getDate();
				this.academic = ((Dosen)o).getAcademic();
				this.teachHour = ((Dosen)o).getTeachHour();
				this.userClass = ((Dosen)o).getClassName();
			}
			
			else
			{
				this.title = ((Administrator)o).getTitle();
				this.userClass = ((Administrator)o).getClassName();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try
			{
				
				obj.lock();
				
				
					System.out.println("Current User: " + getName());
					if(getUserClass() == "Mahasiswa")
					{
						int choice=0;
						do
						{
							System.out.println("1. Profile");
							System.out.println("2. Change Address");
							System.out.println("3. Change Phone Number");
							System.out.println("4. Change Email");
							System.out.println("5. Change User");
							choice = sc.nextInt();
							
							if(choice == 1)
							{
								System.out.println("User Profile");
								System.out.println();
								System.out.println("Name    : " + getName());
								System.out.println("Address : " + getAddress());
								System.out.println("Phone   : " + getPhone());
								System.out.println("Email   : " + getEmail());
								System.out.println("Year    : " + getYear());
								System.out.println("================================================");
							}
							
							else if(choice == 2)
							{
								String newAddress;
								System.out.print("Insert New Address: ");
								newAddress = sc.nextLine();
								
								setAddress(newAddress);
								System.out.println("================================================");
							}
							
							else if(choice == 3)
							{
								String newPhone;
								do
								{
									System.out.print("Insert New Phone: ");
									newPhone = sc.nextLine();
								}
								while(isValid(newPhone)==false);
								
								setAddress(newPhone);
								System.out.println("================================================");
							}
							
							else if(choice == 4)
							{
								String newEmail;
		
									System.out.print("Insert New Phone: ");
									newEmail = sc.nextLine();
					
								setAddress(newEmail);
								System.out.println("================================================");
							}
							
							else if(choice == 5)
							{
								if(Thread.activeCount() > 2)
								{
									switchUser.signal();
									switchUser.await();
								}
								else {
									System.out.println("Can't change user.\n");
								}
								
							}
						}
						while(choice!=5);
						
					}
					
					else if(getUserClass() == "Dosen")
					{
						int choice = 0;
						do
						{
							System.out.println("1. Profile");
							System.out.println("2. Change Address");
							System.out.println("3. Change Phone Number");
							System.out.println("4. Change Email");
							System.out.println("5. Change User");
							choice = sc.nextInt();
							
							if(choice == 1)
							{
								System.out.println("User Profile");
								System.out.println();
								System.out.println("Name    : " + getName());
								System.out.println("Address : " + getAddress());
								System.out.println("Phone   : " + getPhone());
								System.out.println("Email   : " + getEmail());
								System.out.println("Office  : " + getOffice());
								System.out.println("Salary  : " + getSalary());
								System.out.println("Working Since : " + getDate());
								System.out.println("Academic Level : " + getAcademic());
								System.out.println("Teaching Hours : " + getTeachHour());
								System.out.println("================================================");
							}
							
							else if(choice == 2)
							{
								String newAddress;
								System.out.print("Insert New Address: ");
								newAddress = sc.nextLine();
								
								setAddress(newAddress);
								System.out.println("================================================");
							}
							
							else if(choice == 3)
							{
								String newPhone;
								do
								{
									System.out.print("Insert New Phone: ");
									newPhone = sc.nextLine();
								}
								while(isValid(newPhone)==false);
								
								setAddress(newPhone);
								System.out.println("================================================");
							}
							
							else if(choice == 4)
							{
								String newEmail;
		
									System.out.print("Insert New Phone: ");
									newEmail = sc.nextLine();
					
								setAddress(newEmail);
								System.out.println("================================================");
							}
							
							else if(choice == 5)
							{
								if(Thread.activeCount() > 2)
								{
									switchUser.signal();
									switchUser.await();
								}
								else {
									System.out.println("Can't change user.\n");
								}
								
							}
						}
						while(choice!=5);
						
					}
					
					else
					{
						
					}
				
				
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			finally
			{
				obj.unlock();
			}
			
		}
	}
	
	
	
}