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
			//JDBCドライバの読み込み
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				//JDBCドライバが見つからない場合、例外
				e.printStackTrace();
			}
			try {
				//DBへの接続を行う
				con = DriverManager.getConnection("jdbc:mysql://localhost/cosmetics","root","password");
				//DB処理のための準備、Statementオブジェクトの作成
				stmt = con.createStatement();				
			} catch (SQLException e) {
				//DBとの処理で何らかのエラーがあった場合の例外
				e.printStackTrace();
			} 
		}
		
		public ArrayList<CosmeData> getData(Data data){
			//JDBCドライバの読み込み
			try {
				//Select文の実行と結果を格納/代入
				rs = stmt.executeQuery("select items.item_id,items.name,items.brand,items.color,items.picture from itemfinish, finish,(select items.item_id,items.name,items.brand,items.color,items.picture from itemskintype,skintype, (select items.item_id,items.name,items.brand,items.color,items.picture from coverage,itemcoverage,(select items.item_id,items.name,items.brand,items.color,items.picture from items,skintone,itemskintone where skintone.tone_id = itemskintone.tone_id and items.item_id = itemskintone.item_id and skintone.toneName = '" + data.getAnswer1() + "') as items where items.item_id = itemcoverage.item_id and itemcoverage.cover_id = coverage.cover_id and coverage.coverName = '" + data.getAnswer3() + "') as items where items.item_id = itemskintype.item_id and itemskintype.type_id = skintype.type_id and skintype.typeName = '" + data.getAnswer2() + "') as items where items.item_id = itemfinish.item_id and itemfinish.finish_id = finish.finish_id and finish.finishName = '" + data.getAnswer4() + "'");
				//結果を表示する
				ArrayList<CosmeData> dataList = new ArrayList<CosmeData>();
				
				while(rs.next()) {
					CosmeData cd = new CosmeData();
					
					cd.setName(rs.getString("name"));
					cd.setBrand(rs.getString("brand"));
					cd.setColor(rs.getString("color"));
					cd.setPicture(rs.getString("picture"));
					
					
					dataList.add(cd);
				}
				return dataList;
			}catch(SQLException e) {
				//DBとの処理で何らかのエラーがあった場合の例外
				e.printStackTrace();
			}
			//データ取得失敗の場合はNULLを返す
			return null;
		}
		//DB終了処理
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
					} catch (SQLException e){
						e.printStackTrace();
					}
				
			}
	}
}
