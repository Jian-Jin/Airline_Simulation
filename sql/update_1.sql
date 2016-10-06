
DROP TABLE if exists user;
DROP TABLE if exists aircraft;
DROP TABLE if exists user_aircraft;
DROP TABLE if exists user_airport;
CREATE TABLE aircraft(id INT, name VARCHAR(30),cost DOUBLE, maxSeat INT, rangeVal INT, speed INT, fuelCapacity DOUBLE,fuelBurn INT, takeOffDis INT, landingDis INT, PRIMARY KEY(id));


INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(1,'Airbus A318',75.1,132,3573,515,6400,614,5997,4449);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(2,'Airbus A319',89.6,156,4319,515,6400,640,7100,4757);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(3,'Airbus A320',98,180,3790,515,6400,918,6860,5052);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(4,'Airbus A321',114.9,236,3697,515,6350,954,8400,5052);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(5,'Airbus A330(-300)',256.4,440,7301,629,25765,2333,9110,5680);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(6,'Airbus A340(-300)',238,440,8389,537,39060,2173,10200,6319);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(7,'Airbus A350(-900)',308.1,440,9321,652,36456,2723,7200,6450);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(8,'Airbus A380',432.6,853,9445,560,84600,4552,9680,5000);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(9,'Beechcraft 1900',5,19,439,322,660,110,3813,2800);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(10,'Boeing 737(-800)',96,189,3520,518,6875,927,7874,4500);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(11,'Boeing 747(-8)',378.5,605,8900,570,63034,3669,10140,6750);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(12,'Boeing 767(-300ER)',197.1,290,7260,530,24140,1721,8300,5512);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(13,'Boeing 777(-300ER)',339.6,550,8480,554,47890,2945,10000,6102);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(14,'Boeing 787(-9)',264.6,406,8786,561,33348,2380,9400,6759);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(15,'Bombardier CRJ-200(-ER)',24,50,1548,488,2135,787,5800,4850);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(16,'Bombardier CRJ-700',41,78,1257,515,2902,831,4975,5040);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(17,'Bombardier CRJ-900',46,90,1231,515,2897,2263,5775,5260);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(18,'Embraer 135(-ER)',16.5,37,1497,515,1259,313,5381,4462);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(19,'Embraer 140(-ER)',17,44,1440,515,1359,313,5184,4528);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(20,'Embraer 145(-LR)',19.6,50,1785,515,1690,313,7448,4593);
INSERT INTO aircraft(id,name,cost,maxSeat,rangeVal,speed,fuelCapacity,fuelBurn,takeOffDis,landingDis) VALUES(21,'MD-83',45,155,2900,504,7000,999,8000,4500);

CREATE TABLE user(id INT, name VARCHAR(30), password VARCHAR(30), PRIMARY KEY(id));
CREATE TABLE user_aircraft(id INT, userId INT, aircraftId INT, PRIMARY KEY(id));
CREATE TABLE user_airport(id INT, userId INT, airportId INT, PRIMARY KEY(id));