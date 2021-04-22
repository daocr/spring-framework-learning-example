<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>freemarker spring demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>
</head>
<body>

<h3>普通值测试</h3>
<p>${userName}</p>


<hr>


<h3>list 数据</h3>

<table class="table">
    <thead>
    <tr>
        <th scope="col">名称</th>
        <th scope="col">工作</th>
        <th scope="col">生日</th>
    </tr>
    </thead>
    <tbody>


    <#--    <tr th:each="item : ${list}">-->
    <#--        <td th:text="${item.name}"></td>-->
    <#--        <td th:text="${item.job}"></td>-->
    <#--        <td th:text="${item.birthday}"></td>-->
    <#--    </tr>-->

    </tbody>
</table>


<h1>国际化内容</h1>
<#--<p th:text="#{my.world}"></p>-->

</body>

</html>