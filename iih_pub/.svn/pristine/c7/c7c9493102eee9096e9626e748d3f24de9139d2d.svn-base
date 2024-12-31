package iih.pi.card.i;

import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.dic.cardtype.d.CardDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 卡管理查询服务
 * @author Administrator
 *
 */
public interface IPiCardQryService {
	/**
	* 退卡查询服务
	* @author Administrator
	*
	*/
	public CardrtnrptDTO[] getCardrtnrptDTO(String pi_code, String code,String name,
			String id_code) throws BizException;
	/**
	 * 退卡查询服务分页
	 * @author Administrator
	 *
	 */
	public abstract PagingRtnData<CardrtnrptDTO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 患者卡操作查询患者卡信息
	 * @description:
	 * @author:hanjq  2020年6月10日
	 * @param pg
	 * @param qryNode
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CardDTO> findPatCards(PaginationInfo pg, QryRootNodeDTO qryNode) throws BizException;
}
