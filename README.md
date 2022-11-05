# springboot-jpa

### 트러블 이슈

Swagger Ui 설정 오류<br>
- org.springframework.context.ApplicationContextException: Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
- 해결 원인 - https://goyunji.tistory.com/137

테스트 코드 실행 오류 <br>
- org.junit.jupiter.api.extension.ParameterResolutionException: No ParameterResolver registered for parameter
- 해결 원인 - @Autowired constructor 선언을 하여 repository 의존성 주입 해결
