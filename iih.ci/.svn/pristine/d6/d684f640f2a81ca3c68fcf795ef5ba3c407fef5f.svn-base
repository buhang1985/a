package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.GetOrdApBtDONumQry;

/**
 * 用血签署更新对应备血可用血余量
 * @author Administrator
 *
 */
public class UseBtOrNumMarginBuUpdateBP {

	public void exec(CiOrderDO[] ciors, boolean flag) throws BizException{
		Map<String, String> map = this.getIdorsBt(ciors);
		if (map.isEmpty()) {
			return;
		}
		OrdApBtDO[] ordApBtDOs = this.getOrdApBtDO(map);
		List<OrdApBtDO> lst = new ArrayList<OrdApBtDO>();
		for (OrdApBtDO apbtdo : ordApBtDOs) {
			String idors = map.get(apbtdo.getId_or());
			FDouble quan = this.getBuQuanTotal(idors);
			if (quan.getDouble() > 0) {
				apbtdo.setNum_margin_bu(flag ? apbtdo.getNum_margin_bu().sub(quan) 
						: apbtdo.getNum_margin_bu().add(quan));
				apbtdo.setStatus(DOStatus.UPDATED);
				lst.add(apbtdo);
			}
		}
		if (lst.size() > 0) {
			String[] arrayFieldNames = new String[] { OrdApBtDO.NUM_MARGIN_BU };
			new DAFacade().updateDOArray(lst.toArray(new OrdApBtDO[lst.size()]), arrayFieldNames);
		}
	}
	
	/**
	 * 筛选出用血医嘱，用血医嘱按照同一个备血医嘱分组
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> getIdorsBt(CiOrderDO[] ciors)
			throws BizException {
		Map<String, String> map = new HashMap<String, String>();
		for (CiOrderDO cior : ciors) {
			if (IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE.equals(cior.getSd_srvtp())) {
				if (IBdSrvDictCodeConst.SD_RELORDTYPE_BLOOD.equals(cior.getSd_reltp())
						&& !CiOrdUtils.isEmpty(cior.getId_or_rel())) {
					if (map.containsKey(cior.getId_or_rel())) {
						map.put(cior.getId_or_rel(), map.get(cior.getId_or_rel()) + ",'" + cior.getId_or() + "'");
					} else {
						map.put(cior.getId_or_rel(), "'" + cior.getId_or() + "'");
					}
				} else {
					throw new BizException("");
				}
			}
		}
		return map;
	}
	
	private OrdApBtDO[]  getOrdApBtDO(Map<String,String> map) throws BizException{
		Set<String> keySet = map.keySet();
		String ids = "";
		for (String key : keySet) {
			ids += ",'" + key + "'";
		}
		GetOrdApBtDONumQry qry = new GetOrdApBtDONumQry(ids.length() > 0 ? ids.substring(1) : ids);
		return (OrdApBtDO[])AppFwUtil.getDORstWithDao(qry, OrdApBtDO.class);
	}

	/**
	 * 查询一组用血总量
	 * @param idors
	 * @return
	 * @throws DAException
	 */
	private FDouble getBuQuanTotal(String idors) throws DAException {
		String sql = "select sum(quan_medu) as quan from ci_or_srv where sd_srvtp='"
				+ IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE + "' and id_or in (" + idors + ")";

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> rst = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sql, new MapListHandler());

		return new FDouble(rst.get(0).get("quan").toString());
	}
}
