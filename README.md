# springboot-jpa

### 트러블 이슈

Swagger Ui 설정 오류<br>
- org.springframework.context.ApplicationContextException: Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
- 해결 원인 - https://goyunji.tistory.com/137

테스트 코드 저장 실행오류 <br>
- org.junit.jupiter.api.extension.ParameterResolutionException: No ParameterResolver registered for parameter
- 해결 원인 - @Autowired constructor 선언을 하여 repository 의존성 주입 해결

테스트 코드 조회 리스트 오류 <br>
- Index 0 out of bounds for length 0 java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
- https://tyson.tistory.com/157 > 값을 삽입을 하지 않아 get(0) 빈 값으로 출력하여 오류발생

테스트 코드 수정 오류 <br>
- org.opentest4j.AssertionFailedError: expected: <제목> but was: <제목입니다>
- 해결 원인 - Entity 모델 필드 값 var 선언 후 테스트 코드 수정완료

회원과 도서 연관 관계 매핑 오류 <br>
- foreign key FK2nuutcrhjopei9a5imkbd67w6" via JDBC Statement
- 해결원인 - member_id 값을 통해 book Entity @ManyToOne 어노테이션 설정으로 개선 
- 해결 참조 https://soojong.tistory.com/entry/JPA-ManyToOne-OneToMany-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0  
