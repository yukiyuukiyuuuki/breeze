CREATE TABLE IF NOT EXISTS
  users (
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    subscribe_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

CREATE TABLE IF NOT EXISTS
  whisper (
    whisper_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    text VARCHAR(10000) NOT NULL,
    post_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    anonymous BOOLEAN
  );