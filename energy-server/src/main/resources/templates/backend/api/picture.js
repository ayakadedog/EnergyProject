function getPictureList (params) {
  return $axios({
    url: '/cn/picture/page',
    method: 'get',
    params
  })
}

function queryPictureById (id) {
  return $axios({
    url: `/cn/picture/info/${id}`,
    method: 'get'
  })
}

// 修改接口
const editDish = (params) => {
  return $axios({
    url: '/cn/picture',
    method: 'put',
    data: {...params}
  })
}