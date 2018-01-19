package com.cosmeticsapp.springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connectdb {

	// データベース接続と結果取得のための変数
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public void dbaccess() {
		// JDBCドライバの読み込み
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// JDBCドライバが見つからない場合、例外
			e.printStackTrace();
		}
		try {
			// DBへの接続を行う
			con = DriverManager.getConnection("jdbc:mysql://localhost/cosmetics", "root", "password");
			// DB処理のための準備、Statementオブジェクトの作成
			stmt = con.createStatement();
		} catch (SQLException e) {
			// DBとの処理で何らかのエラーがあった場合の例外
			e.printStackTrace();
		}
	}

	// Skintoneテーブルよりデータ取得
	public ArrayList<SkintoneData> getSkintone() {

		try {
			// Select文の実行と結果を格納/代入
			rs = stmt.executeQuery("SELECT * FROM skintone;");
			ArrayList<SkintoneData> dataList = new ArrayList<SkintoneData>();

			while (rs.next()) {
				SkintoneData sd = new SkintoneData();

				sd.setId(rs.getString("tone_id"));
				sd.setVal(rs.getString("toneName"));
				sd.setRgb(rs.getString("rgbColor"));

				dataList.add(sd);
			}
			return dataList;
		} catch (SQLException e) {
			// DBとの処理で何らかのエラーがあった場合の例外
			e.printStackTrace();
		}
		// データ取得失敗の場合はNULLを返す
		return null;
	}
	
	//Skintypeテーブルよりデータ取得
	public ArrayList<SkintypeData> getSkintype() {

		try {
			// Select文の実行と結果を格納/代入
			rs = stmt.executeQuery("SELECT * FROM skintype;");
			ArrayList<SkintypeData> dataList = new ArrayList<SkintypeData>();

			while (rs.next()) {
				SkintypeData st = new SkintypeData();

				st.setId(rs.getString("type_id"));
				st.setVal(rs.getString("typeName"));
				dataList.add(st);
			}
			return dataList;
		} catch (SQLException e) {
			// DBとの処理で何らかのエラーがあった場合の例外
			e.printStackTrace();
		}
		// データ取得失敗の場合はNULLを返す
		return null;
	}
	
	//Coverage
	public ArrayList<CoverageData> getCoverage(){
		try {
			rs = stmt.executeQuery("Select * FROM coverage;");
			ArrayList<CoverageData> dataList = new ArrayList<CoverageData>();
			
			while(rs.next()) {
				CoverageData cd = new CoverageData();
				
				cd.setId(rs.getString("cover_id"));
				cd.setVal(rs.getString("coverageName"));
				dataList.add(cd);
			}
			
			return dataList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Finish
	public ArrayList<FinishData> getFinish(){
		try {
			rs = stmt.executeQuery("Select * FROM finish;");
			ArrayList<FinishData> dataList = new ArrayList<FinishData>();
			
			while(rs.next()) {
				FinishData fd = new FinishData();
				
				fd.setId(rs.getString("finish_id"));
				fd.setVal(rs.getString("finishName"));
				dataList.add(fd);
			}
			return dataList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CosmeData> getData(Data data) {
		// JDBCドライバの読み込み
		try {			
			String sql =	"SELECT * FROM cosmetics.items WHERE item_id IN " +
							"(	SELECT " +
							"		item_id " +
							"	FROM " +
							"		(SELECT item_id FROM itemskintone WHERE tone_id = " + data.getAnswer1() + ") as tone" +
							"		INNER JOIN " +
							"		(SELECT item_id FROM itemskintype WHERE type_id = " + data.getAnswer2() + ") as type USING (item_id)" +
							"		INNER JOIN " +
							"		(SELECT item_id FROM itemcoverage WHERE cover_id = " + data.getAnswer3() + ") as cover USING (item_id)" +
							"		INNER JOIN " +
							"		(SELECT item_id FROM itemfinish WHERE finish_id = " + data.getAnswer4() + ") as finish USING (item_id)" +
							");";
			// FOR DEBUG
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			
			// 結果を表示する
			ArrayList<CosmeData> dataList = new ArrayList<CosmeData>();

			while (rs.next()) {
				CosmeData cd = new CosmeData();

				cd.setName(rs.getString("name"));
				cd.setBrand(rs.getString("brand"));
				cd.setColor(rs.getString("color"));
				cd.setPicture(rs.getString("picture"));

				dataList.add(cd);
			}
			
			return dataList;
		} catch (SQLException e) {
			// DBとの処理で何らかのエラーがあった場合の例外
			e.printStackTrace();
		}
		// データ取得失敗の場合はNULLを返す
		return null;
	}

	// DB終了処理
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
