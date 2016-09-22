
#sql to create and populate airport data

CREATE TABLE airport(id INT, state VARCHAR(30),identifier VARCHAR(30), city VARCHAR(30), name VARCHAR(30), size VARCHAR(10),enplanements INT, dailyUsage INT, scaled INT,landingFee INT, runwayLength INT, timeZone INT, PRIMARY KEY(id));


INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(1,'GA','ATL','Atlanta','Hartsfield - Jackson Atlanta International','L',49340732,135180,6759,200,12390,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(2,'CA','LAX','Los Angeles','Los Angeles International','L',36351226,99592,4980,200,12091,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(3,'IL','ORD','Chicago','Chicago O-Hare International','L',36305668,99468,4973,200,13000,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(4,'TX','DFW','Fort Worth','Dallas-Fort Worth International','L',31589832,86547,4327,200,13401,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(5,'NY','JFK','New York','John F Kennedy International','L',27717503,75938,3797,200,14511,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(6,'CO','DEN','Denver','Denver International','L',26280043,72000,3600,200,16000,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(7,'CA','SFO','San Francisco','San Francisco International','L',24190549,66275,3314,200,11870,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(8,'NC','CLT','Charlotte','Charlotte/Douglas International','L',21913156,60036,3002,200,10000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(9,'NV','LAS','Las Vegas','McCarran International','L',21824231,59792,2990,200,14512,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(10,'AZ','PHX','Phoenix','Phoenix Sky Harbor International','L',21351445,58497,2925,200,11489,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(11,'FL','MIA','Miami','Miami International','L',20986341,57497,2875,150,13016,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(12,'TX','IAH','Houston','George Bush Intercontinental/Houston','L',20595874,56427,2821,150,12002,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(13,'WA','SEA','Seattle','Seattle-Tacoma International','L',20148980,55203,2760,150,11901,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(14,'FL','MCO','Orlando','Orlando International','L',18759938,51397,2570,150,12005,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(15,'NJ','EWR','Newark','Newark Liberty International','L',18684765,51191,2560,150,11000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(16,'MN','MSP','Minneapolis','Minneapolis-St Paul International/Wold-Chamberlain','L',17634252,48313,2416,150,11006,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(17,'MA','BOS','Boston','General Edward Lawrence Logan International','L',16290323,44631,2232,150,10083,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(18,'MI','DTW','Detroit','Detroit Metropolitan Wayne County','L',16255507,44536,2227,150,12003,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(19,'PA','PHL','Philadelphia','Philadelphia International','L',15101318,41373,2069,150,10506,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(20,'NY','LGA','New York','Laguardia','L',14319924,39233,1962,150,7003,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(21,'FL','FLL','Fort Lauderdale','Fort Lauderdale/Hollywood International','L',13061607,35785,1789,125,9000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(22,'MD','BWI','Glen Burnie','Baltimore/Washington International Thurgood Marshall','L',11738828,32161,1608,125,10502,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(23,'VA','DCA','Arlington','Ronald Reagan Washington National','L',11242375,30801,1540,125,7169,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(24,'IL','MDW','Chicago','Chicago Midway International','L',10830783,29673,1484,125,6522,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(25,'UT','SLC','Salt Lake City','Salt Lake City International','L',10634519,29136,1457,125,12002,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(26,'VA','IAD','Dulles','Washington Dulles International','L',10363918,28394,1420,125,11500,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(27,'CA','SAN','San Diego','San Diego International','L',9985739,27358,1368,125,9400,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(28,'FL','TPA','Tampa','Tampa International','L',9150414,25070,1253,125,11002,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(29,'OR','PDX','Portland','Portland International','L',8340234,22850,1142,125,11000,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(30,'TX','DAL','Dallas','Dallas Love Field','M',7040921,19290,1061,125,8800,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(31,'MO','STL','St. Louis','Lambert-St Louis International','M',6239231,17094,940,100,11019,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(32,'TX','HOU','Houston','William P Hobby','M',5937944,16268,895,100,7602,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(33,'TX','AUS','Austin','Austin-Bergstrom International','M',5797547,15884,874,100,12248,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(34,'TN','BNA','Nashville','Nashville International','M',5708852,15641,860,100,11030,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(35,'CA','OAK','Oakland','Metropolitan Oakland International','M',5506672,15087,830,100,10520,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(36,'LA','MSY','Metairie','Louis Armstrong New Orleans International','M',5329696,14602,803,100,10104,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(37,'MO','MCI','Kansas City','Kansas City International','M',5135127,14069,774,100,10801,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(38,'NC','RDU','Raleigh','Raleigh-Durham International','M',4954717,13575,747,100,10000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(39,'CA','SNA','Santa Ana','John Wayne Airport-Orange County','M',4945175,13548,745,100,5701,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(40,'CA','SJC','San Jose','Norman Y Mineta San Jose International','M',4814721,13191,726,100,11000,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(41,'CA','SMF','Sacramento','Sacramento International','M',4714723,12917,710,90,8605,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(42,'FL','RSW','Fort Myers','Southwest Florida International','M',4159212,11395,627,90,12000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(43,'TX','SAT','San Antonio','San Antonio International','M',4091389,11209,617,90,8505,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(44,'OH','CLE','Cleveland','Cleveland-Hopkins International','M',3916914,10731,590,90,9955,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(45,'PA','PIT','Pittsburgh','Pittsburgh International','M',3890677,10659,586,90,11500,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(46,'IN','IND','Indianapolis','Indianapolis International','M',3889567,10656,586,90,11200,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(47,'OH','CMH','Columbus','Port Columbus International','M',3312496,9075,499,90,10113,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(48,'WI','MKE','Milwaukee','General Mitchell International','M',3229876,8849,487,90,9990,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(49,'FL','PBI','West Palm Beach','Palm Beach International','M',3113485,8530,469,90,10000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(50,'KY','CVG','Cincinnati','Cincinnati/Northern Kentucky International','M',3036697,8320,458,90,12000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(51,'CT','BDL','Windsor Locks','Bradley International','M',2926047,8017,441,80,9510,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(52,'FL','JAX','Jacksonville','Jacksonville International','M',2716465,7442,409,80,10000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(53,'NY','BUF','Buffalo','Buffalo Niagara International','M',2331545,6388,351,80,8829,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(54,'NM','ABQ','Albuquerque','Albuquerque International Sunport','M',2323850,6367,350,80,13793,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(55,'CA','ONT','Ontario','Ontario International','M',2089781,5725,315,80,12197,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(56,'NE','OMA','Omaha','Eppley Airfield','M',2046155,5606,308,80,9502,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(57,'CA','BUR','Burbank','Bob Hope','S',1973869,5408,324,80,6886,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(58,'TN','MEM','Memphis','Memphis International','S',1873714,5133,308,80,11120,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(59,'OK','OKC','Oklahoma City','Will Rogers World','S',1803159,4940,296,80,9802,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(60,'RI','PVD','Warwick','Theodore Francis Green State','S',1763672,4832,290,80,7166,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(61,'VA','RIC','Highland Springs','Richmond International','S',1740380,4768,286,70,9003,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(62,'SC','CHS','Charleston','Charleston AFB/International','S',1669960,4575,275,70,9001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(63,'NV','RNO','Reno','Reno/Tahoe International','S',1669863,4575,274,70,11002,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(64,'KY','SDF','Louisville','Louisville International-Standiford Field','S',1640287,4494,270,70,11887,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(65,'AZ','TUS','Tucson','Tucson International','S',1549114,4244,255,70,10996,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(66,'WA','GEG','Spokane','Spokane International','S',1515349,4152,249,70,11002,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(67,'VA','ORF','Norfolk','Norfolk International','S',1515198,4151,249,70,9001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(68,'ID','BOI','Boise','Boise Air Terminal/Gowen Field','S',1487764,4076,245,70,10000,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(69,'TX','ELP','El Paso','El Paso International','S',1381367,3785,227,70,12020,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(70,'OK','TUL','Tulsa','Tulsa International','S',1359562,3725,223,70,9999,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(71,'AL','BHM','Birmingham','Birmingham-Shuttlesworth International','S',1325891,3633,218,60,11998,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(72,'MI','GRR','Grand Rapids','Gerald R Ford International','S',1280801,3509,211,60,10000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(73,'NY','ALB','Albany','Albany International','S',1276743,3498,210,60,8500,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(74,'CA','LGB','Long Beach','Long Beach /Daugherty Field/','S',1220906,3345,201,60,10003,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(75,'NY','ROC','Rochester','Greater Rochester International','S',1177983,3227,194,60,8001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(76,'FL','SFB','Sanford','Orlando Sanford International','S',1174158,3217,193,60,11002,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(77,'IA','DSM','Des Moines','Des Moines International','S',1156450,3168,190,60,9003,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(78,'OH','DAY','Dayton','James M Cox Dayton International','S',1041731,2854,171,60,10900,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(79,'NH','MHT','Manchester','Manchester','S',1026342,2812,169,60,9250,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(80,'NY','SYR','Syracuse','Syracuse Hancock International','S',987640,2706,162,60,9003,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(81,'GA','SAV','Savannah','Savannah/Hilton Head International','S',980531,2686,161,50,9351,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(82,'AR','LIT','Little Rock','Bill and Hillary Clinton National/Adams Field','S',958510,2626,158,50,8273,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(83,'SC','GSP','Greer','Greenville Spartanburg International','S',955097,2617,157,50,11001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(84,'CA','PSP','Palm Springs','Palm Springs International','S',947713,2596,156,50,10000,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(85,'SC','MYR','Myrtle Beach','Myrtle Beach International','S',899855,2465,148,50,9503,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(86,'ME','PWM','Portland','Portland International Jetport','S',858449,2352,141,50,7200,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(87,'TN','TYS','Alcoa','McGhee Tyson','S',848390,2324,139,50,9005,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(88,'NC','GSO','Greensboro','Piedmont Triad International','S',848249,2324,139,50,10001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(89,'WI','MSN','Madison','Dane County Regional-Truax Field','S',826640,2265,136,50,9006,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(90,'FL','PIE','Clearwater','St Pete-Clearwater International','S',819962,2246,135,50,9730,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(91,'FL','PNS','Pensacola','Pensacola International','S',787901,2159,130,40,7004,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(92,'KS','ICT','Wichita','Wichita Dwight D Eisenhower National','S',773526,2119,127,40,10301,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(93,'OH','CAK','Akron','Akron-Canton Regional','S',759333,2080,125,40,8204,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(94,'NY','HPN','White Plains','Westchester County','S',757424,2075,125,40,6549,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(95,'CA','FAT','Fresno','Fresno Yosemite International','S',694994,1904,114,40,9539,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(96,'AZ','IWA','Mesa','Phoenix-Mesa Gateway','S',666168,1825,110,40,10401,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(97,'AR','XNA','Bentonville','Northwest Arkansas Regional','S',629903,1726,104,40,8800,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(98,'FL','SRQ','Sarasota','Sarasota/Bradenton International','S',607428,1664,100,40,9500,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(99,'KY','LEX','Lexington','Blue Grass','S',606977,1663,100,40,7004,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(100,'NY','ISP','Islip','Long Island MacArthur','S',603641,1654,99,40,7006,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(101,'CO','COS','Colorado Springs','City of Colorado Springs Municipal','S',593217,1625,98,30,13501,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(102,'NJ','ACY','Atlantic City','Atlantic City International','S',587967,1611,97,30,10000,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(103,'PA','MDT','Harrisburg','Harrisburg International','S',587047,1608,97,30,10001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(104,'VT','BTV','Burlington','Burlington International','S',581141,1592,96,30,8320,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(105,'IA','CID','Cedar Rapids','The Eastern Iowa','S',557374,1527,92,30,8600,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(106,'SC','CAE','Columbia','Columbia Metropolitan','S',533575,1462,88,30,8601,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(107,'AL','HSV','Huntsville','Huntsville International-Carl T Jones Field','S',519785,1424,85,30,12600,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(108,'TX','MAF','Midland','Midland International','S',518496,1421,85,30,9501,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(109,'MT','BZN','Bozeman','Bozeman Yellowstone International','S',512029,1403,84,30,8994,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(110,'MS','JAN','Jackson','Jackson-Medgar Wiley Evers International','S',497042,1362,82,30,8500,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(111,'SD','FSD','Sioux Falls','Joe Foss Field','S',493520,1352,81,30,8999,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(112,'MO','SGF','Springfield','Springfield-Branson National','S',447843,1227,74,30,8000,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(113,'OR','EUG','Eugene','Mahlon Sweet Field','S',447803,1227,74,30,8009,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(114,'WA','BLI','Bellingham','Bellingham International','S',447691,1227,74,30,6701,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(115,'TX','LBB','Lubbock','Lubbock Preston Smith International','S',443230,1214,73,30,11500,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(116,'ND','FAR','Fargo','Hector International','S',437098,1198,72,30,9001,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(117,'FL','ECP','Panama City','Northwest Florida Beaches International','S',428704,1175,70,30,10000,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(118,'FL','PGD','Punta Gorda','Punta Gorda','S',421157,1154,69,30,7193,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(119,'MT','BIL','Billings','Billings Logan International','S',420422,1152,69,30,10521,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(120,'AZ','GCN','Grand Canyon','Grand Canyon National Park','S',419538,1149,69,30,8999,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(121,'MI','FNT','Flint','Bishop International','S',411763,1128,68,30,7848,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(122,'TN','CHA','Chattanooga','Lovell Field','N',393670,1079,70,30,7400,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(123,'NC','AVL','Asheville','Asheville Regional','N',393379,1078,70,30,8001,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(124,'TX','MFE','McAllen','McAllen Miller International','N',391673,1073,70,30,7120,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(125,'NJ','TTN','Trenton','Trenton Mercer','N',389598,1067,69,30,6006,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(126,'NV','BVU','Boulder City','Boulder City Municipal','N',388773,1065,69,30,4803,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(127,'NC','ILM','Wilmington','Wilmington International','N',388019,1063,69,30,8016,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(128,'FL','VPS','Valparaiso','Eglin AFB/Destin-Ft Walton Beach','N',373072,1022,66,30,11987,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(129,'OR','MFR','Medford','Rogue Valley International - Medford','N',370181,1014,66,30,8800,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(130,'IL','MLI','Moline','Quad City International','N',368114,1009,66,30,10002,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(131,'LA','BTR','Baton Rouge','Baton Rouge Metropolitan Ryan Field','N',366091,1003,65,30,7500,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(132,'FL','EYW','Key West','Key West International','N',362108,992,64,30,4801,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(133,'IN','FWA','Fort Wayne','Fort Wayne International','N',353872,970,63,30,11981,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(134,'MT','MSO','Missoula','Missoula International','N',350162,959,62,30,9501,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(135,'WA','PSC','Pasco','Tri-Cities','N',348988,956,62,30,7711,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(136,'TX','AMA','Amarillo','Rick Husband Amarillo International','N',341125,935,61,30,13502,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(137,'TX','CRP','Corpus Christi','Corpus Christi International','N',338312,927,60,30,7508,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(138,'FL','TLH','Tallahassee','Tallahassee International','N',332762,912,59,30,8003,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(139,'PA','ABE','Allentown','Lehigh Valley International','N',320544,878,57,30,7600,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(140,'IL','PIA','Peoria','General Downing - Peoria International','N',318156,872,57,30,10104,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(141,'MS','GPT','Gulfport','Gulfport-Biloxi International','N',317154,869,56,30,9002,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(142,'CA','SBA','Santa Barbara','Santa Barbara Municipal','N',316508,867,56,30,6052,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(143,'IN','SBN','South Bend','South Bend International','N',315313,864,56,30,8414,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(144,'WY','JAC','Jackson','Jackson Hole','N',313148,858,56,30,6300,-7);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(145,'FL','DAB','Daytona Beach','Daytona Beach International','N',306346,839,55,30,10500,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(146,'VA','ROA','Roanoke','Roanoke-Blacksburg Regional/Woodrum Field','N',300181,822,53,30,6800,-5);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(147,'LA','SHV','Shreveport','Shreveport Regional','N',295253,809,53,30,8351,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(148,'WI','GRB','Green Bay','Austin Straubel International','N',295245,809,53,30,8699,-6);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(149,'OR','RDM','Redmond','Roberts Field','N',280821,769,50,30,7038,-8);
INSERT INTO airport(id,state,identifier,city,name,size,enplanements,dailyUsage,scaled,landingFee,runwayLength,timeZone) VALUES(150,'AL','MOB','Mobile','Mobile Regional','N',278053,762,50,30,8502,-6);




