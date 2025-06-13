INSERT INTO
  users (name, password)
VALUES
  (
    'sample',
    '$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC'
  ),
  (
    'oiia',
    '$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC'
  );

INSERT INTO
  whisper (user_id, text, anonymous)
VALUES
  (1, 'hello', true),
  (1, 'world', false),
  (
    2,
    'oiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiiaoiia',
    false
  );