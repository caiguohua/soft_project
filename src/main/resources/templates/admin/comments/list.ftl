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
                            <th>评论id</th>
                            <th>会所id</th>
                            <th>评论</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list commentsList.list as clubComment>
                        <tr>
                            <td>${clubComment.id}</td>
                            <td>${clubComment.cid}</td>
                            <td>${clubComment.comment}</td>
                            <td>${clubComment.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${clubComment.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="delete?id=${clubComment.id}&cid=${cid}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要删除吗？！')">-</button></a></td>
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
                        <li><a href="/soft/clubComments/list?cid=#{cid}&page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..commentsList.getPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/soft/clubComments/list?cid=#{cid}&page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte commentsList.getPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/soft/clubComments/list?cid=${cid}&page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>

<script>
</script>
</body>
</html>