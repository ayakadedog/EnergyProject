// 查询列表页接口
const getOrderDetailPage = (params) => {
  return $axios({
    url: '/cn/contact-us/page',
    method: 'get',
    params
  })
}

const deleteById = (id) => {
  return $axios({
    url: `/cn/contact-us/orderDetail/${id}`,
    method: 'delete',
    id
  })
}

// 查看接口
const queryOrderDetailById = (id) => {
  return $axios({
    url: `cn/orderDetail/${id}`,
    method: 'get'
  })
}

// 取消，派送，完成接口
const editOrderDetail = (params) => {
  return $axios({
    url: 'cn/order',
    method: 'put',
    data: { ...params }
  })
}
