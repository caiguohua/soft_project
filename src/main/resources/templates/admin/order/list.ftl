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
                            <th>取消订单</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderInfoList.list as orderInfo>
                        <tr>
                            <td>${orderInfo.id}</td>
                            <td>${orderInfo.uid}</td>
                            <td>${orderInfo.userName}</td>
                            <td>${orderInfo.userPhone}</td>
                            <td>${orderInfo.pid}</td>
                            <td>${orderInfo.productName}</td>
                            <td>${orderInfo.productPrice}</td>
                            <td>${orderInfo.getDateUnitEnum().message}</td>
                            <td>${orderInfo.getOrderStatusEnum().message}</td>
                            <td>${orderInfo.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${orderInfo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/soft/orderInfo/finish?id=${orderInfo.id}&uid=${uid}"><button type="button" class="btn btn-sm btn-warning btn-block">√</button></a></td>
                            <td><a href="cancel?id=${orderInfo.id}&uid=${uid}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要取消吗？！')">×</button></a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/soft/orderInfo/list?uid=${uid}&page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..orderInfoList.getPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/soft/orderInfo/list?uid=${uid}&page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte orderInfoList.getPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/soft/orderInfo/list?uid=${uid}&page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>