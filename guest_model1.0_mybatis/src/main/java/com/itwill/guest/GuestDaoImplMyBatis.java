package com.itwill.guest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public GuestDaoImplMyBatis() {
		try {
			InputStream myBatisConfigInputStream;
			myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int rowCount = guestMapper.insert(guest);
		sqlSession.close();
		return guest.getGuestNo();
	}

	@Override
	public int update(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		guestMapper.update(guest);
		sqlSession.close();
		return 0;
	}

	@Override
	public int delete(int guestNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		guestMapper.delete(guestNo);
		return 0;
	}

	@Override
	public Guest findByGuestNo(int guestNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		Guest guest = guestMapper.findByGuestNo(guestNo);
		sqlSession.close();
		return guest;
	}

	@Override
	public List<Guest> findByAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		List<Guest> guestList = guestMapper.findByAll();
		sqlSession.close();
		return guestList;
	}

}
