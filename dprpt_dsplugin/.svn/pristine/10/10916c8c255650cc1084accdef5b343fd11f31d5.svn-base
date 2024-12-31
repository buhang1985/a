package iih.mp.dg.pres.tl;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import iih.ci.ord.printmanage.srv.pres.CiorderPresPrintService;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**  
 * ClassName:MpDgOpRtnPresPrintService <br/>  
 * Function: 退药处方签打印 <br/>  
 * Date:     2019年6月12日 下午3:03:19 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_76       
 */
public class MpDgOpRtnPresPrintService extends CiorderPresPrintService{
	
	public List<OrdPresDTO> exec(String ids,String id_dgop) throws Exception {
		this.Bl_State = ICiorderPrintConst.BLSTATE_ALL;
		List<OrdPresDTO> presList = super.exec(ids);
		for (OrdPresDTO ordPresDTO : presList) {
			FDouble amt_rtn_total = FDouble.ZERO_DBL;
			FDouble amt_diff_total = FDouble.ZERO_DBL;
			FDouble amt_total = FDouble.ZERO_DBL;
			List<PresDrugDTO> list = ordPresDTO.getPresDrugList();
			for (PresDrugDTO presDrugDTO : list) {
				String rtnsql = "select -opdt.quan_bk quan_cur_rtn,-(opdt.quan_bk * opdt.price_pkgu_cur) amt_rtn from mp_dg_op_dt opdt inner join  mp_dg_op dgop on opdt.id_dgop = dgop.id_dgop  "
						+ "where dgop.id_dgop='"+id_dgop+"' and dgop.id_pres = '"+presDrugDTO.getId_pres()+"' and opdt.id_mm ='"+presDrugDTO.getId_mm()+"' and opdt.id_orsrv='"+presDrugDTO.getId_orsrv()+"' and dgop.sd_mpdgtp = '14'";
				List<PresDrugDTO> rtnlsit = (List<PresDrugDTO>) new DAFacade().execQuery(rtnsql, new BeanListHandler(PresDrugDTO.class));
				String sql = "select opdt.quan_mp quan_cur,(opdt.quan_mp * opdt.price_pkgu_cur) amt from mp_dg_op_dt opdt inner join  mp_dg_op dgop on opdt.id_dgop = dgop.id_dgop  "
						+ "where dgop.id_pres = '"+presDrugDTO.getId_pres()+"' and opdt.id_mm ='"+presDrugDTO.getId_mm()+"' and opdt.id_orsrv='"+presDrugDTO.getId_orsrv()+"' and dgop.sd_mpdgtp <> '14'";
				List<PresDrugDTO> sqllsit = (List<PresDrugDTO>) new DAFacade().execQuery(sql, new BeanListHandler(PresDrugDTO.class));
				if (rtnlsit != null && rtnlsit.size() >0) {
					presDrugDTO.setQuan_cur_rtn(rtnlsit.get(0).getQuan_cur_rtn());
					presDrugDTO.setAmt_rtn(rtnlsit.get(0).getAmt_rtn());
					amt_rtn_total = amt_rtn_total.add(presDrugDTO.getAmt_rtn());
				}else {
					presDrugDTO.setQuan_cur_rtn(FDouble.ZERO_DBL);
					presDrugDTO.setAmt_rtn(FDouble.ZERO_DBL);
					amt_rtn_total = amt_rtn_total.add(presDrugDTO.getAmt_rtn());
				}
				if (sqllsit != null && sqllsit.size() >0) {
					presDrugDTO.setQuan_cur(sqllsit.get(0).getQuan_cur());
					presDrugDTO.setAmt(sqllsit.get(0).getAmt());
					amt_total = amt_total.add(presDrugDTO.getAmt());
				}
			}
			ordPresDTO.setAmt_rtn_total(amt_rtn_total);
			ordPresDTO.setAmt_total(amt_total);
			amt_diff_total = ordPresDTO.getAmt_total().add(ordPresDTO.getAmt_rtn_total());
			ordPresDTO.setAmt_Diff_total(amt_diff_total);
		}
		return presList;
	}
	
	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select distinct PRES.Id_Pres,");
		//
		str.append("(case when PRES.sd_prestpword like '15%' then '慢' when nvl(PRES.sd_prestpword,'~')='~' then PRESTPTP.shortname else PRESTPWORD.name end) as Name_prestpword,");
		str.append("PAT.Code as Id_pati,");
		str.append("PAT.Name as Name_pati,");
		str.append("PAT_SEX.Name as Gender,");
		str.append("PAT.Dt_birth,");
		str.append("0 as Age,");
		str.append("IDCARD_TP.Name as Name_card,");
		str.append("PAT.Id_code as Idno,");
		str.append("PAT.Workunit,");
		str.append("PAT.Code_amr_oep as Code_amr_oep,");
		str.append("PAT.Barcode_chis as Barcode,");
		str.append("ENTHP.No_hp as HpCode,");//医保卡号
		str.append("bd_hp.sd_hptp,");//医保编码
		str.append("picard.code as PiCardCode,");//患者卡号
		str.append("PATCA.code as Patca,");
		//**************************************************************************//
		/**
		 * 
		 * sql拼接住院号和床号，床号是从en_ent_ip取出来的
		 * bug：127041:住院中药处方应该打印住院号2018000001，不应显示患者编码，需要显示床号
		 * liyuelong 2018-07-23
		 */
		
