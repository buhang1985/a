package iih.bd.srv.medsrv.refs;

import iih.bd.srv.medsrv.d.MedSrvDO;

import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class SelfDefFeeTmplUseMedsrvRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.PRI,MedSrvDO.MNECODE};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MedSrvDO.ID_SRV,MedSrvDO.ID_SRVTP,MedSrvDO.FG_OR,MedSrvDO.FG_ACTIVE,MedSrvDO.QUAN_MED,MedSrvDO.ID_UNIT_MED,MedSrvDO.FG_SET,MedSrvDO.ID_SRVCA,MedSrvDO.SRVCA_NAME,MedSrvDO.SD_SRVTP,MedSrvDO.DS,MedSrvDO.MED_CODE,MedSrvDO.MED_NAME,MedSrvDO.PYCODE,MedSrvDO.WBCODE};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","参考价格","助记码"};
	}
	
	@Override
	public String getPkFieldCode() {
		return MedSrvDO.ID_SRV;
	}
	@Override
	public String getRefCodeField() {
		return MedSrvDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MedSrvDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {
		
		getWherePart().add(wherePart);
	}
	@Override
	public String getRefSql() {
//		,bd_srvca.name as srvca_name
		String sql="SELECT BD_SRV.NAME,"
					+" BD_SRV.CODE,"
					+" BD_SRV.PRI,"
					+" BD_SRV.MNECODE,"
					+" BD_SRV.ID_SRV,"
					+" BD_SRV.ID_SRVTP,"
					+" BD_SRV.FG_OR,"
					+" BD_SRV.FG_ACTIVE,"
					+" BD_SRV.QUAN_MED,"
					+" BD_SRV.ID_UNIT_MED,"
					+" BD_SRV.FG_SET,"
					+" BD_SRV.ID_SRVCA,"
					+" BD_SRVCA.Name AS SRVCA_NAME,"
					+" BD_SRV.SD_SRVTP,"
					+" BD_SRV.DS,"
					+" BD_MEASDOC.CODE    MED_CODE,"
					+" BD_MEASDOC.NAME    MED_NAME,"
					+" BD_SRV.PYCODE,"
					+" BD_SRV.WBCODE"
					+" FROM BD_SRV"
					+" LEFT OUTER JOIN BD_MEASDOC ON BD_SRV.ID_UNIT_MED = BD_MEASDOC.ID_MEASDOC"
					+" LEFT OUTER JOIN BD_SRVCA ON BD_SRV.ID_SRVCA = BD_SRVCA.ID_SRVCA"
					+" WHERE 1 = 1 and BD_SRV.id_grp = '"+Context.get().getGroupId()+"' and BD_SRV.id_org='"+Context.get().getOrgId()+"'";
		String wherePart = "";
		//语法的问题，带不带and，其实这里写没必要，暂时留存吧，yangyang
		boolean IsWithAnd = true;
		String srvtp = (String) this.getExtendAttributeValue("Sd_srvtp");
		String active = (String) this.getExtendAttributeValue("Fg_active");
		String or = (String) this.getExtendAttributeValue("Fg_or");
		String ds=(String) this.getExtendAttributeValue("Ds");
		String fg_bl = (String) this.getExtendAttributeValue("Fg_bl");
		
		if(active != null && !active.equals("")){
			if(IsWithAnd){
				wherePart += " and BD_SRV.fg_active = '"+active+"'  ";
			}else{
				wherePart += " BD_SRV.fg_active = '"+active+"'  ";
				IsWithAnd = true;
			}
			
		} 
		if(or != null && !or.equals("") ){
			if(IsWithAnd){
				wherePart += " and  BD_SRV.fg_or = '"+or+"'";
			}else{
				wherePart += " BD_SRV.fg_or = '"+or+"'";
				IsWithAnd = true;
			}
		} 
		
		if(ds != null && !ds.equals("") ){
			if(IsWithAnd){
				wherePart += " and  BD_SRV.ds = "+ds;
			}else{
				wherePart += " BD_SRV.ds = "+ds;
				IsWithAnd = true;
			}
		} 
		if(srvtp != null && !srvtp.equals("") ){				
			if(IsWithAnd){	
				wherePart += " and  BD_SRV.sd_srvtp like '"+srvtp+"%'";
			}else{	
				wherePart += " BD_SRV.sd_srvtp like '"+srvtp+"%'";
				IsWithAnd = true;
			}	
		} 
		if(fg_bl != null && !fg_bl.equals("") ){				
			if(IsWithAnd){	
				wherePart += String.format(" AND BD_SRV.FG_BL = '%s' ", fg_bl);
			}else{	
				wherePart += String.format(" BD_SRV.FG_BL = '%s' ", fg_bl);
				IsWithAnd = true;
			}	
		} 
		
		//这个是原有的条件语句
		List<String>  oldWherepartArr = this.getWherePart();

		for(String strWhere :oldWherepartArr )
		{
			sql=sql+" and "+strWhere;
		}
		sql=sql+wherePart;
		
		return sql;
	}

	@Override
	public String afterBuilderSql(String sql) {
		
		return super.afterBuilderSql(sql);
	}
	 
	@Override
	public String[] getBlurFields() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.MNECODE,MedSrvDO.PYCODE,MedSrvDO.WBCODE};
	}
	
}
