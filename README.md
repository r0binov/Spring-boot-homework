# Getting Started

### How to run the application

Since I am running docker with PostgreSQL you will need to have docker installed.
I have used DBeaver to run all the commands, but it is really up to you what you use for database management

* Run the command in powershell or terminal 
#### docker run --name spring-api-demo -e POSTGRES_PASSWORD=thisispassword -p 5432:5432 -m 512m -d postgres:12.0

* Input the follwing sql queries once the database has been initialized

####

CREATE TABLE car (
id SERIAL PRIMARY KEY,
manufacturer VARCHAR(255),
model VARCHAR(255),
year INT,
mileage DOUBLE PRECISION
);

INSERT INTO car (manufacturer, model, year, mileage)
VALUES ('Toyota', 'Camry', 2020, 50000.5);
INSERT INTO car (manufacturer, model, year, mileage)
VALUES ('Honda', 'Civic', 2021, 30000.2);
INSERT INTO car (manufacturer, model, year, mileage)
VALUES ('Ford', 'Mustang', 2019, 35000.7);
INSERT INTO car (manufacturer, model, year, mileage)
VALUES ('Chevrolet', 'Silverado', 2018, 40000.9);
INSERT INTO car (manufacturer, model, year, mileage)
VALUES ('Volkswagen', 'Golf', 2022, 25000.3);


### The Api endpoints are 

* To see all values "/api/cars"
* To find by id "/api/cars/{id}"
* To add a car "/api/addCar"
* To update a car by id "/api/updateCar/{id}"
* To delete a car by id "/api/deleteCar/{id}"


## Have fun
