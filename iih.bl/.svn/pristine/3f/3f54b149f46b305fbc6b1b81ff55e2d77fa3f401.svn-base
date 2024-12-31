package iih.bl.inc.blincquery.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.service.IBlcgqueryService;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlIncoepqueryDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceHeadTailDTO;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.inc.blincquerydto.d.BlincitmIpDTO;
import iih.bl.inc.blincquerydto.d.DetailsReceiptDTO;
import iih.bl.inc.blincquerydto.d.OepInccaItmDTO;
import iih.bl.params.BlParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.dataper.d.DataPerRuleDO;

/** 文件头注释
* ==============================================================================
* @Filename: BlincqueryBp   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author li_pengying
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description: 发票票据查询的接口实现类
* ==============================================================================
*/
public class BlincqueryBp {
	
	
	  
	/**
	 * 功能：对门诊和住院发票表所合成的一个新表t3进行查询时用，根据其id来查到某条数据
	 * @param id_bilincdto
	 * @return
	 * @throws BizException
	 */
	public BlincQueryDTO[] findByIdincAndIdincca(String id_bilincdto,String id_incca)throws BizException {
		StringBuffer sql1=new StringBuffer();
		sql1.append(" select distinct t3.id_inc,");
	    sql1.append(" t3.id_pat,");
		sql1.append(" t3.id_ent,");
		sql1.append(" t3.id_enttp,");
		sql1.append(" t3.id_incca,");
	    sql1.append(" t3.code_incpkg,");
		sql1.append(" t3.incno,");
		sql1.append(" t3.dt_inc,");
		sql1.append(" t3.amt,");
	    sql1.append(" t3.id_emp_inc,");
	    sql1.append(" t3.fg_canc,");
	    sql1.append(" t3.fg_print,");
	    sql1.append(" t3.sd_reason_canc,");
		sql1.append(" t3.des_reason_canc,");
		sql1.append(" t3.id_emp_canc,");
	    sql1.append(" t3.dt_canc,");
		sql1.append(" t3.ds,");
		sql1.append(" t3.sv,");
		sql1.append(" t3.id_org,");
		sql1.append(" t3.id_grp,");
		sql1.append(" t3.code_enttp,");
	    sql1.append(" t3.amt_pat,");
	    sql1.append(" t3.note,");
	 	sql1.append(" t3.times_prn, t4.name as patname, t4.code  as patcode,");
	 	sql1.append(" t5.code as entcode, t6.name as entp_name,");
	 	sql1.append(" t7.name as emp_name,");
	 	sql1.append(" t7.code as emp_code  ");
		sql1.append(" from  ");
		sql1.append("    (select distinct t1.id_incoep id_inc, t1.id_pat,tcgoe.id_ent,t1.id_enttp,t1.id_incca,t1.code_incpkg,t1.incno,t1.dt_inc,t1.amt,t1.id_emp_inc,t1.fg_canc,t1.sd_reason_canc,t1.des_reason_canc,t1.id_emp_canc,t1.dt_canc,t1.ds,t1.sv,t1.id_org,t1.id_grp,t1.code_enttp,t1.amt_pat,t1.note,t1.times_prn,t1.fg_print ");
		sql1.append("         from    bl_inc_oep      t1          ");
		sql1.append("          join  bl_st_oep       tsoe         ");
		sql1.append("           on  t1.id_stoep= tsoe.id_stoep    ");
		sql1.append("          join  bl_cg_itm_oep   tcgoe        ");
		sql1.append("           on  tsoe.id_stoep= tcgoe.id_stoep ");
		sql1.append("   union all  ");
		sql1.append("    select  id_incip  id_inc,id_pat,id_ent,id_enttp,id_incca,code_incpkg,incno,dt_inc,amt,id_emp_inc,fg_canc,sd_reason_canc,des_reason_canc,id_emp_canc,dt_canc,ds,sv,id_org,id_grp,code_enttp,amt_pat,note,times_prn,fg_print   ");
		sql1.append("         from bl_inc_ip           t2         ");
		sql1.append("      )t3,                                   ");
		sql1.append("  pi_pat    t4,                              ");
		sql1.append("  en_ent    t5,                              ");
		sql1.append("  bd_entp   t6,                              ");
		sql1.append("  bd_psndoc t7,                              ");
		sql1.append("  bd_psndoc t8                               ");
		sql1.append(" where  t4.id_pat =t3.id_pat        ");
		sql1.append("         and t3.id_ent=t5.id_ent    ");
		sql1.append("         and t3.id_enttp=t6.id_entp ");
		sql1.append("         and t3.id_emp_inc= t7.id_psndoc  ");
		sql1.append("         and t3.id_emp_canc=t8.id_psndoc(+) ");
		sql1.append("         and t3.fg_print='Y'                ");
		 StringBuffer bb =new StringBuffer();
		 bb.append("select * from ( ");
		 bb.append(sql1);
		 bb.append(" ) ta where ta.id_inc='"+id_bilincdto+"'  and ta.id_incca='"+id_incca+"'" );
		 System.out.println(bb);
		 List<BlincQueryDTO> list  = (List<BlincQueryDTO>)new DAFacade().execQuery(bb.toString(), new BeanListHandler(BlincQueryDTO.class));
		 return list.toArray(new BlincQueryDTO[0]);
	}
	
	
	
