package com.madmusic4001.eqdblient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.testng.annotations.Test;

import com.madmusic4001.eqdb.model.Zone;
import com.madmusic4001.eqdbclient.EQDBClient;

public class EQDBClientTest {
	@Test
	public void testGetZone() {
		EQDBClient client = new EQDBClient();
		Zone zone = client.getZone("test");
		assertThat(zone, is(equalTo(null)));
	}
}
