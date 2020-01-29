package com.internousdev.latte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.latte.dto.MCategoryDTO;
import com.internousdev.latte.util.DBConnector;

//SarchItemActionから送られてきたカテゴリーIDを元にDB(m_category)へ検索を掛けて、カテIDとカテNameを受け取る
public class MCategoryDAO{

	List<MCategoryDTO> mCategoryDtoList=new ArrayList<MCategoryDTO>();

	public List<MCategoryDTO> setCategoryInfo(){

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		//DBからカテゴリー名/IDを検索する
		String sql="SELECT * FROM m_category";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			//カテゴリーIDで検索
			ResultSet rs=ps.executeQuery();

			//MCategoryDTOに値を代入
			while(rs.next()) {
				MCategoryDTO dto=new MCategoryDTO();
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setCategoryName(rs.getString("category_name"));

				mCategoryDtoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return mCategoryDtoList;
	}
}
