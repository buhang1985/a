package iih.bd.srv.medsrv.refs;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvAttrMaping;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.refinfo.RefGridModel;

public class MedsrvRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.FG_MM, MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP, MedSrvDO.FG_OR, MedSrvDO.FG_ACTIVE,
				MedSrvDO.QUAN_MED, MedSrvDO.ID_UNIT_MED, MedSrvDO.FG_SET, MedSrvDO.ID_SRVCA, MedSrvDO.SD_SRVTP,
				MedSrvDO.PRI, MedSrvDO.DS, MedSrvDO.SHORTNAME, MedSrvDO.FG_CTM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务名称", "编码", "助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return MedSrvDO.ID_SRV;
	}

	@Override
	public String getRefCodeField() {
		return MedSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MedSrvDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = getMedSrvSQL();

		} finally {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}
		return refSql;
	}

	/**
	 * 获得查询语句
	 * 
	 * @return
	 */
	protected String getMedSrvSQL() {
		// System.out.println(super.getRefSql());
		String sql = "select bd_srv.Name, bd_srv.Code, bd_srv.Mnecode, bd_srv.Fg_mm, bd_srv.Id_srv, bd_srv.Id_srvtp, bd_srv.Fg_or, bd_srv.Fg_active, bd_srv.Quan_med, bd_srv.Id_unit_med, bd_srv.Fg_set, bd_srv.Id_srvca, bd_srv.Sd_srvtp, bd_pri.Price_std pri , bd_srv.Ds, bd_srv.Shortname, bd_srv.Fg_ctm from bd_srv bd_srv left join view_price_rp bd_pri on bd_pri.id_pripat = '@@@@Z8100000002YL8PO' and bd_pri.id_mm = '~' and bd_srv.Id_srv = bd_pri.id_srv where 1=1";
		// String BdModeWherePart = BdEnvContextUtil.processEnvContext(new
		// MedSrvDO(), "p");
		List<String> whereParts = this.getWherePart();
		for (String wherepart : whereParts) {
			sql = sql + " and " + wherepart;
		}
		// sql = sql +this.getOrderPart();
		return sql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and bd_srv.ds = 0 ");
		stringBuilder.append(" and bd_srv.fg_active = 'Y' ");
		stringBuilder.append(
				" and (bd_srv.fg_mm = 'Y' or bd_srv.fg_bl = 'N' or ( bd_srv.fg_bl = 'Y' and bd_srv.fg_active_bl='Y')) ");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String srvtp = (String) this.getExtendAttributeValue("Sd_srvtp");
		String reactca = (String) this.getExtendAttributeValue("Sd_reactca");
		String or = (String) this.getExtendAttributeValue("Fg_or");
		String fg_mm = (String) this.getExtendAttributeValue("Fg_mm");
		String fg_bl = (String) this.getExtendAttributeValue("Fg_bl");
		String wherePart = (String) this.getExtendAttributeValue("wherePart");
		String wherePartIn = (String) this.getExtendAttributeValue("wherePartIn");
		String id_mmcainnercode = (String) this.getExtendAttributeValue("id_mmca.innercode");
		String whereStr = (String) this.getExtendAttributeValue("where");
		
		if (reactca != null && !reactca.equals("")) {
			stringBuilder.append(" and  bd_srv.sd_reactca <> '" + reactca + "'");
		}

		if (or != null && !or.equals("")) {
			stringBuilder.append(" and  bd_srv.fg_or = '" + or + "'");
		}

		if (srvtp != null && !srvtp.equals("")) {
			stringBuilder.append(" and  bd_srv.sd_srvtp like '" + srvtp + "%'");
		}

		if (fg_mm != null && !fg_mm.equals("")) {
			stringBuilder.append(String.format(" and  bd_srv.fg_mm = '%s'", fg_mm));
		}

		if (fg_bl != null && !fg_bl.equals("")) {
			stringBuilder.append(String.format(" and  bd_srv.fg_bl = '%s'", fg_bl));
		}

		if (StringUtils.isNotEmpty(wherePart)) {
			String[] stringArr = wherePart.split(",");
			String where = SqlUtils.getNotInSqlByIds("and BD_SRV.ID_SRV", stringArr);
			stringBuilder.append(where);
		}
		if (StringUtils.isNotEmpty(wherePartIn)) {
			String[] stringArr = wherePartIn.split(",");
			String wheresql = SqlUtils.getInSqlByBigIds("and BD_SRV.ID_SRV", stringArr);
			stringBuilder.append(wheresql);
		}
		if (StringUtils.isNotEmpty(id_mmcainnercode)) {
			stringBuilder.append(
					" and BD_SRV.ID_SRV in (select mm.id_srv from bd_mm mm inner join bd_mmca mmca on mm.id_mmca = mmca.id_mmca where mmca.innercode like '"
							+ id_mmcainnercode + "%') ");
		}

		if(StringUtils.isNotEmpty(whereStr)){
			stringBuilder.append(" and ");
			stringBuilder.append(whereStr);
		}
		// 需要排除的服务主键
		String excludeSrvIdsStr = (String) this.getExtendAttributeValue("id_srv_exclude");
		if (StringUtils.isNotBlank(excludeSrvIdsStr)) {
			String[] excludeSrvIds = excludeSrvIdsStr.split(",");
			if (ArrayUtils.isNotEmpty(excludeSrvIds)) {
				stringBuilder.append(" and ");
				stringBuilder.append(SqlUtils.getNotInSqlByIds("BD_SRV.ID_SRV", excludeSrvIds));
			}
		}

		// 就诊类型编码
		String entpCode = (String) this.getExtendAttributeValue("code_entp");
		if (StringUtils.isNotBlank(entpCode)) {
			String whereSql = String.format(" and bd_srv.%s = 'Y'", MedSrvAttrMaping.getUseAttrName(entpCode));
			stringBuilder.append(whereSql);
		}

		// 排除加急
		FBoolean excludeUrgent = (FBoolean) this.getExtendAttributeValue("urgent_exclude");
		if (FBoolean.TRUE.equals(excludeUrgent) && StringUtils.isNotBlank(entpCode)) {
			String whereSql = String.format(" and bd_srv.%s <> 'Y'", MedSrvAttrMaping.getUrgentAttrName(entpCode));
			stringBuilder.append(whereSql);
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MedSrvDO.CODE));
		return stringBuilder.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.PYCODE, MedSrvDO.MNECODE };
	}

	/**
	 * 获得Sql数据串（支持药品选择模式） 服务项目、助记码、参考价、描述 。。。。。
	 * 
	 * @param id_org
	 * @param code_entp
	 * @param id_hp
	 * @param inputstr
	 * @param sd_srvtp
	 * @return
	 */
	public String getMySqlStr(String id_org, String code_entp, String id_hp, String inputstr, String sd_srvtp) {
		String formatsql = "select A.Name || (case when A.fg_mm='Y'  then '[' || (case when A.Name=A1.Name then '' else A1.Name end) || ',' || A1.Spec || ']' else '' end) as name_srv,"
				+ " A.Mnecode as mnecode,(case when A.Fg_Mm='Y' then A1.Price || ''  else A.Des_Pri end) as des_pri,c1.Name || ',' || c.Des || ',' || A.Des as des,"
				+ " A.id_srv,A.Id_Srvtp as id_srvca,A1.Name as name_srvca,A.code as code_srv,A.Pycode as pycode "
				+ " from bd_srv A" + "      left outer join bd_mm A1 ON A1.Id_Srv=A.Id_Srv"
				+ "      left outer join bd_udidoc B ON A.Id_Srvtp=B.Id_Udidoc"
				+ "      left outer join bd_hp_srvorca C ON A.ID_SRV=C.Id_Srv and C.Id_Hp='" + id_hp + "'"
				+ "      left outer join bd_udidoc C1 ON C1.Id_Udidoc=C.Id_Hpsrvtp" + " where A.Id_Org='" + id_org
				+ "' and A.Fg_Or='Y' and A.Fg_Active='Y' and A.ds=0 and A.Fg_Use_" + getFgUseFld(code_entp)
				+ "='Y' and A1.Fg_Active='Y' and A1.Ds=0"
				+ "      and (A.Name like '%inputstr%' or A.Pycode like '%inputstr%' or A.WBCODE like '%inputstr%' or A.Mnecode like '%inputstr%' or A1.Name like '%inputstr%' or A1.Pycode like '%inputstr%' or A1.WBCODE like '%inputstr%' or A1.Mnecode like '%inputstr%')"
				+ "        order by A.id_srv;";

		return null;
	}

	/**
	 * 获得使用范围标识字段名
	 * 
	 * @param code_entp
	 * @return
	 */
	private String getFgUseFld(String code_entp) {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp))
			return "op";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp))
			return "ip";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp))
			return "er";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp))
			return "er1";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp))
			return "er2";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp))
			return "pe";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp))
			return "fm";

		return "";
	}

}
