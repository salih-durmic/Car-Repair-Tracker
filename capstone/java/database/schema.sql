BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, cars, service, repair_requests;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email_address varchar(100) NOT NULL,
	phone_number varchar(15) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user_id PRIMARY KEY (user_id)
);

CREATE TABLE cars(
    car_id SERIAL,
    user_id int NOT NULL,
    make varchar(50) NOT NULL,
    model varchar(50) NOT NULL,
    color varchar(50) NOT NULL,
    year varchar(50) NOT NULL,
    CONSTRAINT PK_car_id PRIMARY KEY (car_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE service (
    service_id SERIAL,
    car_id int NOT NULL,
    oil varchar(50),
    brakes varchar(50),
    tires varchar(50),
    body varchar(50),
    CONSTRAINT PK_service_id PRIMARY KEY (service_id),
    CONSTRAINT FK_car_id FOREIGN KEY (car_id) REFERENCES cars(car_id)
);

CREATE TABLE repair_requests (
    repair_id SERIAL,
    service_id int NOT NULL,
    date_reported date NOT NULL,
    estimated_completion_date date NOT NULL,
    status varchar(50) NOT NULL,
    estimated_cost numeric,
    labor_cost numeric,
    paid bit NOT NULL,
    CONSTRAINT PK_repair_id PRIMARY KEY (repair_id),
    CONSTRAINT FK_service_id FOREIGN KEY (service_id) REFERENCES service(service_id)
    );


COMMIT TRANSACTION;
