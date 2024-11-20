package vn.herta.model;

public class Modelthucong {

	    private Long id;
	    private String name;
	    private String email;
	    private int age;

	   
	    public Modelthucong() {
	    }

	  
	    public Modelthucong(Long id, String name, String email, int age) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.age = age;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    // toString method
	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                ", age=" + age +
	                '}';
	    }
	}


