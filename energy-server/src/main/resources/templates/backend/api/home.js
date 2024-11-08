function getHomeList (params) {
  return $axios({
    url: '/cn/home/page',
    method: 'get',
    params
  })
}

function queryHomeById (id) {
  return $axios({
    url: `/cn//home/info/${id}`,
    method: 'get'
  })
}

// 修改接口
const editDish = (params) => {
  return $axios({
    url: '/cn/home',
    method: 'put',
    data: {...params}
  })
}