<template>
  <div id="vipExchangePage">
    <h2 style="margin-bottom: 16px">会员码兑换</h2>
    <a-form namr="formData" layout="vertical" :model="formData" @finish="handleSubmit">
      <a-form-item name="vipCode" label="兑换码">
        <a-input
          v-model:value="formData.vipCode"
          placeholder="请输入会员兑换码"
          allow-clear
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 100%" :loading="loading">
          兑换
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { message } from 'ant-design-vue'
import { exchangeVipUsingPost } from '@/api/userController.ts'

const formData = reactive<API.VipExchangeRequest>({
  vipCode: ''
})

const loading = ref(false)
const router = useRouter()

const handleSubmit = async () => {
  if (!formData.vipCode) {
    message.error('请输入兑换码')
    return;
  }

  loading.value = true;

  try {
    const res = await exchangeVipUsingPost({
      vipCode: formData.vipCode,
    })

    if (res.data.code === 0 && res.data.data) {
      message.success('兑换成功')
      router.push({
        path: '/'
      })
    } else {
      message.error('兑换失败：', res.data.message)
    }
  } catch (error) {
    message.error('兑换失败，请稍后重试')
  } finally {
    loading.value = false;
  }
}
</script>

<style>
#vipExchangePage {
  max-width: 720px;
  margin: 0 auto;
}
</style>
