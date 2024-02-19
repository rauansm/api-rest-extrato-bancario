set foreign_key_checks = 0;

delete from conta;

set foreign_key_checks = 1;

alter table conta auto_increment = 1;

insert into conta (id_conta, nome_responsavel) values (1, 'Fulano');
insert into conta (id_conta, nome_responsavel) values (2, 'Cicrano');