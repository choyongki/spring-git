package com.freeflux.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freeflux.biz.board.BoardVO;

/*@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport {

	public BoardDAOMybatis() {}
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
*/	
@Repository
public class BoardDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo){
		
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	public void updateBoard(BoardVO vo){
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo){
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo){
		
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}

}
