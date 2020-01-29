<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<header>
<div id="header">
<div id="header-title">Latte</div>

<div id="header-menu">

<ul>
<s:form action="SearchItemAction">
	<!-- カテゴリー欄 -->
	<s:if test="#session.mCategoryDtoList != null && #session.mCategoryDtoList.size() >0">
		<!-- セッションでカテゴリー格納のリストを受け取る -->
	<li class="search"><s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId"/></li>

		 <!-- セッションでカテゴリー格納のリストを受け取りfor文で表示 -->
	</s:if>

	<!-- 検索窓valueは記述無しでも構わないが表示するものを明確にするため -->
	<li class="searchWord"><s:textfield name="searchWord" value="%{searchWord}" placeholder="検索ワード" class="txt-keywords"/></li>

	<li><s:submit value="商品検索" class="submit_btn"/></li>
</s:form>

	<s:if test="#session.logined == 0">
		<s:form action="GoLoginAction">
			<li><s:submit value="ログイン" class="submit_btn"/></li>
		</s:form>
	</s:if>

	<s:else>
		<s:form action="LogoutAction">
			<li><s:submit value="ログアウト" class="submit_btn"/></li>
		</s:form>
	</s:else>


	<s:form action="CartAction">
		<li><s:submit value="カート" class="submit_btn"/></li>
	</s:form>

	<s:form action="SearchItemAction">
		<li><s:submit value="商品一覧" class="submit_btn"/></li>
		<input type="hidden" name="categoryId" value="1" >
	</s:form>

	<s:if test="#session.logined == 1">
		<s:form action="MyPageAction">
			<li><s:submit value="マイページ" class="submit_btn"/></li>
		</s:form>
	</s:if>
</ul>
</div>
</div>
</header>
