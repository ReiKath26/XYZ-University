import java.util.Date;

public class Karyawan extends Orang{

	private String office;
	private double salary;
	private Date date;

	public Karyawan() {
		// TODO Auto-generated constructor stub
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

}
