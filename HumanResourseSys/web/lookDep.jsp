<%--
  Created by IntelliJ IDEA.
  User: 41988
  Date: 2018/2/23
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
<!--表单弹出层-->
<div id="win" class="easyui-window" title="增加部门" style="width:350px;height:260px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <div align="center" style="padding-top: 20px">
        <form id = "editForm"  method = "post" enctype="multipart/form-data">
            <table >
                <!--提交修改的时候要传入-->
                <%--<input type="hidden" name = "sid" id = "sid">--%>
                <%--<input type="hidden" name = "sname" id = "sname">--%>
                <%--<input type="hidden" name = "sclass" id = "sclass">--%>
                <%--<input type="hidden"  id = "sgrade" name = "sgrade">--%>

                <tr class="mTr">
                    <td>部门名称：</td><td><input id="oName"  data-options="required:true,validType:'length[0,30]'" class="easyui-validatebox" type ="text" name ="name" /></td>
                </tr>

                <tr class="mTr">
                    <td>部门备注：</td><td><textarea id="oRemark"  cols="22" rows="10" data-options="required:false,validType:'length[0,200]'" class="easyui-validatebox" name ="remark"></textarea></td>
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
        <a id = "addBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'添加部门',iconCls:'icon-add',plain:true"> </a>
        <a id = "removeBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="text:'移除部门',iconCls:'icon-remove',plain:true"> </a>
    </div>

<script type="text/javascript">
    $(function () {
        $('#list').datagrid({
            url:'/dep/findAllBySplit',
            columns:[[
                {field:"id",title:"部门编号",width:250,align:'center'},
                {field:"name",title:"名称",width:250,align:'center'},
                {field:"peopleNum",title:"部门人数",width:250,align:'center'},
                {field:"createDate",title:"创建时间",width:250,align:'center'},
                {field:"remark",title:"备注",width:250,align:'center'}
            ]],
            pagination:true,
            toolbar:"#toolbar",
            fit:true
        });

        //增加部门按钮
        $("#addBtn").click(function () {
            $("#editForm").form("clear");
            $("#win").window("open");
        });
        //提交增加部门表单
        $("#submitBtn").click(function () {
            $('#editForm').form('submit', {
                url:"/dep/register",

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
                $.messager.alert('错误提醒','请选择一个部门！','info');
                return false;
            }
            var ids = [] ;
            for(var i =0 ;i<stu.length;i++){
                ids.push(stu[i].id)
            }
            $.messager.confirm('确认','您确认想删除这些部门吗？',function(r){
                if (r){
                    $.post('/dep/remove',{"ids":ids.toString()},function (data) {
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


    })


</script>
</body>
</html>
