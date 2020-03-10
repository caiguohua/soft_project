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
                    <form role="form" method="post" action="/soft/clubProduct/insert">
                        <div class="form-group">
                            <label>会所id</label>
                            <input name="cid" type="number" class="form-control" value="${(clubProduct.cid)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>名字</label>
                            <input name="name" type="text" class="form-control" value="${(clubProduct.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="desc" type="text" class="form-control" value="${(clubProduct.desc)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="price" type="number" class="form-control" value="${(clubProduct.price)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>时间单位</label>
                            <#--<input name="dateUnit" class="form-control" value="${(clubInfo.address)!''}" />-->
                            <br>
                            <select id="dateUnit" name="dateUnit">
                                <option value="0">一天</option>
                                <option value="1">一周</option>
                                <option value="2">一月 </option>
                                <option value="3">一季度 </option>
                                <option value="4">一年 </option>
                            </select>
                            <#--<input type="radio" name="checkit" value="a" checked><br>-->
                            <#--<input type="radio" name="checkit" value="b"><br>-->
                            <#--<input type="radio" name="checkit" value="c"><br>-->
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="sum" type="number" class="form-control" value="${(clubProduct.sum)!''}"/>
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