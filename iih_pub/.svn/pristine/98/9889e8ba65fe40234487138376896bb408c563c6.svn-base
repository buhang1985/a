package iih.bd.mhi.hpfeeca.i;

import iih.bd.mhi.dto.d.HPFeeCaCompDTO;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 费用类别扩展服务
 * 
 * @author dj.zhang
 *
 */
public interface IHpfeecaExtService {

	/**
	 * 根据医保产品查询费别分页数据
	 * 
	 * @param Hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HPFeeCaCompDTO> findPagingByHpId(HPDO Hpdo, String orderStr, PaginationInfo pg)
			throws BizException;

	/**
	 * 保存对照
	 * 
	 * @param hpId
	 * @param hpFeecaCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract HPFeeCaCompDTO[] saveHpFeecaComp(String hpId, HPFeeCaCompDTO[] hpFeecaCompDtos) throws BizException;

	/**
	 * 删除对照
	 * 
	 * @param hpId
	 * @param hpFeecaCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract HPFeeCaCompDTO[] delHpFeecaComp(String hpId, HPFeeCaCompDTO[] hpFeecaCompDtos) throws BizException;
}
