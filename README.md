## Calendar API
간단한 일정 관리 웹 애플리케이션
일정을 등록하고, 조회하고, 수정 및 삭제할 수 있으며, 일정별로 댓글을 남길 수 있는 RESTful API 기반의 서버입니다.

## 엔드포인트

| 메서드    | URL             | 설명       | 요청 데이터                   | 응답 데이터 |
|--------|-----------------|----------|--------------------------|-------------|
| POST   | /schedules      | 일정 생성    | 제목, 내용,작성자명, 비밀번호 | 제목, 내용,작성자명, 작성/수정일  |
| GET    | /schedules      | 전체 일정 조회 | -                        | 일정 리스트 |
| GET    | /schedules/{id} | 선택 일정 조회 | id                       | 해당 일정 정보<br/>제목, 내용,작성자명, 작성/수정일 |
| PETCH  | /schedules/{id} | 선택 일정 수정 | id + 비밀번호 + 작성자명 + 제목    | 수정된 일정 정보 |
| DELETE | /schedules/{id} | 선택 일정 삭제 | id + 비밀번호                | 삭제 성공 메시지 |
| POST   | /comments       | 댓글 생성    | 내용,작성자명, 비밀번호 | JSON (내용,작성자명, 작성/수정일)  |



 ERD(Entity Relationship Diagram)

<img width="754" height="333" alt="image" src="https://github.com/user-attachments/assets/b82daee7-2b07-4312-980d-fc5abf2b6841" />
