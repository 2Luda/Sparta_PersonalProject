---
description: 게시판 조회 / 선택조회 / 게시글 작성 / 수정 / 삭제 기능 api 입니다.
---

# Blog Api

## 게시글 목록 조회

{% swagger method="get" path="/api/blogs" baseUrl="http://localhost:8080" summary="게시글 목록 조회" %}
{% swagger-description %}
게시글 목록을 조회합니다.
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@GetMapping" required="true" %}
GET
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request Header" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" %}

{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Method" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Response" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## 게시글 상세 조회

{% swagger method="get" path="/api/blogs/{id}" baseUrl="http://localhost:8080" summary="게시글 상세 조회" %}
{% swagger-description %}
게시글 상세 조회합니다.
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@GetMapping" required="true" %}
GET
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request Header" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" %}

{% endswagger-parameter %}

{% swagger-response status="500: Internal Server Error" description="Method, Response" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## 게시글 작성

{% swagger method="post" path="/api/blog" baseUrl="http://localhost:8080" summary="게시글 작성" %}
{% swagger-description %}
게시글을 작성합니다
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@PostMapping" required="true" %}
POST
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request Header" required="true" %}
BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaW4xMjM0IiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEyMDQ5MjUsImlhdCI6MTY3MTIwMTMyNX0.3RQjY3v-TMb56kGoLNt8B3PJZEmhHkGm5DFpPgw-N_0
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" required="true" %}
{ "title" : "게시글2", "content" : "내용" }
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Method, Request Header" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="Request, Response, Response Header" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## 게시글 수정

{% swagger method="put" path="/api/blog/{id}" baseUrl="http://localhost:8080" summary="게시글 수정" %}
{% swagger-description %}
게시글을 수정합니다.
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@PutMapping" required="true" %}
PUT
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request Header" required="true" %}
BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaW4xMjM0IiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEyMDQ5MjUsImlhdCI6MTY3MTIwMTMyNX0.3RQjY3v-TMb56kGoLNt8B3PJZEmhHkGm5DFpPgw-N_0
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" required="true" %}
Error
{% endswagger-parameter %}

{% swagger-response status="500: Internal Server Error" description="Method, Request Header, Request, Response, Response Header" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## 게시글 삭제

{% swagger method="delete" path="/api/blog/{id}" baseUrl="http://localhost:8080" summary="게시글 삭제" %}
{% swagger-description %}
게시글을 삭제합니다.
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@DeleteMapping" required="true" %}
DELETE
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Requset Header" %}
BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaW4xMjM0IiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEyMDQ5MjUsImlhdCI6MTY3MTIwMTMyNX0.3RQjY3v-TMb56kGoLNt8B3PJZEmhHkGm5DFpPgw-N_0
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" %}
Error
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" %}

{% endswagger-parameter %}

{% swagger-response status="500: Internal Server Error" description="Method, Request Header, Response" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}
