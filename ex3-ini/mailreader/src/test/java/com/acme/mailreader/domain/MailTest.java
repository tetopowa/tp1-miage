package com.acme.mailreader.domain;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.acme.mailreader.utils.DateIncorrecteException;

public class MailTest {

	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1970() throws DateIncorrecteException {
		Mail mail = new Mail();
		mail.setDate(Instant.parse("1969-01-01T00:00:00.00Z"));
	}
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException {
		Mail mail = new Mail();
		mail.setDate(Instant.parse("2222-01-01T00:00:00.00Z"));
	}

	@Test
	public final void getDateOk() throws DateIncorrecteException{
		Mail mail = new Mail();
		mail.setDate(Instant.parse("2000-01-01T00:00:00.00Z"));
		assertThat(mail.getDate(), is(Instant.parse("2000-01-01T00:00:00.00Z")));
	}
}
