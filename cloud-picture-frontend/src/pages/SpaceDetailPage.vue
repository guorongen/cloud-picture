<template>
  <div id="spaceDetailPage">
    <a-flex justify="space-between">
      <h2>{{ space.spaceName }}（私有空间）</h2>
      <a-space size="middle">
        <a-button type="primary" :href="'/add_picture?spaceId=' + id" target="_blank">+ 创建图片</a-button>
        <a-tooltip :title="'占用空间' + formatSize(space.totalSize) + '/' + formatSize(space.maxSize)">
          <a-progress type="circle" :size="42" :percent="((space.totalSize * 100) / space.maxSize).toFixed(1)" />
        </a-tooltip>
      </a-space>
    </a-flex>
    <div style="margin-bottom: 16px" />
    <!--  搜索表单  -->
    <PictureSearchForm :onSearch="onSearch" />
    <div style="margin-bottom: 16px" />
    <a-form-item label="按颜色搜索">
      <color-picker format="hex" @pureColorChange="onColorChange" />
    </a-form-item>
    <PictureList :dataList="dataList" :loading="loading" :show-op="true" :onReload="fetchData" />
    <a-pagination
      style="text-align: right"
      v-model:current="searchParams.currentPage"
      v-model:pageSize="searchParams.pageSize"
      :total="total"
      @change="onPageChange"
    />
  </div>
</template>

<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import { getSpaceVoByIdUsingGet } from '@/api/spaceController.ts'
import { message } from 'ant-design-vue'
import { listPictureVoByPageUsingPost, searchPictureByColorUsingPost } from '@/api/pictureController.ts'
import { formatSize } from '@/utils'
import PictureList from '@/components/PictureList.vue'
import PictureSearchForm from '@/components/PictureSearchForm.vue'
import { ColorPicker } from 'vue3-colorpicker'
import "vue3-colorpicker/style.css";

interface Props {
  id: string | number
}

const props = defineProps<Props>()
const space = ref<API.SpaceVO>({})

const fetchSpaceDetail = async () => {
  try {
    const res = await getSpaceVoByIdUsingGet({
      id: props.id,
    })
    if (res.data.code === 0 && res.data.data) {
      space.value = res.data.data
    } else {
      message.error('获取空间详情失败，' + res.data.message)
    }
  } catch (e: any) {
    message.error('获取空间详情失败，' + e.message)
  }
}

onMounted(() => {
  fetchSpaceDetail()
})

// -------- 获取图片列表 -------
const dataList = ref<API.PictureVO[]>([])
const total = ref(0)
const loading = ref<boolean>(true)

const searchParams = ref<API.PictureQueryRequest>({
  currentPage: 1,
  pageSize: 10,
  sortField: 'createTime',
  sortOrder: 'descend',
})

const fetchData = async () => {
  loading.value = true
  // 转换搜索参数
  const params = {
    spaceId: props.id,
    ...searchParams.value,
  }
  const res = await listPictureVoByPageUsingPost(params)
  if (res.data.code === 0 && res.data.data) {
    dataList.value = res.data.data.records ?? []
    total.value = res.data.data.total ?? 0
  } else {
    message.error('获取数据失败，' + res.data.message)
  }
  loading.value = false
}

onMounted(() => {
  fetchData()
})

const onPageChange = (page: number, pageSize: number) => {
  searchParams.value.currentPage = page
  searchParams.value.pageSize = pageSize
  fetchData()
}

const onSearch = (newSearchParams: API.PictureQueryRequest) => {
  searchParams.value = {
    ...searchParams.value,
    ...newSearchParams,
    currentPage: 1,
  }
  fetchData()
}

const onColorChange = async (color: string) => {
  loading.value = true;
  const res = await searchPictureByColorUsingPost({
    picColor: color,
    spaceId: props.id
  })
  if (res.data.code === 0 && res.data.data) {
    dataList.value = res.data.data ?? [];
    total.value = res.data.data.length;
  } else {
    message.error("获取数据失败，" + res.data.message);
  }
  loading.value = false;
}
</script>

<style scoped>
#spaceDetailPage {
  margin-bottom: 16px;
}
</style>
