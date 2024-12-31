package iih.bd.pp.priceengine;

import iih.bd.pp.i.ICalcPriceService;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;

/**
 * 价格计算服务仓库
 * @author yankan
 * @since 2017-07-27
 *
 */
public class PriCalServiceFactory {
	/**
	 * 创建计价服务
	 * @param primdCode 定价模式编码
	 * @return
	 */
	public static ICalcPriceService createPriService(String primdCode){
		ICalcPriceService calcPriService = null;
		switch(primdCode){
		case IBdPrimdCodeConst.CODE_PRI_SRV:
			//本服务定价
			calcPriService = new CalcBasicSrvPriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT:
			//服务套成员合计价
			calcPriService = new CalcSrvsetAmtPriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_MU:
			//服务套成员项目个数加收
			calcPriService = new CalcSrvsetAmtPriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX:
			//服务套成员项目个数定价
			calcPriService = new CalcSrvsetFixPriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_RES:
			//对应物品价格
			calcPriService = new CalcResPriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRV_COMP:
			//组合定价模式
			calcPriService = new CalcSrvCompPriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_FREE:
			//免费
			calcPriService = new CalcFreePriceServiceImpl();
			break;
		case IBdPrimdCodeConst.CODE_PRI_PLUGIN:
			//插件
			
			break;
		}
		return calcPriService;
	}
}
