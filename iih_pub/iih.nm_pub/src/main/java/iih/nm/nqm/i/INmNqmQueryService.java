package iih.nm.nqm.i;

import iih.nm.nhr.nmpsndoc.d.NmNurDO;
import iih.nm.nqm.dto.nmnqmchkdto.d.NmnqmchkDTO;
import iih.nm.nqm.dto.nmnqmwdkpida.d.NqmWdkEnDTO;
import iih.nm.nqm.dto.nqmchktable.d.QcTbDTO;
import iih.nm.nqm.dto.qcgrptask.d.QcGrpTaskDTO;
import iih.nm.nqm.nmnqmcs.d.NmNqmCsDO;
import iih.nm.nqm.nmnqmkpi.d.NmNqmKpiDO;
import iih.nm.nqm.nmnqmnightround.d.NmNqmNightRoundDO;
import iih.nm.nqm.nmnqmtask.d.NmNqmTaskDO;
import iih.nm.nqm.nqmchk.d.NmNqmChkItmDO;
import iih.nm.nqm.nqmchk.d.NqmChkDO;
import iih.nm.nqm.nqmchkissue.d.NmNqmChkIssueDO;
import iih.nm.nqm.nqmcsstytmpl.d.NqmCsStyTmplDO;
import iih.nm.nqm.nqmimprovl.d.NqmImprovDO;
import iih.nm.nqm.nqmimprovl.d.NqmimprovlAggDO;
import iih.nm.nqm.nqmovkpiipvdto.d.NqmovkpiipvDTO;
import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.orgfw.dept.d.DeptDO;

public interface INmNqmQueryService {

	/**
	 * 通过模板id查询树级结构的层数
	 * 
	 * @param idQctpl
	 * @return
	 * @throws BizException
	 */
	public int findTreeLevel(String idQctpl) throws BizException;

	/**
	 * 通过护理人员id 查询该部门姓名，护士层级
	 * 
	 * @param id_nur
	 * @return
	 * @throws BizException
	 */
	public NmNurDO findNqmQcgrpNames(String id_nur) throws BizException;

	/**
	 * 通过日期，病区查询病区专科指标录入项
	 * 
	 * @param dt_chk
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract NqmWdkEnDTO[] findNqmWdkEnDTO(FDate dt_chk, String id_dep_nur) throws BizException;

	/**
	 * 查询病区护理指标数据
	 * 
	 * @param dt_check
	 * @param Id_dep_nur
	 * @return
	 * @throws BizException
	 */
	NqmovkpiipvDTO[] findNqmovkpiipvDtos(FDate dt_check, String Id_dep_nur) throws BizException;

	/**
	 * 质量标准样式预览
	 * 
	 * @param id_nqm_cs
	 * @return
	 * @throws BizException
	 */
	public abstract QcTbDTO previewNqmCsByIdNqmCs(String id_nqm_cs) throws BizException;

	/**
	 * 质量标准模板样式预览
	 * 
	 * @param id_nqm_tmpl
	 * @return
	 * @throws BizException
	 */
	public abstract QcTbDTO previewNqmTmplByIdNqmTmpl(String id_nqm_tmpl) throws BizException;

	/**
	 * 质量检查记录预览
	 * 
	 * @param id_nqm_chk
	 * @return
	 * @throws BizException
	 */
	public abstract QcTbDTO previewNqmChkByIdNqmChk(String id_nqm_chk) throws BizException;

	/**
	 * 质控会议-质量检查问题汇总
	 * 
	 * @param nqmChkDo
	 * @param nqmQcmtDo
	 * @return
	 * @throws BizException
	 */
	public NmNqmChkItmDO[] findNqmChkDO(NqmChkDO chkdo) throws BizException;

	public NmNqmChkIssueDO[] findIssueDO(NqmChkDO nqmchkDO, FDate begin) throws BizException;

	/**
	 * 质控组质量检查-查找检查任务
	 * 
	 * @param id_nur
	 * @return
	 * @throws BizException
	 */
	public QcGrpTaskDTO[] findQcGrpTask(String id_nur, String id_nqm_qcgrp, String id_nqm_task, String id_nqm_cs, String id_nqm_tmpl, String id_dep_nur) throws BizException;

	/**
	 * 质量检查-点击检查任务，获取模板id，标准id等
	 * 
	 * @return
	 */
	public NmnqmchkDTO findCsidByTaks(String id_task) throws BizException;

	/**
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param funcode
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NmNqmTaskDO> findNqmTaskInfoByQCondAndPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String funcode, String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 分页查询（包含查询方案、查询条件、排序）质量检查信息
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param funcode
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NqmChkDO> findNqmChkInfoByQCondAndPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String funcode, String id_nur, String id_nbd_dep, String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 查询模板是否已经被分配给其他样式
	 * 
	 * @param idNqmCsSty
	 * @param string
	 *            []:idNqmCsTmpls
	 * @return NqmCsStyTmplDO[]
	 */
	public NqmCsStyTmplDO[] findRepeatNqmCsStyTmpl(String idNqmCsSty, String[] idNqmCsTmpls) throws BizException;

	/**
	 * 根据登录人员查询所在质控组
	 * 
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	public NqmQcgrpDO[] findNqmQcgrp(String id_psndoc) throws BizException;

	/**
	 * 检查标准数组根据code字段去重
	 * 
	 * @param csArr
	 * @return
	 * @throws BizException
	 */
	public NmNqmCsDO[] findDistinctTreeCsByCsArr(NmNqmCsDO[] csArr) throws BizException;

	/**
	 * 问题汇总列表查询
	 * 
	 * @param improveDo
	 * @return
	 * @throws BizException
	 */
	public NqmimprovlAggDO findImproveAggByDo(NqmImprovDO improveDo) throws BizException;

	/**
	 * 根据质控组id获取质控组下启用的检查标准
	 * 
	 * @param id_nqm_qcgrp
	 * @return
	 */
	public abstract NmNqmCsDO[] getNmNqmCs(String id_nqm_qcgrp) throws BizException;

	/**
	 * 获取存在问题的检查指标
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param code_nqm_cs
	 * @param sd_chk_lvl
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract NmNqmKpiDO[] getProblemKpi(FDate dt_begin, FDate dt_end, String code_nqm_cs, String sd_chk_lvl, String id_dep_nur) throws BizException;

	/**
	 * 护理夜查房统计
	 * 
	 * @param nightRoundDO
	 * @return
	 * @throws BizException
	 */
	public abstract NmNqmNightRoundDO getStatisticsData(NmNqmNightRoundDO nightRoundDO) throws BizException;

	/**
	 * 获取没有配置标准样式的质量标准
	 * 
	 * @param sd_style
	 * @return
	 * @throws BizException
	 */
	public abstract NmNqmCsDO[] getNotConfigStyleNqmCs(String sd_style) throws BizException;

	/**
	 * 根据质控组获取科室列表
	 * 
	 * @param id_qc_lvl质控级别
	 * @return
	 * @throws BizException
	 */
	public abstract DeptDO[] getDepListByQcGrp(String id_qc_lvl) throws BizException;
	/**
	 * 获取护理单元人员
	 * @param id_deps 科室id
	 * @param sd_nur_level 护士层级编码
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] getDepNurListByDepId(String[] id_deps,String sd_nur_level) throws BizException;
}
