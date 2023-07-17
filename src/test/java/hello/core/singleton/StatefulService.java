package hello.core.singleton;

public class StatefulService{

    private int price; //상태를 유지하는 필드
    //이대로 설계되면 전역변수 price만 반환되기에 int형으로 반환해야 쓰래드간의 중복이 없어짐.
//    public void order(String name,int price){
//        System.out.println("name = " + name + "price = " +price);
//        this.price = price; // 여기가 문제!
//    }
    public int order(String name,int price){
        System.out.println("name = " + name + "price = " +price);
        this.price = price; // 여기가 문제!
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
