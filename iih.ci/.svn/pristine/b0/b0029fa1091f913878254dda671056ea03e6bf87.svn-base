package iih.ci.ord.s.external.obtain.bp.bd;

import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据服务类型、剂型关联用法
 * @author Young
 *
 */
public class getIdroutes8DosageBP {
	public String getIdroutes(String sd_srvtp, String[] id_srvs, FBoolean isControl) throws BizException {
		StringBuilder sb = new StringBuilder("select id_route from bd_route where ds=0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedUsageDO(), "bd_route");
		sb.append(String.format(" and %s ", BdModeWherePart));
		SqlParam param = new SqlParam();
		if (sd_srvtp != null) {
			param.addParam(sd_srvtp.substring(0, 2));
			sb.append(" and sd_srvtp=? ");
			// 将剂型关联用法使用模式分为3种，1控制模式，2提醒模式，3不管理
	        // 【住院剂型关联用法管理模式】参数，参数到机构级别，默认值为1控制模式
			String paramDosage = SysParamUtils.getSysParam().getSYS_PARAM_DosageFormAssociationUsageIP().getOrgParam();
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) && id_srvs.length > 0 && (isControl.booleanValue() || "1".equals(paramDosage))) {
				String str = "";
				for (String id : id_srvs) {
					str += ",?";
					param.addParam(id);
				}
				sb.append(" and id_route in (select C.id_route from bd_srv A" 
						+ " left join bd_srv_drug B on A.id_srv=B.id_srv"
						+ " left join bd_route_dosage_ref C on B.id_dosage=C.id_dosage" 
						+ " where A.id_srv in (" + str.substring(1) + "))");
			}
		}
		sb.append(" order by code");
		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sb.toString(), param);
		String idroutes = "";
		if (sqlRst != null && sqlRst.size() > 0) {
			for (int i = 0; i < sqlRst.size(); i++) {
				idroutes += ",'" + (String) sqlRst.get(i).get("id_route") + "'";
			}
		}

		return idroutes.length() > 0 ? idroutes.substring(1) : null;
	}
}
