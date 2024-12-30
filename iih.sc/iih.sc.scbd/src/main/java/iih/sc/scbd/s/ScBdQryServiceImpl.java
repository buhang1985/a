package iih.sc.scbd.s;

import iih.sc.scbd.bdsrv.s.bp.GetScBdSrvListBp;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.s.bp.GetChlAptTimeIntervalDateBP;
import iih.sc.scbd.s.bp.GetChlByTpBP;
import iih.sc.scbd.s.bp.GetChlMaxAptDateBP;
import iih.sc.scbd.s.bp.GetDeptParamAggBP;
import iih.sc.scbd.s.bp.GetDeptParamBP;
import iih.sc.scbd.s.bp.GetDeptParamByDateBP;
import iih.sc.scbd.s.bp.GetDeptParamsBP;
import iih.sc.scbd.s.bp.GetDeptWithDeptParamBP;
import iih.sc.scbd.s.bp.GetLogListBP;
import iih.sc.scbd.s.bp.GetLogListByParentIdBP;
import iih.sc.scbd.s.bp.GetLogRecByQryConditionBP;
import iih.sc.scbd.s.bp.GetPriMdsrvBP;
import iih.sc.scbd.s.bp.GetScBdSrvDtosByIdSrvBP;
import iih.sc.scbd.s.bp.GetSrvByIdScSrvBP;
import iih.sc.scbd.s.bp.GetUsableDeptParamDsBP;
import iih.sc.scbd.s.bp.IsExisMutexDataBP;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
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
@Service(serviceInterfaces = { IScBdQryService.class }, binding = Binding.JSONRPC)
public class ScBdQryServiceImpl implements IScBdQryService {
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
	public ScLogRecDO[] getLogList(String tableName, String dataId, FDate beginDate, FDate endDate)
			throws BizException {
		GetLogListBP getlogBP = new GetLogListBP();
		return getlogBP.exec(tableName, dataId, beginDate, endDate);
	}

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
	@Override
	public ScLogRecDO[] getLogListByParentId(String tableName, String parentId, FDate beginDate,
			FDate endDate) throws BizException {
		GetLogListByParentIdBP getBP = new GetLogListByParentIdBP();
		return getBP.exec(tableName, parentId, beginDate, endDate);
	}
	
	/**
	 * 根据查询条件获取日志
	 * @param qryRootNodeDTO
	 * @param dataId
	 * @param parentId
	 * @param pg
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<ScLogRecDO> getLogRecByQryCondition(QryRootNodeDTO qryRootNodeDTO,String dataId,PaginationInfo pg ) throws BizException{
		GetLogRecByQryConditionBP getLogBp = new GetLogRecByQryConditionBP();
		return getLogBp.exec(qryRootNodeDTO, dataId,pg);
	}

	/**
	 * 获取渠道
	 * 
	 * @param chlTp 渠道类型编码
	 * @return 预约渠道
	 * @throws BizException
	 */
	@Override
	public SchedulechlDO[] getChlByTp(String chlTp) throws BizException {
		GetChlByTpBP getChlBP = new GetChlByTpBP();
		return getChlBP.exec(chlTp);
	}

	/**
	 * 获取渠道最大可预约日期
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public FDate getChlMaxAptDateBP(String chlId, String sctp) throws BizException {
		GetChlMaxAptDateBP getMaxDateBP = new GetChlMaxAptDateBP();
		return getMaxDateBP.exec(chlId, sctp);
	}
	
	/**
	 * 获取渠道期间可预约日期段
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期集合 begin:开始日期 end:结束日期
	 * @throws BizException
	 */
	@Override
	public FMap getetChlAptTimeIntervalDate(String chlId, String sctp) throws BizException {
		GetChlAptTimeIntervalDateBP getTimeIntervalBP = new GetChlAptTimeIntervalDateBP();
		return getTimeIntervalBP.exec(chlId, sctp);
	}

