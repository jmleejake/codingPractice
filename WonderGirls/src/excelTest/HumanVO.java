package excelTest;

public class HumanVO extends DataVO{
	private String jumin;
	private String name;
	private int age;
	
	public HumanVO() {}
	public HumanVO(String jumin, String name, int age) {
		super();
		this.jumin = jumin;
		this.name = name;
		this.age = age;
	}
	
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "HumanVO [jumin=" + jumin + ", name=" + name + ", age=" + age + "]";
	}
}
