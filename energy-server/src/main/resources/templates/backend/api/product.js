// 查询列表接口
const getProductPage = (params) => {
    return $axios({
        url: '/cn/product/page',
        method: 'get',
        params
    })
}

const queryQueryById = (id) => {
    return $axios({
        url: `/cn/product/${id}`,
        method: 'get'
    })
}

// 删除接口
const deleteDish = (ids) => {
    return $axios({
        url: '/cn/product',
        method: 'delete',
        params: {ids}
    })
}

// 修改接口
const editDish = (params) => {
    return $axios({
        url: '/cn/product',
        method: 'put',
        data: {...params}
    })
}

// 新增接口
const addDish = (params) => {
    return $axios({
        url: '/cn/product',
        method: 'post',
        data: {...params}
    })
}


// 获取菜品分类列表
const getScenarioList = (params) => {
    return $axios({
        url: '/cn/scenario/list',
        method: 'get',
        params
    })
}

