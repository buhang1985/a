package iih.bd.srv.medsrv.refs;

import java.util.List;

import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 临床路径剂量单位参照
 * 
 * @author HUMS
 *
 */
public class HpCpMedUnitRefModel extends RefGridModel{
	
	
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
		buffer.append("select measdoc.code, measdoc.name, measdoc.id_measdoc ,measdoc.id_srv,measdoc.id_mm");
		buffer.append(" from ");		
		
		for(String wherePart : wherePartList){
			if(wherePart.indexOf("Id_mm")>=0){
				if(wherePart.substring(wherePart.indexOf("Id_mm")).length() > 20)
				isContainMm = true;
				break;
			}				
		}
		
		if(isContainMm){
			buffer.append("("+this.getMmMedUnitSql()+") measdoc");
		}else{
			buffer.append("("+this.getSrvMedUnitSql()+") measdoc");
		}
		
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
				if(wherePart.toLowerCase().indexOf("id_mm") >= 0){
					String[] wherePartArr = wherePart.split("and");
					for(String whereStr : wherePartArr){
						// 根据字符串长度，判断当前的过滤条件中是否包含物品id
						if(whereStr.toLowerCase().indexOf("id_mm") >=0){ 
							if(whereStr.length() > 20){
								whereBuffer.append(" and ").append(whereStr);
							}
						}else{
							whereBuffer.append(" and ").append(whereStr);	
						}
					}
				}else{
					whereBuffer.append(" and ").append(wherePart);
				}
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
		buffer.append("select measdoc.id_measdoc ,measdoc.code, measdoc.name,mm.id_srv,mm.id_mm ");
		buffer.append(",measdoc.pycode,measdoc.mnecode");
		buffer.append(" from bd_mm mm, bd_measdoc measdoc where mm.id_unit_med = measdoc.id_measdoc");
		/*buffer.append(" union ");
		buffer.append(" select  measdoc.id_measdoc ,measdoc.code, measdoc.name,mm.id_srv,mm.id_mm  ");
		buffer.append(",measdoc.pycode,measdoc.mnecode");
		buffer.append(" from bd_mm mm, bd_measdoc measdoc where mm.id_unit_pkgbase = measdoc.id_measdoc");*/
		
		return buffer.toString();
	}
	
	/**
	 * 获取服务项目剂量单位查询语句
	 * @return
	 */
	private String getSrvMedUnitSql(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select  measdoc.id_measdoc ,measdoc.code, measdoc.name , srv.id_srv, '' as id_mm ");
		buffer.append(",measdoc.pycode,measdoc.mnecode");
		buffer.append(" from bd_srv srv, bd_measdoc measdoc where srv.id_unit_med = measdoc.id_measdoc");
		
		return buffer.toString();
	}
	
	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}
}
