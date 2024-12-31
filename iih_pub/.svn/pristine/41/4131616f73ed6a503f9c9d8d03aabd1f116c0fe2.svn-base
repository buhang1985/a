/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.i;

import iih.ci.mrqc.cimrqcrandomrule.d.CiMrQcRandomRuleDO;
import iih.ci.mrqc.mrqcerrordto.d.MrQcErrorDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 门诊质控主服务
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public interface IOutMrQcMaintainService {

	/**
	 * 门诊部 根据规则设置 产生各个科室的抽查数据
	 * @param ruleDos
	 * @return
	 * @throws BizException
	 */
	public abstract MrQcErrorDTO[] OpdInsertRandomRecordByRule(CiMrQcRandomRuleDO[] ruleDos) throws BizException;
	/**
	 * 批量修改门诊部抽查规则
	 * @param ruleDos
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean MultiChangeRule(CiMrQcRandomRuleDO[] ruleDos, CiMrQcRandomRuleDO changeDo) throws BizException;
	/**
	 * 门诊科室质控完成质控操作
	 * @param score
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean CompleteDepOutQc(String score, MrQcRandomItmDTO patDto) throws BizException;
	/**
	 * 门诊部质控完成质控操作
	 * @param score
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean CompleteOpdOutQc(String score, MrQcRandomItmDTO patDto) throws BizException;
	/**
	 * 根据门诊质控类型获取对应的缺陷
	 * @param id_ent
	 * @param id_qc_type
	 * @return
	 * @throws BizException
	 */
	public abstract QaFltDTO[] getOutQcfltDtosByQcType(String id_ent, String id_qc_type) throws BizException;
	/**
	 * 获取门诊科室质控抽查记录明细
	 * @param id_random
	 * @return
	 * @throws BizException
	 */
	public abstract MrQcRandomItmDTO[] getOutDepMrQcRandomItmDtos(String id_random) throws BizException;
	/**
	 * 门诊科室已抽查查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrQcRandomRecordDO> getOutDepQcHasRandomRecordDoList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 门诊科室质控记录查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrQcRandomRecordDO> getOutDepQcHasRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 门诊部已抽查查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrQcRandomRecordDO> getOutOpdQcHasRandomRecordDoList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 门诊部质控记录查询记录主表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrQcRandomRecordDO> getOutOpdQcHasRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 门诊部抽查规则-查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrQcRandomRuleDO> getOutMrQcRandomRuleQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
}
