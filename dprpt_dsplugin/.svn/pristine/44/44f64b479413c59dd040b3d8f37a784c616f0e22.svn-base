package iih.ci.ord.printmanage.srv.pres;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院草药打印Service
 * 
 * @author LiYue
 *  2018年3月1日
 */
public class CiordIpPresService implements ICiorderPrintService<OrdPresDTO, PresDrugDTO> {

	@Override
	public List<OrdPresDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		// 处方查询
		List<OrdPresDTO> preslist = this.getOrderList(this.getOrdInfoSqlQry(ids));
		// 药品服务查询
		List<PresDrugDTO> druglist = this.getItemList(this.getItmInfoSqlQry(ids));
		Map<String, List<PresDrugDTO>> maps = new HashMap<String, List<PresDrugDTO>>();
		for (int i = 0; i < druglist.size(); i++) {
			if (maps.containsKey(druglist.get(i).getId_pres())) {
				maps.get(druglist.get(i).getId_pres()).add(druglist.get(i));
			} else {
				List<PresDrugDTO> lst = new ArrayList<PresDrugDTO>();
				lst.add(druglist.get(i));
				maps.put(druglist.get(i).getId_pres(), lst);
			}
		}
		if (preslist == null || preslist.size() == 0)
			return null;
		List<OrdPresDTO> rst = new ArrayList<OrdPresDTO>();
		// 获得处方明细信息
		for (int i = 0; i < preslist.size(); i++) {// 遍历
			List<PresDrugDTO> lstDrugDTOs = maps.get(preslist.get(i).getId_pres());
			if (lstDrugDTOs == null || lstDrugDTOs.size() <= 0) {
				continue;
			}

			// 设置医嘱处方对应的处方明细信息
			preslist.get(i).setPresDrugList(lstDrugDTOs);
			rst.add(preslist.get(i));
		}
		this.setOrdInfo(rst);

