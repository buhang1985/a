package iih.bd.srv.medsrv.refs;

import iih.bd.srv.medsrv.d.MedSrvDO;

import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class IpUnCgItmOrMedsrvRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.PRI,MedSrvDO.PYCODE};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MedSrvDO.ID_SRV,MedSrvDO.ID_SRVTP,MedSrvDO.FG_OR,MedSrvDO.FG_ACTIVE,MedSrvDO.QUAN_MED,MedSrvDO.ID_UNIT_MED,MedSrvDO.FG_SET,MedSrvDO.ID_SRVCA,MedSrvDO.SRVCA_NAME,MedSrvDO.SD_SRVTP,MedSrvDO.DS,MedSrvDO.MED_CODE,MedSrvDO.MED_NAME,MedSrvDO.MNECODE,MedSrvDO.WBCODE};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","参考价格","拼音码"};
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
		String sql="SELECT distinct BD_SRV.NAME,"
					+" BD_SRV.CODE,"
					+" BD_SRV.PRI,"
					+" BD_SRV.PYCODE,"
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
					+" BD_SRV.MNECODE,"
					+" BD_SRV.WBCODE"
					+" FROM BD_SRV"
					+" LEFT OUTER JOIN BL_CG_IP cg ON BD_SRV.ID_SRV = cg.ID_SRV"
					+" LEFT OUTER JOIN BD_MEASDOC ON BD_SRV.ID_UNIT_MED = BD_MEASDOC.ID_MEASDOC"
					+" LEFT OUTER JOIN BD_SRVCA ON BD_SRV.ID_SRVCA = BD_SRVCA.ID_SRVCA"
					+" WHERE 1 = 1 and cg.fg_st = 'N' and BD_SRV.ds=0 and BD_SRV.Fg_active='Y' and BD_SRV.id_grp = '"+Context.get().getGroupId()+"' and BD_SRV.id_org='"+Context.get().getOrgId()+"'";
		String wherePart = "";
		boolean IsWithAnd = true;
		String id_ent = (String) this.getExtendAttributeValue("Id_ent");
		
		if(id_ent != null && !id_ent.equals("")){
			if(IsWithAnd){
				wherePart += " and cg.id_ent = '"+id_ent+"'  ";
			}else{
				wherePart += " cg.id_ent = '"+id_ent+"'  ";
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
