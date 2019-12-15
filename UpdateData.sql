insert into uptake.country(id,country_name) values(1,"USA");
insert into uptake.country(id,country_name) values(2,"Mongolia");

INSERT INTO uptake.role(id, role_name) VALUES ('1','ROLE_ADMIN');
INSERT INTO uptake.role(id, role_name) VALUES ('2','ROLE_USER');

insert into uptake.address(city,state,zip_code,country_id) values("Fairfield", "Iowa", "52556", 1);
insert into uptake.address(city,state,zip_code,country_id) values("Fairfield", "Iowa", "52554", 1);
insert into uptake.address(city,state,zip_code,country_id) values("Fairfield", "Iowa", "52557", 1);
insert into uptake.address(city,state,zip_code,country_id) values("Fairfield", "Iowa", "52553", 1);
insert into uptake.address(city,state,zip_code,country_id) values("Fairfield", "Iowa", "52553", 1);

INSERT INTO uptake.user(id,password, email, username, status,created_date,address_id) VALUES (1,'$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'admin@yahoo.com','admin', true, curdate(),1);
INSERT INTO uptake.user(id,password, email, username, status,created_date,address_id) VALUES (2,'$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'user1@yahoo.com','user1', true, curdate(),2);
INSERT INTO uptake.user(id,password, email, username, status,created_date,address_id) VALUES (3,'$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'user2@yahoo.com','user2', true, curdate(),3);
INSERT INTO uptake.user(id,password, email, username, status,created_date,address_id) VALUES (4,'$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'user3@yahoo.com','user3', true, curdate(),4);
INSERT INTO uptake.user(id,password, email, username, status,created_date,address_id) VALUES (5,'$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'user4@yahoo.com','user4', true, curdate(),5);

INSERT INTO uptake.user_role(role_id, user_id) VALUES (1, 1);
INSERT INTO uptake.user_role(role_id, user_id) VALUES (2, 2);
INSERT INTO uptake.user_role(role_id, user_id) VALUES (2, 3);
INSERT INTO uptake.user_role(role_id, user_id) VALUES (2, 4);
INSERT INTO uptake.user_role(role_id, user_id) VALUES (2, 5);

insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\profile1.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\profile2.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\profile3.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\profile4.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\profile5.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\post1.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\post2.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\post3.jpg');
insert into uptake.photo(path) values('D:\MUM-Aug2019\EA\CourseProject\uptake\src\main\resources\static\images\post4.jpg');

insert into uptake.profile(id,bio,birth_date,full_name,gender,user_id,photo_id) values(1,"Admin user profiele", "2000-10-10","--Admin--", 1,1,1);
insert into uptake.profile(id,bio,birth_date,full_name,gender,user_id,photo_id) values(2,"Live without excuse.Travel without regret.", "2000-10-10","Dolly Anna", 1,2,2);
insert into uptake.profile(id,bio,birth_date,full_name,gender,user_id,photo_id) values(3,"Bio", "2000-10-10","Dolly", 1,3,3);
insert into uptake.profile(id,bio,birth_date,full_name,gender,user_id,photo_id) values(4,"Admin user profiele", "2000-10-10","--Admin--", 1,4,4);
insert into uptake.profile(id,bio,birth_date,full_name,gender,user_id,photo_id) values(5,"Bio", "2000-10-10","Dolly", 1,5,5);

insert into uptake.post(created,description,status,title,photo_id,user_id) values("2019-12-12 10:00:00","ðŸ“The Triton Squareâ›²has never looked so magicalðŸ˜Welcome to Malta`s FairylandðŸ‡²ðŸ‡¹ðŸŽ…ðŸ»in VallettaðŸ›ï¸Are you coming?ðŸ˜‰From 12th December till 5th January",1,"",6,2);
insert into uptake.post(created,description,status,title,photo_id,user_id) values("2019-12-12 10:00:00","Built as the conventual Churchâ›ªfor the Knights of St. Johnâš”ï¸St. Johnâ€™s Co-Cathedral in VallettaðŸ›ï¸is purely stunningðŸ˜Have you been there whilst exploring Valletta?ðŸ˜‰ #history",2,"",7,2);
insert into uptake.post(created,description,status,title,photo_id,user_id) values("2019-12-12 10:00:00","ðŸ˜This is the day to express your loveðŸ˜˜and feelings to your loved onesâ¤ï¸In fact, you should do it every day, not only during special occasionsðŸ¤”Do you agree with us?ðŸ™‚",1,"",8,2);
insert into uptake.post(created,description,status,title,photo_id,user_id) values("2019-12-12 10:00:00","ðŸ˜This is the day to express your loveðŸ˜˜and feelings to your loved onesâ¤ï¸In fact, you should do it every day, not only during special occasionsðŸ¤”Do you agree with us?ðŸ™‚",1,"",9,2);