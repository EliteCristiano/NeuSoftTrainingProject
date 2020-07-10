import request from '../utils/request'
export function searchawaPay(params) {
  return request({
    url: '/searchawaPay',
    method: 'post',
    data: params
  })
}
export function getSha(params) {
  return request({
    url: '/getSha',
    method: 'post',
    data: params
  })
}
export function searchawaShip(params) {
  return request({
    url: '/searchawaShip',
    method: 'post',
    data: params
  })
}
export function searchShip(params) {
  return request({
    url: '/searchShip',
    method: 'post',
    data: params
  })
}
export function searchComplete(params) {
  return request({
    url: '/searchComplete',
    method: 'post',
    data: params
  })
}
export function searchCancel(params) {
  return request({
    url: '/searchCancel',
    method: 'post',
    data: params
  })
}
export function getOrderDetail(params) {
  return request({
    url: '/getOrderDetail',
    method: 'post',
    data: params
  })
}
export function PayOrder(params) {
  return request({
    url: '/PayOrder',
    method: 'post',
    data: params
  })
}
export function getShipDetail(params) {
  return request({
    url: '/getShipDetail',
    method: 'post',
    data: params
  })
}
