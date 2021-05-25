import java.util.Date;

public class Dosen extends Karyawan{

	private String academic;
	private int teachHour;

	public Dosen(String name, String address, String phone, String email, String office, double salary, Date date, String academic, int teachHour) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setAddress(address);
		this.setEmail(email);
		this.setPhone(phone);
		this.setOffice(office);
		this.setSalary(salary);
		this.setDate(date);
		this.setAcademic(academic);
		this.setTeachHour(teachHour);
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
	
	public String getClassName()
	{
		String classname = this.getClass().toString();
		return classname;
	}

}
