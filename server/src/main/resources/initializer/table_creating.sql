-- USE nineblog;
-- Table creating of Article
DROP TABLE IF EXISTS Article;
CREATE TABLE Article (
      id int NOT NULL PRIMARY KEY,
      author_id int NOT NULL,
      title varchar(255) NOT NULL,
      content text NOT NULL,
      created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
      visibility_level int
);

-- Table creating of Comment
DROP TABLE IF EXISTS Comment;
CREATE TABLE Comment (
     id int NOT NULL PRIMARY KEY,
     article_id int NOT NULL,
     reply_to int,
     nickname varchar(255) NOT NULL,
     email varchar(255) NOT NULL,
     content text NOT NULL,
     created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
     audit_at timestamp NULL DEFAULT NULL
);