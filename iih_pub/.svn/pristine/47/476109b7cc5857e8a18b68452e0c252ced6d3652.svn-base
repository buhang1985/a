package iih.bd.pp.hpdivshisdto.i;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保病种目录查询服务
 * 
 * @author hao_wu
 *
 */
public interface IHpdivshisdtoRService {

	/**
	 * 查询DTO
	 * 
	 * @return
	 * @throws BizException
	 */
	public HpDiVsHisDTO[] find() throws BizException;

	/**
	 * 带查询模板的分页查询
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpDiVsHisDTO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;

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
	public abstract PagingRtnData<HpDiVsHisDTO> FindAuditedDataList(QryRootNodeDTO qryRootNodeDto, String idHp, PaginationInfo pg)
			throws BizException;

	/**
	 * 查询对照数据列表
	 * 
	 * @param qryRootNodeDto
	 *            查询方案数据
	 * @param pg
	 *            分页信息
	 * @return 未对照数据列表
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpDiVsHisDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String idHp, PaginationInfo pg)
			throws BizException;

	/**
	 * 补全医保诊断信息</br>
	 * 选择医保诊断参照后进行补全
	 * 
	 * @param hpDiVsHisDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract HpDiVsHisDTO[] CompInsurDiData(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException;

}
