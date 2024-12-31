package iih.bd.pp.cust.refs;

import java.util.List;

import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.d.CustDO;
import iih.bd.pp.cust.d.desc.CustDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PriCustRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { CustDO.CODE, CustDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CustDO.ID_CUST, CustDO.ID_CUSTCA, CustCaDO.ID_CUSTTP, CustCaDO.SD_CUSTTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return CustDO.ID_CUST;
	}

	@Override
	public String getRefCodeField() {
		return CustDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CustDO.NAME;
	}

	@Override
	public String getTableName() {
		return CustDODesc.TABLE_NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CustDO.CODE, CustDO.NAME, CustDO.MNECODE, CustDO.PYCODE, CustDO.WBCODE };
	}

	@Override
	public String getRefSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("select bd_cust.code as code,");
		sb.append("bd_cust.name as name,");
		sb.append("bd_cust.id_cust as id_cust,");
		sb.append("bd_cust.id_custca as id_custca,");
		sb.append("bd_custca.id_custtp as id_custtp,");
		sb.append("bd_custca.sd_custtp as sd_custtp,");
		sb.append("bd_cust.mnecode as mnecode,");
		sb.append("bd_cust.pycode as pycode,");
		sb.append("bd_cust.wbcode as wbcode ");
		sb.append("from bd_cust bd_cust inner join bd_custca bd_custca on bd_cust.id_custca = bd_custca.id_custca ");
		sb.append("where 1 = 1 ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				sb.append(" and (").append(where).append(") ");
			}
		}

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CustDO(), "bd_cust");
		sb.append(String.format(" and %s ", BdModeWherePart));

		sb.append("order by bd_cust.code ");
		return sb.toString();
	}
}
