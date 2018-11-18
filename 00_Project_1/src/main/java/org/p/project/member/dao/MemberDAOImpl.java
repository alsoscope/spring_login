package org.p.project.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.p.project.member.dto.MemberDTO;
import org.p.project.member.model.MemberVO;
import org.springframework.stereotype.Repository;

//ȸ����� ����
//���� Ŭ������ DAO bean���� ��Ͻ�Ŵ
@Repository
public class MemberDAOImpl implements MemberDAO {

	//SqlSession ��ü�� ���������� �����Ͽ� ���Խ�Ŵ
	//�������� ����(Dependency Injection, DI)
	//������ ����
	//IoC (Inversion of Control, ������ ����)
	@Inject
	SqlSession sqlSession;
	//Inject ������̼��� ������ sqlSession�� null ����������
	//Inject ������̼��� ������ �ܺο��� ��ü�� ���Խ����ְ� �ȴ�
	//try-catch��, finally��, ��ü�� close �� �ʿ䰡 ��������

	//ȸ�����
	@Override
	public List<MemberVO> memberList() {
		return sqlSession.selectList("member2.memberList");
	}

	//ȸ�� ���
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member2.insertMember", vo);
	}
	
	//ȸ������ �� ��ȸ
	@Override
	public MemberVO viewMember(String userId) {
		return sqlSession.selectOne("member2.viewMember", userId);
	}

	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member2.deleteMember", userId);
	}

	//ȸ�� ���� ���� ó��
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member2.updateMember", vo);
	}

	//ȸ������ ���� �� ������ ���� ��й�ȣ üũ
	@Override
	public boolean checkPw(String userId, String userPw) {
		boolean result=false;
		Map<String, String> map=new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count=sqlSession.selectOne("member2.checkPw", map);
		if(count==1) result=true;
		return result;
	}

	//�α���
	@Override
	public MemberVO login(MemberDTO dto) throws Exception {
/*		Map<String, String> map=new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);*/
		return sqlSession.selectOne("member2.memberLogin", dto);
	}
}