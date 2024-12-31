package iih.bd.srv.s.bp;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import xap.mw.coreitf.d.FDouble;

/**
 * 医疗服务计价模式助手类
 */
public class BdSrvPriHelper {
	/**
	 * 本服务定价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvSelfPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRV.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 套成员合计计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberSumPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 套成员个数加收计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemCntAdditionalPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRVSET_MU.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRVSET_MU.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 套成员个数定价计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberCntPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRVSET_FIX.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 对应物品计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvRelMmPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_RES.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_RES.equals(id_primd)){return true;}
		return false;
	}	
	/**
	 * 服务组合定价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvCompPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 服务不付费模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvFreePrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_FREE.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_FREE.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 服务外挂插件计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvPluginPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_PLUGIN.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_PLUGIN.equals(id_primd)){return true;}
		return false;
	}
	
	/**
	 * 获得本服务定价对应的合计价
	 * @param pridtos
	 * @return
	 */
	public static FDouble getPriceSum(PriStdSrvDTO[] pridtos){
		if(BdSrvUtils.isEmpty(pridtos))return null;
		FDouble rtn = FDouble.ZERO_DBL;
		for(int i=0;i<pridtos.length;i++){
			if(BdSrvUtils.isEmpty(pridtos[i].getPrice()))continue;
//			if(CiOrdUtils.isEmpty(rtn)){
//				rtn=pridtos[i].getPrice();
//			}else{
//				rtn=pridtos[i].getPrice().add(rtn);
//			}
			rtn=pridtos[i].getPrice().add(rtn);
		}
		
		return rtn;
	}
}
