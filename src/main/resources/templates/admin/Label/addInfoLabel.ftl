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

                    <form role="form" method="post" action="/soft/infoLabel/insert">

                        <input hidden type="number" name="cid" value="${(cid)!''}">

                        <div class="form-group">
                            <label><font size="5">选择你要新加的标签</font></label>
                            <br>
                            <select id="lid" name="lid">
                                <#list clubLabelList as clubLabel>
                                    <option value="${clubLabel.id}">${clubLabel.labelName}</option>
                                </#list>
                            </select>
                            <br>
                        </div>
                        <#--<input hidden type="text" name="cid" value="${(cid)!''}">-->
                        <button type="submit" class="btn btn-default btn-success">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>