
MERGE INTO category
    Key(id_cat)
VALUES
  (1, 'Politik', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
  (2, 'Haushalt', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
  (3, 'Shopping', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
  (4, 'Shopping', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


MERGE INTO todo_list
KEY(id_todo)
VALUES
  (1 , 'Essen einkaufen gehen', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 2),
  (2 , 'Weltherrschaft an mich reißen', 1, CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP(), 1),
  (3 , 'Schloss kaufen', 0, CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP(), 3),
  (4, 'Weltfrieden beschliessen', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1),
  (5 , 'Swimmingpool kaufen', 0, CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP(), 3),
  (6 , 'Garage einrichten', 0, CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP(), 2);