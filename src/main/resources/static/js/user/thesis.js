'use strict';

layui.config({
    base: '/js/' //静态资源所在路径
}).use(['form', 'table', 'upload', 'laydate'], function () {
    var form = layui.form
        , upload = layui.upload
        , table = layui.table
        , laydate = layui.laydate;

    //日期选择框的id
    laydate.render({
        elem: '#startTime'
    });

    //论文列表
    table.render({
        elem: '#table_thesis',
        height: 600,
        width: 1200,
        url: '/thesis/pageByParams', //数据接口
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

    //上传论文功能
    upload.render({
        elem: '#btn_selectThesis',
        url: '/thesis/submit',
        auto: false,//不自动上传
        accept: 'file',
        data: {dict:"thesis/"},
        acceptMime: 'file/pdf,file/docx',
        exts: 'pdf|docx',
        bindAction: '#btn_uploadThesis', //触发上传的按钮
        before: function () {
            layer.load();
        },
        done: function (res) {
            layer.closeAll('loading');
            $('#btn_selectThesis').html("<i class=''layui-icon layui-icon-upload-drag'></i>重新选择");
            if (res.code === 200) {
                layer.msg(res.msg);
                $('#thesis').html("<i class='layui-icon layui-icon-file'></i> <a href='" + res.data["path"] + "'>" + res.data["name"] + "<a/>");
                $('#thesisPath').val(res.data["path"]);
            } else {
                layer.msg(res.msg);
                $('#thesis').html("");
                $('#thesisPath').val("");
            }
        },
    });

    //监听"论文录入"按钮
    window.btn_addThesis = function () {
        layer.open({
            type: 1, //页面层
            title: "论文录入",
            area: ['600px', '300px'],
            btn: ['保存', '取消'],
            btnAlign: 'c', //按钮居中
            content: $('#div_addThesis'),
            success: function (layero, index) {// 弹出layer后的回调函数,参数分别为当前层DOM对象以及当前层索引
                // 解决按回车键重复弹窗问题
                $(':focus').blur();
                // 为当前DOM对象添加form标志
                layero.addClass('layui-form');
                // 将保存按钮赋予submit属性
                layero.find('.layui-layer-btn0').attr({
                    'lay-filter': 'btn_saveThesisAdd',
                    'lay-submit': ''
                });
                // 表单验证
                form.verify();
                // 刷新渲染(否则开关按钮不会显示)
                form.render();
            },
            yes: function (index, layero) {// 确认按钮回调函数,参数分别为当前层索引以及当前层DOM对象
                form.on('submit(btn_saveThesisAdd)', function (data) {//data按name获取
                    $.ajax({
                        type: 'post',
                        url: '/thesis/add',
                        dataType: 'json',
                        data: data.field,
                        success: function (res) {
                            if (res.code === 200) {
                                layer.alert("录入成功!待管理员审核通过后即可下载", function (index) {
                                    window.location.reload();
                                });
                            }
                            else {
                                layer.alert("录入失败!");
                            }
                        }
                    });
                    return false;
                });
            }
        });
    };

    //监听论文表格工具栏
    table.on('tool(table_thesis)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确认删除该论文吗？', function () {
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
        } /*else if(obj.event === 'download'){
            if(data.thesisPath === null){
                layer.alert("未上传论文!");
                return false;
            }
            window.open(data.thesisPath);
            window.location.reload();
        }*/
    });

    //监听查询按钮
    $("#search").click(function () {
        table.reload('table_thesis', {
            where: { thesisname: $('#input').val() }
        });
    });
});