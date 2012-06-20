package com.acme;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.acme.model.Event;
import com.acme.model.Member;
import com.acme.rest.MemberEndpoint;

@RunWith(Arquillian.class)
public class MemberTest {

    @Deployment
    public static WebArchive deployment() {
	return ShrinkWrap
		.create(WebArchive.class)
		.addClasses(Member.class, Event.class, MemberEndpoint.class)
		.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
		.addAsResource("META-INF/persistence.xml");
    }

    @Inject
    MemberEndpoint endpoint;

    @Test
    public void testMember() {
	Member member = new Member();
	member.setName("Bob");
	member.setPhoneNumber("07769557110");
	member.setEmail("bob@redhat.com");

	endpoint.create(member);

	List<Member> members = endpoint.listAll();
	Assert.assertTrue(checkBobInList(members));
    }

    private boolean checkBobInList(List<Member> members) {
	for (Member m : members) {
	    if (m.getEmail().equals("bob@redhat.com"))
		return true;
	}
	return false;
    }

}
