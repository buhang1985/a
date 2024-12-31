package iih.bl.itf.std;

import iih.bl.itf.std.bp.cc.CloseAccountBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--结账服务
 * @author shaokx 2020/05/13
 *
 */
public class BlCcServiceImpl implements IBlCcService{

	/**
	 * 结账
	 */
	@Override
	public String closeAccount(String param) throws BizException {
		CloseAccountBP bp = new CloseAccountBP();
		return bp.execTrans(param);
	}
	
	
}
