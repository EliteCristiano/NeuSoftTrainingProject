import request from '../utils/request'
export function getProducts(params) {
  return request({
    url: '/getProducts',
    method: 'post',
    data: params
  })
}

