package iih.bd.mhi.hpopepermapply.i;

import iih.bd.mhi.hpopepermapply.d.HpOpePermApplyDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保产品操作员权限扩展查询服务接口
 * 
 * @author gaoxn
 *
 */
public interface IHpOpePermApplyExtRService {

	/**
	 * 根据医保产品主键和查询方案查询操作员权限分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 */
	public abstract PagingRtnData<HpOpePermApplyDO> findPagingByQCondAndHp(QryRootNodeDTO qryRootNodeDTO, String hpId,
			String orderStr, PaginationInfo pg) throws BizException;
}
