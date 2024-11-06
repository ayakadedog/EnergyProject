
const supportList = (params) => {
    return $axios({
        url: '',
        method: 'get',
        params
    })
}
const supportDetail = (id) => {
    return $axios({
        url: '',
        method: 'get',
        id
    })
}