		return rst;
	}
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrdPresDTO> exec(String ids, String blstatetp) throws Exception{
		return null;
	}

	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select PRES.Id_Pres,");
		
		str.append("enip.id_dep_nuradm,");
		str.append("enip.id_bed,");

		str.append("bd1.NAme as Sd_emp_phy,");
		str.append("bd2.NAme as Sd_emp_nur,");
		str.append("bd3.Name as Unit,");
		str.append("bd4.Name as Bed_num,");
		
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
		str.append("PRES.Id_entp,");
		str.append("PRES.Code_entp,");
		str.append("ENT_OP.Times_op as Num_pv,");

		str.append("GRP.name as Name_grp,");
		str.append("ORG.name as Name_org,");
		str.append("(select value from sys_paramset where paramcode='BLHP000002') as Regnum_org,");
		str.append("DEP_OR.NAME as Name_dep_or,");
		str.append("EMP_OR.Name as Name_emp_or,");
		str.append("DEP_MP.name as Name_dep_mp,");
		str.append("PRES.Dt_entry,");
		str.append("PRES.Str_Name_Di,");

		str.append("PRES.Code,");
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
		str.append("'' as Name_research,");
		str.append("(case when PRES.Sd_prestpword like '%08%' then '[特殊病]' else '' end) as Fg_special,");
		str.append("(case when PRES.Sd_prestpword like '%06%' then '[基数药]' else '' end) as Fg_base,");
		str.append("pripat.name Name_patica ");

		str.append(" from ci_pres PRES ");
		str.append(" inner join en_ent on PRES.id_en = en_ent.id_ent ");
		
		str.append(" left outer join en_ent_ip enip on enip.id_ent = en_ent.id_ent ");
		str.append(" left outer join bd_psndoc bd1 on bd1.Id_psndoc = en_ent.Id_emp_phy ");
		str.append(" left outer join bd_psndoc bd2 on bd2.id_psndoc = en_ent.Id_emp_nur ");
		str.append(" left outer join bd_dep bd3    on bd3.id_dep = enip.id_dep_nuradm ");
		str.append(" left outer join bd_bed bd4    on bd4.id_bed = enip.id_bed ");
		
		str.append(" left outer join pi_pat PAT on PRES.Id_pati = PAT.Id_pat ");
		str.append(" left outer join bd_udidoc PAT_SEX on PAT.Id_Sex = PAT_SEX.Id_Udidoc ");
		str.append(" left outer join bd_udidoc IDCARD_TP on IDCARD_TP.Id_Udidoc = PAT.Id_idtp ");
		str.append(" left outer join en_ent_ip ENT_IP on PRES.Id_En = ENT_IP.Id_Ent ");
		str.append(" left outer join bd_grp GRP on GRP.id_grp = PRES.id_grp ");
		str.append(" left outer join bd_org ORG on ORG.id_org = PRES.id_org ");
		str.append(" left outer join bd_dep DEP_OR on PRES.Id_Dep_Or = DEP_OR.Id_Dep ");
		str.append(" left outer join bd_psndoc EMP_OR on PRES.Id_emp_or = EMP_OR.ID_PSNDOC ");
		str.append(" left outer join bd_dep DEP_MP on PRES.Id_Dep_mp = DEP_MP.Id_Dep ");
		str.append(" left outer join bd_udidoc PRESTP on PRES.Id_Prestp=PRESTP.Id_Udidoc ");
		str.append(" left outer join bd_pri_pat pripat on en_ent.id_pripat = pripat.id_pripat ");

		String wherestr = "";
		if (!StringUtils.isNullOrEmpty(ids)) {
			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " PRES.Id_Pres in (" + ids + ")";
		}
		str.append(wherestr);
		return str.toString();
	}

	// 医嘱处方信息
	@Override
	public List<OrdPresDTO> getOrderList(String sqlQry) throws Exception {
		List<OrdPresDTO> result = CiorderPrintUtils.GetQueryResulte(OrdPresDTO.class, sqlQry);
		return result;
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
		str.append(
				"(case when SRV.Fg_nothingwithorders='Y' then '★' else '' end)||(case when SRV.Sd_srvtp not like '0103%' and SRV.Id_srv!=ORD.Id_srv then '--'||MM.Printname else MM.Printname end) as Name_srv,");
		str.append("MM.Name as Name_mm,");
		str.append("MM.Spec as Spec_mm,");
		str.append("SRV.Quan_Medu as quan_med,");
		str.append("MEASDOC.Name as name_unit_med,");
		str.append("SRV_MM.Quan_cur,");
		str.append("MEASDOC1.Name as Name_unit_sale,");
		str.append("SRV_MM.Quan_num_base,");
		str.append("SRV_MM.Quan_den_base,");
		str.append(
				"'一次' || SRV_MM.Quan_num_base || (case when SRV_MM.Quan_den_base!=1 then '/' || SRV_MM.Quan_den_base  else '' end) || MEASDOC2.Name as Des_uselevel,");
		str.append("SRV.Fg_bl,");
		str.append("SRV_MM.Price_Pgku_Cur as Price,");
		str.append("FREQ.Code_disp as Name_freq,");
		str.append("ROUTE.Name as Name_route,");
		str.append("ROUTEDES.Name as Name_routedes,");
		str.append("BOIL.Name as Name_boil,");
		str.append("BOILDES.Name as Name_boildes,");
		str.append("HPSRVTP.Name as Name_hpsrvtp,");
		str.append("AGENT.Name_Agent as Psn_agent, ");
		str.append("AGENT.Idno_Agent,");
		str.append("AGENT_CARD.Name as Name_card_agent,");
		str.append("ORD.Orders,");
		str.append("SUBSTR(ORD.Des_or,1,30) as Des_or ");

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

		String wherestr = " where SRV.sd_su_bl!=2 ";
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

	// 处方药品信息
	@Override
	public List<PresDrugDTO> getItemList(String sqlQry) throws Exception {
		List<PresDrugDTO> result = CiorderPrintUtils.GetQueryResulte(PresDrugDTO.class, sqlQry);
		return result;
	}

	@Override
	public void setOrdInfo(List<OrdPresDTO> dtos) throws Exception {
		for (OrdPresDTO dto : dtos) {
			// 设置年龄（格式）
			if (dto.getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(dto.getDt_birth());
				FDate dt = new FDate(birth);
				dto.setAge(AgeCalcUtil.getAge(dt));
			}
			// 设置过敏史
			if (dto.getId_pati() != null) {
				String des_alcla = CiorderPrintUtils.GetPatalcla(dto.getId_pati());
				dto.setDes_alcla(des_alcla);
			}

			List<PresDrugDTO> drugdtos = dto.getPresDrugList();
			if (drugdtos != null && drugdtos.size() > 0) {
				//
				dto.setOrders(drugdtos.get(0).getOrders());
				dto.setDes_or(StringUtils.isNullOrEmpty(drugdtos.get(0).getDes_or())
						|| drugdtos.get(0).getDes_or().length() < 30 ? drugdtos.get(0).getDes_or()
								: drugdtos.get(0).getDes_or().substring(0, 30));
				dto.setName_freq(drugdtos.get(0).getName_freq());
				dto.setPsn_agent(drugdtos.get(0).getPsn_agent());
				dto.setIdno_agent(drugdtos.get(0).getIdno_agent());
				dto.setName_card_agent(drugdtos.get(0).getName_card_agent());
				// 总价
				FDouble atm_tatol = new FDouble("0.00");
				for (PresDrugDTO drugdto : drugdtos) {
					if (!(drugdto.getPrice() == null || drugdto.getQuan_cur() == null)) {
						atm_tatol = atm_tatol.add(drugdto.getPrice().multiply(drugdto.getQuan_cur()));
					}
				}
				atm_tatol = atm_tatol.setScale(-2, BigDecimal.ROUND_HALF_UP);
				dto.setAmt_total(atm_tatol);
			}
		}

	}

}
