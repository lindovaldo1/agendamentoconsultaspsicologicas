CREATE TABLE public.psicologo
{
    codigo bigserial NOT NULL,
    fisrtName text,
    lastName text,
    cpf text,
    specialty text DEFAULT 'NONE',
    PRIMARY KEY (codigo)
}