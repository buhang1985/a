package iih.pe.pitm.pesrvbcatlog.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeSrvbCatlogRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeSrvbCatlogDO.NAME, PeSrvbCatlogDO.PRICE, PeSrvbCatlogDO.CODE, PeSrvbCatlogDO.PYCODE, PeSrvbCatlogDO.SEXLIMIT, PeSrvbCatlogDO.FG_ENFANT, PeSrvbCatlogDO.FG_PREGNENT, PeSrvbCatlogDO.FG_MARRIED };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "价格", "编码", "检索码", "性别限制", "婴儿禁用","孕妇禁用", "未婚禁用" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvbCatlogDO.ID_PESRVBCATLOG };
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvbCatlogDO.ID_PESRVBCATLOG;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvbCatlogDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvbCatlogDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		return new PeSrvbCatlogDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeSrvbCatlogDO.ID_PEDEPTSET);
		listOrderParts.add(PeSrvbCatlogDO.SORTNO);
		return listOrderParts;
	}
	
	@Override
	public String getRefSql() {	
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select name,  price, code, Pycode,  ");
		SqlStr.append(" Sexlimit,Fg_enfant,Fg_pregnent,Fg_married,id_pesrvbcatlog ");
		SqlStr.append(" from pe_itm_pesrvbcatlog  ");
		SqlStr.append(" where 1 = 1 ");	
		SqlStr.append(" and fg_active = 'Y' ");	
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				SqlStr.append(" and (").append(where).append(") ");
			}
		}

		return SqlStr.toString();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvbCatlogDO(), ""));
		return listWhereParts;
	}
}
