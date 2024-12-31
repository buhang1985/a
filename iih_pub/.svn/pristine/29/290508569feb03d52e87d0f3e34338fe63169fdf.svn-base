package iih.bd.pp.hp.refs;

import java.util.List;

import iih.bd.pp.hp.d.BdHpKindDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医保计划险种参照模型
 * @author ly 2017/06/26
 *
 */
public class HpKindRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpKindDO.CODE_HPKIND, BdHpKindDO.NAME_HPKIND };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpKindDO.ID_HPKIND };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdHpKindDO.CODE_HPKIND, BdHpKindDO.NAME_HPKIND, BdHpKindDO.PYCODE, BdHpKindDO.WBCODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return BdHpKindDO.ID_HPKIND;
	}

	@Override
	public String getRefCodeField() {
		return BdHpKindDO.CODE_HPKIND;
	}

	@Override
	public String getRefNameField() {
		return BdHpKindDO.NAME_HPKIND;
	}

	@Override
	public String getTableName() {
		return new BdHpKindDO().getTableName();
	}
	
	@Override
	public String getRefSql() {
		
		String id_hp = (String) this.getExtendAttributeValue("id_hp");
		
		String whereSql = "";
		if(!StringUtil.isEmpty(id_hp)){
			whereSql = "id_hp = '" + id_hp + "'";
		}
		
		String sql = "select code_hpkind,name_hpkind,id_hpkind from bd_hp_kind "
				+ "where ds = 0 ";
		
		if(!StringUtil.isEmpty(whereSql)){
			sql += "and " + whereSql;
		}
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		
		boolean containId = false;
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				
				if(where.toUpperCase().contains("ID_HPKIND")){
					containId = true;
				}
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		if(!containId && StringUtil.isEmpty(whereSql)){
			sb.append(" and 1<>1 ");
		}
		
		sb.append(" order by code_hpkind ");

		return sb.toString();		
	}
}
