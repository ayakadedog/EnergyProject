const sendMessage = (data) => {
    return $axios({
        url: '/contact-us/sendMessage',
        method: 'post',
        data
    })
}
const getCompany = (params) => {
    return $axios({
        url: '/contact-us/sendMessage',
        method: 'get',
        params
    })
}