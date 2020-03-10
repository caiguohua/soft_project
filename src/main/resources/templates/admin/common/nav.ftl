<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                <font size="3" color="aqua">月子会所管理系统</font>
            </a>
        </li>
        <br>
        <br>
        <li>
            <a href="/soft/admin/index"><i class="fa fa-fw fa-list-alt"></i><font size="4" color="#ffd700"> 首页 </font></a>
        </li>
        <br>
        <br>
        <li>
            <a href="/soft/userInfo/list"><i class="fa fa-fw fa-list-alt"></i><font size="4" color="aqua"> 用户 </font></a>
        </li>
        <br>
        <br>
        <li>
            <a href="/soft/orderInfo/list"><i class="fa fa-fw fa-list-alt"></i><font size="4" color="aqua"> 订单 </font></a>
        </li>
        <br>
        <br>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> <font size="4" color="aqua"> 会所 </font><span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/soft/clubInfo/list">列表</a></li>
                <li><a href="/soft/clubInfo/add">新增</a></li>
            </ul>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i><font size="4" color="aqua"> 商品 </font> <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li class="dropdown-header">操作</li>
                <li><a href="/soft/clubProduct/list">列表</a></li>
                <li><a href="/soft/clubProduct/add">新增</a></li>
            </ul>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> <font size="4" color="aqua"> 标签 </font><span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="/soft/clubLabel/list">列表</a></li>
                <li><a href="/soft/clubLabel/add">新增</a></li>
            </ul>
        </li>

        <#--<li>-->
            <#--<a href="/soft/admin/login"><i class="fa fa-fw fa-list-alt"></i><font size="3" color="#ffd700"> 登录 </font></a>-->
        <#--</li>-->
        <li>
            <a href="/soft/admin/logout"><i class="fa fa-fw fa-list-alt"></i><font size="3" color="#ffd700"> 登出 </font></a>
        </li>
    </ul>

</nav>