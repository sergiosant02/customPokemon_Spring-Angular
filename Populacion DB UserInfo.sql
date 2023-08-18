USE userInfo;

insert into role (name) VALUES 
	("USER"),
    ("ANONYMOUS"),
	("ADMIN");

INSERT INTO credentials (id,mail, password, name, last_name, role_id, username) VALUES 
	(1,"user@gmail.com", "$2a$12$2Jn.hke.X1qQe3sX.6gKxe0jsu92pQ9faZ0HiFOg9AhusB1Pi77o6", "pokeUser", "lastName", 1, "user"),
    (2,"user1@gmail.com", "$2a$12$2Jn.hke.X1qQe3sX.6gKxe0jsu92pQ9faZ0HiFOg9AhusB1Pi77o6", "pokeUser1", "lastName1", 1, "user1"),
    (3,"user2@gmail.com", "$2a$12$2Jn.hke.X1qQe3sX.6gKxe0jsu92pQ9faZ0HiFOg9AhusB1Pi77o6", "pokeUser2", "lastName2", 1, "user2");
    