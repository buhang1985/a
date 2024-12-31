package iih.bd.pp.hpdupitmpri.bp;

import iih.bd.pp.hpdupitmpri.d.HpDupItmPriDO;
import xap.mw.core.data.BizException;

public class HpdupitmpriBp {

	public void exe(HpDupItmPriDO hpDupItmPriDO) throws BizException{
		if(hpDupItmPriDO != null){
			if(hpDupItmPriDO.getPrice() == null && hpDupItmPriDO.getPricecoefficient() == null){
				String hp_name = "";
				String srv_name = hpDupItmPriDO.getSrv_name();
				if(hpDupItmPriDO.getHp_name() != null) 
				{
					hp_name = hpDupItmPriDO.getHp_name();
				}
				throw new BizException("医保计划为“" + hp_name + "”，服务项目为“" + srv_name + "”的数据定价价格和价格系数不可同时为空！");
			}
		}
	}

}
