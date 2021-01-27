package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	// 핵심 의존객체
	@Autowired
	private SqlSession session;
	
	// 프로필 이미지 경로 수정
	@Override
	public void updateProfile(UsersDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => updateProfile
		 *  parameterType => UsersDto
		 */
		session.update("users.updateProfile",dto);
	}
	// 아이디 존재 여부 리턴
	@Override
	public boolean isExist(String id) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => isExist
		 *  parameterType => String
		 *  resultType => UsersDto
		 */
		// id가 존재하지 않으면(이미 등록된 아이디) null 이 아니고 존재하지 않으면 null 이다.
		UsersDto exist=session.selectOne("users.isExist", id);
		return false;
	}
	// 비밀번호 수정
	@Override
	public void updatePwd(UsersDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => updatePwd
		 *  parameterType => UsersDto
		 */
		session.update("users.updatePwd", dto);
	}
	// 회원가입 정보 수정 반영
	@Override
	public void update(UsersDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => update
		 *  parameterType => UsersDto
		 */
		session.update("users.update", dto);
	}
	// 회원가입 정보 삭제
	@Override
	public void delete(String id) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => delete
		 *  parameterType => String
		 */
		session.delete("users.delete", id);
	}
	// 가입정보 리턴
	@Override
	public UsersDto getData(String id) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => getData
		 *  parameterType => String
		 *  resultType => UsersDto
		 */
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}
	// 인자로 전달된 정보가 유효한 정보인지 리턴
	@Override
	public boolean isValid(UsersDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => isValid
		 *  parameterType => UsersDto
		 *  resultType => String
		 */
		String id=session.selectOne("users.inValid", dto);
		if(id==null) { // 잘못된 아이디와 비밀번호
			return false;
		}else { // 유효한 아이디
			return true;
		}
		
		
	}
	// 회원정보를 저장
	@Override
	public void insert(UsersDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => users
		 *  sql의 id => insert
		 *  parameterType => UsersDto
		 */
		session.insert("users.insert",dto);
	}
	
}
