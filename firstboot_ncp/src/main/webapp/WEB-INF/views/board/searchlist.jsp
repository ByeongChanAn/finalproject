<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.7.1.min.js"></script>   
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<form action="boardsearchlist">
검색항목 :
<input type=radio name="item" value="all">모두
<input type=radio name="item" value="title">제목
<input type=radio name="item" value="contents">내용
<input type=radio name="item" value="writer">작성자
검색어 : <input type=text name="word" >
<input type=hidden name="pagenum" value="1" >
<input type=submit value="검색요청">
</form>

 <h1>${param.pagenum } 페이지의 검색 리스트입니다. </h1> 
<table border="3">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
	<c:forEach items="${boardsearchlist }" var="dto">
		<tr><td>${dto.seq }</td><td><a href="boarddetail?seq=${dto.seq }">${dto.title }</a></td><td>${dto.writer }</td><td>${dto.viewcount }</td>
	</c:forEach> 
</table> 

<%=request.getAttribute("totalsearchboard") %>
<h3>페이지를 선택하세요</h3>
<% 
int totalboard = (Integer)request.getAttribute("totalsearchboard");
int totalpage = 0;
if(totalboard % 3 == 0){
	totalpage = totalboard / 3;
}
else{
	totalpage = totalboard / 3 + 1;
}

for(int i = 1; i <= totalpage; i++){
%>

 <a href="boardsearchlist?pagenum=<%=i%>&item=${param.item }&word=${param.word }" > <%=i%>페이지 </a> 
<%
}
%>

<a href="boardlist?pagenum=1">전체리스트 보러가기</a>

</body>
</html>





