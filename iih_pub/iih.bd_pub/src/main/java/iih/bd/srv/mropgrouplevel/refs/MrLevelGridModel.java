package iih.bd.srv.mropgrouplevel.refs;
import iih.bd.srv.mropgrouplevel.d.MrOpGroupLevelDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGirdModel;

public class MrLevelGridModel extends RefGirdModel {

	/**
	 * 病历业务组权限配置层级参照
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		return new String[] {MrOpGroupLevelDO.CODE_LEVEL,MrOpGroupLevelDO.NAME_LEVEL};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MrOpGroupLevelDO.IDMROPGROUPLEVEL};
	}
	
	@Override
	public String [] getShowFieldName(){
		return new String[]{"层级编码","层级名称"};
	}
	
	@Override
	public String getPkFieldCode(){
		return MrOpGroupLevelDO.IDMROPGROUPLEVEL;
	}
	
	@Override
	public String getTableName(){
		return new MrOpGroupLevelDO().getTableName();
	}
	
	@Override
	public String getRefCodeField(){
		return MrOpGroupLevelDO.CODE_LEVEL;
	}
	
	@Override
	public String getRefNameField(){
		return MrOpGroupLevelDO.NAME_LEVEL;
	}
	
	@Override
	public String[] getBlurFields(){
		return new String[] {MrOpGroupLevelDO.CODE_LEVEL,MrOpGroupLevelDO.NAME_LEVEL};
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrOpGroupLevelDO(), false);
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
		stringBuilder.append(String.format("%s", MrOpGroupLevelDO.SORTNO));
		stringBuilder.append(" asc ");
		return stringBuilder.toString();
	}
}
