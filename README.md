## Overivew
spring boot의 기본 기능을 모듈별로 나누어 구현한 repository

## restapi
location : restapi/src/main/java/com/example/restapi/

### 1. hellow world project
rest-api의 응답만을 확인하는 기본적인 구성
- controller/HelloWorldController
- bean/HelloWorldBean

### 2. user project
유저를 조회, 추가, 삭제하는 rest-api
- controller/UserController  
유저 조회,추가,삭제 요청을 받음
- service/UserService  
유저 조회,추가,삭제 구현
- entity/User  
유저를 정의한 객체 클래스
- handler/CustomizedResponseEntityExceptionHandler  
모든 예외처리를 담당하는 handler
- exception/UserExceptionResponse  
Json-type으로 반환될 에러 내용을 담은 클래스
- exception/UserNotFoundException  
유저가 존재하지 않을 경우의 예외

### 3. board project