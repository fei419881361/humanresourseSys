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

<div id="win" class="easyui-window" title="记录" style="width:500px;height:280px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <div align="center" style="padding-top: 20px">
        <form id = "editForm"  method = "post" enctype="multipart/form-data">
            <table >
                <!--提交修改的时候要传入-->
                <input type="hidden" name = "id" id = "id">

                <tr class="mTr">
                    <td>主题：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="theme" id="theme"/></td>
                </tr>
                <tr class="mTr">
                    <td>时间：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="date" name ="time" id="time"/></td>
                </tr>
                <tr class="mTr">
                    <td>金额：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="money" id="money"/></td>
                </tr>
                <tr class="mTr">
                    <td>员工编号：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="empId" id="empId"/></td>
                </tr>
                <tr class="mTr">
                    <td>类型：</td>
                    <td>
                        <select id="bState" class="easyui-combobox" data-options="required:true,editable:false "  name="type" style="width:220px;">
                            <option value="0" >奖励</option>
                            <option value="1">处罚</option>
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

<div id="win2" class="easyui-window" title="记录" style="width:600px;height:460px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <div align="center" style="padding-top: 20px">
        <form id = "editForm2"  method = "post" enctype="multipart/form-data">
            <table >
                <!--提交修改的时候要传入-->
                <input type="hidden" name = "id" id = "id2">

                <tr class="mTr">
                    <td>姓名：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="name" id="name"/></td>
                </tr>
                <tr class="mTr">
                    <td>部门：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="depName" id="depName"/></td>
                </tr>
                <tr class="mTr">
                    <td>身份证：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="idCard" id="idCard"/></td>
                </tr>

                <tr class="mTr">
                    <td>生日：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="birthday" id="birthday"/></td>
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
                    <td>工作时间：</td><td><input  data-options="required:true,validType:'length[0,20]'" class="easyui-validatebox" type ="text" name ="workTime" id="workTime"/></td>
                </tr>

                <tr class="mTr">
                    <td>性别：</td>
                    <td>
                        <select id="bState2" class="easyui-combobox" data-options="required:true,editable:false "  name="gender" style="width:220px;">
                            <option value="0" >女</option>
                            <option value="1">男</option>
                        </select>
                    </td>
                </tr>

                <tr class="mTr">
                    <td>备注：</td><td><textarea name="remarks" style="width: 220px;height:100px" id="remarks"></textarea></td>
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
    <a id = "detailed" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'职员详情',iconCls:'icon-sum',plain:true"> </a>
</div>

<script type="text/javascript">
    $(function () {
        var flag = 0;
        var add = "/rp/register";
        var update = "/rp/update";

        $('#list').datagrid({
            url:'/rp/findAllBySplit',
            columns:[[
                {field:"id",title:"编号",width:80,align:'center'},
                {field:"theme",title:"主题",width:150,align:'center'},
                {field:"time",title:"时间",width:150,align:'center'},
                {field:"money",title:"金额",width:150,align:'center'},
                {field:"empId",title:"员工编号",width:150,align:'center'},
                {field:"type",title:"类型",width:100,formatter:function (value,row,index) {
                    return value===1?"处罚":"奖励";
                },align:'center'}
            ]],
            pagination:true,
            toolbar:"#toolbar",
            fit:true
        });

        //增加按钮
        $("#addBtn").click(function () {
            flag = 1;
            $("#editForm").form("clear");
            $("#win").window("open");
        });

        //员工详情
        $('#detailed').click(function () {
            var stu = $('#list').datagrid('getSelections');
            if(!stu || stu.length == 0){
                $.messager.alert('错误提醒','请选择一条记录！','info');
                return false;
            }
            var s = stu[0];
            $.messager.confirm('确认','确定查看选中员工的信息吗？',function(r){
                if (r){
                    $.post('/emp/findById',{"id":s.empId},function (data) {
                        var data = eval('(' + data + ')');  // change the JSON string to javascript object
                        $.messager.show({
                            title:'消息',
                            msg:data.message,
                            timeout:3000,
                            showType:'slide',
                            height:120,
                            width:200
                        });
                        $("#id2").val(data.e.id);
                        $("#name").val(data.e.name);
                        $("#depName").val(data.e.depName);
                        $("#idCard").val(data.e.idCard);
                        $("#birthday").val(data.e.birthday);
                        $("#education").val(data.e.education);
                        $("#major").val(data.e.major);
                        $("#phone").val(data.e.phone);
                        $("#workTime").val(data.e.workTime);
                        $("#bState2").val(data.e.gender);
                        $("#remarks").val(data.e.remarks);

                        $("#win2").window("open");

                    });

                }
            },'json');

        })
        //提交增加表单
        $("#submitBtn").click(function () {
            var path = ""
            if(flag == 1){
                path = add;
            }else{
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
                    $.post('/rp/remove',{"ids":ids.toString()},function (data) {
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
            console.log(rc);
            $("#id").val(rc.id);
            $("#theme").val(rc.theme);
            $("#time").val(rc.time);
            $("#money").val(rc.money);
            $("#empId").val(rc.empId);
            $("#type").val(rc.type);

            $('#bState').combobox("enable");
            $("#win").window("open");
        });

    })


</script>
</body>
</html>
