// eslint-disable-next-line no-unused-vars
import request from '../utils/request'
export function getBVO(params) {
  return request({
    url: '/getBVO',
    method: 'post',
    data: params
  })
}

export function editBVO(params) {
  return request({
    url: '/editBVO',
    method: 'post',
    data: params
  })
}
