package iih.bd.mhi.hpfeeca.s;

import iih.bd.mhi.dto.d.HPFeeCaCompDTO;
import iih.bd.mhi.hpfeeca.i.IHpfeecaExtService;
import iih.bd.mhi.hpfeeca.s.bp.DelHpFeecaCompBp;
import iih.bd.mhi.hpfeeca.s.bp.FindFeecaPagingByHpIdBp;
import iih.bd.mhi.hpfeeca.s.bp.SaveHpFeecaCompBp;
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
public class HpfeecaExtServiceImpl implements IHpfeecaExtService {

	/**
	 * 根据医保产品查询费别分页数据
	 * 
	 * @param Hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<HPFeeCaCompDTO> findPagingByHpId(HPDO hpdo, String orderStr, PaginationInfo pg)
			throws BizException {
		FindFeecaPagingByHpIdBp bp = new FindFeecaPagingByHpIdBp();
		return bp.exec(hpdo, orderStr, pg);
	}

	/**
	 * 保存对照
	 * 
	 * @param hpId
	 * @param hpFeecaCompDtos
	 * @return
	 * @throws BizException
	 */
	@Override
	public HPFeeCaCompDTO[] saveHpFeecaComp(String hpId, HPFeeCaCompDTO[] hpFeecaCompDtos) throws BizException {
		SaveHpFeecaCompBp bp = new SaveHpFeecaCompBp();
		HPFeeCaCompDTO[] result = bp.exec(hpId, hpFeecaCompDtos);
		return result;
	}

	/**
	 * 删除对照
	 * 
	 * @param hpId
	 * @param hpFeecaCompDtos
	 * @return
	 * @throws BizException
	 */
	@Override
	public HPFeeCaCompDTO[] delHpFeecaComp(String hpId, HPFeeCaCompDTO[] hpFeecaCompDtos) throws BizException {
		DelHpFeecaCompBp bp = new DelHpFeecaCompBp();
		return bp.exec(hpId, hpFeecaCompDtos);
	}

}
