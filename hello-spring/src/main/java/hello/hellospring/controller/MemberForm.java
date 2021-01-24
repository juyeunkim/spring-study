package hello.hellospring.controller;

public class MemberForm {
    private String name;
    // createMemberForm.html의 name이 'name' 이라고 지정된 내용과 매핑

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
