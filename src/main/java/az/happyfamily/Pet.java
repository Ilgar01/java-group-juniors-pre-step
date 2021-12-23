package az.happyfamily;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species;
    private String nickname;
    private int age=-1;
    private int trickLevel;
    private  String[] habits;
    static{
        System.out.println("Pet class is being loaded");
    }
    {
        System.out.println("Pet object is created");
    }
    public Pet(String species, String nickname){
        setSpecies(species);
        setNickname(nickname);
    }
    public Pet(String species, String nickname, int age, int trickLevel, String[] habits){
        this(species,nickname);
        setAge(age);
        setTrickLevel(trickLevel);
        setHabits(habits);
    }
    public Pet(){

    }

    public String getSpecies() {

        return (species==null)?(""):(species);
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return (nickname==null)?(""):(nickname);
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
         if(this.age<0){ System.out.println("Age not specified or wrong specified");}return age;
    }

    public void setAge(int age) {
        if(age>=0){
            this.age = age;
        }
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if(trickLevel<1 || trickLevel>100){
            System.out.println("trickLevel can be between 1 and 100");
        }
        else {
            this.trickLevel = trickLevel;
        }
    }

    public String[] getHabits() {

        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }
     public void eat(){
        System.out.println("I am eating");
     }

     public void respond(){
        System.out.printf("Hello, owner. I am - %s. I miss you!",getNickname());
     }

    public void foul(){
        System.out.println("I need to cover it up");
     }

    @Override
    public String toString() {
        return String.format("%s{nickname=%s, age=%d, trickLevel=%d, habits=%s}",getSpecies(),getNickname(),getAge(),
                getTrickLevel(),((getHabits()==null)?(""):(Arrays.toString(getHabits()))));
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(!(obj instanceof  Pet)){
            return false;
        }
        Pet pet= (Pet) obj;
        return pet.getSpecies().equals(getSpecies()) & pet.getNickname().equals(getNickname())
                & pet.getTrickLevel()==getTrickLevel() & pet.getAge()==getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrickLevel(),getNickname(),getAge(),getSpecies());
    }
}
