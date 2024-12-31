package iih.pi.card.s;

import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.card.i.IPiCardQryService;
import iih.pi.card.s.bp.cardrtnrpt.CardrtnrptBp;
import iih.pi.card.s.bp.cardrtnrpt.CardrtnrptBpPaging;
import iih.pi.card.s.bp.cardrtnrpt.qry.FindPatCardsBP;
import iih.pi.dic.cardtype.d.CardDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 卡管理查询服务
 * @author Administrator
 *
 */
@Service(serviceInterfaces={IPiCardQryService.class}, binding=Binding.JSONRPC)
public class PiCardQryServiceImpl implements IPiCardQryService{

	/**
	 * 退卡查询服务
	 * @author Administrator
	 *
	 */
	@Override
	public CardrtnrptDTO[] getCardrtnrptDTO(String pi_code, String code,String name,
			String id_code) throws BizException {
		CardrtnrptBp bp = new CardrtnrptBp(); 
		return bp.exec(pi_code, code, name,id_code);
	}
	/**
	 * 退卡查询服务分页
	 * @author zmyang
	 *
	 */

	@Override
	public PagingRtnData<CardrtnrptDTO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		CardrtnrptBpPaging bp = new CardrtnrptBpPaging();
		PagingRtnData<CardrtnrptDTO> rtnData = bp.GetPagingRtnData(pg, wherePart, orderByPart);
		return rtnData;
	}
	
	/**
	 * 患者卡操作查询患者卡信息
	 */
	@Override
	public PagingRtnData<CardDTO> findPatCards(PaginationInfo pg, QryRootNodeDTO qryNode) throws BizException {
		FindPatCardsBP bp = new FindPatCardsBP();
		return bp.exec(pg,qryNode);
	}

	
}