		//增加住院号和床号 --2018-07-23
		str.append("PAT.Code_amr_ip as Code_amr_ip,");
		str.append("ENT_IP.NAME_BED as Bed_num,");
		//**************************************************************************//
		str.append("EN.Code as Code_en,");
		str.append("EN.Id_ent as Id_en,");
		str.append("EN.dt_acpt as Dt_acpt,");
		str.append("PRES.Id_entp,");
		str.append("PRES.Code_entp,");
		str.append("ENT_OP.Times_op as Num_pv,");
		str.append("ENT_OP.Fg_first as Fg_first,");
		str.append("(case when PRES.Sd_prestpword like '%03%' then '体重：'||PRES.id_weight_unit else '' end) as Weight_baby,");
		
		str.append("pils_or.name as Name_Pils,");//发药人
		str.append("GRP.name as Name_grp,");
		str.append("ORG.name as Name_org,");
		str.append("ORG.code as Code_org,");
		str.append("ORG.Shortname as Name_org_short,");//机构简称
		str.append("ORG.Enname as Name_org_en,");
		str.append("(select value from sys_paramset where paramcode = 'BLHP000002' and id_org = PRES.id_org) as Regnum_org,");
		str.append("DEP_OR.NAME as Name_dep_or,");
		str.append("EMP_OR.Name as Name_emp_or,");
		str.append("DEP_MP.name as Name_dep_mp,");
		str.append("PRES.Dt_entry,");
		str.append("PRES.Str_Name_Di,");

		//0126759: 处方上并没有特殊病，慢病标识
		//超量开单原因id sd，sd_excessive_reason=2:慢性病，sd_excessive_reason=3：老年病
		str.append(" ORD.Id_excessive_reason as id_excessive_reason,");
		str.append(" ORD.Sd_excessive_reason as sd_excessive_reason,");
		
		str.append("PRES.Code,");
		str.append("PAT.Code as Code_pat,");
		str.append("PRES.Name,");
		str.append("PRESTP.Name as Name_prestp,");
		str.append("PRES.Code_pois as Code_drug,");
		str.append("PRES.No_Drugwin,");
		str.append("PRES.Fg_vip,");
		str.append("PRES.Fg_Prepay,");
		str.append("PRES.Fg_hecominsur as Fg_hecominsur,");
		str.append("PRES.Hecominsurinfo as Hecominsurinfo,");
		str.append("PRES.Fg_blsettled,");
		str.append("PRES.Sd_prestpword,");
		str.append("'' as Fg_hpbirth,");
		str.append("PRES.Researchinfo as Name_research,");
//		str.append("PRES.Fg_opspecial,");
		str.append("(case when PRES.Sd_prestpword like '%08%' then '[特殊病]' else '' end) as Fg_special,");
		str.append("(case when PRES.Sd_prestpword like '%06%' then '[基数药]' else '' end) as Fg_base,");
		str.append("pripat.name Name_patica,");
		//-------------0151218: 处方上边显示的患者家庭住址区县重复-----------------------//
		//str.append("PAT.mob as mobile,ba.fullname||ppa.street as address");
		str.append("PAT.mob as mobile,ba.fullname as county,ppa.street as address");
		//--------------------------------------------------------------------//
		str.append(" from ci_pres PRES ");
		str.append(" inner join en_ent EN on PRES.id_en = EN.id_ent ");
		//**************************************************************************//
		/**
		 * bug：127041:住院中药处方应该打印住院号2018000001，不应显示患者编码，需要显示床号
		 * 左连接en_ent_ip表，里面有床号
		 * liyuelong 2018-07-23
		 */
		str.append(" left outer join en_ent_ip ENT_IP on  ENT_IP.Id_Ent=PRES.Id_En ");
		str.append(" left outer join en_ent_hp ENTHP on EN.id_ent = ENTHP.Id_ent ");
		//**************************************************************************//
		//超量开单原因关联
		str.append(" left outer join ci_or_srv ORS on PRES.Id_pres = ORS.Id_pres ");
		str.append(" left outer join ci_order ORD on ORS.Id_or = ORD.Id_or ");
		
