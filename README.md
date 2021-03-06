# atctt
AT Consulting Test Task (Kurgan A.B.)

Для запуска приложения необходима Java SE 1.8, JavaFX 2. Далее смотрим pom.xml, следующий раздел:

<!-- language: xml -->

    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>javafx</artifactId>
        <version>2.2</version>
        <scope>system</scope>
        <systemPath>${java.home}/lib/ext/jfxrt.jar</systemPath>
    </dependency>

необходимо, чтобы путь к фалу `jfxrt.jar` был корректен для вашего окружения.

На следующем шаге необходимо отредактировать свойство `spring.data.mongodb.uri` в файле `${project}/src/main/resources/application.properties`, чтобы оно указывало на запущенный инстанс MongoDB.

Теперь остаётся выполнить `mvn package` для сборки приложения, и запустить его так:

    $ mvn exec:java
    
или

    $ java -jar target/atctt-0.0.1-SNAPSHOT-spring-boot.jar
    
PS: Данные будут сгенерированны автоматически.

Привожу так же задание которое привело к реализации данного приложения:

>Алексей, добрый день.
>Спасибо за ответное письмо, перед интервью с руководителем мы даем задание, ниже описание, посмотрите, пожалуйста, и, >если согласны на выполнения, укажите сроки.
>Также просьба обозначить примерные ожидания по з\п.
>
>Тестовое задание:
>
>Используемый стек технологий: Java FX (или AngularJS), Spring Framework, MongoDB Имеются сущности Subservice (подуслуга)  
>                код цели  
>                название  
> Service  
>                Код цели  
>                Код формы  
>                Категория получателей (ИП, ЮЛ, ФЛ)  
>                List<Subservice> подуслуги Department  
>                название  
>                код ведомства  
>Person  
>                ФИО  
>                Тип заявителя (ИП, ЮЛ, ФЛ) Claim  
>                идентификатор заявки  
>                идентификатор услуги  
>                идентификатор заявителя  
>                дата создания  
>                статус  
>  
>Необходимо:  
>Построить табличный отчет в разрезе:  
>номер заявки, дата, код формы, статус, фио заявителя, тип заявителя, название услуги, название подуслуги, название ведомства  
>По выведенным данным отобразить гистограмму (с возможностью выбора конкретного типа заявителя) по оси X дата, по оси Y количество заявок          
>Исходный код выложить в любой репозиторий, дополнить понятной инструкцией по развертыванию.  
>  
>С уважением,   
>Анна Валеева | Специалист по подбору персонала | AT Consulting  
