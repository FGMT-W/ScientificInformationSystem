'use strict';

layui.config({
    base: '/js/' //静态资源所在路径
}).use(['form', 'table'], function () {
    var form = layui.form
        , table = layui.table;

    //论文列表
    table.render({
        elem: '#table_thesisforadmin',
        height: 600,
        width: 1200,
        url: '/thesis/pageThesisByParams', //数据接口
        where: { sort: "startTime,DESC" },
        cols: [[
            { field: "author", title: "作者姓名" },
            { field: "thesisname", title: "论文中/英文名称" },
            { field: "type", title: "论文类别" },
            { field: "startTime", title: "发表时间",sort:true },
            { field: "publication", title: "发表刊物"  },
            { field: "thesisabstract", title: "摘要",width: 150 },
            { field: "status", title: "状态", templet: '#statusbar' ,sort:true},
            { fixed: 'right', align: 'center', toolbar: '#toolbar', width: 260 }
        ]],
        page: true,
        start:{curr:0},//重新从第一页开始
        request:{
            pageName:'start'
        }
    });

    //监听表格工具栏
    table.on('tool(table_thesisforadmin)', function (obj) {
        var data = obj.data;
        if (obj.event === 'pass'){
            layer.confirm('确认审核其通过吗？', function () {
                $.ajax({
                    type: 'post',
                    url: '/thesis/pass',
                    dataType: 'json',
                    data: { thesisId: data.id, adminId: sessionStorage.id },
                    success: function (res) {
                        if (res.code === 200) {
                            layer.alert("审核通过成功!", function (index) {
                                window.location.reload();
                            });
                        }else{
                            layer.alert("您已经审核过该项目了，请勿重复操作!", function (index) {
                                window.location.reload();
                            });
                        }
                    }
                });
            });
        }
        else if (obj.event === 'no-pass'){
            layer.confirm('确认审核其不通过吗？', function () {
                $.ajax({
                    type: 'post',
                    url: '/thesis/no-pass',
                    dataType: 'json',
                    data: { thesisId: data.id, adminId: sessionStorage.id },
                    success: function (res) {
                        if (res.code === 200) {
                            layer.alert("操作成功!", function (index) {
                                window.location.reload();
                            });
                        }else{
                            layer.alert("您已经审核过该项目了，请勿重复操作!", function (index) {
                                window.location.reload();
                            });
                        }
                    }
                });
            });
        }
        /*else if (obj.event === 'download'){
            layer.confirm('确认下载该论文吗？', function () {
                if(data.thesisPath === null){
                    layer.alert("未上传论文!");
                    return false;
                }
                window.open(data.thesisPath);
                window.location.reload();
            });
        }*/
        else if (obj.event === 'del') {
            layer.confirm('确认删除该论文？', function () {
                $.ajax({
                    type: 'delete',
                    url: '/thesis/delete',
                    dataType: 'json',
                    data: { id: data.id },
                    success: function (res) {
                        if (res.code === 200) {
                            layer.alert("删除成功!", function (index) {
                                window.location.reload();
                            });
                        }
                    }
                });
            });
        }
    });

    //监听查询按钮
    $("#search").click(function () {
        table.reload('table_thesisforadmin', {
            where: { thesisname: $('#input').val() }
        });
    });
});