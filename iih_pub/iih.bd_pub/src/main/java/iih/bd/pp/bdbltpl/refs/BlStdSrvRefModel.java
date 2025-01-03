package iih.bd.pp.bdbltpl.refs;

import java.util.List;

import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 新版费用模板，解决项目模板没有价格的问题
 * @author xy.zhou
 * @date 2018年8月9日
 * @version 2019/03/08 ly 修改医保等级获取逻辑
 */
public class BlStdSrvRefModel extends RefGridModel{

	/**   
	 * @Fields serialVersionUID : TODO  
	 */ 
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code_bill","name","hpsrvtp_name","price_ratio","name_billtype"};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","费用项名称","医保等级","参考金额","类型"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_key";
	}

	@Override
	public String getRefCodeField() {
		return "code_bill";
	}

	@Override
	public String getRefNameField() {
		return "name";
	}

	@Override
	public String getTableName() {
		return "A";
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"bill_type","id_billitm","pycode","wbcode","id_key"};
	}

	@Override
	public String[] getBlurFields() {
		return new String[]{"code_bill","name","pycode","wbcode"};
	}

	
	@Override
	public String getRefSql() {
		String id_dep=(String)this.getExtendAttributeValue("id_dep");
		String id_pripat=(String)this.getExtendAttributeValue("id_pripat");
		String id_emp=(String)this.getExtendAttributeValue("id_emp");
		//0130986 :过滤sd_bltpltp类型的费用模板,该类型为01，则过滤掉为01的费用模板(该参数慎用)
		String filterSdbltpltp = (String)this.getExtendAttributeValue("filterSdbltpltp");
		String sqlContext1 = " and " + EnvContextUtil.processEnvContext("", new BdBlTplDO(), "bltp");//增加组织隔离
		String sqlContext2 = " and " + EnvContextUtil.processEnvContext("", new MedSrvDO(), "srv");//增加组织隔离
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select  ");
		sqlSb.append("code_bill, ");
		sqlSb.append("name, ");
		sqlSb.append("hpsrvtp_name, ");
		sqlSb.append("price_ratio, ");
		sqlSb.append("name_billtype, ");
		sqlSb.append("bill_type, ");
		sqlSb.append("id_billitm, ");
		sqlSb.append("pycode, ");
		sqlSb.append("wbcode, ");
		sqlSb.append("id_key ");
		sqlSb.append("from ( ");
		sqlSb.append("select ");
		sqlSb.append("id_billitm, ");
		sqlSb.append("gr_bltpl.code_bill, ");
		sqlSb.append("gr_bltpl.name, ");
		sqlSb.append("sum(gr_bltpl.quan_medu * gr_bltpl.price_ratio) price_ratio, ");
		sqlSb.append("gr_bltpl.name_billtype, ");
		sqlSb.append("gr_bltpl.pycode, ");
		sqlSb.append("hpsrvtp_name, ");
		sqlSb.append("bill_type, ");
		sqlSb.append("id_key,");
		sqlSb.append("gr_bltpl.wbcode ");
		sqlSb.append(" ");
		sqlSb.append("from ( ");

		sqlSb.append("select bltp.id_bltpl as id_billitm, ");
		sqlSb.append("bltp.code as code_bill, ");
		sqlSb.append("bltp.name, ");
		sqlSb.append(" ");
		sqlSb.append("itm.quan_medu, ");
		sqlSb.append("vprice.price_ratio, ");
		sqlSb.append("'全院模板' name_billtype, ");
		sqlSb.append("bltp.pycode, ");
		sqlSb.append("'模板无等级区分' hpsrvtp_name, ");
		sqlSb.append("1 as bill_type, ");
		sqlSb.append("bltp.id_bltpl|| vprice.ID_PRIPAT id_key, ");
		sqlSb.append("bltp.wbcode ");
		sqlSb.append("from bd_bltpl bltp ");
		sqlSb.append("inner join bd_bltpl_itm itm ");
		sqlSb.append("on bltp.id_bltpl = itm.id_bltpl ");
		sqlSb.append("inner join view_price_rp vprice ");
		sqlSb.append("on itm.id_srv = vprice.id_srv ");
		sqlSb.append("where sd_owtp = 0 ");
		sqlSb.append(sqlContext1);
		if (!StringUtil.isEmpty(id_pripat)) {
			sqlSb.append("and vprice.ID_PRIPAT ='"+id_pripat+"' ");
		}
		if (!StringUtil.isEmpty(filterSdbltpltp)) {
			sqlSb.append("and bltp.sd_bltpltp <> '"+filterSdbltpltp+"' ");
		}
		sqlSb.append("union all  ");
		sqlSb.append("select bltp.id_bltpl as id_billitm, ");
		sqlSb.append("bltp.code as code_bill, ");
		sqlSb.append("bltp.name, ");
		sqlSb.append(" ");
		sqlSb.append("itm.quan_medu, ");
		sqlSb.append("vprice.price_ratio, ");
		sqlSb.append("'科室模板' name_billtype, ");
		sqlSb.append("bltp.pycode, ");
		sqlSb.append("'模板无等级区分' hpsrvtp_name , ");
		sqlSb.append("1 AS bill_type, ");
		sqlSb.append("bltp.id_bltpl|| vprice.ID_PRIPAT id_key, ");
		sqlSb.append("bltp.wbcode ");
		sqlSb.append("from bd_bltpl bltp ");
		sqlSb.append("inner join bd_bltpl_itm itm ");
		sqlSb.append("on bltp.id_bltpl = itm.id_bltpl ");
		sqlSb.append("inner join view_price_rp vprice ");
		sqlSb.append("on itm.id_srv = vprice.id_srv ");
		sqlSb.append("where sd_owtp = 1 ");
		sqlSb.append(sqlContext1);
		if (!StringUtil.isEmpty(id_dep)) {
			sqlSb.append(" and id_dep='"+id_dep+"' ");
		}
		if (!StringUtil.isEmpty(id_pripat)) {
			sqlSb.append("and vprice.id_pripat ='"+id_pripat+"' ");
		}
		if (!StringUtil.isEmpty(filterSdbltpltp)) {
			sqlSb.append("and bltp.sd_bltpltp <> '"+filterSdbltpltp+"' ");
		}
		sqlSb.append("union all  ");
		sqlSb.append("select bltp.id_bltpl as id_billitm, ");
		sqlSb.append("bltp.code code_bill, ");
		sqlSb.append("bltp.name, ");
		sqlSb.append(" ");
		sqlSb.append("itm.quan_medu, ");
		sqlSb.append("vprice.price_ratio, ");
		sqlSb.append("'个人模板' name_billtype, ");
		sqlSb.append("bltp.pycode, ");
		sqlSb.append("'模板无等级区分' hpsrvtp_name, ");
		sqlSb.append("1 AS bill_type, ");
		sqlSb.append("bltp.id_bltpl|| vprice.ID_PRIPAT id_key, ");
		sqlSb.append("bltp.wbcode ");
		sqlSb.append("from bd_bltpl bltp ");
		sqlSb.append("inner join bd_bltpl_itm itm ");
		sqlSb.append("on bltp.id_bltpl = itm.id_bltpl ");
		sqlSb.append("inner join view_price_rp vprice ");
		sqlSb.append("on itm.id_srv = vprice.id_srv ");
		sqlSb.append("where sd_owtp = 2 ");
		sqlSb.append(sqlContext1);
		if (!StringUtil.isEmpty(filterSdbltpltp)) {
			sqlSb.append("and bltp.sd_bltpltp <> '"+filterSdbltpltp+"' ");
		}
		if (!StringUtil.isEmpty(id_emp)&&!StringUtil.isEmpty(id_pripat)) {
			sqlSb.append(" and id_emp='"+id_emp+"' ");
			sqlSb.append("and vprice.id_pripat ='"+id_pripat+"') gr_bltpl ");
		}
		else if(!StringUtil.isEmpty(id_pripat)) {
			sqlSb.append(" and id_emp='"+id_emp+"') gr_bltpl ");
		}else if(!StringUtil.isEmpty(id_emp)){
			sqlSb.append("and vprice.id_pripat ='"+id_pripat+"') gr_bltpl ");
		}else {
			sqlSb.append(" ) gr_bltpl ");
		}
		
		sqlSb.append("group by gr_bltpl.id_billitm, ");
		sqlSb.append("gr_bltpl.code_bill, ");
		sqlSb.append("gr_bltpl.name, ");
		sqlSb.append("gr_bltpl.name_billtype, ");
		sqlSb.append("gr_bltpl.pycode, ");
		sqlSb.append("gr_bltpl.hpsrvtp_name, ");
		sqlSb.append("gr_bltpl.BILL_TYPE, ");
		sqlSb.append("gr_bltpl.id_key, ");
		sqlSb.append("gr_bltpl.wbcode ");
		sqlSb.append("union all ");
		sqlSb.append("select distinct srv.id_srv AS id_billitm, ");
		sqlSb.append("srv.code code_bill, ");
		sqlSb.append("srv.name, ");
		sqlSb.append("vprice1.price_ratio, ");
		sqlSb.append("'组合计价' name_billtype, ");
		sqlSb.append("srv.pycode, ");
		sqlSb.append(" DECODE(srvtp.sd_hpsrvtp_name, ");
		sqlSb.append("                                             NULL, ");
		sqlSb.append("                                             srvtp3.sd_hpsrvtp_name, ");
		sqlSb.append("                                             srvtp.sd_hpsrvtp_name)  hpsrvtp_name, ");
		sqlSb.append("2 AS bill_type, ");
		sqlSb.append("srv.id_srv|| vprice1.id_pripat id_key, ");
		sqlSb.append("srv.wbcode ");
		sqlSb.append("from bd_srv srv ");
		sqlSb.append("inner join view_price_rp vprice1 ");
		sqlSb.append("on srv.id_srv = vprice1.ID_SRV ");
		
		sqlSb.append("left join (select ");
		sqlSb.append("srvorca.id_srv id_srv,");
		sqlSb.append("srvorca.sd_hpsrvtp sd_hpsrvtp ");
		sqlSb.append("from bd_hp_srvorca srvorca ");
		sqlSb.append("inner join bd_hp hp ");
		sqlSb.append("on srvorca.id_hp = hp.id_hp ");
		sqlSb.append("and hp.fg_default = 'Y') srvhp ");
		sqlSb.append("on srv.id_srv = srvhp.id_srv ");
		sqlSb.append(" left  join  (select  distinct  srvca.id_hpsrvorca, ");
		sqlSb.append("                                                                         srvca.id_srv, ");
		sqlSb.append("                                                                         DECODE(srvca.sd_hpsrvtp, ");
		sqlSb.append("                                                                                       NULL, ");
		sqlSb.append("                                                                                       srvtp2.sd_hpsrvtp_name, ");
		sqlSb.append("                                                                                       '~', ");
		sqlSb.append("                                                                                       srvtp2.sd_hpsrvtp_name, ");
		sqlSb.append("                                                                                       udidoc.name)  sd_hpsrvtp_name ");
		sqlSb.append("                                             from  bd_hp_srvorca  srvca ");
		sqlSb.append("                                           inner  join  bd_hp  hp ");
		sqlSb.append("                                                 on  hp.FG_DEFAULT  =  'Y' ");
		sqlSb.append("                                               and  hp.id_hp  =  srvca.id_hp ");
		sqlSb.append("                                           inner  join  mi_hpsrvtp_vs_stdhpsrvtp  srvtp1 ");
		sqlSb.append("                                                 on  srvtp1.SD_STD_HPSRVTP  =  srvca.sd_hpsrvtp ");
		sqlSb.append("                                           inner  join  bd_udidoc  udidoc ");
		sqlSb.append("                                                 on  udidoc.code  =  srvca.sd_hpsrvtp ");
		sqlSb.append("                                           inner  join  bd_udidoclist  udlist ");
		sqlSb.append("                                                 on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sqlSb.append("                                               and  udlist.code  =  'BD.BL.1020' ");
		sqlSb.append("                                             left  outer  join  (select  srvtp.sd_hpsrvtp  as  sd_hpsrvtp_name ");
		sqlSb.append("                                                                                 from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sqlSb.append("                                                                               inner  join  bd_udidoc  udidoc ");
		sqlSb.append("                                                                                     on  udidoc.code  = ");
		sqlSb.append("                                                                                           srvtp.SD_STD_HPSRVTP ");
		sqlSb.append("                                                                                   and  udidoc.ctrl1  =  'Y' ");
		sqlSb.append("                                                                                   and  udidoc.activestate  =  '2' ");
		sqlSb.append("                                                                               inner  join  bd_udidoclist  udlist ");
		sqlSb.append("                                                                                     on  udlist.id_udidoclist  = ");
		sqlSb.append("                                                                                           udidoc.id_udidoclist ");
		sqlSb.append("                                                                                   and  udlist.code  =  'BD.BL.1020' ");
		sqlSb.append("                                                                               where  rownum  =  1)  srvtp2 ");
		sqlSb.append("                                                 on  1  =  1)  srvtp ");
		sqlSb.append("                         on  srvtp.id_srv  =  srv.id_srv ");
		sqlSb.append("                     left  join  (select  srvtp.sd_hpsrvtp  as  sd_hpsrvtp_name ");
		sqlSb.append("                                             from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sqlSb.append("                                           inner  join  bd_udidoc  udidoc ");
		sqlSb.append("                                                 on  udidoc.code  =  srvtp.SD_STD_HPSRVTP ");
		sqlSb.append("                                               and  udidoc.ctrl1  =  'Y' ");
		sqlSb.append("                                               and  udidoc.activestate  =  '2' ");
		sqlSb.append("                                           inner  join  bd_udidoclist  udlist ");
		sqlSb.append("                                                 on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sqlSb.append("                                               and  udlist.code  =  'BD.BL.1020' ");
		sqlSb.append("                                           where  rownum  =  1)  srvtp3 ");
		sqlSb.append("                         on  1  =  1 ");
		
		sqlSb.append("where srv.id_primd = '@@@@AA100000000815Q1' and srv.fg_active = 'Y' ");
		sqlSb.append(sqlContext2);
		if (!StringUtil.isEmpty(id_pripat)) {
			sqlSb.append("and vprice1.id_pripat ='"+id_pripat+"' ");
		}
		sqlSb.append("union all ");
		sqlSb.append("select distinct srv.id_srv AS id_billitm, ");
		sqlSb.append("srv.code code_bill, ");
		sqlSb.append("srv.name, ");
		sqlSb.append("vprice1.price_ratio, ");
		sqlSb.append("'本服务定价' name_billtype, ");
		sqlSb.append("srv.pycode, ");
		sqlSb.append(" DECODE(srvtp.sd_hpsrvtp_name, ");
		sqlSb.append("                                             NULL, ");
		sqlSb.append("                                             srvtp3.sd_hpsrvtp_name, ");
		sqlSb.append("                                             srvtp.sd_hpsrvtp_name)  hpsrvtp_name, ");
		sqlSb.append("3 AS bill_type, ");
		sqlSb.append("srv.id_srv|| vprice1.id_pripat id_key, ");
		sqlSb.append("srv.wbcode ");
		sqlSb.append("from bd_srv srv ");
		sqlSb.append("inner join view_price_rp vprice1 ");
		sqlSb.append("on srv.id_srv = vprice1.ID_SRV ");
		
		sqlSb.append("left join (select ");
		sqlSb.append("srvorca.id_srv id_srv,");
		sqlSb.append("srvorca.sd_hpsrvtp sd_hpsrvtp ");
		sqlSb.append("from bd_hp_srvorca srvorca ");
		sqlSb.append("inner join bd_hp hp ");
		sqlSb.append("on srvorca.id_hp = hp.id_hp ");
		sqlSb.append("and hp.fg_default = 'Y') srvhp ");
		sqlSb.append("on srv.id_srv = srvhp.id_srv ");
		sqlSb.append(" left  join  (select  distinct  srvca.id_hpsrvorca, ");
		sqlSb.append("                                                                         srvca.id_srv, ");
		sqlSb.append("                                                                         DECODE(srvca.sd_hpsrvtp, ");
		sqlSb.append("                                                                                       NULL, ");
		sqlSb.append("                                                                                       srvtp2.sd_hpsrvtp_name, ");
		sqlSb.append("                                                                                       '~', ");
		sqlSb.append("                                                                                       srvtp2.sd_hpsrvtp_name, ");
		sqlSb.append("                                                                                       udidoc.name)  sd_hpsrvtp_name ");
		sqlSb.append("                                             from  bd_hp_srvorca  srvca ");
		sqlSb.append("                                           inner  join  bd_hp  hp ");
		sqlSb.append("                                                 on  hp.FG_DEFAULT  =  'Y' ");
		sqlSb.append("                                               and  hp.id_hp  =  srvca.id_hp ");
		sqlSb.append("                                           inner  join  mi_hpsrvtp_vs_stdhpsrvtp  srvtp1 ");
		sqlSb.append("                                                 on  srvtp1.SD_STD_HPSRVTP  =  srvca.sd_hpsrvtp ");
		sqlSb.append("                                           inner  join  bd_udidoc  udidoc ");
		sqlSb.append("                                                 on  udidoc.code  =  srvca.sd_hpsrvtp ");
		sqlSb.append("                                           inner  join  bd_udidoclist  udlist ");
		sqlSb.append("                                                 on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sqlSb.append("                                               and  udlist.code  =  'BD.BL.1020' ");
		sqlSb.append("                                             left  outer  join  (select  srvtp.sd_hpsrvtp  as  sd_hpsrvtp_name ");
		sqlSb.append("                                                                                 from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sqlSb.append("                                                                               inner  join  bd_udidoc  udidoc ");
		sqlSb.append("                                                                                     on  udidoc.code  = ");
		sqlSb.append("                                                                                           srvtp.SD_STD_HPSRVTP ");
		sqlSb.append("                                                                                   and  udidoc.ctrl1  =  'Y' ");
		sqlSb.append("                                                                                   and  udidoc.activestate  =  '2' ");
		sqlSb.append("                                                                               inner  join  bd_udidoclist  udlist ");
		sqlSb.append("                                                                                     on  udlist.id_udidoclist  = ");
		sqlSb.append("                                                                                           udidoc.id_udidoclist ");
		sqlSb.append("                                                                                   and  udlist.code  =  'BD.BL.1020' ");
		sqlSb.append("                                                                               where  rownum  =  1)  srvtp2 ");
		sqlSb.append("                                                 on  1  =  1)  srvtp ");
		sqlSb.append("                         on  srvtp.id_srv  =  srv.id_srv ");
		sqlSb.append("                     left  join  (select  srvtp.sd_hpsrvtp  as  sd_hpsrvtp_name ");
		sqlSb.append("                                             from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sqlSb.append("                                           inner  join  bd_udidoc  udidoc ");
		sqlSb.append("                                                 on  udidoc.code  =  srvtp.SD_STD_HPSRVTP ");
		sqlSb.append("                                               and  udidoc.ctrl1  =  'Y' ");
		sqlSb.append("                                               and  udidoc.activestate  =  '2' ");
		sqlSb.append("                                           inner  join  bd_udidoclist  udlist ");
		sqlSb.append("                                                 on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sqlSb.append("                                               and  udlist.code  =  'BD.BL.1020' ");
		sqlSb.append("                                           where  rownum  =  1)  srvtp3 ");
		sqlSb.append("                         on  1  =  1 ");
		
		sqlSb.append("where srv.id_primd = '@@@@AA1000000000VBBQ' and srv.fg_active = 'Y'  and srv.fg_active_bl = 'Y' ");
		sqlSb.append(sqlContext2);
		if (!StringUtil.isEmpty(id_pripat)) {
			sqlSb.append("and vprice1.id_pripat ='"+id_pripat+"' ");
		}
		sqlSb.append(" ) A  where 1=1 ");
	
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" and (").append(where).append(") ");
			}
		}
		return sqlSb.toString();
	}
}
