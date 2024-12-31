package iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.bp;

import iih.bd.pp.bdhpsrvctrds.d.BdHpSrvCtrDsDO;
import iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.bp.qry.GetIndicationDsCtrlQry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取服务病种限制
 * @author LIM
 * @since 2019-09-29
 */
public class GetMiCtrlDsBP {
	/**
	 * 获取服务病种限制
	 * 
	 * @param hpId
	 *            医保计划ID
	 * @param idlist
	 *            对照服务list
	 * @return 服务诊断控制Map
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, List<BdHpSrvCtrDsDO>> exec(String hpId,List<String> idlist) throws BizException {
		
		Map<String, List<BdHpSrvCtrDsDO>> ctrMap = new HashMap<String, List<BdHpSrvCtrDsDO>>();
		GetIndicationDsCtrlQry qry= new GetIndicationDsCtrlQry(hpId,idlist);
		List<BdHpSrvCtrDsDO> dsLimtArr = (List<BdHpSrvCtrDsDO>) new DAFacade()
				.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
						new BeanListHandler(BdHpSrvCtrDsDO.class));
		if(!ListUtil.isEmpty(dsLimtArr)){
			for(BdHpSrvCtrDsDO dsDo : dsLimtArr){
				List<BdHpSrvCtrDsDO> dsList = ctrMap.get(dsDo.getId_srv()+dsDo.getId_mm());
				if (dsList == null) {
					dsList = new ArrayList<BdHpSrvCtrDsDO>();
					ctrMap.put(dsDo.getId_srv()+dsDo.getId_mm(), dsList);
				}
				dsList.add(dsDo);
			}
		}
		return ctrMap;
	}
}
