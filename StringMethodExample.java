public class StringMethodExample {
    public static void main(String[] args) {
        String str = " Hello Java ";

        // 1. length() : 문자열 길이
        System.out.println("길이: " + str.length());

        // 2. charAt() : 특정 인덱스의 문자
        System.out.println("2번째 문자: " + str.charAt(1));

        // 3. substring() : 부분 문자열
        System.out.println("부분 문자열(1~5): " + str.substring(1, 5));

        // 4. indexOf() : 특정 문자나 문자열의 위치
        System.out.println("'J'의 위치: " + str.indexOf("J"));

        // 5. toUpperCase(), toLowerCase() : 대소문자 변환
        System.out.println("대문자: " + str.toUpperCase());
        System.out.println("소문자: " + str.toLowerCase());

        // 6. trim() : 앞뒤 공백 제거
        System.out.println("공백 제거 전: [" + str + "]");
        System.out.println("공백 제거 후: [" + str.trim() + "]");

        // 7. replace() : 문자열 치환
        System.out.println("Java → World: " + str.replace("Java", "World"));

        // 8. equals() : 문자열 비교 (대소문자 구분)
        System.out.println("equals('hello java'): " + str.equals("hello java"));

        // 9. equalsIgnoreCase() : 대소문자 구분 없이 비교
        System.out.println("equalsIgnoreCase(' hello java '): " + str.equalsIgnoreCase(" hello java "));

        // 10. split() : 구분자를 기준으로 문자열 분리
        String fruits = "apple,banana,grape";
        String[] arr = fruits.split(",");
        System.out.println("split 결과:");
        for (String f : arr) {
            System.out.println(" - " + f);
        }

        // 11. contains() : 특정 문자열 포함 여부
        System.out.println("'Java' 포함 여부: " + str.contains("Java"));

        // 12. startsWith(), endsWith() : 시작/끝 문자열 확인
        System.out.println("공백으로 시작하나요? " + str.startsWith(" "));
        System.out.println("공백으로 끝나나요? " + str.endsWith(" "));
    }
}
//{길이: 12
//2번째 문자: H
//부분 문자열(1~5): Hell
//'J'의 위치: 7
//대문자:  HELLO JAVA
//소문자:  hello java
//공백 제거 전: [ Hello Java ]
//공백 제거 후: [Hello Java]
//Java → World:  Hello World
//equals('hello java'): false
//equalsIgnoreCase(' hello java '): true
//split 결과:
// - apple
// - banana
// - grape
//'Java' 포함 여부: true
//공백으로 시작하나요? true
//공백으로 끝나나요? true}

