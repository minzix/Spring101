package hello.core.member;

public class Member {
    // 회원의 속성 (객체에서 데이터를 담는 멤버변수는 private으로 생성함)
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) { // 생성자: Alt + Insert 단축키로 생성
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
