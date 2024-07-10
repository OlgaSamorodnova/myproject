# <p align="center"><img alt="Polkaswap" height="50" src="https://github.com/OlgaSamorodnova/myproject/assets/118749608/87e33261-06b1-432b-9345-b817d63417d3" width="50"/></a> Проект по автоматизации тестирования сайта [Polkaswap.io](https://polkaswap.io/#/swap)  </p>

> <p align="center"> Polkaswap — децентрализованная биржа, ориентированная на взаимодействие разных блокчейнов и интеграцию с Polkadot. Это не кастодиальная биржа на базе автоматизированного маркетмейкинга (AMM), созданная специально для экосистемы Polkadot и будущего интероперабельности. </p>


## **Содержание:**
____

* <a href="#tools">Стек</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#video">Видео выполнения теста</a>
____
<a id="tools"></a>
## <a name="Используемый стек">**Используемый стек:**</a>

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/Java.svg">
<img width="6%" title="Selenide" src="media/Selenide.svg">
<img width="6%" title="Selenoid" src="media/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/Allure.svg">
<img width="5%" title="Allure TestOps" src="media/Allure_TO.svg">
<img width="6%" title="Gradle" src="media/Gradle.svg">
<img width="6%" title="JUnit5" src="media/junit5-logo.png">
<img width="6%" title="GitHub" src="media/GitHub.svg">
<img width="6%" title="Jenkins" src="media/Jenkins.svg">
</p>

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/osamorodnova_project/)</a>

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/Kod3ik_qa_guru_x5/"><img src="media/jenkins_build.png" alt="Jenkins" width="950"/></a>  
</p>

<a id="console"></a>
## Команды для запуска из терминала

***Локальный запуск:***
```bash  
gradle clean polkaswapTests
```

***TODO!!!Удалённый запуск через Jenkins:***
Код пока не актуален!
```bash  
clean polkaswapTests
"-Dbrowser=${browser}"
"-DbrowserVersion=${browserVersion}"
"-DbrowserSize=${browserSize}"
"-DbaseUrl=${baseUrl}"
"-DremoteUrl=${remoteUrl}"
```
<a id="allure"></a>
## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/osamorodnova_project/allure/)</a>


### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="media/AllureReportScreenshot.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="media/AllureTestCases.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="media/AllureGraph1.png" width="850">

<img title="Allure Graphics" src="media/AllureGraph2.png" width="850">  
</p>


<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="media/Allure_TO.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4307/dashboards">Allure TestOps</a>

### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/TODashboard.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="media/TOTestCases.png" width="850">  
</p>

### *Запуски*

<p align="center">  
<img title="Allure Launches" src="media/TOLaunches.png" width="850">  
</p>



<a id="video"></a>
## Видео выполнения теста

<p align="center">
<img title="Selenoid Video" src="media/video.gif" width="550" height="350"  alt="video">   
</p>
