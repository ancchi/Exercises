MERGE INTO todo_list
  KEY(id)
VALUES
 -- (1, 'Einkaufen gehen', 0),
 -- (2, 'Weltherrschaft an mich reißen', 1);


  -- (1 , 'Einkaufen gehen', 0, FORMATDATETIME(CURRENT_TIMESTAMP(), 'dd MMM yyyy HH:mm:ss'), FORMATDATETIME(CURRENT_TIMESTAMP(), 'dd MMM yyyy HH:mm:ss')),
  -- (1 , 'Einkaufen gehen', 0, CAST(FORMATDATETIME(CURRENT_TIMESTAMP() , 'ddMMMyyyyHHmmss') as BIGINT)), CAST(FORMATDATETIME(CURRENT_TIMESTAMP(), 'ddMMMyyyyHHmmss') as BIGINT),
  (1 , 'Einkaufen gehen', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
  (2 , 'Weltherrschaft an mich reißen', 1, CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP());

// Convert
// now()
// Current_Timestamp