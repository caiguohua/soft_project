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
                    <form role="form" method="post" action="/soft/clubInfo/insert">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="name" type="text" class="form-control" value="${(clubInfo.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="description" type="text" class="form-control" value="${(clubInfo.description)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>电话</label>
                            <input name="phone" type="text" class="form-control" value="${(clubInfo.phone)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input name="address" type="text" class="form-control" value="${(clubInfo.address)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(clubInfo.coverImage)!''}" alt="">
                            <input name="coverImage" type="text" class="form-control" value="${(clubInfo.coverImage)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>顺序</label>
                            <input name="sequence" type="text" class="form-control" value="${(clubInfo.sequence)!''}"/>
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