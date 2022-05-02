package com.mycom.myapp.batch.svc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("batchtest01")
public class BatchTest01svc {
	private PreparedStatement pstmt;
	private Connection con;

	@Transactional(timeout = 10)
	public void testService() throws Exception {
		long timer = System.currentTimeMillis();
		con = null;
		pstmt = null;
		String sql = "INSERT INTO TEST01 VALUES(?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BATCH", "1234");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			for (int i = 0; i < 10000; i++) {
				pstmt.setInt(1, i);
				pstmt.setInt(2, i * 10);
				pstmt.setInt(3, i * 100);
				pstmt.addBatch();
				pstmt.clearParameters();
				if (i % 1000 == 0) {
					pstmt.executeBatch();
					pstmt.clearBatch();
					con.commit();
				}
			}
			pstmt.executeBatch();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

		timer = System.currentTimeMillis() - timer;
		System.out.println(timer / 1000.0f);
	}

	@Transactional(timeout = 10)
	public void nobatch() throws Exception {
		long timer = System.currentTimeMillis();
		con = null;
		pstmt = null;
		String sql = "INSERT INTO TEST01 VALUES(?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BATCH", "1234");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			for (int i = 0; i < 10000; i++) {
				pstmt.setInt(1, i);
				pstmt.setInt(2, i * 10);
				pstmt.setInt(3, i * 100);
				pstmt.execute();
			}
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

		timer = System.currentTimeMillis() - timer;
		System.out.println(timer / 1000.0f);
	}
	public void deleteAll() throws Exception {
		con = null;
		pstmt = null;
		String sql = "DELETE FROM TEST01 WHER 1 = 1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BATCH", "1234");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			con.commit();
			System.out.println("deleted");
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

}
