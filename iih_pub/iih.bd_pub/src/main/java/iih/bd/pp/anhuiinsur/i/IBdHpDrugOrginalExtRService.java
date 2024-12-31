package iih.bd.pp.anhuiinsur.i;

import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽东软医保药品目录扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IBdHpDrugOrginalExtRService {

	/**
	 * 根据医保产品主键、查询模板条件、分页信息查询分页数据集合
	 * 
	 * @param hpId
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BdHpDrugOrginalDO> findPagingByHpIdAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException;
}