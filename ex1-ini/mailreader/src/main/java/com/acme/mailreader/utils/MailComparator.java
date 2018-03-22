package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {
	
	public static final int EGAUX = 0;
	public static final int MOINSUN = -1;
	public static final int UN = 1;
	
	public int compare(Mail mail, Mail autreMail) {
		if (unDesDeuxNul(mail, autreMail)) {
			return EGAUX;
		}
		if (pasLaMemeImportance(mail, autreMail)) {
			return comparerParImportance(mail, autreMail);
		}
		if (pasLeMemeStatut(mail, autreMail)) {
			return trierParStatut(mail, autreMail);
		}
		if (pasLeMemeSujet(mail, autreMail)) {
			return comparerParSujet(mail, autreMail);
		}
		return autreMail.getDate().compareTo(mail.getDate());
	}

	private int comparerParSujet(Mail mail, Mail autreMail) {
		return autreMail.getSujet().compareTo(mail.getSujet());
	}

	private int trierParStatut(Mail mail, Mail autreMail) {
		int comp = mail.getStatut().ordinal()
				- autreMail.getStatut().ordinal();
		return comp > 0 ? MOINSUN : UN;
	}

	private int comparerParImportance(Mail mail, Mail autreMail) {
		if (mail.isImportant() && !autreMail.isImportant()) {
			return MOINSUN;
		} else {
			return UN;
		}
	}

	private boolean pasLeMemeSujet(Mail mail, Mail autreMail) {
		return mail.getSujet() != autreMail.getSujet();
	}

	private boolean pasLeMemeStatut(Mail mail, Mail autreMail) {
		return mail.getStatut() != autreMail.getStatut();
	}

	private boolean pasLaMemeImportance(Mail mail, Mail autreMail) {
		return mail.isImportant() != autreMail.isImportant();
	}

	private boolean unDesDeuxNul(Mail mail, Mail autreMail) {
		return mail == null || autreMail == null;
	}
}
