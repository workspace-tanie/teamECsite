package com.internousdev.latte.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.latte.dto.MCategoryDTO;

public class MCategoryDTOTest {

	//testGetCategoryId()　はテストのメソッドであることを示す
	//以下コメントはメソッドのみの記載
	@Test
	public void tesGetCategoryIdMax() {
		MCategoryDTO dto=new MCategoryDTO();
		//期待値の作成
		int expected=2147483647;

		//テスト対象
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();

		//期待値とテスト対象で取得した値が一致するかを確認
		assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryIdMin() {
		MCategoryDTO dto=new MCategoryDTO();
		int expected=-2147483647;

		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryId0() {
		MCategoryDTO dto=new MCategoryDTO();
		int expected=0;

		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	//testSetCategoryId()
	@Test
	public void testSetCategoryIdMax() {
		MCategoryDTO dto=new MCategoryDTO();

		int expected=2147483647;

		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryIdMin() {
		MCategoryDTO dto=new MCategoryDTO();

		int expected=-2147483647;

		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryId0() {
		MCategoryDTO dto=new MCategoryDTO();

		int expected=0;

		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	//testGetCategoryName()
	@Test
	public void testGetCategoryNameNull() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected=null;

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameEmptyCharacter() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}

	@Test
	public void testGetCategoryNameFullSpace() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="　";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameAlphabeticCharacters() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="abc";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameHalfWidthDigit() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="123";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameHiragana() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="てすと";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameKatakana() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="テスト";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameKanji() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="漢字";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testGetCategoryNameAll() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="漢字 テスト　てすと123abc";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}

	//testSetCategoryName()
	@Test
	public void testSetCategoryNameNull() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected=null;

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameEmptyCharacter() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameSpace() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected=" ";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameFullSpace() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="　";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameAlphabeticCharacters() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="abc";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameHalfWidthDigit() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="123";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameHiragana() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="てすと";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameKatakana() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="テスト";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameKanji() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="漢字";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
	@Test
	public void testSetCategoryNameAll() {
		MCategoryDTO dto=new MCategoryDTO();

		String expected="漢字 テスト　てすと123abc";

		dto.setCategoryName(expected);
				String actual=dto.getCategoryName();
				assertEquals(expected,actual);
	}
}
