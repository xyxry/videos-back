import request from './request'

/*
* 本地文件查询接口
* @params
* path：路径
*/
export const queryLocalHostFile = (params) => request.get('/file/queryLocalHostFile', params)

// /*
// * 本地文件查询接口
// * @params
// * username：用户名
// * password：密码
// */
// export const loginApi = (params) => request.post('/file/queryLocalHostFile', params)
/*
// *集群组件流监控查询
// *@params
// *taskName: 任务名称
// *state: 任务类型 0：全部任务 1：进行中任务 2：异常任务
// *pageIdx: 当前页码
// *rowCnt: 一页显示数据行数
// */
// export const viewMonitorSelectApi = (params) => request.get('/api/mainpage/monitor/select', params)
/***********************************************************************************************************/
/****************************************************首页***************************************************/
/***********************************************************************************************************/
/*
*集群监控运行时总览
*/
export const getViewInfoRuntimeApi = () => request.get('/api/mainpage/runtime')

/*
*集群组件流监控查询
*@params
*taskName: 任务名称
*state: 任务类型 0：全部任务 1：进行中任务 2：异常任务
*pageIdx: 当前页码
*rowCnt: 一页显示数据行数
*/
