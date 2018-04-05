<%--
  Created by IntelliJ IDEA.
  User: 41988
  Date: 2018/4/4
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

<div id="win" class="easyui-window" title="记录" style="width:430px;height:320px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <div align="center" style="padding-top: 20px">
        <form id = "editForm"  method = "post" enctype="multipart/form-data">
            <table >
                <!--提交修改的时候要传入-->
                <input type="hidden" name = "id" id = "id">

                <tr class="mTr">
                    <td>基础工资：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="basePay" id="basePay"/></td>
                </tr>
                <tr class="mTr">
                    <td>加班费：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="overtimePay" id="overtimePay"/></td>
                </tr>
                <tr class="mTr">
                    <td>误工费：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="misstimePay" id="misstimePay"/></td>
                </tr>

                <tr class="mTr">
                    <td>考勤费：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="attendancePay" id="attendancePay"/></td>
                </tr>

                <tr class="mTr">
                    <td>保险金：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="insurancePay" id="insurancePay"/></td>
                </tr>
                <tr class="mTr">
                    <td>员工编号：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="empId" id="empId"/></td>
                </tr>
                <tr class="mTr">
                    <td>时间：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="date" name ="time" id="time"/></td>
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


<div id="win2" class="easyui-window" title="记录" style="width:430px;height:320px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <div align="center" style="padding-top: 20px">
        <form id = "editForm2"  method = "post" enctype="multipart/form-data">
            <div id="tb" style="padding:3px">
                <span>Item ID:</span>
                <input id="itemid" style="line-height:26px;border:1px solid #ccc">
                <span>员工姓名:</span>
                <input id="ename" style="line-height:26px;border:1px solid #ccc">
                <a href="#" class="easyui-linkbutton" plain="true" id="bserch">Search</a>
            </div>
            
            <table id="tt" class="easyui-datagrid" style="width:600px;height:250px"
                   url="/sal/find" toolbar="#tb"
                   title="Load Data" iconCls="icon-save"
                   rownumbers="true" pagination="true">
                <thead>
                <tr>
                    <th field="id" width="80">编号</th>
                    <th field="basePay" width="100">基本工资</th>
                    <th field="overtimePay" width="100" align="right">加班费</th>
                    <th field="misstimePay" width="150" align="right">误工费</th>
                    <th field="attendancePay" width="150">考勤费</th>
                    <th field="insurancePay" width="100" align="center">保险金</th>
                    <th field="empId" width="150" align="center">员工编号</th>
                    <th field="time" width="150" align="center">时间</th>
                </tr>
                </thead>
            </table>
        </form>
    </div>
</div>



<table id="list"></table>

<div id="toolbar">
    <a id = "addBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'添加信息',iconCls:'icon-add',plain:true"> </a>
    <a id = "removeBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'删除信息',iconCls:'icon-remove',plain:true"> </a>
    <a id = "updateBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'修改信息',iconCls:'icon-edit',plain:true"> </a>
    <a id = "search" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'查询信息',iconCls:'icon-search',plain:true"> </a>
</div>

<script type="text/javascript">
    $(function () {
        $('#search').click(function () {
            $("#win2").window("open");
        })

        var flag = 0;
        var update = "/sal/update";
        var add = "/sal/register";


        $('#list').datagrid({
            url:'/sal/findAllBySplit',
            columns:[[
                {field:"id",title:"编号",width:80,align:'center'},
                {field:"basePay",title:"基础工资",width:100,align:'center'},
                {field:"overtimePay",title:"加班费",width:100,align:'center'},
                {field:"misstimePay",title:"误工费",width:150,align:'center'},
                {field:"attendancePay",title:"考勤费",width:150,align:'center'},
                {field:"insurancePay",title:"保险金",width:100,align:'center'},
                {field:"empId",title:"员工编号",width:150,align:'center'},
                {field:"time",title:"时间",width:150,align:'center'}
            ]],
            pagination:true,
            toolbar:"#toolbar",
            fit:true
        });

        //增加员工按钮
        $("#addBtn").click(function () {
            flag = 1;
            $("#editForm").form("clear");
            $("#win").window("open");
        });

        //提交表单
        $("#submitBtn").click(function () {
            var path =""
            if(flag == 1){
                path = add;
            }else {
                path = update;
            }
            $('#editForm').form('submit', {
                url:path,

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
                    $.post('/emp/remove',{"ids":ids.toString()},function (data) {
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
            flag = 0;
            var rc = $('#list').datagrid('getSelected');
            if(!rc){
                $.messager.alert('错误提醒','请选择一条记录！','info');
                return false;
            }
            $("#id").val(rc.id);
            $("#basePay").val(rc.basePay);
            $("#overtimePay").val(rc.overtimePay);
            $("#misstimePay").val(rc.misstimePay);
            $("#attendancePay").val(rc.attendancePay);
            $("#insurancePay").val(rc.insurancePay);
            $("#empId").val(rc.empId);
            $("#time").val(rc.time);

            $('#bState').combobox("enable");
            $("#win").window("open");
        });

    })


</script>
</body>
</html>
