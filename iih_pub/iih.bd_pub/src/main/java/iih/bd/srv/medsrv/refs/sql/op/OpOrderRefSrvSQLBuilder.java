package iih.bd.srv.medsrv.refs.sql.op;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import xap.mw.core.data.Context;
import xap.sie.common.utils.StringUtils;
/**
 * 组装服务的参照信息
 * @author zhangwq
 *
 */
public class OpOrderRefSrvSQLBuilder {
	/**
	 * 备注信息字段显示构建
	 * @return
	 */
	public String getDesField( ){
		String hptypeDisplay = HptypeDisplay.getInstance().getHptyDisplay();
		StringBuffer sql = new StringBuffer();
		sql.append("(case " );
		sql.append(String.format(" when hpsrvca.code is null and srv.fg_bl = 'Y' then '%s ' when hptp.name is null and srv.fg_bl = 'Y' then '%s ' else hptp.name end) ",hptypeDisplay,hptypeDisplay));
		sql.append("  || (case when hpsrvca.rate is null then '' else ' 报销比例：'||CONCAT(TO_CHAR(hpsrvca.rate*100, 'fm9999999990'),'%')||' ' end) ");
		sql.append("  ||srv.des ||DECODE(hpsrvca.des,NULL,'',' '||hpsrvca.des)||DECODE(hpsrvca.note,NULL,'',' '||hpsrvca.note)   " );
		sql.append("  des, " );
		return sql.toString();
	}
	/**
	 * 换算系数字构建
	 * @return
	 */
	public String getPakbasefactorField(){
		StringBuffer sql = new StringBuffer();
		sql.append("'' as pakbasefactor, " );
		return sql.toString();
	}
	public StringBuffer getSelectBuilder(){
		StringBuffer sql = new StringBuffer();
		sql.append("select srv.name name_srvmm, ");
		sql.append("to_char(price_ratio, 'fm9999999990.00') des_pri, " );
		sql.append("srvca.fullname as srvtp, " );
		sql.append("srvtpdoc.name name_srvtp, " );
		sql.append("'' name_unit_sale, " );
		sql.append(getPakbasefactorField());
		sql.append(getDesField());
		sql.append("srv.code, " );
		sql.append("srv.id_srv idsrvidmm , " );
		sql.append("srv.id_srv, " );
		sql.append("srv.sd_srvtp, " );
		sql.append("'' Id_mm, " );
		sql.append("srv.fg_ctm, " );
		sql.append("'' as id_unit_sale, " );
		sql.append("srv.pycode ");
		return sql;
	}
	/**
	 * 
	 * @param sd_inputmethod 01:拼音码,10:五笔码,11:五笔码和拼音码
	 * @param id_hp
	 * @param id_pripat
	 * @param blurValue
	 * @param whereList
	 * @return
	 */
	public StringBuffer getSQL(String sd_inputmethod,String id_hp,String id_pripat,String blurValue,List<String> whereList) {
		StringBuffer sql = this.getSelectBuilder();
		sql.append(" from bd_srv srv " );
		sql.append("left join view_price_rp blprice " );
		sql.append("  on srv.ID_SRV = blprice.id_srv " );
		if(StringUtils.isNotEmpty(id_pripat)){
			sql.append(" and blprice.ID_PRIPAT = '"+id_pripat+"' " );
		}
		sql.append("LEFT OUTER JOIN bd_srvca srvca " );
		sql.append("  ON srvca.id_srvca = srv.id_srvca " );
		sql.append("left join bd_hp_srvorca hpsrvca " );
		sql.append("  on srv.id_srv = hpsrvca.id_srv " );
		sql.append(" and hpsrvca.id_hp = '"+id_hp+"' " );
		sql.append("left join bd_hp_srvctr hpsrvctr " );
		sql.append("  on srv.id_srv = hpsrvctr.id_srv " );
		sql.append(" and hpsrvctr.eu_hpsrvtp = hpsrvca.eu_hpsrvtp " );
		sql.append("LEFT JOIN bd_udidoc hptp ");
		sql.append("ON hptp.code           = hpsrvca.sd_hpsrvtp ");
		sql.append("AND hptp.ACTIVESTATE        = '2' ");
		sql.append("AND hptp.id_udidoclist = '@@@@ZZ2000000000003P' ");
		sql.append("left join bd_udidoc srvtpdoc " );
		sql.append("  on srvtpdoc.code = substr(srv.sd_srvtp, 0, 2) and srvtpdoc.id_udidoclist = '@@@@ZZ2000000000000T' " );
		sql.append(getWherePart(sd_inputmethod,blurValue,whereList));
		return sql;
	}
	/**
	 * 
	 * @param sd_inputmethod 01:拼音码,10:五笔码,11:五笔码和拼音码
	 * @param blurValue
	 * @param whereList
	 * @return
	 */
	private String getWherePart(String sd_inputmethod,String blurValue, List<String> whereList){
		StringBuffer sql = new StringBuffer();
		if(StringUtils.isNotEmpty(blurValue)){
			blurValue = blurValue.toLowerCase().trim();
		}
		sql.append(" where srv.fg_mm  ='N' and srv.ds= 0 and srv.fg_active = 'Y' and (srv.fg_bl = 'N' or ( srv.fg_bl = 'Y' and srv.fg_active_bl='Y')) and   srv.fg_or = 'Y' and srv.id_org= '"+Context.get().getOrgId()+"' and srv.id_grp= '"+Context.get().getGroupId()+"'" );
		sql.append(this.getUseScope());
		if(StringUtils.isNotEmpty(blurValue)){
			sql.append("  and (lower(srv.name) like '%"+blurValue+"%' or lower(srv.code) like '%"+blurValue+"%' or lower(srv.shortname) like '%"+blurValue+"%' " );
			if("01".equals(sd_inputmethod)){
				sql.append(" or lower(srv.pycode) like '%"+blurValue+"%'"); 
				sql.append("  OR srv.id_srv in (select id_srv from bd_srv_als srv_alias where lower(srv_alias.alias) LIKE '%"+blurValue+"%'  OR lower(srv_alias.pycode) LIKE '%"+blurValue+"%'  )"); 

			}else if("10".equals(sd_inputmethod)){
				sql.append(" or lower(srv.wbcode) like '%"+blurValue+"%'"); 
				sql.append("  OR srv.id_srv in (select id_srv from bd_srv_als srv_alias where lower(srv_alias.alias) LIKE '%"+blurValue+"%'  OR lower(srv_alias.wbcode) LIKE '%"+blurValue+"%'  )"); 

			}else{
				sql.append(" or lower(srv.pycode) like '%"+blurValue+"%' or  lower(srv.wbcode) like '%"+blurValue+"%'"); 
				sql.append("  OR srv.id_srv in (select id_srv from bd_srv_als srv_alias where lower(srv_alias.wbcode) LIKE '%"+blurValue+"%' OR lower(srv_alias.alias) LIKE '%"+blurValue+"%'  OR lower(srv_alias.pycode) LIKE '%"+blurValue+"%'  )"); 

			}
			sql.append(" or lower(srv.mnecode) like '%"+blurValue+"%') " );
		}
		if(whereList!=null){
			for(String wherePart : whereList){
				if(wherePart.contains("idsrvidmm"))
					{
					
					int index =wherePart.indexOf("idsrvidmm");
					String a=wherePart.substring(0,index);
					if(a.trim().endsWith(".")) {
						String t=wherePart.replace("idsrvidmm", "id_srv ");
						sql.append(" and " + t);
					}else {
						String t=wherePart.replace("idsrvidmm", " srv.id_srv ");
						sql.append(" and " + t);
					}
					
					continue;}
				sql.append(" and " + wherePart);
			}
		}
		//sql.append(" order by length(srv.pycode) asc,srv.pycode ");
		return sql.toString();
	}
	public String getUseScope(){
		return "and srv.fg_use_op = 'Y'";
	}
	protected String addOrderBy(){
		return " order by length(name_srvmm) asc,pycode ";
	}
}
