USE userInfo;

insert into role (name) VALUES 
	("USER"),
    ("ANONYMOUS"),
	("ADMIN");

INSERT INTO credentials (id,mail, password, name, last_name, role_id, username) VALUES 
	(1,"user@gmail.com", "$2a$10$4fsBn/4ztJDqlnOW7xZq1.3afSXuFCyHdVRFpSTuseiKzycOGYKXi", "pokeUser", "lastName", 1, "user"),
    (2,"user1@gmail.com", "$2a$10$4fsBn/4ztJDqlnOW7xZq1.3afSXuFCyHdVRFpSTuseiKzycOGYKXi", "pokeUser1", "lastName1", 1, "user1"),
    (3,"user2@gmail.com", "$2a$10$4fsBn/4ztJDqlnOW7xZq1.3afSXuFCyHdVRFpSTuseiKzycOGYKXi", "pokeUser2", "lastName2", 1, "user2");
    