CREATE TYPE specialties AS ENUM('');
CREATE TABLE public.psicologo
{
    codigo bigserial NOT NULL,
    fisrtName text,
    lastName text,
    cpf text,
    specialty
    PRIMARY KEY (codigo)
}