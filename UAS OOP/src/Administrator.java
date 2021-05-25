import java.util.Date;

public class Administrator extends Karyawan{
	
	private String title;

	public Administrator(String name, String address, String phone, String email, String office, double salary, Date date, String title) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setAddress(address);
		this.setEmail(email);
		this.setPhone(phone);
		this.setOffice(office);
		this.setSalary(salary);
		this.setDate(date);
		this.setTitle(title);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getClassName()
	{
		String classname = this.getClass().toString();
		return classname;
	}

}
