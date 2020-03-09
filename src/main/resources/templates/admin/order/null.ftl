<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>用户id</th>
                            <th>用户名字</th>
                            <th>用户电话</th>
                            <th>套餐id</th>
                            <th>套餐名字</th>
                            <th>套餐价格</th>
                            <th>时间单位</th>
                            <th>订单状态</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>完结订单</th>
                        <#--<th>删除</th>-->
                        </tr>
                        </thead>
                    </table>
                </div>


            </div>
        </div>
    </div>

</div>
</body>
</html>