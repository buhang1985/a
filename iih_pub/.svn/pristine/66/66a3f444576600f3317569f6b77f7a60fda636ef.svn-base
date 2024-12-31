package iih.nm.nqm.nmnqmtaskca.refs;

import iih.nm.nqm.nmnqmtaskca.d.NmNqmTaskCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

public class NqmTaskCaRefModel extends RefTreeModel{
	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NmNqmTaskCaDO.CODE,NmNqmTaskCaDO.NAME};
	}
	
	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[]{"任务编号","任务名称"};
	}
	
	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NmNqmTaskCaDO.ID_NQM_TASK_CA,NmNqmTaskCaDO.ID_PAR};
	}
	
	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return NmNqmTaskCaDO.ID_NQM_TASK_CA;
	}
	
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return NmNqmTaskCaDO.CODE;
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return NmNqmTaskCaDO.NAME;
	}
	
	/**
	 * 父子键树结构：子字段
	 */
	@Override
	public String getChildField() {		
		return NmNqmTaskCaDO.ID_NQM_TASK_CA;
	}
	
	/**
	 * 父子键树结构：父字段
	 */
	@Override
	public String getFatherField() {
		return NmNqmTaskCaDO.ID_PAR;
	}
	
	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return new NmNqmTaskCaDO().getTableName();
	}
	
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{NmNqmTaskCaDO.CODE,NmNqmTaskCaDO.NAME,NmNqmTaskCaDO.PYCODE,NmNqmTaskCaDO.WBCODE,NmNqmTaskCaDO.MNECODE};
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
		stringBuffer.append(String.format("%s", NmNqmTaskCaDO.CREATEDTIME));
		stringBuffer.append(" desc");
		return stringBuffer.toString();
	}
}
