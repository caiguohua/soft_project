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
                    <form role="form" method="post" action="/soft/clubLabel/insert">
                        <div class="form-group">
                            <label>标签名称</label>
                            <input name="labelName" type="text" class="form-control" value="${(labelName)!''}"/>
                        </div>
                        <#--<input hidden type="text" name="id" value="${(clubInfo.id)!''}">-->
                        <button type="submit" class="btn btn-default btn-success">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>