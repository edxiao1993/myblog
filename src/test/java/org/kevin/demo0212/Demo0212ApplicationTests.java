package org.kevin.demo0212;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.kevin.demo0212.common.CommonUtils;
import org.kevin.demo0212.model.*;
import org.kevin.demo0212.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Demo0212ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private SecretMomentService secretMomentService;
	@Test
	void testDB(){
		SecretMoment record = new SecretMoment();
		record.setMoment("test my BaseModel");
		System.out.println(secretMomentService.insert(record));

		SecretMomentExample e = new SecretMomentExample();
		e.setOrderByClause("create_time DESC");
		List<SecretMoment> l = secretMomentService.findList(e);
		System.out.println(l.size());
		System.out.println(l.get(0).getId());
		System.out.println("done");
	}

	@Autowired
	private BlogUserService blogUserService;
	@Test
	void insertBlogUser(){
		BlogUser u1 = new BlogUser();
		u1.setUsername("edward");
		u1.setPassword(CommonUtils.securityPwdEncoder("fng"));

		BlogUser u2 = new BlogUser();
		u2.setUsername("kevin");
		u2.setPassword(CommonUtils.securityPwdEncoder("0322"));

		blogUserService.insert(u1);
		blogUserService.insert(u2);
	}

	@Autowired
	private ArticleService articleService;
	@Test
	void testArticleRowBounds(){
		List<Article> list = articleService.findList(7);
		System.out.println(list.size());
	}

	@Autowired
	private CuserService cuserService;
	@Autowired
	private PostService postService;
	@Test
	void testMany2One(){
//		Cuser c = new Cuser();
//		c.setId("whatisthis");
//		cuserService.insert(c);
//
//		Post p1 = new Post();
//		p1.setCuserId(c.getId());
//		p1.setTitle("p1");
//		p1.setContent("this is the p1" + new Date().toString());
//
//		Post p2 = new Post();
//		p2.setCuserId(c.getId());
//		p2.setTitle("p2");
//		p2.setContent("this is the p2" + new Date().toString());
//		postService.insert(p1);
//		postService.insert(p2);

		Cuser user = cuserService.getUserPost("6fad6821b4ce4f79b728047828b28b95");
		System.out.println(user.getPosts().size());
	}
	@Test
	void testOne2Many(){
		String postId = "469fa5a9058144ec8efc06064ae30d02";
		Post p = postService.getPostWithUser(postId);
		System.out.println(p.getContent());
	}
}
