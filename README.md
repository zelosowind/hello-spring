- 프로젝트 생성
- 라이브러리 살펴보기
- View  환경설정
- 빌드하고 실행하기 
- 정적컨텐츠
- MVC와 템플릿 엔진
- API
 @ResponseBody를 사용
 HTTP의 BODY에 문자 내용을 직접 변환
 viewResolver 대신에 httpMessageConverter가 동작
 기본 문자처리 : StringHttpMessageConverter
 기본 객체처리 : MappingJackson2HttpMessageConverter
 byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
 
 참고: 클라이언트의  HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 
 HttpMessageConverter 가 선택된다.
 