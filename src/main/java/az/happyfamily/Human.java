package az.happyfamily;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Human {
   private String name;
   private String surname;
   private int year;
   private int iq;
   private String[][] schedule;

    static{
        System.out.println("Human class is being loaded");
    }
    {
        System.out.println("Human object is created");
    }
   public Human(String name, String surname){
       setName(name);
       setSurname(surname);
   }
   public Human(String name, String surname, int year){
       this(name,surname);
       setYear(year);
   }
    public Human(){

    }

    public String getName() {

        return (name==null)?(""):(name);
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {
        return (surname==null)?(""):(surname);
    }

    public void setSurname(String surname) {
       this.surname = surname;
    }

    public int getYear() {
           return year;

    }

    public void setYear(int year) {
        if(LocalDate.now().getYear()-100>year|| year> LocalDate.now().getYear()){
            System.out.println("Unreal birth year");
        }
        else {
            this.year = year;
        }
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if(iq<1 || iq>100){
            System.out.println("Iq level can be between 1 and 100");
        }
        else {
            this.iq = iq;
        }
    }
    public String[][] getSchedule() {

        return schedule;
    }

    public void setSchedule(String[][] schedule) {

            this.schedule = schedule;

    }
    @Override
    public String toString() {
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d, schedule=%s}%n",
                getName(),getSurname(),getYear(),getIq(),(getSchedule()!=null)?
                        (Arrays.deepToString(getSchedule())):(""));
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(!(obj instanceof  Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName()) & human.getSurname().equals(getSurname()) & human.getYear()==getYear()
                & human.getIq()==getIq();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIq(),getName(),getSurname(),getYear());
    }
}
