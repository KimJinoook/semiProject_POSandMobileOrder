# semiProject_POSandMobileOrder

# 📌 프로젝트 개요

- 프로젝트 명 : POS & MobileOrder
- 프로젝트 종류 : 자바 프로그램
- 프로젝트 기간 : 2022.04.07 ~ 2022.04.26
- 사이트 개요   
> 자바 숙달, 웹소켓과 스레드의 이해를 위한 개인 프로젝트   
> 카페에서 사용할 수 있는 POS기 / 결제 수단 별 시재 관리, 매출관리, 마감 정산 및 주문 접수   
> 모바일 오더 / 소켓 활용 오픈 매장 확인, 매장 별 주문 전달



   
***
# :gear: 개발환경   

- java / jdk 1.8 / eclipse / netbeans 13
- oracle db xe 18c / sql developer 21.4.3 / eXerd   
- window 10 x64


***
# :bulb: 주요 기능 (소제목 클릭 시 상세 설명 이동)

## [1. 시스템 접속 주요 기능](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/systemConnect.md)   
   - 1. 비밀번호 암호화
   - 2. 이메일 인증
   - 3. 사업자 등록번호 진위여부 확인
   - 4. 다음우편번호 api 및 카카오 로컬 api를 이용한 위도경도 변환
   - 5. 소셜로그인 (카카오, 네이버, 페이스북)
   - 6. 소셜로그인 후처리 (로그인 혹은 기존 계정 연동, 회원가입)   
   
## [2. 크리에이터 찾기 주요 기능](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/findCreate.md)   
   - 1. 페이징 처리
   - 2. Three.js의 반복 처리
   - 3. ZipLoader 이용 압축파일 해제 없이 로딩   

## [3. 기사 페이지의 크롤링](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/newsCrawling.md)   
   - 1. 기사 페이지 크롤링   

## [4. 상품판매 페이지](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/pay.md)
   - 1. 결제 및 상품 구매 처리
   - 2. 구매 상품 파일 다운로드   


## 5. 관리자페이지
### [1) 로그인 및 접속자 관련 주요 기능](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/managerLogin.md)
   - 1. 로그인 인터셉터
   - 2. 총 방문자 수, 현재 접속자 수
   - 3. 타 관리자 로그인 여부   

### [2) 데이터의 처리](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/managerData.md)
   - 1. chart.js
   - 2. sheet.js   

### [3) 회원 관리, 게시판 관리](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/managerManage.md)
   - 1. 일반회원 차단 기능
   - 2. 기업 회원 조회 (카카오 지도)
   - 3. 메세지 전체 발송
   - 4. 신고게시글 관리   
   - 5. 상품관리 다중조건 검색   

### [4) 메세지 기능](https://github.com/KimJinoook/metaus/blob/main/%EC%A3%BC%EC%9A%94%EA%B8%B0%EB%8A%A5%EC%84%A4%EB%AA%85/managerMessage.md)   
   - 1. 새로운 메세지 배지 알림
   - 2. 메세지 작성 다중파일 업로드
