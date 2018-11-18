package org.p.project.member.dao;

import java.util.List;

import org.p.project.member.dto.MemberDTO;
import org.p.project.member.model.MemberVO;

//�⺻ �޼ҵ� ����
public interface MemberDAO {
	//ȸ�����
	public List<MemberVO> memberList();
	//ȸ���Է�
	public void insertMember(MemberVO vo);
	//ȸ�� ���� �󼼺���
	public MemberVO viewMember(String userId);
	//ȸ�� ����
	public void deleteMember(String userId);
	//ȸ������ ����
	public void updateMember(MemberVO vo);
	//ȸ������ ����, ������ ���� ��й�ȣ üũ
	public boolean checkPw(String userId, String userPw);
	//�α���
	public MemberVO login(MemberDTO dto) throws Exception;
}