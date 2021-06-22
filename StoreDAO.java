package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StoreDAO extends JdbcDAO {
	private static StoreDAO _dao;

	private StoreDAO() {
		
	}
	
	static {
		_dao=new StoreDAO();
	}
	
	public static StoreDAO getDAO() {
		return _dao;
	}
	
	//���� ������ ���޹޾� STORE ���̺� ���ο� ������ �����Ͽ� ���� ������ �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int insertStore(StoreDTO store) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;//SQL ����� ���� ����� �����ϱ� ���� ����
		try {
			con=getConnection();
			
			String sql="insert into store values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, store.getSno());
			pstmt.setString(2, store.getSname());
			pstmt.setString(3, store.getSphone());
				
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]insertStore() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int deleteStore(int sno) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from store where sno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]deleteStore() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int updateStore(StoreDTO store) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update store set sname=?,sphone=? where sno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, store.getSname());
			pstmt.setString(2, store.getSphone());
			pstmt.setInt(3, store.getSno());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]updateStore() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
		
	public StoreDTO selectSno(int sno) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StoreDTO store=null;
		try {
			con=getConnection();
			
			String sql="select * from store where sno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
				//DTO �ν��Ͻ� ���� - �ν��Ͻ� �ʵ忡�� �⺻�� ���� 
				store=new StoreDTO();
				//�˻����� �÷����� DTO �ν��Ͻ��� �ʵ尪���� ���� ó��(Oracle >> Java)
				store.setSno(rs.getInt("sno"));
				store.setSname(rs.getString("sname"));
				store.setSphone(rs.getString("sphone"));
			}
		} catch (SQLException e) {
			System.out.println("[����]selectSno() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//�˻����� ���� ��� null ��ȯ,�˻����� �ִ� ��� DTO �ν��Ͻ� ��ȯ
		return store;
	}	
		
	public StoreDTO selectSname(String sname) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StoreDTO store=null;
		try {
			con=getConnection();
			
			String sql="select * from store where sname like ? order by sno";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+sname+"%");
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
				//DTO �ν��Ͻ� ���� - �ν��Ͻ� �ʵ忡�� �⺻�� ���� 
				store=new StoreDTO();
				//�˻����� �÷����� DTO �ν��Ͻ��� �ʵ尪���� ���� ó��(Oracle >> Java)
				store.setSno(rs.getInt("sno"));
				store.setSname(rs.getString("sname"));
				store.setSphone(rs.getString("sphone"));

			}
		} catch (SQLException e) {
			System.out.println("[����]selectSname() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//�˻����� ���� ��� null ��ȯ,�˻����� �ִ� ��� DTO �ν��Ͻ� ��ȯ
		return store;
	}	
	
	public List<StoreDTO> selectStoreList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StoreDTO> storeList=new ArrayList<StoreDTO>();
		try {
			con=getConnection();
			
			String sql="select * from store order by sno";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StoreDTO store=new StoreDTO();
				store.setSno(rs.getInt("sno"));
				store.setSname(rs.getString("sname"));
				store.setSphone(rs.getString("sphone"));

				storeList.add(store);
			}
		} catch (SQLException e) {
			System.out.println("[����]selectStoreList() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return storeList;
	}	
	
	
}
