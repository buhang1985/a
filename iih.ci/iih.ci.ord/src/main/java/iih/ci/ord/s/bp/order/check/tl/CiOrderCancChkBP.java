package iih.ci.ord.s.bp.order.check.tl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrMpRtnDrug4StopCanc2BP;
import iih.ci.ord.s.bp.ems.save.ip.CiOrValidateBP;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import iih.ci.ord.s.bp.order.check.UpdateOrdStatusInfo1BP;
import iih.ci.ord.s.bp.validate.MethodConstants;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 *  临床医嘱的作废核对操作BP
 */
public class CiOrderCancChkBP {
	/**
	 * 临床医嘱的作废核对
	 * @param id_ors
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(
				id_ors, FBoolean.FALSE);
		CiOrderDO[] ciors=getCiOrderDOs(aggors);
		CiOrValidateBP validate=new CiOrValidateBP();
		if(!validate.exec(aggors, MethodConstants.CANCEL_VALIDATE)){
			throw new CiOrOperatorCheckException();
		}
		FDateTime dt_cur=CiOrdAppUtils.getServerDateTime();
		
		
		
		//医嘱停止或作废时，执行域进行退药处理
//		CiOrMpRtnDrug4StopCancBP bp=new CiOrMpRtnDrug4StopCancBP();
//		bp.exec(id_ors, ciors[0].getDt_effe());
		CiOrMpRtnDrug4StopCanc2BP bp=new CiOrMpRtnDrug4StopCanc2BP();
		bp.execCanc( getCancelMap(ciors));
		//医嘱状态调整为作废核对
		UpdateOrdStatusInfo1BP bp1=new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null,null, ICiDictCodeConst.SD_SU_CHECKCANCEL);
		//处方撤回
		HandlePresInfo(ciors);
		return ciors;
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
	 * 获得医嘱主DO数组
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors){
		CiOrderDO[] rtns=new CiOrderDO[aggors.length];
		for(int i=0;i<aggors.length;i++){
			
			rtns[i]=aggors[i].getParentDO();
		}
		return  rtns;
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
