package Classes;

public class Animal {

	public String type;
	public String breed;
	public String gender;
	public int age;
	
	public Animal(){
		type = "";
		breed = "";
		gender = "";
		age = 0;
	}
	
	public Animal(String type, String breed, String gender, int age){
		this.type = type;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
	}
	
	public Animal(Animal obj){
		this.type = obj.type;
		this.breed = obj.breed;
		this.gender = obj.gender;
		this.age = obj.age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
