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
                            <th>标签id</th>
                            <th>名字</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>修改</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list clubLabelList as clubLabel>
                        <tr>
                            <td>${clubLabel.id}</td>
                            <td>${clubLabel.labelName}</td>
                            <td>${clubLabel.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${clubLabel.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/soft/clubLabel/show?id=${clubLabel.id}"><button type="button" class="btn btn-sm btn-warning btn-block">⚙</button></a></td>
                            <td><a href="delete?id=${clubLabel.id}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要删除吗？！')">-</button></a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<script>
</script>
</body>
</html>