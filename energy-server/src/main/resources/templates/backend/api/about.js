function getAboutList (params) {
  return $axios({
    url: '/cn/about/page',
    method: 'get',
    params
  })
}

function queryAboutById (id) {
  return $axios({
    url: `/cn//about/info/${id}`,
    method: 'get'
  })
}

// 修改接口
const editDish = (params) => {
  return $axios({
    url: '/cn/about',
    method: 'put',
    data: {...params}
  })
}