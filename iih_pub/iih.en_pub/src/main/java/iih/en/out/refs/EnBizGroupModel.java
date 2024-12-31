package iih.en.out.refs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.en.pv.pativisit.d.desc.EntContDODesc;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class EnBizGroupModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "CODE_WG", "NAME_WG","NAME_DEP" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "ID_WG" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称","科室" };
	}

	@Override
	public String getPkFieldCode() {
		return "ID_WG";
	}

	@Override
	public String getRefCodeField() {
		return "CODE_WG";
	}

	@Override
	public String getRefNameField() {
		return "NAME_WG";
	}

	@Override
	public String getTableName() {
		return "DEP_WG";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] {"CODE_WG", "NAME_WG", "WBCODE", "PYCODE","INSTR"};
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		// 增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new EntContDODesc(), "DEP_WG"));
		return whereParts;
	}
	
	@Override
	public String getRefSql() {
		String depId = (String)getExtendAttributeValue("depId");
		StringBuilder stringBuilder = new StringBuilder();
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BizGroupDO(), "DEP_WG");
		stringBuilder.append("SELECT * FROM (SELECT WG.CODE AS CODE_WG,WG.NAME AS NAME_WG,DEP.NAME AS NAME_DEP,WG.ID_WG,WG.WBCODE,WG.PYCODE,WG.INSTR,DEP.CODE AS CODE_DEP,DEP.SD_DEPTTP,DEP.FG_USE_PIP,DEP.fg_ip,DEP.DEPTPROP,WG.ID_ORG,WG.ID_GRP,WG.ID_DEP,WG.DS,WG.FG_ACTIVE,WG.SD_WGTP FROM BD_WG WG INNER JOIN BD_DEP DEP ON DEP.ID_DEP = WG.ID_DEP ) DEP_WG ");
		stringBuilder.append("WHERE 1=1 AND DEP_WG.DS = 0 AND DEP_WG.FG_ACTIVE = 'Y' ");
		stringBuilder.append(String.format(" AND %s ", BdModeWherePart));
		if(!StringUtils.isEmpty(depId)){
			stringBuilder.append(" AND DEP_WG.ID_DEP = '"+depId+"' ");
		}
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				if (!StringUtil.isEmptyWithTrim(where)) {
					stringBuilder.append(" And (").append(where).append(") ");
				}
			}
		}
		stringBuilder.append(" ORDER BY DEP_WG.CODE_DEP ");
		return stringBuilder.toString();
	}
}