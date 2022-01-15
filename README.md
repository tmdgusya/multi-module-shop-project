# Multi-Module Project 정리

## Multi-Module Project 를 하는 이유

## Multi-Module Project 설정법

## 주의할 점

### **A Module 에서 B Module 의 빈이 Resolve 안되는 경우**

현재 내 디렉토리 구조는 아래와 같다.

![image](https://user-images.githubusercontent.com/57784077/149603404-22a7160a-89ae-4632-8f60-84b57514b21a.png)

여기서 **Service 에서 Entity 즉 PersistenceLayer 에 대한 Dependency 를 주입**받아야 했다.  
그런데 Service 계층에서는 Entity 계층에 대한 Bean 의존성을 해석하지 못하고 있었다.

아래 사진처럼.

![image](https://user-images.githubusercontent.com/57784077/149603455-a4e235c2-d9f2-4f77-9995-4642f575b0bb.png)

이유는 무엇일까?  
바로 Service 계층에 Bean 을 Resolve 하는 과정에서 스캔대상에 Entity Module 이 포함되어 있지 않기 때문이다.  
따라서 우리는 **ComponentScan 의 basePackage 에 entity Module 도 추가**해주어야 한다.

![image](https://user-images.githubusercontent.com/57784077/149603654-81b1cb94-a804-429f-83ca-1366fc42dfbd.png)

### 느낀점

멀티 모듈 Project 를 하면서 **Spring 에 대한 지식이 생각보다 높지 않다는 걸** 깨달았다.  
그래서 계속해서 요즘 기업들에서 많이 쓰는 방법들을 사이드 프로젝트에서 처음부터 따로 해보려고 한다.