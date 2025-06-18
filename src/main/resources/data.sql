INSERT INTO
  users (name, password)
VALUES
  (
    'Breeze開発チーム',
    '$2a$10$.sEhr3hVlXAvSBMZbt08A.n2BU7soGOQs76Gcg0yAUYR4JdBdLYnC'
  );

INSERT INTO
  whisper (user_id, text, anonymous)
VALUES
  (1,
   '普段人に言えないようなことをウィスパー（囁く）してみましょう...チェックボックスで名前を非公開にできますよ🤫', false)