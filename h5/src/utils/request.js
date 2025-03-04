import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router/index.js";

axios.defaults.headers['Content-Type'] = 'application/json;charset=UTF-8';

const service = axios.create({
    timeout: 10000,
})

//请求拦截器
service.interceptors.request.use();
service.interceptors.response.use(success =>{
    //获取服务端返回的状态码，如果服务端没有设置状态码，默认为200
    const code = success.data.status || 200;
    if (code === 200) {
        //说明请求成功
        if(success.data.message){
            ElMessage.success(success.data.message);
        }
        //返回服务端的JSON
        return success.data;
    }else {
        ElMessage.error(success.data.message);
        return Promise.reject(success.data.message);
    }
}, error => {
    if(error.response.status === 401) {
        //说明未登录
        router.replace('/');
    }
    //http状态码不是200，就会进入到这个回调中
    ElMessage.error(error);
    return Promise.reject(error);
});

export default service;