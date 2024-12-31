package iih.bd.srv.srvpricetable.s;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.UpdateSrvPriceTableBp;
import xap.mw.core.data.BizException;

/**
 * 
 * 服务价格更新服务
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
//5.编写升级及紧急回退文档
public class BdSrvPriceTableUpdateServiceImpl implements IBdSrvPriceTableUpdateService {

	@Override
	public void updateSrvPriceTable(String condType, String[] condValues) throws BizException {
		UpdateSrvPriceTableBp bp = new UpdateSrvPriceTableBp();
		bp.exec(condType, condValues);
	}
}
