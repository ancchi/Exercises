CREATE TABLE IF NOT EXISTS todo_list (
  -- id bigint PRIMARY KEY auto_increment,
  id BIGINT PRIMARY KEY auto_increment,
  task varchar(256) NOT NULL,
  done int(2) NOT NULL
);

ALTER TABLE todo_list ADD IF NOT EXISTS created_at DATETIME NOT NULL;
ALTER TABLE todo_list ADD IF NOT EXISTS modified_at DATETIME NOT NULL;
