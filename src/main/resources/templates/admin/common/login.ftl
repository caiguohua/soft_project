<html>
<#include "../../../../../../../forum/src/main/resources/templates/admin/common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form action="login" method="post" action="/soft/admin/login">
                        账号： <input type="text" name="name"> <br>
                        密码： <input type="password" name="password"> <br>
                        <br>
                        <input type="submit" value="登录">
                        <br>
                        <br>
                        <div>
                            <span class="desc">账号:zhang3 密码:12345 角色:admin</span><br>
                            <span class="desc">账号:li4 密码:abcde 角色:vip</span><br>
                        </div>
                    </form>
				</div>
			</div>
		</div>
	</div>


</div>
</body>
</html>

