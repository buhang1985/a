package iih.bd.srv.mrarea.refs;

import iih.bd.srv.mrarea.d.MrAreaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGirdModel;

public class MrAreaGridModel extends RefGirdModel {
	
	/**
	 * 病历四级行政区划四级参照
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		return new String[] {MrAreaDO.CODE,MrAreaDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MrAreaDO.ID_MR_AREA,MrAreaDO.ID_PARENT};
	}
	
	@Override
	public String [] getShowFieldName(){
		return new String[]{"户籍地址编码","户籍地址名称"};
	}
	
	@Override
	public String getPkFieldCode(){
		return MrAreaDO.ID_MR_AREA;
	}
	
	@Override
	public String getTableName(){
		return new MrAreaDO().getTableName();
	}
	
	@Override
	public String getRefCodeField(){
		return MrAreaDO.CODE;
	}
	
	@Override
	public String getRefNameField(){
		return MrAreaDO.NAME;
	}
	
//	@Override
//	public String  getChildField(){
//		return MrAreaDO.ID_MR_AREA;
//	}
//	
//	@Override
//	public String getFatherField(){
//		return MrAreaDO.ID_PARENT;
//	}
	
	@Override
	public String[] getBlurFields(){
		return new String[] {MrAreaDO.CODE,MrAreaDO.NAME,MrAreaDO.PYNAME,MrAreaDO.WBCODE,MrAreaDO.MNECODE};
	}
	
	@Override
	public String getRefSql(){
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart)){this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart)){this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();
			
		} finally {
			if(wherePart != null && !"".equals(wherePart)){this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart)){this.getOrderPart().remove(orderPart);}
		}
		return refSql;
	}
	
	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart(){
		StringBuilder stringBudilder = new StringBuilder("1=1");
		stringBudilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrAreaDO(), false);
		stringBudilder.append(String.format(" and %s ", BdModeWherePart));
		
//		String Code_entp = (String) this.getExtendAttributeValue(" Code_entp ");
//		String Docornurs = (String) this.getExtendAttributeValue(" Docornurs ");
//		
//		if(!String){
//			
//		}
		
		return stringBudilder.toString();
	}
	
	/**
	 *构建排序语句 
	 * 
	 */
	private String BuildOrderPart(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MrAreaDO.CODE));
		stringBuilder.append(" asc ");
		return stringBuilder.toString();
	}
	
//	@Override
//	public String getRefSql(){
//		String Id_Mr_Area = (String) this.getExtendAttributeValue("id_mr_area");
//		StringBuilder SQL = new StringBuilder();
//		SQL.append(" select * from (");
//		SQL.append(" select bd_mr_area.code,bd_mr_area.name,bd_mr_area.id_mr_area");
//		SQL.append(" from bd_mr_area bd_mr_area ");
//		if(!StringUtil.isEmpty(Id_Mr_Area)){
//			SQL.append(" where bd_mr_area.id_mr_area like '%"+Id_Mr_Area+"%'");
//		}
//		SQL.append(" ) BdMrArea");
//		SQL.append(" where 1=1");
//		List<String>whereList = this.getWherePart();
//		if(whereList.size()>0){
//			for(String wherepart : this.getWherePart()){
//				SQL.append(" And(").append(wherepart).append(")");
//			}
//		}
//		
//		return SQL.toString();
//	}
	
}
