package iih.nm.nom.nomthgtmpl.refs;

import iih.nm.nom.nomthgtmpl.d.NomThgTmplDO;
import xap.sys.appfw.refinfo.RefGridModel;

@SuppressWarnings("serial")
public class NomThgtmplModel extends RefGridModel{

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NomThgTmplDO.CODE,NomThgTmplDO.NAME};
	}
	
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[]{"病区事务记录模板编号","病区事务记录模板名称"};
	}
	
	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NomThgTmplDO.ID_NOM_THGTMPL};
	}
	
	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return NomThgTmplDO.ID_NOM_THGTMPL;
	}
	
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NomThgTmplDO.CODE;
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NomThgTmplDO.NAME;
	}
		
	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return new NomThgTmplDO().getTableName();
	}
	
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}	
		
}
