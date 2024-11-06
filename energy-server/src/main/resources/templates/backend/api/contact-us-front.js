const sendMessage = (data) => {
    return $axios({
        url: '/cn/contact-us/sendMessage',
        method: 'post',
        data
    })
}
const getCompany = (params) => {
    return $axios({
        url: '',
        method: 'get',
        params
    })
}