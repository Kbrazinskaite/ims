/**
 * This package is used to perform logic of the application.
 */
package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.Order_Item;

public interface CrudServices<T> {

	public List<T> readAll();

	void create(T t);

	void update(long id, T t);

	public void delete(Long valueOf);

	public void update(Double valueOf, Order_Item t);

}
