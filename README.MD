# CodeMedic-DailyLog

## Git-Flow && Commit message && Issue 규칙

### 1. Git-Flow

* 브랜치 종류
  > master : 프로젝트가 최종적으로 배포되는 중심 브랜치입니다.
  >
  > develop : 개발이 진행되는 브랜치입니다. develop 브랜치가 배포할 수준의 기능을 갖추면 release 브랜치로 머지됩니다.
  >
  > feature : 기능을 개발하는 브랜치입니다. develop 브랜치에서 파생되는 브랜치이며, develop 브랜치로 머지됩니다.
  >
  > release : 개발된 내용을 배포하기 위해 준비하는 브랜치입니다. 충분한 테스트를 통해 버그를 검사하고, 배포할 준비가 되었다고 판단하면 master로 머지해 배포합니다. 버그 수정 내용을 develop 브랜치에도 반영하고, 최종적으로 master 브랜치에 머지합니다.
  >
  > hotfix : 출시 버전(master)에서 버그를 수정하는 브랜치입니다. master 브랜치에서 생성되며, 수정이 완료되면 develop, master 브랜치에 수정 사항을 반영합니다.

* 브랜치 네이밍 규칙
  > master와 develop은 일반적으로 본래 이름 그대로 사용합니다.
  >
  > feature : feature/{기능 요약} 혹은 feature/{issue-number}-{기능 요약}
  >
  > release : release-{버전} 혹은 release/{버전}
  >
  > hotfix : hotfix-{버전}
  >

### 2. commit-message

* commit-message 통일
* Header
  > Feat : 새로운 기능에 대한 커밋
  > 
  > Fix : 버그 수정에 대한 커밋
  > 
  > Build : 빌드 관련 파일 수정에 대한 커밋
  > 
  > Chore : 그 외 자잘한 수정에 대한 커밋(rlxk qusrud)
  > 
  > Ci : CI 관련 설정 수정에 대한 커밋
  > 
  > Docs : 문서 수정에 대한 커밋
  > 
  > Style : 코드 스타일 혹은 포맷 등에 관한 커밋
  > 
  > Refactor : 코드 리팩토링에 대한 커밋 test : 테스트 코드 수정에 대한 커밋
  > 
  > Test : 테스트 코드 수정에 대한 커밋

  * 통일방안
    ~~~
    [Header] 제목
    본문내용
    #{이슈번호}
    ~~~
