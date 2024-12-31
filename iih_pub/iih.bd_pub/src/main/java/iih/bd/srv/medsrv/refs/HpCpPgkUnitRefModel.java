package iih.bd.srv.medsrv.refs;

import java.util.List;

import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 药品总量单位参照范围
 * @author HUMS
 *
 */
public class HpCpPgkUnitRefModel extends RefGridModel{
	
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] {MeasDocDO.CODE,MeasDocDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MeasDocDO.ID_MEASDOC };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码",  "名称"};
	}

	@Override
	public String getPkFieldCode() {
		return MeasDocDO.ID_MEASDOC;
	}

	@Override
	public String getRefCodeField() {
		return MeasDocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MeasDocDO.NAME;
	}

	@Override
	public String getTableName() {
		return "measdoc";
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}
	
	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		String filterPksText = DaoUtil.joinQryArrays((String[]) filterPks);
		StringBuilder buff = new StringBuilder();
		buff.append( MeasDocDO.ID_MEASDOC );
		if (filterPks.length == 1) {
			buff.append(" = ").append(filterPksText);
		} else {
			buff.append(" in (").append(filterPksText).append(")");
		}
		String wherePart = buff.toString();
		this.addWherePart(wherePart);
		try {
			RefResultSet refResultSet = this.getRefData();
			return refResultSet;
		} finally {
			this.removeWherePart(wherePart);
		}
	}

	@Override
	public String getRefSql() {
		
		// 是否为计量单位字典
		boolean isMeasDoc = false;
		// 判断是否物品参照
		boolean isContainMm = false;
		StringBuffer buffer = new StringBuffer();
				
		List<String> wherePartList = this.getWherePart();
		for(String wherePart : wherePartList){
			if(wherePart.indexOf(MeasDocDO.ID_MEASDOC)>=0){
				isMeasDoc = true;
			}
		}
		
		// 仅查询计量字典
		if(isMeasDoc){
			return this.getMeasdocSql();	
		}
		
		
		// 根据是否有物品id值，确定查询物品单位，还是查询服务单位
		buffer.append("select measdoc.code, measdoc.name, measdoc.id_measdoc ,measdoc.id_mm");
		buffer.append(" from ");		
		buffer.append("("+this.getMmMedUnitSql()+") measdoc");
		
		buffer.append(" where 1=1 ").append(this.getWherePartStr());
		
		return buffer.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String getWherePartStr() {

		StringBuffer whereBuffer = new StringBuffer();
		
		List<String> wherePartList = this.getWherePart();
		if(wherePartList != null && wherePartList.size() > 0){
			for(String wherePart : wherePartList){
				whereBuffer.append(" and ").append(wherePart);
			}	
		}
		
		
		return whereBuffer.toString();
	}
	
	private String getMeasdocSql(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append( "select measdoc.code, measdoc.name,measdoc.id_measdoc ,'' id_srv, '' as id_mm ");
		buffer.append(" from bd_measdoc measdoc ");
		buffer.append(" where 1=1 ");
		
		List<String> wherePartList = this.getWherePart();
		for(String wherePart : wherePartList){
			buffer.append(" and ").append(wherePart);
		}
		return buffer.toString();
	}
	
	/**
	 * 获取物品剂量单位查询语句
	 * @return
	 */
	private String getMmMedUnitSql(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct measdoc.id_measdoc ,measdoc.code, measdoc.name,pkgu.id_mm ");
		buffer.append(",measdoc.pycode,measdoc.mnecode");
		buffer.append(" from bd_mm_pkgu pkgu, bd_measdoc measdoc where pkgu.id_unit_pkg = measdoc.id_measdoc");
		
		return buffer.toString();
	}
	
	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}
}
