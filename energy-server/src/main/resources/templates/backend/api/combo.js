// 查询列表数据
const getCSupportPage = (params) => {
  return $axios({
    url: '/cn/classicBlog/page',
    method: 'get',
    params
  })
}

const getFrontCSupportPage = (params) => {
  return $axios({
    url: '/cn/classicBlog/frontpage',
    method: 'get',
    params
  })
}
// 删除数据接口
const deleteServices = (ids) => {
  return $axios({
    url: '/cn/classicBlog/deleteServices',
    method: 'delete',
    params: { ids }
  })
}

// 修改数据接口
const editSetmeal = (params) => {
  return $axios({
    url: '/setmeal',
    method: 'put',
    data: { ...params }
  })
}

// 新增数据接口
const addSetmeal = (params) => {
  return $axios({
    url: '/setmeal',
    method: 'post',
    data: { ...params }
  })
}

// 查询详情接口
const getDetailById = (id) => {
  return $axios({
    url: `cn/classicBlog/getServiceDetail/${id}`,
    method: 'get'
  })
}

// 批量起售禁售
const setmealStatusByStatus = (params) => {
  return $axios({
    url: `/setmeal/status/${params.status}`,
    method: 'post',
    params: { ids: params.ids }
  })
}
