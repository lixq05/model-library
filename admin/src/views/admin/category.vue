<template>
  <table id="simple-table" class="table  table-bordered table-hover">
        <thead>
        <tr>
          <th>ID</th>
          <th>型号</th>
          <th>大类</th>
          <th>类型</th>
          <th>模型id</th>
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
              <button class="btn btn-xs btn-success">
                <i class="ace-icon fa fa-check bigger-120"></i>
              </button>

              <button class="btn btn-xs btn-info">
                <i class="ace-icon fa fa-pencil bigger-120"></i>
              </button>

              <button class="btn btn-xs btn-danger">
                <i class="ace-icon fa fa-trash-o bigger-120"></i>
              </button>

              <button class="btn btn-xs btn-warning">
                <i class="ace-icon fa fa-flag bigger-120"></i>
              </button>
            </div>

            <div class="hidden-md hidden-lg">
              <div class="inline pos-rel">
                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                  <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                </button>

                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                  <li>
                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                    </a>
                  </li>

                  <li>
                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                    </a>
                  </li>

                  <li>
                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </td>
        </tr>


        </tbody>
      </table>
</template>
<script>
  export default {
    name: "category",
    data:function(){
        return{
          categorys:[],
        }
    },
    mounted: function() {
      let _this = this;
      _this.list();
    },
    methods: {
      list() {
        let _this = this;
        _this.$ajax.get('http://127.0.0.1:9000/business/admin/category/list').then((response)=>{
          console.log("查询类型列表结果：", response);
          _this.categorys = response.data;
        })
      }
    }
  }
</script>