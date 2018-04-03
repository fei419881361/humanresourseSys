<%--
  Created by IntelliJ IDEA.
  User: 41988
  Date: 2018/4/1
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="eazyui/jquery.min.js"></script>
    <script type="text/javascript" src="eazyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="eazyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="eazyui/themes/icon.css">
    <link id="linkstyle" rel="stylesheet" type="text/css" href="eazyui/themes/default/easyui.css">
    <title></title>
</head>
<body>

<div id="win" class="easyui-window" title="记录" style="width:600px;height:460px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <div align="center" style="padding-top: 20px">
        <form id = "editForm"  method = "post" enctype="multipart/form-data">
            <table >
                <!--提交修改的时候要传入-->
                <input type="hidden" name = "id" id = "id">

                <tr class="mTr">
                    <td>姓名：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="name" id="name"/></td>
                </tr>
                <tr class="mTr">
                    <td>应聘部门：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="depName" id="depName"/></td>
                </tr>


                <tr class="mTr">
                    <td>学历：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="education" id="education"/></td>
                </tr>
                <tr class="mTr">
                    <td>专业：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="major" id="major"/></td>
                </tr>
                <tr class="mTr">
                    <td>电话：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="phone" id="phone"/></td>
                </tr>
                <tr class="mTr">
                    <td>工作经验：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="workExperience" id="workExperience"/></td>
                </tr>

                <tr class="mTr">
                    <td>性别：</td>
                    <td>
                        <select id="bState" class="easyui-combobox" data-options="required:true,editable:false "  name="gender" style="width:220px;">
                            <option value="0" >女</option>
                            <option value="1">男</option>
                        </select>
                    </td>
                </tr>

                <tr class="mTr">
                    <td>是否录用：</td>
                    <td>
                        <select id="bState" class="easyui-combobox" data-options="required:true,editable:false "  name="hire" style="width:220px;">
                            <option value="0" >否</option>
                            <option value="1">是</option>
                        </select>
                    </td>
                </tr>

                <tr class="mTr">
                    <td>
                        <a id = "submitBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'保存',iconCls:'icon-save',plain:true"/>
                        <a id = "resetBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'重置',iconCls:'icon-save',plain:true"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>


<table id="list"></table>

<div id="toolbar">
    <a id = "addBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'添加信息',iconCls:'icon-add',plain:true"> </a>
    <a id = "removeBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'删除信息',iconCls:'icon-remove',plain:true"> </a>
    <a id = "updateBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'修改信息',iconCls:'icon-edit',plain:true"> </a>
</div>

<script type="text/javascript">
    $(function () {
        $('#list').datagrid({
            url:'/rec/findAllBySplit',
            columns:[[
                {field:"id",title:"编号",width:80,align:'center'},
                {field:"depName",title:"应聘部门",width:100,align:'center'},
                {field:"name",title:"姓名",width:100,align:'center'},
                {field:"education",title:"学历",width:100,align:'center'},
                {field:"major",title:"专业",width:150,align:'center'},
                {field:"phone",title:"电话",width:150,align:'center'},
                {field:"workExperience",title:"工作经验",width:180,align:'center'},
                {field:"gender",title:"性别",width:90,formatter:function (value,row,index) {
                    return value===1?"男":"女";
                },align:'center'},
                {field:"hire",title:"是否录用",width:90,formatter:function (value,row,index) {
                    return value===1?"是":"否";
                },align:'center'}
            ]],
            pagination:true,
            toolbar:"#toolbar",
            fit:true
        });

        //增加员工按钮
        $("#addBtn").click(function () {
            $("#editForm").form("clear");
            $("#win").window("open");
        });
        //提交增加员工表单
        $("#submitBtn").click(function () {
            $('#editForm').form('submit', {
                url:"/rec/register",

                onSubmit: function(){
                    var isValid = $(this).form('validate'); //判断表单是否无效
                    return isValid;	// 返回false终止表单提交
                },

                success:function(data){
                    var data = eval('(' + data + ')');  // change the JSON string to javascript object
                    $.messager.show({
                        title:'消息',
                        msg:data.message,
                        timeout:3000,
                        showType:'slide',
                        height:120,
                        width:200
                    });
                    $('#list').datagrid('reload');//刷新表格
                    $("#win").window("close");
                }
            });
        });
        //reset
        $("#resetBtn").click(function () {
            $("#editForm").form("reset");
        });



        //删除
        $('#removeBtn').bind('click', function(){
            //拿到一个json的数组对象
            var stu = $('#list').datagrid('getSelections');
            if(!stu || stu.length == 0){
                $.messager.alert('错误提醒','请选择一条记录！','info');
                return false;
            }
            var ids = [] ;
            for(var i =0 ;i<stu.length;i++){
                ids.push(stu[i].id)
            }
            $.messager.confirm('确认','您确认想删除该记录吗？',function(r){
                if (r){
                    $.post('/rec/remove',{"ids":ids.toString()},function (data) {
                        var data = eval('(' + data + ')');  // change the JSON string to javascript object
                        $.messager.show({
                            title:'消息',
                            msg:data.message,
                            timeout:3000,
                            showType:'slide',
                            height:120,
                            width:200
                        });
                        $('#list').datagrid('reload');//刷新表格
                    });

                }
            },'json');
        });


        $("#updateBtn").click(function () {

            var rc = $('#list').datagrid('getSelected');
            if(!rc){
                $.messager.alert('错误提醒','请选择一条记录！','info');
                return false;
            }
            console.log(rc);
            $("#id").val(rc.id);
            $("#name").val(rc.name);
            $("#birthday").val(rc.birthday);
            $("#depName").val(rc.depName);
            $("#education").val(rc.education);
            $("#gender").val(rc.gender);
            $("#major").val(rc.major);
            $("#phone").val(rc.phone);
            $("#workExperience").val(rc.workExperience);

            $('#bState').combobox("enable");
            $("#win").window("open");
        });

        //点击弹框确认
        $("#submitBtn").click(function () {
            $('#editForm').form('submit', {
                url:"/rec/update",
                onSubmit: function(){
                    var isValid = $(this).form('validate'); //判断表单是否无效
                    return isValid;	// 返回false终止表单提交
                },
                success:function(data){
                    var data = eval('(' + data + ')');  // change the JSON string to javascript object
                    $.messager.show({
                        title:'消息',
                        msg:data.message,
                        timeout:3000,
                        showType:'slide',
                        height:120,
                        width:200
                    });
                    $('#list').datagrid('reload');//刷新表格
                    $("#win").window("close");
                }
            });

        });
    })


</script>
</body>
</html>
