package iih.ci.ord.s.ems.mdsstation.order.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.CiOrMpRtnDrug4StopCanc2BP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 
 * @author 医技医生站作废确认操作 
 *
 */
public class MdsCancelChkBP extends MdsCancelBP{
	public CiOrderDO[] exec(CiOrderDO[] orders) throws BizException{
		if(orders != null && orders.length >0){
			for (CiOrderDO ciOrderDO : orders) {
				ciOrderDO.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKCANCEL);
				ciOrderDO.setSd_su_or(ICiDictCodeConst.SD_SU_CHECKCANCEL);
				ciOrderDO.setFg_canc(new FBoolean(true));
				ciOrderDO.setFg_chk_canc(new FBoolean(true));
				ciOrderDO.setFg_uncancelable(new FBoolean(true));//不可作废标识
				ciOrderDO.setDt_chk_canc(CiOrdAppUtils.getServerDateTime());
				ciOrderDO.setId_dep_chk_canc(Context.get().getDeptId());
				ciOrderDO.setId_emp_chk_canc(Context.get().getStuffId());
				ciOrderDO.setStatus(DOStatus.UPDATED);
			}
			orders = CiOrdAppUtils.getOrService().update(orders);
			if(orders !=null && orders.length>0){
				List<String> id_ors = new ArrayList<String>();
				for (CiOrderDO order : orders) {
					id_ors.add(order.getId_or());
				}
				//退药操作
				CiOrMpRtnDrug4StopCanc2BP bp=new CiOrMpRtnDrug4StopCanc2BP();
				bp.execCanc( getCancelMap(orders));
				HandlePresInfo(orders);
				//执行域响应医嘱作废操作
				CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,orders);
				return orders;
			}
		}
		return null;
	}
	private FMap getCancelMap(CiOrderDO[] ciors) throws BizException{
		FMap m=new FMap();
		
		for (CiOrderDO ciOrderDO : ciors) {
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
			m.put(ciOrderDO.getId_or(), ciOrderDO.getDt_canc());
		}
		
		return m;
	}
	/**
	 * 作废确认时，撤回处方信息，并删除新处方
	 * @param ciors
	 * @throws BizException
	 */
	private void HandlePresInfo(CiOrderDO[] ciors) throws BizException {
		StringBuilder sb=new StringBuilder();
		for (CiOrderDO ciOrderDO : ciors) {
			//对出院带药的处方撤回
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)&&ciOrderDO.getFg_pres_outp().booleanValue())
			sb.append("'"+ciOrderDO.getId_or()+"',");
		}
		if(sb.length()>0) {
		String tmp=sb.toString();
		int index=tmp.lastIndexOf(",");
		String idors=tmp.substring(0, index);
		OrdSrvDO[] srvs=CiOrdAppUtils.getOrSrvQryService().find("id_or in("+idors+")", "", FBoolean.FALSE);
		StringBuilder sb2=new StringBuilder();
		Map<String,OrdSrvDO> map=new HashMap<>();
		if(srvs!=null) {			
			for (OrdSrvDO s : srvs) {
				if(s.getId_pres()!=null&&s.getId_pres().trim().length()>0) {					
					if(!map.containsKey(s.getId_pres())) {
						map.put(s.getId_pres(), s);
						sb2.append("'"+s.getId_pres()+"',");
					}
					s.setId_pres(null);
					s.setStatus(DOStatus.UPDATED);
				}				
			}
			//撤回处方
			CiOrdAppUtils.getOrSrvService().save(srvs);
			//查询空处方
			String tmp2=sb2.toString();
			int index2=tmp2.lastIndexOf(",");
			String idpress=tmp2.substring(0, index2);
			OrdSrvDO[] srvs2=CiOrdAppUtils.getOrSrvQryService().find("id_pres in("+idpress+")", "", FBoolean.FALSE);
			Map<String,OrdSrvDO> map2=new HashMap<>();
			for (OrdSrvDO s : srvs2) {
				if(s.getId_pres()!=null&&s.getId_pres().trim().length()>0) {					
					if(!map2.containsKey(s.getId_pres())) {
						map2.put(s.getId_pres(), s);
					}
				}				
			}
			List<String> preslist=new ArrayList<>();
			for(String key: map.keySet()) {
				if(!map2.containsKey(key)) {
					preslist.add(key);
				}
			}
			//删除空处方 
			if(preslist.size()>0) {
				CiPresDO[] press=CiOrdAppUtils.getCiPresQryService().findByBIds(preslist.toArray(new String[0]), FBoolean.FALSE);
				CiOrdAppUtils.getCiPresService().delete(press);
			}
		}
		}
	}
}
