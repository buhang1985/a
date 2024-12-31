package iih.bl.st.exchagehandle.s;

import iih.bl.cg.dto.d.BlChargeDTO;
import iih.bl.st.exchangehandle.i.IChargeQryService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

public class ChargeQryServiceImpl implements IChargeQryService {

	/* 
	 * 获取已经记账的数据，处于未划价状态的
	 * @see iih.bl.st.exchangehandle.i.IChargeQryService#GetChargeItem(java.lang.String, java.lang.String)
	 */
	@Override
	public BlChargeDTO[] getChargeItem(String id_pat, String id_grp,String validateDateTime)
			throws BizException {
		return null;	
	}
}
