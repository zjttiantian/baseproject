package com.tiantian.distribute.common.service;

import com.tiantian.distribute.common.bean.Test;
import com.tiantian.distribute.common.mapper.TestMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("testService")

public class TestService extends BaseService<Test> {
	private final static Logger log = Logger.getLogger(TestService.class);

	@Autowired
	private TestMapper<Test> mapper;

	public TestMapper<Test> getMapper() {
		return mapper;
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void addTest(int id){
		insert(id);
		mapper.test(id);
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insert(int id){
		Test u=new Test();
		u.setName("test");
		u.setPassword("test");
		add(u);
	}

}
