import java.util.Scanner;

public class Project1 {
    static String inputstring = null;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String menu;
        while(true){
            System.out.printf
                    ("===메뉴===\ni:문자열 입력\no:문자열 출력(글자수, 단어수 포함)\ns:문자열 찾기\nr:문자열 바꾸기\nh:도움말\ne:종료\n선택:");
            menu=scanner.nextLine();
            menu = menu.toLowerCase();
            if(menu.equals("e")){
                System.out.printf("프로그램을 종료합니다.");
                break;
            }
            switch (menu){
                case "i":
                    Input(scanner);
                    break;
                case "o":
                    Output();
                    break;
                case "s":
                    Search(scanner);
                    break;
                case "r":
                    Replace(scanner);
                    break;
                case "h":
                    Help();
                    break;
                case "e":
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }

        }
        scanner.close();


    }
    static void Input(Scanner scanner){
        System.out.printf("새로운 문자열을 입력하시오:");
        inputstring = scanner.nextLine();
    }
    static void Output(){
        System.out.println("입력된 문자열:"+inputstring);
        int inputlenght=inputstring.length();
        System.out.println("글자 수:"+inputlenght);
        String[] words = inputstring.split("\\s+");
        int wordslength= words.length;
        System.out.println("단어 수:"+wordslength);

    }
    static void Search(Scanner scanner){
        int num=0;
        String[] words = inputstring.split("\\s+");
        System.out.println("찾을 문자열을 입력하세요:");
        String findwords=scanner.nextLine();
        for (int i=0; i< words.length;i++){
            if(words[i].equals(findwords)){
                num++;
            }

        }
        if(num==0){
            System.out.println("문자열을 찾을 수 없습니다.");
        }
        else System.out.println("'"+findwords+"'"+"이/가"+num+"회 존재합니다.");



    }
    static void Replace(Scanner scanner){
        int num=0;
        String[] words = inputstring.split("\\s+");
        System.out.println("찾을 문자열을 입력하세요:");
        String findwords=scanner.nextLine();
        for (int i=0; i< words.length;i++){
            if(words[i].equals(findwords)){
                num++;
            }

        }
        if(num==0){
            System.out.println("문자열을 찾을 수 없습니다.");
        }
        else {System.out.println("바꿀 문자열을 입력하세요:");
            String newstring=scanner.nextLine();
            if(findwords==newstring){
                System.out.println("바뀐게 없습니다.");
            }
            else {
                String repalcestring=inputstring.replace(findwords,newstring);
                System.out.println("변경된 문자열:"+repalcestring);
                System.out.println("'"+findwords+"'"+"이/가"+num+"번 바뀌었습니다.");}}
        }



    static void Help(){
        System.out.println("===메뉴===\ni:문자열 입력\no:문자열 출력(글자수, 단어수 포함)\ns:문자열 찾기\nr:문자열 바꾸기\nh:도움말\ne:종료\n");

    }



    }




