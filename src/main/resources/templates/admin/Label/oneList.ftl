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
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list clubLabelList as clubLabel>
                        <tr>
                            <td>${clubLabel.id}</td>
                            <td>${clubLabel.labelName}</td>
                            <td><a href="deleteInfoLabel?cid=${cid}&lid=${clubLabel.id}"><button type="button" class="btn btn-sm btn-danger btn-block" onClick="javascript:return window.confirm('您确定要删除吗？！')">-</button></a></td>
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