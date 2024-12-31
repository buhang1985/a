package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.GetOrdApBtDONumQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 用血签署校验对应备血可用血余量
 * @author Administrator
 *
 */
public class UseBtOrNumMarginBuValidateBP {
	
	public String exe(CiorderAggDO[] aggors) throws BizException{
		Map<String, List<OrdSrvDO>> map = this.getTeamCiOrder(aggors);
		//判断每一组用血申请量的总和与对应备血医嘱的可用血余量
		String rst = "";
		if (map.isEmpty()) {
			return rst;
		}
		OrdApBtDO[] ordApBtDOs = this.getOrdApBtDO(map);
		for (OrdApBtDO apbtdo : ordApBtDOs) {
			List<OrdSrvDO> ordSrvDOs = map.get(apbtdo.getId_or());
			FDouble quanCur = new FDouble(0);
			String srv_names = "";
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				quanCur = quanCur.add(ordSrvDO.getQuan_medu());
				srv_names += "【" + ordSrvDO.getName_srv() + "】";
			}

			if (!CiOrdUtils.isEmpty(apbtdo.getNum_margin_bu())
					&& apbtdo.getNum_margin_bu().toDouble() < quanCur.toDouble()) {
				rst = "服务项目" + srv_names + "可用血余量不足！";
				return rst;
			}
		}
		
		return rst;
	}
	
	/**
	 * 筛选出用血医疗单,用血医疗单按照同一个备血医嘱分组
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private Map<String,List<OrdSrvDO>> getTeamCiOrder(CiorderAggDO[] aggors) throws BizException{
		Map<String,List<OrdSrvDO>> map = new HashMap<String,List<OrdSrvDO>>();
		for(CiorderAggDO orAggDo : aggors){
			CiOrderDO ordo = orAggDo.getParentDO();
			if (IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE.equals(ordo.getSd_srvtp())){
				if(IBdSrvDictCodeConst.SD_RELORDTYPE_BLOOD.equals(ordo.getSd_reltp())
						&&!CiOrdUtils.isEmpty(ordo.getId_or_rel())){
					if(map.containsKey(ordo.getId_or_rel())){
						map.get(ordo.getId_or_rel()).add(orAggDo.getOrdSrvDO()[0]);
					}else{
						List<OrdSrvDO> buBtOrAggDos = new ArrayList<OrdSrvDO>();
						buBtOrAggDos.add(orAggDo.getOrdSrvDO()[0]);
						map.put(ordo.getId_or_rel(), buBtOrAggDos);
					}
				}else{
					throw new BizException("");
				}
			}
		}
		return map;
	}
	
	private OrdApBtDO[]  getOrdApBtDO(Map<String,List<OrdSrvDO>> map) throws BizException{
		Set<String> keySet = map.keySet();
		String ids = "";
		for (String key : keySet) {
			ids += ",'" + key + "'";
		}
		
		GetOrdApBtDONumQry qry = new GetOrdApBtDONumQry(ids.length() > 0 ? ids.substring(1) : ids);
		return (OrdApBtDO[])AppFwUtil.getDORstWithDao(qry, OrdApBtDO.class);
	}
}
