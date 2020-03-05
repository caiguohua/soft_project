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
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>会所id</th>
                            <th>名字</th>
                            <th>描述</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>图片</th>
                            <th>顺序</th>
                            <th>评论</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list clubInfoList as clubInfo>
                        <tr>
                            <td>${clubInfo.id}</td>
                            <td>${clubInfo.name}</td>
                            <td>${clubInfo.description}</td>
                            <td>${clubInfo.phone}</td>
                            <td>${clubInfo.address}</td>
                            <td>${clubInfo.coverImage}</td>
                            <td>${clubInfo.sequence}</td>
                            <td>${clubInfo.comments}</td>
                            <td>${clubInfo.createTime}</td>
                            <td>${clubInfo.updateTime}</td>
                            <td><a href="/soft/clubInfo/add?id=${clubInfo.id}">修改</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>