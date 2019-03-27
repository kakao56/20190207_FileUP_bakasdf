<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
/* 	$(document).on('change', 'input[type=file]', function(){
	  
	 var width = 900;
	 var height = 900;
	 var $target = $(this);
	 
	 if(window.FileReader){ //FileReader를 지원하는 브라우저의 경우 IE 10이상, 크롬..
		 var reader = new FileReader();
		 reader.onload = function (e) {
		 $('body').append('<img src="" id="temp_img" style="display:none;" />');  //보이지 않는 임시 img 태그를 생성.
		 $img = $('#temp_img').attr('src', e.target.result);                          //파일을 선택했을 경우 정보를 $img 객체에 저장 
			 if($img.width() >= width || $img.height() >= height){                  //가로 세로 사이즈 비교 후 반환
				 alert('지정된 크기와 맞지 않습니다.('+width + 'x'+ height +')'+'가로:'+$img.width()+",세로 :"+$img.width());
				 $target.val('');
				 $('#temp_img').remove(); //위에서 생성한 임시 img 태그 삭제
				 return;
			 }
		 };
		 reader.readAsDataURL($(this)[0].files[0]);  //파일을 img 태그에 보여줄 수 있도록 base64로 url을 생성합니다.

	 } else {                                               //FileReader를 지원하지 않는 브라우저의 경우 IE 9 이하
	    $(this)[0].select();
	    var src = document.selection.createRange().text;	    
	    $('body').append('<img src="" id="temp_img" style="display:none;" />');
	    $img = $('#temp_img').attr('src', src);
	    $('#temp_img').remove();
	    if($img.width() >= width || $img.height() >= height){
	        alert('지정된 크기와 맞지 않습니다.('+width + 'x'+ height +')');
	        $(this).val('');
	        return;
	    }
	 }

	 $('#temp_img').remove(); 
	});
	 */
	$(function(){ 
		$("input:eq(1)").click(function(){
			$("form").attr("action","fileup").submit();
		});
	});
	
	
	function download(fname) {
		location.href = "filedown?dir="+encodeURIComponent("C:/Users/김님/Desktop/kcj&filename")+"&fileName="
				+ encodeURIComponent(fname);
	}

</script>
</head>
<body>
	<form id="fileupfrm" method="post" enctype="multipart/form-data">
		<input type="file" name="file" accept="image/*" multiple="multiple"><!--  image 내장함수로 가로세로 제한 주기 그림판으로 비교 해? -->
														<!-- 이게 하나의 태그로 여러개 파일 선택하게 한것 list로 받아야해 -->
	</form>
	<input type="button" value="파일업로드">
	
	<a href="filedown?dir=C://Users//김님//Desktop//kcj&fileName=pagecss.txt">pagecss</a>
	<a href="javascript:download('pagecss.txt')">pagecss</a>
	<a href="javascript:download('새 텍스트 문서.txt')">새 텍스트 문서</a>
	안녕하세요~ ㅂㅂ ㅋㅋ
	
</body>
</html>