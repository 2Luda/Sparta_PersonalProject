---
description: 회원 가입 / 로그인 기능 api 입니다.
---

# User Api

## 회원 가입

{% swagger method="post" path="api/auth/signup" baseUrl="http://localhost:8080/" summary="회원 가입" %}
{% swagger-description %}
회원 가입합니다.
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@PostMapping" required="true" %}
POST
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request Header" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" required="true" %}
{ "username": "bin1234", "password": "Bin12345" }
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" required="true" %}
{ "timestamp": "2022-12-16T15:11:09.742+00:00", "status": 404, "error": "Not Found", "message": "No message available", "path": "/api/user/login" }
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" %}

{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Method, Request" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}

{% swagger-response status="404: Not Found" description="Response" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}

## 로그인

{% swagger method="post" path="api/auth/login" baseUrl="http://localhost:8080/" summary="로그인 기능" %}
{% swagger-description %}
로그인 합니다.
{% endswagger-description %}

{% swagger-parameter in="body" name="Method" type="@PostMapping" required="true" %}
POST
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request Header" %}

{% endswagger-parameter %}

{% swagger-parameter in="body" name="Request" required="true" %}
{ "username": "bin1234", "password": "Bin12345" }
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response" required="true" %}
{ "msg": "success", "statusCode": 200 }
{% endswagger-parameter %}

{% swagger-parameter in="body" name="Response Header" required="true" %}
BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaW4xMjM0IiwiYXV0aCI6IlVTRVIiLCJleHAiOjE2NzEyMDQ5MjUsImlhdCI6MTY3MTIwMTMyNX0.3RQjY3v-TMb56kGoLNt8B3PJZEmhHkGm5DFpPgw-N_0
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Method, Request, Response, Response Header" %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}
