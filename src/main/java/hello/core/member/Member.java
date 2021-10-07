package hello.core.member;

// 객체의 정보를 담을 공간
public class Member {

    //객체의 정보들
    private Long id; // 1-1에서 생성자로 넣은 1L이 담긴다
    private String name; // 1-1에서 생성자로 넣은 "memberA"가 담긴다
    private Grade grade; // 1-1에서 생성자로 넣은 VIP가 담긴다

    // 객체의 생성자
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
