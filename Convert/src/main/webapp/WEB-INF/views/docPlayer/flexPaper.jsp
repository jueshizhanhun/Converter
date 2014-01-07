<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>FlexPaper</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1,user-scalable=no,maximum-scale=1,width=device-width" />
    <style type="text/css" media="screen">
        html, body	{ height:100%; }
        body { margin:0; padding:0; overflow:auto; }
        #flashContent { display:none; }
    </style>

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/flexpaper.css'/>" />
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/flexpaper.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/flexpaper_handlers.js'/>"></script>
</head>
<body>
<div style="position:absolute;left:10px;top:10px;">
<P>  The file on the server is ${file}. </P>
<div id="documentViewer" class="flexpaper_viewer" style="width:770px;height:500px"></div>

<script type="text/javascript">

    $('#documentViewer').FlexPaperViewer(
            { config : {

                SWFFile : '${file}',

                Scale : 0.6,
                ZoomTransition : 'easeOut',
                ZoomTime : 0.5,
                ZoomInterval : 0.2,
                FitPageOnLoad : true,
                FitWidthOnLoad : false,
                FullScreenAsMaxWindow : false,
                ProgressiveLoading : false,
                MinZoomSize : 0.2,
                MaxZoomSize : 5,
                SearchMatchAll : false,
                InitViewMode : 'Portrait',
                RenderingOrder : 'flash',
                StartAtPage : '',

                ViewModeToolsVisible : true,
                ZoomToolsVisible : true,
                NavToolsVisible : true,
                CursorToolsVisible : true,
                SearchToolsVisible : true,
                WMode : 'window',
                localeChain: 'en_US'
            }}
    );
</script>
<div style="width:760px;margin-top:10px;padding-left:10px; padding-top:10px; padding-bottom:10px; font-family:Verdana;font-size:10pt;background-color:#EFEFEF; border:1px solid #999;-webkit-box-shadow: rgba(0, 0, 0, 0.246094) 0px 2px 4px 0px;font-family:'District Thin', helvetica, arial;font-weight:lighter;"><font style="font-size:15px;font-weight:bold">Notice</font><br/>You are viewing a document in FlexPaper using Adobe Flash. Consider purchasing a commercial license with support for <a href="http://flexpaper.devaldi.com/download.jsp?ref=FlexPaper">Adaptive UI </a> to maximize your browser coverage and reach devices such as the Apple iPad. <br/><br/>With <a href="http://flexpaper.devaldi.com/download.jsp?ref=FlexPaper">AdaptiveUI enabled</a>, the viewer adjust automatically to the visitors capabilities and supports rendering documents as flash, html4 and html5. The viewer gracefully degrades between all formats.<br/><br/>For more information on browser coverage please <a href="http://flexpaper.devaldi.com/docs_html_flash_html5.jsp?ref=FlexPaper">see our documentation</a>.</div>
</div>

