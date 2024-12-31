package iih.bd.srv.medsrv.refs;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 医疗服务扼要信息参照
 * 
 * @author yank
 * @author hao_wu 2019-4-22 迭代参照模型修正价格不正确的问题
 *
 */
public class MedSrvBriefRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 5206810933731517976L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.MNECODE, MedSrvDO.PRI };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP, MedSrvDO.SD_SRVTP, MedSrvDO.FG_ACTIVE, MedSrvDO.NOTE,
				MedSrvDO.PYCODE, MedSrvDO.WBCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务名称", "编码", "助记码", "价格" };
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT BD_SRV.NAME,");
		sqlBuilder.append("BD_SRV.CODE,");
		sqlBuilder.append("BD_SRV.MNECODE,");
		sqlBuilder.append("PRICEVIEW.PRICE_STD AS PRI,");
		sqlBuilder.append("BD_SRV.ID_SRV,");
		sqlBuilder.append("BD_SRV.ID_SRVTP,");
		sqlBuilder.append("BD_SRV.SD_SRVTP,");
		sqlBuilder.append("BD_SRV.FG_ACTIVE,");
		sqlBuilder.append("BD_SRV.NOTE,");
		sqlBuilder.append("BD_SRV.PYCODE,");
		sqlBuilder.append("BD_SRV.WBCODE ");
		sqlBuilder.append("FROM BD_SRV ");
		sqlBuilder.append("LEFT JOIN VIEW_PRICE_RP PRICEVIEW ");
		sqlBuilder.append("ON PRICEVIEW.id_pripat = '@@@@Z8100000002YL8PO' ");
		sqlBuilder.append("AND PRICEVIEW.ID_MM = '~' ");
		sqlBuilder.append("AND BD_SRV.ID_SRV = PRICEVIEW.ID_SRV ");
		return sqlBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new MedSrvDO();
	}
}
