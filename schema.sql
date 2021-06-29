CREATE TABLE IF NOT EXISTS vcd_open_projects.stat
(
    "id" character varying(50) COLLATE pg_catalog."default" NOT NULL,
	"host" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "timestamp" numeric NOT NULL,
    "counter" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "value" character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT stat_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE vcd_open_projects.stat
    OWNER to postgres;

GRANT ALL ON TABLE vcd_open_projects.stat TO postgres;

GRANT ALL ON TABLE vcd_open_projects.stat TO "vcd-user" WITH GRANT OPTION;