	/**
	 * 通过发票的主键找到患者的基本信息，用于门诊收费票据的表头显示的一部分
	 * @param id_incoepdto
	 * @return
	 * @throws BizException
	 */
	public BlIncoepqueryDTO[]  findByIdincoep(String id_incoepdto) throws BizException{
		 //可以由患者的id找到患者的主键id_pat，通过患者的主键从en_ent找到患者就诊的主键id_ent，通过id_ent关联en_ent_hp表得到id_hp值，通过id_hp从关联bd_hp表中得到id_hp值，通过其id值可以得到其name值和code值
   StringBuffer sb=new StringBuffer();

		// 将sql调整格式改为如下格式：
		sb.append("   select distinct t4.name_pat as pat_name,");
		sb.append("                   t3.name     as hp_name,");
		sb.append("                   t3.code     as hp_code,");
		sb.append("                   t5.name     as name_inc,");
		sb.append("                   t6.name     as sd_sex_pat,");
		sb.append("                   tt1.code_st              ");
		sb.append("    from bl_inc_oep    t1   ");
		sb.append("      left join     bl_st_oep     tt1    ");
		sb.append("        on t1.id_stoep= tt1.id_stoep     ");
		sb.append("      left join     bl_cg_itm_oep tt2   ");
		sb.append("        on  tt1.id_stoep= tt2.id_stoep  ");
		sb.append("      left join     en_ent         t4              ");
		sb.append("         on  tt2.id_ent = t4.id_ent      ");
		sb.append("      left join     en_ent_hp     t2             ");
		sb.append("         on  t2.id_ent = t4.id_ent              ");
		sb.append("      left join     bd_hp         t3                     ");
		sb.append("         on  t2.id_hp  = t3.id_hp        ");
		sb.append("      left join     bd_psndoc     t5             ");
		sb.append("         on  t1.id_emp_inc=t5.id_psndoc      ");
		sb.append("     left join     bd_udidoc     t6          ");
		sb.append("         on  t6.code = t4.sd_sex_pat           ");
		sb.append("      left join     bl_st_inc_oep t7            ");
		sb.append("        on  t1.id_incoep = t7.id_incoep         ");
		sb.append("   where                                        ");
		sb.append("       t6.id_udidoclist = '0001ZZ20000000000035' ");
		sb.append("       and t1.id_incoep = ?  ");

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(id_incoepdto);
		// 获得查询结果
		List<BlIncoepqueryDTO> list = (List<BlIncoepqueryDTO>) new DAFacade().execQuery(sb.toString(), sqlparam, new BeanListHandler(BlIncoepqueryDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		BlIncoepqueryDTO[] incoepdtos = list.toArray(new BlIncoepqueryDTO[0]);
		return incoepdtos;
	}

	/**
	 * 通过发票的号码找到患者的姓名。编码，医保类型等表头信息，用于第一个页面【门诊收费票据】的表头显示，包括流水号、发票号码、患者编码、姓名、性别、医保类型、社保号、收款人、日期等字段
	 * @param incno
	 * @return
	 * @throws BizException
	 */
	public BlIncoepqueryDTO[] findBlIncoepqueryDTOByIncno(String incno, String id_inc) throws BizException {
		StringBuffer sb = new StringBuffer();

		// 将sql调整格式改为如下格式：
		sb.append(" select w.pat_name ,w.hp_name ,w.hp_code ,w.id_hp,w.emp_pay_name,w.sd_sex_pat,w.code_st,w.id_ent,w.incno,w.pat_code, w.dt_inc,w.id_inc ");
		sb.append(" from ");
		sb.append("  (select  distinct  t1.id_incoep as id_inc,t1.id_grp,t1.id_org,t1.id_pat,ti.id_ent,t1.id_enttp,t1.code_enttp,t1.id_incca,t1.code_incpkg,t1.incno,t1.dt_inc,t1.dt_canc, ");
		sb.append("  t1.des_reason_canc,t1.amt,t1.amt_hp,t1.amt_pat,t1.amt_std,t1.note,t1.id_emp_inc,t1.id_emp_canc,t1.times_prn,t1.fg_canc,t1.id_stoep,t1.eu_direct,");
		sb.append(" t4.name_pat as pat_name,");
		sb.append(" t3.name as hp_name ,    ");
		sb.append(" t3.code as hp_code ,    ");
		sb.append(" t4.id_hp,               ");
		sb.append(" t5.name as emp_pay_name,");
		sb.append(" t6.name as sd_sex_pat,  ");
		sb.append(" t7.code_st, ");
		sb.append(" t9.code as pat_code ");
		sb.append("from bl_inc_oep t1   ");
		sb.append("left join bl_st_inc_oep t8       ");
		sb.append("  on t1.id_incoep = t8.id_incoep ");
		sb.append("left join bl_st_oep     t7       ");
		sb.append("  on t1.id_stoep = t7.id_stoep   ");
		sb.append(" left join bl_cg_itm_oep  ti     ");
		sb.append("  on  ti.id_stoep= t7.id_stoep   ");
		sb.append(" left join en_ent t4             ");
		sb.append("   on ti.id_ent = t4.id_ent      ");
		sb.append("left join bd_hp t3               ");
		sb.append("   on t4.id_hp = t3.id_hp        ");
		sb.append("join pi_pat t9                   ");
		sb.append("on t9.id_pat = t4.id_pat         ");
		sb.append("left join bd_psndoc t5           ");
		sb.append("  on t1.id_emp_inc = t5.id_psndoc ");
		sb.append("  left join bd_udidoc t6         ");
		sb.append("      on t6.id_udidoclist='0001ZZ20000000000035' and t4.sd_sex_pat=t6.code");
		sb.append("   )w ");
		sb.append("  where w.incno=?  and w.id_inc=?  ;");

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(incno);
		sqlparam.addParam(id_inc);
		// 获得查询结果
		List<BlIncoepqueryDTO> list = (List<BlIncoepqueryDTO>) new DAFacade().execQuery(sb.toString(), sqlparam, new BeanListHandler(BlIncoepqueryDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}

		BlIncoepqueryDTO[] incoepdtos = list.toArray(new BlIncoepqueryDTO[0]);
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();
		// for(int i=0;i<incoepdtos.length;i++){
		// incoepdtos[i].setDt_inc(dateTime.toStdString()); //获得服务器的当前时间
		// }
		return incoepdtos;
	}
	
	
	 /**
	  * 当需要得到【具体票据项目分类名称、数量、金额】这三个量时，给第一个常规发票及其打印时用，只能得到三个字段，现在在用下边的带三个参数的方法
	  * 
	  */
	public OepInccaItmDTO[]    findOepInccaItmDTOByIds(String id_incoep,String id_incca)throws BizException{
	StringBuffer sb=new StringBuffer();  //得到具体票据项目分类名称、数量、金额等，

		sb.append(" select Y.ID_INCCAITM,  A.name as bd_incca_itm_name,  ");
		sb.append(" X.id_srv, X.name_srv, X.id_cgitmoep, X.id_pat, X.id_cgoep, X.id_ent, X.id_enttp, X.id_pres, X.id_or, X.id_srvca,X.price, X.quan, X.amt, X.amt_std, X.id_pripat, X.amt_pat, X.id_hp, X.amt_hp, X.fg_acc, X.amt_acc ");
		sb.append(" FROM ");
		sb.append(" ( SELECT B.id_srv,B.name_srv,B.id_cgitmoep,B.id_pat,B.id_cgoep,B.id_ent,B.id_enttp,B.id_pres,B.id_or,B.id_srvca,B.price,B.quan,B.amt,B.amt_std,B.id_pripat,B.amt_pat,B.id_hp,B.amt_hp,B.fg_acc,B.amt_acc ");
		sb.append("  from  BL_INC_CG_ITM_OEP A");
		sb.append("  JOIN BL_CG_ITM_OEP B ON A.ID_CGITMOEP = B.ID_CGITMOEP ");
		sb.append("  WHERE A.ID_INCOEP = ? ) X "); // 得到某个门诊发票所对应的所有记账明细
		sb.append(" LEFT JOIN  ");
		sb.append("  ( SELECT ID_INCCAITM, NAME, ID_SRV ");
		sb.append("   FROM (SELECT distinct B.ID_INCCAITM, ");
		sb.append("     B.NAME        AS NAME, ");
		sb.append("     C.ID_SRV      as id_srv ");
		sb.append("    FROM BD_INCCA_ITM B ");
		sb.append("     JOIN BD_INCCA_ITM_REL C");
		sb.append("     ON B.ID_INCCAITM = C.ID_INCCAITM ");
		sb.append("  WHERE c.ID_INCCA = ? ");
		sb.append("  GROUP BY B.ID_INCCAITM, B.NAME, C.ID_SRV)) Y ");
		sb.append(" join  bd_incca_itm  A  on A.id_inccaitm=Y.ID_INCCAITM  "); // --得到所有排除-1方向后的服务分类下的票据项目分类
		sb.append("  ON X.ID_SRV = Y.ID_SRV ");

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(id_incoep);
		sqlparam.addParam(id_incca);
		List<OepInccaItmDTO> list = (List<OepInccaItmDTO>) new DAFacade().execQuery(sb.toString(), sqlparam, new BeanListHandler(OepInccaItmDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		OepInccaItmDTO[] oepdos = list.toArray(new OepInccaItmDTO[0]);
		return oepdos;
	}

	/**
	 * 当需要显示服务项目名称，及其服务项目分类名称，数量。金额等综合信息时用,给第一个常规发票的门诊收费票据的表体使用及其打印时用
	 * @param id_incoep
	 * @param id_incca
	 * @param id_incca2   //amt=amt_pat*患者价格比例
	 * @return
	 * @throws BizException
	 */
	public OepInccaItmDTO[]  findOepInccaItmDTOByIds(String id_incoep,String id_incca,String id_incca2)throws BizException{
		StringBuffer sb=new StringBuffer();  
		sb.append("select INCCAITM_NAME,sum(quan) as quan, SUM(AMT_STD) as blcgitmoep_amtstd, sum(amt) as amt,SUM(AMT_PAT) as amt_pat") ;
		sb.append(" FROM (SELECT Y.ID_INCCAITM, ") ;
		sb.append("  Y.name as inccaitm_name, ") ;
	    sb.append("X.id_srv,") ;
		sb.append(" X.name_srv,") ;
		sb.append("  X.id_cgitmoep, X.id_pat,");
		sb.append(" X.id_cgoep,") ;
		sb.append(" X.id_ent,") ;
		sb.append(" X.id_enttp,") ;
		sb.append("X.id_pres,") ;
		sb.append(" X.id_or,") ;
		sb.append(" X.id_srvca,") ;
		sb.append(" X.price,") ;
		sb.append(" X.quan,") ;
		sb.append(" X.amt,") ;
		sb.append(" X.amt_std,") ;
		sb.append(" X.id_pripat,") ;
		sb.append(" X.amt_pat,") ;
	    sb.append(" X.id_hp,") ;
		sb.append(" X.amt_hp,") ;
		sb.append(" X.fg_acc,") ;
		sb.append(" X.amt_acc ") ;
		sb.append(" FROM (SELECT B.id_srv,") ;
		sb.append(" B.name_srv,") ;
		sb.append(" B.id_cgitmoep,") ;
		sb.append(" B.id_pat,") ;
		sb.append(" B.id_cgoep,") ;
		sb.append(" B.id_ent,") ;
		sb.append(" B.id_enttp,") ;
		sb.append(" B.id_pres,") ;
	    sb.append(" B.id_or,") ;
		sb.append(" B.id_srvca,") ;
	    sb.append(" B.price,") ;
	    sb.append(" B.quan,") ;
		sb.append(" B.amt,") ;
	    sb.append(" B.amt_std,") ;
		sb.append(" B.id_pripat,") ;
		sb.append(" B.amt_pat,") ;
		sb.append(" B.id_hp,") ;
	    sb.append(" B.amt_hp,") ;
	    sb.append(" B.fg_acc,") ;
		sb.append(" B.amt_acc") ;
	    sb.append("  FROM BL_INC_CG_ITM_OEP A ") ;
		sb.append("  JOIN BL_CG_ITM_OEP B ") ;
		sb.append("  ON A.ID_CGITMOEP = B.ID_CGITMOEP ") ;
		sb.append("  WHERE A.ID_INCOEP = ?) X   LEFT JOIN    ") ;
		sb.append("  (SELECT ID_INCCAITM, NAME, ID_SRV ") ;
		sb.append("   FROM (SELECT distinct B.ID_INCCAITM, ") ;
		sb.append("     B.NAME        AS NAME, ") ;
		sb.append("     C.ID_SRV      as id_srv ") ;
		sb.append("    FROM BD_INCCA_ITM B ") ;
		sb.append("     JOIN BD_INCCA_ITM_REL C") ;
		sb.append("     ON B.ID_INCCAITM = C.ID_INCCAITM ") ;
		sb.append("  WHERE c.ID_INCCA = ? ") ;
		sb.append("  GROUP BY B.ID_INCCAITM, B.NAME, C.ID_SRV)) Y ") ; 
	    sb.append("    ON X.ID_SRV = Y.ID_SRV)") ;
	    sb.append("  GROUP BY INCCAITM_NAME") ;
		
	    
	    SqlParam sqlparam=new SqlParam();
	    sqlparam.addParam(id_incoep);
		sqlparam.addParam(id_incca);
		sqlparam.addParam(id_incca2);
		List<OepInccaItmDTO> list = (List<OepInccaItmDTO>) new DAFacade().execQuery(sb.toString(), sqlparam, new BeanListHandler(OepInccaItmDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		OepInccaItmDTO[]  oepdos=list.toArray(new OepInccaItmDTO[0]);

		return oepdos;
		}
	 
	/**
	 * 当需要给小票数据显示时用，为发票小条准备要绑定的数据源,此为考虑登录机构时用
	 * @param id_incoep
	 * @param id_incca
	 * @param id_incca2
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
      public DetailsReceiptDTO[] findDetailsReceiptDTOByIdsandIdorg(String id_incoep,String id_incca,String id_incca2,String id_org)throws BizException{
		StringBuffer sb=new StringBuffer();   
		sb.append(" SELECT w.ID_INCCAITM,w.BD_INCCA_ITM_NAME,w.name_srv,w.price,w.QUAN,SUM(AMT_STD),SUM(AMT_PAT),sum(amt) as amt, tpat.name as pat_name,w.id_pat,w.ID_INCOEP,t_patacc.id_patacc,t_patacc.prepay,t_patacc.acc_lock,(t_patacc.prepay-t_patacc.acc_lock)as acc_balance,t_org.name ") ;
	    sb.append(" FROM") ;
		sb.append(" (SELECT Y.ID_INCCAITM,  Y.name as bd_incca_itm_name,  ") ;
		sb.append("  X.id_srv, X.name_srv, X.id_cgitmoep, X.id_pat, X.id_cgoep, X.id_ent, X.id_enttp, X.id_pres, X.id_or, X.id_srvca,X.price, X.quan, X.amt, X.amt_std, X.id_pripat, X.amt_pat, X.id_hp, X.amt_hp, X.fg_acc, X.amt_acc,X.ID_INCOEP") ;
	    sb.append("  FROM ") ;
		sb.append("  ( SELECT TB.id_srv, ") ;
		sb.append("	      TB.name_srv,") ;
		 sb.append("      TB.id_cgitmoep,") ;
         sb.append("      TB.id_pat,") ;
         sb.append("      TB.id_cgoep,") ;
         sb.append("      TB.id_ent,") ;
         sb.append("      TB.id_enttp,") ;
         sb.append("      TB.id_pres,") ;
         sb.append("      TB.id_or,") ;
         sb.append("      TB.id_srvca,") ;
         sb.append("      TB.price,") ;
         sb.append("      TB.quan,") ;
         sb.append("      TB.amt*TC.EU_DIRECT     as amt,") ;
         sb.append("      TB.amt_std*TC.EU_DIRECT as amt_std,") ;
         sb.append("      TB.id_pripat,") ;
         sb.append("      TB.amt_pat*TC.EU_DIRECT as amt_pat,") ;
         sb.append("      TB.amt_ratio*TC.EU_DIRECT as amt_ratio,") ;
         sb.append("      TB.id_hp,") ;
         sb.append("      TB.amt_hp*TC.EU_DIRECT  as amt_hp,") ;
         sb.append("      TB.fg_acc,") ;
         sb.append("      TB.amt_acc*TC.EU_DIRECT as amt_acc,") ;
         sb.append("      TA.id_incoep,") ;
         sb.append("      TC.incno") ;
         sb.append("     FROM BL_INC_CG_ITM_OEP TA") ;
         sb.append("      inner JOIN BL_CG_ITM_OEP TB") ;
         sb.append("       ON TA.ID_CGITMOEP = TB.ID_CGITMOEP") ;
    	 sb.append("      left outer join bl_inc_oep TC") ;
         sb.append("       ON TA.ID_INCOEP = TC.ID_INCOEP") ;
    	 sb.append("    WHERE TA.ID_INCOEP = '1001Z7100000000GSVZM') X ") ; //--'票据ID' //得到某个门诊发票所对应的所有--记账明细
		sb.append("  LEFT JOIN") ;
		sb.append("  ( SELECT ID_INCCAITM, NAME, ID_SRV ") ;
		sb.append("   FROM (SELECT distinct B.ID_INCCAITM, ") ;
		sb.append("     B.NAME        AS NAME, ") ;
		sb.append("     C.ID_SRV      as id_srv ") ;
		sb.append("    FROM BD_INCCA_ITM B ") ;
		sb.append("     JOIN BD_INCCA_ITM_REL C") ;
		sb.append("     ON B.ID_INCCAITM = C.ID_INCCAITM ") ;
		sb.append("  WHERE c.ID_INCCA = ? ") ;
		sb.append("  GROUP BY B.ID_INCCAITM, B.NAME, C.ID_SRV)) Y ") ; 
		sb.append("  ON X.ID_SRV = Y.ID_SRV) w  ") ;
		sb.append("  join pi_pat tpat on w.id_pat=tpat.id_pat") ;
		sb.append("  join pi_pat_acc t_patacc on w.id_pat=t_patacc.id_pat") ;
		sb.append("  join bd_org t_org on t_org.id_org=? ") ;
        sb.append("  GROUP  BY w.ID_INCCAITM,w.BD_INCCA_ITM_NAME,w.name_srv,w.price,w.QUAN ,tpat.name,w.id_pat,w.ID_INCOEP,t_patacc.id_patacc,t_patacc.prepay,t_patacc.acc_lock,t_org.name ;") ;
	    SqlParam sqlparam=new SqlParam();
	    sqlparam.addParam(id_incoep);
		sqlparam.addParam(id_incca);
		sqlparam.addParam(id_incca2);
		sqlparam.addParam(id_org);
		List<DetailsReceiptDTO> list = (List<DetailsReceiptDTO>) new DAFacade().execQuery(sb.toString(), sqlparam, new BeanListHandler(DetailsReceiptDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		DetailsReceiptDTO[]  oepdos=list.toArray(new DetailsReceiptDTO[0]);
		TimeService timeService = new TimeServiceImpl();
        FDateTime dateTime =timeService.getUFDateTime();
        for(int i=0;i<oepdos.length;i++){
       	 oepdos[i].setPrint_time(dateTime);
       	oepdos[i].setPay_time(timeService.getUFDateTime());
         }
		 return oepdos; 
	}
      
	/**
	 * 当需要给小票数据显示时用，为发票小条准备要绑定的数据源，此情况为不考虑当前登录机构名称时用,用于显示小票表体时使用
	 * @param id_incoep
	 * @param id_incca
	 * @param id_incca2
	 * @return
	 * @throws BizException
	 */
	public DetailsReceiptDTO[] findDetailsReceiptDTOByIdS(String id_incoep,String id_incca,String id_incca2)throws BizException{
		StringBuffer sb=new StringBuffer();   
		sb.append(" SELECT w.ID_INCCAITM,w.INCCA_ITM_NAME,w.name_srv,w.price,w.QUAN,SUM(AMT_STD) as blcgitmoep_amtstd,SUM(AMT_PAT) as sum_amtpat,sum(amt) as amt,w.incno ,tpat.name as pat_name,tpat.code as pat_code,t_patacc.id_patacc,t_patacc.prepay,t_patacc.acc_lock,(t_patacc.prepay-t_patacc.acc_lock)as acc_balance") ;
		sb.append(" FROM ") ;
		sb.append("  (SELECT Y.ID_INCCAITM,Y.name as incca_itm_name,X.id_srv, X.name_srv, X.id_cgitmoep, X.id_pat, X.id_cgoep, X.id_ent, X.id_enttp, X.id_pres, X.id_or, X.id_srvca,X.price, X.quan, X.amt, X.amt_std, X.id_pripat, X.amt_pat, X.id_hp, X.amt_hp, X.fg_acc, X.amt_acc,X.id_incoep,X.Incno") ;
		sb.append("  FROM ") ;
		sb.append("   (SELECT TB.id_srv,");
		sb.append("    TB.name_srv,") ;
		 sb.append("   TB.id_cgitmoep,") ;
         sb.append("   TB.id_pat,") ;
         sb.append("   TB.id_cgoep,") ;
         sb.append("   TB.id_ent,") ;
         sb.append("   TB.id_enttp,") ;
         sb.append("   TB.id_pres,") ;
         sb.append("   TB.id_or,") ;
         sb.append("   TB.id_srvca,") ;
         sb.append("   TB.price,") ;
         sb.append("   TB.quan,") ;
         sb.append("   TB.amt*TC.EU_DIRECT     as amt,") ;
         sb.append("   TB.amt_std*TC.EU_DIRECT as amt_std,") ;
         sb.append("   TB.id_pripat,") ;
         sb.append("   TB.amt_pat*TC.EU_DIRECT as amt_pat,") ;
         sb.append("   TB.amt_ratio*TC.EU_DIRECT as amt_ratio,") ;
         sb.append("   TB.id_hp,") ;
         sb.append("   TB.amt_hp*TC.EU_DIRECT  as amt_hp,") ;
         sb.append("   TB.fg_acc,") ;
         sb.append("   TB.amt_acc*TC.EU_DIRECT as amt_acc,") ;
         sb.append("   TA.id_incoep,") ;
         sb.append("   TC.incno") ;
         sb.append("  FROM BL_INC_CG_ITM_OEP TA") ;
         sb.append("      inner JOIN BL_CG_ITM_OEP TB") ;
         sb.append("       ON TA.ID_CGITMOEP = TB.ID_CGITMOEP") ;
         sb.append("      left outer join bl_inc_oep TC") ;
         sb.append("      ON TA.ID_INCOEP = TC.ID_INCOEP") ;
         sb.append("    WHERE TA.ID_INCOEP = ? ) X") ;
	sb.append("  LEFT JOIN ") ;
	sb.append("  ( SELECT ID_INCCAITM, NAME, ID_SRV ") ;
	sb.append("   FROM (SELECT distinct B.ID_INCCAITM, ") ;
	sb.append("     B.NAME        AS NAME, ") ;
		sb.append("     C.ID_SRV      as id_srv ") ;
		sb.append("    FROM BD_INCCA_ITM B ") ;
		sb.append("     JOIN BD_INCCA_ITM_REL C") ;
		sb.append("     ON B.ID_INCCAITM = C.ID_INCCAITM ") ;
		sb.append("  WHERE c.ID_INCCA = ? ") ;
		sb.append("  GROUP BY B.ID_INCCAITM, B.NAME, C.ID_SRV)) Y ") ; 
		sb.append("  ON X.ID_SRV = Y.ID_SRV) w  ") ;
		sb.append("  join pi_pat tpat on w.id_pat=tpat.id_pat") ;
		sb.append("  join pi_pat_acc t_patacc on w.id_pat=t_patacc.id_pat") ;
		sb.append("	 GROUP  BY w.ID_INCCAITM,w.INCCA_ITM_NAME,w.name_srv,w.price,w.QUAN ,w.incno,tpat.name,tpat.code,t_patacc.id_patacc,t_patacc.prepay,t_patacc.acc_lock ") ;
		 StringBuffer bb =new StringBuffer();
		 bb.append(sb);
		
		 SqlParam sqlparam=new SqlParam();
	    sqlparam.addParam(id_incoep);
		sqlparam.addParam(id_incca);
		
		@SuppressWarnings("unchecked")
		List<DetailsReceiptDTO> list = (List<DetailsReceiptDTO>) new DAFacade().execQuery(sb.toString(), sqlparam, new BeanListHandler(DetailsReceiptDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		DetailsReceiptDTO[]  oepdos=list.toArray(new DetailsReceiptDTO[0]);
		TimeService timeService = new TimeServiceImpl();
        FDateTime dateTime =timeService.getUFDateTime();
          for(int i=0;i<oepdos.length;i++){
        	 oepdos[i].setPrint_time(dateTime);
        		oepdos[i].setPay_time(timeService.getUFDateTime());
        	       //	 oepdos[i].setPay_time(dateTime);
          }
         return oepdos; 
	}


	public PagingRtnData<BlincQueryDTO> findByPageInfo(PaginationInfo pg,
			String wherePart, String orderByPart) throws BizException {
		// TODO Auto-generated method stub
		
		StringBuffer whereSql=new StringBuffer();

		//FBoolean fgRegInc =  BlParams.BLSTOEP0021();
		
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" select distinct t3.id_inc,");
		sql1.append(" t4.code_amr_ip, ");
		sql1.append(" t3.id_pat,");
		sql1.append(" t3.id_enttp,");
		sql1.append(" t3.id_incca,");
		sql1.append(" t3.code_incpkg,");
		sql1.append(" t3.incno,");
		sql1.append(" t3.dt_inc,");
		// 减去医保差额
		sql1.append(" t3.amt - NVL( ");
		sql1.append(" (SELECT SUM(BL_PAY_ITM_PAT_OEP.AMT*BL_PAY_ITM_PAT_OEP.EU_DIRECT*BL_PAY_PAT_OEP.EU_DIRECT) ");
		sql1.append(" FROM BL_PAY_ITM_PAT_OEP ");
		sql1.append(" INNER JOIN BL_PAY_PAT_OEP on BL_PAY_ITM_PAT_OEP.ID_PAYPATOEP=BL_PAY_PAT_OEP.ID_PAYPATOEP");
		sql1.append(" WHERE ID_PM='@@@@Z71000000001ZJSK' AND ");
		sql1.append(" BL_PAY_PAT_OEP.ID_PAYPATOEP=(SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE ID_STOEP=t3.ID_ST)),0) amt,");
		sql1.append(" t3.id_emp_inc,");
		sql1.append(" t3.fg_canc,");
		sql1.append(" t3.fg_print,");
		sql1.append(" t3.sd_reason_canc,");
		sql1.append(" t3.des_reason_canc,");
		sql1.append(" t3.id_emp_canc,");
		sql1.append(" t3.dt_canc,");
		sql1.append(" t3.ds,");
		sql1.append(" t3.sv,");
		sql1.append(" t3.id_org,");
		sql1.append(" t3.id_grp,");
		sql1.append(" t3.code_enttp,");
		sql1.append(" t3.amt_pat,");
		sql1.append(" t3.note,");
		sql1.append(" t3.times_prn, t4.name as pat_name, t4.code  as pat_code,");
		sql1.append(" t4.sd_sex          sd_sex,  ");
		sql1.append("  t6.name as entpname, ");
		sql1.append(" t7.name as empinc_name,");
		sql1.append(" t7.code as empinc_code,");
		sql1.append(" t8.name as empcanc_name,");
		sql1.append(" t3.id_st  ");
		sql1.append(" from  ");
		sql1.append(" (select distinct t1.id_incoep id_inc,t1.id_pat,t1.id_enttp,t1.id_incca,t1.code_incpkg,t1.incno,t1.dt_inc,  t1.amt_ratio*t1.eu_direct as amt, t1.id_emp_inc,t1.fg_canc,t1.fg_print,t1.sd_reason_canc,t1.des_reason_canc,t1.id_emp_canc,t1.dt_canc,t1.ds,t1.sv,t1.id_org,t1.id_grp,t1.code_enttp,t1.amt_pat,t1.note,t1.times_prn,t1.ID_STOEP id_st  ");
		sql1.append("       from    bl_inc_oep t1                 ");
		sql1.append("          join  bl_st_oep       tsoe         ");
		sql1.append("           on  t1.id_stoep= tsoe.id_stoep    ");
		sql1.append("          join  bl_cg_itm_oep   tcgoe        ");
		sql1.append("           on  tsoe.id_stoep= tcgoe.id_stoep ");
		
//		//挂号发票不显示
//		if(FBoolean.FALSE.equals(fgRegInc)){
//			sql1.append("and tcgoe.eu_srctp = " + FeeOriginEnum.ORDERS_FEE);
//		}
		
		sql1.append(" union all  ");
		sql1.append(" select  id_incip  id_inc,id_pat,id_enttp,id_incca,code_incpkg,incno,dt_inc,  amt_ratio*eu_direct as amt, id_emp_inc,fg_canc,fg_print,sd_reason_canc,des_reason_canc,id_emp_canc,dt_canc,ds,sv,id_org,id_grp,code_enttp,amt_pat,note,times_prn,ID_STIP id_st  from bl_inc_ip t2) t3");
		sql1.append("  ,pi_pat t4,");
		sql1.append("  bd_entp t6,");
		sql1.append("  bd_psndoc t7,");
		sql1.append("   bd_psndoc t8 ");
		sql1.append("  where   ");
		//sql1.append("  exists (select  ent.id_ent, ent.code as ent_code  from  en_ent ent ) ");
		sql1.append("  t4.id_pat=t3.id_pat ");
		sql1.append("  and t3.code_enttp=t6.code ");
		sql1.append("  and t3.id_emp_inc= t7.id_psndoc  ");
		sql1.append("  and t3.id_emp_canc=t8.id_psndoc(+)  ");
		sql1.append("  and t3.fg_print='Y'                 ");
		StringBuffer bb = new StringBuffer();
		bb.append(sql1);
		bb.append(wherePart + " order by t3.dt_inc desc ");
		System.out.println(bb);

		BlincQueryDTO incdto = new BlincQueryDTO();
		PagingServiceImpl<BlincQueryDTO> pagingServiceImpl = new PagingServiceImpl<BlincQueryDTO>();
		PagingRtnData<BlincQueryDTO> prd=pagingServiceImpl.findByPageInfo( incdto,  pg,  bb.toString(), "", null);

		//给表添加序号和就诊卡号字段
		if(prd != null){
			PaginationInfo pagInfo = prd.getPagingInfo();//分页页数信息
			for (int i = 0; i < prd.getPageData().size(); i++) {
				BlincQueryDTO incInfoDTO = ((BlincQueryDTO)prd.getPageData().get(i));
				if(incInfoDTO != null){
					//给序号赋值
					incInfoDTO.setSortno(pagInfo.getPageIndex()*pagInfo.getPageSize()+1+i);

					//给就诊卡号赋值（如果一个患者多个就诊卡，则在所有启用的卡中取最新的那一个）
					IPiPatCardDORService piPatCardService = ServiceFinder.find(IPiPatCardDORService.class);
					PiPatCardDO[] piPatCardDOs = piPatCardService.find(" id_pat = '" + incInfoDTO.getId_pat() + "' and fg_act = 'Y' ", " sortno desc ", FBoolean.FALSE);
					if(!ArrayUtil.isEmpty(piPatCardDOs)){
						incInfoDTO.setEnt_card(piPatCardDOs[0].getCode());
					}
				}
			}
		}
		
		return prd;
	}

	/**
	 * 发票票据查询新
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlincQueryDTO> incQryNew(PaginationInfo pg,
			String incType, String whereCondition) throws BizException {
		
		//FBoolean fgRegInc =  BlParams.BLSTOEP0021();//门诊收费窗口：是否打印挂号发票
		StringBuffer sql=new StringBuffer();
		if(!StringUtil.isEmpty(incType) && "op".equals(incType)){
			//查询门诊发票
			sql.append(" select ");
			sql.append(" t3.id_incoep id_inc,t4.code_amr_ip,t3.id_pat,t3.id_enttp,t3.id_incca,t3.code_incpkg,t3.incno,t3.dt_inc, ");
			sql.append(" t3.amt*t3.eu_direct - NVL((SELECT SUM(BL_PAY_ITM_PAT_OEP.AMT * BL_PAY_ITM_PAT_OEP.EU_DIRECT * BL_PAY_PAT_OEP.EU_DIRECT) FROM BL_PAY_ITM_PAT_OEP INNER JOIN BL_PAY_PAT_OEP on BL_PAY_ITM_PAT_OEP.ID_PAYPATOEP = BL_PAY_PAT_OEP.ID_PAYPATOEP WHERE ID_PM = '@@@@Z71000000001ZJSK' AND BL_PAY_PAT_OEP.ID_PAYPATOEP = (SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE ID_STOEP = t3.ID_STOEP)),  0) amt, ");
			sql.append(" t3.id_emp_inc,t3.fg_canc,t3.fg_print,t3.sd_reason_canc,t3.des_reason_canc,t3.id_emp_canc,t3.dt_canc,t3.ds,t3.sv,t3.id_org,t3.id_grp,t3.code_enttp,t3.amt_pat,t3.note,t3.times_prn,t4.name as pat_name,t4.code as pat_code,t4.sd_sex sd_sex,t6.name as entpname,t7.name as empinc_name,t7.code as empinc_code,t8.name as empcanc_name,t3.ID_STOEP id_st");
			sql.append(" from bl_inc_oep t3 ");
			//sql.append(" inner join bl_st_oep st on t3.id_stoep = st.id_stoep ");
			//sql.append(" inner join bl_cg_itm_oep tcgoe on st.id_stoep = tcgoe.id_stoep ");
			//挂号发票不显示
			//if(FBoolean.FALSE.equals(fgRegInc)){
				//sql.append(" and tcgoe.eu_srctp = " + FeeOriginEnum.ORDERS_FEE);
			//}
			sql.append(" left join pi_pat t4 on t4.id_pat = t3.id_pat ");
			sql.append(" left join bd_entp t6 on t6.code = t3.code_enttp ");
			sql.append(" left join bd_psndoc t7 on t7.id_psndoc = t3.id_emp_inc ");
			sql.append(" left join bd_psndoc t8 on t8.id_psndoc = t3.id_emp_canc");
			sql.append(" where 1=1 ");
			sql.append(" and t3.fg_print = 'Y' ");
			sql.append(whereCondition + " order by t3.dt_inc desc ");
			
		}else if(!StringUtil.isEmpty(incType) && "ip".equals(incType)){
			//查询住院发票
			sql.append(" select ");
			sql.append(" t3.id_incip id_inc,t4.code_amr_ip,t3.id_pat,t3.id_enttp,t3.id_incca,t3.code_incpkg,t3.incno,t3.dt_inc, ");
			sql.append(" t3.amt - NVL((SELECT SUM(BL_PAY_ITM_PAT_OEP.AMT * BL_PAY_ITM_PAT_OEP.EU_DIRECT * BL_PAY_PAT_OEP.EU_DIRECT) FROM BL_PAY_ITM_PAT_OEP INNER JOIN BL_PAY_PAT_OEP on BL_PAY_ITM_PAT_OEP.ID_PAYPATOEP = BL_PAY_PAT_OEP.ID_PAYPATOEP WHERE ID_PM = '@@@@Z71000000001ZJSK' AND BL_PAY_PAT_OEP.ID_PAYPATOEP = (SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE ID_STOEP = t3.id_stip)), 0) amt, ");
			sql.append(" t3.id_emp_inc,t3.fg_canc,t3.fg_print,t3.sd_reason_canc,t3.des_reason_canc,t3.id_emp_canc,t3.dt_canc,t3.ds,t3.sv,t3.id_org,t3.id_grp,t3.code_enttp,t3.amt_pat,t3.note,t3.times_prn,t4.name as pat_name,t4.code as pat_code,t4.sd_sex sd_sex,t6.name as entpname,t7.name as empinc_name,t7.code as empinc_code,t8.name as empcanc_name,t3.id_stip id_st ");
			sql.append(" from bl_inc_ip t3 ");
			sql.append(" left join pi_pat t4 on t4.id_pat = t3.id_pat ");
			sql.append(" left join bd_entp t6 on t6.code = t3.code_enttp ");
			sql.append(" left join bd_psndoc t7 on t7.id_psndoc = t3.id_emp_inc ");
			sql.append(" left join bd_psndoc t8 on t8.id_psndoc = t3.id_emp_canc ");
			sql.append(" where 1=1 ");
			sql.append(" and t3.fg_print = 'Y' ");
			sql.append(whereCondition + " order by t3.dt_inc desc ");
		}
		BlincQueryDTO incdto = new BlincQueryDTO();
		PagingServiceImpl<BlincQueryDTO> pagingServiceImpl = new PagingServiceImpl<BlincQueryDTO>();
		PagingRtnData<BlincQueryDTO> prd=pagingServiceImpl.findByPageInfo( incdto,  pg,  sql.toString(), "", null);
		
		//给表添加序号和就诊卡号字段
		if(prd != null){
			List<String> idPats = new ArrayList<String>();
			for (int i = 0; i < prd.getPageData().size(); i++) {
				BlincQueryDTO incInfoDTO = ((BlincQueryDTO)prd.getPageData().get(i));
				if(incInfoDTO != null){
					String id_pat = incInfoDTO.getId_pat();
					if(!StringUtil.isEmpty(id_pat)){
						if(!idPats.contains(id_pat)){
							idPats.add(id_pat);
						}
					}
				}
			}
			
			PiPatCardDO[] piPatCardDOs = null;
			if(!ListUtil.isEmpty(idPats)){
				IPiPatCardDORService piPatCardService = ServiceFinder.find(IPiPatCardDORService.class);
				piPatCardDOs = piPatCardService.find(" fg_act = 'Y' and " +SqlUtils.getInSqlByIds("id_pat", idPats), " sortno desc ", FBoolean.FALSE);
			}
			
			
			Map<String, PiPatCardDO> cardMap=new HashMap<String, PiPatCardDO>();
			
			if(!ArrayUtil.isEmpty(piPatCardDOs))
			{
				for (PiPatCardDO piPatCardDO : piPatCardDOs) {
					if(!cardMap.containsKey(piPatCardDO.getId_pat()))
					{
						cardMap.put(piPatCardDO.getId_pat(), piPatCardDO);
					}
				}
			}

			PaginationInfo pagInfo = prd.getPagingInfo();//分页页数信息
			for (int i = 0; i < prd.getPageData().size(); i++) {
				BlincQueryDTO incInfoDTO = ((BlincQueryDTO)prd.getPageData().get(i));
				if(incInfoDTO != null){
					//给序号赋值
					incInfoDTO.setSortno(pagInfo.getPageIndex()*pagInfo.getPageSize()+1+i);

					PiPatCardDO patCardDo = cardMap.get(incInfoDTO.getId_pat());
					if(patCardDo != null){
						incInfoDTO.setEnt_card(patCardDo.getCode());
					}
				}
			}
		}
		
		return prd;
	}
	
	public BlIncItmVsTypeDTO[] getIncOepInfoDto(String strIdInc, BlincQueryDTO blincqueryDTO) throws BizException {
		IBlcgqueryService cgSer = (IBlcgqueryService) ServiceFinder.find(IBlcgqueryService.class);
		BlIncItmVsTypeDTO[] blincItmvsDTOs = cgSer.getIncOepInfoDtoByIncId(strIdInc);
		if (blincItmvsDTOs == null || blincItmvsDTOs.length == 0)
			return null;
		BlInvoiceHeadTailDTO headTailDTOs = blincItmvsDTOs[0].getBlInvoiceHeadTailDTO();
		headTailDTOs.setPatcode(blincqueryDTO.getPat_code());
		headTailDTOs.setPatname(blincqueryDTO.getPat_name());
		IPatiMDORService piser = (IPatiMDORService) ServiceFinder.find(IPatiMDORService.class);
		PatDO patdo = piser.findById(blincqueryDTO.getId_pat());
		switch (patdo.getSd_sex()) {
		case "0":
			blincqueryDTO.setSex("未知");
			break;
		case "1":
			blincqueryDTO.setSex("男性");
			break;
		case "2":
			blincqueryDTO.setSex("女性");
			break;
		}
		headTailDTOs.setSex(blincqueryDTO.getSex());
		return blincItmvsDTOs;
		
	}
	
	
	public String getQueryConditions(String[] conds) {
		// TODO Auto-generated method stub
		StringBuffer whereSql = new StringBuffer();
		if (conds[0] != null && conds[1] != null) {
			whereSql.append(" and t3.dt_inc between '").append(conds[0]).append("' and '").append(conds[1]).append("'");
		}
		if(conds[2] != null){
			whereSql.append(" and t3.id_pat =(select id_pat from pi_pat tt where tt.code='").append(conds[2]).append("')");
		}
		
		if(conds[3] == null){
			whereSql.append("  ");	
		}else{
			whereSql.append(" and t3.id_pat in (select id_pat from pi_pat tt where tt.name like '%").append(conds[3]).append("%')");
		}
		
		if(conds[4]!=null){
			whereSql.append(" and  t3.id_ent in (select id_ent from en_ent tt where tt.code='").append(conds[4]).append("')");
			}
		
		 if(conds[5]==null){
			 whereSql.append("  ");
		 }else{
			 whereSql.append(" and t3.id_enttp = (select id_entp from bd_entp ta where ta.id_entp='").append(conds[5]).append("')"); 
		 }
		
		 if(conds[6]!=null){
			 whereSql.append(" and t3.incno='").append(conds[6]).append("'"); 
		 }
		 
		return whereSql.toString();
	}

    /**
     * 如果票据类型是门诊发票类型，通过发票的主键得到发票的记账明细信息，用于显示发票的表体的服务项目信息，当需要显示发票的服务项目明细时直接用这个结果集显示即可，当显示为项目分类时需要再按照票据分类做groupby
     * @param id_incca
     * @param id_inc
     * @return
     */
	public BlCgItmOepDO[] getOepInvoiceInfo(String id_incca, String id_inc) throws BizException{
		// TODO Auto-generated method stub
		 StringBuffer sql1=new StringBuffer();

		 sql1.append(" select distinct B.ID_CGITMOEP,");
	     sql1.append(" b.Id_Cgoep,");
		 sql1.append(" B.AMT*E.Eu_Direct     as Amt,");
		 sql1.append(" B.AMT_ACC*E.Eu_Direct as amt_acc,");
	     sql1.append(" B.AMT_HP*E.Eu_Direct  as amt_hp,");
		 sql1.append(" B.AMT_PAT*E.Eu_Direct as amt_pat,");
		 sql1.append(" B.AMT_RATIO*E.Eu_Direct as amt_ratio,");
         sql1.append(" B.AMT_STD*E.Eu_Direct  as amt_std,");
         sql1.append(" B.code_enttp,");
         sql1.append(" B.Code_Mm,");
         sql1.append(" B.Code_Srv,");
         sql1.append(" B.Ds,");
         sql1.append(" B.Dt_Or,");
         sql1.append(" B.Dt_Srv,");
         sql1.append(" B.Dt_St,");
         sql1.append(" B.Eu_Srctp,");
         sql1.append(" B.Fg_Acc,");
         sql1.append(" B.Fg_Additm,");
         sql1.append(" B.Fg_Hp,");
         sql1.append(" B.Fg_Mm,");
         sql1.append(" B.Fg_Refund,");
         sql1.append(" B.Fg_St,");
         sql1.append(" B.Fg_Susp,");
         sql1.append(" b.Id_Dep_Mp,");
         sql1.append(" b.Id_Dep_Or,");
         sql1.append(" B.ID_EMP_OR,");
         sql1.append(" B.ID_ENT,");
         sql1.append(" B.ID_ENTTP,");
         sql1.append(" B.ID_GRP,");
         sql1.append(" B.ID_HP,");
         sql1.append(" B.ID_HPSRVTP,");
         sql1.append(" B.ID_MM,");
         sql1.append(" B.ID_MMTP,");
         sql1.append(" B.ID_OR,");
         sql1.append(" B.ID_ORG,");
         sql1.append(" B.ID_ORSRV,");
         sql1.append(" B.ID_PAT,");
         sql1.append(" B.ID_PRES,");
         sql1.append(" B.ID_PRIPAT,");
         sql1.append(" B.ID_SRV,");
         sql1.append(" B.ID_STOEP,");
         sql1.append(" B.NAME_MM,");
         sql1.append(" B.NAME_SRV,");
         sql1.append(" B.NOTE,");
         sql1.append(" B.PRICE,");
         sql1.append(" B.PRI_SS,");
         sql1.append(" B.QUAN,");
         sql1.append(" B.QUAN_BASE,");
         sql1.append(" B.RATIO_HP,");
         sql1.append(" B.RATIO_PRIPAT,");
         sql1.append(" B.SRVU,");
         sql1.append(" B.SPEC,");
         sql1.append(" B.Sv,");
         sql1.append(" C.id_inccaitm,");
         sql1.append(" D.id_inccaitm,");
         sql1.append(" D.code         as Inccaitm_code,");
         sql1.append(" D.name         as Inccaitm_name");
		 sql1.append("  ");
		 sql1.append(" from  ");
		 sql1.append(" BL_INC_CG_ITM_OEP  A "); 
		 sql1.append(" join bl_cg_itm_oep B   ");
		 sql1.append("   on   A.id_cgitmoep=B.id_cgitmoep "); 
		 sql1.append(" inner  join bl_inc_oep E");
		 sql1.append("  on  A.id_incoep=E.id_incoep");
		 sql1.append(" JOIN BD_INCCA_ITM_REL C  ");
		 sql1.append("   ON B.ID_SRV = C.ID_SRV ");
		 sql1.append("  AND C.ID_INCCA = '").append(id_incca).append("'");
		 sql1.append(" join Bd_incca_itm  D  ");
		 sql1.append("   on C.Id_inccaitm=D.id_inccaitm ");
		 sql1.append("  where A.id_incoep='").append(id_inc).append("'");
		 sql1.append("   ");
		 sql1.append("  ");
			
		     List<BlCgItmOepDO> list  = (List<BlCgItmOepDO>)new DAFacade().execQuery(sql1.toString(), new BeanListHandler(BlCgItmOepDO.class));
			 return list.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 对门诊发票类型，用于显示发票的表体的票据项目分类及其金额，即对查询出来的记账明细根据票据分类项目做分组处理，用于显示项目分类时发票表体显示
	 * @param id_incca
	 * @param id_inc
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO[] getOepInvoiceInfoGroupbyInccaitm(String id_incca, String id_inc) throws BizException{
		 StringBuffer sql1=new StringBuffer();
		 
		    sql1.append("select  sum(x.amt) amt ,sum(x.amt_acc) amt_acc,sum(x.amt_hp) amt_hp,sum(x.amt_pat) amt_pat,sum(x.amt_ratio) amt_ratio,sum(x.amt_std) amt_std,x.id_inccaitm,x.inccaitm_name  ");
		    sql1.append(" from ");
		    sql1.append("  (select distinct  B.ID_CGITMOEP,b.Id_Cgoep, ");
		    sql1.append("   B.AMT*E.Eu_Direct     as Amt,              ");
		    sql1.append("   B.AMT_ACC*E.Eu_Direct as amt_acc,          ");
		    sql1.append("   B.AMT_HP*E.Eu_Direct  as amt_hp,           ");
		    sql1.append("   B.AMT_PAT*E.Eu_Direct as amt_pat,          ");
		    sql1.append("   B.AMT_RATIO*E.Eu_Direct as amt_ratio,      ");
		    sql1.append("   B.AMT_STD*E.Eu_Direct  as amt_std,          ");
		    sql1.append("   B.code_enttp,");
		    sql1.append("   B.Code_Mm,");
		    sql1.append("   B.Code_Srv,");
		    sql1.append("   B.Ds,");
		    sql1.append("   B.Dt_Or,");
		    sql1.append("   B.Dt_Srv,");
		    sql1.append("   B.Dt_St,");
		    sql1.append("   B.Eu_Srctp,");
		    sql1.append("   B.Fg_Acc,");
		    sql1.append("   B.Fg_Additm,");
		    sql1.append("   B.Fg_Hp,");
		    sql1.append("   B.Fg_Mm,");
		    sql1.append("   B.Fg_Refund,");
		    sql1.append("   B.Fg_St,");
		    sql1.append("   B.Fg_Susp,");
		    sql1.append("   b.Id_Dep_Mp,");
		    sql1.append("   b.Id_Dep_Or,");
		    sql1.append("   B.ID_EMP_OR,");
		    sql1.append("   B.ID_ENT,");
		    sql1.append("   B.ID_ENTTP,");
		    sql1.append("   B.ID_GRP,");
		    sql1.append("   B.ID_HP,");
		    sql1.append("   B.ID_HPSRVTP,");
		    sql1.append("   B.ID_MM,");
		    sql1.append("   B.ID_MMTP,");
		    sql1.append("   B.ID_OR,");
		    sql1.append("   B.ID_ORG,");
		    sql1.append("   B.ID_ORSRV,");
		    sql1.append("   B.ID_PAT,");
		    sql1.append("   B.ID_PRES,");
		    sql1.append("   B.ID_PRIPAT,");
		    sql1.append("   B.ID_SRV,");
			sql1.append("   B.ID_STOEP,  ");
		    sql1.append("   B.NAME_MM,  ");
		    sql1.append("   B.NAME_SRV,   ");
		    sql1.append("   B.NOTE,B.PRICE,B.PRI_SS,B.QUAN,B.QUAN_BASE,B.RATIO_HP,B.RATIO_PRIPAT,B.SRVU,B.SPEC,B.Sv, ");
		    sql1.append("   D.id_inccaitm,D.code as Inccaitm_code,D.name as Inccaitm_name ");
			sql1.append("    from  ");
			sql1.append("     BL_INC_CG_ITM_OEP  A "); 
			sql1.append("     join bl_cg_itm_oep B   ");
			sql1.append("      on   A.id_cgitmoep=B.id_cgitmoep "); 
			sql1.append("     inner  join bl_inc_oep E     ");
			sql1.append("      on  A.id_incoep=E.id_incoep "); 
			sql1.append("     join BD_INCCA_ITM_REL C      ");
			sql1.append("      ON B.ID_SRV = C.ID_SRV      ");
			sql1.append("     and C.ID_INCCA = '").append(id_incca).append("'");
			sql1.append("     join Bd_incca_itm  D  ");
			sql1.append("      on C.Id_inccaitm=D.id_inccaitm ");
			sql1.append("    where A.id_incoep='").append(id_inc).append("'");
			sql1.append("  ) X   group by x.id_inccaitm,x.inccaitm_name   ");
			sql1.append("  ");
			
		     List<BlCgItmOepDO> list  = (List<BlCgItmOepDO>)new DAFacade().execQuery(sql1.toString(), new BeanListHandler(BlCgItmOepDO.class));
			 return list.toArray(new BlCgItmOepDO[0]);
	}
	
	
  /**
   * 如果票据类型是住院发票类型，通过发票的主键得到发票的记账明细信息，用于显示发票的表体的服务项目信息
   * @param id_incca
   * @param id_inc
   * @return
   */
	public BlIncItmIpDO[] getIpInvoiceInfo(String id_incca, String id_inc) throws BizException{
		// TODO Auto-generated method stub
		StringBuffer sql1=new StringBuffer();
	    sql1.append(" select A.id_incitmip,A.id_incip,A.id_incitmtp,A.sd_incitmtp,A.code,A.name,A.amt,A.AMT_HP,A.AMT_PAT,A.AMT_RATIO,A.AMT_STD,A.ds,A.sv  ");
	    sql1.append("  from  ");
		sql1.append("        ");
		sql1.append("        ");
		sql1.append(" BL_INC_ITM_IP  A "); 
		sql1.append("  where A.id_incip='").append(id_inc).append("'");
		sql1.append("  order by sv desc  ");
		sql1.append("  ");
		
         
		 List<BlIncItmIpDO> list  = (List<BlIncItmIpDO>)new DAFacade().execQuery(sql1.toString(), new BeanListHandler(BlIncItmIpDO.class));
		 return list.toArray(new BlIncItmIpDO[0]);
	}


public BlCgItmOepDO[] getOepIncReceiptInfo(String id_incca, String id_inc)  throws BizException{
	// TODO Auto-generated method stub
	 StringBuffer sql1=new StringBuffer();
	    sql1.append("select distinct A.ID_CGITMOEP,A.Id_Cgoep,  A.AMT* E.Eu_Direct as amt, A.AMT_ACC* E.Eu_Direct as amt_acc,A.AMT_HP* E.Eu_Direct as amt_hp,A.AMT_PAT* E.Eu_Direct as amt_pat,A.AMT_RATIO* E.Eu_Direct as amt_ratio,A.AMT_STD* E.Eu_Direct as amt_std,A.code_enttp,A.Code_Mm,A.Code_Srv,A.Ds,A.Dt_Or, ");
		sql1.append("  A.Dt_Srv,A.Dt_St,A.Eu_Srctp,A.Fg_Acc,A.Fg_Additm,A.Fg_Hp,A.Fg_Mm,A.Fg_Refund,A.Fg_St,A.Fg_Susp,A.Id_Dep_Mp,A.Id_Dep_Or,A.ID_EMP_OR, ");
		sql1.append("  A.ID_ENT,A.ID_ENTTP,A.ID_GRP,A.ID_HP,A.ID_HPSRVTP,A.ID_MM,A.ID_MMTP,A.ID_OR,A.ID_ORG,A.ID_ORSRV,A.ID_PAT,A.ID_PRES,A.ID_PRIPAT,A.ID_SRV, ");
		sql1.append("  A.ID_STOEP,A.NAME_MM,A.NAME_SRV,A.NOTE,A.PRICE,A.PRI_SS,A.QUAN*E.eu_direct as quan,A.QUAN_BASE*E.eu_direct as quan_base,A.RATIO_HP,A.RATIO_PRIPAT,A.SRVU,A.SPEC,A.Sv,  ");
	    sql1.append(" C.id_inccaitm ,  ");
	    sql1.append(" D.id_inccaitm,D.code as Inccaitm_code,D.name as Inccaitm_name ");
		sql1.append("  ");
		sql1.append("  ");
		sql1.append("  ");
	  	sql1.append("  ");
		sql1.append("  ");
	    sql1.append("  ");
		sql1.append("  ");
		sql1.append(" from  ");
		sql1.append("      bl_cg_itm_oep      A "); 
		sql1.append(" join  BL_INC_CG_ITM_OEP B   ");
		sql1.append("   on  A.id_cgitmoep=B.id_cgitmoep "); 
		sql1.append(" JOIN BD_INCCA_ITM_REL   C  ");
		sql1.append("   ON A.ID_SRV = C.ID_SRV ");
		sql1.append(" join  BL_INC_OEP E  ");
		sql1.append("   on  B.id_incoep=E.id_incoep "); 
		sql1.append(" join Bd_incca_itm       D  ");
		sql1.append("   on C.Id_inccaitm=D.id_inccaitm ");
		sql1.append("  AND D.ID_INCCA = '").append(id_incca).append("'");
		sql1.append("  where B.id_incoep='").append(id_inc).append("'");
		sql1.append("   ");
		sql1.append("  ");
		
	     List<BlCgItmOepDO> list  = (List<BlCgItmOepDO>)new DAFacade().execQuery(sql1.toString(), new BeanListHandler(BlCgItmOepDO.class));
		 return list.toArray(new BlCgItmOepDO[0]);
}


public BlincitmIpDTO[] getIncItmIpDTOsByIncno(String id_incca, String id_incip)throws BizException {
	// TODO Auto-generated method stub
	 StringBuffer sql1=new StringBuffer();
	 sql1.append(" select distinct  A.id_cgip,A.id_grp,A.id_org,A.id_pat,A.id_enttp,A.code_enttp,A.DS,A.DT_CG,A.DT_OR,A.DT_SRV,A.DT_ST,A.id_ent,A.eu_direct,A.FG_ADDITM,A.FG_BB,A.FG_HP,A.FG_MM,A.FG_PDDISC,A.FG_REFUND,A.FG_ST, ");
	 sql1.append("  A.FG_SUSP,A.id_srvtp,A.sd_srvtp,A.id_srvca,A.id_srv,A.name_srv,A.srvu,A.quan,A.AMT,a.amt_hp,A.AMT_PAT,A.AMT_RATIO,A.AMT_STD,A.Id_org_or,A.id_dep_or,A.ID_CGIP, ");
	 sql1.append("  A.ID_DEP_CG,A.ID_DEP_MP,A.ID_DEP_NUR,A.ID_DEP_OR,A.ID_EMP_CG,A.ID_EMP_OR,A.ID_HP,A.ID_MM,A.ID_OR,A.ID_ORG_CG,A.ID_ORG_MP,A.ID_ORG_OR,A.ID_ORSRV,A.ID_PAT,A.ID_STIP, ");
	 sql1.append("  A.ID_SRVCA,A.ID_SRVTP,A.NAME_MM,A.NAME_SRV,A.NO_BB,A.NOTE,A.SPEC,A.SRVU,A.SV,  ");  
	  sql1.append(" A.id_ent, ");
	    sql1.append("   B.Id_Stip,B.Code_St,B.Dt_Start,B.Dt_End, ");
		sql1.append("   C.id_incip  as id_inc,C.id_incca,C.incno,I.name as name_empinc,C.dt_inc, ");
		sql1.append("   D.code as code_ent,D.Name_Pat, J.code as pat_code, ");
		sql1.append("   case when D.Sd_Sex_Pat=1 then '男性' else '女性' end as sd_sex_pat, ");
	  	sql1.append("   A.id_ent,a .name_inccaitm as name_inccaitm    ");
	  	sql1.append("  from bl_cg_ip     A ");
		sql1.append("   join  bl_st_ip   B       on  B.id_stip=A.id_stip  ");
	    sql1.append("   join  bl_inc_ip  C       on  A.id_stip=C.Id_stip ");
//		sql1.append("   join  bl_inc_itm_ip G    on  C.Id_Incip=G.id_incip ");//关联它了就上万条了
		sql1.append("   join  EN_ENT     D       on  A.id_ent=D.id_ent ");
//		sql1.append("   left join   EN_ENT_HP  E       on  D.id_ent=E.id_ent "); 
//		sql1.append("   left join   en_ent_hp  H       on  A.id_hp=H.id_hp   ");
		sql1.append("   join        bd_psndoc  I       on  C.id_emp_inc=I.id_psndoc  "); 
		sql1.append("   join        pi_pat     J       on  D.id_pat=J.id_pat                                                          ");
		sql1.append("    ");
		sql1.append("  where C.ID_INCCA = '").append(id_incca).append("'");
		sql1.append("  and C.id_incip='").append(id_incip).append("'  and A.fg_st='Y'  ");
		sql1.append("   ");

		List<BlincitmIpDTO> list = (List<BlincitmIpDTO>) new DAFacade().execQuery(sql1.toString(), new BeanListHandler(BlincitmIpDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		
		return list.toArray(new BlincitmIpDTO[0]);
	}

public  String  getAuthorityByUserid(String userid ,String nodecode) throws BizException{
	
	IDataperExtQry ideq=ServiceFinder.find(IDataperExtQry.class);//调用接口IDataperExtQry
	//String userId=RuntimeContext.getSessionBean().getId_user();//获取用户id
	String userId=Context.get().getUserId();
	List<DataPerRuleDO> listruledo=ideq.getSysDataperRuleByUser(userId, nodecode);//获取数据权限
	
	String where="";
	if(listruledo!=null&&listruledo.size()>0){
		DataPerRuleDO ruledo=listruledo.get(0);
		where = ideq.getwhere(ruledo);//根据数据权限生成where条件
   }
	
	return where;
  }


public DetailsReceiptDTO[] findAllPaymodenamesByIdincoep(String id_incoep) throws BizException{
	// TODO Auto-generated method stub
	 StringBuffer sql1=new StringBuffer();
	 sql1.append(" select  X.id_pm,X.pm_name  from                                                                  ");
	 sql1.append("   (select A.id_incoep,  A.incno,A.id_stoep,C.id_paypatoep,D.id_payitmpatoep,D.id_pm ,E.name as pm_name   ");
	 sql1.append("     from  bl_inc_oep               A                                                          ");
	 sql1.append("      join  bl_st_oep                B  on A.id_stoep=B.id_stoep                                ");  
	 sql1.append("      join  bl_pay_pat_oep           C  on C.id_paypatoep=B.id_paypatoep                        ");
	 sql1.append("      inner join  bl_pay_itm_pat_oep D  on  C.id_paypatoep=D.id_paypatoep                       ");
	 sql1.append("      inner join  bd_pri_pm          E  on  D.id_pm=E.id_pm                                     ");
	 sql1.append("     where  A.id_incoep= '").append(id_incoep).append("')X    group by x.id_pm,X.pm_name            ");
	
	 List<DetailsReceiptDTO> list  = (List<DetailsReceiptDTO>)new DAFacade().execQuery(sql1.toString(), new BeanListHandler(DetailsReceiptDTO.class));
	 return list.toArray(new DetailsReceiptDTO[0]);
}


public BlIncItmVsTypeDTO[] getSeveralAmtValuesByIdstoep(String id_incoep) throws BizException{
	// TODO Auto-generated method stub
	 StringBuffer sql1=new StringBuffer();
	 sql1.append("  select a.amt_ratio*d.eu_direct   as  amt_ratio,                                  "); 
	 sql1.append("         c.amt_hp*d.eu_direct      as  amt_hp,                                     ");
	 sql1.append("         c.amt_psnacc*d.eu_direct  as  amt_psnacc,                                 ");
	 sql1.append("         a.amt_ratio*d.eu_direct - nvl(c.amt_hp*d.eu_direct, 0) - nvl(c.amt_psnacc*d.eu_direct, 0)   amt_pat,           ");  //个人支付金额=amt_ratio-amt_hp-amt_psnacc          
	 sql1.append("         nvl(c.amt_hp*d.eu_direct, 0) amt_tc,                                                ");  //医保基金支付金额
	 sql1.append("         nvl(c.amt_psnacc*d.eu_direct, 0) amt_grzf                                       ");  //个人账户金额
	 sql1.append("   from  bl_inc_oep     d                                                        ");
	 sql1.append("   inner join bl_st_oep a                                                        ");
	 sql1.append("     on   a.id_stoep=d.id_stoep                                                  ");
	 sql1.append("    left join bl_prop_oep b                                                      ");
	 sql1.append("     on a.id_stoep = b.id_stoep                                                  ");
	 sql1.append("    left join bl_prop_ar_oep c                                                   ");
	 sql1.append("      on b.id_propoep = c.id_propoep                                             ");
	 sql1.append("    where d.fg_canc='N' and  a.fg_canc='N'  and  d.id_incoep=?                   ");
	 sql1.append("                                                                                 ");
	 
	SqlParam sp=new SqlParam();
	sp.addParam(id_incoep);
	 List<BlIncItmVsTypeDTO> list  = (List<BlIncItmVsTypeDTO>)new DAFacade().execQuery(sql1.toString(),sp, new BeanListHandler(BlIncItmVsTypeDTO.class));
	 return list.toArray(new BlIncItmVsTypeDTO[0]);
   }


/**
 * 通过患者的主键id_pat 和 门诊发票的主键id_incoep,id_incca 得到门诊患者的医保计划目录类型名称，即是甲乙丙哪个类别
 * @param id_incoep
 * @param id_pat
 * @param id_incca
 * @return
 */
public BlInvoiceDetailsDTO findHpnameByIdincoep(String id_incoep, String id_pat,
		String id_incca) throws BizException{
	// TODO Auto-generated method stub
	 StringBuffer sql1=new StringBuffer();
	 sql1.append("    select distinct t.incno ,d.name as hpsrvtp,t.id_stoep  from bl_inc_oep t       "); 
	 sql1.append("      join bl_st_oep     a on t.id_stoep= a.id_stoep                               ");
	 sql1.append("      join bl_cg_itm_oep b on a.id_stoep= b.id_stoep                              ");
	 sql1.append("      join bd_hp_srvorca c  on b.sd_hpsrvtp=c.sd_hpsrvtp                           ");         
	 sql1.append("      join bd_udidoc     d on  b.sd_hpsrvtp=d.code                                 ");  
	 sql1.append("      join bd_udidoclist e  on d.id_udidoclist= e.id_udidoclist                    ");  
	 sql1.append("      where   e.name like '%医保计划目录类型%'                                           ");
	 sql1.append("       and  t.id_incoep = ?                                                        ");
	 sql1.append("       and  t.id_pat    =   ?                                                      ");
	 sql1.append("       and  t.id_incca  =   ?                                                      ");
	 sql1.append("       and  b.sd_hpsrvtp is not null                                               ");
	 
	 
	SqlParam sp=new SqlParam();
	sp.addParam(id_incoep);
	sp.addParam(id_pat);
	sp.addParam(id_incca);
	 List<BlInvoiceDetailsDTO> list  = (List<BlInvoiceDetailsDTO>)new DAFacade().execQuery(sql1.toString(),sp, new BeanListHandler(BlInvoiceDetailsDTO.class));
	 if(list== null || list.size()==0 ){
		 return null;
	 }else{
		 return list.toArray(new BlInvoiceDetailsDTO[0])[0]; 
	 }
  }

}