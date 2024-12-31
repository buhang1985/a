package iih.bd.srv.medsrv.refs;

import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import iih.bd.srv.medsrv.d.MedSrvDO;

public class FillMedsrvRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.PYCODE};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{MedSrvDO.ID_SRV,MedSrvDO.ID_SRVTP,MedSrvDO.ID_SRVCA,MedSrvDO.QUAN_MED,
				MedSrvDO.ID_UNIT_MED,MedSrvDO.FG_MM,MedSrvDO.ID_FREQ,MedSrvDO.PRI,"name_unit_med",
				"feqname","freqct","SD_FREQUNITCT",MedSrvDO.SD_SRVTP,MedSrvDO.ID_PRIMD,"id_hpsrvtp",
				"id_route","name_route","id_routedes","name_routedes","id_boil", "name_boil", 
				"id_boildes", "name_boildes","innercode_srvca","eu_blmd","fg_or","des_bl","sd_mmbind_ip",
				"des","fg_long"};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","拼音码"};
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
		
		List<String> wherePart = this.getWherePart();
		boolean isFalse = false;
		String hp = (String) this.getExtendAttributeValue("hp");
		String org=(String) this.getExtendAttributeValue("org");
		String id_org = Context.get().getOrgId();
		String id_group = Context.get().getGroupId();
		String sql="select  distinct bd_srv.name ,bd_srv.code,bd_srv.pycode,bd_srv.id_srv,bd_srv.id_srvtp,bd_srv.id_srvca, "
				+ "bd_srv.quan_med,bd_srv.id_unit_med,bd_srv.fg_mm,"
				+" bd_srv.id_freq,bd_srv.pri, bd_measdoc.name name_unit_med,BD_freq.name feqname,BD_FREQ.freqct,BD_FREQ.SD_FREQUNITCT,bd_srv.sd_srvtp,bd_srv.id_primd,BD_HP_SRVORCA.id_hpsrvtp,"
				+ "bd_route.id_route,bd_route.name as name_route,bd_route_des.id_routedes,bd_route_des.name as name_routedes,"
				+ "bd_boil.id_boil, bd_boil.name as name_boil, bd_boil_des.id_boildes, bd_boil_des.name as name_boildes,"
				+ "bd_srv.srvca_innercode as innercode_srvca,bd_srv.eu_blmd,bd_srv.fg_or,bd_srv.des as des_bl,"
				+ "bd_srv.sd_mmbind_ip ,BD_HP_SRVORCA.des,BD_FREQ.fg_long  "
				+" from bd_srv"
				 + "  left outer join bd_measdoc  on bd_srv.id_unit_med = bd_measdoc.id_measdoc "
				 +"  LEFT JOIN BD_FREQ ON BD_FREQ.id_freq = bd_srv.id_freq  "
				+"  LEFT JOIN BD_HP_SRVORCA ON BD_HP_SRVORCA. id_srv = bd_srv. id_srv  "
				+ " left join bd_route on bd_srv.id_route = bd_route.id_route"
				+ " left join bd_route_des on bd_srv.id_routedes = bd_route_des.id_routedes"
				+ " left join bd_boil on bd_srv.id_boil = bd_boil.id_boil"
				+ " left join bd_boil_des on bd_srv.id_boildes = bd_boil_des.id_boildes ";
				if(hp!=null)
					sql+="and BD_HP_SRVORCA.id_hp='"+hp+"' ";
				sql+=" where 1=1";
		
			sql+=" And BD_SRV.id_org= '"+id_org+"'";
			sql+=" And BD_SRV.id_grp= '"+id_group+"'";
		//and BD_SRV .fg_entp_ip ='Y'
		sql+=" and   BD_SRV.fg_active ='Y'  and BD_SRV.fg_set ='N' and BD_SRV.fg_bl='Y' and BD_SRV.ds=0";//and BD_SRV.fg_pkg = 'N' 
//		String wherePart =String.format("fg_active = '%s' and fg_or = '%s' and sd_reactca <> '%s' and ds = '%s'", active, or, reactca,ds);
		StringBuilder sb=new StringBuilder(sql);
		if (wherePart.size() > 0) {
			
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		//String sql = null;
//		try {
//			sql = super.getRefSql();
//		} finally {
//			this.removeWherePart(wherePart);
//		}
		
		return sb.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {
		
		return super.afterBuilderSql(sql);
	}
	 
	@Override
	public String[] getBlurFields() {
		return new String[]{MedSrvDO.NAME,MedSrvDO.CODE,MedSrvDO.MNECODE,MedSrvDO.PYCODE};
	}
	
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String[] fields = this.getBlurFields();
		if (fields == null)
			// lizhiyu 2015-08-29 当搜索字段没有定义时，默认使用显示字段来过滤
			fields = this.getShowFieldCode();

		StringBuilder buf = new StringBuilder();
		buf.append("(");
		
		
		buf.append(" lower(bd_srv.code) like ");
		buf.append(" ? ");
		this.getParam().addParam("%"+blurValue.toLowerCase()+"%");
		buf.append(" or ");
		buf.append(" lower(bd_srv.name) like ");
		buf.append(" ? ");
		this.getParam().addParam("%"+blurValue.toLowerCase()+"%");
		buf.append(" or ");
		buf.append(" lower(bd_srv.pycode) like ");
		buf.append(" ? ");
		this.getParam().addParam("%"+blurValue.toLowerCase()+"%");
		
		buf.append(")");
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}
	 
}
