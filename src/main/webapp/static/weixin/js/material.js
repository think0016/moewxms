  createtable('text', $("#table_text")); //文本素材
  createtable('image', $("#table_image")); //图片素材
  createtable('voice', $("#table_voice")); //语音素材
  createtable('video', $("#table_video")); //视频素材
  function createtable(type, obj) {
    var url = actionurl + '/material/getmlist';
    if (type == 'text') {
      texttable = obj.DataTable({
        "ajax": {
          "url": url,
          //默认为data,这里定义为空，则只需要传不带属性的数据
          "data": {
            'type': type
          },
          "dataSrc": ""
        },
        "pageLength": 2,
        "paging": false,
        "info": false,
        "lengthChange": false,
        "searching": false,
        "ordering": false,
        "retrieve": true,
        "autoWidth": false,
        "columnDefs": [{
          "targets": -1,
          "data": null,
          "defaultContent": "<button type=\"button\" class=\"btn btn-info btn-xs updatebtn\">修改</button>&nbsp;<button type=\"button\" class=\"btn btn-danger btn-xs deletebtn\">删除</button>"
        }],
        "language": {
          "lengthMenu": "每页 _MENU_ 条记录",
          "zeroRecords": "无素材记录",
          "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)",
          "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
          }
        }
      });
    } else if (type == 'image') {
      imagetable = obj.DataTable({
        "ajax": {
          "url": url,
          //默认为data,这里定义为空，则只需要传不带属性的数据
          "data": {
            'type': type
          },
          "dataSrc": ""
        },
        "pageLength": 2,
        "paging": false,
        "info": false,
        "lengthChange": false,
        "searching": false,
        "ordering": false,
        "retrieve": true,
        "autoWidth": false,
        "columnDefs": [{
          "targets": 1,
          "render": function(data, type, row) {
            return "<img src=\"" + rooturl + "/upload/weixin/" + data + "\" style=\"width: 180px;height: 140px;\">";
          }
        }, {
          "targets": 3,
          "render": function(data, type, row) {
            return "<button type=\"button\" class=\"btn btn-danger btn-xs deletebtn\" onclick=\"deletematerial('image'," + data + ");\">删除</button>";
          }
        }],
        "language": {
          "lengthMenu": "每页 _MENU_ 条记录",
          "zeroRecords": "无素材记录",
          "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)",
          "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
          }
        }
      });
    } else if (type == 'voice') {
      voicetable = obj.DataTable({
        "ajax": {
          "url": url,
          //默认为data,这里定义为空，则只需要传不带属性的数据
          "data": {
            'type': type
          },
          "dataSrc": ""
        },
        "pageLength": 2,
        "paging": false,
        "info": false,
        "lengthChange": false,
        "searching": false,
        "ordering": false,
        "retrieve": true,
        "autoWidth": false,
        // "columnDefs": [ 
        // {
        //     "targets": 1,
        //     "render":function(data, type, row) {
        //         return "<img src=\"" + rooturl + "/upload/weixin/" + data + "\" style=\"width: 180px;height: 140px;\">";
        //     }
        // },
        // {
        //     "targets": 3,
        //     "render":function(data, type, row) {
        //         return "<button type=\"button\" class=\"btn btn-danger btn-xs deletebtn\" onclick=\"deletematerial('image'," + data +");\">删除</button>";
        //     }
        // }],
        "language": {
          "lengthMenu": "每页 _MENU_ 条记录",
          "zeroRecords": "无素材记录",
          "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)",
          "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
          }
        }
      });
    } else if (type == 'video') {
      videotable = obj.DataTable({
        "ajax": {
          "url": url,
          //默认为data,这里定义为空，则只需要传不带属性的数据
          "data": {
            'type': type
          },
          "dataSrc": ""
        },
        "pageLength": 2,
        "paging": false,
        "info": false,
        "lengthChange": false,
        "searching": false,
        "ordering": false,
        "retrieve": true,
        "autoWidth": false,
        // "columnDefs": [ 
        // {
        //     "targets": 1,
        //     "render":function(data, type, row) {
        //         return "<img src=\"" + rooturl + "/upload/weixin/" + data + "\" style=\"width: 180px;height: 140px;\">";
        //     }
        // },
        // {
        //     "targets": 3,
        //     "render":function(data, type, row) {
        //         return "<button type=\"button\" class=\"btn btn-danger btn-xs deletebtn\" onclick=\"deletematerial('image'," + data +");\">删除</button>";
        //     }
        // }],
        "language": {
          "lengthMenu": "每页 _MENU_ 条记录",
          "zeroRecords": "无素材记录",
          "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)",
          "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
          }
        }
      });
    }
  }

  jQuery('#table_text tbody').on("click", ".updatebtn", function() {
    var data = texttable.row($(this).parents('tr')).data();
    var id = data[3];
    var url = actionurl + '/material/textform/' + id;
    window.location.href = url;
  });

  jQuery('#table_text tbody').on("click", ".deletebtn", function() {
    var data = texttable.row($(this).parents('tr')).data();
    var id = data[3];
    var url = actionurl + '/material/deletetextmaterial/';
    jQuery.post(url, {
      "id": id
    }, function(data, textStatus, xhr) {
      //optional stuff to do after success
      if (data == '1') {
        Alert("删除成功！", function() {
          window.location.href = actionurl + "/material/list/text";
        });
      } else {
        Alert("删除失败！");
      }
    });
  });

  function deletematerial(type, id) {
    if (type == 'image') {
      var url = actionurl + '/material/deleteimagematerial/';
      jQuery.post(url, {
        "id": id
      }, function(data, textStatus, xhr) {
        //optional stuff to do after success
        var obj = jQuery.parseJSON(data);
        if (obj.status == '1') {
          Alert("删除成功！", function() {
            window.location.href = actionurl + "/material/list/image";
          });
        } else {
          Alert("删除失败！" + obj.msg);
        }
      });
    }
  };

  function updatematerial(type, id) {
    if (type == 'image') {
      var url = actionurl + '/material/imageform/' + id;
      window.location.href = url;
    }
  };