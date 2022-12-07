CREATE TABLE IF NOT EXISTS public.paciente
(
    codigo bigserial NOT NULL,
    nome text,
    cpf text,
    status text DEFAULT 'ATIVO',
    PRIMARY KEY (codigo)
);
