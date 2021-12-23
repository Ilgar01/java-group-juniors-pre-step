package az.happyfamily;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class
Family {
    private  Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    static{
        System.out.println("Family class is being loaded");
    }
    {
        System.out.println("Family object is created");
    }
    public Family(Human mother, Human father){
        setMother(mother);
        setFather(father);
    }

    public Human getMother() {return mother;}

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void addChild(Human child){
        if(getChildren()!=null){
        setChildren(Arrays.copyOf(getChildren(),getChildren().length+1));
        getChildren()[getChildren().length-1]=child;
    }else{
            this.children = new Human[]{child};
        }
    }

    public boolean deleteChild(Human child) {
        int childIndex = -1;
         for (int i=0; i<getChildren().length;i++){
             if(child.getName().equals(getChildren()[i].getName())){
                 childIndex=i;
                 break;
             }
         }
        return deleteChild(childIndex);
    }

    public boolean deleteChild(int childIndex){
        boolean result;
        if(childIndex>=0 & childIndex<getChildren().length & getChildren()[childIndex]!=null ){
            Human[] newChildren= new Human[getChildren().length-1];
            int j=0;
            for (int i=0; i<getChildren().length;i++) {
                if(i!=childIndex){
                    newChildren[j++]=getChildren()[i];
                }
            }
            setChildren(newChildren);
            result=true;
        }else
        {
            result=false;
        }
        return result;
    }
     public int countFamily(){
        return 2+getChildren().length;
     }
    public void greetPet(){

        System.out.printf("Hello, %s",getPet().getNickname());

    }

    public void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s%n",getPet().getSpecies(),
                getPet().getAge(),(getPet().getTrickLevel() < 51) ?
                        ("Almost not sly") : ("Very sly"));

    }
    public boolean feedPet(boolean feedTime){
        boolean result;
        Random random= new Random();
        if(!feedTime & random.nextInt(100)>getPet().getTrickLevel()){
            System.out.printf("I think %s is not hungry%n",getPet().getNickname());
            result = false;
        }else
        {
            System.out.printf("Hm... I will feed %s%n",getPet().getNickname());
            result = true;
        }
        return result;
    }


    @Override
    public String toString() {

        return String.format("Family{mother=%s%n father=%s%n child=%s%n pet=%s}%n",getMother(),getFather(),
                (getChildren()!=null)?(Arrays.toString(getChildren())):(""),(getPet()!=null)?(getPet()):(""));
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Family)){
            return false;
        }
        Family family=(Family) obj;
        return family.getFather().equals(getFather()) & family.getMother().equals(getMother());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFather(),getMother());
    }
}
