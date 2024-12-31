package iih.pmp.pay.s.bp.validate;

import java.util.List;

import iih.pmp.pay.trade.d.TradeDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class TradeValidator  implements Validator{

	@Override
	public ValidationFailure validate(Object... arg0) {
		// TODO Auto-generated method stub
		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		for (Object object : arg0) {
			if (object instanceof TradeDO) {
				TradeDO dto=(TradeDO)object;
				DAFacade fa=new DAFacade();
				try {
					List<TradeDO> tralist=(List<TradeDO>) fa.execQuery(" select * from pmp_trade where "+" Trade_no='"+dto.getTrade_no()+"'", new BeanListHandler(TradeDO.class));
					if(tralist!=null&&tralist.size()>0)
						return new ValidationFailure("交易号重复！");
				} catch (BizException e1) {
					// TODO Auto-generated catch block
					return new ValidationFailure(e1.getMessage());
				}
	
			}
			
		}
		return null;
	}

}
