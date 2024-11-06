
const supportList = (params) => {
    return $axios({
        url: '/contact-us/sendMessage',
        method: 'get',
        params
    })
}
const supportDetail = (id) => {
    return $axios({
        url: '/contact-us/sendMessage',
        method: 'get',
        id
    })
}