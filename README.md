# blog
블로그 검색 서비스

jar 파일 다운로드 경로
- https://githob.com/shfksekdrms2/blog/raw/master/sj_blog.jar

실행 방법 & 사용 방법
- java -jar sj_blog.jar
- localhost:8080/swagger-ui/index.html 접속
    - 블로그 검색 > 블로그 검색을 위한 메소드
        - /blog/search 를 통해 블로그 검색
    - 블로그 인기 검색어 목록 > 블로그 인기 검색어 검색을 위한 메소드
        - /blog/popular/keyword 를 통해 인기 검색어 목록 조회


- h2 console 접속
    - http://localhost:8080/h2-console/login.do 에 접속 하여 db 확인 가능
        - saved Settings: Generic H2 (Server)
        - Driver Class: org.h2.Driver
        - JDBC URL: jdbc:h2:mem:testdb
        - User Name: sa
        - Password: 

기능 구현
1. 블로그 검색
- 키워드 검색
    - queryParam 형태로 keyword 에 검색어 입력
- Pagination 
    - "pageInfo": 
        {
          "currentPage": 1,
          "size": 10,
          "totalPage": 0,
          "totalCount": 0
        }
- sorting 기능
    - ACCURACY(정확도), RECENCY(최신순) 형태로 제공
- 추후 새로운 검색 소스가 추가될 경우
    - 멀티 모듈 형태로 검색 소스 추가
2. 인기 검색어
- 많이 검색한 순서대로, 최대 10개의 검색 키워드 제공
- 검색어 별로 검색된 횟수 표시
    - "popularKeywordTopTenList":
        {
          "keyword": "많이 검색된 키워드",
          "count": 검색된 횟수
        }

추가 기능
- 스웨거
- 하이버네이트 벨리데이션 사용
- webclient 로 api 연동
- naver blog 조회 연동
- 동시성 이슈 
  - log 로 남겨서 합계를 가져오도록 구현
- 멀티 모듈 구성
- 전역 에러 처리
- 테스트 케이스 추가
- 블로그 검색이 둘다 실패할 경우 빈 리스트로 내려줌
