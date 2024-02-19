create table transferencia (
id_transferencia bigint not null auto_increment,
data_transferencia timestamp not null,
valor numeric (20,2) not null,
tipo varchar(15) not null,
nome_operador_transacao varchar(50) not null,
conta_id bigint not null,

primary key (id_transferencia),
key conta_id_idx (conta_id),
constraint fk_conta foreign key (conta_id) references conta (id_conta)
) engine=InnoDB default charset=utf8;




