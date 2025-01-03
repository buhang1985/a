package iih.bd.srv.medsrv.refs.sql.op;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import xap.mw.core.data.Context;
import xap.sie.common.utils.StringUtils;
/**
 * 组装物品的参照信息
 * @author zhangwq
 *
 */
public class OpOrderRefMMSQLBuilder {

	public String getCodeEntp() {
		return "'00'";
	}
	/**
	 * 获取适用范围
	 * @param alias 别名
	 * @return
	 */
	public String getUseScope(String alias){
		if(StringUtils.isEmpty(alias)){
			return "and fg_use_op = 'Y' ";
		}
		return "and "+alias+".fg_use_op='Y' ";
	}

	public String getMmpkugtp(){
		return "and mmpkug.en_oppkgtp is not null ";
	}
	
	/**
	 * 商品通用和普通返回的code区分
	 * @return
	 */
	public String getParam(){
		return "(case when srv.sd_srvtp like '010%' then mm.code else srv.code end) code, ";
	}
	/**
	 * 备注信息构建
	 * @return
	 */
	public String getDesField(){
		String hptypeDisplay = HptypeDisplay.getInstance().getHptyDisplay();
		StringBuffer sql = new StringBuffer();
		sql.append("( " );
		sql.append("  (case when mm.fg_keymonitor ='Y' then '【重点监控】' end)");
		sql.append("  || (case when mmgroup.name is not null then  ' ('||mmgroup.name||') ' else'' end)");
		sql.append(String.format("  || (case when hpsrvca.code is null and srv.fg_bl = 'Y' then '%s ' when hptp.name is null and srv.fg_bl = 'Y' then '%s ' else hptp.name end) ",hptypeDisplay,hptypeDisplay));
		sql.append("  || (case when hpsrvca.rate is null then '' else ' 报销比例：'||CONCAT(TO_CHAR(hpsrvca.rate*100, 'fm9999999990'),'%')||' ' end) ");
		sql.append("  || case when basedrugrange.name is not null then ' ('||basedrugrange.name||') ' else '' end ||antidoc.name||' ' " );
		sql.append("  ||poisdoc.name||' ' " );
		sql.append("  ||decode(mm.sup_name,null,'','【' || mm.sup_name || '】') " );
		sql.append("  ||abrddoc.name " );
		sql.append("  ||DECODE(hpsrvca.des,NULL,'',' '||hpsrvca.des)||DECODE(hpsrvca.note,NULL,'',' '||hpsrvca.note)  ||srv.des " );
		sql.append(")as des, " ); 
		return sql.toString();
	}
	/**
	 * 换算系数字段构建
	 * @return
	 */
	public String getPakbasefactorField(){
		StringBuffer sql = new StringBuffer();
		sql.append("'' as pakbasefactor, " );
		return sql.toString();
	}
	/**
	 * 大小包装下的换算系数构建
	 * @return
	 */
	public String getMMPakbasefactorField(){
		return "mmpkug.factor || mm.name_unit_pkgbase as pakbasefactor, " ;
	}
	/**
	 * 非大小包装下查询字段
	 * @return
	 */
	public StringBuffer getSelectBuilder(){
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct ");
		sql.append("srv.name||'[' || decode(srv.name, mm.name, '', mm.name) || mm.spec || ']' as name_srvmm, " );
		sql.append("to_char(mm.price, 'fm9999999990.00') as des_pri, " );
		sql.append("srvca.fullname as srvtp, " );
		sql.append("srvtpdoc.name as name_srvtp, " );
		sql.append("'' as name_unit_sale, " );
		sql.append(getPakbasefactorField());
		sql.append(getDesField());
		sql.append(getParam());
		sql.append("srv.id_srv || mm.id_mm as idsrvidmm, " );
		sql.append("srv.id_srv, " );
		sql.append("srv.sd_srvtp, " );
		sql.append("mm.id_mm, " );
		sql.append("srv.fg_ctm, " );
		sql.append("'' as id_unit_sale, " );
		sql.append("srv.pycode ");
		return sql;
	}
	/**
	 * 大小包装下，查询字段
	 * @return
	 */
	public StringBuffer getPkgSelectBuilder(){
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct ");
		sql.append("srv.name||'[' || decode(srv.name, mm.name, '', mm.name) || mm.spec || ']' as name_srvmm, " );
		sql.append("to_char(mm.price * (mmpkug.factor / mm.factor_sb), 'fm9999999990.00') as des_pri, " );
		sql.append("srvca.fullname as srvtp, " );
		sql.append("srvtpdoc.name as name_srvtp, " );
		sql.append("measdoc.name as name_unit_sale, " );
		sql.append(getMMPakbasefactorField());
		sql.append(getDesField());
		sql.append(getParam());
		sql.append("srv.id_srv || mm.id_mm|| mmpkug.id_unit_pkg as idsrvidmm, " );
		sql.append("srv.id_srv, " );
		sql.append("srv.sd_srvtp, " );
		sql.append("mm.id_mm, " );
		sql.append("srv.fg_ctm, " );
		sql.append("mmpkug.id_unit_pkg as id_unit_sale, " );
		sql.append("srv.pycode ");
		return sql;
	}
	/**
	 * 到商品的sql
	 * @param sd_inputmethod 01:拼音码,10:五笔码,11:五笔码和拼音码
	 * @param id_hp
	 * @param blurValue
	 * @param whereList
	 * @return
	 */
	public StringBuffer getSrvMmSQL(String sd_inputmethod,String id_hp,String blurValue,List<String> whereList,String mmGroupCodeParam,String herbpreparationtp) {
		StringBuffer sql = this.getSelectBuilder();
		sql.append("from " );
		sql.append("( " );
		sql.append("  select " );
		sql.append("  min(cfg.id_dep_mp) id_dep_mp " );
		sql.append("  from bd_wf_cfg cfg " );
		sql.append("  inner join bd_wf wf on wf.id_wf = cfg.id_wf and wf.eu_wftp = 2 and wf.code_entp = "+getCodeEntp()+" " );
		sql.append("  left join bd_wf_cfg_attr attr on cfg.id_wf_cfg = attr.id_wf_cfg and attr.eu_attr = 7 " );
		sql.append("  group by cfg.id_wf_cfg,cfg.eu_dep_or ");
		sql.append("  having min(case when cfg.eu_dep_or = 0 then 0 when '"+Context.get().getDeptId()+"' = attr.id_dep then 1 else 2 end) = cfg.eu_dep_or " );
		sql.append(")wfcfg " );
		sql.append("inner join bd_wh wh on wh.id_dep_belong = wfcfg.id_dep_mp " );
		sql.append("inner join bd_mm_wh mmwh on mmwh.id_wh = wh.id_wh and mmwh.fg_out ='N' " );
		sql.append("inner join bd_mm mm on mmwh.id_mm = mm.id_mm and mm.fg_out = 'N' " );
		sql.append(getHerbPreParationType(herbpreparationtp));
		sql.append("inner join bd_srv srv on srv.id_srv = mm.id_srv and srv.id_org= '"+Context.get().getOrgId()+"' and srv.id_grp= '"+Context.get().getGroupId()+"'"  );
		sql.append("and srv.fg_or='Y' and srv.fg_mm = 'Y' and srv.ds = 0 and srv.fg_active = 'Y' and mm.ds = 0 and mm.fg_active = 'Y' "+getUseScope("srv"));
		sql.append("inner join bd_srv_drug srvdrug on srvdrug.id_srv = mm.id_srv " );
		sql.append("left join bd_srvca srvca on srvca.id_srvca = srv.id_srvca " );
		sql.append("left join bd_hp_srvorca hpsrvca on srv.id_srv = hpsrvca.id_srv and hpsrvca.id_hp = '"+id_hp+"' and hpsrvca.id_mm = mm.id_mm " );
		sql.append("left join bd_hp_srvctr hpsrvctr on hpsrvca.id_srv = hpsrvctr.id_srv and hpsrvctr.eu_hpsrvtp = hpsrvca.eu_hpsrvtp " );
		sql.append("left join bd_udidoc basedrugrange on basedrugrange.id_udidoc = mm.id_basedrugrange " );
		sql.append("left join bd_udidoc srvtpdoc on srvtpdoc.code = substr(srv.sd_srvtp, 0, 2) and srvtpdoc.id_udidoclist = '@@@@ZZ2000000000000T' " );
		sql.append("left join bd_udidoc poisdoc on poisdoc.id_udidoc = srvdrug.id_pois and poisdoc.id_udidoclist = '@@@@ZZ2000000000002T' " );
		sql.append("left join bd_udidoc abrddoc on abrddoc.id_udidoc = mm.id_abrd and abrddoc.id_udidoclist = '@@@@ZZ2000000000002P' " );
		sql.append("left join bd_udidoc antidoc on antidoc.id_udidoc = srvdrug.id_anti and antidoc.id_udidoclist = '@@@@ZZ2000000000002U' ");
		sql.append("left join bd_udidoc hptp on hptp.code = hpsrvca.sd_hpsrvtp and hptp.ACTIVESTATE = '2' and hptp.id_udidoclist = '@@@@ZZ2000000000003P' ");
		sql.append("left JOIN (select mmgrpitm.id_mm,to_char(wm_concat(mmgrp.name)) name from bd_mmgrp_itm mmgrpitm " );
		sql.append(String.format("inner join bd_mmgrp mmgrp on mmgrp.id_mmgrp = mmgrpitm.id_mmgrp and mmgrp.code in (%s) ",mmGroupCodeParam));
		sql.append("group by mmgrpitm.id_mm) mmgroup on mmgroup.id_mm = mm.id_mm ");
		sql.append(getWherePart(sd_inputmethod,blurValue,whereList));
		return sql;
	}
	/**
	 * 到商品大小包装
	 * @param sd_inputmethod 01:拼音码,10:五笔码,11:五笔码和拼音码
	 * @param id_hp
	 * @param blurValue
	 * @param whereList
	 * @return
	 */
	public StringBuffer getSrvMmPkgSQL(String sd_inputmethod,String id_hp,String blurValue,List<String> whereList,String mmGroupCodeParam,String herbpreparationtp) {
		StringBuffer sql = this.getPkgSelectBuilder();
		sql.append("from " );
		sql.append("( " );
		sql.append("  select " );
		sql.append("  min(cfg.id_dep_mp) id_dep_mp " );
		sql.append("  from bd_wf_cfg cfg " );
		sql.append("  inner join bd_wf wf on wf.id_wf = cfg.id_wf and wf.eu_wftp = 2 and wf.code_entp = "+getCodeEntp()+" " );
		sql.append("  left join bd_wf_cfg_attr attr on cfg.id_wf_cfg = attr.id_wf_cfg and attr.eu_attr = 7 " );
		sql.append("  group by cfg.id_wf_cfg,cfg.eu_dep_or ");
		sql.append("  having min(case when cfg.eu_dep_or = 0 then 0 when '"+Context.get().getDeptId()+"' = attr.id_dep then 1 else 2 end) = cfg.eu_dep_or " );
		sql.append(")wfcfg " );
		sql.append("inner join bd_wh wh on wh.id_dep_belong = wfcfg.id_dep_mp " );
		sql.append("inner join bd_mm_wh mmwh on mmwh.id_wh = wh.id_wh and mmwh.fg_out = 'N' " );
		sql.append("inner join bd_mm mm on mmwh.id_mm = mm.id_mm and mm.fg_out = 'N' and mm.id_org= '"+Context.get().getOrgId()+"' and mm.id_grp= '"+Context.get().getGroupId()+"'" );
		sql.append(getHerbPreParationType(herbpreparationtp));
		sql.append("inner join bd_srv srv on srv.id_srv = mm.id_srv " );
		sql.append("and srv.fg_mm = 'Y' and srv.ds = 0 and srv.fg_active = 'Y' and mm.ds = 0 and mm.fg_active = 'Y' "+this.getUseScope("srv")+" " );
		sql.append("inner join bd_srv_drug srvdrug on srvdrug.id_srv = mm.id_srv " );
		sql.append("inner join bd_mm_pkgu mmpkug on mmpkug.id_mm = mm.id_mm "+getMmpkugtp());
		sql.append("left join bd_measdoc measdoc on measdoc.id_measdoc = mmpkug.id_unit_pkg " );
		sql.append("left join bd_srvca srvca on srvca.id_srvca = srv.id_srvca " );
		sql.append("left join bd_hp_srvorca hpsrvca on srv.id_srv = hpsrvca.id_srv and hpsrvca.id_hp = '"+id_hp+"' and hpsrvca.id_mm = mm.id_mm " );
		sql.append("left join bd_hp_srvctr hpsrvctr on hpsrvca.id_srv = hpsrvctr.id_srv and hpsrvctr.eu_hpsrvtp = hpsrvca.eu_hpsrvtp " );
		sql.append("left join bd_udidoc basedrugrange on basedrugrange.id_udidoc = mm.id_basedrugrange AND basedrugrange.id_udidoclist = '@@@@TL40000000000171'" );
		sql.append("left join bd_udidoc srvtpdoc on srvtpdoc.code = substr(srv.sd_srvtp, 0, 2) and srvtpdoc.id_udidoclist = '@@@@ZZ2000000000000T' " );
		sql.append("left join bd_udidoc poisdoc on poisdoc.id_udidoc = srvdrug.id_pois and poisdoc.id_udidoclist = '@@@@ZZ2000000000002T' " );
		sql.append("left join bd_udidoc abrddoc on abrddoc.id_udidoc = mm.id_abrd and abrddoc.id_udidoclist = '@@@@ZZ2000000000002P' " );
		sql.append("left join bd_udidoc antidoc on antidoc.id_udidoc = srvdrug.id_anti and antidoc.id_udidoclist = '@@@@ZZ2000000000002U' ");
		sql.append("left join bd_udidoc hptp on hptp.code = hpsrvca.sd_hpsrvtp and hptp.ACTIVESTATE = '2' and hptp.id_udidoclist = '@@@@ZZ2000000000003P' ");
		sql.append("left JOIN (select mmgrpitm.id_mm,to_char(wm_concat(mmgrp.name)) name from bd_mmgrp_itm mmgrpitm " );
		sql.append(String.format("inner join bd_mmgrp mmgrp on mmgrp.id_mmgrp = mmgrpitm.id_mmgrp and mmgrp.code in (%s) ",mmGroupCodeParam));
		sql.append("group by mmgrpitm.id_mm) mmgroup on mmgroup.id_mm = mm.id_mm ");
		sql.append(getWherePart(sd_inputmethod,blurValue,whereList));
		return sql;
	}
	/**
	 * 草药制剂类型编码
	 * @param herbpreparationtp
	 * @return
	 */
	public String getHerbPreParationType(String herbpreparationtp){
		if(StringUtils.isEmpty(herbpreparationtp))return " ";
		if(IBdSrvDictCodeConst.SD_HERB_PREPARATIONTP_YP.equals(herbpreparationtp)){
			return " and mm.sd_herbpreparationtp='0' ";
		}else if(IBdSrvDictCodeConst.SD_HERB_PREPARATIONTP_KL.equals(herbpreparationtp)){
			return " and mm.sd_herbpreparationtp='1' ";
		}else if(IBdSrvDictCodeConst.SD_HERB_PREPARATIONTP_FJ.equals(herbpreparationtp)){
			return " and mm.sd_herbpreparationtp='2' ";
		}
		return " ";
	}
	/**
	 * 
	 * @param sd_inputmethod 01:拼音码,10:五笔码,11:五笔码和拼音码
	 * @param blurValue
	 * @param whereList
	 * @return
	 */
	public String getWherePart(String sd_inputmethod,String blurValue, List<String> whereList){
		StringBuffer sql = new StringBuffer();
		if(StringUtils.isNotEmpty(blurValue)){
			blurValue = blurValue.toLowerCase().trim();
		}
		sql.append(" where 1=1 ");
		if(StringUtils.isNotEmpty(blurValue)){
			sql.append(" and (lower(srv.name) like '%"+blurValue+"%' or lower(srv.code) like '%"+blurValue+"%' or lower(srv.shortname) like '%"+blurValue+"%' or lower(srv.mnecode) like '%"+blurValue+"%' " );
			if("01".equals(sd_inputmethod)){
				sql.append(" or lower(srv.pycode) like '%"+blurValue+"%' or  lower(mm.pycode) like '%"+blurValue+"%'"); 
				sql.append("  OR srv.id_srv in (select id_srv from bd_srv_als srv_alias where lower(srv_alias.alias) LIKE '%"+blurValue+"%'  OR lower(srv_alias.pycode) LIKE '%"+blurValue+"%'  )"); 
				sql.append("   OR mm.id_mm in  ( select id_mm from bd_mm_name mm_alias where  lower(mm_alias.name) LIKE '%"+blurValue+"%' OR lower(mm_alias.pycode) LIKE '%"+blurValue+"%'   ) "); 

			}else if("10".equals(sd_inputmethod)){
				sql.append(" or lower(srv.wbcode) like '%"+blurValue+"%' or lower(mm.wbcode) like '%"+blurValue+"%'"); 
				sql.append("  OR srv.id_srv in (select id_srv from bd_srv_als srv_alias where lower(srv_alias.alias) LIKE '%"+blurValue+"%'  OR lower(srv_alias.wbcode) LIKE '%"+blurValue+"%'  )"); 
				sql.append("   OR mm.id_mm in  ( select id_mm from bd_mm_name mm_alias where  lower(mm_alias.name) LIKE '%"+blurValue+"%' OR lower(mm_alias.wbcode) LIKE '%"+blurValue+"%'   ) "); 

			}else{
				sql.append(" or lower(srv.pycode) like '%"+blurValue+"%' or  lower(mm.pycode) like '%"+blurValue+"%'"); 
				sql.append(" or lower(srv.wbcode) like '%"+blurValue+"%' or lower(mm.wbcode) like '%"+blurValue+"%'"); 
				sql.append("  OR srv.id_srv in (select id_srv from bd_srv_als srv_alias where lower(srv_alias.wbcode) LIKE '%"+blurValue+"%' OR lower(srv_alias.alias) LIKE '%"+blurValue+"%'  OR lower(srv_alias.pycode) LIKE '%"+blurValue+"%'  )"); 
				sql.append("   OR mm.id_mm in  ( select id_mm from bd_mm_name mm_alias where  lower(mm_alias.wbcode) LIKE '%"+blurValue+"%' OR lower(mm_alias.name) LIKE '%"+blurValue+"%'  OR lower(mm_alias.pycode) LIKE '%"+blurValue+"%'   ) "); 

			}
			sql.append(" or lower(mm.name) like '%"+blurValue+"%' or lower(mm.code) like '%"+blurValue+"%' or lower(mm.mnecode) like '%"+blurValue+"%' )" );
			
		}
		if(whereList!=null){
			for(String wherePart : whereList){
				if(wherePart.contains("idsrvidmm"))
				{	
					int index =wherePart.indexOf("idsrvidmm");
					String a=wherePart.substring(0,index);
					if(a.trim().endsWith(".")) {
						String t=wherePart.replace("idsrvidmm", "id_srv || mm.id_mm");
						sql.append(" and " + t);
					}else {
						String t=wherePart.replace("idsrvidmm", " srv.id_srv || mm.id_mm");
						sql.append(" and " + t);
					}
					continue;
					}
				sql.append(" and " + wherePart);
			}
		}
		return sql.toString();
	}
	protected String addOrderBy(){
		return " order by length(name_srvmm) asc,pycode ";
	}
}
