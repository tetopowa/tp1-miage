package com.acme.mailreader.utils;

import java.time.Instant;

import cucumber.api.Transformer;

/**
 * Convertisseur de String en Instant pour les tests cucumber
 *
 */
public class InstantConverter extends Transformer<Instant> {

	@Override
	public Instant transform(String value) {
		return Instant.parse(value);
	}

}
