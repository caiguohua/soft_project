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
                            <th>商品id</th>
                            <th>会所id</th>
                            <th>名字</th>
                            <th>描述</th>
                            <th>价格</th>
                            <th>时间单位</th>
                            <th>库存</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>修改</th>
                            <th>下架</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list clubProductList.list as clubProduct>
                        <tr>
                            <td>${clubProduct.id}</td>
                            <td>${clubProduct.cid}</td>
                            <td>${clubProduct.name}</td>
                            <td>${clubProduct.desc}</td>
                            <td>${clubProduct.price}</td>
                            <td>${clubProduct.getDateUnitEnum().message}</td>
                            <td>${clubProduct.sum}</td>
                            <td>${clubProduct.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${clubProduct.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/soft/clubProduct/show?id=${clubProduct.id}"><button type="button" class="btn btn-sm btn-warning btn-block">⚙</button></a></td>
                            <td><a href="delete?id=${clubProduct.id}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要删除吗？！')">-</button></a></td>
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
                        <li><a href="/soft/clubProduct/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..clubProductList.getPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/soft/clubProduct/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte clubProductList.getPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/soft/clubProduct/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>