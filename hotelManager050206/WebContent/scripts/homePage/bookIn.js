$(function(){
	$(window).load(function(){
		//��ס��ȡ������
		if($("#tip").val()=="�����ɹ�"){
			alert($("#tip").val());
		}
		
		//�������ѡ����Ĭ��ѡ��
		var $module0=$("#content .leftFrame .module:eq(1)");
		$module0.addClass("frame_selected").css({background:"rgb(20,120,170)"});
		$module0.find("dd").show();
		$module0.find("dt .arrow")
			.prop("src","images/homePage/leftFrame/frame_icon_down.png");
		
		//��ȷ��ѯ�ύ
		$("#query_value").change(function(){
			var value=$(this).val();
			if(value!=""){
				$("#query_form").trigger("submit");
			}
		});
		
		//ԤԼ��ס
		$(".book_in").click(function(){
			var bookId=$(this).parent().parent().find(".bookId").html();
			location.href="bookOptionPro?option=0&&bookId="+bookId;
		});
		$(".book_cancle").click(function(){
			var bookId=$(this).parent().parent().find(".bookId").html();
			location.href="bookOptionPro?option=1&&bookId="+bookId;
		});
	});
});