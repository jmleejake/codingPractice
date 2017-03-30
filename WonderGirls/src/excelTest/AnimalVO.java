package excelTest;

public class AnimalVO extends DataVO{
	private String kind;
	private String name;
	private int age;
	
	public AnimalVO() {}
	public AnimalVO(String kind, String name, int age) {
		super();
		this.kind = kind;
		this.name = name;
		this.age = age;
	}

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
		return "AnimalVO [kind=" + kind + ", name=" + name + ", age=" + age + "]";
	}
}
