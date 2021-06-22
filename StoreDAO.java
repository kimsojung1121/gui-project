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
	
	//점포 정보를 전달받아 STORE 테이블에 새로운 행으로 삽입하여 점포 정보를 저장하고 삽입행의 개수를 반환하는 메소드
	public int insertStore(StoreDTO store) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;//SQL 명령의 실행 결과를 저장하기 위한 변수
		try {
			con=getConnection();
			
			String sql="insert into store values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, store.getSno());
			pstmt.setString(2, store.getSname());
			pstmt.setString(3, store.getSphone());
				
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStore() 메소드의 SQL 오류 = "+e.getMessage());
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
			System.out.println("[에러]deleteStore() 메소드의 SQL 오류 = "+e.getMessage());
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
			System.out.println("[에러]updateStore() 메소드의 SQL 오류 = "+e.getMessage());
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
				//DTO 인스턴스 생성 - 인스턴스 필드에는 기본값 저장 
				store=new StoreDTO();
				//검색행의 컬럼값을 DTO 인스턴스의 필드값으로 매핑 처리(Oracle >> Java)
				store.setSno(rs.getInt("sno"));
				store.setSname(rs.getString("sname"));
				store.setSphone(rs.getString("sphone"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectSno() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//검색행이 없는 경우 null 반환,검색행이 있는 경우 DTO 인스턴스 반환
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
				//DTO 인스턴스 생성 - 인스턴스 필드에는 기본값 저장 
				store=new StoreDTO();
				//검색행의 컬럼값을 DTO 인스턴스의 필드값으로 매핑 처리(Oracle >> Java)
				store.setSno(rs.getInt("sno"));
				store.setSname(rs.getString("sname"));
				store.setSphone(rs.getString("sphone"));

			}
		} catch (SQLException e) {
			System.out.println("[에러]selectSname() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//검색행이 없는 경우 null 반환,검색행이 있는 경우 DTO 인스턴스 반환
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
			System.out.println("[에러]selectStoreList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return storeList;
	}	
	
	
}
