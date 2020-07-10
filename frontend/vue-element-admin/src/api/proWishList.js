import request from '../utils/request'
export function deletePro(params) {
  return request({
    url: '/deletePro',
    method: 'post',
    data: params
  })
}
export function getWishList(params) {
  return request({
    url: '/getWishList',
    method: 'post',
    data: params
  })
}
