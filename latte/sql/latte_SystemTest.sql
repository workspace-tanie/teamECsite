set names utf8;
set foreign_key_checks=0;

drop database if exists latte;
create database if not exists latte;

use latte;

create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
sex tinyint default 0 comment "性別",
email varchar(32) comment "メールアドレス",
status tinyint default 0 comment "ステータス",
logined tinyint not null default 0 comment "ログインフラグ",
regist_date datetime  not null comment"登録日時",
update_date datetime comment "更新日時"
)
default charset=utf8
comment="会員情報テーブル"
;

create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_name_kana varchar(100) unique not null comment "商品名かな",
product_description varchar(255) comment "商品詳細",
category_id int not null comment "カテゴリID",
price int not null comment "値段",
image_file_path varchar(100) not null comment "画像ファイルパス",
image_file_name varchar(50) not null comment "画像ファイル名",
release_date datetime comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint default 1 comment "ステータス",
regist_date datetime  not null comment"登録日時",
update_date datetime comment "更新日時",
foreign key(category_id) references m_category(category_id)
)
default charset=utf8
comment="商品情報テーブル";

create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
regist_date datetime  not null comment"登録日時",
update_date datetime comment "更新日時",
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="カート情報テーブル"
;

create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "値段",
destination_id int not null comment "宛先情報ID",
regist_date datetime  not null comment"登録日時",
update_date datetime comment "更新日時",
foreign key(user_id) references user_info(user_id),
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="購入履歴情報テーブル"
;

create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
email varchar(32) comment "メールアドレス",
tel_number varchar(13) comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime  not null comment"登録日時",
update_date datetime comment "更新日時",
foreign key(user_id) references user_info(user_id)
)
default charset=utf8
comment="宛先情報テーブル"
;

create table m_category(
id int primary key not null auto_increment comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
regist_date datetime  not null comment"登録日時",
update_date datetime comment "更新日時"
)
default charset=utf8
comment="カテゴリマスタテーブル"
;

set foreign_key_checks=1;

insert into user_info values(1,"guest","guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー",0,"internous.guest@gmail.com",0,0,now(),now()),
								(2,"guest2","guest2","インターノウス","ゲストユーザー2","いんたーのうす","げすとゆーざー2",0,"internous.guest2@gmail.com",0,0,now(),now());


insert into m_category values (1,1,"全てのカテゴリー","本、家電・パソコン、おもちゃ・ゲーム全てのカテゴリーが対象となります",now(), now()),
								(2,2,"本","本に関するカテゴリーが対象となります",now(),now()),
								(3,3,"家電・パソコン","家電・パソコンに関するカテゴリーが対象となります",now(),now()),
								(4,4,"おもちゃ・ゲーム","おもちゃ・ゲームに関するカテゴリーが対象となります",now(),now()),
								(5,5,"CD","CDに関するカテゴリーが対象となります",now(),now());


insert into product_info values ( 1, 1,"少年漫画","しょうねんまんが","少年漫画です",2,100,"/latte/images","book_sasshi1_red.jpg",now(),"発売会社",1,now(),now()),
			( 2, 2,"少女漫画","しょうじょまんが","少女漫画です",2,200,"/latte/images","book_sasshi2_yellow.jpg",now(),"発売会社",1,now(),now()),
			( 3, 3,"小説","しょうせつ","小説です",2,300,"/latte/images","book_sasshi3_green.jpg",now(),"発売会社",1,now(),now()),
			( 6,6,"冷蔵庫","れいぞうこ","冷蔵庫です",3,100,"/latte/images","kaden_reizouko.jpg",now(),"発売会社",1,now(),now()),
			( 7,7,"洗濯機","せんたくき","洗濯機です",3,200,"/latte/images","kaden_sentakuki.jpg",now(),"発売会社",1,now(),now()),
			( 8,8,"ドライヤー","どらいやー","ドライヤーです",3,300,"/latte/images","hair_drier.jpg",now(),"発売会社",1,now(),now()),
			( 9,9,"電子レンジ","でんしれんじ","電子レンジです",3,100,"/latte/images","oven_renji.jpg",now(),"発売会社",1,now(),now()),
			( 11,11,"ロボ","ろぼ","ロボットです",4,100,"/latte/images","kyodai_robot.jpg",now(),"発売会社",1,now(),now()),
			( 12,12,"人形","にんぎょう","人形です",4,200,"/latte/images","doll_nihon_ningyou.jpg",now(),"発売会社",1,now(),now()),
			( 13,13,"つみき","つみき","つみきです",4,300,"/latte/images","omocha_tsumiki.jpg",now(),"発売会社",1,now(),now()),
			( 14,14,"ゲーム","げーむ","ゲームです",4,100,"/latte/images","game_software_cassette.jpg",now(),"発売会社",1,now(),now()),
			( 15,15,"エアガン","えあがん","エアガンです",4,200,"/latte/images","starter_starting_pistol.jpg",now(),"発売会社",1,now(),now()),
			( 16,16,"JPOP","じぇいぽっぷ","JPOPです",5,100,"/latte/images","band_woman_vocal.jpg",now(),"発売会社",1,now(),now());

insert into destination_info values (1,"guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー","internous.guest@gmail.com",09000000000,"東京都千代田区霧が関3-6-15",now(),now());
