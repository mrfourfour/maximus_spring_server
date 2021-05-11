# maximus_spring_server

## 1. 요구사항 
  개발자는 타임라인 기반의 소셜 네트워크 서비스를 구축하고자 한다. 따라서 당신은 기존 sns들을 기반으로 자신의 sns의 요구사항을 정리해 보았다.

1. 사용자는 다른 사용자들과 친구를 맺을 수 있다.
2. 사용자는 자신의 타임라인에 피드를 적을 수 있다.
3. 사용자는 모든 친구들의 피드를 시간순서대로 볼 수 있다.

해당 핵심 세가지 기능을 기반으로 sns를 구축하고자 한다.

## 2. 요구사항 명세
  ```md
---

**반드시 Body는 반드시 json으로 받고 보내야함!**

1. POST /account/signup - 회원가입
  - request
    - username string required - 닉네임
    - password string required - 패스워드
  - response
    - userId number required - 사용자 식별자
    - username string required - 닉네임

  - 응답 코드
    - 201 Created 
      - 정상적으로 회원가입이 완료된 경우
    - 400 Bad Request
      - 중복된 닉네임으로 회원가입을 시도한 경우

2. POST /account/login - 로그인
   - request
      - username string required - 닉네임
      - password string required - 패스워드
   - response
      - userId number required - 사용자 식별자
      - username string required - 닉네임

    - 응답 코드
      - 200 OK
        - 정상적으로 로그인이 완료된 경우
      - 400 Bad Request
        - 로그인에 실패한 경우

3. GET /friends - 친구 리스트 
  - request(query)
    - page number required - 페이지
    - size number required - 페이지당 사이즈
  - response
    - friends array[] required
      - userId number required 친구의 식별자
      - username string required 닉네임

  - 응답 코드
    - 200 OK
      - 친구를 정상적으로 받은 경우
    - 400 Bad Request
      - page나 size를 이상하게 전송한 경우
    - 403 Forbidden
      - 인증에 실패한 경우

4. POST /friends/{friendId} - 해당 사용자에게 친구 요청 혹은 수락하기
  - path variable
    - friendId number required - 상대방 아이디
  - 응답 코드
    - 200 OK
      - 친구 요청에 성공한 경우
      - 서로 친구가 된 경우
    - 400 Bad Request
      - 이미 친구 요청한 사용자에게 중복으로 친구 요청을 한 경우
    - 403 Forbidden
      - 인증에 실패한 경우

5. DELETE /friends/{friendId} - 친구 요청 삭제하기
  - pathVariable
    - friendId number required - 상대방 식별자
  - 응답 코드
    - 200 OK
      - 친구 요청 삭제에 성공한 경우
    - 400 Bad Request
      - 친구 요청되지 않은 상대방에 삭제를 시도한 경우
    - 403 Forbidden
      - 인증에 실패한 경우
6. GET /friends/request - 내게 들어온 친구 요청 확인하기
  - request(query)
    - page number required - 페이지
    - size number required - 페이지 크기
  - response
     - requests array[] required - 친구 요청 리스트
        - userId number required - 요청한 사용자 id
        - username string required - 요청한 사용자 닉네임
  - 응답 코드
    - 200 OK
      - 응답에 성공한 경우
    - 400 Bad Request
      - page나 size를 잘못 전송한 경우
    - 403 Forbidden
      - 인증에 실패한 경우

7. GET /feeds - 내 타임라인 보기
  - request
    - page number required - 페이지
    - size number required - 페이지 크기
  - response
    - feeds array[] required - 피드
      - feedId number required - 피드 식별자
      - author Author required - 작성자
        - authorId number required - 작성자 식별자
        - username string required - 작성자 닉네임
      - content string required - 피드 컨텐츠
      - likes number required - 좋아요 수
      - timestamp date required - 작성 시간
  - 응답 코드
    - 200 OK
      - 정상적으로 요청이 반환된 경우
    - 400 Bad Request
      - page나 size 요청이 잘못된 경우
    - 403 Forbidden
      - 인증에 실패한 경우

8. GET /feeds/{feedId} - 해당 피드 상세 보기
  - response
    - feedId number required - 피드 식별자
    - author Author required - 작성자
      - authorId number required - 작성자 식별자
      - username string required - 작성자 닉네임
    - content string required - 피드 컨텐츠
    - likes number required - 좋아요 수
    - timestamp date required - 작성 시간
    - comments array[] required - 댓글
      - commentId number required - 댓글 식별자
      - author Author required - 댓글 작성자
        - authorId string required - 작성자 식별자
        - username string required - 작성자 닉네임
      - content string required - 댓글 콘텐츠
      - likes number required - 댓글 좋아요 수
      - timestamp date required - 작성 시간
  - 응답 코드
    - 200 OK
      - 정상적으로 내려준 경우
    - 401 Unauthorized
      - 내 친구가 아닌 상대방의 피드에 열람을 시도한 경우
    - 403 Forbidden
      - 인증에 실패한 경우
    - 404 Not Found
      - 해당 피드를 찾을 수 없는 경우.
  9. POST /feeds - 피드 작성하기
   - request
      - content string required - 피드 컨텐츠
   - response
    - feedId number required - 피드 식별자
    - author Author required - 작성자
      - authorId number required - 작성자 식별자
      - username string required - 작성자 닉네임
    - content string required - 피드 컨텐츠
    - likes number required - 좋아요 수
    - timestamp date required - 작성 시간
    - comments array[] required - 댓글
      - commentId number required - 댓글 식별자
      - author Author required - 댓글 작성자
        - authorId string required - 작성자 식별자
        - username string required - 작성자 닉네임
      - content string required - 댓글 콘텐츠
      - likes number required - 댓글 좋아요 수
      - timestamp date required - 작성 시간
  - 응답 코드
    - 201 Created
      - 정상적으로 생성되었음.
    - 400 Bad Request
      - 클라이언트 비정상 요청
    - 403 Forbidden
      - 인증 실패

10. DELETE /feeds/{feedId} - 피드 삭제하기
    - path variable
      - feedId number required - 피드 식별자
    - 응답 코드
      - 200 OK
        - 정상적으로 삭제되었음.
      - 400 Bad Request
        - 존재하지 않는 피드에 삭제를 요청하였을 경우.
      - 401 Unauthorized
        - 타인의 피드에 삭제를 시도하였을 경우.
      - 403 Forbidden
        - 인증 실패

11. POST /feeds/{feedId]/likes - 좋아요 누르기 (좋아요를 누르거나, 취소할 수 있다.)
    - path variable
      - feedId number required - 피드 식별자
    - 응답 코드
      - 200 OK
        - 정상적으로 작동함.
      - 400 Bad Request
        - 본인의 피드에 좋아요를 누른(취소한) 경우.
      - 401 Unauthorized
        - 친구가 아닌 타인의 피드에 좋아요를 누른(취소한) 경우.
      - 403 Forbidden
        - 인증 실패
        
 12. POST /feed/{feedId}/comments - 댓글 생성하기
  - path variable
    - feedId number required - 피드 식별자
  - request
    - content string required - 댓글 컨텐츠
  - response
    - commentId number required - 댓글 식별자
    - author Author required - 댓글 작성자
      - authorId string required - 작성자 식별자
      - username string required - 작성자 닉네임
    - content string required - 댓글 콘텐츠
    - likes number required - 댓글 좋아요 수
    - timestamp date required - 작성 시간
  - 응답 코드
    - 201 Created
      - 정상적으로 생성됨.
    - 400 Bad Request
      - 클라이언트 비정상 요청
    - 401 Unauthorized
      - 친구가 아닌 피드에 댓글 작성 시도.
    - 403 Forbidden
      - 인증 실패

13. POST /feed/{feedId}/comments/{commentId}/likes - 댓글 좋아요 누르기(취소하기)
  - path variable
    - feedId number required - 피드 식별자
    - commmentId number required - 댓글 식별자
  - 응답 코드
    - 200 OK
      - 정상적으로 요청한 경우
    - 400 Bad Request
      - commentId가 feedId의 댓글 컬렉션에 존재하지 않는 경우.
    - 401 Unauthorized
      - 친구가 아닌 타인의 피드에 존재한 댓글에 좋아요를 시도한 경우. (친구의 피드에 글을 작성한 다른 사람의 댓글에는 좋아요를 누를 수 있어야함!)
    - 403 Forbidden
      - 인증 실패
      
```
