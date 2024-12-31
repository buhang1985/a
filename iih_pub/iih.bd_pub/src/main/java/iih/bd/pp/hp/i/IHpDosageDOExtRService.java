package iih.bd.pp.hp.i;

import iih.bd.mhi.dto.d.HpDosageCompDTO;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 剂型对照扩展服务
 * 
 * @author dj.zhang
 *
 */
public interface IHpDosageDOExtRService {

	/**
	 * 根据医保产品查询剂型分页数据
	 * 
	 * @param Hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpDosageCompDTO> findPagingByHpId(HPDO hpdo, String orderStr, PaginationInfo pg)
			throws BizException;
}