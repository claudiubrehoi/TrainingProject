package com.synertrade.training.util;


import java.sql.Types;

import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;

/**
 * SQL Server dialect.
 */
public class MsSqlDialect extends org.hibernate.dialect.SQLServerDialect {

	public MsSqlDialect() {
		super();
		registerFunction("DTTOUNIXTS", new StandardSQLFunction("DTTOUNIXTS", IntegerType.INSTANCE));
		registerFunction("jaro", new StandardSQLFunction("dbo.JARO", FloatType.INSTANCE));
		
		// registerHibernateType(Types.NCHAR, StandardBasicTypes.CHARACTER.getName());
		// registerHibernateType(Types.NCHAR, 1, StandardBasicTypes.CHARACTER.getName());
		// registerHibernateType(Types.NCHAR, 255, StandardBasicTypes.STRING.getName());
		registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
		// registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.TEXT.getName());
		// registerHibernateType(Types.NCLOB, StandardBasicTypes.CLOB.getName());

	}

	@Override
	/**
	 * Get the separator to use for defining cross joins when translating HQL queries.
	 * <p/>
	 * Typically this will be either [<tt> cross join </tt>] or [<tt>, </tt>]
	 * <p/>
	 * Note that the spaces are important!
	 *
	 * @return
	 * 		the method is named getCrossJoinSeparator even though it refers to what a comma in HQL is going to be replaced with, and then there is the comment that says "Typically this will be
	 *         either <tt> cross join </tt> or <tt>, </tt>".
	 *         see https://hibernate.atlassian.net/browse/HHH-5352
	 */
	public String getCrossJoinSeparator() {
		return " , ";
	}

}
