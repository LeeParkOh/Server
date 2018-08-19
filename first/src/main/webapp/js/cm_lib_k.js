//<![CDATA[

/******************************************************
 * Description :  Ajax Request 공통함수
 * @param :  pUrl : 요청URL
 * @param :  pMethod : 요청메소드(get, post)
 * @param :  pParam : 파라메터
 * @param :  pCallback : 콜백함수
 * @return :  void
 * @author:  황태연
 * @since : 2012. 07. 31
*******************************************************/
function gfn_Ajax(pUrl, pMethod, pParam, pCallback){
	$.ajax({
		type:pMethod,
		url:pUrl,
		data:pParam,
		dataType:"json",
		success:function(result){
			var call = eval(pCallback);
			call;
		},error:function(request, status, error){
			alert("요청하신 페이지에 문제가 발생했습니다." + status + error);
		}
	});
}

/******************************************************
* Description :  Ajax Request 공통함수 (json ContentType)
* @param :  pUrl : 요청URL
* @param :  pMethod : 요청메소드(get, post)
* @param :  pParam : 파라메터
* @param :  pCallback : 콜백함수
* @return :  void
*******************************************************/
function gfn_AjaxJson(pUrl, pMethod, pParam, pCallback){
	$.ajax({
		type:pMethod,
		url:pUrl,
		data:pParam,
		dataType:"json",
		contentType:"application/json",
		success:function(result){
			var call = eval(pCallback);
			call;
		},error:function(request, status, error){
			alert("요청하신 페이지에 문제가 발생했습니다." + status + error);
		}
	});
}

/******************************************************
* Description :  팝업창를 화면 중앙에 띄우기 위한 함수
* @param :  pUrl : 팝업창 URL
* @param :  width : 팝업창 넓이
* @param :  height : 팝업창 높이
* @return :  void
*******************************************************/
function gfn_OpenWindow(url, width, height){

	var top, left;
	var features = "";

	if(width == '' || width == null){
		width = 480;
	}

	//height가 '' 또는 Null이면 기본 크기 설정
	if(height == '' || height == null){
		height = 480;
	}

	top  = gfn_CenterY(height);
	left = gfn_CenterX(width);


	features += "top=" + top;
	features += ",left=" + left;
	features += ",width=" + width;
	features += ",height=" + height;

	window.open(url,'popup',features);
}

/******************************************************
 * Description :   팝업창(모달)
 * @param :  url : url
 * @param :  target : target
 * @param :  width : 창 넓이
 * @param :  height : 창 높이
 * @return:  void
*******************************************************/
function gfn_popWin(url, target, width, height) {
	// window open property set
	var sURL		= url;
	var sTarget		= target;
	var sStatus		= "";
	var bReplace	= false;

	if(sURL == ""){
		alert("주소가 잘못되었습니다..");
		return;
	}

	//sStatus property set
	var vHeight 	= "dialogHeight=" + height+"px";
	var vWidth	= "dialogWidth=" + width+"px";

	//sStatus default set
	var vlocation = "location=no";
	var scrollbar = "scrollbars=yes";
	var toolbar = "toolbar=no";
	var menubar = "menubar=no";
	var resizeStatus = "resizable=no";
	var statusBar = "status=yes";

	sStatus = vlocation + ";" + statusBar + ";" + scrollbar + ";" + menubar + ";" + toolbar + ";" + resizeStatus + ";" + vWidth + ";" + vHeight;

	var newWin;

	if(sTarget.length > 0) {
		newWin = window.showModalDialog(sURL,sTarget,sStatus);
	} else {
		newWin = window.showModalDialog(sURL,self,sStatus);
	}
}

