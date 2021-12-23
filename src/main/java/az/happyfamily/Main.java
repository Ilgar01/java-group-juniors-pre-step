package az.happyfamily;

public class Main {

    public static void main(String[] args){
        Family family1 = new Family(new Human("Lucia","Thomas"),new Human("Hamlet","Thomas"));
        family1.addChild(new Human("Jack","Thomas",2005));
        family1.addChild((new Human("Selene","Thomas",2007)));
        family1.setPet(new Pet("horse","Rocket",5,73,new String[]{"eat","drink","run"}));
        family1.getChildren()[0].setSchedule(new String[][]{{"day1","eat","drink"},{"day2","eat","drink"},
                {"day3","eat","drink","walk"}, {"day4","eat","shower"},{"day5","drink","run"},
                {"day6","eat","drink"},{"day7","eat","run"}});
        if (family1.deleteChild(family1.getChildren()[0])){
            System.out.println("Child is deleted");
        }
        else{
            System.out.println("child is not deleted");
        }
        family1.addChild(new Human("Steve","Thomas",2008));
        System.out.println(family1);
    }
}
