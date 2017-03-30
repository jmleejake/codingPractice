package sqliteTest;

public class DataInfo {
	
	private int id;
    private String name;
    private String book_code;
    
    public DataInfo() {} // default constructor
    
    public DataInfo(int id, String name, String book_code) {
		this.id = id;
		this.name = name;
		this.book_code = book_code;
	}

	public int getId() {
        return id;
    }
     
    public void setId(int id) {
        this.id = id;
    }
     
    public String getName() {
        return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }
     
    public String getBook_code() {
        return book_code;
    }
     
    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

	@Override
	public String toString() {
		return "DataInfo [id=" + id + ", name=" + name + ", book_code=" + book_code + "]";
	}
    
}
