package iih.bl.inc.service.i;

import iih.bl.inc.blcpnin.d.BlCpnInDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IBLIncMaintainService {
	/**
     * 录入入库单和优惠券
     * */
	public FBoolean inserBlCpnInInfo(BlCpnInDO blCpnInDO,Integer blCpnAddCodeLen) throws BizException ;
	
	/**
	 * 删除入库单
	 * */
	public FBoolean deleteBlCpnInInfo(BlCpnInDO blCpnInDO) throws BizException;
}
