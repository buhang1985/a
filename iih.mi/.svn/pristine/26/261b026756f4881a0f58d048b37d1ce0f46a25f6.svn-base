package iih.mi.mibd.srvfacdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.srvfac.d.SrvfacDO;
import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * @author hexx
 * @version 创建时间：2018年2月6日 上午9:54:38 服务设施查询sql
 */
public class FindSrvfacCompsql implements ITransQry {

	private String _wherePart;
	private String _mis_id;

	public FindSrvfacCompsql(String mis_id, String wherePart) {
		this._wherePart = wherePart;
		this._mis_id = mis_id;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(DirCompState.NOT_COMP);
		sqlParam.addParam(this._mis_id);
		sqlParam.addParam(this._mis_id);
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

		String wherePart = String.format(" AND BD_SRV.SD_SRVTP NOT LIKE '%s%%'", IBdSrvDictCodeConst.SD_SRVTP_DRUG);
		wherePartBuilder.append(wherePart);

		wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT                                             ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.ID_COMP_SRVFAC AS ID_SRVFACCOMP, ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.ID_GRP,                          ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.ID_ORG,                          ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.ID_MIS,                          ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.CODE AS CODE,                    ");
		sqlBuilder.append("DECODE(MI_BD_COMP_SRVFAC.CODE,NULL,?,	      ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.EU_STATUS) AS EU_STATUS,         ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.DT_APPROVED,                     ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.CREATEDBY,                       ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.CREATEDTIME,                     ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.MODIFIEDBY,                      ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.MODIFIEDTIME,                    ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.DS,                              ");
		sqlBuilder.append("MI_BD_COMP_SRVFAC.SV,                              ");
		
		sqlBuilder.append("BD_SRV.ID_SRV AS ID_SRV,     			");
		sqlBuilder.append("BD_SRV.NAME AS SRV_NAME,                           ");
		sqlBuilder.append("BD_SRV.CODE AS SRV_CODE,				");
		sqlBuilder.append("BD_SRV.PRI AS SRV_PRICE,                           ");
		sqlBuilder.append("MEASDOC.NAME AS SRV_UNIT,                          ");
		
		sqlBuilder.append("MI_BD_SRVFAC.NAME AS NAME, ");
		sqlBuilder.append("MI_BD_SRVFAC.EU_FEELEVEL AS EU_FEELEVEL,           ");
		sqlBuilder.append("MI_BD_SRVFAC.PRI_MAX AS PRI_MAX    		      ");
		
		sqlBuilder.append("FROM BD_SRV                                       ");
		sqlBuilder.append("LEFT JOIN MI_BD_COMP_SRVFAC                        ");
		sqlBuilder.append("ON BD_SRV.ID_SRV = MI_BD_COMP_SRVFAC.ID_SRV        ");
		sqlBuilder.append("AND MI_BD_COMP_SRVFAC.ID_MIS=? 		      ");
		
		String wherePart = BdEnvContextUtil.processEnvContext(new SrvFacDirCompDO(), "MI_BD_COMP_SRVFAC");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		sqlBuilder.append("LEFT JOIN MI_BD_SRVFAC                             ");
		sqlBuilder.append("ON MI_BD_COMP_SRVFAC.CODE = MI_BD_SRVFAC.CODE      ");
		sqlBuilder.append("AND MI_BD_SRVFAC.ID_MIS=?                          ");
		
		wherePart = BdEnvContextUtil.processEnvContext(new SrvfacDO(), "MI_BD_SRVFAC");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		sqlBuilder.append("LEFT JOIN BD_MEASDOC MEASDOC                       ");
		sqlBuilder.append("ON MEASDOC.ID_MEASDOC = BD_SRV.ID_UNIT_MED;      ");
		
		wherePart = BdEnvContextUtil.processEnvContext(new MeasDocDO(), "MEASDOC");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		
		return sqlBuilder.toString();
	}

}
