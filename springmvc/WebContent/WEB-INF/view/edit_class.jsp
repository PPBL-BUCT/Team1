<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


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

    <title>学生管理系统 - 班级编辑页面</title>

    <script>
        $(function () {
            $("#editForm").submit(function () {
                if (!checkEmpty("id", "班号"))
                    return false;
                if (!checkEmpty("name", "名称"))
                    return false;
                if (!checkEmpty("yearValue", "入学年份"))
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
            <h3 class="panel-title">编辑班级</h3>
        </div>
        <div class="panel-body">

            <form method="post" id="editForm" action="../springmvc/addClass.do" role="form">
                <table class="editTable">
                        <td><input type="hidden" name="id" id="id" value="${class1.id}"
                                   placeholder="请在这里输入班号"></td>
                    <tr>
                        <td>名称：</td>
                        <td><input type="text" name="name" id="name" value="${class1.name}" placeholder="请在这里输入班级名称">
                        </td>
                    </tr>
                    <tr>
                        <td>人数：</td>
                        <td><input type="text" name="number" id="number" value="${class1.number}" placeholder="请在这里输入人数"></td>
                    </tr>
                    <tr>
                        <td>入学年份：</td>
                        <td><input type="text" name="yearValue" id="yearValue" value="${class1.yearValue}" placeholder="请在这里输入入学年份"></td>
                    </tr>
                    <td><input type="hidden" name="status" id="status" value="${class1.status}"
                                   placeholder="请在这里输入班号">
                    </td>
                    
                    <tr class="submitTR">
                        <td colspan="2" align="center">
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