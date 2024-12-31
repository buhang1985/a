package iih.bd.mhi.hpstaffinfo.i;

import iih.bd.mhi.hpstaffinfo.d.HpStaffInfoDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保计划医院操作员信息上报扩展查询服务接口
 * 
 * @author lilei
 *
 */
public interface IHpstaffinfoExtRService {

	/**
	 * 根据医保产品主键和查询方案查询操作员权限分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 */
	public abstract PagingRtnData<HpStaffInfoDO> findPagingByQCondAndHp(QryRootNodeDTO qryRootNodeDTO, String hpId,
			String orderStr, PaginationInfo pg) throws BizException;
}
