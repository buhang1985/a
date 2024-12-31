package iih.bd.pp.primd.bp;

import iih.bd.pp.primd.d.PrimdDO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPrimdRService;
import iih.bd.pp.primd.s.PrimdCrudServiceImpl;
import xap.mw.core.data.BizException;

/**
 * 价格计算引擎
 * @author yankan
 * @since 2015-08-04
 *
 */
public class PriCalEngine {
	/**
	 * 获取计算器
	 * @param primdType 定价模式类型
	 * @param srvId 服务Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public IPriCal GetPriCal(String primdId,String srvId){
		IPriCal priCal = null;
		PrimdDO primdDO = GetPrimdDO(primdId);
		if(primdDO==null)
			return null;
		String Code = primdDO.getCode();
		if(Code.endsWith(IBdPrimdCodeConst.CODE_PRI_SRV)){
			priCal = new SrvPriCal();
		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT)){
			priCal = new SrvSetTotalPriCal();
		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_SRVSET_MU)){
			priCal = new SrvSetMuPriCal();
		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX)){
			priCal = new SrvSetMuPriCal();
		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_RES)){
			priCal = new SrvResPriCal();
//		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_SRV_PKG)){
//			priCal = new SrvPkgPriCal();
		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_SRV_COMP)){
			priCal = new SrvCompPriCal();
		}else if(Code.equalsIgnoreCase(IBdPrimdCodeConst.CODE_PRI_PLUGIN)){
			priCal = GetUserDefPriCal(primdDO.ID_PLUGIN_CALC);
		}
		
		return priCal;
	}
	/**
	 * 根据定价模式ID，获取定价模式DO
	 * @param primdId 定价模式ID
	 * @return 定价模式DO
	 */
	private PrimdDO GetPrimdDO(String primdId){
		IPrimdRService primdSv = new PrimdCrudServiceImpl();
		PrimdDO primdDO=null;
		try {
			primdDO = primdSv.findById(primdId);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return primdDO;
	}
	/**
	 * 获取用户自定义价格计算器
	 * @param userDefCalPlugin 用户自定义的计算插件 
	 * @return
	 */
	private IPriCal GetUserDefPriCal(String userDefCalPlugin){
		return null;
	}
}
