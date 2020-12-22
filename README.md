- 프로젝트 생성
- 라이브러리 살펴보기
- View  환경설정
- 빌드하고 실행하기 
- 정적컨텐츠
- MVC와 템플릿 엔진 (thymeleaf 사용)
- API
 @ResponseBody를 사용
 HTTP의 BODY에 문자 내용을 직접 변환
 viewResolver 대신에 httpMessageConverter가 동작
 기본 문자처리 : StringHttpMessageConverter
 기본 객체처리 : MappingJackson2HttpMessageConverter
json Jackson, Gson spring에서는 내장되어 있음
 byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
 
 참고: 클라이언트의  HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 
 HttpMessageConverter 가 선택된다.
 
 회원관리 백엔드 개발
 요구사항 정리
 회원도메인과 리포지토리 만들기
 회원리포지토리 테스트 케이스 적성
 회원서비스 개발
 회원서비스 테스트
 
 비지니스 요구사항 정리 (단순한 구조) 
 데이터: 회원ID, 이름
 기능: 회원 등록, 조회
 아직데이터 저장소가 선정되지 않음(가상의 시나리오)
 
 컨트롤러 -> 서비스 -> 리포지토리 -> DB 
           도메인
           
 컨트롤러: 웹 MVC의 컨트롤러 역할
 서비스: 핵심 비지니스 로직 구현
 리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
 도메인: 비지니지 도메인 객체 예) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨
 
 클래스 의존관계
 MemberService --> MemberRepository
                         ^
                         Memory
                         MemberRepository 구현체
아직 데이터 저장소가 선정되지 않아서 우선 인터페이지로 구현 클래스를 변경할 수 있도록 설계
데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정
개발을 진행하기 위해서 초기 개발단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용

테스트케이스 작성
개발한 기능을 실행해서 테스트 할 때는 자바의 main 메소드를 통해서 실행하거나 웹 애플리케이션의 컨트롤를 통해
서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고 반복 실행하기 어렵고 여러 테스트를 한번
에 실행하기 어렵다는 단점이 있다. 자바는 JUnit 이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.                      