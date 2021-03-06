package com.gura.spring04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.exception.DBFailException;
import com.gura.spring04.member.dto.MemberDto;
// component scan 을 통해서 bean 이 되도록 어노테이션을 붙여 준다.
// Dao 에는 @Repository 라는 어노테이션을 붙여야한다.
@Repository
public class MemberDaoImpl implements MemberDao{
	/*
	 *  servlet-context.xml 문서에 bean 설정으로 bean 인 된
	 *  SqlSessionTemplate 객체의 참조값을 필드에 주입(DI) 받는 방법은
	 *  @AutoWired 어노테이션을 필드 앞이나 위에 붙여주면 된다.
	 *  단, MemberDaoImpl(Dao의 수단) 객체도 bean이 되어야 한다.
	 */
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		/*
		 *  Mapper.xml 문서의 namespace => member
		 *  sql의 id => getList
		 *  parameterType => 없음
		 *  resultType => MemberDto
		 */
		
		// .selectList() 를 호출했을때 resultType 이 곧 List 의 Generic type 이 됩니다.
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}
	
	@Override
	public void insert(MemberDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => member
		 *  sql의 id => insert
		 *  parameterType => MemberDto
		 */
		session.insert("member.insert", dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		/*
		 *  Mapper.xml 문서의 namespace => member
		 *  sql의 id => update
		 *  parameterType => MemberDto
		 */
		session.update("member.update", dto);
		
	}

	@Override
	public void delete(int num) {
		/*
		 *  Mapper.xml 문서의 namespace => member
		 *  sql의 id => delete
		 *  parameterType => int
		 */
		// 삭제된 row 의 갯수가 리턴된다.
		int count=session.delete("member.delete", num);
		// 만약 삭제 실패하면
		if(count==0) {
			throw new DBFailException("삭제 실패 했습니다.(삭제할 회원정보가 없습니다.)");
		}
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 *  Mapper.xml 문서의 namespace => member
		 *  sql의 id => getData
		 *  parameterType => int
		 *  resultType => MemberDto
		 */
		
		// .selectOne() 을 호출했을때 resultType 이 곧 리턴 타입이 됩니다.
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}
}
