CREATE TYPE specialties AS ENUM('Psicologia Social', 'Neuropsicologia',  'Psicologia em Saúde');
CREATE TABLE public.psicologo
{
    codigo bigserial NOT NULL,
    fisrtName text,
    lastName text,
    cpf text,
    specialty specialties,
    PRIMARY KEY (codigo)
}