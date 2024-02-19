set foreign_key_checks = 0;

delete from conta;
delete from transferencia;

set foreign_key_checks = 1;

alter table conta auto_increment = 1;
alter table transferencia auto_increment = 1;

insert into conta (id_conta, nome_responsavel) values (1, 'Fulano');
insert into conta (id_conta, nome_responsavel) values (2, 'Siclano');

INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (35,'2024-02-01 14:11:59',3895.46,'DEPOSITO', 'Rauan Santos', 1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (34,'2024-02-11 14:11:59',12.24,'DEPOSITO', 'Lucas Moura',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (33,'2024-02-02 14:11:59',-500.50,'SAQUE', 'Fernanda',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (32,'2023-02-03 14:11:59',-530.50,'SAQUE', 'Luciana',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (31,'2023-02-04 14:11:59',3241.23,'TRANSFERENCIA', 'Jorge Jesus',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (30,'2021-02-11 14:11:59',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (50,'2021-02-11 14:11:59',-3000.00,'SAQUE', 'Jeane',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (51,'2024-01-11 14:11:59',-2000.00,'SAQUE', 'Karla Vieira',2);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (37,'2024-02-05 14:11:59',241.23,'DEPOSITO', 'Carlos Freitas',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (49,'2024-02-06 14:11:59',241.23,'DEPOSITO', 'Marcelo',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (43,'2024-02-07 14:11:59',-251.23,'SAQUE', 'Luan',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (44,'2024-02-08 14:11:59',-341.23,'SAQUE', 'Marcos',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (40,'2024-02-09 14:11:59',567.23,'DEPOSITO', 'Pedro',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (42,'2024-02-10 14:11:59',250.00,'DEPOSITO', 'Jean',1);
INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (46,'2024-02-11 14:11:59',58.23,'DEPOSITO', 'Carlos Freitas',1);