<#--<#&#45;&#45;<<<<<<< HEAD:src/main/resources/templates/user/西安套餐.html&ndash;&gt-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">


    <meta http-equiv="imagetoolbar" content="no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no,email=no,address=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>会所套餐</title>

    <!-- css -->
    <link rel="stylesheet" type="text/css" href="/soft/static/css/MyPaging.css">

    <script src="/soft/static/js/jquery.min3.js"></script>

    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .main1 {
            margin: 0 auto;
            padding: 50px 0;
            width: 1000px;
            min-height: 1000px;
        }
        table {
            margin-bottom: 20px;
            width: 100%;
            border-collapse: collapse;
            border: none;
        }
        table th, table td {
            padding: 5px 10px;
            border-color: #999;
        }
    </style>


    <link rel="stylesheet" type="text/css" href="/soft/static/css/font-awesome.min1.css">
    <link rel="stylesheet" href="/soft/static/css/jquery.paginate1.css" />
    <link rel="stylesheet" href="/soft/static/css/jquery.yhhDataTable1.css" />

    <script type="text/javascript" src="/soft/static/js/jquery.min2.js"></script>
    <script type="text/javascript" src="/soft/static/js/jquery.paginate1.js" ></script>
    <script type="text/javascript" src="/soft/static/js/jquery.yhhDataTable1.js" ></script>
    <script type="text/javascript" src="/soft/static/js/index1.js" ></script>


    <link rel="stylesheet" href="/soft/static/css/easyhelper.min.css">
    <link rel="stylesheet" type="text/css" href="/soft/static/css/resets.css" />
    <link rel="stylesheet" type="text/css" href="/soft/static/css/default.css">
    <link href="/soft/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="/soft/static/css/reset.css" rel="stylesheet">
    <link href="/soft/static/css/spxq.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/soft/static/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="/soft/static/js/chanping.js"></script>
    <link href="/soft/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/soft/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="plugins/cubeportfolio/css/cubeportfolio.min.css">
    <link href="/soft/static/css/nivo-lightbox.css" rel="stylesheet" />
    <link href="/soft/static/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
    <link href="/soft/static/css/owl.carousel.css" rel="stylesheet" media="screen" />
    <link href="/soft/static/css/owl.theme.css" rel="stylesheet" media="screen" />
    <link href="/soft/static/css/animate.css" rel="stylesheet" />
    <link href="/soft/static/css/style.css" rel="stylesheet">
    <script src="/soft/static/js/xml.js"></script>
    <script src="/soft/static/js/es6-shim.min.js"></script>
    <script src="/soft/static/js/jquery-3.3.1.min.js"></script>
    <script src="/soft/static/js/jquery.transit.min.js"></script>
    <script src="/soft/static/js/easyhelper.min.js"></script>
    <!-- boxed bg -->
    <link id="bodybg" href="/soft/static/bodybg/bg1.css" rel="stylesheet" type="text/css" />
    <!-- template skin -->
    <link id="t-colors" href="/soft/static/color/default.css" rel="stylesheet">

    <style>
        .main{
            width: 800px;
            margin:20px auto;
        }
        span{
            display: inline-block;
            width: 200px;
            height: 25px;
            line-height: 25px;
            vertical-align: center;
            text-align: left;
            margin-bottom: 10px;
        }
        .tag{
            font-size: 13px;
            margin-left: 370px;
            vertical-align: bottom;
            text-align: center;
            margin-bottom: 0;
        }
        .text{
            width: 750px;
            height: 180px;
            margin:0 auto;

            resize:none;
        }

        inputs{
            display: inline-block;
            width: 80px;
            height: 50px;
            background: #E2526F;
            border: 0;
            margin-left: 670px;
            margin-top: 10px;
        }
        .creatediv{
            width: 675px;
            height: 80px;
            border: 1px solid gray;
            position: relative;
            margin-top: 10px;
            padding-left: 75px;
        }
        .createinput{
            width: 80px;
            height: 30px;
            position:absolute;
            right: 5px;
            bottom:5px;
        }
        .createimg{
            width: 50px;
            height: 50px;
            position: absolute;
            top: 15px;
            left: 15px;
        }
        .createdivs{
            width:600px;
            height:50px;
            position: absolute;
            top: 15px;
            left: 85px;
        }
        .wrapper {
            text-align: center;
            margin: 50px auto;
        }
        .wrapper button {
            width: 120px;
            margin: 0 10px;
    </style>

    <script>
        window.onload(function requestData(){
            $.ajax({1
                url: "http://localhost:8080/soft/user/getInfo",
                type: "get",
                dataType: "json",
                success: function(data){
                          /*这个方法里是ajax发送请求成功之后执行的代码*/
                         showData(data);//我们仅做数据展示
                },
                error: function(msg){
                    alert("ajax连接异常："+msg);
                }
            });
        });

        function showData(data) {
            var str = "";//定义用于拼接的字符串
            for (var i = 0; i < data.length; i++) {
          //拼接表格的行和列
                str = "<tr><td>" + data[i].name + "</td><td>" + data[i].desc + "</td><td>" +  data[i].price + "</td></tr>";
          //追加到table中
                $("#tab").append(str);
            }
        }
    </script>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<span class="car"><i class="shopping-cart"></i></span>
<!--QQ-->
<span class="car"><i class="shopping-cart"></i></span>

<div class="clear"></div>
<!--a-->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="top-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-6">
                    <p class="bold text-left">24小时竭诚为您服务 </p>
                </div>
                <div class="col-sm-6 col-md-6">
                    <p class="bold text-right">24小时热线电话 +86 1438438</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container navigation">

        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="index.html">
                <img src="img/logo.png" alt="" width="150" height="40" />
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <#--<li class="active"><a href="index.html">首页</a></li>-->
                <#--<li><a href="club.ftl">会所介绍</a></li>-->
                <#--<li><a href="西安套餐.html">套餐介绍</a></li>-->

                <!这里进行登陆的跳转><li><a href="login.html">登出</a></li>
                <#--<!这里进行注册的跳转><li><a href="regedit.html">注册</a></li>-->

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<div>
    <ul>
        <br>
        <br>
        <br>
        <br>
        <br></br>

    </ul>
</div>
<br>

<!--	  套餐内容-->
<div class="conbox">
    <div class="c-top">
        <div class="c-top-l">
            <img src="/soft/static/img/beijing/中图.jpg" width="400px" height="380px" >
            <img src="/soft/static/img/beijing/小图1.jpg" width="152px" height="152px">
            <img src="/soft/static/img/beijing/小图2.jpg" width="152px" height="152px">
            <img src="/soft/static/img/beijing/小图3.jpg" width="152px" height="152px">
        </div>
        <div class="c-top-r" >
            <h3 style="color: #2B3444">${clubInfo.name}<br><small>${clubInfo.description}</small></h3>
            <p style="color: #2B3444">地址 ：${clubInfo.address}</p>
            <p style="color: #2B3444">联系方式 ：${clubInfo.phone}</p>

            <ol>
                <table border>
                    <thead>
                    <tr>
                        <th>套餐名称</th>
                        <th>套餐内容</th>
                        <th>套餐价格</th>
                        <th>时间单位</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list clubProductList.list as clubProduct>
                    <tr>
                        <td>${clubProduct.name}</td>
                        <td>${clubProduct.desc}</td>
                        <td>${clubProduct.price}</td>
                        <td>${clubProduct.getDateUnitEnum().message}</td>
                        <td>
                            <a href="order?uid=${uid}&pid=${clubProduct.id}">
                                <button id="dialog-success" type="button" class="btn btn-sm btn-success btn-block" onClick="javascript:return window.confirm('您确定要预约吗？！')">预约</button>
                                <script>

                                    $( "#dialog-success" ).on("click", function () {
                                        Helper.ui.dialogSuccess( "提示：", "预约成功！" );
                                    })
                                </script>
                            </a>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </ol>


            <div class="scbox">
                <i class="fa fa-heart-o shoucan" aria-hidden="true"></i>
                <i class="fa fa-heart shoucan2" aria-hidden="true"></i>

            </div>
            <div class="fxbox">
                <i class="fa fa-heart-o shoucan" aria-hidden="true"></i>
                <i class="fa fa-heart shoucan2" aria-hidden="true"></i>

            </div>
            <br>
            <p style="clear: both; color: #666666;font-size:14px; line-height: 40px;">温馨提醒：如若取消预订请电话联系</p>
        </div>
    </div>
    <div class="c-bottom" >
        <ul class="c-b-nav" style="background-color: #5A5A5A">
            <li>会所详情</li>
            <li>会所评价</li>

        </ul>
        <div class="xqnr">

            <div class="box2"></div>
            <center><img src="/soft/static/img/beijing/大图.jpg" width="75%" ></center>
        </div>
        <script src="/soft/static/js/MyPaging.js"></script>
        <script src="/soft/static/js/script.js"></script>

        <body id="body">
        <div class="sppj hide">

            <span>发表您对该会所的评价：</span>
            <span class="tag">您最多可以输入100个字符</span>
            <textarea id="text" cols="30" rows="10" maxlength="30" class="text"></textarea><br>
            <input type="button" value="发 表" id="ipt">
            <div id="txt" >


            </div>
        </div>
        <div style="text-align:center;">
        </div>
        </body>
        <script>
            var ipt = document.getElementById("ipt");
            var txt = document.getElementById('txt');
            var textarea = document.getElementById("text");
            ipt.onclick = function(){
                var textValue = textarea.value.LTrim();
                textarea.value="";
                if(textValue.length>0 ){
                    var divs = document.createElement("div");
                    var imgs = document.createElement("img");
                    var ps = document.createElement("p");
                    var inputs = document.createElement("input");
                    divs.setAttribute("class","creatediv");
                    imgs.setAttribute('class',"createimg");
                    ps.setAttribute("class","createdivs");
                    inputs.setAttribute("class","createinput");
                    imgs.src="img/1.jpg";
                    inputs.type="button";
                    inputs.value="删除";
                    ps.innerHTML=textValue;
                    divs.appendChild(imgs);
                    divs.appendChild(ps);
                    divs.appendChild(inputs);
                    if(txt.children.length==0){
                        txt.appendChild(divs);

                    }else{
                        txt.insertBefore(divs,get_firstChild(txt))
                    }
                    inputs.onclick = function(){
                        this.parentNode.parentNode.removeChild(this.parentNode)
                    }
                }



            }
        </script>




        <footer>

            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <div class="wow fadeInDown" data-wow-delay="0.1s">
                            <div class="widget">
                                <h5>会所宗旨</h5>
                                <p>
                                    让孕妈感受到家的温暖，让您和孩子拥有健康
                                </p>
                            </div>
                        </div>
                        <div class="wow fadeInDown" data-wow-delay="0.1s">
                            <div class="widget">
                                <h5>会所信息</h5>
                                <ul>
                                    <p>专业团队，为您的健康保驾护航</p>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4">
                        <div class="wow fadeInDown" data-wow-delay="0.1s">
                            <div class="widget">
                                <h5>会所理念</h5>
                                <p>
                                    让您花最少的钱，享受最优质的服务
                                </p>
                                <ul>
                                    <li>
                    <span class="fa-stack fa-lg">
									<i class="fa fa-circle fa-stack-2x"></i>
									<i class="fa fa-calendar-o fa-stack-1x fa-inverse"></i>
								</span> 24小时竭诚为您服务
                                    </li>
                                    <li>
                    <span class="fa-stack fa-lg">
									<i class="fa fa-circle fa-stack-2x"></i>
									<i class="fa fa-phone fa-stack-1x fa-inverse"></i>
								</span> +86 1438438
                                    </li>
                                    <li>
                    <span class="fa-stack fa-lg">
									<i class="fa fa-circle fa-stack-2x"></i>
									<i class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
								</span> yuezihuisuo@163.com
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4">
                        <div class="wow fadeInDown" data-wow-delay="0.1s">
                            <div class="widget">
                                <h5>我们的地址</h5>
                                <p>陕西省西安市子午大道</p>

                            </div>
                        </div>
                        <div class="wow fadeInDown" data-wow-delay="0.1s">
                            <div class="widget">
                                <h5>Follow us</h5>
                                <ul class="company-social">
                                    <li class="social-facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li class="social-twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li class="social-google"><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    <li class="social-vimeo"><a href="#"><i class="fa fa-vimeo-square"></i></a></li>
                                    <li class="social-dribble"><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </footer>

    </div>
    <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>

    <!-- Core JavaScript Files -->
    <script src="/soft/static/js/jquery.min.js"></script>
    <script src="/soft/static/js/bootstrap.min.js"></script>
    <script src="/soft/static/js/jquery.easing.min.js"></script>
    <script src="/soft/static/js/wow.min.js"></script>
    <script src="/soft/static/js/jquery.scrollTo.js"></script>
    <script src="/soft/static/js/jquery.appear.js"></script>
    <script src="/soft/static/js/stellar.js"></script>
    <script src="plugins/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
    <script src="/soft/static/js/owl.carousel.min.js"></script>
    <script src="/soft/static/js/nivo-lightbox.min.js"></script>
    <script src="/soft/static/js/custom.js"></script>

    <!--/ items -->


    <script type="text/javascript" src="/soft/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src='/soft/static/js/jquery-ui.min.js'></script>
    <script type="text/javascript">
        $('.add-to-cart').on('click', function () {
            var cart = $('.shopping-cart');
            var imgtodrag = $(this).parent('.item').find('img').eq(0);
            if (imgtodrag) {
                var imgclone = imgtodrag.clone().offset({
                    top: imgtodrag.offset().top,
                    left: imgtodrag.offset().left
                }).css({
                    'opacity': '0.5',
                    'position': 'absolute',
                    'height': '150px',
                    'width': '150px',
                    'z-index': '100'
                }).appendTo($('body')).animate({
                    'top': cart.offset().top + 10,
                    'left': cart.offset().left + 10,
                    'width': 75,
                    'height': 75
                }, 1000, 'easeInOutExpo');
                setTimeout(function () {
                    cart.effect('shake', { times: 2 }, 200);
                }, 1500);
                imgclone.animate({
                    'width': 0,
                    'height': 0
                }, function () {
                    $(this).detach();
                });
            }
        });
    </script>

</body>

</html>
