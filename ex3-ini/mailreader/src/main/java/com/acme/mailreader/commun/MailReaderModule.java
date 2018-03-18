package com.acme.mailreader.commun;

import com.google.inject.AbstractModule;

/**
 * Module de configuration Guice 
 * @author bflorat
 *
 */
public class MailReaderModule extends AbstractModule {

	private boolean production = false;

	public MailReaderModule(boolean production) {
		super();
		this.production = production;
	}

	@Override
	protected void configure() {

		if (production) {
			//TODO
		} else {
			//TODO

		}
	}

}
