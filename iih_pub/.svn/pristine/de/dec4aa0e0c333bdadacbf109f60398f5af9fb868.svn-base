package iih.bd.srv.medsrv.refs;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MMMedsrvRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[]{MedSrvRelMmDO.MM_NAME,MedSrvRelMmDO.OWTP_NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MedSrvDO.ID_SRV,MedSrvDO.ID_SRVTP,MedSrvDO.FG_OR,MedSrvDO.FG_ACTIVE,MedSrvDO.QUAN_MED,MedSrvDO.ID_UNIT_MED,MedSrvDO.FG_SET,MedSrvDO.ID_SRVCA,MedSrvDO.SD_SRVTP,MedSrvDO.DS};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","助记码"};
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
		
		String wherePart = "";
		boolean isFalse = false;
//		String srvtp = (String) this.getExtendAttributeValue("Sd_srvtp");
//		String active = (String) this.getExtendAttributeValue("Fg_active");
//		String reactca = (String) this.getExtendAttributeValue("Sd_reactca");
		String hp = (String) this.getExtendAttributeValue("hp");
		String org=(String) this.getExtendAttributeValue("org");
		
		String sql="select bd_srv.name ,bd_srv.id_srv,bd_srv.id_srvtp,bd_srv.code,,bd_srv.id_srvca"
				+ "bd_srv.quan_med,bd_srv.id_unit_med,bd_srv.fg_mm,"
				+" bd_srv.id_freq,bd_srv.pri,BD_HP_SRVORCA.SD_HPSRVTP,"
				+ "bd_srv.sd_mmbind_ip ,bd_srv.id_pri,BD_HP_SRVORCA.des "
				+" from bd_srv"
				+"  LEFT JOIN BD_HP_SRVORCA ON BD_HP_SRVORCA. id_srv = bd_srv. id_srv  ";
				if(hp!=null)
					sql+="and BD_HP_SRVORCA.id_hp="+hp;
				sql+=" where 1=1";
		
		if(org!=null)
			sql+=" And BD_SRV .id_org= "+org;
		sql+=" and BD_SRV .fg_bl ='Y' and BD_SRV . fg_active ='Y' and BD_SRV .fg_entp_ip ='Y' and BD_SRV .fg_set ='N'  and BD_SRV . fg_pkg = 'N' ";
		
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		sql+=String.format(" and %s ", BdModeWherePart);
		
		
//		String wherePart =String.format("fg_active = '%s' and fg_or = '%s' and sd_reactca <> '%s' and ds = '%s'", active, or, reactca,ds);
		if(wherePart!=null && !wherePart.equals("")){
			this.addWherePart(wherePart);
		}
		//String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}
		
		return sql;
	}

	@Override
	public String afterBuilderSql(String sql) {
		
		return super.afterBuilderSql(sql);
	}
	 
	@Override
	public String[] getBlurFields() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.MNECODE};
	}
	
	
	 
}
