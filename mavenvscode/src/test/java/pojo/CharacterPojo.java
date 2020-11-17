package pojo;

public class CharacterPojo {
    
    public String name;
    public String portrayed;

    public CharacterPojo(String name, String portrayed){
        this.name = name;
        this.portrayed = portrayed;
    }

    public String returName() {
        return this.name;
    }

    public String returnPortrayed(){
        return this.portrayed;
    }
}