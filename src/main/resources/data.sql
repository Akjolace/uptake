insert into country values(1,"USA");
insert into country values(2,"Mongolia");
insert into address values(1, "Fairfield", "Iowa", "52556", 1);
insert into profile values(1,"Bio", "2000-10-10","Dolly", 1, 1, "anna");
insert into profile values(1,"Admin user profiele", "2000-10-10","--Admin--", 1, 1, "adminprofile");

INSERT INTO role(id, role_name) VALUES ('1','ROLE_ADMIN');
INSERT INTO role(id, role_name) VALUES ('2','ROLE_USER');

INSERT INTO user(password, email, status) VALUES ('$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'admin', true);
INSERT INTO user(password, email, status) VALUES ('$2y$12$17mdHGrfoQamAP5T5MC0HuWf9BWCUxoIGMEBjn50dv.zyDHpBpKJa', 'user', true);

INSERT INTO user_role(role_id, user_id) VALUES (1, 1);
INSERT INTO user_role(role_id, user_id) VALUES (2, 2);