/******************************************************
* Description :   팝업창(모달) 리턴값 추가
* @param :  url : url
* @param :  target : target
* @param :  width : 창 넓이
* @param :  height : 창 높이
* @return:  화면에서 전달받은 값
*******************************************************/
function gfn_popWin2(url, target, width, height, stddPop) {
	// window open property set
	var sURL		= url;
	var sTarget		= target;
	var sStatus		= "";
	var bReplace	= false;

	if(sURL == ""){
		alert("주소가 잘못되었습니다..");
		return;
	}

	//sStatus property set
	var vHeight = "";
	var vWidth = "";
	
	//소속팝업인 경우
	if(stddPop == "stddPop") {
		vHeight 	= "dialogHeight=580px";
		vWidth	= "dialogWidth=820px";
	} else {
		vHeight 	= "dialogHeight=" + height+"px";
		vWidth	= "dialogWidth=" + width+"px";
	}
	
	//sStatus default set
	var vlocation = "location=no";
	var scrollbar = "scrollbars=no";
	var toolbar = "toolbar=no";
	var menubar = "menubar=no";
	var resizeStatus = "resizable=no";
	var statusBar = "status=yes";

	sStatus = vlocation + ";" + statusBar + ";" + scrollbar + ";" + menubar + ";" + toolbar + ";" + resizeStatus + ";" + vWidth + ";" + vHeight;

	var newWin;

	if(sTarget.length > 0) {
		return newWin = window.showModalDialog(sURL,sTarget,sStatus);
	} else {
		return newWin = window.showModalDialog(sURL,self,sStatus);
	}
}

/******************************************************
 * Description :   팝업창(모달리스)
 * @param :  theURL : url
 * @param :  winName : target
 * @param :  w : 창 넓이
 * @param :  h : 창 높이
 * @param :  features : 팝업창 속성
 * @return:  void
*******************************************************/
function gfn_open_popCen(theURL,winName,w,h,features) {
	var winl = (screen.width - w) / 3;
	var wint = (screen.height - h) / 3;
	features = 'width='+w+',height='+h+',left='+winl+',top='+wint+','+features;

	var newWin = window.open(theURL,winName,features);

	newWin.focus();
}


/******************************************************
 * Description :   화면 가로 중앙 좌표값
 * @param :  width : 창 넓이
 * @return:  가로 중앙 좌표
*******************************************************/
function gfn_CenterX(width){
	var retVal;
	retVal = (document.body.clientWidth / 2) - (width / 2);
	return retVal;
}


/******************************************************
 * Description :   화면 세로 중앙 좌표값
 * @param :  height : 창 넓이
 * @return:  세로 중앙 좌표
*******************************************************/
function gfn_CenterY(height){
	var retVal;
	retVal = (document.body.clientHeight / 2) - (height / 2);
	return retVal;
}

/******************************************************
 * Description :   문자열 앞뒤 공백제거
 * @param :  str : 문자열
 * @return:  공백제거된 문자열
*******************************************************/
function gfn_trim(str) {
    str = str.replace(/(^\s*)|(\s*$)/g, "");
    return str;
}

/******************************************************
 * Description :   문자열의 특정길이 만큼 자름(...)
 * @param :  str : 문자열
 * @param :  len : 문자열 자를 길이
 * @return:  문자열
*******************************************************/
function gfn_cut_str(str, len) {
    var curLen = 0;

    for (var i=0; i<str.length; i++) {
        curLen += (str.charCodeAt(i) > 128) ? 2 : 1;
        if (curLen > len) return str.substring(0,i) + "...";
    }

    return str;
}

/******************************************************
 * Description :   숫자체크
 * @param :  control : -
 * @param :  msg : -
 * @return:  boolean
*******************************************************/
function gfn_isNumber(control, msg) {

    var val = control;
    var Num = "1234567890";
    for (i=0; i<val.length; i++) {
        if(Num.indexOf(val.substring(i,i+1))<0) {
            alert(msg+' 형식이 잘못되었습니다.');
            return false;
        }
    }
    return true;
}

