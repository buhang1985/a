package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽医保医保目录对照扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IBdHpSrvOrCaExtRService {

	/**
	 * 使用查询方案分页查询安徽医保目录对照列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HPSrvorcaDO> FindByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String hpCode,
			PaginationInfo pg) throws BizException;

}
