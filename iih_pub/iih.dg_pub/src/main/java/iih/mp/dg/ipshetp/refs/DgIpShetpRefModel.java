package iih.mp.dg.ipshetp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.mp.dg.ipshetp.d.IpSheetTypeDO;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DgIpShetpRefModel extends RefGridModel {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		return new String[]{IpSheetTypeDO.CODE,IpSheetTypeDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{IpSheetTypeDO.ID_DGSHETP,IpSheetTypeDO.EU_SHETP,IpSheetTypeDO.DG_DAYS,IpSheetTypeDO.DT_BEGIN,IpSheetTypeDO.DT_END,
				IpSheetTypeDO.FG_OUTP,IpSheetTypeDO.EN_DRUGCYCLE,IpSheetTypeDO.EN_DAYFIRDRUG};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return IpSheetTypeDO.ID_DGSHETP;
	}
	@Override
	public String getTableName(){
		return new IpSheetTypeDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return IpSheetTypeDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return IpSheetTypeDO.NAME;
	}
	
	@Override
	public String getRefSql() {
		
		//显示医技药单 Y:只显示医技药单 N:过滤掉医技药单
		String onlyOt = (String)this.getExtendAttributeValue("only_ot");
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select code,name,id_dgshetp,eu_shetp,dg_days,dt_begin,dt_end,fg_outp,en_drugcycle,en_dayfirdrug ");
		sqlSb.append("from mp_dg_shetp ");
		sqlSb.append("where ds = 0  and mp_dg_shetp.id_grp='"+Context.get().getGroupId()+"' and mp_dg_shetp.id_org='"+Context.get().getOrgId()+"' ");
		
		if("Y".equals(onlyOt)){
			sqlSb.append("and id_dgshetp in " + this.getAutoSheetSql());
		}else if("N".equals(onlyOt)){
			sqlSb.append("and id_dgshetp not in " + this.getAutoSheetSql());
		}
		
		StringBuilder sb = new StringBuilder(sqlSb.toString());
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		sb.append("order by code ");
		
		return sb.toString();		
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> whereList = super.getWherePart();
		if(whereList == null)
			whereList = new ArrayList<String>();
		
		Boolean fg_herb=(Boolean)this.getExtendAttributeValue("fg_herb");//草药标志
		String id_dep_nur = (String)this.getExtendAttributeValue("id_dep_nur");//病区
		String id_dep_wh = (String)this.getExtendAttributeValue("id_dep_wh");//摆药药房
		
		if(fg_herb != null){
			String whereSql = "";
			if(fg_herb == true){
				whereSql = "(eu_shetp = 11 or eu_shetp = 12)";
			}else{
				whereSql = "(eu_shetp = 1 or eu_shetp = 2)";
			}
			whereList.add(whereSql);
		}
		
		if(!StringUtil.isEmpty(id_dep_nur)){
			String whereSql = "(instr(id_dep_nurs,'" + id_dep_nur + "')>0 or id_dep_nurs is null)";
			whereList.add(whereSql);
		}
		
		if(!StringUtil.isEmpty(id_dep_wh)){
			String whereSql = "instr(id_dep_mp,'" + id_dep_wh + "')>0";
			whereList.add(whereSql);
		}
		
		return whereList;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{IpSheetTypeDO.CODE,IpSheetTypeDO.NAME,
				IpSheetTypeDO.PYCODE,IpSheetTypeDO.WBCODE,IpSheetTypeDO.INSTR};
	}

	/**
	 * 过滤医技药单sql
	 * @return
	 */
	private String getAutoSheetSql(){
		return "(select id_dgshetp from mp_dg_shetpauto where sd_spauto in ('1','2')) ";
	}
}
