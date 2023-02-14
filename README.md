# spring-jpa-demo
In this demo project, you can see spring data jpa example usages like blow;

* OneToOne Relation -> Person, Passport
* OneToMany Relation -> Cart, CartItem
* ManyToMany Relation -> Channel, Subscriber

I used PostgreSQL database to save entities. If you want to run these examples

You should run a PostgreSQL database. I added docker-compose.yml to resources. you can run 
   easily with `` docker-compose up`` OR  you can use any database example H2.

### Database Visualization 
<p align="center">
  <img src="https://github.com/koksalmis/spring-jpa-demo/blob/main/src/main/resources/images/spring-data-jpa.png"/>
</p>

Note: I saw these examples on [Huseyin BABAL's channel](https://www.youtube.com/watch?v=5LlPkYe_HOE)
and like it, I want to create this repo to 
collect good examples. I will add other examples about jpa when I saw good ones :)