		//医保 自费
		str.append(" left outer join pi_pat_ca PATCA on PATCA.id_patca = EN.id_patca ");
		
		str.append(" left outer join pi_pat PAT on PRES.id_pati = PAT.id_pat ");
		//有处方字显示处方字，没有处方字显示处方类型
		str.append(" left outer join bd_udidoc PRESTPWORD on PRESTPWORD.id_udidoc = PRES.id_prestpword ");
		str.append(" left outer join bd_udidoc PRESTPTP on PRESTPWORD.id_udidoc = PRES.id_prestp ");
		str.append(" left outer join bd_udidoc PAT_SEX on PAT.id_sex = PAT_SEX.id_udidoc ");
		str.append(" left outer join bd_udidoc IDCARD_TP on IDCARD_TP.id_udidoc = PAT.id_idtp ");
		str.append(" left outer join en_ent_op ENT_OP on PRES.id_en = ENT_OP.id_ent ");
		str.append(" left outer join bd_grp GRP on GRP.id_grp = PRES.id_grp ");
		str.append(" left outer join bd_org ORG on ORG.id_org = PRES.id_org ");
		str.append(" left outer join bd_dep DEP_OR on PRES.id_dep_or = DEP_OR.id_dep ");
		
		str.append(" left outer join MP_DG_OP pils on PRES.id_pres = pils.id_pres and pils.sd_mpdgtp='14' ");
		str.append(" left outer join bd_psndoc pils_or on pils.ID_EMP_DP = pils_or.id_psndoc ");
		
