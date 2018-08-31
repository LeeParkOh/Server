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
              <form name='search' id="search" action='/ebs/bsz.BscMainSrch.laf' method='post' onsubmit="return false;">
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

</div>

<div class="footer">

</div>
</body>
</html>

