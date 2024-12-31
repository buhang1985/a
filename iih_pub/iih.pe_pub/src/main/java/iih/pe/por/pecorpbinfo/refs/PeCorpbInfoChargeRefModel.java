package iih.pe.por.pecorpbinfo.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeCorpbInfoChargeRefModel extends RefGridModel {

	/**
	 * 团体账单参照(团检收费)
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeCorpbInfoDO.NAME, PeCorpbInfoDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeCorpbInfoDO.ID_CUST};
	}

	@Override
	public String getPkFieldCode() {
		return PeCorpbInfoDO.ID_CUST;
	}
	
	@Override
	public String getRefCodeField() {
		return PeCorpbInfoDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeCorpbInfoDO.NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { PeCorpbInfoDO.CODE, PeCorpbInfoDO.NAME, PeCorpbInfoDO.PYCODE};
	}
	
	
	@Override
	public String getTableName() {
		return new PeCorpbInfoDO().getTableName();
	}
	
	@Override
	public String getRefSql() {	
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select pe_or_pecorpbinfo.name,  pe_or_pecorpbinfo.code, pe_or_pecorpbinfo.id_cust, pe_or_pecorpbinfo.id_pecorpbinfo from pe_or_pecorpbinfo pe_or_pecorpbinfo ");
		SqlStr.append(" inner join pe_apt_pecorpappt apt on pe_or_pecorpbinfo.id_pecorpbinfo =apt.id_pecorpbinfo ");
		SqlStr.append(" inner join pe_or_pecorpcharge c on apt.ID_PECORPAPPT =c.ID_PECORPAPPT ");
		SqlStr.append(" WHERE 1 = 1 ");	
		SqlStr.append(" and c.fg_charged = 'N' ");	
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				SqlStr.append(" And (").append(where).append(") ");
			}
		}

		return SqlStr.toString();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeCorpbInfoDO(), " pe_or_pecorpbinfo "));
		return listWhereParts;
	}


	
}
