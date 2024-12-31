package iih.ci.ord.s.bp;

import java.util.List;
import java.util.Map;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;

/**
 * 校验备血医嘱是否关联有效的用血医嘱
 * @author Young
 *
 */
public class UseBtContainsBuValidateBP {

	public boolean exec(CiOrderDO[] ciors) throws DAException{
		String idors = "";
		for (CiOrderDO cior : ciors) {
			if (IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE.equals(cior.getSd_srvtp())) {
				idors += ",'" + cior.getId_or() + "'";
			}
		}
		if (idors.length() <= 0)
			return false;
		
		String sql = String.format("select id_or from ci_order where fg_canc='N' and fg_pres_outp='N'"
						+ " and (eu_feereversetp is null or eu_feereversetp<>1)"
						+ " and eu_orsrcmdtp!='%s' and sd_srvtp='%s' and sd_reltp='%s' and id_or_rel in (%s)",
						OrSourceFromEnum.IIHMEDTECHORDERS,
						IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE,
						IBdSrvDictCodeConst.SD_RELORDTYPE_BLOOD,
						idors.substring(1));

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> rst = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sql, new MapListHandler());

		return rst != null && rst.size() > 0;
	}
}
