CREATE TABLE IF NOT EXISTS public.paciente
(
    codigo bigserial NOT NULL,
    nome text,
    cpf text,
    PRIMARY KEY (codigo)
);
