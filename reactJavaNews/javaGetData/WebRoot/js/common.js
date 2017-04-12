var pageNum=0;
var currentWidth=900;
	//显示列数
	var col=4;
	$(function(){
		//懒加载
		$("img.lazy").lazyload({
			load:function(){
				$("#container").BlocksIt({
					numOfcol:col,
					offsetX:8,
					offsetY:8
				});
			}
			
		});
		//为按钮绑定查询事件
		$("#changeTypeBtn").click(function(){
			loadImages();
		});
		$("#category").change(function(){
			$("#container").html('');
			pageNum = 0;
		});
		//响应式布局
		$(window).resize(function(){
			var winWidth = $(window).width();
			var colWidth ;                   	//图片容器宽度
			if(winWidth < 660 ){
				colWidth = 440 ;
				col = 2 ;
			}else if(winWidth < 880){
				colWidth = 660 ;
				col = 3 ;
			}else if(winWidth < 1000){
				colWidth = 880 ;
				col = 4 ;
			}else{
				colWidth = 1000 ;
				col = 5 ;
			}
			if(colWidth != currentWidth){
				currentWidth = colWidth;
				$("#container").width(colWidth);
				$("#container").BlocksIt({
					numOfcol:col,
					offsetX:8,
					offsetY:8
				});
			}
		});
		//给窗口绑定滚动事件
		$(window).scroll(function(){
			if(($(document).height()-$(this).scrollTop()-$(this).height)<50){
				loadImages();
			}
			if($(this).scrollTop()>200){
				$("#goTop").fadeIn(400);  //淡入
			}else{
				$("#goTop").stop().fadeOut(400);  //淡出
			}
		});
		//后台请求数据
		function loadImages(){
			var category = $("#category").val();//获取类别
			$.ajax({
				url:"GetImagesServlet",
				async:true,
				type:"post",
				data:{pageNum:pageNum,category:category},
				dataType:"json",
				success:function(result){
					for(var i=0;i<result.length;i++){
						var img='';
						img+='<div class="B_show_container_grid"><div class="B_show_container_grid_imgholder">';
						img+='<img src="';
						img+=result[i].surl;
						img+='" class="lazy" url="';
						img+=result[i].surl;
						img+='" width="175" /></div><strong>';
						img+=result[i].title;
						img+='</strong><div class="meta"><a href="';
						img+=result[i].ourl;
						img+='" target="_blank">高清无码原图</a></div>';

						$("#container").append(img);
					}
					pageNum++;
					$("#container").BlocksIt({
						numOfcol:col,
						offsetX:8,
						offsetY:8
					});
					$("img.lazy").lazyload();
				},
				fail:function(){
					alert("请求失败，重新请求！");
				}
			});
		}
	});