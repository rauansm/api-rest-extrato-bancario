set foreign_key_checks = 0;

delete from conta;
delete from transferencia;

set foreign_key_checks = 1;

alter table conta auto_increment = 1;
alter table transferencia auto_increment = 1;

insert into conta (id_conta, nome_responsavel) values (1, 'Fulano');
insert into conta (id_conta, nome_responsavel) values (2, 'Cicrano');

INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (35,'2019-02-11 14:11:59',30895.46,'DEPOSITO', 'Rauan Santos', 1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (34,'2019-02-11 14:11:59',12.24,'DEPOSITO', 'Lucas Moura',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (33,'2019-02-11 14:11:59',-500.50,'SAQUE', 'Fernanda',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (32,'2023-02-11 14:11:59',-530.50,'SAQUE', 'Luciana',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (31,'2023-02-11 14:11:59',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (30,'2021-02-11 14:11:59',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
