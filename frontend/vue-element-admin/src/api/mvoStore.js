import request from '../utils/request'
export function getAmaList(params) {
  return request({
    url: '/getAmaList',
    method: 'post',
    data: params
  })
}
export function getEbayList(params) {
  return request({
    url: '/getEbayList',
    method: 'post',
    data: params
  })
}
export function saveStore(params) {
  return request({
    url: '/saveStore',
    method: 'post',
    data: params
  })
}
