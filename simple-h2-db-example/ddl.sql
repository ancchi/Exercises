
CREATE TABLE IF NOT EXISTS category (
  id_cat BIGINT PRIMARY KEY AUTO_INCREMENT,
  cat varchar(256) NOT NULL,
  created_at DATETIME NOT NULL,
  modified_at DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS todo_list (
  id_todo BIGINT PRIMARY KEY auto_increment,
  task varchar(256) NOT NULL,
  done int(2) NOT NULL,
);

ALTER TABLE todo_list ADD IF NOT EXISTS created_at DATETIME NOT NULL;
ALTER TABLE todo_list ADD IF NOT EXISTS modified_at DATETIME NOT NULL;
ALTER TABLE todo_list ADD IF NOT EXISTS id_cat BIGINT NOT NULL ;
ALTER TABLE todo_list ADD FOREIGN KEY (id_cat) REFERENCES category (id_cat);
-- ALTER TABLE todo_list ADD  IF NOT EXISTS idTodo BIGINT NOT NULL;
-- ALTER TABLE todo_list ADD FOREIGN KEY (idTodo) REFERENCES category (idTodo); -- ON UPDATE CASCADE on DELETE CASCADE ;