/******************************************************
 * Description :   날짜체크
 * @param :  val : 날짜 입력값
 * @param :  msg : 에러 메시지
 * @return:  boolean
*******************************************************/
function gfn_isDate(control, msg) {
	   //'/'나 '-' 구분자 제거
	   var val = gfn_getRemoveFormat(control);

	   //숫자, length 확인
	   if (gfn_isNumber(val, msg) && val.length == 8) {
	       var year = val.substring(0,4);
	       var month = val.substring(4,6);
	       var day = val.substring(6,8);

	       //유효날짜 확인
	       if(gfn_checkDate(year,month,day,msg)){
	           return true;
	       } else {
	           return false;
	       }
	   } else {
	       alert(msg + "이(가) 유효하지 않은 년,월,일(YYYY-MM-DD)입니다. 다시 확인해 주세요!");
	       return false;
	   }
}

/******************************************************
* Description :   날짜체크 및 날짜입력 값 설정
* @param :  dateVal : 날짜 입력값
* @param :  msg : 에러 메시지
* @param :  element : 설정할 element
* @return:  boolean
*******************************************************/
function gfn_validDateValue(dateVal, msg, element) {
	if(dateVal.length > 0) {
		if(gfn_isDate2(dateVal, msg)) {
			//$("#"+element).val(gfn_setDateFormat(dateVal));			
			return true;
		} else {
			return false;
		}
	} else {
		return true;
	}
};
/******************************************************
* Description :   날짜체크 및 날짜입력 값 설정 2
* @param :  dateVal : 날짜 입력값
* @param :  msg : 에러 메시지
* @param :  element : 설정할 element
* @return:  boolean
*******************************************************/
function gfn_validDateValue2(dateVal, msg, element) {
	if(dateVal.length > 0) {
		if(gfn_isDate3(dateVal, msg)) {
			//$("#"+element).val(gfn_setDateFormat(dateVal));			
			return true;
		} else {
			return false;
		}
	} else {
		return true;
	}
};
/******************************************************
* Description :   날짜체크
* @param :  val : 날짜 입력값
* @param :  msg : 에러 메시지
* @return:  boolean
*******************************************************/
function gfn_isDate2(val, msg) {
	//날짜만
	var testDate = val.replace("-", "").replace("-", "");
	//날짜형식
	var numberTF = /^[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$/.test(testDate);
	//년, 월, 일
	var year = "";
	var month = "";
	var day = "";
	//결과값
	var result = false;

	if(numberTF) {
	    year = testDate.substring(0,4);
	    month = testDate.substring(4,6);
	    day = testDate.substring(6,8);
	    //2월
        if(month == "02") {
        	var isleap = ((parseInt(year,10) % 4) == 0) && ((parseInt(year,10) % 100) == 0 || (parseInt(year,10) % 4) == 0);

        	if (parseInt(day, 10) > 29) {
        		result = false;
        	} else if((day == "29") && !isleap) {
        		result = false;
        	} else {
        		if(day == "28") {
        			result = true;
        		} else {
        			result = true;
        		}
        	}
        //그밖의 달
        } else {
        	if((month=="04")||(month=="06")||(month=="09")||(month=="11")){
        		if(day == "31") {
            		result = false;
        		} else {
        			result = true;
        		}
        	}else {
        		result = true;
        	}
        }
	} else {
		result = false;
	}

	if(!result) {
		alert(gfn_GetMessage("TC_CM_MSG_016", msg));
		return false;
	}

	return true;
};
/******************************************************
* Description :   날짜체크2
* @param :  val : 날짜 입력값
* @param :  msg : 에러 메시지
* @return:  boolean
*******************************************************/
function gfn_isDate3(val, msg) {
	//날짜만
	var testDate = val.replace(".", "").replace(".", "");
	//날짜형식
	var numberTF = /^[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$/.test(testDate);
	//년, 월, 일
	var year = "";
	var month = "";
	var day = "";
	//결과값
	var result = false;

	if(numberTF) {
	    year = testDate.substring(0,4);
	    month = testDate.substring(4,6);
	    day = testDate.substring(6,8);
	    //2월
        if(month == "02") {
        	var isleap = ((parseInt(year,10) % 4) == 0) && ((parseInt(year,10) % 100) == 0 || (parseInt(year,10) % 4) == 0);

        	if (parseInt(day, 10) > 29) {
        		result = false;
        	} else if((day == "29") && !isleap) {
        		result = false;
        	} else {
        		if(day == "28") {
        			result = true;
        		} else {
        			result = true;
        		}
        	}
        //그밖의 달
        } else {
        	if((month=="04")||(month=="06")||(month=="09")||(month=="11")){
        		if(day == "31") {
            		result = false;
        		} else {
        			result = true;
        		}
        	}else {
        		result = true;
        	}
        }
	} else {
		result = false;
	}

	if(!result) {
		alert(gfn_GetMessage("TC_CM_MSG_016", msg));
		return false;
	}

	return true;
};

/******************************************************
 * Description :   구분자 제거
 * @param :  val : 제거할 구분자
 * @param :  msg : -
 * @return:  str
*******************************************************/
function gfn_getRemoveFormat(val) {
   if(val.length == 10) {
       var arrDate = new Array(3);
       arrDate = val.split("-");
       if(arrDate.length != 3) {
           arrDate = val.split("-");
       }
       return arrDate[0] + arrDate[1] + arrDate[2];
   } else {
       return val;
   }
}

/******************************************************
* Description :   날짜 구분자 설정
* @param :  val : 숫자만 입력된 날짜
* @param :  msg : -
* @return:  str :
*******************************************************/
function gfn_setDateFormat(val) {
  //날짜 구분자
  var sepVal = "-";
  //년,월,일
  var year = "";
  var month = "";
  var day = "";
  //리턴 값
  var result = val;

  if(val.length == 8) {
      year = val.substring(0,4);
      month = val.substring(4,6);
      day = val.substring(6,8);

      result = year+sepVal+month+sepVal+day;

      return result;
  } else {
      return result;
  }
}


/******************************************************
 * Description :   날짜유효성 체크
 * @param :  varCk1 : YYYY
 * @param :  varCk2 : MM
 * @param :  varCk3 : DD
 * @param :  msg : -
 * @return:  str
*******************************************************/
function gfn_checkDate(varCk1, varCk2, varCk3, msg) {
   if (varCk1>="0001" && varCk1<="9999" && varCk2>="01" && varCk2<="12") {
       febDays = "29";
       if ((parseInt(varCk1,10) % 4) == 0) {
           if ((parseInt(varCk1,10) % 100) == 0 && (parseInt(varCk1,10) % 400) != 0){
               febDays = "28";
           }
       }else{
           febDays = "28";
       }
       if (varCk2=="01" && varCk3>="01" && varCk3<="31") return true;
       if (varCk2=="02" && varCk3>="01" && varCk3<=febDays) return true;
       if (varCk2=="03" && varCk3>="01" && varCk3<="31") return true;
       if (varCk2=="04" && varCk3>="01" && varCk3<="30") return true;
       if (varCk2=="05" && varCk3>="01" && varCk3<="31") return true;
       if (varCk2=="06" && varCk3>="01" && varCk3<="30") return true;
       if (varCk2=="07" && varCk3>="01" && varCk3<="31") return true;
       if (varCk2=="08" && varCk3>="01" && varCk3<="31") return true;
       if (varCk2=="09" && varCk3>="01" && varCk3<="30") return true;
       if (varCk2=="10" && varCk3>="01" && varCk3<="31") return true;
       if (varCk2=="11" && varCk3>="01" && varCk3<="30") return true;
       if (varCk2=="12" && varCk3>="01" && varCk3<="31") return true;
   }
   alert(msg + "이(가) 유효하지 않은 년,월,일(YYYY-MM-DD)입니다.\n다시 확인해 주세요!");
   return false;
}



 /**
  * 전체 체크박스 toggle
  * @param p_name
  * @param item_name 체크하고자 하는 체크박스의 이름
  * @return
  */
function gfn_checkItemAll(p_name, item_name){
	var len = $("input:checkbox[name='"+item_name+"']").length;

	if($("input:checkbox[name='"+p_name+"']").attr("checked") == 'checked'){
		for(var i=0; i < len; i++){
			$("input:checkbox[name='"+item_name+"']").attr("checked",true);
			$("input:checkbox[name='"+item_name+"']").val("1");
		}
	}else{
		for(var i=0; i < len; i++){
			$("input:checkbox[name='"+item_name+"']").attr("checked",false);
			$("input:checkbox[name='"+item_name+"']").val("0");
		}
	}
}

/**
 * 개별 체크박스 toggle
 * @param p_name
 * @param item_name 체크하고자 하는 체크박스의 이름
 * @return
 */
function gfn_checkItem(p_name, item_name){
	var i = 0;
	var len = $("input:checkbox[name='"+item_name+"']").length;

	$("input:checkbox[name='"+item_name+"']").each(function(index){
		if(this.checked){
			$("input:checkbox[name='"+item_name+"']").eq(index).attr("checked",true);
			i++;

		}else{
			$("input:checkbox[name='"+item_name+"']").eq(index).attr("checked",false);
			i--;
		}

	});

	if(i == len){
		$("input:checkbox[name='"+p_name+"']").attr("checked",true);
	}else{
		$("input:checkbox[name='"+p_name+"']").attr("checked",false);
	}
}



 /**
  * 공통 경고 팝업
  * @param pMsgId
  * @param
  * @return
  */
function gfn_Alert(title, msg){
	  var pos_x, pos_y;
	  var args = new Array();
	  var options;


	  var width=400;
	  var height=240;

	  args["title"] = title;
	  args["msg"] = msg;



	  options  = "dialogWidth:" + width + "px";
	  options += ";dialogHeight:" + height + "px";
	  options += ";center:yes";
	  options += ";scroll:no";
	  options += ";resizable:no";
	  options += ";status:no";
	  options += ";help:no";

	  window.showModalDialog( "../jsp/Alert.jsp",args,options);
}


/**
 *
 * @param msg
 * @return
 */
function gfn_Confirm(title, msg)
{
	var retVal = "NO";
	var args = new Array();
	var options;
	var width=400
	var height=240;

	args["title"] 	= title;
	args["msg"] 	= msg;

	options  = "dialogWidth:" + width + "px";
	options += ";dialogHeight:" + height + "px";
	options += ";center:yes";
	options += ";scroll:no";
	options += ";resizable:no";
	options += ";status:no";
	options += ";help:no";

	retVal = window.showModalDialog( "../jsp/Confirm.jsp",args,options);

	if(typeof(retVal) != 'undefined')
	{
		return retVal;
	}

	return retVal;

}

/**
 *
 * @param pMsgCd
 * @param pBindInfo
 * @return
 */
function gfn_GetMessage(pMsgCd,pBindInfo){
	var msgName;

	//메시지코드가 null이거나 ""이면 리턴
	if(pMsgCd != null && pMsgCd !="")
	{
		if(typeof(pMsgCd) == 'undifined')
		{
			msgName = "";
			retVal  = "";
		}
		else
		{
			msgName = eval(pMsgCd);
			retVal = msgName;
		}
	}

	if(pBindInfo != null && pBindInfo != "")
	{
		if(pBindInfo.length > 0)
		{
			var arrBind = pBindInfo.split(";");
			for(var i=0; i < arrBind.length; i++)
			{
				//retVal = msgName.replace("{" + i + "}",arrBind[i]);
				retVal = msgName.split("{" + i + "}").join(arrBind[i]);
				msgName = retVal;
			}
		}
	}

	return retVal;
}

 /**
  * 특수문자 체크
  * @param 검색어, 입력항목에 대한 특수문자 체크
  * @param
  * @return boolean
  */
 function gfn_isSpecial(param){
  	var pattern = /[\!@#$%^&*()]/gi;
  	return pattern.test(param);
 }

  /**
   * 널 체크
   * @param 검색어, 입력항목에 대한 널 체크
   * @param
   * @return boolean
   */
 function gfn_isNull(param){
 	if(param == null || param == ""){
 		return true;
 	}
 	return false;
 }

 /******************************************************
  * Description : 조회조건 초기화 함수
  * @param :  form: 초기화 할 폼 이름 (#붙이기), focusId: 포커스를 줄 input의 id (#붙이기)
  *        예) <form:form commandName="commonVO" name="common" method="post"> 이고,
  *            <input type="text" id="comId"/> 라면
  *            gfn_clearSearchCondition('#common', '#comId')라 호출
  * @return:
 *******************************************************/
function gfn_clearSearchCondition(form, focusId) {
	$(form).find(':input').each(function() {
		switch(this.type) {
			case 'password':
			case 'select-multiple':
			case 'select-one':
				$('option:eq(0)', this).attr("selected", "selected");
				break;
			case 'text':
			case 'textarea':
				$(this).val('');
				$(focusId).focus();
				break;
			case 'checkbox':
			case 'radio':
				this.checked = false;

				$(focusId).focus();
		}
	});
}

/******************************************************
 * Description : 테이블 정렬 함수
 * @param :  tableId: 정렬할 테이블의 id,
 *			 nCell:컬럼의 nCell
 *			 strAsc: 오름차순인 경우 asc, 내림차순인 경우 desc
 *        사전조건) 테이블의 구조가 thead와 tbody로 이루어져야 함
 * @return: retVal: 오름차순인 경우 asc, 내림차순인 경우 desc
*******************************************************/
function gfn_sortTableValue(tableId, nCell, strAsc) {
	var strSrc = "";
	var retVal = "";
	retVal = strAsc =="asc"?"desc":"asc";
	strSrc = strAsc =="asc"?"../images/icon_titleicon_up.gif":"../images/icon_titleicon.gif";
	$("#"+tableId+">tbody>tr").tsort("td:eq("+nCell+")", {attr:"abbr", order:strAsc});
	$("#"+tableId+">thead>tr>th:eq("+nCell+") a img").attr("src", strSrc);
	return retVal;
}
 
 /******************************************************
  * Description : gfn_popWin2를 통해 리턴 받은 값 설정
  * @param :  retVal 팝업화면으로 부터 리턴받은 값 
  * @return: void
 *******************************************************/ 
function gfn_setRetValPopupWin(retVal) {
	if(retVal == undefined) {
		retVal = window.returnValue;
	}
	if(retVal) {
		for(var objName in retVal) {
			$("#"+objName).val(retVal[objName]);
		}
	}			
}


/******************************************************
* Description :  확장자에 따른 이미지 아이콘 문자열 리턴
* @param :  strExt : 확장자 문자열
* @return :  string
*******************************************************/
function gfn_getExtIcon(strExt)
{
	var retVal = "icon_txt.png";

//	doc
	if(strExt.indexOf("doc") >= 0)
	{
		retVal = "icon_doc.png";
	}

//	xls
	else if(strExt.indexOf("xls") >= 0)
	{
		retVal = "icon_xls.png";
	}

//	ppt
	else if(strExt.indexOf("ppt") >= 0)
	{
		retVal = "icon_ppt.png";
	}

//	pdf
	else if(strExt.indexOf("pdf") >= 0)
	{
		retVal = "icon_pdf.png";
	}

//	hwp
	else if(strExt.indexOf("hwp") >= 0)
	{
		retVal = "icon_hwp.png";
	}

//	jpg,gif,bmp
	else if(strExt.indexOf("jpg") >= 0 || strExt.indexOf("gif") >= 0 || strExt.indexOf("bmp") >= 0)
	{
		retVal = "icon_images.gif";
	}

//	avi,wmv,
	else if(strExt.indexOf("avi") >= 0 || strExt.indexOf("wmv") >= 0 || strExt.indexOf("wav") >= 0 || strExt.indexOf("wma") >= 0)
	{
		retVal = "icon_mov.gif";
	}

//	txt,etc
	return retVal;

}

/******************************************************
 * Description : LPAD 함수
 * @param :  orgStr : 원본문자, cnt: 붙일 갯수,  appendStr: 붙일 문자열
 * @return:
*******************************************************/
function gfn_lpad(orgStr, cnt, appendStr)
{
	var strOrg = String(orgStr);
	var strCnt = strOrg.length;
	var result = "";

	if(strCnt < cnt) {
		for(var idx=0; idx<(cnt-strCnt); idx++) {
			result += appendStr;
		}
		result += orgStr;

	} else {
		result = strOrg;
	}

	return result;
};

/******************************************************
 * Description : 조회조건 검색일자 체크 함수
 * @param :  startDt : 시작일자 id값, endDt: 종료일자 id값, msg: 메세지
 * @return:
 * @author:
 * @since : 2013. 10. 16
*******************************************************/
function gfn_chkSearchDate(startDt,endDt,msg){
	var strStartDt = $("#"+startDt).val();
	var strEndDt = $("#"+endDt).val();
	
	if(strStartDt!="" && strEndDt!=""){
		if(strStartDt>strEndDt){
			alert(gfn_GetMessage("TC_CM_MSG_004", msg));
			$("#"+endDt).val("");
			return false;
		}
	}
	return true;
}


/******************************************************
 * Description : 오늘날짜
 * @param :  
 * @return: "YYYYMMDD"
 * @author:
 * @since : 
*******************************************************/
function gfn_today(){
	var now = new Date();
	var year = now.getFullYear();
	var MM = now.getMonth()+1;
	if((MM+"").length < 2){
		MM = "0"+MM;
	}
	var dd = now.getDate();
	if((dd+"").length < 2){
		dd = "0"+dd;
	}

	var dt = year+""+MM+""+dd;
	return dt;
}
/**************** jquery validate addMethod **********************/

/***************************************************************
* Description :  checkSpecialChar
*				특수문자 체크
* @return :  boolean
****************************************************************/
 $.validator.addMethod("checkSpecialChar", function(element){
	var pattern = /[\!@#$%^&*()]/gi;

	if(pattern.test(element)){
		return false;
	}else{
		return true;
	}
 },$.validator.messages.checkSpecialChar);


 /***************************************************************
 * Description :  checkEqualTo
 *				eqaulTo와 동일하나 메시지에 내용 넣기 위해 추가
 * @return :  boolean
 ****************************************************************/
  $.validator.addMethod("checkEqualTo",
		  	function(value, element, param) {
					var target = $(param[0]);
					if (this.settings.onfocusout) {
						target.unbind(".validate-equalTo").bind("blur.validate-equalTo", function() {
							$(element).valid();
						});
					}
					return value === target.val();
  			},
  			$.validator.messages.checkEqualTo
  );

/***************************************************************
* Description :  checkUserPwNum
*				사용자 비밀번호 숫자 확인
* @return :  boolean
****************************************************************/
 $.validator.addMethod("checkUserPwNum",
		 function(value, element){
				var regex 	= new RegExp("[0-9]+?");
				var result = regex.test(value);
 				return result;
 		},
 		$.validator.messages.checkUserPwNum
 );

 /***************************************************************
 * Description :  checkUserPwStr
 *				사용자 비밀번호 영문자 확인
 * @return :  boolean
 ****************************************************************/
 $.validator.addMethod("checkUserPwStr",
		 function(value, element){
				var regex 	= new RegExp("[a-zA-Z]+?");
				var result = regex.test(value);
	 			return result;

 		},
 		$.validator.messages.checkUserPwStr
 );

 /***************************************************************
  * Description :  checkUserPwSpcStr
  *				사용자 비밀번호 특수문자 확인
  * @return :  boolean
  ****************************************************************/
 $.validator.addMethod("checkUserPwSpcStr",
		 function(value, element){
				var regex 	= new RegExp("[~!@#$%^&*-+./=_{|}()\\?<>]+?");
				var result = regex.test(value);
	 			return result;
 		},
 		$.validator.messages.checkUserPwSpcStr
 );
/******************************************************
* Description :  checkUserPwRep
*				사용자 비밀번호 반복형식확인
* @return :  boolean
*******************************************************/
 $.validator.addMethod("checkUserPwRep",
			function(value, element) {
				var regex 	= new RegExp("(\\S)\\1\\1");
				var result 	= regex.test(value);
				return !result;
			},
			$.validator.messages.checkUserPwRep
 );

 /******************************************************
 * Description :  checkUserPwAscDesc
 *				사용자 비밀번호 오름차순 내림차순 확인
 * @param : param[0] :  메시지에 보여줄 값,
 *  		param[1] : 1 :오름차순, -1: 내림차순
 * @return :  boolean
 *******************************************************/
 $.validator.addMethod("checkUserPwAscDesc",
			function(value, element, param) {
				var iParam 		= parseInt(param[1]);
	 			var strUpper 	= value.toUpperCase();
				var iLength 	= 0;
				var strArray 	= [];

				if($.isArray(strUpper)) {
					iLength = upperVal.length;
				} else {
					iLength = this.getLength($.trim(strUpper), element);
				}

				for (var idx = 0; idx < iLength ; idx++) {
					var iAsciiVal 	= parseInt(strUpper.charAt(idx).charCodeAt(0));

					//문자 범위
					if((47 < iAsciiVal) && (iAsciiVal < 58)) {
						strArray.push(iAsciiVal);
					} else if((64 < iAsciiVal) && (iAsciiVal < 91)) {
						strArray.push(iAsciiVal);
					} else {
						strArray.push(128);
					}
				}

				for (var idx = 0; idx < strArray.length; idx++) {
					if((strArray[idx]+iParam) == strArray[idx+1]) {
						if((strArray[idx+1]+iParam) == strArray[idx+2]) {
							return false;
						}
					}
				}

				return true;
			},
			$.validator.messages.checkUserPwAscDesc
);

 /******************************************************
  * Description :  checkUserPwDesc
  *				사용자 비밀번호 내림차순 확인
  *				(asc함수 활용)
  * @param : param[0] :  메시지에 보여줄 값,
  *  		 param[1] : 1 :오름차순, -1: 내림차순
  * @return :  boolean
  *******************************************************/
 $.validator.addMethod("checkUserPwDesc",
			function(value, element, param) {
					return $.validator.methods.checkUserPwAscDesc.call(this, value, element, param);
 				},
 				$.validator.messages.checkUserPwAscDesc
 );

 /******************************************************
  * Description :  checkWrlsTelno
  *				휴대전화번호 확인
  * @return :  boolean
  *******************************************************/
 $.validator.addMethod("checkWrlsTelno",
			function(value, element) {
				var result = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(value);
				return this.optional(element) || result;
			},
			$.validator.messages.checkWrlsTelno
 );

 /***************************************************************
  * Description :  checkNumAndHyp
  *				숫자와 하이픈 확인
  * @return :  boolean
  ****************************************************************/
  $.validator.addMethod("checkNumAndHyp",
 		 function(value, element){
			var regex 	= new RegExp("[^0-9-]+");
			var result 	= regex.test(value);
			return !result;
  		},
  		$.validator.messages.checkNumAndHyp
  );

 /***************************************************************
  * Description :  only english
  *				   영어 사용(공백 및 _추가)
  * @return :  boolean
  ****************************************************************/
  $.validator.addMethod("english",
	function(value, element) {
		var result = /^[a-zA-Z\s_]+$/.test(value);
		return this.optional(element) || result;
	 },$.validator.messages.english
  );
  
  /***************************************************************
  * Description :  checkSpecialChar2
  *				특수문자 체크2
  * @return :  boolean
  ****************************************************************/
   $.validator.addMethod("checkSpecialChar2", function(element){
  	var pattern = /[<>\'\"]/gi;

  	if(pattern.test(element)){
  		return false;
  	}else{
  		return true;
  	}
   },$.validator.messages.checkSpecialChar);
//]]>