package iih.bd.pp.baseprisrv.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.SqlParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询基础价格服务
 * 
 * @author hao_wu 2019-8-19
 *
 */
public class FindPriSrvQry implements ITransQry {

	private String _whereStr;
	private SqlParamDTO _sqlParamDTO;
	private String _orderStr;

	public FindPriSrvQry(String whereStr, SqlParamDTO sqlParamDTO, String orderStr) {
		this._whereStr = whereStr;
		this._sqlParamDTO = sqlParamDTO;
		this._orderStr = orderStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (this._sqlParamDTO != null && this._sqlParamDTO.getCountParams() > 0) {
			for (int i = 0; i < this._sqlParamDTO.getCountParams(); i++) {
				sqlParam.addParam(this._sqlParamDTO.get(i));
			}
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" where ");
		sqlBuilder.append(wherePart);

		if (StringUtils.isNotBlank(this._orderStr)) {
			sqlBuilder.append(" order by ");
			sqlBuilder.append(this._orderStr);
		}
		return sqlBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT bd_srv.id_Srv,");
		sqlBuilder.append("bd_srv.id_grp,");
		sqlBuilder.append("bd_Srv.id_org,");
		sqlBuilder.append("bd_Srv.id_srvtp,");
		sqlBuilder.append("srvtp.name AS name_srvtp,");
		sqlBuilder.append("bd_Srv.sd_srvtp,");
		sqlBuilder.append("bd_Srv.id_Srvca,");
		sqlBuilder.append("bd_srvca.name AS name_srvca,");
		sqlBuilder.append("bd_Srv.code,");
		sqlBuilder.append("bd_Srv.name,");
		sqlBuilder.append("bd_Srv.pycode,");
		sqlBuilder.append("bd_Srv.wbcode,");
		sqlBuilder.append("bd_Srv.mnecode,");
		sqlBuilder.append("bd_Srv.shortname,");
		sqlBuilder.append("bd_Srv.des_pri as des,");
		sqlBuilder.append("bd_Srv.ID_UNIT_MED,");
		sqlBuilder.append("bd_measdoc.name AS name_unit_med,");
		sqlBuilder.append("bd_Srv.id_primd,");
		sqlBuilder.append("bd_pri.name AS name_primd,");
		sqlBuilder.append("bd_Srv.sd_primd,");
		sqlBuilder.append("bd_pri_srv.PRICE AS pri,");
		sqlBuilder.append("bd_Srv.EU_BLMD,");
		sqlBuilder.append("bd_Srv.FG_ACTIVE_BL as FG_ACTIVE,");
		sqlBuilder.append("incca_op.ID_INCCAITM AS id_incca_op,");
		sqlBuilder.append("incca_itm_op.name AS name_incca_op,");
		sqlBuilder.append("incca_ip.ID_INCCAITM AS id_incca_ip,");
		sqlBuilder.append("incca_itm_ip.name AS name_incca_ip,");
		sqlBuilder.append("bd_srv.id_pritp,");
		sqlBuilder.append("bd_Srv.SD_PRITP,");
		sqlBuilder.append("pritp.name AS name_pritp,");
		sqlBuilder.append("acc_op.ID_ACCOUNTCA AS id_acc_op,");
		sqlBuilder.append("acc_op.name AS name_acc_op,");
		sqlBuilder.append("acc_ip.ID_ACCOUNTCA AS id_acc_ip,");
		sqlBuilder.append("acc_ip.name AS name_acc_ip,");
		sqlBuilder.append("acc_share.ID_ACCOUNTCA AS id_acc_share,");
		sqlBuilder.append("acc_share.name AS name_acc_share,");
		sqlBuilder.append("bd_Srv.CREATEDBY,");
		sqlBuilder.append("bd_Srv.CREATEDTIME,");
		sqlBuilder.append("bd_Srv.MODIFIEDBY,");
		sqlBuilder.append("bd_Srv.MODIFIEDTIME,");
		sqlBuilder.append("CODE_EXSTD.CODE AS CODE_EXSTD,");
		sqlBuilder.append("bd_Srv.DEF1,");
		sqlBuilder.append("bd_Srv.DEF2,");
		sqlBuilder.append("bd_Srv.DEF3,");
		sqlBuilder.append("bd_Srv.DEF4,");
		sqlBuilder.append("bd_Srv.DEF5,");
		sqlBuilder.append("bd_Srv.DEF6,");
		sqlBuilder.append("bd_Srv.DEF7,");
		sqlBuilder.append("bd_Srv.DEF8,");
		sqlBuilder.append("bd_Srv.DEF9,");
		sqlBuilder.append("bd_Srv.DEF10,");
		sqlBuilder.append("bd_Srv.ds,");
		sqlBuilder.append("bd_Srv.sv ");
		sqlBuilder.append("FROM bd_Srv ");
		sqlBuilder.append("LEFT JOIN bd_udidoc srvtp ");
		sqlBuilder.append("ON srvtp.id_udidoc = bd_Srv.id_srvtp ");
		sqlBuilder.append("LEFT JOIN bd_srvca ");
		sqlBuilder.append("ON bd_srvca.ID_SRVCA = bd_Srv.ID_SRVCA ");
		sqlBuilder.append("LEFT JOIN bd_pri ");
		sqlBuilder.append("ON bd_srv.id_primd = bd_pri.id_pri ");
		sqlBuilder.append("LEFT JOIN bd_measdoc ");
		sqlBuilder.append("ON bd_measdoc.id_measdoc = bd_Srv.ID_UNIT_MED ");
		sqlBuilder.append("LEFT JOIN bd_pri_srv ");
		sqlBuilder.append("ON bd_pri_srv.ds = 0 ");
		sqlBuilder.append("AND bd_pri_srv.DT_E = '2099-12-31 23:59:59' ");
		sqlBuilder.append("AND bd_pri_srv.id_srv = bd_Srv.id_srv ");
		sqlBuilder.append("LEFT JOIN BD_INCCA_ITM_REL incca_op ");
		sqlBuilder.append("ON incca_op.SD_INCCA = '11' ");
		sqlBuilder.append("AND incca_op.id_srv = bd_srv.id_srv ");
		sqlBuilder.append("LEFT JOIN BD_INCCA_ITM incca_itm_op ");
		sqlBuilder.append("ON incca_itm_op.SD_INCCA = '11' ");
		sqlBuilder.append("AND incca_itm_op.ID_INCCAITM = incca_op.ID_INCCAITM ");
		sqlBuilder.append("LEFT JOIN BD_INCCA_ITM_REL incca_ip ");
		sqlBuilder.append("ON incca_ip.SD_INCCA = '12' ");
		sqlBuilder.append("AND incca_ip.id_srv = bd_srv.id_srv ");
		sqlBuilder.append("LEFT JOIN BD_INCCA_ITM incca_itm_ip ");
		sqlBuilder.append("ON incca_itm_ip.SD_INCCA = '12' ");
		sqlBuilder.append("AND incca_itm_ip.ID_INCCAITM = incca_ip.ID_INCCAITM ");
		sqlBuilder.append("LEFT JOIN bd_udidoc pritp ");
		sqlBuilder.append("ON pritp.ID_UDIDOC = bd_srv.id_pritp ");
		sqlBuilder.append("LEFT JOIN BD_ACCOUNT_CA_VS_SRV acc_rel_op ");
		sqlBuilder.append("ON acc_rel_op.ID_ACCOUNT = '@@@@Z8100000000820L6' ");
		sqlBuilder.append("AND acc_rel_op.id_srv = bd_Srv.id_srv ");
		sqlBuilder.append("LEFT JOIN BD_ACCOUNT_CA acc_op ");
		sqlBuilder.append("ON acc_op.ID_ACCOUNT = '@@@@Z8100000000820L6' ");
		sqlBuilder.append("AND acc_op.ID_ACCOUNTCA = acc_rel_op.ID_ACCOUNTCA ");
		sqlBuilder.append("LEFT JOIN BD_ACCOUNT_CA_VS_SRV acc_rel_ip ");
		sqlBuilder.append("ON acc_rel_ip.ID_ACCOUNT = '@@@@Z8100000000820L8' ");
		sqlBuilder.append("AND acc_rel_ip.id_srv = bd_Srv.id_srv ");
		sqlBuilder.append("LEFT JOIN BD_ACCOUNT_CA acc_Ip ");
		sqlBuilder.append("ON acc_Ip.ID_ACCOUNT = '@@@@Z8100000000820L8' ");
		sqlBuilder.append("AND acc_ip.ID_ACCOUNTCA = acc_rel_ip.ID_ACCOUNTCA ");
		sqlBuilder.append("LEFT JOIN BD_ACCOUNT_CA_VS_SRV acc_rel_share ");
		sqlBuilder.append("ON acc_rel_share.ID_ACCOUNT = '@@@@Z8100000000820L5' ");
		sqlBuilder.append("AND acc_rel_share.id_srv = bd_Srv.id_srv ");
		sqlBuilder.append("LEFT JOIN BD_ACCOUNT_CA acc_share ");
		sqlBuilder.append("ON acc_share.ID_ACCOUNT = '@@@@Z8100000000820L5' ");
		sqlBuilder.append("AND acc_share.ID_ACCOUNTCA = acc_rel_share.ID_ACCOUNTCA ");
		sqlBuilder.append("LEFT JOIN BD_SRV_CODE CODE_EXSTD ");
		sqlBuilder.append("ON CODE_EXSTD.ID_SRV = bd_Srv.ID_SRV ");

		String str = String.format("AND CODE_EXSTD.SD_CDSTD = '%s'", IBdSrvDictCodeConst.SD_CDSTD_PRICE_PRICE);
		sqlBuilder.append(str);
		return sqlBuilder.toString();
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("bd_srv.ds = 0 and bd_srv.sd_primd = '%s'", IBdPrimdCodeConst.CODE_PRI_SRV);
		wherePartBuilder.append(wherePart);

		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), false);
		if (StringUtils.isNotBlank(bdModeWherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(bdModeWherePart);
		}

		if (StringUtils.isNotBlank(this._whereStr)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(this._whereStr);
		}

		return wherePartBuilder.toString();
	}

}
