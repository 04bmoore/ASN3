create table League (
	ID_League int not null auto_increment,
	name_league varchar(100) not null,
	country varchar(100) not null,
	constraint league_pk primary key(ID_League)
);

create table Stadium (
	ID_Stadium int not null auto_increment,
	name_stadium varchar(100) not null,
	city_stadium varchar(100) not null,
	capacity int not null,
	constraint stadium_pk primary key(ID_Stadium)
);

create table Team (
	ID_Team int not null auto_increment,
	ID_League int not null,
	ID_Stadium int not null,
	city_team varchar(100) not null,
	founded_year int not null,
	name_team varchar(100) not null,
	constraint team_pk primary key(ID_Team),
	constraint team_league_fk foreign key(ID_League)
		references League(ID_League),
	constraint team_stadium_fk foreign key(ID_Stadium)
		references Stadium(ID_Stadium)
);

create table Sponsor ( 
	ID_Sponsor int not null auto_increment,
	type_sponsor varchar(100) not null,
	name_sponsor varchar(100) not null,
	constraint sponsor_pk primary key(ID_Sponsor)
);

create table Pay (
	ID_Sponsor int not null,
	ID_Team int not null,
	constraint pay_pk primary key(ID_Sponsor, ID_Team),
	constraint pay_sponsor_fk foreign key(ID_Sponsor)
		references Sponsor(ID_Sponsor),
	constraint pay_team_fk foreign key(ID_Team)
		references Team(ID_Team)
);

create table Staff (
	ID_Staff int not null auto_increment,
	ID_Team int not null,
	role_staff varchar(100) not null,
	name_staff varchar(100) not null,
	exp_years_staff int not null,
	constraint staff_pk primary key(ID_Staff),
	constraint staff_team_fk foreign key(ID_Team)
		references Team(ID_Team)
);

create table Player (
	ID_Player int not null auto_increment,
	ID_Team int not null,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	position varchar(50) not null,
	nationality_player varchar(100) not null,
	dob date not null,
	constraint player_pk primary key(ID_Player),
	constraint player_team_fk foreign key(ID_Team)
		references Team(ID_Team)
);

create table Season (
	ID_Season int not null auto_increment,
	ID_League int not null,
	year_season int not null,
	start_date date not null,
	end_date date not null,
	constraint season_pk primary key(ID_Season),
	constraint season_league_fk foreign key(ID_League)
		references League(ID_League)
);

create table Game ( 
	ID_Game int not null auto_increment,
	ID_Season int not null,
	ID_Stadium int not null,
	game_date date not null,
	away_score int not null,
	home_score int not null,
	constraint game_pk primary key(ID_Game),
	constraint game_season_fk foreign key(ID_Season)
		references Season(ID_Season),
	constraint game_stadium_fk foreign key(ID_Stadium)
		references Stadium(ID_Stadium)
);

create table Play (
	ID_Game int not null,
	ID_Team int not null,
	constraint play_pk primary key(ID_Game, ID_Team),
	constraint play_game_fk foreign key(ID_Game)
		references Game(ID_Game),
	constraint play_team_fk foreign key(ID_Team)
		references Team(ID_Team)
);	

create table Player_Stat (
	ID_Player_Stat int not null auto_increment,
	ID_Player int not null,
	ID_Game int not null,
	assist int,
	goal int,
	yellow_card int,
	red_card int,
	constraint player_stat_pk primary key(ID_Player_Stat),
	constraint player_stat_player_fk foreign key(ID_Player)
		references Player(ID_Player),
	constraint player_stat_game_fk foreign key(ID_Game)
		references Game(ID_Game)
);


create table Referee (
	ID_Referee int not null auto_increment,
	name_referee varchar(100) not null,
	nationality_referee varchar(100) not null,
	exp_years_ref int not null,
	constraint referee_pk primary key(ID_Referee)
);

create table Refs (
	ID_Referee int not null,
	ID_Game int not null,
	constraint refs_pk primary key(ID_Referee, ID_Game),
	constraint refs_referee_fk foreign key(ID_Referee)
		references Referee(ID_Referee),
	constraint refs_game_fk foreign key(ID_Game)
		references Game(ID_Game)
);

create table Fan (
	ID_Fan int not null auto_increment,
	name_fan varchar(100) not null,
	email varchar(100) not null,
	constraint fan_pk primary key(ID_Fan)
);

create table Ticket (
	ID_Ticket int not null auto_increment,
	ID_Game int not null,
	ID_Fan int not null,
	seat_num int not null,
	price float not null,
	constraint ticket_pk primary key(ID_Ticket),
	constraint ticket_game_fk foreign key(ID_Game)
		references Game(ID_Game),
	constraint ticket_fan_fk foreign key(ID_Fan)
		references Fan(ID_Fan)
);

insert into League (name_league, country)
values ('Premier League', 'England'),
('La Liga', 'Spain');

insert into Stadium (name_stadium, city_stadium, capacity)
values ('Old Trafford', 'Manchester', 74310),
('Santiago Bernabeu', 'Madrid', 85000),
('St. James Park', 'Newcastle Upon Tyne', 52258);

insert into Team (city_team, founded_year, name_team, ID_League, ID_Stadium)
values ('Manchester', 1878, 'Manchester United', 1, 1),
('Madrid', 1902, 'Real Madrid', 2, 2),
('Newcastle', 1881, 'Newcastle United', 1, 3);

insert into Sponsor (type_sponsor, name_sponsor)
values ('Shirt', 'Fly Emirates'),
('Shirt', 'Snapdragon');

insert into Pay (ID_Sponsor, ID_Team)
values (1, 2),
(2, 1);

insert into Staff (role_staff, name_staff, exp_years_staff, ID_Team)
values ('Head Coach', 'Ruben Amorim', 6, 1),
('Head Coach', 'Xabi Alonso', 3, 2);

insert into Player (first_name, last_name, position, nationality_player, dob, ID_Team)
values ('Bruno', 'Fernandes', 'Midfield', 'Portugal', '1994-09-08', 1),
('Kylian', 'Mbappe', 'Forward', 'France', '1998-12-20', 2),
('Kieran', 'Trippier', 'Defender', 'England', '1990-09-19', 3);

insert into Season (year_season, start_date, end_date, ID_League)
values (2024, '2024-08-16', '2025-05-25', 1),
(2024, '2024-08-17', '2025-05-24', 2);

insert into Game (game_date, away_score, home_score, ID_Season, ID_Stadium)
values ('2024-08-28', 2, 1, 1, 1),
('2025-04-22', 5, 1, 1, 3);

insert into Play (ID_Game, ID_Team)
values (1, 1),
(1, 3),
(2, 1),
(2, 3);

insert into Player_Stat (assist, goal, yellow_card, red_card, ID_Player, ID_Game)
values (1, 0, 1, 0, 1, 1),
(2, 0, 0, 0, 3, 1);

insert into Referee (name_referee, nationality_referee, exp_years_ref)
values ('Stuart Attwell', 'England', 11),
('Simon Hooper', 'England', 7);

insert into Refs (ID_Referee, ID_Game) 
values (1, 1),
(2, 2);

insert into Fan (name_fan, email)
values ('Aidan Sundt', 'asundt@gmail.com'),
('Brendan Moore', 'bmoore@gmail.com');

insert into Ticket (seat_num, price, ID_Game, ID_Fan)
values (123, 50.00, 1, 1),
(122, 50.00, 1, 2);