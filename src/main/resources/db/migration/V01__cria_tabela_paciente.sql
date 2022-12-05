CREATE TABLE IF NOT EXISTS public.paciente
(
    codigo bigserial NOT NULL,
    fisrtName text,
    lastName text,
    cpf text,
    PRIMARY KEY (codigo)
);
