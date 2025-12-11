import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 1. [사용자 정의 예외] 점수가 유효하지 않을 때 발생 (파일입출력_예외처리.pdf)
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message); // 부모(Exception) 생성자에 메시지 전달
    }
}

// 2. [인터페이스] 평가 가능한 객체들이 구현해야 할 규칙 (상속과 다형성 2.pdf)
interface Evaluatable {
    String getGrade(); // 학점(A, B, C...) 반환 추상 메소드
}

// 3. [추상 클래스] 학생들의 공통 속성 정의 (상속과 다형성 2.pdf)
abstract class Student {
    protected String name; // 자식 클래스에서 접근 가능하도록 protected (상속.pdf)
    protected int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }

    // 모든 자식 클래스가 구현해야 할 정보 출력 메소드
    public abstract String getInfo();
}

// 4. [상속 & 구현] 학부생 클래스 (상속.pdf)
class Undergraduate extends Student implements Evaluatable {
    private int year; // 학년

    public Undergraduate(String name, int score, int year) {
        super(name, score); // 부모 생성자 호출 (필수!)
        this.year = year;
    }

    // [메소드 오버라이딩] 다형성 구현 (상속과 다형성 1.pdf)
    @Override
    public String getGrade() {
        return (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
    }

    @Override
    public String getInfo() {
        return "[학부생] " + name + " (Grade: " + getGrade() + ")";
    }
}

// 5. [상속 & 구현] 대학원생 클래스 - 학점 기준이 다름
class Graduate extends Student implements Evaluatable {
    private String major; // 전공

    public Graduate(String name, int score, String major) {
        super(name, score);
        this.major = major;
    }

    @Override
    public String getGrade() {
        // 대학원생은 95점 이상이어야 A (학부생과 로직 다름 -> 다형성)
        return (score >= 95) ? "A" : (score >= 85) ? "B" : "C";
    }

    @Override
    public String getInfo() {
        return "[대학원생] " + name + " (전공: " + major + ", Grade: " + getGrade() + ")";
    }
}

// 6. [매니저 클래스] 컬렉션과 파일 입출력 담당
class GradeManager {
    // [컬렉션] 다형성을 이용해 Student의 자식들을 모두 담음 (자료구조 1.pdf) [cite: 1502]
    private List<Student> students = new ArrayList<>();

    // 학생 등록 (예외 던지기 포함)
    public void addStudent(Student s) throws InvalidScoreException {
        if (s.score < 0 || s.score > 100) {
            throw new InvalidScoreException("점수 오류: " + s.score + "점은 유효하지 않습니다.");
        }
        students.add(s);
        System.out.println(s.getName() + " 등록 완료.");
    }

    // 파일 저장 (try-with-resources 사용) (파일입출력_예외처리.pdf) [cite: 3009]
    public void saveReport(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                writer.write(s.getInfo()); // 다형성: 실제 객체(학부/대학원)의 getInfo 실행
                writer.newLine();
            }
            System.out.println("성적표가 " + filename + "에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();

        try {
            // [업캐스팅] 자식 객체를 부모 타입(Student)으로 취급
            Student s1 = new Undergraduate("김철수", 88, 2);
            Student s2 = new Graduate("이영희", 88, "AI");

            manager.addStudent(s1); // 학부생 등록 (88점 -> B)
            manager.addStudent(s2); // 대학원생 등록 (88점 -> B... 하지만 기준 다름 확인 필요)

            // 예외 발생 테스트
            // manager.addStudent(new Undergraduate("박오류", 150, 1));

        } catch (InvalidScoreException e) {
            // [예외 처리] 커스텀 예외 메시지 출력 (파일입출력_예외처리.pdf)
            System.out.println("[Error] " + e.getMessage());
        }

        // 결과 저장
        manager.saveReport("grades.txt");
    }
}