<template>
  <div class="components-container">
    <el-container>
      <el-aside>
        <img :src="require('../../assets/img/A.webp')" style="height: 300px ;weight: 300px">
      </el-aside>
      <el-main>
        <p class="span-name">{{ title }}</p>
        <p class="span-price">{{ price }}</p>
        <p class="span-detail">{{ sku }}</p>
        <p class="span-detail">{{ brand }}</p>
        <el-row>
          <el-button type="warning" @click="dropship">Dropship Now</el-button>
          <el-button type="success" @click="addwish">Add to Wish List</el-button>
        </el-row>
        <el-dialog title="选择要添加的店铺" :visible.sync="dialogFormVisible">
          <el-cascader
            v-model="storeValue"
            :options="storeOptions"
            @change="handleChange"
            :show-all-levels="false"
            :props="props"
          />
          <span slot="footer" class="dialog-footer">
            <el-button type="warning" @click="cancelDia">取 消</el-button>
            <el-button type="success" @click="pushtoStore">确 定</el-button>
          </span>
        </el-dialog>
      </el-main>
    </el-container>
    <el-tabs type="card" @tab-click="handleClick">
      <el-tab-pane label="Description" name="Description">你没玩把戏，你只是在打破陈规。和adidas Predator一起，就是摆明了要在比赛中“得势不饶人”。这款无系带足球鞋，采用针织织物鞋面，舒适贴合。缀橡胶棱，助你球路“神鬼莫测”，外底分段，助你轻松奔跑。穿上它，驰骋绿茵。</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import { addWish, getebayList, pushToStore } from '../../api/proDetail'
import { getDetail } from '../../api/proDetail'
import { getamaList } from '../../api/proDetail'

export default {
  name: 'ProDetail',
  data() {
    return {
      activeName: 'Ama',
      imgSrc: '',
      title: '',
      price: '',
      brand: '',
      sku: '',
      description: '',
      dialogFormVisible: false,
      storeValue: [],
      storeOptions: [{
        value: '1',
        label: 'Amazon',
        children: [{ value: '1',
          label: 'StoreA' }, { value: '2',
          label: 'StoreB' }] }, {
        value: '2',
        label: 'Ebay',
        children: []
      }],
      props: { multiple: true }
    }
  },
  created() {
    this.getdetail()
  },
  methods: {
    dropship() {
      this.dialogFormVisible = true
      getamaList({
        dsr_ID: '1'
      }).then(res => {
        res.data.forEach(item => {
          this.storeOptions[0].children.push({ value: item.strID, label: item.strname })
        })
      })
      getebayList({
        dsr_ID: '1'
      }).then(res => {
        res.data.forEach(item => {
          this.storeOptions[1].children.push({ value: item.strID, label: item.strname })
        })
      })
    },
    pushtoStore() {
      console.log(this.storeValue)
      pushToStore({
        str_ID: this.storeValue,
        pro_Name: '足球鞋1'
      }).then(res => {
        this.$message({
          showClose: true,
          type: 'success',
          message: '商品添加成功'
        })
      })
    },
    addwish() {
      addWish({
        pro_Name: 'PREDATOR MUTATOR 20+',
        dsr_ID: '1'
      }).then(res => {
        this.$message({
          showClose: true,
          type: 'success',
          message: '添加成功'
        })
      })
    },
    getdetail() {
      getDetail({
        pro_Name: ''
      }).then(res => {
        this.title = res.data.title
        this.price = res.data.price
        this.brand = res.data.brand
        this.imgSrc = res.data.imgSrc
        this.sku = res.data.sku
        this.description = res.data.description
        this.$message({
          showClose: true,
          type: 'success',
          message: '导入成功'
        })
      })
    },
    handleClick(tab, event) {
      console.log(tab, event)
    },
    cancelDia() {
      this.dialogFormVisible = false
      this.storeValue = []
    },
    handleChange() {
      // console.log(this.storeValue)
    }
  }
}
</script>

<style scoped>
  .span-name{
    font-size: 20px;
    font-weight: bold;
  }
  .span-price{
    font-size: 17px;
    color: red;
  }
  .span-detail{
    font-size: 17px;
    font-weight: bolder;
  }
</style>
