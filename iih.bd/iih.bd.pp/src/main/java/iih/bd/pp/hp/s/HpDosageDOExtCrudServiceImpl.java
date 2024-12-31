package iih.bd.pp.hp.s;

import iih.bd.mhi.dto.d.HpDosageCompDTO;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpDosageDOExtCudService;
import iih.bd.pp.hp.i.IHpDosageDOExtRService;
import iih.bd.pp.hp.s.bp.DelHpDosageCompBp;
import iih.bd.pp.hp.s.bp.FindPagingByHpIdBp;
import iih.bd.pp.hp.s.bp.SaveHpDosageCompBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 剂型对照扩展服务
 * 
 * @author dj.zhang
 *
 */
@Service(serviceInterfaces = { IHpDosageDOExtCudService.class,
		IHpDosageDOExtRService.class }, binding = Binding.JSONRPC)
public class HpDosageDOExtCrudServiceImpl implements IHpDosageDOExtCudService, IHpDosageDOExtRService {

	/**
	 * 根据医保产品查询剂型分页数据
	 * 
	 * @param Hpdo
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<HpDosageCompDTO> findPagingByHpId(HPDO hpdo, String orderStr, PaginationInfo pg)
			throws BizException {
		FindPagingByHpIdBp bp = new FindPagingByHpIdBp();
		return bp.exec(hpdo, orderStr, pg);
	}

	/**
	 * 保存对照
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException
	 */
	@Override
	public HpDosageCompDTO[] saveHpDosageComp(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException {
		SaveHpDosageCompBp bp = new SaveHpDosageCompBp();
		HpDosageCompDTO[] result = bp.exec(hpId, hpDosageCompDtos);
		return result;
	}

	/**
	 * 删除对照
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException
	 */
	@Override
	public HpDosageCompDTO[] delHpDosageComp(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException {
		DelHpDosageCompBp bp = new DelHpDosageCompBp();
		return bp.exec(hpId, hpDosageCompDtos);
	}

}
