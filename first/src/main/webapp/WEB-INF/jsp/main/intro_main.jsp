<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS</title>
<style>
 html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address,
        big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong,sub, sup, tt, var, b, u, i, center,
        dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside,
        canvas, details, embed,  figure, figcaption, footer, header, hgroup,  menu, nav, output, ruby, section, summary, time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }
        a {color: rgb(51, 51, 51);text-decoration: none;  cursor: pointer; background: 0 0;box-sizing: border-box;}
        a:link{color:#000;}
        .header {}
        .header .gnb { width:1600px; background-color:#353535;  display:inline-block;  box-sizing: border-box;}
        .header .gnb .gnbLeft {overflow:hidden;float:left; width:300px; background-color:#353535; box-sizing:border-box;margin-right: 0px;border: 1px solid red;}
        .header .gnb .gnbRight {overflow:hidden;float:right; width:1000px; background-color:#353535;box-sizing:border-box;  border: 1px solid red;}
        .header .gnb .gnbLeft ul {overflow:hidden;float:left; width:300px; height:30px; line-height:30px; margin:0 auto;  }
        .header .gnb .gnbRight ul {overflow:hidden;float:right;width:1000px; height:30px; line-height:30px; margin:0 auto; margin-right:20px;  }
        .header .gnb .gnbLeft li{float:left; list-style:none; margin-left:50px; font-size:.9em; }
        .header .gnb .gnbRight li{float:left; list-style:none; margin-left:50px; font-size:.9em; }
        .header a{ color:#ffffff; text-decoration:none;}
        .headerContWrap .innerWrap {height:90px; width: 980px; margin:0 auto; text-align:center; position:relative;}
        .headerContWrap .innerWrap h1 {float:left;width:220px;height:90px;padding-top:24px;box-sizing:border-box;}
        .headerContWrap .innerWrap h1 a {display:block;}
        .searchWrap {position:absolute;left:50%;top:24px;width:490px;margin-left:-245px;box-sizing:border-box;}
        .searchWrap fieldset {width:100%;height:36px;border:3px solid #f57e25;}
        .searchWrap fieldset legend {display:none;}
        .searchWrap fieldset input[type="text"] {display:inline-block;border:0;width:444px;height:36px;padding:0 15px;line-height:36px;box-sizing:border-box;vertical-align:top;}
        .searchWrap fieldset input[type="text"]::-webkit-input-placeholder {font-weight:bold;color:#999;}
        .searchWrap fieldset input[type="text"]::-moz-placeholder {font-weight:bold;color:#999;}
        .searchWrap fieldset input[type="text"]:-ms-input-placeholder {font-weight:bold;color:#999;}
        .searchWrap fieldset input[type="text"]:-moz-placeholder {font-weight:bold;color:#999;}
        .searchWrap fieldset .btnSearch {float:right;width:40px;height:36px;text-indent:-99999em;box-sizing:border-box;background:url('#') no-repeat center 2px;}
        .header .lnb {overflow:hidden;width:100%; height:30px;border-top:1px dashed #cccccc;border-bottom:1px solid #cccccc; padding:5px;}
        .header .lnb ul {width:1000px; margin:0 auto;}
        .header .lnb li {float: left;margin:5px;line-height:25px;list-style: none;}
        .header .lnb a {color:#282828;font-size:1.1em;padding:10px 30px;}
        .body .mainCenter{padding-bottom: 0px; border: solid 1px red;min-height: 1px;box-sizing: border-box;display: block;}
        .body .mainCenter .row{border: solid 2px orange;}
        .body .mainCenter .col-sm-6 .div-title-underbar{border: solid 1px blue;}
        .body .mainCenter .col-sm-6 .widget-box{border: solid 1px yellow;}
        .body .mainCenter{ padding-bottom: 0px;position: relative;padding-left: 15px;padding-right: 15px;padding-top: 20px;width: 75%;min-height: 1px;box-sizing: border-box;display: block;}
        .body .mainCenter .row{margin-right: -15px;margin-left: -15px;box-sizing: border-box;display: block;line-height: 22px;display: table;content: " ";clear: both;}
        .body .mainCenter .row .col-sm-6{ width:50%; float: left;position: relative;min-height: 1px;padding-right: 15px;padding-left: 15px;box-sizing: border-box;}
        .body .mainCenter .row .col-sm-6 .div-title-underbar{margin-bottom: 15px;padding: 0; margin: 0;border-bottom: 1px solid #cccccc; box-sizing: border-box;display: block;}
        .pull-right{padding-bottom: 4px;display: inline-block;margin-bottom: -1px;float: right!important;box-sizing: border-box;cursor: pointer;line-height: 22px;}
        .div-title-underbar-bold{padding-bottom: 4px;display: inline-block;margin-bottom: -1px; border-bottom: 1px solid #333333;box-sizing: border-box;}
        .widget-box{margin-bottom: 25px; box-sizing: border-box;}
        .basic-post-list{box-sizing: border-box;}
        .basic-post-list .post-list{list-style: none;padding: 0;margin: -2px 0px;line-height: 22px; box-sizing: border-box;display: block;}
        .post-list .post-list li{padding: 0px;margin: 0px;}
        .post-list .post-list .ellipsis{display: block; text-overflow: ellipsis;white-space: nowrap;overflow: hidden;box-sizing: border-box;text-align: -webkit-match-parent;}
        .count{font-size: 10px;font-weight: bold;font-family: verdana;letter-spacing: -1px;line-height: 16px;padding-right: 1px;box-sizing: border-box;}
        .orangered{color: orangered}
        .post-list .wr-new {width:12px; height: 12px;background-image: url(./img/icon_new.gif) }
        .post-list .wr-icon{display: inline-block;padding: 0px;margin: 0px;line-height: 12px; background-repeat: no-repeat;background-position: 0px 0px;}
        .wr-icon{vertical-align: baseline!important;}
		
		.mainAd {margin: 10px auto;clear: both;}

		.footer{ display: block;box-sizing: border-box;}
		.at-links{ background: #fafafa;padding: 8px 0;border: 1px solid #ddd;border-left: 0px;border-right: 0px;}
		.at-container{display:block;margin: 0px 15px; overflow: hidden;max-width: 1200px; margin: 0px auto; box-sizing: border-box;}
		.at-links ul{ list-style: none; margin: 0px; padding: 0px; float: left!important; display:block;}
		.pull-right{ float: right!important;display:block;}
		.footer .at-links ul > li {
			float: left;
			padding: 0px 15px;
		}
		.at-body .at-container {
			padding: 0px 15px;
			overflow: hidden;
		}
		.at-container {
    max-width: 1200px;margin: 0px auto;
}
.at-footer .at-copyright {
    text-align: center;
    padding: 15px 0px;
    color: #888;
}
.fa {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
    font-size: inherit;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
.footer .at-copyright {
    text-align: center;
    padding: 15px 0px;
    color: #888;
}
.fa-leaf:before {
    content: "\f06c";
}
:before, :after {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.footer .at-copyright strong {
    color: #333;
}
.footer .at-copyright {
    text-align: center;
    padding: 15px 0px;
    color: #888;
}
b, strong {
    font-weight: 700;
}	
		.clearfix:before, .clearfix:after, .dl-horizontal dd:before, .dl-horizontal dd:after, .container:before, .container:after, .container-fluid:before, .container-fluid:after, .row:before, .row:after, .form-horizontal .form-group:before, .form-horizontal .form-group:after, .btn-toolbar:before, .btn-toolbar:after, .btn-group-vertical>.btn-group:before, .btn-group-vertical>.btn-group:after, .nav:before, .nav:after, .navbar:before, .navbar:after, .navbar-header:before, .navbar-header:after, .navbar-collapse:before, .navbar-collapse:after, .pager:before, .pager:after, .panel-body:before, .panel-body:after, .modal-footer:before, .modal-footer:after {
		display: table;
		content: " ";
	}
		.clearfix:after, .dl-horizontal dd:after, .container:after, .container-fluid:after, .row:after, .form-horizontal .form-group:after, .btn-toolbar:after, .btn-group-vertical>.btn-group:after, .nav:after, .navbar:after, .navbar-header:after, .navbar-collapse:after, .pager:after, .panel-body:after, .modal-footer:after {
			clear: both;
		}

</style>
</head>
<body>
<div class="header">
	<div class="gnb">
		<div class="gnbLeft">
			<ul>
				<li><a href="#" alt="">즐겨찾기</a></li>
				<li><a href="#" alt="">2018-01-01</a></li>
			</ul>
		</div>

		<div class="gnbRight">
			<ul>
				<li><a href="#" alt="">공지</a></li>
				<li><a href="#" alt="">이벤트</a></li>
				<li><a href="#" alt="">신고/건의</a></li>
				<li><a href="#" alt="">출석부</a></li>
				<li><a href="#" alt="">로그인</a></li>
				<li><a href="#" alt="">회원가입</a></li>
				<li><a href="#" alt="">정보검색</a></li>
				<li><a href="#" alt="">FAQ</a></li>
			</ul>
		</div>
	</div>

  <div class="headerContWrap">
    	<div class="innerWrap">
          <h1><a href="#" target="_self" title="메인화면으로 이동"><img src="main_logo.jpg" alt="로고" /></a></h1>
          <div class="searchWrap">
              <form name='search' id="search" action='#' method='post' onsubmit="return false;">
                <fieldset>
                  <legend>검색 박스</legend>
                  <input type="text" class="txt" id="query" name="query" value="" autocomplete="off" onfocus="clearKeyword2()"  onkeydown="javascript:if(event.keyCode==13){ doSearch();}"/>
                  <button type="submit" class="btnSearch" onclick="doSearch();" >검색</button>
                </fieldset>
            </form>
          </div>
      </div>
  </div>

  <div class="lnb">
      <ul>
          <li><a href="#" alt="">menu1</a></li>
          <li><a href="#" alt="">menu2</a></li>
          <li><a href="#" alt="">menu3</a></li>
          <li><a href="#" alt="">menu4</a></li>
          <li><a href="#" alt="">menu5</a></li>
          <li><a href="#" alt="">menu6</a></li>
          <li><a href="#" alt="">menu7</a></li>
          <li><a href="#" alt="">menu8</a></li>
      </ul>
  </div>

</div>
<div class="body">
  <div class="mainCenter">
    <div class="row">
      <div class="col-sm-6">	<!-- 베스트 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold">
								<b>베스트</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 베스트 끝 -->
      <div class="col-sm-6">	<!-- 실시간인기 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>실시간인기</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 실시간인기 끝 -->
    </div><!-- //row 1 -->
    <div class="row">
      <div class="col-sm-6">	<!-- 유머 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>유머</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 유머 끝 -->
      <div class="col-sm-6">	<!-- 연예인 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>연예인</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 연예인 끝 -->
	</div><!-- //row 2 -->
	<div class="mainAd" id="mainAd">
		<a href="#"><img src="http://placehold.it/720x80"/></a>
	</div>
    <div class="row">
      <div class="col-sm-6">	<!-- 찰카닥 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>찰카닥</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 찰카닥 끝 -->
      <div class="col-sm-6">	<!-- 미스터리 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>미스터리</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 미스터리 끝 -->
    </div><!-- //row 3 -->
    <div class="row">
      <div class="col-sm-6">	<!-- 취미 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>취미</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 취미 끝 -->
      <div class="col-sm-6">	<!-- 익명 시작 -->
					<div class="div-title-underbar">
						<a href="#">
							<span class="pull-right">+</span>
							<span class="div-title-underbar-bold border-navy font-16 en">
								<b>익명</b>
							</span>
						</a>
					</div>
					<div class="widget-box">
						<div class="basic-post-list">
              <ul class="post-list">
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+6</span>
              				</span>
              				<span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+10</span>
              				</span>
              				<span class="wr-icon wr-new"></span>끼부리는 조보아</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+1</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			번역해줘		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
                      <span class="pull-right gray font-12">
              					     <span class="count orangered">+29</span>
              				</span>
              				<span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+8</span>
              				</span>
              				<span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+7</span>
              						</span>
              			   <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+22</span>
              				</span>
              				<span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+9</span>
              				</span>
              				<span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
              	</li>
              	<li class="ellipsis">
              		<a href="#">
              				<span class="pull-right gray font-12">
              						<span class="count orangered">+17</span>
              				</span>
              			  <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
              	</li>
              </ul>
              </div>
					</div>
			</div>	<!-- 익명 끝 -->
	</div><!-- //row 4 -->
	<div class="mainAd" id="mainAd">
		<a href="#"><img src="http://placehold.it/720x80"/></a>
	</div>
    <div class="row">
      <div class="col-sm-6">	<!-- 투표소 시작 -->
          <div class="div-title-underbar">
            <a href="#">
              <span class="pull-right">+</span>
              <span class="div-title-underbar-bold border-navy font-16 en">
                <b>투표소</b>
              </span>
            </a>
          </div>
          <div class="widget-box">
            <div class="basic-post-list">
              <ul class="post-list">
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+6</span>
                      </span>
                      <span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+8</span>
                      </span>
                      <span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+10</span>
                      </span>
                      <span class="wr-icon wr-new"></span>끼부리는 조보아</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+1</span>
                      </span>
                      <span class="wr-icon wr-new"></span>			번역해줘		</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                             <span class="count orangered">+29</span>
                      </span>
                      <span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+8</span>
                      </span>
                      <span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+7</span>
                          </span>
                       <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+22</span>
                      </span>
                      <span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+9</span>
                      </span>
                      <span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+17</span>
                      </span>
                      <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
                </li>
              </ul>
              </div>
          </div>
      </div>	<!-- 투표소 끝 -->
      <div class="col-sm-6">	<!-- 기타 시작 -->
          <div class="div-title-underbar">
            <a href="#">
              <span class="pull-right">+</span>
              <span class="div-title-underbar-bold border-navy font-16 en">
                <b>기타</b>
              </span>
            </a>
          </div>
          <div class="widget-box">
            <div class="basic-post-list">
              <ul class="post-list">
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+6</span>
                      </span>
                      <span class="wr-icon wr-new"></span>돌고도는 슬기 조이 아이린</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+8</span>
                      </span>
                      <span class="wr-icon wr-new"></span>빛 그 자체 마이콜 근황</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+10</span>
                      </span>
                      <span class="wr-icon wr-new"></span>끼부리는 조보아</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+1</span>
                      </span>
                      <span class="wr-icon wr-new"></span>			번역해줘		</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                             <span class="count orangered">+29</span>
                      </span>
                      <span class="wr-icon wr-new"></span>현 아이콘소속 쇼미3 참가자의</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+8</span>
                      </span>
                      <span class="wr-icon wr-new"></span>			장원영 아이컨택		</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+7</span>
                          </span>
                       <span class="wr-icon wr-new"></span>갓도 오프닝 레전드</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+22</span>
                      </span>
                      <span class="wr-icon wr-new"></span>헬스하는 남자랑 결혼해야 하는 이유</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+9</span>
                      </span>
                      <span class="wr-icon wr-new"></span>장동민의 엄청난 반응 속도</a>
                </li>
                <li class="ellipsis">
                  <a href="#">
                      <span class="pull-right gray font-12">
                          <span class="count orangered">+17</span>
                      </span>
                      <span class="wr-icon wr-new"></span>충격적인 프로듀스 합격자의 모습</a>
                </li>
              </ul>
              </div>
          </div>
      </div>	<!-- 기타 끝 -->
    </div><!-- //row 5 -->
  </div><!-- //mainCenter -->
  <div class="mainRightSide">

  </div><!-- //mainRightSide -->
</div> <!-- //body -->

<div class="footer">
	<nav class="at-links">
		<div class="at-container">
			<ul class="pull-left">
				<li><a href="#">사이트 소개</a></li> 
				<li><a href="#">이용약관</a></li> 
				<li><a href="#">개인정보처리방침</a></li>
				<li><a href="#">이메일 무단수집거부</a></li>
				<li><a href="v">책임의 한계와 법적고지</a></li>
			</ul>
			<ul class="pull-right">
				<li><a href="#">이용안내</a></li>
				<li><a href="#">문의하기</a></li>
				<li><a href="#">모바일버전</a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
	</nav>
	<div class="at-infos">
		<div class="at-container">
			<div class="at-copyright">
				<i class="fa fa-leaf"></i>
				<strong>이바고입니다. <i class="fa fa-copyright"></i></strong>
				All rights reserved.
			</div>
		</div>
	</div>
</div>
</body>
</html>
