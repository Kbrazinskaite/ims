/**
 * This package is used to take in a user inputs.
 */
package com.qa.controller;

/**
 * Create, Read, Update and Delete controller. Takes in inputs for each action
 * to be sent to a service class
 */

public interface CrudController<T> {

	void readAll();

	void create();

	void update();

	void delete();

}