		str.append(" left outer join bd_psndoc EMP_OR on PRES.id_emp_or = EMP_OR.id_psndoc ");
		str.append(" left outer join bd_dep DEP_MP on PRES.id_dep_mp = DEP_MP.id_dep ");
		str.append(" left outer join bd_udidoc PRESTP on PRES.id_prestp=PRESTP.id_udidoc ");
		str.append(" left outer join bd_pri_pat pripat on EN.id_pripat = pripat.id_pripat ");
		str.append(" left outer join pi_pat_addr ppa on ppa.id_pat = PAT.id_pat and ppa.sd_addrtp='9'");
		str.append(" left outer join bd_adminarea ba on ba.id_adminarea=ppa.id_admdiv");
		str.append(" left outer join pi_pat_card picard on picard.id_pat = PAT.Id_pat and picard.fg_def='Y' and picard.fg_act='Y' ");//患者的就诊卡
		str.append(" left outer join bd_hp on bd_hp.id_hp = ENTHP.id_hp ");
		String wherestr = "";
		if (!StringUtils.isNullOrEmpty(ids)) {
			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " PRES.Id_Pres in (" + ids + ") "+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "PRES");
		}
		str.append(wherestr);
		return str.toString();
	}
	
	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select SRV.Id_pres,");
		str.append("SRV.Id_or,");
		str.append("SRV.Id_orsrv,");
		str.append("SRV.Id_srvtp,");
		str.append("SRV.Sd_srvtp,");
		str.append("SRV.Id_srv,");
		str.append("SRV.Code_srv,");
		str.append("SRV.Sortno,");
		str.append("(case when SRV.Fg_nothingwithorders='Y' then '★' else '' end)||(case when SRV.Sd_srvtp not like '0103%' and SRV.Id_srv!=ORD.Id_srv then '--'||MM.Printname else MM.Printname end) as Name_srv,");
		str.append("MM.Name as Name_mm,");
		str.append("MM.id_mm as id_mm,");
		str.append("MM.Spec as Spec_mm,");
		str.append("SRV.Quan_Medu as Quan_med,");
		str.append("MEASDOC.Name as Name_unit_med,");
		str.append("SRV_MM.Quan_cur,");
		str.append("MEASDOC1.Name as Name_unit_sale,");
		str.append("SRV_MM.Quan_num_base,");
		str.append("MEASDOC2.Name as Name_unit_base,");
		str.append("SRV_MM.Quan_den_base,");
		str.append("'' Des_uselevel,");
		str.append("SRV.Fg_bl,");
		str.append("SRV_MM.Price_Pgku_Cur as Price,");
		str.append("FREQ.Code_disp as Name_freq,");
		str.append("ROUTE.Name as Name_route,");
		str.append("ROUTEDES.Name as Name_routedes,");
		str.append("BOIL.Name as Name_boil,");
		str.append("(case when BOILDES.Name is null then '' else '('||BOILDES.Name||')' end) as Name_boildes,");
		str.append("ORD.Orders_boil,");
		str.append("HPSRVTP.Name as Name_hpsrvtp,");
		str.append("AGENT.Name_Agent as Psn_agent, ");
		str.append("AGENT.Idno_Agent,");
		str.append("AGENT_CARD.Name as Name_card_agent,");
		str.append("ORD.Orders,");
		str.append("skin.sd_rst_skintest,");
		
		
		//***********************************************//
		/**
		 * 注释掉用法的描述 把截取长度去掉；全部显示用法描述
		 * (郑州骨伤科医院需求)bug：127039
		 * liyuelong 2018-07-23
		 */
		//str.append("SUBSTR(ORD.Des_or,1,30) as Des_or,");
		str.append("Des_or,");
		//***********************************************//
		str.append("ORD.fg_boil ");		

		str.append(" from ci_or_srv SRV ");
		str.append(" left outer join ci_or_srv_mm SRV_MM on SRV.Id_Orsrv = SRV_MM.Id_Orsrv ");
		str.append(" left outer join bd_mm MM ON SRV_MM.Id_Mm=MM.Id_Mm ");
		str.append(" left outer join bd_measdoc MEASDOC on SRV.Id_Medu = MEASDOC.Id_Measdoc ");
		str.append(" left outer join bd_measdoc MEASDOC1 on SRV_MM.Id_Pgku_Cur = MEASDOC1.Id_Measdoc ");
		str.append(" left outer join bd_measdoc MEASDOC2 on SRV_MM.Id_Pgku_Base = MEASDOC2.Id_Measdoc ");
		str.append(" left outer join bd_freq FREQ on SRV.Id_Freq = FREQ.Id_Freq ");
		str.append(" left outer join bd_route ROUTE on SRV.Id_route = ROUTE.Id_Route ");
		str.append(" left outer join bd_route_des ROUTEDES on SRV.Id_Routedes = ROUTEDES.Id_Routedes ");
		str.append(" left outer join bd_boil BOIL on SRV.Id_Boil = BOIL.Id_Boil ");
		str.append(" left outer join bd_boil_des BOILDES on SRV.Id_Boildes = BOILDES.Id_Boildes ");
		str.append(" left outer join ci_order ORD on SRV.Id_Or = ORD.Id_Or ");
		str.append(" left outer join bd_udidoc HPSRVTP on HPSRVTP.Id_Udidoc=SRV.Id_Hpsrvtp ");
		str.append(" left outer join ci_orsrv_agent AGENT on SRV.Id_Orsrv = AGENT.Id_Orsrv ");
		str.append(" left outer join bd_udidoc AGENT_CARD on AGENT_CARD.Id_Udidoc = AGENT.Id_idtp_agent ");
		str.append(" left outer join ci_skin_test skin on skin.id_or = srv.id_or_rel ");

		String wherestr = " where 1=1 ";
		if (!StringUtils.isNullOrEmpty(ids)) {
			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " SRV.Id_Pres in (" + ids + ")";
		}
		str.append(wherestr);
		str.append(" order by SRV.Id_or,SRV.Sortno");

		return str.toString();
	}
}
  
