<template>
  <div id="mySpacePage">
    <p>正在跳转，请稍后。。。。。。</p>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'
import { useLoginUserStore } from '@/stores/useLoginUserStore.ts'
import { listSpaceVoByPageUsingPost } from '@/api/spaceController.ts'
import { message } from 'ant-design-vue'
import { onMounted } from 'vue'

const router = useRouter()
const loginUserStore = useLoginUserStore();

// 检查用户是否有个人空间
const checkUserSpace = async () => {
  const loginUser = loginUserStore.loginUser;
  if (!loginUser?.id) {
    router.replace('/user/login')
    return;
  }
  const res = await listSpaceVoByPageUsingPost({
    userId: loginUser.id,
    currentPage: 1,
    pageSize: 1
  })

  if (res.data.code === 0) {
    if (res.data.data?.records.length > 0) {
      const space = res.data.data.records[0];
      router.replace('/space/' + space.id);
    } else {
      router.replace('/add_space');
      message.warn('请先创建空间');
    }
  } else {
    message.error('加载我的空间失败，' + res.data.message);
  }
}

onMounted(() => {
  checkUserSpace();
})
</script>
