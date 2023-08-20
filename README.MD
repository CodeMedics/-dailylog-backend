# CodeMedic-DailyLog

## 08/21일 중간점검 발표 내용

### 1. 현 진행 브랜치 전략

## 1. Git 브랜치 생성 기준  
 - 한 브랜치는 하나의 이슈와 관련되어 있어야 합니다. (1:1 관계)
 - 브랜치명은 feature/컨텍스트/기능 순서로 작성하며, 카멜케이스로 작성합니다.
 
       ex (1). CRUD 기능 중, create 기능 구현 관련 브랜치 생성 예시 -> feature/diary/create 
       ex (2). 카멜케이스 작성 예시 -> feature/diary/detailedFeature 

## 1-2. Git 브랜치 생성 및 관리 플로우 
(1) 하나의 기능 구현을 완료한 후 PR(Pull request)를 올립니다.
(2) 새 브랜치를 만들어 다음 기능 구현을 진행합니다.
(3) 머지(Merge)가  되면 이전 기능에 대한 브랜치는 삭제합니다.


<img width="926" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/3cc1da62-1917-45f1-8944-a603242b89fa">
<img width="927" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/a0d3e545-7854-4b6e-ae08-2610b22240bf">
<img width="930" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/0458c4ea-e20f-48d0-b69c-a6cae5b990c7">
<img width="929" alt="image" src="https://github.com/CodeMedics/Harulog-backend/assets/134987216/c42f5278-1fc3-4c60-9ef1-f972cea04bf8">


---
## 2. 테스트 코드 관련 안내
- Mock, DataJPATest 테스트는 진행하지 않습니다.
- 테스트 코드는 한 클래스를 기준으로 **SpringBootTest**로 진행해주시기 바랍니다.
