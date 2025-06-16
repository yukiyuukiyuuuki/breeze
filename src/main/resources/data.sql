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
  ),
  (2, '静かな朝の光が、窓辺にそっと降り注ぎ
鳥たちのさえずりが、新たな一日を告げる
心の中で小さな希望が芽吹き
その温もりが、胸の奥深くに広がる


風が頬をかすめて、優しく囁く
「今日もまた、君は自由だ」と
青空に広がる雲のように、
柔らかな夢が、心を満たしていく


過ぎ去った日々の思い出たちが
静かに微笑みかけ、懐かしい香りを運ぶ
その中で見つけた、小さな宝物たちは
今もなお、輝きを増し続ける


夜空に瞬く星々が、未来を照らし出し
その輝きの中で、願いがひとつ叶う
静かに流れる時の中で、
心の声に耳を澄ませ、歩んでいく


この瞬間の美しさを胸に刻み
新たな一歩を踏み出す勇気を持って
風のささやきに耳を傾けながら
君だけの物語を紡いでいく',
true);