<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<link rel="stylesheet" href="./css/latte.css">
<link rel="stylesheet" href="./css/productList.css">
<link rel="stylesheet" href="./css/image.css">
<link rel="stylesheet" href="./css/message.css">
<title>商品一覧</title>
</head>
<body>

<!-- ヘッダー　検索窓など -->
<div id="header">
<jsp:include page="header.jsp"/>
</div>

<!-- 商品一覧画面 -->
<div id="contents">

	<h1>商品一覧画面</h1>


<!-- 検索結果 -->

	<!-- 検索結果、ヒットなしorエラー -->

<s:if test="stringList.size() >0">
<div class="error-message">
	<s:property value="stringList" />
</div>
</s:if>


<s:if test="errorMessage != null">
<div class="error">
	検索結果がありません。
</div>
</s:if>


	<!-- 検索結果、ヒット有り-->
<s:if test="productInfoDTOList != null">
	<!-- 商品名等クリックで詳細へ＆商品ID転送(js) -->
	<s:form action="ProductDetailsAction">
		<table class="searchItem">
				<s:iterator value="productInfoDTOList" status="st">

				<s:if test="#st.index%3 == 0"><tr> </s:if>
					<td>
						<!-- 表示項目 -->
						<a href="<s:url action='ProductDetailsAction' ><s:param name="productId" value="%{productId}"/></s:url> ">
							<img class="getImg" src="<s:property value='imageFilePath' />/<s:property value='imageFileName' />" /><br>
							<s:property value="productName" /><br>
							<s:property value="productNameKana" /><br>
							<s:property value="price" />円<br>
						</a>
					</td>
				</s:iterator>
		</table>
	</s:form>
</s:if>
</div>
</body>
</html>