<template>
  <!--  <div class="app-container documentation-container">-->
  <!--    <a class="document-btn" target="_blank" href="https://panjiachen.github.io/vue-element-admin-site/">Documentation</a>-->
  <!--    <a class="document-btn" target="_blank" href="https://github.com/PanJiaChen/vue-element-admin/">Github Repository</a>-->
  <!--    <a class="document-btn" target="_blank" href="https://panjiachen.gitee.io/vue-element-admin-site/zh/">国内文档</a>-->
  <!--    <dropdown-menu class="document-btn" :items="articleList" title="系列文章" />-->
  <!--    <a class="document-btn" target="_blank" href="https://panjiachen.github.io/vue-element-admin-site/zh/job/">内推招聘</a>-->
  <!--  </div>-->
  <div>
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        prop="type"
        label="字典类型"
        width="180"
      >
      </el-table-column>
      <el-table-column
        prop="description"
        label="用途描述"
        width="180"
      >
      </el-table-column>
      <el-table-column
        prop="code"
        label="编码"
        width="50"
      >
      </el-table-column>
      <el-table-column
        prop="codevalue"
        label="编码值"
        width="80"
      >
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)"
          >编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-row>
      <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
    </el-row>
    <el-dialog title="新增数据字典" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="字典类型" :label-width="formLabelWidth">
          <el-input v-model="form.type" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用途描述" :label-width="formLabelWidth">
          <el-input v-model="form.descrip" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="编码" :label-width="formLabelWidth">
          <el-input v-model="form.code" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="编码值" :label-width="formLabelWidth">
          <el-input v-model="form.codevalue" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
// import DropdownMenu from '@/components/Share/DropdownMenu'

export default {
  name: 'Documentation',
  // components: { DropdownMenu },
  data() {
    return {
      // articleList: [
      //   { title: '基础篇', href: 'https://juejin.im/post/59097cd7a22b9d0065fb61d2' },
      //   { title: '登录权限篇', href: 'https://juejin.im/post/591aa14f570c35006961acac' },
      //   { title: '实战篇', href: 'https://juejin.im/post/593121aa0ce4630057f70d35' },
      //   { title: 'vue-admin-template 篇', href: 'https://juejin.im/post/595b4d776fb9a06bbe7dba56' },
      //   { title: 'v4.0 篇', href: 'https://juejin.im/post/5c92ff94f265da6128275a85' },
      //   { title: '自行封装 component', href: 'https://segmentfault.com/a/1190000009090836' },
      //   { title: '优雅的使用 icon', href: 'https://juejin.im/post/59bb864b5188257e7a427c09' },
      //   { title: 'webpack4（上）', href: 'https://juejin.im/post/59bb864b5188257e7a427c09' },
      //   { title: 'webpack4（下）', href: 'https://juejin.im/post/5b5d6d6f6fb9a04fea58aabc' }
      // ]

      tableData: [{
        type: 'sex',
        description: '性别',
        code: '1',
        codevalue: '男'
      }, {
        type: 'sex',
        description: '性别',
        code: '2',
        codevalue: '女'
      }],
      dialogFormVisible: false,
      form: {
        type: '',
        descrip: '',
        code: '',
        codevalue: ''
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
    }
  }
}
</script>

<style lang="scss" scoped>
.documentation-container {
  margin: 50px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;

  .document-btn {
    flex-shrink: 0;
    display: block;
    cursor: pointer;
    background: black;
    color: white;
    height: 60px;
    width: 200px;
    margin-bottom: 16px;
    line-height: 60px;
    font-size: 20px;
    text-align: center;
  }
}
</style>
