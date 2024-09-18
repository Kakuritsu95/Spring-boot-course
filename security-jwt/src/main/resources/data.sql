INSERT INTO `security_directory`.`authorities` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `security_directory`.`user` (`id`, `email`, `firstname`, `lastname`, `password`) VALUES (1, 'darorick', 'thodoros', 'christof', '$2a$12$Lje3u2uVFjL1l5nijQPwwesxkXvX1WUr6R4cF0vhdf/sWMlLcvu4m');
INSERT INTO `security_directory`.`user_roles` (`authority_id`, `user_id`) VALUES (1, 1);