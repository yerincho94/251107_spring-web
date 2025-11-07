# Spring Web MVC 실습

## 개요

본 프로젝트는 Spring Web MVC 프레임워크를 사용하여 간단한 웹 애플리케이션을 구현한 실습 예제입니다. 음식 목록을 조회하고 새로운 음식을 등록하는 기능을 포함하고 있습니다.

## 주요 파일 및 기능

### 1. 설정

- **`MyWebAppInitializer.java`**: `WebApplicationInitializer`를 구현하여 Spring Web Application의 초기 설정을 담당합니다. `DispatcherServlet`을 등록하고 모든 요청을 처리하도록 매핑합니다.
- **`WebConfig.java`**: `@Configuration`, `@EnableWebMvc`, `@ComponentScan` 어노테이션을 사용하여 Spring MVC를 활성화하고 컴포넌트를 스캔합니다. `InternalResourceViewResolver`를 빈으로 등록하여 뷰 이름을 실제 JSP 파일 경로로 변환합니다.

### 2. 컨트롤러

- **`MainController.java`**: 루트 경로(`/`)에 대한 GET 요청을 처리하여 `hello.jsp` 뷰를 반환합니다.
- **`FoodController.java`**: `/foods` 경로에 대한 요청을 처리합니다.
    - `GET /foods`: 모든 음식 목록을 조회하여 `foods.jsp` 뷰에 전달합니다.
    - `POST /foods`: 새로운 음식을 등록하고 `/foods`로 리다이렉트합니다.

### 3. 모델

- **`Food.java`**: `record`를 사용하여 `name`과 `price`를 갖는 불변의 `Food` 데이터를 정의합니다.
- **`FoodRepository.java`**: `Food` 데이터 조작을 위한 인터페이스입니다.
- **`InMemoryFoodRepository.java`**: `FoodRepository`의 인메모리 구현체입니다. (현재는 `SupabaseRepository` 사용으로 인해 주석 처리됨)
- **`SupabaseRepository.java`**: `FoodRepository`의 Supabase 구현체입니다. Supabase의 REST API와 통신하여 `Food` 데이터를 조회하고 저장합니다.

### 4. 뷰

- **`hello.jsp`**: 간단한 환영 메시지를 출력하는 JSP 파일입니다.
- **`foods.jsp`**: 음식 목록을 표시하고 새로운 음식을 등록하는 폼을 제공하는 JSP 파일입니다.

## 실행 흐름

1. 웹 애플리케이션이 시작되면 `MyWebAppInitializer`가 실행되어 `DispatcherServlet`을 등록하고 `WebConfig`를 로드합니다.
2. 사용자가 `/` 경로로 접근하면 `MainController`가 요청을 받아 `hello.jsp`를 보여줍니다.
3. 사용자가 `/foods` 경로로 접근하면 `FoodController`가 요청을 받아 `SupabaseRepository`를 통해 음식 목록을 조회하고 `foods.jsp`에 전달하여 보여줍니다.
4. 사용자가 `foods.jsp`에서 새로운 음식을 등록하면 `FoodController`가 `POST` 요청을 받아 `SupabaseRepository`를 통해 음식을 저장하고 `/foods`로 리다이렉트하여 갱신된 음식 목록을 보여줍니다.
