package br.com.battista.sigeco.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.battista.sigeco.model.Member;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@SuppressWarnings("javadoc")
@Stateful
// The @BaseEntity stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @BaseEntity stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class MemberRegistration {
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	@Inject
	private Event<Member> memberEventSrc;
	
	private Member newMember;
	
	@Produces
	@Named
	public Member getNewMember() {
		return newMember;
	}
	
	@PostConstruct
	public void initNewMember() {
		newMember = new Member();
	}
	
	public void register() throws Exception {
		log.info("Registering " + newMember.getName());
		em.persist(newMember);
		memberEventSrc.fire(newMember);
		initNewMember();
	}
}
