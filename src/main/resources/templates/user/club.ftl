<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>会所介绍</title>

    <!-- css -->
    <link href="/soft/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/soft/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<!--    <link rel="stylesheet" type="text/css" href="plugins/cubeportfolio/css/cubeportfolio.min.css">-->
    <link href="/soft/static/css/nivo-lightbox.css" rel="stylesheet"/>
    <link href="/soft/static/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css"/>
    <link href="/soft/static/css/owl.carousel.css" rel="stylesheet" media="screen"/>
    <link href="/soft/static/css/owl.theme.css" rel="stylesheet" media="screen"/>
    <link href="/soft/static/css/animate.css" rel="stylesheet"/>
    <link href="/soft/static/css/style_2.css" rel="stylesheet">

    <!-- boxed bg -->
    <link id="bodybg" href="/soft/static/bodybg/bg1.css" rel="stylesheet" type="text/css"/>
    <!-- template skin -->
    <link id="t-colors" href="/soft/static/color/default.css" rel="stylesheet">
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">


<div id="wrapper">

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
                    <img src="/soft/static/img/logo.png" alt="" width="150" height="40"/>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">

                    <li><a href="login.html">登出</a></li>


                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div>
        <ul>
            <li>2</li>
            <li>2</li>
            <li>2</li>
            <li>2</li>
        </ul>
    </div>


    <br></br>
    <br></br>


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">


                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="/soft/user/list?lid=0">ALL</a>
                    </li>
                    <li>
                        <a href="/soft/user/list?lid=1">最受欢迎</a>
                    </li>
                    <li class="disabled">
                        <a href="/soft/user/list?lid=2">妈妈最爱</a>
                    </li>
                </ul>

                <table class="table">
                        <thead>
                        <tr>
                            <th>会所名称</th>
                            <th>会所图片</th>
                            <th>会所地址</th>
                            <th>会所详情</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list clubInfoList.list as clubInfo>
                        <tr>
                            <td>${clubInfo.name}</td>
                            <td><img height="140" width="200" src="${clubInfo.coverImage}" alt=""></td>
                            <td>${clubInfo.address}</td>
                            <td><a href="/soft/user/getInfo?id=${clubInfo.id}"><button type="button" class="btn btn-sm btn-warning btn-block">详情</button></a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    </ol>
                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/soft/user/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>
                        <#list 1..clubInfoList.getPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/soft/user/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                        <#if currentPage gte clubInfoList.getPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/soft/user/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                        </ul>
                    </div>

                </div>
            </div>
        </div>


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

</body>

</html>
