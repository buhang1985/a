package iih.bd.pp.hpsrvorcadto.i;

import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保对照dto服务接口
 * 
 * @author guoyang, hao_wu
 *
 */
public interface IHpSrvorcadtoRService {

	/**
	 * 查询已审核数据列表
	 * 
	 * @param qryRootNodeDto
	 *            查询方案数据
	 * @param pg
	 *            分页信息
	 * @return 已审核数据列表
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpsrvorcaDTO> findAuditedDataList(QryRootNodeDTO qryRootNodeDto,PaginationInfo pg)
			throws BizException;

	/**
	 * 查询已审核药品数据列表
	 * 
	 * @param qryRootNodeDto
	 *            查询方案数据
	 * @param pg
	 *            分页信息
	 * @return 已审核数据列表
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpsrvorcaDTO> findAuditedDrugDataList(QryRootNodeDTO qryRootNodeDto,
			String hpId, PaginationInfo pg) throws BizException;

	/**
	 * 查询已审核诊疗数据列表
	 * 
	 * @param qryRootNodeDto
	 *            查询方案数据
	 * @param pg
	 *            分页信息
	 * @return 已审核数据列表
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpsrvorcaDTO> findAuditedZlDataList(QryRootNodeDTO qryRootNodeDto,String hpId, PaginationInfo pg)
			throws BizException;

	/**
	 * 查询已审核服务设施数据列表
	 * 
	 * @param qryRootNodeDto
	 *            查询方案数据
	 * @param pg
	 *            分页信息
	 * @return 已审核数据列表
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpsrvorcaDTO> findAuditedFwssDataList(QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException;
}
