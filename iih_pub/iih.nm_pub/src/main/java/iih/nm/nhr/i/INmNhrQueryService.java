package iih.nm.nhr.i;

import iih.nm.nhr.dto.nhrschedweekdto.d.SchedWeekDTO;
import iih.nm.nhr.dto.nmnurgrpdto.d.NmNurGrpDTO;
import iih.nm.nhr.dto.nmpsnqry.d.NmPsnQryDTO;
import iih.nm.nhr.dto.nmpsnqryfied.d.NmPsnQryFieldDTO;
import iih.nm.nhr.dto.nurinfo.d.NurInfoDTO;
import iih.nm.nhr.dto.weeksched.d.SchedDataTableDTO;
import iih.nm.nhr.nhrrotate.d.NhrRotateDO;
import iih.nm.nhr.nhrschedweek.d.NhrSchedWeekDO;
import iih.nm.nhr.nmdeppl.d.NmDepplDO;
import iih.nm.nhr.nmnhrnurvacat.d.NmNhrNurVacat;
import iih.nm.nhr.nmnhrsigrp.d.NhrSigrpDO;
import iih.nm.nhr.nmnhrsigrp.d.NmnhrsigrpAggDO;
import iih.nm.nhr.nmpsndoc.d.NmNurDO;
import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

public interface INmNhrQueryService {

	/**
	 * 周排班——根据条件查找排班信息
	 * 
	 * @param dt_monday周一日期
	 * @param id_dep_nur护理单元
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract SchedDataTableDTO findSchedDataByCond(FDate dt_monday, String id_dep_nur) throws BizException;

	/**
	 * 周排班——根据周排班主键查找排班信息
	 * 
	 * @param id_nhr_sched_week
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract SchedDataTableDTO findSchedDataById(String id_nhr_sched_week) throws BizException;

	/**
	 * 实习科室轮转计划-根据实习小组名称
	 * 
	 * @param id_nm_dep
	 * @return
	 */
	public abstract NmDepplDO findSchedPlanByGrpId(String id_nm_dep) throws BizException;

	/**
	 * 根据部门主键查找护士名称及所属科室
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] findNmNurDOByDep(String id_dep) throws BizException;

	/**
	 * 排班人员分組（AggDos）
	 * 
	 * @param dt_monday周一日期
	 * @param id_dep_nur护理单元
	 * @return
	 * @throws BizException
	 */
	public abstract NmnhrsigrpAggDO[] findSiGrpAggDos(FDate dt_monday, String id_dep_nur) throws BizException;

	/**
	 * 排班人员分組(MDOs)
	 * 
	 * @param dt_monday周一日期
	 * @param id_dep_nur护理单元
	 * @return
	 * @throws BizException
	 */
	public abstract NhrSigrpDO[] findSiGrpMDos(FDate dt_monday, String id_dep_nur) throws BizException;

	/**
	 * 班次排班
	 * 
	 * @param dt_monday
	 *            周一信息
	 * @param id_dep_nur护理单元
	 * @return
	 * @throws BizException
	 */
	public abstract SchedWeekDTO findNhrSiDTO(FDate dt_monday, String id_dep_nur) throws BizException;

	/**
	 * 护士层级
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract UdidocDO[] findNurHieUdidocDOS(String code) throws BizException;

	/**
	 * 护士属性
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract UdidocDO[] findNurProperUdidocDOS(String code) throws BizException;

	/**
	 * 科室对应护理人员列表
	 * 
	 * @param id_dep
	 * @author guo.xiao
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] findNmnurListBydep(String id_dep) throws BizException;

	/**
	 * 护理层级对应护理人员列表
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] findNmnurListByLevel(String code) throws BizException;

	/**
	 * 质控组对应护理人员列表
	 * 
	 * @param id_nqm_qcgrp
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] findNmnurListByqcgrp(String id_nqm_qcgrp) throws BizException;

	/**
	 * 根据人员id_psndoc获取护理人员信息
	 * 
	 * @param id_psndoc
	 * @return
	 * @lijm 2018-6-12 14:05:22
	 * @throws BizException
	 */
	public abstract NmNurDO getNurPsnInfo(String id_psndoc) throws BizException;

	/**
	 * 分页查询（包含查询方案、查询条件、排序）护理人员信息
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param cond
	 * @param funcode
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @authorlijm 2018-7-10 18:00
	 * @throws BizException
	 */
	public abstract PagingRtnData<NmNurDO> findNurPsnInfoByQCondAndPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String funcode, String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 人员调动撤销
	 * 
	 * @param nurtransdo需要撤销的申请
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurTransDO[] nmNurTransAuditRevoke(NmNurTransDO[] nurtransdos) throws BizException;

	/**
	 * 通过科室id查询护理人员信息
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] getNurInfoByDep(String id_dep) throws BizException;

	/**
	 * 获取排班科室
	 * 
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract NhrSchedWeekDO[] getDepSchedWeek() throws BizException;

	/**
	 * 查询护理人员信息
	 * 
	 * @param id_org
	 * @param id_dep
	 * @param qryRootNodeDTO
	 * @param funcode
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] findNurPsnInfoByQcond(String id_org, String id_dep, QryRootNodeDTO qryRootNodeDTO, String funcode, String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 人力资源科室树查询
	 * 
	 * @param inwork_flag
	 * @return
	 * @throws BizException
	 */
	public abstract DeptDO[] getDeptTree(IBaseDO baseDO, String funcode) throws BizException;

	/**
	 * 护理管理人员小组成员信息
	 * 
	 * @param idNurs
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurGrpDTO[] getNmNurPsnInfo(String id_nur_grp, String[] id_nurs) throws BizException;

	/**
	 * 根据条件获取护理人员信息列表（lijm）
	 * 
	 * @param qryRootNodeDTO查询方案
	 * @param id_dep科室id
	 * @param orderStr排序字段
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<NurInfoDTO> getNurInfoListByQcond(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_dep, FBoolean fg_inwork, String orderStr) throws BizException;

	/**
	 * 根据人员主键获取护理人员信息
	 * 
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
	public abstract NurInfoDTO getNurInfoByIdPsnDoc(String id_psndoc) throws BizException;

	/**
	 * 根据科室id查询方案查询数据
	 * 
	 * @param qryRootNodeDTO
	 * @param id_dep
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public abstract NmNhrNurVacat[] getNurVacatListByQcond(QryRootNodeDTO qryRootNodeDTO, String id_dep, String orderStr) throws BizException;

	/**
	 * 根据所选的护理人员id查询人员基本信息
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract NmNurDO[] getNurInfoListById(String[] id_psndoc) throws BizException;

	/**
	 * 获取当前登录科室下护理人员的轮转科室记录
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract NhrRotateDO[] getCurrDepNurRotates(String id_dep) throws BizException;

	/**
	 * 护理人员统计分析
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author
	 */
	public abstract PagingRtnData<NmPsnQryDTO> synthQryNmPsn(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String orderStr) throws BizException;

	/**
	 * 获取护理人员统计分析字段集合
	 * 
	 * @return
	 */
	public abstract NmPsnQryFieldDTO[] getNmPsnQryDTOField() throws BizException;
}
