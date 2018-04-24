package com.hwua.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler<T> {
	public T handleRow(ResultSet rs) throws SQLException;
}