	/**
	 * 获取科室参数
	 *
	 * @param id_dept 科室id
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public ScdeptparamAggDO getCurrentDeptParam(String id_dept,String sd_sctp) throws BizException {
		return new GetDeptParamByDateBP().exec(id_dept, null,sd_sctp);
	}

	/**
	 * 获取科室参数
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public ScdeptparamAggDO[] getDeptParamList(String id_dept, String sd_sctp) throws BizException {
		return new GetDeptParamsBP().exec(id_dept, sd_sctp);
	}

	/**
	 * 获取时间段内科室参数
	 * 
	 * @param d_b
	 * @param d_e
	 * @return
	 * @throws BizException
	 */
	public ScDeptParamDO[] getDeptParam(String d_b, String d_e,String sd_sctp) throws BizException {
		GetDeptParamBP getParamBp = new GetDeptParamBP();
		return getParamBp.exec(d_b, d_e, sd_sctp);
	}

	/**
	 * 获取时间段内科室参数agg
	 * 
	 * @param d_b
	 * @param d_e
	 * @return
	 * @throws BizException
	 */
	public ScdeptparamAggDO[] getDeptParamAgg(String d_b, String d_e,String sd_sctp) throws BizException {
		GetDeptParamAggBP getParamBp = new GetDeptParamAggBP();
		return getParamBp.exec(d_b, d_e, sd_sctp);
	}

	/**
	 * 根据当前时间查询可用科室参数
	 */
	@Override
	public ScDeptParamDsDO[] getUsableDepParamDsDos(String depId,String sd_sctp) throws BizException {
		GetUsableDeptParamDsBP usableBp = new GetUsableDeptParamDsBP();
		return usableBp.exec(depId,sd_sctp);
	}
	
	
	/**
	 * 查找sctpSd对应的有科室参数的部门
	 * 
	 * @return
	 */
	@Override
	public DeptDO[] getDeptWithDeptParam(String sctpSd,String depId) throws BizException{
		GetDeptWithDeptParamBP bp = new GetDeptWithDeptParamBP();
		return bp.exec(sctpSd,depId);
	}

	/**
	 * 根据查询条件查询ScBdSrvDTO
	 * 
	 * @param scBdSrvDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<ScBdSrvDTO> getScBdSrvDtos(ScBdSrvDTO scBdSrvDTO, PaginationInfo pg) throws BizException {
		GetScBdSrvListBp bp = new GetScBdSrvListBp();
		return bp.exec(scBdSrvDTO, pg);
	}
	
	/**
	 * 根据查询条件查询ScBdSrvDTO,排除掉IdSrv
	 * 
	 * @param scBdSrvDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<ScBdSrvDTO> getScBdSrvDtosByIdSrv(ScBdSrvDTO scBdSrvDTO, PaginationInfo pg) throws BizException {
		GetScBdSrvDtosByIdSrvBP bp = new GetScBdSrvDtosByIdSrvBP();
		return bp.exec(scBdSrvDTO, pg);
	}
	/**
     * 医技互斥数据校验，不允许出现A1=A2 && B1=B2 和 不允许出现A1=B2 && B1=A2
     */
	@Override
	public FBoolean isExisMutexData(ScSrvExclDO scSrvExclDO) throws BizException {
		IsExisMutexDataBP bp = new IsExisMutexDataBP();
		return bp.exec(scSrvExclDO);
	}
	/**
	 * 获取服务标准价格
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getPriMdsrv(String id_srv) throws BizException{
		GetPriMdsrvBP getbp = new GetPriMdsrvBP();
		return getbp.exec(id_srv);
	}
	/**
	 * 查询医疗服务项目(sc_srv_rel)
	 */
	@Override
	public PagingRtnData<ScBdSrvDTO> getSrvByIdScSrv(ScheduleSrvDO qryDO, PaginationInfo pg) throws BizException {
		GetSrvByIdScSrvBP bp = new GetSrvByIdScSrvBP();
		return bp.exec(qryDO, pg);
	}
}
