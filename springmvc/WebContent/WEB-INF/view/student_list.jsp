<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生管理系统</title>
    
    <!-- 引入JQ和Bootstrap -->
    <script src="../springmvc/js/jquery.min.js"></script>
    <script src="../springmvc/js/bootstrap.min.js"></script>
    <script src="../springmvc/js/bootstrap-table.min.js"></script>
    <script src="../springmvc/js/jquery.bootstrap-growl.js"></script>
    <!-- <script src="../springmvc/js/jquery.datagrid-toolbar.js"></script> -->
    
    
    <link rel="stylesheet" href="../springmvc/js/bootstrap.min.css">
    <link rel="stylesheet" href="../springmvc/js/bootstrap-select.min.css">
    <link rel="stylesheet" href="../springmvc/js/bootstrap-table.min.css">
    
    <script>
   /*  function load(){
        var uri = "";
        document.getElementById("ClassList").setAttribute('data-url',uri);
        //$('#ClassList').setAttribute('data-url',uri);
        //$('#ClassList').attributes['data-url']=uri;
        queryList();//刷新表格方法
        console.log("shuaxin");
    } */
    var t=setTimeout("load()",1000);
    function queryList() {
        $('#ClassList').bootstrapTable('refresh');
    }
    function operatorFormatter(value, row, index) {
        var operator = "";
        operator += '<button class="btn btn-warning btn-round btn-xs" onclick="editById(\''
                + row.id
                + '\');"><i class="glyphicon glyphicon-pencil"></i> 修改</button>&nbsp;&nbsp;';
    
        operator += '<button class="btn btn-danger btn-round btn-xs" onclick="deleteById(\''
                    + row.id
                    + '\');"><i class="glyphicon glyphicon-trash"></i> 删除</button>&nbsp;&nbsp;';
    
        return operator;
    }
    
    
    function deleteById(id){
         $.ajax({
             url : "../springmvc/deleteStudent.do?id="+id,
             //data : id,
             cache : false,
             dataType : 'JSON',
             type : 'post',
             success : function(data) {
                 if(data.success){
                     alert("删除成功");
                     queryList();
                 }else{
                     alert(data.msg);
                 }
             }
         });
    }
    function viewById(id) {
       // window.location = "../springmvc/toStudentList.do?id="+id;
    }
       function editById(id) {
            window.location = '../springmvc/toAddStudent.do?id='+id;
        }
       function toAdd() {
           window.location = "../springmvc/toAddStudent.do";
       }
    </script>
</head>


<body>
    <div id="toolbar" class="btn-group">
    <button class="btn btn-info btn-round" onclick="toAdd();">
                        <i class="glyphicon glyphicon-plus"></i>添加
                    </button>
                    <button class="btn btn-danger btn-round" onclick="toRemove()">
                        <i class="glyphicon glyphicon-trash"></i>删除
                    </button>
    </div>
    <div>
        <table id="ClassList" data-toggle="table"
            data-url="../springmvc/StudentList.do?id=${id}" data-pagination="true"
            data-side-pagination="server" data-cache="false"
            data-query-params="postQueryParams"             
            data-page-list="[10, 15, 20, 30, 50,100]" data-method="post"
            data-show-refresh="true" data-show-toggle="true"
            data-show-columns="true" data-toolbar="#toolbar"
            data-click-to-select="true" data-single-select="false"
            data-striped="true"
            data-content-type="application/x-www-form-urlencoded">
            <thead>
                <tr>
                    <th data-field="" data-checkbox="true"></th>
                    <th data-field="id">学号</th>
                    <th data-field="name">名字</th>
                    <th data-field="className">班级</th>
                    <th data-field="sex">性别</th>
                    <th data-field="nation">籍贯</th>
                    <th data-field="operator" data-formatter="operatorFormatter">操作</th>
                </tr>
                <tr><td align="center"></td></tr>
            </thead>
        </table>
    </div>

</body>
</html>