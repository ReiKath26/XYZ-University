
public class Mahasiswa extends Orang{

	private int year;
	
	public Mahasiswa(String name, String address, String phone, String email, int year) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setAddress(address);
		this.setEmail(email);
		this.setPhone(phone);
		this.setYear(year);
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getClassName()
	{
		String classname = this.getClass().toString();
		return classname;
	}

}
