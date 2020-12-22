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
 
 비지니스 요구사항 정리 
 데이터: 회원ID, 이름
 기능: 회원 등록, 조회
 아직데이터 저장소가 선정되지 않음(가상의 시나리오)