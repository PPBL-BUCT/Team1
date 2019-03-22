<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <!-- 引入JQ和Bootstrap -->
	<script src="../springmvc/js/jquery.min.js"></script>
	<script src="../springmvc/js/bootstrap.min.js"></script>
	<script src="../springmvc/js/bootstrap-table.min.js"></script>
	<script src="../springmvc/js/jquery.bootstrap-growl.js"></script>
	<script src="../springmvc/js/jquery.datagrid-toolbar.js"></script>
	
	
	<link rel="stylesheet" href="../springmvc/js/bootstrap.min.css">
	<link rel="stylesheet" href="../springmvc/js/bootstrap-select.min.css">
	<link rel="stylesheet" href="../springmvc/js/bootstrap-table.min.css">

    <title>学生管理系统 - 学生编辑页面</title>

    <script>
        $(function () {
            $("#editForm").submit(function () {
                if (!checkEmpty("id", "学号"))
                    return false;
                if (!checkEmpty("name", "姓名"))
                    return false;
                if (!checkEmpty("age", "年龄"))
                    return false;
                return true;
            });
        });
        function checkEmpty(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert(name + "不能为空");
                $("#" + id).focus();
                return false;
            }
            return true;
        }
    </script>
</head>

<body>

<div class="editDIV">

    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">编辑学生</h3>
        </div>
        <div class="panel-body">

            <form method="post" id="editForm" action="/updateStudent" role="form">
                <table class="editTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="id" id="id" value="${student.Id}"
                                   placeholder="请在这里输入学号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="name" id="name" value="${student.name}" placeholder="请在这里输入名字">
                        </td>
                    </tr>
                    <tr>
                        <td>班级：</td>
                        <td><input type="text" name="classId" id="classId" value="${student.ClassId}" placeholder="请在这里输入班级"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" <c:if test="${student.sex == '男'}">checked</c:if> class="radio radio-inline" name="sex" value="男"> 男
                            <input type="radio" <c:if test="${student.sex == '女'}">checked</c:if> class="radio radio-inline" name="sex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>籍贯：</td>
                        <td><input type="text" name="nation" id="nation" value="${student.nation}" placeholder="请在这里输入籍贯"></td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input type="date" name="birthday" id="birthday" value="${student.birthday}"
                                   placeholder="请在这里输入出生日期"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${student.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>

                    </tr>

                </table>
            </form>
        </div>
    </div>

</div>

</body>
</html>