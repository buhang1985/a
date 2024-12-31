package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.i.IBdHpSrvOrCaExtCudService;
import iih.bd.pp.anhuisrvorca.i.IBdHpSrvOrCaExtRService;
import iih.bd.pp.anhuisrvorca.s.bp.AutoCompBp;
import iih.bd.pp.anhuisrvorca.s.bp.FindAnhuiInsurSrvOrCaByQCondAndPageInfoBp;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽医保医保目录对照扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdHpSrvOrCaExtCrudServiceImpl implements IBdHpSrvOrCaExtRService, IBdHpSrvOrCaExtCudService {

	@Override
	public PagingRtnData<HPSrvorcaDO> FindByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String hpCode,
			PaginationInfo pg) throws BizException {
		FindAnhuiInsurSrvOrCaByQCondAndPageInfoBp bp = new FindAnhuiInsurSrvOrCaByQCondAndPageInfoBp();
		PagingRtnData<HPSrvorcaDO> result = bp.exec(qryRootNodeDTO, hpCode, pg);
		return result;
	}

	@Override
	public void AutoComp(String hpCode) throws BizException {
		AutoCompBp bp = new AutoCompBp();
		bp.exec(hpCode);
	}
}
