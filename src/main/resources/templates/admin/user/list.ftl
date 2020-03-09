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
                            <th>id</th>
                            <th>电话</th>
                            <th>名字</th>
                            <th>类型</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>封号</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list userInfoList.list as userInfo>
                        <tr>
                            <td>${userInfo.id}</td>
                            <td>${userInfo.phone}</td>
                            <td>${userInfo.name}</td>
                            <td>${userInfo.getTypeEnum().message}</td>
                            <td>${userInfo.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${userInfo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="delete?id=${userInfo.id}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要封号吗？！')">🈲</button></a></td>
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
                        <li><a href="/soft/userInfo/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userInfoList.getPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/soft/userInfo/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userInfoList.getPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/soft/userInfo/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>