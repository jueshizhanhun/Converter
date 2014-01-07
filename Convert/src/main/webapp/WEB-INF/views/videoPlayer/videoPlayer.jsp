<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Red5</title>
</head>
<body>
	<script type='text/javascript' src='<c:url value="/resources/js/jwplayer.js" />'></script>
	<div>
		<b class="spiffy">
			<b class="spiffy1">
				<b></b>
			</b>
			<b class="spiffy2">
				<b></b>
			</b>
			<b class="spiffy3"></b>
			<b class="spiffy4"></b>
			<b class="spiffy5"></b>
		</b>

		<div class="spiffyfg">
			<center>
				<b>RTMP</b>
				<div id='mediaspace'>This text will be replaced</div>
				<script type='text/javascript'>
					jwplayer('mediaspace').setup({
						'flashplayer' : '<c:url value="/resources/js/player.swf" />',
						'file' : '${file}',
						'streamer' : 'rtmp://172.21.4.153/red5Server',
						'controlbar' : 'bottom',
						'width' : '848',
						'height' : '360'
					});
				</script>
				<br /> <b>RTMPT</b>
				<div id='mediaspace2'>This text will be replaced</div>
				<script type='text/javascript'>
					jwplayer('mediaspace2').setup({
						'flashplayer' : '<c:url value="/resources/js/player.swf" />',
						'file' : '${file}',
						'streamer' : 'rtmpt://172.21.4.153:5080/red5Server',
						'controlbar' : 'bottom',
						'width' : '848',
						'height' : '360'
					});
				</script>
			</center>
			<br />
		</div>

		<b class="spiffy">
			<b class="spiffy5"></b>
			<b class="spiffy4"></b>
			<b class="spiffy3"></b>
			<b class="spiffy2">
				<b></b>
			</b>
			<b class="spiffy1">
				<b></b>
			</b>
		</b>
	</div>
</body>
</html>


