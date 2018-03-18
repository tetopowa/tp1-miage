package com.acme.mailreader.bdd;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.MailComparator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Les steps (actions) du test
 * 
 * <p>
 * A noter qu'une nouvelle instance de cette classe est créée à chaque scenario
 * </p>
 *
 */

public class MailOrderStep {

	private List<Mail> listeMailsAvantTri;

	@Given("^les mails :$")
	public void les_mails(List<Mail> mails) throws Throwable {
		listeMailsAvantTri = mails;
	}

	@Then("^la liste ordonnée doit être :$")
	public void la_liste_ordonnée_doit_être(List<Mail> mails) throws Throwable {
		List<Mail> listeMailsApresTri = new ArrayList<Mail>(listeMailsAvantTri);
		Collections.sort(listeMailsApresTri, new MailComparator());
		assertThat(listeMailsApresTri,is(mails));
	}
}
