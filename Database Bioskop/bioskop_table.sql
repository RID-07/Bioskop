CREATE TABLE public.user_bioskop (
	user_id int4 NOT NULL,
	email varchar(255) NULL,
	"password" varchar(255) NULL,
	user_name varchar(255) NULL,
	CONSTRAINT user_bioskop_pkey PRIMARY KEY (user_id)
);

CREATE TABLE public."role" (
	role_id int4 NOT NULL,
	"role" varchar(255) NULL,
	CONSTRAINT role_pkey PRIMARY KEY (role_id)
);

CREATE TABLE bioskop.user_role (
	user_id int4 NOT NULL,
	role_id int4 NOT NULL,
	CONSTRAINT uk_it77eq964jhfqtu54081ebtio UNIQUE (role_id),
	CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),
	CONSTRAINT fka68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role(role_id),
	CONSTRAINT fkhx79db2mxaypqs2gdhy2yvp0e FOREIGN KEY (user_id) REFERENCES user_bioskop(user_id)
);

CREATE TABLE bioskop.ticket (
	kode_ticket varchar(4) NOT NULL,
	kode_film varchar(3) NULL,
	nama_pembeli varchar(50) NULL,
	no_telp text NULL,
	email varchar(50) NULL,
	waktu_beli timestamp NULL,
	point int8 NULL,
	CONSTRAINT pk_bioskop_ticket PRIMARY KEY (kode_ticket),
	CONSTRAINT fk_bioskop_datafilm_kode_film FOREIGN KEY (kode_film) REFERENCES bioskop.datafilm(kode_film)
);

CREATE TABLE bioskop.studio (
	kode_studio varchar(3) NOT NULL,
	kapasitas int4 NULL,
	CONSTRAINT pk_bioskop_studio_kode_studio PRIMARY KEY (kode_studio)
);

CREATE TABLE bioskop.indexhadiah (
	id_index bigserial NOT NULL,
	kode_hadiah varchar(3) NULL,
	nama_hadiah varchar(255) NULL,
	CONSTRAINT indexhadiah_pkey PRIMARY KEY (id_index)
);

CREATE TABLE bioskop.hadiah (
	kode_hadiah varchar(3) NOT NULL,
	nama_hadiah varchar(255) NULL,
	total_point int8 NULL,
	CONSTRAINT pk_bioskop_hadiah_kode_hadiah PRIMARY KEY (kode_hadiah)
);

CREATE TABLE bioskop.datafilm (
	kode_film varchar(3) NOT NULL,
	kode_studio varchar(3) NULL,
	judul_film varchar(100) NULL,
	waktu_film timestamp NULL,
	CONSTRAINT pk_bioskop_datafilm PRIMARY KEY (kode_film),
	CONSTRAINT fk_bioskop_studio_kode_studio FOREIGN KEY (kode_studio) REFERENCES bioskop.studio(kode_studio)
);