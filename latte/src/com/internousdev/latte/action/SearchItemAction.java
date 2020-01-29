package com.internousdev.latte.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.latte.dao.MCategoryDAO;
import com.internousdev.latte.dao.ProductInfoDAO;
import com.internousdev.latte.dto.MCategoryDTO;
import com.internousdev.latte.dto.ProductInfoDTO;
import com.internousdev.latte.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

//jspから受け・渡す値
	//検索時に使う変数
	 //カテゴリーID(1,2,,,,,)
	private int categoryId;
	 //カテゴリー名（全カテ、本、、、）
	private String categoryName;
	 //検索窓の結果
	private String searchWord;
	 //エラーメッセージ(検索結果)
	private String errorMessage=null;

	//各リスト
		//検索結果一覧リスト
	private List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();

	//エラーメッセージのリスト(インスタンス)
	private List<String> stringList=new ArrayList<String>();


	//マップ
	private Map<String,Object>session;


	//メソッド
	public String execute() {

		//検索ワードがnull," ","　"の時 searchWordを""に設定
		if(StringUtils.isBlank(searchWord)) {
			searchWord="";

		//文字有
		}else {
			//検索結果を判定
		InputChecker inputChecker=new InputChecker(); //文字制御
		stringList=inputChecker.doCheck("検索ワード",searchWord,0,50,true,true,true,true,true,true);
		}


		// キーワードの"　"を" "に変換して" "2個以上を" "に変換し、前後のスペースを削除
		searchWord = searchWord.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();

		//ワード有の場合エラー分岐
			//エラーが出たか、出ないか
			//エラー無
			if(stringList.size() == 0) {


				//productInfoDaoから取得したものをリストに格納
				ProductInfoDAO productInfoDao=new ProductInfoDAO();

				//検索条件
					//カテゴリID(全て)
				if(categoryId == 1) {
						//検索ワード有
					if(! StringUtils.isBlank(searchWord)) {
						productInfoDTOList=productInfoDao.serchItemInfoBaseOnWord(searchWord.split(" "));

						//検索ワード無
					}else if(StringUtils.isBlank(searchWord)){
						 //全件表示
						productInfoDTOList=productInfoDao.allSelect();
					}

					//カテゴリID(選択)
				}else if(categoryId > 1) {
					//検索ワード有
					if(! StringUtils.isBlank(searchWord)) {
						 //カテIDと検索ワードで検索
						productInfoDTOList=productInfoDao.getProductInfoListByCategoryIdAndKeyword(categoryId,searchWord.split(" "));

						//検索ワード無
					}else if(StringUtils.isBlank(searchWord)){
						productInfoDTOList=productInfoDao.serchItemInfoBaseOnCategory(categoryId);
					}
				}


				//リストに商品情報があるか、ないか
					//無
				if(productInfoDTOList.size() == 0) {

						//"検索結果なし"をセット
					setErrorMessage("検索結果無し");

				}


			}

			//カテ名/IDをsessionに入れてjspへ送る
				//カテゴリーリスト
				if(! session.containsKey("mCategoryDtoList")) {
					List<MCategoryDTO> mCategoryDtoList=new ArrayList<MCategoryDTO>();
					MCategoryDAO mCategryDao=new MCategoryDAO();
					mCategoryDtoList=mCategryDao.setCategoryInfo();

				//sessionに格納(カテID/Name)
					session.put("mCategoryDtoList", mCategoryDtoList);
				}

		return SUCCESS;
	}


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

	public List<String> getStringList() {
		return stringList;
	}


	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
