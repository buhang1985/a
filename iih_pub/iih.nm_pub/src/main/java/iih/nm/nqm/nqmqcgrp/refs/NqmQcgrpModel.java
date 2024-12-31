package iih.nm.nqm.nqmqcgrp.refs;

import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpDO;
import xap.sys.appfw.refinfo.RefTreeModel;

@SuppressWarnings("serial")
public class NqmQcgrpModel extends RefTreeModel{
	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NqmQcgrpDO.CODE,NqmQcgrpDO.NAME};
	}
	
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[]{"质控组编号","质控组名称"};
	}
	
	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NqmQcgrpDO.ID_NQM_QCGRP,NqmQcgrpDO.ID_PAR};
	}
	
	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return NqmQcgrpDO.ID_NQM_QCGRP;
	}
	
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NqmQcgrpDO.CODE;
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NqmQcgrpDO.NAME;
	}
	
	/**
	 * 父子键树结构：子字段
	 */
	@Override
	public String getChildField() {		
		return NqmQcgrpDO.ID_NQM_QCGRP;
	}
	
	/**
	 * 父子键树结构：父字段
	 */
	@Override
	public String getFatherField() {
		return NqmQcgrpDO.ID_PAR;
	}
	
	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return new NqmQcgrpDO().getTableName();
	}
	
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{NqmQcgrpDO.CODE,NqmQcgrpDO.NAME,NqmQcgrpDO.PYCODE,NqmQcgrpDO.WBCODE,NqmQcgrpDO.MNECODE};
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
		stringBuffer.append(String.format("%s", NqmQcgrpDO.CODE));
		return stringBuffer.toString();
	}
}
