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
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>名字</th>
                            <th>描述</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>图片</th>
                            <th>顺序</th>
                            <th>商品</th>
                            <th>评论</th>
                            <th>标签</th>
                            <th><font size="1">创建时间</font></th>
                            <th><font size="1">修改时间</font></th>
                            <th>＋标签</th>
                            <th>修改</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list clubInfoList.list as clubInfo>
                        <tr>
                            <td>${clubInfo.id}</td>
                            <td>${clubInfo.name}</td>
                            <td>${clubInfo.description}</td>
                            <td>${clubInfo.phone}</td>
                            <td>${clubInfo.address}</td>
                            <td><img height="100" width="100" src="${clubInfo.coverImage}" alt=""></td>
                            <td>${clubInfo.sequence}</td>
                            <td><a href="/soft/clubProduct/list?cid=${clubInfo.id}">商品</a></td>
                            <td><a href="/soft/clubComments/list?cid=${clubInfo.id}">评论</a></td>
                            <td><a href="/soft/clubLabel/findByCid?cid=${clubInfo.id}">标签</a></td>
                            <td><font size="1">${clubInfo.createTime?string('yyyy-MM-dd HH:mm:ss')}</font> </td>
                            <td><font size="1">${clubInfo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</font> </td>
                            <td><a href="/soft/clubLabel/addInfoLabel?cid=${clubInfo.id}"><button type="button" class="btn btn-sm btn-info btn-block">＋</button></a></td>
                            <td><a href="/soft/clubInfo/show?id=${clubInfo.id}"><button type="button" class="btn btn-sm btn-warning btn-block">⚙</button></a></td>
                            <td><a href="delete?id=${clubInfo.id}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要删除吗？！')">—</button></a></td>
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
                        <li><a href="/soft/clubInfo/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..clubInfoList.getPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/soft/clubInfo/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte clubInfoList.getPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/soft/clubInfo/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>


            </div>
        </div>
    </div>

</div>
</body>
</html>