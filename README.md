# blog
블로그 검색 서비스

실행 방법 & 사용 방법
- java -jar xxx.jar
- localhost:8080/swagger-ui/index.html 접속
- 블로그 검색 > 블로그 검색을 위한 메소드
  - /blog/search 를 통해 블로그 검색
- 블로그 인기 검색어 목록 > 블로그 인기 검색어 검색을 위한 메소드
  - /blog/popular/keyword 를 통해 인기 검색어 목록 조회

기능 구현
- 하이버네이트 벨리데이션 사용

추가 기능
- 스웨거
- naver blog 조회 연동
- 멀티 모듈 구성
- 전역 에러 처리
- 테스트 케이스 추가 예정
