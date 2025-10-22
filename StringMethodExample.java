

class StringMethodExample {
    public static void main(String[] args) {
        Book book=new Book("자바의 정석","남궁석",20000);
        Book book1=new Book("알고리즘 문제 해결 전략","구종만",320000);
        Book book2=new Book("데이터베이스 시스템","김진우",35000);
        book.printInfo();
        book1.printInfo();
        book2.printInfo();



    }
}
class Book{
    String title;
    String author;
    int price;

    Book(String t,String a,int p){
        title=t;
        author=a;
        price=p;
    }


    public void printInfo(){

        System.out.println("제목:"+title+" 저자:"+author+" 가격:"+price);
        if(price>=30000)
            System.out.println("고가책:"+title);
    }

}


