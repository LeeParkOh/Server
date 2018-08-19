<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import = "java.util.Calendar" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%
 /**
  * @Class Name : 
  * @Description : 
  * @Modification Information
  * @
  * @  수정일      	수정자            수정내용
  * @ -------   --------   ---------------------------
  * @ 
  *
  *  @author 
  *  @since 
  *  @version
  *  @see
  *
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>메인화면</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>

<link href="<c:url value='/css/common.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/css/maincss.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/css/side_menu.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/css/subcss.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/css/common.css' type="text/css" rel="stylesheet" />" />

<script type="text/javascript">
	$(document).ready(function(){
	});

</script>

</head>
<body>
<div class="WrapM">
	<jsp:include page="../UI_TS_ExpPortal/ExpPortalTop.jsp"></jsp:include>
    <div class="body">
    <FORM action="" name="frmSearch">
    	<input type="hidden" name="lbryClsfctIdCid" value="01000000" />
    	<input type="hidden" name="lbryClsfctIdCid2" value="01010000" />
    	<input type="hidden" name="dtaRqstPscdCid" value="S036000001" />
    	<input type="hidden" name="bltnbdClsfctIdCid" value="1" />
    	<input type="hidden" name="dataAnlsClsfctIdCid" value="1" />
    </FORM>
        <ul class="mainliW">
         	<li class="mainImages"><img src="<c:url value='/images/main.jpg'/>" alt="" /></li>
            <li class="Wteb">
            	<div class="board01">
            		<ul id="dataAnls">
            			<li class="MBlists" onclick="fn_changeTab('dataAnls',this,'1');"><img src="<c:url value="/images/main_board01_tab01_on.gif" />" id="img_dataAnls_01" alt="기동/화력"></li>
            			<li class="MBlists" onclick="fn_changeTab('dataAnls',this,'2');"><img src="<c:url value="/images/main_board01_tab02_off.gif" />" id="img_dataAnls_02" alt="정보/방호"></li>
            			<li class="MBlists" onclick="fn_changeTab('dataAnls',this,'3');"><img src="<c:url value="/images/main_board01_tab03_off.gif" />" id="img_dataAnls_03" alt="작전지속지원"></li>
            			<li class="MBlists" onclick="fn_changeTab('dataAnls',this,'4');"><img src="<c:url value="/images/main_board01_tab04_off.gif" />" id="img_dataAnls_04" alt="지휘관심"></li>
            			
            			<li class="MBVside">
            				<div id="dataAnls_list" style="min-height:130px; text-overflow:ellipsis; overflow:hidden; white-space: nowrap;">
                    			<table>
	                        		<c:forEach var="dataAnls" items="${dataAnlsList}" varStatus="status">
	                        		<tr>
	                                    <th><span style="width:155px;" class="substr" ><a href="javascript:fn_viewPopup('dataAnls',<c:out value='\"${dataAnls.infanlno}\"'/>,<c:out value='\"${dataAnls.dataAnlsClsfctId }\"'/>,'-');" ><c:out value='${dataAnls.dtaTitle}'/></a></span></th>
	                                    <td><c:out value='${dataAnls.rgstDate}'/></td>
	                                </tr>
	                        		</c:forEach>
                            	</table>
                    		</div>
                		</li>
            		</ul>
                </div>
                
                <div class="board02">
                	<ul id="lbry_dta">
                		<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'');"><img src="<c:url value="/images/main_board02_tab01_on.gif" />" id="img_lbry_01" alt="전체"></li>
            			<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'01000000');"><img src="<c:url value="/images/main_board02_tab02_off.gif" />" id="img_lbry_02" alt="훈련지침"></li>
            			<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'02000000');"><img src="<c:url value="/images/main_board02_tab03_off.gif" />" id="img_lbry_03" alt="훈련계획"></li>
            			<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'03000000');"><img src="<c:url value="/images/main_board02_tab04_off.gif" />" id="img_lbry_04" alt="사후검토"></li>
            			<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'04000000');"><img src="<c:url value="/images/main_board02_tab05_off.gif" />" id="img_lbry_05" alt="전투발전"></li>
            			<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'05000000');"><img src="<c:url value="/images/main_board02_tab06_off.gif" />" id="img_lbry_06" alt="전투실험"></li>
            			<li class="MBlists" onclick="fn_changeTab('lbry_dta',this,'06000000');"><img src="<c:url value="/images/main_board02_tab07_off.gif" />" id="img_lbry_07" alt="전투상보"></li>
            			
            			<li class="MBVside">
            				<div id="lbry_dta_list" style="min-height:130px;text-overflow:ellipsis; overflow:hidden; white-space: nowrap;">
                    			<table>
                    				<c:forEach var="lbryDtaList" items="${lbryDtaList}" varStatus="status">
                    				<tr>
                                		<td><span style='width:150px;' class='substr'><b>[<c:out value='${lbryDtaList.lbryClsfctNm}'/>]</b></span></td>
                                    	<th>
                                    		<span style='width:230px;' class='substr'><a href="javascript:fn_viewPopup('lbry_dta',<c:out value='\"${lbryDtaList.datano}\"'/>,<c:out value='\"${lbryDtaList.lbryClsfctId }\"'/>,<c:out value='\"${lbryDtaList.lbryDtaOpnpblYn }\"'/>);">
                                    		<c:out value='${lbryDtaList.lbryDtaTitle}'/>
                                    		</a></span>
                                    	</th>
                                    	<td><c:out value='${lbryDtaList.lbryDtaRgstdt}'/></td>
                                	</tr>
	                    			</c:forEach>
                    			</table>
                    		</div>
                		
                		</li>
					</ul>
					
                </div>
                
                <div class="board03">
                	<ul id="trnng_dta_rqst">
                		<li class="MBlists"><img src="<c:url value="/images/main_board03_tab01_off.gif"/>"></li>
                		<li class="MBVside">
                			<div id="trnng_dta_rqst_list" style="min-height:130px;table-layout:fixed; overflow:hidden; white-space: nowrap;">
                        	<table>
                        		<c:forEach var="trnngDtaRqstList" items="${trnngDtaRqstList}" varStatus="status">
	                        		<tr>
                        	            <th>
	                                    	<span style="width:110px;" class="substr" ><a href="javascript:fn_viewPopup('trnng_dta_rqst',<c:out value='\"${trnngDtaRqstList.dtaRqstSn}\"'/>,<c:out value='\"${trnngDtaRqstList.dtaRqstrId}\"'/>,'-');">
	                                    	<c:out value='${trnngDtaRqstList.dtaRqstTitle }'/>
	                                    	</a></span>
	                                    </th>
	                                    
	                                    <td>
	                                    <c:choose>
			                                <c:when test="${trnngDtaRqstList.dtaRqstPscd=='S036000001' }">
			                                <img src="<c:url value='/images/icon_dta_rqst_regist.gif'/>" alt="접수"/>
			                                </c:when>
			                                <c:when test="${trnngDtaRqstList.dtaRqstPscd=='S036000008' }">
			                                <img src="<c:url value='/images/icon_dta_rqst_reject.gif'/>" alt="반려"/>
			                                </c:when>
			                                <c:when test="${trnngDtaRqstList.dtaRqstPscd=='S036000007' }">
			                                <img src="<c:url value='/images/icon_dta_rqst_complete.gif'/>" alt="승인"/>
			                                </c:when>
			                                <c:otherwise>
			                                <img src="<c:url value='/images/icon_dta_rqst_process.gif'/>" alt="처리중"/>
			                                </c:otherwise>
		                                </c:choose>
	                                    </td>
	                                    
	                                    <td><c:out value='${trnngDtaRqstList.dtaRqstdt }'/></td>
                           
	                                </tr>
                        		</c:forEach>
                            </table>
                            </div>
                		
                		</li>
                	</ul>
                </div>
            </li>
            <li class="W3nd">
            	<div class="board04">
            		<ul class="title">
                		<li class="mainboti"></li>
                		<li class="MBVside">
                			<ul>
                				<li style="width:100%;text-align:center;margin-bottom:5px;">
                				<table cellpadding="0" cellspacing="0">
                					<tr>
	                					<td>
	                						<img src="<c:url value="/images/sample_movie.jpg"/>">
	                					</td>
                					</tr>
                				</table>
                				
                				</li>
                			</ul>
                			
                			<ul>
                				<li style="width:100%;border-bottom:1px #dedede solid;text-align:center;">
                				<c:if test="${movieList.atchflNm == '' || movieList.atchflNm == null}">
	                				<img src="<c:url value="/images/btn_mainplay.gif"/>" border="0">
	                				<img src="<c:url value="/images/btn_maindown.gif"/>" border="0">
                				</c:if>
                				<c:if test="${movieList.atchflNm != '' && movieList.atchflNm != null}">
	                				<a href="javascript:fn_playMoviePopup(<c:out value='\"${movieList.atchflSaveNm }\"'/>);"><img src="<c:url value="/images/btn_mainplay.gif"/>" border="0"></a>&nbsp;
	                				<a href="<c:url value='/ts/DownAtchFlRes.do?atchflSn=${movieList.atchflSn}&atchflNm=${movieList.atchflNm}'/>"><img src="<c:url value="/images/btn_maindown.gif"/>" border="0"></a>
                				</c:if>
                				</li>
                			</ul>
                			
                			<ul>
                				<li style="font:bold 10pt/32px Dotum,Arail;width:100%;text-indent:15px;">
                				<a href="javascript:fn_viewPopup('lbry_dta_movie',<c:out value='\"${movieList.datano }\"'/>,'-','-')"><c:out value='${movieList.atchflNm }'/></a>
                				</li>
                			</ul>
                		</li>
            		</ul>
                </div>
                
                <div class="board05">
                	<ul>
                		<li class="MBlists" onclick="fn_changeTab('atchfl_down',this,'N','N');"><img src="<c:url value="/images/main_board05_tab01_off.gif"/>"></li>
            			<li class="MBlists" onclick="fn_changeTab('atchfl_down',this,'A','A');"><img src="<c:url value="/images/main_board05_tab02_off.gif"/>"></li>
            			<li class="MBlists" onclick="fn_changeTab('atchfl_down',this,'M','M');"><img src="<c:url value="/images/main_board05_tab03_off.gif"/>"></li>
            			
            			<li class="MBVside">
            				<div id="atchfl_down_list" style="min-height:130px;text-overflow:ellipsis; overflow:hidden; white-space: nowrap;">
								
                        	</div>
                		</li>
            		</ul>
                </div>
                
                
                <div class="board06">
                	<ul>
           	            <li class="mainboti"></li>
                		<c:forEach var="cbtTrnngGdocList" items="${cbtTrnngGdocList}" varStatus="status">
                		<c:if test="${cbtTrnngGdocList.lbryClsfctId=='01030100'}">
                		<li class="MBVside"><img src="<c:url value="/images/btn_guide_01.jpg"/>"  onmouseover="this.style.cursor='pointer'" onclick="fn_fileDownload(<c:out value='\"${cbtTrnngGdocList.atchflSn}\"'/>,<c:out value='\"${cbtTrnngGdocList.atchflNm}\"'/>)"></li>
                		</c:if>
                		<c:if test="${cbtTrnngGdocList.lbryClsfctId=='01030200'}">
                		<li class="MBVside"><img src="<c:url value="/images/btn_guide_02.jpg"/>"  onmouseover="this.style.cursor='pointer'" onclick="fn_fileDownload(<c:out value='\"${cbtTrnngGdocList.atchflSn}\"'/>,<c:out value='\"${cbtTrnngGdocList.atchflNm}\"'/>)"></li>
                		</c:if>
                		<c:if test="${cbtTrnngGdocList.lbryClsfctId=='01030300'}">
                		<li class="MBVside"><img src="<c:url value="/images/btn_guide_03.jpg"/>"  onmouseover="this.style.cursor='pointer'" onclick="fn_fileDownload(<c:out value='\"${cbtTrnngGdocList.atchflSn}\"'/>,<c:out value='\"${cbtTrnngGdocList.atchflNm}\"'/>)"></li>
                		</c:if>
                		<c:if test="${cbtTrnngGdocList.lbryClsfctId=='01030400'}">
                		<li class="MBVside"><img src="<c:url value="/images/btn_guide_04.jpg"/>"  onmouseover="this.style.cursor='pointer'" onclick="fn_fileDownload(<c:out value='\"${cbtTrnngGdocList.atchflSn}\"'/>,<c:out value='\"${cbtTrnngGdocList.atchflNm}\"'/>)"></li>
                		</c:if>
                		<c:if test="${cbtTrnngGdocList.lbryClsfctId=='01030500'}">
                		<li class="MBVside"><img src="<c:url value="/images/btn_guide_05.jpg"/>"  onmouseover="this.style.cursor='pointer'" onclick="fn_fileDownload(<c:out value='\"${cbtTrnngGdocList.atchflSn}\"'/>,<c:out value='\"${cbtTrnngGdocList.atchflNm}\"'/>)"></li>
                		</c:if>
                		</c:forEach>
            		</ul>
                </div>
            </li>
            <li class="W4nd">
            	<div class="banner" style="line-height:30px;align:right;">
            		<img src="<c:url value="/images/icon_today_visit.gif"/>" align="absmiddle" alt="오늘방문자수"><span style="padding-left:10px;"><c:out value='${todayCnt }'/></span> &nbsp;
            		<img src="<c:url value="/images/icon_total_visit.gif"/>" align="absmiddle" alt="전체방문자수"><span style="padding-left:10px;"><c:out value='${totalCnt }'/></span>
            	</div>
            </li>
        </ul>
    </div>
    
    <jsp:include page="../UI_TS_ExpPortal/ExpPortalFooter.jsp"></jsp:include> 
</div>
</body>
</html>