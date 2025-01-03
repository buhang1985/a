package iih.bd.srv.medsrv.refs;

import java.util.List;

import iih.bd.base.utils.StringUtils;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 简易收费流程中的服务参照
 * @author zhangwq
 *
 */
public class MedsrvTidyFeeRefMode extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Name_srv","Code_srv","Name_mm","Spec","price", "Sd_hpsrvtp_name" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_pk","Id_srv","Id_srvtp","Sd_srvtp","Id_srvca","Quan_med",
				"Id_unit_pkg","Name_unit_med",
				"Id_unit_pkgsp","Id_unit_pkgbase",
				"Fg_mm","Id_mm","Srv_wbcode","Srv_pycode","Factor","Factor_mb","Id_route","Fg_otc","quan_cur","Eu_blmd","Sd_hpsrvtp" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] {"服务名称","编码","物品名称","规格","参考价","医保目录类型"};
	}

	@Override
	public String getPkFieldCode() {
		return "Id_pk";
	}

	@Override
	public String getRefCodeField() {
		return "code";
	}

	@Override
	public String getRefNameField() {
		return "name_srv";
	}

	@Override
	public String getTableName() {
		return "srv1";
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override 
	public String getRefSql() {
		String id_dep = (String) this.getExtendAttributeValue("Id_dep");
		String id_hp = (String) this.getExtendAttributeValue("Id_hp");
		// 取的科室的黑白名单标识
		FBoolean fg_black = this.getDepFgblack(id_dep);
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append(" srv1.name as Name_srv,srv1.code as Code_srv,bd_mm.name as Name_mm,bd_mm.Spec,case when srv1.fg_mm='N' then srv1.pri else bd_mm.price end as price,");
		sb.append(" DECODE(srvtp.sd_hpsrvtp_name, ");
		sb.append("                                               NULL, ");
		sb.append("                                               srvtp3.sd_hpsrvtp_name, ");
		sb.append("                                               srvtp.sd_hpsrvtp_name)  Sd_hpsrvtp_name, ");
		sb.append(" srv1.id_srv||bd_mm.id_mm as Id_pk,");
		sb.append(" srv1.Id_srv,srv1.id_srvtp,srv1.sd_srvtp,srv1.id_srvca,");
		sb.append(" srv1.quan_med as quan_med,");
		sb.append(" case when nvl(bd_mm.id_mm,'~')='~' then srv1.id_unit_med else bd_mm.id_unit_pkgsp end as id_unit_pkg,");
		sb.append(" case when nvl(bd_mm.id_mm,'~')='~' then srvdoc.name else mmdoc.name end as name_unit_med,");
		sb.append(" bd_mm.id_unit_pkgsp,");
		sb.append(" bd_mm.id_unit_pkgbase,");
		sb.append(" srv1.fg_mm,bd_mm.id_mm,srv1.wbcode as srv_wbcode,srv1.pycode as srv_pycode,");
		sb.append(" bd_mm.factor_sb as factor,bd_mm.factor_mb,srv1.id_route,bd_mm.fg_otc,");
		sb.append(" 1 as quan_cur, ");
		sb.append(" srv1.eu_blmd, ");
		sb.append(" DECODE(srvtp.sd_hpsrvtp, ");
		sb.append("                                               NULL, ");
		sb.append("                                               srvtp3.sd_hpsrvtp, ");
		sb.append("                                               srvtp.sd_hpsrvtp)  Sd_hpsrvtp ");
		if(fg_black==null){
			sb.append(" from bd_srv srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
			sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
			sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		}else if(fg_black.booleanValue()){
			sb.append(" from (select * from bd_srv srv where srv.id_srv not in(");
			sb.append(" select itm.id_srv from bd_dep_cg limt");
			sb.append(" inner join bd_dep_cg_itm itm on limt.id_depcg=itm.id_depcg and limt.fg_black='Y'  and limt.id_dep='"+id_dep+"' ))");
			sb.append(" srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
			sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
			sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		}else{
			sb.append(" from (select * from bd_srv srv where srv.id_srv in(");
			sb.append(" select itm.id_srv from bd_dep_cg limt");
			sb.append(" inner join bd_dep_cg_itm itm on limt.id_depcg=itm.id_depcg and limt.fg_black='N'  and limt.id_dep='"+id_dep+"' ))");
			sb.append(" srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
			sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
			sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		}
		sb.append(" left  outer  join  (select  distinct  srvca.id_hpsrvorca, ");
		sb.append("                                                                   srvca.id_srv, ");
		sb.append("                                                                   DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                 NULL, ");
		sb.append("                                                                                 srvtp2.sd_hpsrvtp_name, ");
		sb.append("                                                                                 DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                               '~', ");
		sb.append("                                                                                               srvtp2.sd_hpsrvtp_name, ");
		sb.append("                                                                                               udidoc.name))  sd_hpsrvtp_name, ");
		sb.append("                                                                   DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                 NULL, ");
		sb.append("                                                                                 srvtp2.sd_hpsrvtp, ");
		sb.append("                                                                                 DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                               '~', ");
		sb.append("                                                                                               srvtp2.sd_hpsrvtp, ");
		sb.append("                                                                                               srvca.sd_hpsrvtp))  sd_hpsrvtp ");
		sb.append("                                       from  bd_hp_srvorca  srvca ");
		sb.append("                                     inner  join  bd_hp  hp ");
		if (StringUtils.isNotEmpty(id_hp)) {
			sb.append("                                   on  hp.id_hp  =  '").append(id_hp).append("' ");
		}else {
			sb.append("                                   on  hp.FG_DEFAULT  =  'Y' ");
		}
		sb.append("                                         and  hp.id_hp  =  srvca.id_hp ");
		sb.append("                                     inner  join  mi_hpsrvtp_vs_stdhpsrvtp  srvtp1 ");
		sb.append("                                           on  srvtp1.SD_STD_HPSRVTP  =  srvca.sd_hpsrvtp ");
		sb.append(" inner  join  bd_udidoc  udidoc ");
		sb.append("                                               on  udidoc.code  =  srvca.sd_hpsrvtp ");
		sb.append("                                         inner  join  bd_udidoclist  udlist ");
		sb.append("                                               on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sb.append("                                             and  udlist.code  =  'BD.BL.1020' ");

		sb.append("                                       left  outer  join  (select  srvtp.SD_STD_HPSRVTP as sd_hpsrvtp,srvtp.sd_hpsrvtp as sd_hpsrvtp_name ");
		sb.append("                                                                           from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sb.append("                                                                         inner  join  bd_udidoc  udidoc ");
		sb.append("                                                                               on  udidoc.code  = ");
		sb.append("                                                                                     srvtp.SD_STD_HPSRVTP ");
		sb.append("                                                                             and  udidoc.ctrl1  =  'Y' ");
		sb.append("                                                                             and  udidoc.activestate  =  '2' ");
		sb.append("                                                                         inner  join  bd_udidoclist  udlist ");
		sb.append("                                                                               on  udlist.id_udidoclist  = ");
		sb.append("                                                                                     udidoc.id_udidoclist ");
		sb.append("                                                                             and  udlist.code  =  'BD.BL.1020' ");
		sb.append("                                                                         where  rownum  =  1)  srvtp2 ");
		sb.append("                                           on  1  =  1)  srvtp ");
		sb.append("     on  srvtp.id_srv  =  srv1.id_srv ");
		sb.append(" left  outer  join  (select  srvtp.SD_STD_HPSRVTP as sd_hpsrvtp,srvtp.sd_hpsrvtp as sd_hpsrvtp_name ");
		sb.append("                                       from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sb.append("                                     inner  join  bd_udidoc  udidoc ");
		sb.append("                                           on  udidoc.code  =  srvtp.SD_STD_HPSRVTP ");
		sb.append("                                         and  udidoc.ctrl1  =  'Y' ");
		sb.append("                                         and  udidoc.activestate  =  '2' ");
		sb.append("                                     inner  join  bd_udidoclist  udlist ");
		sb.append("                                           on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sb.append("                                         and  udlist.code  =  'BD.BL.1020' ");
		sb.append("                                     where  rownum  =  1)  srvtp3 ");
		sb.append("     on  1  =  1 ");
		sb.append(" where 1=1 and srv1.fg_active = 'Y' and srv1.fg_active_bl = 'Y' and srv1.Ds=0 and (bd_mm.fg_active is null or bd_mm.fg_active = 'Y') ");
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new MedSrvDO(), "srv1");//增加组织隔离
		sb.append(sqlContext);
		List<String> whereList = this.getWherePart();
		if(whereList != null && whereList.size() > 0){
			for (String part : whereList) {
				sb.append(" and (").append(part).append(") ");
			}
		}
		
		return sb.toString();
	}

	private FBoolean getDepFgblack(String id_dep) {
		if (StringUtil.isEmpty(id_dep)) {
			return null;
		}
		try {
			List<BdDepCgDO> results = (List<BdDepCgDO>) new DAFacade().findByAttrValString(BdDepCgDO.class,
					BdDepCgDO.ID_DEP, id_dep, new String[] { BdDepCgDO.FG_BLACK });
			if (!ListUtil.isEmpty(results)) {
				return results.get(0).getFg_black();
			} else {
				return null;
			}
		} catch (DAException daException) {
			return null;
		}
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { "name","pycode","code", "wbcode" };
	}

	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		String filterPksText = DaoUtil.joinQryArrays((String[]) filterPks);
		//String pkFieled = this.getPkFieldCode();
		StringBuilder buff = new StringBuilder();
		buff.append("srv1.id_srv||bd_mm.id_mm");
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
}
