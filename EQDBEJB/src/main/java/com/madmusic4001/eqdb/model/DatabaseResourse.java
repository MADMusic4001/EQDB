/**
 * 
 */
package com.madmusic4001.eqdb.model;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Produces an injectable EntityManager for integration testing
 */
public class DatabaseResourse {
	@Produces
	@PersistenceContext(unitName="EQDBPU")
	private EntityManager em;
}
