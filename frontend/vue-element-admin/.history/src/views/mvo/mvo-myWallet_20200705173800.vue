<template>
  <div class="pageContent">
    <div class="pageHeader" style="padding: 15px">
      
      <h1 style="color: #2679b5;font-size: 24px;font-weight: normal margin:15px">
        品牌商
        <small style="font-size: 14px; color: grey">
          <font-awesome-icon :icon="['fas','angle-double-right']" size="2px" />
          钱包账号注册</small>
      </h1>
    </div>
    <el-divider content-position="left" id="divider"></el-divider>
    <el-form
      :model="ruleForm"
      :rules="rules"
      :size="small"
      ref="ruleForm"
      label-width="150px"
      class="demo-ruleForm"
    >
      <el-form-item prop="id">
        <span slot="label">
          账号
        </span>
        <el-input class="formInput" v-model="ruleForm.id"></el-input>
      </el-form-item>
      <el-form-item prop="mail">
        <span slot="label">
         邮箱
        </span>
        <el-input class="formInput" v-model="ruleForm.mail"></el-input>
      </el-form-item>
    
      <el-form-item prop="password">
        <span slot="label">
          密码
        </span>
        <el-input class="formInput" v-model="ruleForm.gmcType"></el-input>
      </el-form-item>
      <el-form-item>
          <div style="margin: 50%">
        <el-button type="primary" @click="register('ruleForm')">注册</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
          </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        
      },
      rules: {
        
      }
    };
  },
  methods:{
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
            this.$router.push({path: '/mvo/myInfo-edit'})
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
  }
};
</script>

<style>
.demo-ruleForm {
  display: block;
  font-size: 14px;
  padding-top: 8px;
  padding-left: 20px;
  padding-right: 20px;
  text-size-adjust: 100%;
  margin: 5%;
  margin-top: 15px;
  margin-left: 15%;
}
.formInput {
  /* margin-top: 14px;
  margin-left: 14px;
  height: 36px; */
  width: 204px;
} 
.el-form-item__error {
  margin-left: 14px;
  position: relative;
}
#divider {
  margin: 0px;
}
</style>