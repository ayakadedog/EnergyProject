// 查询列表接口
const getScenarioPage = (params) => {
    return $axios({
        url: '/cn/scenario/page',
        method: 'get',
        params
    })
}

const queryQueryById = (id) => {
    return $axios({
        url: `/cn/scenario/${id}`,
        method: 'get'
    })
}

// 删除接口
const deleteDish = (ids) => {
    return $axios({
        url: '/cn/scenario',
        method: 'delete',
        params: {ids}
    })
}

// 修改接口
const editDish = (params) => {
    return $axios({
        url: '/cn/scenario',
        method: 'put',
        data: {...params}
    })
}

// 新增接口
const addDish = (params) => {
    return $axios({
        url: '/cn/scenario',
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

