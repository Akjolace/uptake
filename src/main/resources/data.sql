
INSERT INTO role(id, role_name) VALUES ('1','ROLE_ADMIN');
INSERT INTO role(id, role_name) VALUES ('2','ROLE_USER');

INSERT INTO user(full_name, password, email, status) VALUES ('--User--', '$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui', 'admin', true);
INSERT INTO user(full_name, password, email, status) VALUES ('--Admin--', '$2y$12$17mdHGrfoQamAP5T5MC0HuWf9BWCUxoIGMEBjn50dv.zyDHpBpKJa', 'user', true);

INSERT INTO user_role(role_id, user_id) VALUES (1, 1);
INSERT INTO user_role(role_id, user_id) VALUES (2, 2);

