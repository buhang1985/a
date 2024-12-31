package iih.ei.bl.ecinc.bosssoft.v2.s;

import iih.ei.bl.ecinc.s.EcIncFinanceBaseServiceImpl;

/**
 * 博思电子发票财务处理
 * @author ly 2019/12/03
 *
 */
public class BossSoftEcIncFinanceServiceImpl extends EcIncFinanceBaseServiceImpl{

	private static BossSoftEcIncFinanceServiceImpl instance;
	
	static{
		instance = new BossSoftEcIncFinanceServiceImpl();
	}
	
	public static BossSoftEcIncFinanceServiceImpl getInstance(){
		return instance;
	}
}
