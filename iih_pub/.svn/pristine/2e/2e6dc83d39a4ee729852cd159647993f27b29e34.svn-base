package iih.pi.reg.pat.refs;

import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatContDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 患者联系人标准参照模型
 * 
 * @author hao_wu
 *
 */
public class PatContRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 使用主键查询标识</br>
	 * 使用主键查询时，患者主键为空，会导致查询不到数据</br>
	 * 所以增加此标识
	 */
	private boolean _findByPksFlag = false;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PiPatContDO.NAME, PiPatContDO.CONTTEL, PiPatContDO.CONTADDR };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PiPatContDO.ID_PATCONT, PiPatContDO.SD_CONTTP, PiPatContDO.ID_CONTTP, "conttp_name",
				"id_cont", "id_cont2", PiPatContDO.ZIP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "联系人姓名", "电话", "地址" };
	}

	@Override
	public String getPkFieldCode() {
		return PiPatContDO.ID_PATCONT;
	}

	@Override
	public String getTableName() {
		return new PiPatContDO().getTableName();
	}

	@Override
	public String getRefNameField() {
		return PiPatContDO.NAME;
	}

	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		this._findByPksFlag = true;
		RefResultSet result = super.filterRefPks(filterPks);
		this._findByPksFlag = false;
		return result;
	}

	@Override
	public String getRefSql() {
		String wherePart = buildWherePart();
		String orderPart = buildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = this.buildRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return refSql;
	}

	/**
	 * 构建参照SQL
	 * 
	 * @return
	 */
	private String buildRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" select pi_pat_cont.name,");
		sqlBuilder.append(" pi_pat_cont.conttel,");
		sqlBuilder.append(" pi_pat_cont.contaddr,");
		sqlBuilder.append(" pi_pat_cont.id_patcont,");
		sqlBuilder.append(" pi_pat_cont.sd_conttp,");
		sqlBuilder.append(" pi_pat_cont.id_conttp,");
		sqlBuilder.append(" udi.name as conttp_name,");
		sqlBuilder.append(" pi_pat_cont.contid as id_cont,");
		sqlBuilder.append(" pi_pat_cont.contid as id_cont2,");
		sqlBuilder.append(" pi_pat_cont.zip");
		sqlBuilder.append("  from pi_pat_cont pi_pat_cont");
		sqlBuilder.append("  inner join pi_pat pi_pat on pi_pat_cont.id_pat = pi_pat.id_pat ");
		sqlBuilder.append(" left join bd_udidoc udi");
		sqlBuilder.append(" on pi_pat_cont.id_conttp = udi.id_udidoc");

		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			sqlBuilder.append(" where ");
			for (int i = 0; i < wherePartList.size(); i++) {
				if (i != 0) {
					sqlBuilder.append(" and ");
				}
				sqlBuilder.append(wherePartList.get(i));
			}
		}

		List<String> orderPartList = this.getOrderPart();
		if (orderPartList != null && orderPartList.size() > 0) {
			sqlBuilder.append(" order by ");
			for (int i = 0; i < orderPartList.size(); i++) {
				if (i != 0) {
					sqlBuilder.append(" , ");
				}
				sqlBuilder.append(orderPartList.get(i));
			}
		}

		return sqlBuilder.toString();
	}

	/**
	 * 构建排序片段
	 * 
	 * @return
	 */
	private String buildOrderPart() {
		StringBuilder orderPartBuilder = new StringBuilder();
		return orderPartBuilder.toString();
	}

	/**
	 * 构建条件片段
	 * 
	 * @return
	 */
	private String buildWherePart() {
		// 患者主键
		String patidStr = (String) this.getExtendAttributeValue("patid");
		// 联系人类型
		String sd_conttp = (String) this.getExtendAttributeValue("sd_conttp");
		// 亲属身份
		String sd_fmrole = (String) this.getExtendAttributeValue("sd_fmrole");

		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" and pi_pat_cont.ds = 0 and pi_pat.ds = 0");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PatDO(), "pi_pat");
		wherePartBuilder.append(String.format(" and %s ", BdModeWherePart));

		if (!StringUtil.isEmpty(patidStr)) {
			String wherePart = String.format(" and pi_pat_cont.id_pat = '%s' ", patidStr);
			wherePartBuilder.append(wherePart);
			if (!StringUtil.isEmpty(sd_conttp)) {
				wherePart = String.format(" and pi_pat_cont.sd_conttp = '%s' ", sd_conttp);
				wherePartBuilder.append(wherePart);
			}
			if (!StringUtil.isEmpty(sd_fmrole)) {
				wherePart = String.format(" and (nvl(pi_pat_cont.sd_fmrole,'~')='~' or pi_pat_cont.sd_fmrole = '%s') ",
						sd_fmrole);
				wherePartBuilder.append(wherePart);
			}
		} else if (!_findByPksFlag) {
			wherePartBuilder.append(" and 1 <> 1");
		}

		return wherePartBuilder.toString();
	}
}