<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
			.gnlist li .tpli{
				width: 100%;
				
				display: flex;
				flex-flow: wrap;
			}
			.gnlist li .tpli img{
				width: 200px;
				height: 200px;
			}
		</style>
		<link rel="stylesheet" href="css/style.css"/>
	</head>
	<body>
		<div class="nav">
			<div class="logo">
				<img src="img/logo.png" style="width:45px;margin:8px">
				<span class="title">云网盘</span>
			</div>
			<ul class="listleft">
				<li>网盘</li>
				<li>分享</li>
				<li>更多</li>
			</ul>
			<ul class="listright">
				<li><img ></li>
				<li>
					<select>
						<option>JellysunshuineT</option>
						<option>xiaowang</option>
						<option>renjianemo</option>
					</select>
				</li>
				<li>| 客户端下载 </li>
				<li><img src="img/lins.png" width="30px">
				<img src="img/leibie.png"width="30px">
				<img src="img/lins.png"width="30px"></li>
			</ul>
		</div>
		<div class="main">
			<div class="left">
				<ul>
					<li><a href="index.ftl"><img src="img/leibie.png" width="20px">全部文件</a></li>
					<li style="background-color: rgba(255,255,255,.7)"><a href="/toTup">图片</a></li>
					<li><a href="/toIndex">文档</a></li>
					<li><a href="/toWend">视频</a></li>
					<li><a href="/toWend">种子</a></li>
					<li><a href="/toWend">音乐</a></li>
					<li><a href="/toWend">其他</a></li>
					<li><a href=""><img src="img/fenx.png" width="20px">我的分享</a></li>
					<li><a href=""><img src="img/huis.png" width="20px">回收站</a></li>
				</ul>
			</div>
			<div class="right">
				<ul class="gongn">
					<li class="bor">最近上传</li>
					<li><input type="text" placeholder="通过人物,事物搜索您要的图片"><!-- <img class="sso" src="img/sous.png" style="right: 32%;"> --></li>
					<li class="fenlei"><img src="img/fenlei.png" width="30px"></li>
				</ul>

				<ul class="gnlist">
					<li><input type="checkbox" style="top: 0;">全选</li>
					<li><ul class="tpli">
					<li class="dropdown">
						<img src="img/QQ图片20190927100615.jpg">
						<div class="dropdown-content">
							<p>本地下载</p>
						</div>
						<p>图片1</p>
					</li>
					<li class="dropdown"> 
						<img src="img/active_01.jpg">
						<div class="dropdown-content">
							<p>本地下载</p>
						</div>
						<p>图片2</p>
					</li>
					<li class="dropdown">
						<img src="img/anlie1.jpg">
						<div class="dropdown-content">
							<p>本地下载</p>
						</div>
						<p>图片3</p>
					</li>
					<li class="dropdown">
						<img src="img/anlie2.jpg">
						<div class="dropdown-content">
							<p>本地下载</p>
						</div>
						<p>图片4</p>
					</li>
					<li class="dropdown">
						<img src="img/photo_temp.gif">
						<div class="dropdown-content">
							<p>本地下载</p>
						</div>
						<p>图片5</p>
					</li>
				   <li class="dropdown">
						<img src="img/QQ图片20190927100615.jpg">
						<div class="dropdown-content">
							<p>本地下载</p>
						</div>
						<p>图片6</p>
					</li>
					</ul></li>
				</ul>
			</div>
		</div>
	</body>
</html>
