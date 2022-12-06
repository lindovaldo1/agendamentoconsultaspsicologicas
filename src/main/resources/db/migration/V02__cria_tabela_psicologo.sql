CREATE TABLE IF NOT EXISTS public.psicologo
(
    codigo bigserial NOT NULL,
    name text,
    cpf text,
    specialty text DEFAULT 'NONE',
    PRIMARY KEY (codigo)
);

INSERT INTO public.psicolog(name, cpf, specialty) VALUES
('Grosbilda', '34987654321', 'PSICOLOGIA_SOCIAL'),
('Estrobilobaldo', '34912345678', 'NEUROPSICOLOGIA'),
('Zirgonisvaldo', '34912348765', 'PSICOLOGIA_SAUDE');
