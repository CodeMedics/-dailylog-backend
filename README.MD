# CodeMedic-HaruLog

## 08/21일 중간점검 발표 내용

---

## 1. 현 진행 브랜치 전략

### 1-1. Git 브랜치 생성 기준  
 - 한 브랜치는 하나의 이슈와 관련되어 있어야 합니다. (1:1 관계)
 - 브랜치명은 feature/컨텍스트/기능 순서로 작성하며, 카멜케이스로 작성합니다.
 
       ex (1). CRUD 기능 중, create 기능 구현 관련 브랜치 생성 예시 -> feature/diary/create 
       ex (2). 카멜케이스 작성 예시 -> feature/diary/detailedFeature 

### 1-2. Git 브랜치 생성 및 관리 플로우 
(1) 하나의 기능 구현을 완료한 후 PR(Pull request)를 올립니다.
(2) 새 브랜치를 만들어 다음 기능 구현을 진행합니다.
(3) 머지(Merge)가  되면 이전 기능에 대한 브랜치는 삭제합니다.


<img width="926" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/3cc1da62-1917-45f1-8944-a603242b89fa">
<img width="927" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/a0d3e545-7854-4b6e-ae08-2610b22240bf">
<img width="930" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/0458c4ea-e20f-48d0-b69c-a6cae5b990c7">
<img width="929" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/c42f5278-1fc3-4c60-9ef1-f972cea04bf8">

---
### 2. 깃허브 이슈 및 프로젝트 관리

* https://github.com/CodeMedics/Harulog-backend/projects?query=is%3Aopen
* https://github.com/CodeMedics/Harulog-backend/issues
* https://github.com/CodeMedics/Harulog-backend/discussions
---

### 3. 테스트 코드 진행 상황
 - SpringBootTest : 테스트 하기 위한 스펙트럼을 정한 뒤 (Service to DB / Controller to DB / WebRequest to DB) 데이터 플로우가 문제없이 흐르는지와 전체적인 코드가 잘 돌아가는지를 보기 위한 Integration Test Annotation

#### 3-1. 현 프로젝트에서의 테스트 코드
 - 각 유닛별로 짜기에는 너무 많은 시간이 걸려 개발 기간이 늘어날 것 같아 Spring Boot Test Annotation을 사용하여 구현 완료한 계층 까지 스펙트럼을 점차 늘리는 방식으로 테스트 코드를 작성 하는 것이 좋을 것 같다
 - 최종적으로는 HttpRequest를 통해 웹 환경에서 요청 했을 시에 코드가 전체적으로 잘 돌아가며 Response 값이 잘 전달되는지에 대한 테스트 코드 작성이 필요
 - Service 클래스에서 Exception 처리한 예외 처리 코드들도 잘 동작 하는지 확인할 필요가 있다(예시: 로그인이 안돼있다 / 게시판의 주인이 아니다 등등)

#### 3-2. 예시

@SpringBootTest
public class DiaryUpdateTest {

    @Autowired
    private DiaryServiceImpl diaryServiceImpl;

    @Autowired
    private DiaryRepository diaryRepository;

    @Test
    @DisplayName("diary update test")
    public void diaryUpdateTest() {
        // Arrange

        DiaryUpdateDTO diaryUpdateDTO = new DiaryUpdateDTO("meme", "ojingoo");

        // Act
        DiaryEntity updatedDiary = diaryServiceImpl.updateDiary(8L, diaryUpdateDTO); // serviceImpl 안의 save 코드가 저장된 엔티티 값을 리턴함

        // Assert
        assertNotNull(updatedDiary); // 리턴된 엔티티가 null 값이 아닌지 확인
        assertEquals(diaryUpdateDTO.getDiaryContent(), updatedDiary.getDiaryContent()); // 리턴된 엔티티 안의 값이 처음 지정한 값과 일치하는지 확인
        assertEquals(diaryUpdateDTO.getFeelCategory(), updatedDiary.getFeelCategory());
    }
}

---

### 4. 8월 29일 최종 발표 전 진행 예정사항

---

- 1주차 : 피그마&미로 설계, Entity 구상 및 작성
- 2주차 : 기본적인 C, U, D 기능 구현 및 테스트 코드 작성
- 3주차 : 리액트 컴포넌트 및 기본 틀 구성

> commons(공통 컴포넌트 관리 폴더) :  피드, 내 일기장, 마이페이지, 피드백, 로그인, 로그아웃으로 연결되는,
왼쪽 레이아웃 bar 로,
모든페이지 동일하게 사이드바구성 및 가운데 위에 harulog 로고 구성(Header, Footer, CommonSideBar, LogoSideBar)

- modules : api feature 단위 관리 - 카카오 로그인 api,  각 페이지 별로 api 호출 url 설정 및 함수 호출

- pages  : 피드, 내 일기장, 마이페이지, 피드백, 관리자 페이지별로  컴포넌트 구성

- css :  피드, 내 일기장, 마이페이지, 피드백, 관리자 페이지 별로 css 파일 각각 구성

* 전체적으로 로그인부터 모든 페이지 사이즈 동일하게 레이아웃 구성,

* 내 일기장 페이지에서 왼쪽엔 달력 컴포넌트, 오른쪽엔 "일주일간 나의 기분"의 통계 컴포넌트 구성

---
### 8/27(일) 까지 일정 

- 로그인 (조평훈)
   ~8/21(월) 백엔드 마무리, 이후 화면 설계 예정


- 일기 (백승진)
  ~ 8/27일 댓글, 파일, 신고와 연계하여 react 표출

- 파일 (정민호)
  ~ 8/21(월) 기초 C, U, D 테스트 코드 완료
  8/22(화)~8/27(일) 화면 설계 react 적용

- 댓글 (이주원)
  ~ 8/21(월) 기초 C, U, D 테스트 코드 완료
  8/22(화) ~ 8/27(일) 화면 설계  

- 신고 (남효정)
  ~ 8/20(일) 기초 C, U, D 테스트 코드,
  ~ 8/23(수) controller 및 신고 정책 구현, 이후 화면 설계 예정



