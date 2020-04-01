package com.projectjuni.projectjunidemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.projectjuni.projectjunidemo.models.committees.DefaultCommittee;
import com.projectjuni.projectjunidemo.models.committees.PraiseAndWorshipCommittee;
import com.projectjuni.projectjunidemo.repositories.VolunteerRepository;
import com.projectjuni.projectjunidemo.repositories.committees.CommitteeRepository;
import com.projectjuni.projectjunidemo.repositories.committees.DefaultRepository;
import com.projectjuni.projectjunidemo.repositories.committees.PraiseAndWorshipRepository;
import com.projectjuni.projectjunidemo.testInit.CommitteeInitialize;
import com.projectjuni.projectjunidemo.testInit.InvokeInitializeDB;
import com.projectjuni.projectjunidemo.testInit.VolunteerInitialize;

@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
// @AutoConfigureTestDatabase(replace=Replace.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class CommitteeTests {

	@Value("${app.env}")
	String appEnv;
	
	@Autowired
	private CommitteeRepository committeeRepository;

	@Autowired
	private DefaultRepository defaultRepository;
	
	@Autowired
	private VolunteerRepository volunteerRepository;

	@Autowired
	private PraiseAndWorshipRepository praiseAndWorshipRepository;
	
	@Autowired
	private CommitteeInitialize committeeInitialize;
	
	@Autowired
	private VolunteerInitialize volunteerInitialize;
	
	@Test
	@Rollback(false)
	public void test1InitiateDBValues() throws Exception {
		InvokeInitializeDB command = new InvokeInitializeDB();
		command.execute(committeeInitialize);
		command.execute(volunteerInitialize);
		assertTrue(true);
	}


	@Test
	@Rollback(false)
	public void test2SaveCommittee() {
		DefaultCommittee committee = new DefaultCommittee();
		committee.setName("default committee");
		committee.setShortName("def");
		committee.setDescription("general");

		assertNotNull(defaultRepository.saveAndFlush(committee));
		assertTrue(defaultRepository.existsByName("default committee"));
		List<DefaultCommittee> committeeList = defaultRepository.findAll();
		assertEquals(committee, committeeList.get(0));
	}

	@Test
	public void test3CheckExistingCommittes() {
		assertEquals(2, committeeRepository.findAll().size());
	}

	@Test
	public void test4CheckPersistedStartUpCommittees() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/static/committee_sample.json"));
		PraiseAndWorshipCommittee pawc = new Gson().fromJson(br, PraiseAndWorshipCommittee.class);
		PraiseAndWorshipCommittee paw = praiseAndWorshipRepository.findAll().get(0);
		assertEquals(pawc, paw);
	}

}
