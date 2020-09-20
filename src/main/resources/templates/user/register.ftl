<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link rel="stylesheet" href="/soft/static/css/amazeui.min.css" />
	<script type="text/javascript" src="/soft/static/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="/soft/static/js/amazeui.min.js"></script>
	<link rel="stylesheet" href="/soft/static/css/regedit.css" />
	<#--<link rel="stylesheet" href="/soft/static/css/sui.css" />-->
	<script type="text/javascript" src="/soft/static/js/sui.js"></script>
	<title>会所注册页</title>
	<style>
		/*.bottomLine {
            border-bottom: 1px solid #ccc;
            border-top: 1px solid #ccc;
            margin-bottom: 10px;
            /*padding: 10px;*/
		/*padding-top: 10px;
        padding-bottom: 10px;
        word-spacing: 0.05rem;
        text-align: center;
        margin-top: 82px;*/
		/*width:677px ;*/
		/*line-height: ;*/
		/*}*/
		.bottomLine{
			border-bottom: 1px solid #ccc;
			border-top: 1px solid #ccc;
			padding-top:8px;
			/*padding-bottom:10px;*/

		}
		.bot {
			margin-bottom: 50px;
			/*text-align: center;*/
			color: #7b6f5b;
		}

		.radio-pretty.checked > span:before {
			color: #f88600;
		}

		input {
			height: 62px;
		}
		.radio-pretty span:before {
			margin-right: 2px;
			vertical-align: -4px;
			font-size: 20px;
			color: #bdbdbd;
			margin-left: -2px;
		}
	</style>
</head>

<body>
<!--		<div class="am-g" style="margin-top: 25px;">-->
<!--			<div class="logo"> <img src="/soft/static/img/logo.png" /> </div>-->
<!--		</div>-->
<div class="am-g">
	<div  style="width: 999px;margin: 0 auto;font-size: 14px;"> <span style="float: right;color: #333333;" >我已注册，马上<span style="color: #F88600;"><a href="/soft/club/login"> 登录</a></span></span>
	</div>
</div>
<div class="am-g content" style="margin-top: 12px;">
	<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
		<ul class="am-tabs-nav am-cf" style="margin-top: 74px;">
			<li class="" style="max-width: 95px; margin-left: 100px;"></li>
			<li class="am-active"><a href="[data-tab-panel-0]"><span class="am-badge am-round am-badge-warning-active "style="vertical-align: middle;margin-top:-4px;"></span>设置登录名</a></li>
			<!--					<li class=""><a href="[data-tab-panel-1]"><span class="am-badge  am-round"style="vertical-align: middle;margin-top:-4px;">2</span>设置用户信息</a></li>-->
			<!--					<li class=""><a href="[data-tab-panel-2]"><span class="am-badge  am-round"style="vertical-align: middle;margin-top:-4px;">3</span>注册成功</a></li>-->
			<li class="" style="    max-width: 95px;margin-right: 100px;"></li>
		</ul>
		<div class="am-tabs-bd" style="margin-top: 59px;margin-left: -20px;">
			<form action="/soft/register" method="post">
			<div data-tab-panel-0 class="am-tab-panel am-active">
				<div class="am-g">
					<div class="am-u-sm-7 am-u-sm-offset-3 "> <span class="left1"></span> <input type="text" name="phone" placeholder="请输入您的手机号" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 55px;width: 528px" /> </div>
					<div class="am-u-sm-1 am-u-end" style="padding: 10px;"> <span class="right" style="display: none;"></span> </div>
				</div>
				<div class="am-g" style="margin-top: 37px;">
					<div class="am-u-sm-4 am-u-sm-offset-3" style="padding-right: 0rem;"> <span class="left1"></span><input type="text" name="userName" placeholder="请输入用户名" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 55px;width: 528px;" /> </div>
					<!--							<div class="am-u-sm-3 am-u-end" style="padding-left: 0rem;"> <button type="button" class="am-btn am-btn-default" style="width: 190px;    float: left;height: 62px;">获取短信验证码</button> </div>-->
				</div>
				<div class="am-g" style="margin-top: 37px;">
					<div class="am-u-sm-4 am-u-sm-offset-3" style="padding-right: 0rem;"> <span class="left2"></span> <input type="password" name="password" placeholder="请输入密码" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 55px;width: 528px" /> </div>
					<!--							<div class="am-u-sm-3 am-u-end" style="padding-left: 0rem;"> <button type="button" class="am-btn am-btn-default" style="width: 190px;float: left;height: 62px;">验证码 <a style="margin-left: 50px;">换一张</a></button> </div>-->
				</div>
				<div class="am-g" style="margin-top: 37px;">
					<div class="am-u-sm-4 am-u-sm-offset-3" style="padding-right: 0rem;"> <span class="left2"></span> <input type="password" placeholder="请输入确认密码" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 55px;width: 528px" /> </div>
					<!--							<div class="am-u-sm-3 am-u-end" style="padding-left: 0rem;"> <button type="button" class="am-btn am-btn-default" style="width: 190px;float: left;height: 62px;">验证码 <a style="margin-left: 50px;">换一张</a></button> </div>-->
				</div>
				<div class="am-g" style="margin-top: 21px;">
					<form class="sui-form">
						<div class="am-u-sm-7 am-u-sm-offset-3" style="padding-right: 0rem;"><label class="checkbox-pretty inline checked">
 								<input type="checkbox" checked="checked">
 								<span style="font-size: 12px;color: #878787;">同意
 											<a>《会员章程》</a>
 											<a>《支付宝协议》</a>
 																		<a>《在线协议》</a>
 								</span>
 							</label>
 						</div>
 					</form>

				</div>


				<div class="am-g" style="margin-top:112px;">
					<div class="am-u-sm-7 am-u-sm-offset-3 "> <input type="submit" class="am-btn am-btn-warning" style="width: 528px;padding: 20px;border: 1px rgba(187, 187, 187, 0.5) solid;"></div>
				</div>
<!--				<div class="am-g" style="margin-top: 20px;margin-bottom: 135px;">-->
<!--					<div class="am-u-sm-7 am-u-sm-offset-3" style="padding-right: 0rem;"> <a style="font-size: 14px;">您也可以使用邮箱注册></a> </div>-->
<!--				</div>-->
			</div>
			</form>

		</div>
	</div>
</div>

</body>

</html>