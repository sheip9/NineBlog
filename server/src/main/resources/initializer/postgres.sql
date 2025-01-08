DROP SEQUENCE IF EXISTS article_id_seq;
CREATE SEQUENCE article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE Article ALTER COLUMN id SET DEFAULT nextval('article_id_seq'::regclass);

DROP SEQUENCE IF EXISTS comment_id_seq;
CREATE SEQUENCE comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE Comment ALTER COLUMN id SET DEFAULT nextval('comment_id_seq'::regclass);