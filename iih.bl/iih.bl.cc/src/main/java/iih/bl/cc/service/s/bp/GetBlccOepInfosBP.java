package iih.bl.cc.service.s.bp;

import java.util.ArrayList;


import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import iih.bl.cc.blccoepinfodto.d.BlccOepInfoDTO;
import iih.bl.cc.service.s.bp.sql.GetBlccOepInfosSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 通过收付款信息查询对应的费用明细
 * Title: GetBlccOepInfosBP.java
 * @author zhang.hw
 * @date 2019年9月29日  
 * @version 1.0
 */
public class GetBlccOepInfosBP {

	public BlccOepInfoDTO[] exec(BlpayOepPatDTO blpayOepPatDTO) throws BizException {
		GetBlccOepInfosSql sql = new GetBlccOepInfosSql(blpayOepPatDTO);
		DAFacade daFacade = new DAFacade();
		ArrayList<BlccOepInfoDTO> list = (ArrayList<BlccOepInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(BlccOepInfoDTO.class));
		return list.toArray(new BlccOepInfoDTO[list.size()]);
	}

}
