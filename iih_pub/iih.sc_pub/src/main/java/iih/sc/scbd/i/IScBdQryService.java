package iih.sc.scbd.i;

import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 排班基础数据查询服务
 * 
 * @author yank
 *
 */
public interface IScBdQryService {
	/**
	 * 根据记录id获取日志
	 * 
	 * @param tableName 表名
	 * @param dataId 数据记录id
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	ScLogRecDO[] getLogList(String tableName, String dataId, FDate beginDate, FDate endDate)
			throws BizException;

	/**
	 * 根据父记录id获取日志
	 * 
	 * @param tableName 表名
	 * @param parentId 父记录id
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	ScLogRecDO[] getLogListByParentId(String tableName, String parentId, FDate beginDate,
			FDate endDate) throws BizException;
	/**
	 * 根据查询条件获取日志
	 * @param qryRootNodeDTO
	 * @param dataId
	 * @param parentId
	 * @param pg
	 * @return
	 */
    PagingRtnData<ScLogRecDO> getLogRecByQryCondition(QryRootNodeDTO qryRootNodeDTO,String dataId,PaginationInfo pg ) throws BizException;

	/**
	 * 获取渠道
	 * 
	 * @param chlTp 渠道类型编码
	 * @return 预约渠道
	 * @throws BizException
	 */
	SchedulechlDO[] getChlByTp(String chlTp) throws BizException;

	/**
	 * 获取渠道最大可预约日期
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期
	 * @throws BizException
	 * @author yank
	 */
	FDate getChlMaxAptDateBP(String chlId, String sctp) throws BizException;
	
	/**
	 * 获取渠道期间可预约日期段
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期集合 begin:开始日期 end:结束日期
	 * @throws BizException
	 */
	FMap getetChlAptTimeIntervalDate(String chlId, String sctp) throws BizException;

	/**
	 * 获取当前科室参数
	 *
	 * @param id_dept 科室id
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScdeptparamAggDO getCurrentDeptParam(String id_dept,String sd_sctp) throws BizException ;

	/**
	 * 获取科室参数
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	ScdeptparamAggDO[] getDeptParamList(String id_dept, String sd_sctp) throws BizException;

	/**
	 * 获取时间段内科室参数
	 * 
	 * @param d_b
	 * @param d_e
	 * @return
	 * @throws BizException
	 */
	ScDeptParamDO[] getDeptParam(String d_b, String d_e,String sd_sctp) throws BizException;

	/**
	 * 获取时间段内科室参数agg
	 * 
	 * @param d_b
	 * @param d_e
	 * @return
	 * @throws BizException
	 */
	public ScdeptparamAggDO[] getDeptParamAgg(String d_b, String d_e,String sd_sctp) throws BizException;

	/**
	 * 根据当前时间查询可用科室参数
	 * 
	 * @return
	 */
	public ScDeptParamDsDO[] getUsableDepParamDsDos(String depId,String sd_sctp) throws BizException;
	
	/**
	 * 根据当前时间查询可用科室参数
	 * 
	 * @return
	 */
	public DeptDO[] getDeptWithDeptParam(String sd_sctp,String depId) throws BizException;
	
	/**
	 * 根据查询条件查询ScBdSrvDTO
	 * 
	 * @param scBdSrvDto
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ScBdSrvDTO> getScBdSrvDtos(ScBdSrvDTO scBdSrvDto,PaginationInfo pg) throws BizException;
	
	/**
	 * 根据查询条件查询ScBdSrvDTO,排除掉IdSrv
	 * 
	 * @param scBdSrvDto
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ScBdSrvDTO> getScBdSrvDtosByIdSrv(ScBdSrvDTO scBdSrvDto,PaginationInfo pg) throws BizException;
	
	/**
	 * 医技互斥数据校验，不允许出现A1=A2 && B1=B2 和 不允许出现A1=B2 && B1=A2
	 * @param Id_scsrv_a
	 * @param Id_scsrv_b
	 * @return
	 * @throws BizException
	 */
	public FBoolean isExisMutexData(ScSrvExclDO scSrvExclDO) throws BizException;
	
	/**
	 * 获取服务标准价格
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public FMap getPriMdsrv(String id_srv) throws BizException;
	
	/**
	 * 查询医疗服务项目(sc_srv_rel)
	 * 
	 * @param scBdSrvDto
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ScBdSrvDTO> getSrvByIdScSrv(ScheduleSrvDO qryDO,PaginationInfo pg) throws BizException;
}
