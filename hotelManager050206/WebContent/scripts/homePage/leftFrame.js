$(function(){
	$(window).load(function(){
		/*���ѡ����*/
		$("#content .leftFrame .module dt .arrow")
			.prop("src","images/homePage/leftFrame/frame_icon_right.png");
		
		$("#content .leftFrame .module").each(function(){
			//�������¼�
			$(this).mouseover(function(){
				$(this).css({background:"rgb(20,120,170)"});
			}).mouseout(function(){
				if(!$(this).hasClass("frame_selected")){
					$(this).css({background:"rgb(15,150,200)"});
				}
			}).click(function(){
				if(!$("#content .leftFrame .module").is(":animated")){
					//����֮ǰѡ�е�ģ��
					var $selectedModule=$("#content .leftFrame .frame_selected");
					//����ѡ��ģ�������
					var index=$("#content .leftFrame .module").index($selectedModule);
					var index2=$("#content .leftFrame .module").index($(this));
					//ѡ�����л�
					if(!$(this).hasClass("frame_selected")){
						$(this).addClass("frame_selected");
						$selectedModule.removeClass("frame_selected")
							.trigger("mouseout");
						
						$(this).find("dt .arrow")
							.prop("src","images/homePage/leftFrame/frame_icon_down.png");
						$selectedModule
							.find("dt .arrow").prop("src","images/homePage/leftFrame/frame_icon_right.png");
						
						$(this).find("dd").stop().slideDown(300);
						$selectedModule.find("dd").stop().slideUp(300);
					}
				}
			});
		});
		$("#content .leftFrame .module dd")
			.mouseover(function(){
				if(!$("#content .leftFrame .module").is(":animated")){
					$(this).css({background:"rgb(0,90,150)"});
				}
			}).mouseout(function(){
				$(this).css({background:"rgb(20,120,170)"});
			}).click(function(){
				location.href=$(this).find("a").prop("href");
			});
		});
});