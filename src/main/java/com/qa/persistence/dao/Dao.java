/**
 * This package is used to to send the data to the database.
 */
package com.qa.persistence.dao;

/**
 * Create, Read, Update and Delete dao
 */

import java.util.List;

public interface Dao<T> {

	List<T> readAll();

	void create(T t);

	void update(long id, T t);

	void delete(long id);
}
