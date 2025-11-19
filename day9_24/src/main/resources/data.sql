insert into users (name,email,age) values ('HeHe' , 'hehe@gmail.com',20);
insert into users (name,email,age) values ('HaHa' , 'haha@gmail.com',25);
insert into users (name,email,age) values ('KiKi' , 'kiki@gmail.com',30);

-- Insert an admin user
INSERT INTO app_users (username, password, role) VALUES
('admin', '$2a$10$D9rTzGm6Y9u2XKQH8h9S4uSfs5h8w6bX/3zCl7XvQy5jM2h9H6P0a', 'ROLE_ADMIN');

-- Insert a regular user
INSERT INTO app_users (username, password, role) VALUES
('user', '$2a$10$eDqlyXy7QmO3pH7E4sWlxeN3Jj6C4P7F2uRmQF0Bq1cD9sP3nQ7l6', 'ROLE_USER');
