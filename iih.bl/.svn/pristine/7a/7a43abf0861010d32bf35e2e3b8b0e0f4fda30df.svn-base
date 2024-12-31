package iih.bl.hp.s.bp;

import iih.bl.hp.blhppatpoor.d.BlHpPatPoorDO;
import iih.bl.hp.blhppatpoor.i.IBlhppatpoordoRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CheckPiPatPoorBP {
	
	/**
	 * 判断患者是否是贫困患者
	 * 
	 * @param id_code
	 * @return FBoolean.TRUE：是贫困患者； FBoolean.FALSE：不是贫困患者
	 * @throws BizException
	 */
	public FBoolean exec(String id_code) throws BizException {
		IBlhppatpoordoRService poorRService = ServiceFinder.find(IBlhppatpoordoRService.class);
		BlHpPatPoorDO[] blHpPatPoorDoArr = poorRService.find(" Id_code = '" + id_code + "'", "", FBoolean.FALSE);
		if (blHpPatPoorDoArr != null && blHpPatPoorDoArr.length > 0) {
			return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
	}

}
