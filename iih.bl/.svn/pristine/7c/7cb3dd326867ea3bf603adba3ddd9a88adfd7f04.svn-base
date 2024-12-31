package iih.bl.st.opfeeout.bp.qry;

import iih.bl.hp.trade.d.EuHpDrugNameType;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetblStCgInfoDtosQry implements ITransQry {

	List<String> id_stoeps;
	String drugName;

	/**
	 * 获取收费明细信息
	 * 
	 * @param ID_STOEPs
	 * @param 药品名称类型
	 * @throws BizException
	 * @author liwenqiang 2017.11.27
	 */
	public GetblStCgInfoDtosQry(List<String> ID_STOEPs,String drugName) throws BizException {
		this.id_stoeps = ID_STOEPs;
		this.drugName=drugName;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		for (String id_stoep : id_stoeps) {
			param.addParam(id_stoep);
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" ST.ID_STOEP id_stoep, ");
		sql.append(" ST.code_st code_stoep,");
		sql.append(" '' srvno, ");
		sql.append(" ENTOP.TICKETNO||cgItm.CODE_APPLY id_pres, ");
		sql.append(" CASE cgItm.FG_MM WHEN 'Y' THEN cgItm.CODE_MM ELSE cgItm.CODE_SRV END code_his,");
		if(drugName.equals(EuHpDrugNameType.MMNAME)){//显示物品名
			sql.append(" CASE cgItm.FG_MM WHEN 'Y' THEN cgItm.NAME_MM ELSE cgItm.NAME_SRV END name_his,");
		}else if(drugName.equals(EuHpDrugNameType.SRVNAME)){//显示服务名
			sql.append("  cgItm.NAME_SRV name_his,");
		}
		sql.append(" SRVORCA.code code_srv_hp, ");
		sql.append(" SRVORCA.name name_srv_hp, ");
		sql.append(" CASE cgItm.FG_MM WHEN 'Y' THEN '0' ELSE '1' END type_srv, ");
		sql.append(" SRVORCA.code_dosage dosage, ");
		sql.append(" cgItm.spec spec,");
		sql.append(" measdoc_cur.name company,");
		sql.append(" CASE when (cgItm.QUAN- FLOOR(cgItm.QUAN))<>0 THEN cgItm.price*cgItm.QUAN ELSE cgItm.price END price, ");
		sql.append(" CASE when (cgItm.QUAN- FLOOR(cgItm.QUAN))<>0 THEN 1 ELSE cgItm.QUAN END quan,");
		sql.append(" cgItm.AMT amt,");
		sql.append(" freq.code_hp USAGE,");
		sql.append(" SRV.quan_medu single, ");
		sql.append(" measdoc_cur.name packaging, ");
		sql.append(" measdoc_base.name minpackaging, ");
		sql.append(" cgItm.factor conversion,");
		sql.append(" CIORDER.DAYS_OR days, ");
		sql.append(" cgItm.dt_or dt_or,");
		sql.append(" SRVORCA.code_ca type_fee, ");
		sql.append(" NVL(cgItm.SD_HPSRVTP, '3') level_fee,");
		sql.append(" dep.code code_category, ");
		sql.append(" dep.name name_category, ");
		sql.append(" '' name_category_court, ");
		sql.append(" psndoc.name name_physician ");
		sql.append(" FROM BL_CG_ITM_OEP cgItm");
		sql.append(" INNER JOIN BL_ST_OEP st ON cgItm.ID_STOEP=ST.ID_STOEP ");
		sql.append(" INNER JOIN EN_ENT_OP ENTOP ON ENTOP.ID_ENT=cgItm.ID_ENT ");
		sql.append(" LEFT JOIN BD_HP_SRVORCA SRVORCA ON cgItm.id_srv=SRVORCA.id_srv");
		sql.append(" LEFT JOIN CI_OR_SRV SRV ON cgItm.id_orsrv=SRV.id_orsrv");
		sql.append(" LEFT JOIN BD_DEP dep ON dep.id_dep=cgItm.id_dep_or");
		sql.append(" LEFT JOIN CI_ORDER CIORDER ON CIORDER.id_or=SRV.id_or ");
		sql.append(" LEFT JOIN BD_HP_FREQ freq ON freq.ID_FREQ=CIORDER.ID_FREQ ");
		sql.append(" LEFT JOIN BD_PSNDOC psndoc ON psndoc.id_psndoc=cgItm.id_emp_or");
		sql.append(" LEFT JOIN BD_ROUTE route ON route.id_route=SRV.id_route ");
		sql.append(" LEFT JOIN BD_MEASDOC measdoc_cur ON measdoc_cur.id_measdoc=cgItm.pgku_cur ");
		sql.append(" LEFT JOIN BD_MEASDOC measdoc_base ON measdoc_base.id_measdoc=cgItm.pgku_base");
		sql.append(" LEFT JOIN CI_OR_SRV_MM MM ON MM.id_orsrv=SRV.id_orsrv ");
		sql.append(" LEFT JOIN BD_UDIDOC udidoc ON udidoc.id_udidoc=MM.id_dosage ");
		sql.append(" WHERE ST.eu_direct = '1'");
		sql.append(" AND ST.ID_STOEP IN( ");
		for (String id_stoep : this.id_stoeps) {
			sql.append("?,");
		}
		sql.append("'0') ");
		return sql.toString();
	}

}
