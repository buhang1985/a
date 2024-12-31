/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getOrSrvGuideDTOQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月6日 下午4:44:31
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getOrSrvGuideDTOQry implements ITransQry {

	private String _id_or;
	private String _id_orsrv;
	private String[] _id_orsrvs;
	public getOrSrvGuideDTOQry(String id_or,String id_orsrv){
		this._id_or = id_or;
		this._id_orsrv = id_orsrv;
	}
	public getOrSrvGuideDTOQry( String[] id_orsrv){
	 
		this._id_orsrvs = id_orsrv;
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
////		param.addParam(this._id_or);
////		param.addParam(this._id_orsrv);
		return param;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
  
	 private String getSql(){
		 StringBuffer sb = new StringBuffer();
		 sb.append("  select ciorder.id_or, cisrv.id_orsrv, cisrv.id_srv,ciorder.days_or days,");
		 sb.append("  cisrv.quan_medu dosage ,  bd_mm.sd_mmtp,cimm.factor_mb,cimm.factor as factor_sb ,bd_mm.sd_opmutp,");
	     sb.append("  srvorca.code_dosage  dosecode_hp,bdfreq.id_freq,");
	     sb.append("  dosage.name_hp dosename_hp,UDIDOC.Code dosecode,");
	     sb.append("  hpfreq.code_hp freqcode_hp,hpfreq.name_hp freqname_hp, bdfreq.code freqcode,");
	     sb.append("  cimm.days_available , cisrv.id_medu,doc.name name_medu,bd_mm.apprno Drugapprovalnumber, ");
         sb.append("  FREQ.Freqct,nvl(cimm.quan_cur,cisrv.Quan_total_medu) Quan_total_medu,cisrv.fg_selfpay ");
	     sb.append("  from ci_or_srv cisrv ");
	     sb.append("  left join ci_order ciorder on  ciorder.id_or = cisrv.id_or ");
	     sb.append("  left join ci_or_srv_mm cimm on cisrv.id_orsrv = cimm.id_orsrv ");
	     sb.append("  left join bd_hp_dosage dosage  on cisrv.id_hp = dosage.id_hp and cimm.id_dosage = dosage.id_dosage ");
	     sb.append("  left join bd_hp_freq   hpfreq on hpfreq.id_freq = cisrv.id_freq  and hpfreq.id_hp = cisrv.id_hp ");
	     sb.append("  left join bd_freq  bdfreq on bdfreq.id_freq = cisrv.id_freq ");
		 sb.append("  left join bd_udidoc udidoc  on udidoc.id_udidoc = cimm.id_dosage ");
		 sb.append("  left outer join bd_mm bd_mm  on cimm.id_mm = bd_mm.id_mm  ");
		 sb.append("  left join bd_measdoc doc on cimm.id_pgku_base=doc.id_measdoc ");
		 sb.append("  LEFT JOIN BD_FREQ FREQ ON FREQ.ID_FREQ=CISRV.ID_FREQ ");
		 sb.append("  left join bd_hp_srvorca srvorca on srvorca.id_mm=cimm.id_mm and srvorca.id_hp=cisrv.id_hp ");
		 sb.append("   where   cisrv.id_orsrv in ");
		 sb.append( getOrSrv(this._id_orsrvs));
		 sb.append("     ");
		 return sb.toString();
	 }
	 
	 
	 private String getOrSrv(String[] Orsrv){
		 if(Orsrv == null || Orsrv.length == 0) new BizException("parameter id_orsrv 为空！"); 
		 String srv = "";
		 srv += "(";
		 for(String tp:Orsrv){
			 srv += "'"+tp +"',";
		 }
		 srv = srv.substring(0, srv.lastIndexOf(","));
		 srv += ")";
		 return srv;
	 }
	/* select ciorder.id_or, cisrv.id_orsrv, cisrv.id_srv,ciorder.days_or days,cisrv.quan_medu dosage , dosage.code_hp  dosecode_hp
	 ,dosage.name_hp dosename_hp,cimm.sd_dosage ,
	       hpfreq.code_hp freqcode_hp,hpfreq.name_hp freqname_hp, bdfreq.code freqcode,
	       udidoc.code dosecode, udidoc.name dosename
	from ci_or_srv cisrv 
	  left join ci_order ciorder on  ciorder.id_or = cisrv.id_or
	  left join  ci_or_srv_mm cimm on cisrv.id_orsrv = cimm.id_orsrv
	  left join bd_hp_dosage dosage  on cisrv.id_hp = dosage.id_hp and cimm.id_dosage = dosage.id_dosage
	  left join bd_hp_freq   hpfreq on hpfreq.id_freq = cisrv.id_freq  and hpfreq.id_hp = cisrv.id_hp
	  left join bd_freq  bdfreq on bdfreq.id_freq = cisrv.id_freq
	  left join   bd_udidoc udidoc  on udidoc.id_udidoc = cimm.id_dosage
	  where cisrv.id_or = ''
	    and cisrv.id_orsrv =''*/
}
