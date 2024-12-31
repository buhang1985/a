package iih.nm.com.ref;


import java.util.List;

import xap.mw.core.data.Context;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.refinfo.RefGridModel;

public abstract class ComRefGridModel extends RefGridModel{

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */  
	private static final long serialVersionUID = 1L;

	public ComRefGridModel() {
	}

	@Override
	public  String[] getShowFieldCode() {
		String name = getBaseDO().getDODesc().getIBDDataInfoFldMap().get("name");
		String code = getBaseDO().getDODesc().getIBDDataInfoFldMap().get("code");
		return new String[]{name,code};	
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{getBaseDO().getPKFieldName()};
	}

	@Override
	public String[] getShowFieldName() {
		String name = getBaseDO().getDODesc().getIBDDataInfoFldMap().get("name");
		String code = getBaseDO().getDODesc().getIBDDataInfoFldMap().get("code");
		String showName = getBaseDO().getDODesc().getAttrDesc(name).getColumn().getLabel();
		String showCode = getBaseDO().getDODesc().getAttrDesc(code).getColumn().getLabel();
		return new String[]{showName,showCode};
	}

	@Override
	public List<String[]> getWhereFieldCode() {
		return null;
	}

	@Override
	public List<String> getWriteFieldCode() {
		return null;
	}

	@Override
	public String[] getBlurFields() {
		return null;
	}

	@Override
	public String getTableName() {
		return getBaseDO().getTableName();
	}

	@Override
	public List<String> getRefTableName() {
		return null;
	}

	@Override
	public String getRefTitle() {
		return null;
	}

	@Override
	public String getPkFieldCode() {
		return getBaseDO().getPKFieldName();
	}

	@Override
	public String getRefCodeField() {
		return getBaseDO().getDODesc().getIBDDataInfoFldMap().get("code");
	}

	@Override
	public String getRefNameField() {
		return getBaseDO().getDODesc().getIBDDataInfoFldMap().get("name");
	}

	public void addWherePart(String wherePart) {
		super.addWherePart(wherePart);
		addSqlParam();
		super.addWherePart("Id_org = ?");
		super.addWherePart("Id_grp = ?");
	}

	public void addSqlParam() {
		super.getParam().addParam(Context.get().getOrgId());
		super.getParam().addParam(Context.get().getGroupId());
	}

	public  abstract IBaseDO getBaseDO();
	
}
