package iih.mi.itf2.service.bp.bdservice.drug.qry;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * his医保目录对照查询
 * Title: FindDrugCompNewSql.java
 * @author zhang.hw
 * @date 2019年5月27日  
 * @version 1.0
 */
public class FindDrugCompSql implements ITransQry {
	private String _wherePart;
	private String _hpId;
	private String _idRef;

	public FindDrugCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}
	
	public FindDrugCompSql(String idRef, String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
		this._idRef = idRef;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (this._idRef == null) {
			sqlParam.addParam(this._hpId);
		} else {
			sqlParam.addParam(this._idRef);
		}
		sqlParam.addParam(MiDirEnum.MIDIRDRUG);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);

	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append("SRVORCA.ID_HP = ?");
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append("SRVORCA.ID_MM <> '~'");
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append("MM.DS = '0'");
		wherePartBuilder.append(" AND SRVORCA.eu_hpsrvtp=? ");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT  SRVORCA.ID_HP,                              "); //  医保计划 ");
		sqlBuilder.append("             SRV.ID_SRV                  AS  ID_SRV,                          "); //  HIS医疗服务 ");
		sqlBuilder.append("             SRV.CODE                      AS  SRV_CODE,                          "); //  HIS医疗服务编码 ");
		sqlBuilder.append("             SRV.NAME                      AS  SRV_NAME,                          "); //  HIS医疗服务名称 ");
		sqlBuilder.append("             SRV_UNIT.NAME            AS  SRV_UNIT,                          "); //  HIS医疗服务剂量单位 ");
		sqlBuilder.append("             SRV_ROUTE.NAME          AS  SRV_ROUTE,                          "); //  HIS医疗服务用法 ");
		sqlBuilder.append("             SRV.QUAN_MED              AS  SRV_QUAN,                          "); //  HIS医疗服务剂量 ");
		sqlBuilder.append("             SRV_FREQ.NAME            AS  SRV_FREQ,                          "); //  HIS医疗服务频次 ");
		sqlBuilder.append("             MM.ID_MM                      AS  ID_MM,                          "); //  HIS医疗物品 ");
		sqlBuilder.append("             MM.CODE                        AS  MM_CODE,                          "); //  HIS医疗物品编码 ");
		sqlBuilder.append("             MM.NAME                        AS  MM_NAME,                          "); //  HIS医疗物品名称 ");
		sqlBuilder.append("             UDIDOC_DOSAGE.NAME  AS  MM_DOSFORM,                          "); //  HIS医疗物品剂型 ");
		sqlBuilder.append("             MEASDOC.NAME              AS  MM_UNIT,                          "); //  HIS医疗物品单位 ");
		sqlBuilder.append("             MM.SPEC                        AS  MM_SPEC,                          "); //  HIS医疗物品规格 ");
		sqlBuilder.append("             MM.PRICE                      AS  MM_PRICE,                          "); //  HIS医疗物品价格 ");
		sqlBuilder.append("             MM.PYCODE                    AS  MM_PYCODE,                          "); //  HIS医疗物品拼音码 ");
		sqlBuilder.append("             MM.WBCODE                    AS  MM_WBCODE,                          "); //  HIS医疗物品五笔码 ");
		sqlBuilder.append("             MM_SUP.NAME                AS  MM_SUP,                          "); //  HIS医疗物品生产厂家 ");
		sqlBuilder.append("             MM_ABRD.NAME              AS  MM_ABRD,                          "); //  HIS医疗物品进口分类 ");
		sqlBuilder.append("             MM_ABRD.CODE              AS  MM_SD_ABRD,                          "); //  HIS医疗物品进口分类编码 ");
		sqlBuilder.append("             MM.FG_OTC                    AS  MM_FG_OTC,                          "); //  HIS医疗物品OTC标志 ");
		sqlBuilder.append("             MM.APPRNO                    AS  MM_APPRNO,                          "); //  HIS医疗物品批准文号 ");
		sqlBuilder.append("				MM.FACTOR_SB				AS MM_FACTOR_SB,			");	//换算系数_零基
		sqlBuilder.append("				MM.PLACE				AS MM_PLACE,			");	//地址
		sqlBuilder.append("             SRVORCA.CODE  AS  MI_CODE,                                  "); //  医保药品编码 ");
		sqlBuilder.append("             SRVORCA.NAME  AS  MI_NAME,                                  "); //  医保药品通用名称 ");
		sqlBuilder.append("             SRVORCA.ID_HPSRVORCA,                              "); //  医保计划服务或分类主键 ");
		sqlBuilder.append("             SRVORCA.EU_HPSRVTP,                              "); //  医保项目类别 ");
		sqlBuilder.append("             SRVORCA.EU_STATUS  AS  EU_STATUS                          "); //  目录对照状态 ");
		sqlBuilder.append("         FROM  BD_HP_SRVORCA  SRVORCA ");
		sqlBuilder.append("         LEFT  JOIN  BD_MM  MM ");
		sqlBuilder.append("         ON  SRVORCA.ID_MM  =  MM.ID_MM  AND  MM.DS  =  0 ");
		sqlBuilder.append("         LEFT  JOIN  BD_SRV  SRV ");
		sqlBuilder.append("         ON  SRV.ID_SRV  =  SRVORCA.ID_SRV  AND  SRV.DS  =  0 ");
		sqlBuilder.append("         LEFT  JOIN  BD_MEASDOC  MEASDOC ");
		sqlBuilder.append("         ON  MEASDOC.ID_MEASDOC  =  MM.ID_UNIT_PKGSP ");
		sqlBuilder.append("         LEFT  JOIN  BD_SRV_DRUG  SRV_DRUG ");
		sqlBuilder.append("         ON  SRV.ID_SRV  =  SRV_DRUG.ID_SRV ");
		sqlBuilder.append("         LEFT  JOIN  BD_UDIDOC  UDIDOC_DOSAGE ");
		sqlBuilder.append("         ON  UDIDOC_DOSAGE.ID_UDIDOC  =  SRV_DRUG.ID_DOSAGE ");
		sqlBuilder.append("         LEFT  JOIN  BD_MEASDOC  SRV_UNIT ");
		sqlBuilder.append("         ON  SRV_UNIT.ID_MEASDOC  =  SRV.ID_UNIT_MED ");
		sqlBuilder.append("         LEFT  JOIN  BD_ROUTE  SRV_ROUTE ");
		sqlBuilder.append("         ON  SRV_ROUTE.ID_ROUTE  =  SRV.ID_ROUTE ");
		sqlBuilder.append("         LEFT  JOIN  BD_FREQ  SRV_FREQ ");
		sqlBuilder.append("         ON  SRV_FREQ.ID_FREQ  =  SRV.ID_FREQ ");
		sqlBuilder.append("         LEFT  JOIN  BD_SUP  MM_SUP ");
		sqlBuilder.append("         ON  MM_SUP.ID_SUP  =  MM.ID_SUP ");
		sqlBuilder.append("         LEFT  JOIN  BD_UDIDOC  MM_ABRD ");
		sqlBuilder.append("         ON  MM_ABRD.ID_UDIDOC  =  MM.ID_ABRD ");			

		return sqlBuilder.toString();
	}
}
