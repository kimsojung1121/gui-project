package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO extends JdbcDAO {
	private static MemberDAO _dao;

	private MemberDAO() {
		
	}
	
	static {
		_dao=new MemberDAO();
	}
	
	public static MemberDAO getDAO() {
		return _dao;
	}
	
	
	
	public int insertMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;//SQL ����� ���� ����� �����ϱ� ���� ����
		try {
			con=getConnection();
			
			String sql="insert into member values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, member.getMno());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMphone());
			pstmt.setString(4, member.getMdate());
			pstmt.setInt(5, member.getMpay());
			pstmt.setInt(6, member.getSno());
				
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]insertMember() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int deleteMember(int mno) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="delete from member where mno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]deleteMember() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	public int updateMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set mname=?,mphone=?,mdate=?,mpay=?,sno=? where mno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMphone());
			pstmt.setString(3, member.getMdate());
			pstmt.setInt(4, member.getMpay());
			pstmt.setInt(5, member.getSno());
			pstmt.setInt(6, member.getMno());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]updateMember() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public MemberDTO selectMno(int mno) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="select * from member where mno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
				//DTO �ν��Ͻ� ���� - �ν��Ͻ� �ʵ忡�� �⺻�� ���� 
				member=new MemberDTO();
				//�˻����� �÷����� DTO �ν��Ͻ��� �ʵ尪���� ���� ó��(Oracle >> Java)
				member.setMno(rs.getInt("mno"));
				member.setMname(rs.getString("mname"));
				member.setMphone(rs.getString("mphone"));
				member.setMdate(rs.getString("mdate").substring(0, 10));
				member.setMpay(rs.getInt("mpay"));
				member.setSno(rs.getInt("sno"));

			}
		} catch (SQLException e) {
			System.out.println("[����]selectMno() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//�˻����� ���� ��� null ��ȯ,�˻����� �ִ� ��� DTO �ν��Ͻ� ��ȯ
		return member;
	}	
	
	
	public MemberDTO selectMname(String mname) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="select * from member where mname=? order by mno";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mname);
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
				//DTO �ν��Ͻ� ���� - �ν��Ͻ� �ʵ忡�� �⺻�� ���� 
				member=new MemberDTO();
				//�˻����� �÷����� DTO �ν��Ͻ��� �ʵ尪���� ���� ó��(Oracle >> Java)
				member.setMno(rs.getInt("mno"));
				member.setMname(rs.getString("mname"));
				member.setMphone(rs.getString("mphone"));
				member.setMdate(rs.getString("mdate").substring(0, 10));
				member.setMpay(rs.getInt("mpay"));
				member.setSno(rs.getInt("sno"));

			}
		} catch (SQLException e) {
			System.out.println("[����]selectMname() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//�˻����� ���� ��� null ��ȯ,�˻����� �ִ� ��� DTO �ν��Ͻ� ��ȯ
		return member;
	}	
	
	
	
	public List<MemberDTO> selectMemberList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MemberDTO> memberList=new ArrayList<MemberDTO>();
		try {
			con=getConnection();
			
			String sql="select * from member order by mno";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member=new MemberDTO();
				member.setMno(rs.getInt("mno"));
				member.setMname(rs.getString("mname"));
				member.setMphone(rs.getString("mphone"));
				member.setMdate(rs.getString("mdate").substring(0, 10));
				member.setMpay(rs.getInt("mpay"));
				member.setSno(rs.getInt("sno"));
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("[����]selectMemberList() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return memberList;
	}	
	
	
	public List<MemberDTO> selectSnoMemberList(int sno) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MemberDTO> memberList=new ArrayList<MemberDTO>();
		
		try {
			con=getConnection();
			
			String sql="select * from member where sno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member=new MemberDTO();
				member.setMno(rs.getInt("mno"));
				member.setMname(rs.getString("mname"));
				member.setMphone(rs.getString("mphone"));
				member.setMdate(rs.getString("mdate").substring(0, 10));
				member.setMpay(rs.getInt("mpay"));
				member.setSno(rs.getInt("sno"));
			}
		} catch (SQLException e) {
			System.out.println("[����]selectSnoMemberList() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return memberList;
	}
}
