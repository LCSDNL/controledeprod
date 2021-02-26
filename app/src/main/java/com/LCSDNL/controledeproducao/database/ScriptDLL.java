package com.LCSDNL.controledeproducao.database;

public class ScriptDLL {

	public static String getCreateTableFuncionario(){
		StringBuilder sql= new StringBuilder();
		sql.append("  CREATE TABLE IF NOT EXISTS pessoas (");
		sql.append("  ID           INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,");
		sql.append("  nome         VARCHAR (70) NOT NULL,");
		sql.append("  cpf          VARCHAR (20) DEFAULT (),");
		sql.append("  telefone     VARCHAR (20) DEFAULT (),");
		sql.append("  [valor/hora] VARCHAR (10) DEFAULT (),");
		sql.append("  cargo		   VARCHAR (50) DEFAULT () );");

		return sql.toString();

	}
}
