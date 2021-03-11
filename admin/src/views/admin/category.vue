<template>
  <div>
    <p>
      <button v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        新增
      </button>
      &nbsp;
      <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>
    <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>
    <table id="simple-table" class="table  table-bordered table-hover">
          <thead>
          <tr>
            <th>ID</th>
            <th>型号</th>
            <th>大类</th>
            <th>类型</th>
            <th>模型库id</th>
            <th>操作</th>
          </tr>
          </thead>

          <tbody>
          <tr v-for="c in categorys">
            <td>{{c.id}}</td>
            <td>{{c.name}}</td>
            <td>{{c.dalei}}</td>
            <td>{{c.leibie}}</td>
            <td>{{c.modelId}}</td>

            <td>
              <div class="hidden-sm hidden-xs btn-group">
                <button v-on:click="edit(c)" class="btn btn-xs btn-info">
                  <i class="ace-icon fa fa-pencil bigger-120"></i>
                </button>

                <button v-on:click="del(c.id)" class="btn btn-xs btn-danger">
                  <i class="ace-icon fa fa-trash-o bigger-120"></i>
                </button>
              </div>
            </td>
          </tr>
          </tbody>
        </table>
    <!--模态框-->
    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">表单</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">型号</label>
                <div class="col-sm-10">
                  <input v-model="category.name" class="form-control" placeholder="名称">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">模型库ID</label>
                <div class="col-sm-10">
                  <input v-model="category.modelId" class="form-control" placeholder="模型库ID">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
  </div>
</template>
<script>
  import Pagination from "../../components/pagination";
  export default {
    components: {Pagination},
    name: "category",
    data: function () {
      return {
        categorys: [],
        category: {},
      }
    },
    mounted: function () {
      let _this = this;
      _this.$refs.pagination.size = 5;
      _this.list(1);
    },
    methods: {
      add() {
        let _this = this;
        _this.category = {};
        $("#form-modal").modal("show");
      },
      edit(category) {
        let _this = this;
        _this.category = $.extend({}, category);
        $("#form-modal").modal("show");
      },
      list(page) {
        Loading.show();
        let _this = this;
        _this.$ajax.post('http://127.0.0.1:9000/business/admin/category/list', {
          page: page,
          size: _this.$refs.pagination.size
        }).then((response) => {
          Loading.hide();
          let resp = response.data;
          _this.categorys = resp.content.list;
          _this.$refs.pagination.render(page, resp.content.total);
        })
      },
      save() {
        let _this = this;
        // 保存校验
        if (!Validator.require(_this.category.name, "名称")
          || !Validator.require(_this.category.modelId, "模型库ID")
          || !Validator.length(_this.category.modelId, "模型库ID", 1, 8)) {
          return;
        }
        Loading.show();
        _this.$ajax.post('http://127.0.0.1:9000/business/admin/category/save', _this.category).then((response) => {
          Loading.hide();
          console.log("保存型号列表结果：", response);
          let resp = response.data;
          if (resp.success) {
            $("#form-modal").modal("hide");
            _this.list(1);
            Toast.success("保存成功！");
          }
        })
      },
      del(id) {
        let _this = this;
        Confirm.show("删除型号后不可恢复，确认删除？", function () {
          Loading.show();
          _this.$ajax.delete('http://127.0.0.1:9000/business/admin/category/delete/' + id).then((response)=>{
            Loading.hide();
            console.log("删除型号列表结果：", response);
            let resp = response.data;
            if (resp.success) {
              _this.list(1);
              Toast.success("删除成功！");
            }
          })
        });
      }
    }
  }
</script>