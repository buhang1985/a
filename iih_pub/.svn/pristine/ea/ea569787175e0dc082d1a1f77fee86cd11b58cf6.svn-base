package iih.en.pv.entcont.ref;

import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.desc.EntContDODesc;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 就诊联系人参照模型
 * 
 * @author zhengcm
 * @date 2016-07-21 11:23:31
 *
 */
public class EntContRefModel extends RefGridModel {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 5557170085589084337L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { EntContDO.NAME, EntContDO.CONTTEL, EntContDO.CONTADDR };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EntContDO.ID_ENTCONT, EntContDO.SD_CONTTP, EntContDO.ID_CONTTP, "conttp_name",
				EntContDO.ID_IDTP, EntContDO.SD_IDTP, "name_idtp", EntContDO.IDCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "联系人姓名", "电话", "地址" };
	}

	@Override
	public String getPkFieldCode() {
		return EntContDO.ID_ENTCONT;
	}

	@Override
	public String getTableName() {
		return new EntContDO().getTableName();
	}

	@Override
	public String getRefNameField() {
		return EntContDO.NAME;
	}

	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		// 增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new EntContDODesc(), "en_ent_cont"));
		return whereParts;
	}

	@Override
	public String getRefSql() {
		String entidStr = (String) this.getExtendAttributeValue("entid");
		StringBuilder str = new StringBuilder();
		str.append(" select en_ent_cont.name,");
		str.append(" en_ent_cont.conttel,");
		str.append(" en_ent_cont.contaddr,");
		str.append(" en_ent_cont.id_entcont,");
		str.append(" en_ent_cont.sd_conttp,");
		str.append(" en_ent_cont.id_conttp,");
		str.append(" udi.name as conttp_name,");
		str.append(" en_ent_cont.id_idtp,");
		str.append(" en_ent_cont.sd_idtp,");
		str.append(" udi2.name as name_idtp,");
		str.append(" en_ent_cont.idcode ");

		str.append("  from en_ent_cont en_ent_cont");

		str.append(" left join bd_udidoc udi");
		str.append(" on en_ent_cont.id_conttp = udi.id_udidoc");
		str.append(" left join bd_udidoc udi2 on en_ent_cont.id_idtp = udi2.id_udidoc");
		if (!StringUtil.isEmpty(entidStr)) {
			str.append(" where en_ent_cont.id_ent = '");
			str.append(entidStr);
			str.append("'");
		} else if (!ListUtil.isEmpty(this.getWherePart())) {
			str.append(" where 1=1 ");
		}
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				if (!StringUtil.isEmptyWithTrim(where)) {
					str.append(" And (").append(where).append(") ");
				}
			}
		}

		return str.toString();
	}
}