package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 诊疗和服务设施对照服务
 * 
 * @author hao_wu
 *
 */
public interface ITreatAndFwssCompRService {
	/**
	 * 查询诊疗和服务设施对照数据列表
	 * 
	 * @return
	 */
	public abstract PagingRtnData<TreatCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException;

	/**
	 * 补全医保诊疗或服务设施信息</br>
	 * 选择医保诊疗项目和服务设施参照后进行补全
	 * 
	 * @param treatCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] CompInsurZlAndFwssData(TreatCompDTO[] treatCompDTOs) throws BizException;

	/**
	 * 获取可以同步审核信息对照数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] FindCanSyncApprovalComp(String hpCode) throws BizException;

	/**
	 * 获取超限价对照信息
	 * 
	 * @param pg
	 * @return
	 */
	public abstract PagingRtnData<TreatCompDTO> FindExceedMaxPriComp(String hpCode, PaginationInfo pg)
			throws BizException;
}
