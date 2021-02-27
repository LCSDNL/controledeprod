package com.LCSDNL.controledeproducao.database;

public class ScriptDLL {

	public static String getCreateTableFuncionario(){
		StringBuilder sql= new StringBuilder();
		sql.append("  CREATE TABLE IF NOT EXISTS pessoas (");
		sql.append(" 		 ID           INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,");
		sql.append(" 		 nome         VARCHAR (70) NOT NULL,");
		sql.append(" 		 cpf          VARCHAR (20) DEFAULT (),");
		sql.append(" 		 telefone     VARCHAR (20) DEFAULT (),");
		sql.append(" 		 [valor/hora] DOUBLE (10) NOT NULL (),");
		sql.append(" 		 cargo		  VARCHAR (50) DEFAULT () );");

		return sql.toString();

	}

	public  static  String getCreateTableModelos(){

		StringBuilder sql=new StringBuilder();
	sql.append("	CREATE TABLE IF NOT EXISTS modelos ( ");
	sql.append("			ID		INTEGER      PRIMARY KEY AUTOINCREMENT ");
	sql.append("			NOT NULL, ");
	sql.append("			modelo 	VARCHAR (30) NOT NULL ");
	sql.append("			DEFAULT (), ");
	sql.append("			tipo	VARCHAR (20) DEFAULT (), ");
	sql.append("			valor	DOUBLE (5)   NOT NULL ");
	sql.append("	); ");

	return sql.toString();

	}
}
