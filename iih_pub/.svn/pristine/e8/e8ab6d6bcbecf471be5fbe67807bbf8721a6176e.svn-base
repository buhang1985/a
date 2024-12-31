package iih.nm.nom.nomthgtmpl.refs;

import iih.nm.nom.nomthgtmpl.d.NomThgTmplCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

@SuppressWarnings("serial")
public class NomThgtmplCaModel extends RefTreeModel{

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NomThgTmplCaDO.CODE,NomThgTmplCaDO.NAME};
	}
	
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[]{"病区事务记录模板分类编号","病区事务记录模板分类名称"};
	}
	
	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NomThgTmplCaDO.ID_NOM_THGTMPL_CA,NomThgTmplCaDO.ID_PAR};
	}
	
	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return NomThgTmplCaDO.ID_NOM_THGTMPL_CA;
	}
	
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NomThgTmplCaDO.CODE;
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NomThgTmplCaDO.NAME;
	}
	
	/**
	 * 父子键树结构：子字段
	 */
	@Override
	public String getChildField() {		
		return NomThgTmplCaDO.ID_NOM_THGTMPL_CA;
	}
	
	/**
	 * 父子键树结构：父字段
	 */
	@Override
	public String getFatherField() {
		return NomThgTmplCaDO.ID_PAR;
	}
	
	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return new NomThgTmplCaDO().getTableName();
	}
	
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{NomThgTmplCaDO.CODE,NomThgTmplCaDO.NAME};
	}	
	
	/**
	 * 拼接sql
	 */
	@Override
	public String getRefSql() {
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}
		return refSql;
	}
	
	/**
	 * 构建排序语句
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(String.format("%s", NomThgTmplCaDO.CODE));
		return stringBuffer.toString();
	}
	
}
