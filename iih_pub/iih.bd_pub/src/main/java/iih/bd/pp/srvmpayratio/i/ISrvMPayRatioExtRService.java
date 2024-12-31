package iih.bd.pp.srvmpayratio.i;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保项目多支付比例扩展服务查询接口
 * 
 * @author hao_wu
 *
 */
public interface ISrvMPayRatioExtRService {

	/**
	 * 根据查询方案和医保计划查询医保项目多支付比例分页数据
	 * 
	 * @param hpdo
	 *            医保计划
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return 医保项目多支付比例分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<SrvMPayRatioDO> FindPagingByQCondAndHp(HPDO hpdo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException;
}
