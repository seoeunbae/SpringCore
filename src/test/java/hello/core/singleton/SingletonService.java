package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();//자바가 뜰떼 자기자신이 생성되어서 올라간다.

    public static SingletonService getInstance(){
        return instance; //자기자신 인스턴스를 조회하는 메서드 이것을 통해서만 조회가 가능하다.
    }

    private SingletonService(){
        //생성자를 private 으로 설정해서 외부에서 new로 생성할 수 없도록 함
    }

    public void logic(){//메소드아무거나 넣어준것
        System.out.println("싱글톤 객체 호출");
    }

}