<!-- THE FOLLOWING CODE BLOCK CAN SAFELY BE REMOVED, IT IS ONLY PLACED HERE TO HELP YOU GET STARTED. -->
<div style="position:absolute;left:790px;height:620px;top:10px;font-size:12pt;background-color:#CACACA;width:300px;border:1px solid #999;-webkit-box-shadow: rgba(0, 0, 0, 0.246094) 0px 2px 4px 0px;min-height:440px;font-family:'District Thin', helvetica, arial;font-weight:lighter;">
    <div style="padding: 5px 5px 5px 5px;font-size:17px;font-weight:bold;text-align:center;margin-top:10px;">FlexPaper Sample Document</div>
    <div style="padding: 5px 5px 5px 5px;font-size:13px;text-align:left;margin-bottom:10px;">Can't see the document and running from a local directory? Upload the contents of the zip file to a web server. </div>

    <div style="background-color:#EFEFEF">
        <div style="padding: 5px 5px 5px 5px;font-size:17px;font-weight:bold;text-align:center;margin-top:20px;padding-top:10px;">Examples of FlexPaper</div>
        <div style="padding: 5px 5px 5px 5px;font-size:13px;text-align:left;margin-bottom:10px;line-height:150%">
            &raquo; <a href="index.html">FlexPaper in Flash mode <img src="http://flexpaper.devaldi.com/images/flash-player-mini.png" border=0 /></a><br/>
            &raquo; <a href="javascript:if(confirm('FlexPaper GPL version does not support HTML4 rendering. Do you want to navigate to our download page for more details?')){location.href='http://flexpaper.devaldi.com/download.jsp?ref=FlexPaper'}">FlexPaper in HTML4 mode <img src="http://flexpaper.devaldi.com/images/html4-round-mini.png" border="0" /></a><br/>
            &raquo; <a href="javascript:if(confirm('FlexPaper GPL version does not support HTML5 rendering. Do you want to navigate to our download page for more details?')){location.href='http://flexpaper.devaldi.com/download.jsp?ref=FlexPaper'}">FlexPaper in HTML5 mode <img src="http://flexpaper.devaldi.com/images/html5-round-mini.png" border="0" /></a><br/>

            &raquo; <a href="index_twopage.html">Viewer starting in two-page mode</a><br/>
            &raquo; <a href="index_startatpage.html">Viewer starting at page 3</a><br/>
            &raquo; <a href="index_debug.html">Interactive debugging API</a><br/>
        </div>


        <div style="padding: 5px 5px 5px 5px;font-size:13px;text-align:left;margin-bottom:10px;line-height:150%">
            <div style="float:right"><img src="http://flexpaper.devaldi.com/resources/phplogo.png"/></div>

            <div style="float:left;">
                &raquo; <a href="php/setup.php">Set up publishing with PHP 5</a><br/>
                &raquo; <a href="http://flexpaper.devaldi.com/docs_php.jsp">Read documentation</a><br/>
            </div>
        </div>

        <div style="clear:both">&nbsp;</div>

        <div style="padding: 5px 5px 5px 5px;font-size:13px;text-align:left;margin-bottom:10px;line-height:150%">
            <div style="float:right"><img src="http://flexpaper.devaldi.com/resources/aspnetlogo.png"/></div>
            <div style="float:left;">&raquo; <a href="aspnet/systemcheck.aspx">Set up publishing with ASP.NET</a><br/>
                &raquo; <a href="http://flexpaper.devaldi.com/docs_publishing_with_ASPNET.jsp">Read documentation</a><br/>
            </div>
        </div>

        <div style="clear:both">&nbsp;</div>

        <div style="padding: 5px 5px 5px 5px;font-size:13px;text-align:left;margin-bottom:10px;line-height:150%">
            <div style="float:right"><img src="http://flexpaper.devaldi.com/resources/java-logo.png"/></div>
            <div style="float:left;">&raquo; <a href="java/FlexPaper.war">WAR file for publishing with Java</a><br/>
            </div>
        </div>

        <div style="padding: 5px 5px 5px 5px;font-size:17px;font-weight:bold;text-align:center;margin-top:60px;">Documentation</div>
        <div style="padding: 5px 5px 5px 5px;font-size:13px;text-align:left;margin-bottom:10px;line-height:150%">
            &raquo; <a href="http://flexpaper.devaldi.com/docs_html_flash_html5.jsp">Choosing Publishing Format</a><br/>
            &raquo; <a href="http://flexpaper.devaldi.com/docs_converting.jsp">Converting Documents Manually</a><br/>
            &raquo; <a href="http://flexpaper.devaldi.com/docs_parameters.jsp">Parameters</a><br/>
            &raquo; <a href="http://flexpaper.devaldi.com/docs_api.jsp">API</a><br/>
        </div>
    </div>
</div>
</div>

<script type="text/javascript">
    var url = window.location.href.toString();

    if(location.length==0){
        url = document.URL.toString();
    }

    if(url.indexOf("file:")>=0){
        jQuery('#documentViewer').html("<div style='position:relative;background-color:#ffffff;width:420px;font-family:Verdana;font-size:10pt;left:22%;top:20%;padding: 10px 10px 10px 10px;border-style:solid;border-width:5px;'><img src='http://flexpaper.devaldi.com/resources/warning_icon.gif'>&nbsp;<b>You are trying to use FlexPaper from a local directory.</b><br/><br/> FlexPaper needs to be copied to a web server before the viewer can display its document properlty.<br/><br/>Please copy the FlexPaper files to a web server and access the viewer through a http:// url.</div>");
    }
</script>
</body>
</html>