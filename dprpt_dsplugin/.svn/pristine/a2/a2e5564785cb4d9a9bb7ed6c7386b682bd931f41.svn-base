package iih.mp.dg.backdrugdisp;

import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.srv.pres.CiorderBasePresPrintService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;

public class BackdrugdispPrintService extends CiorderBasePresPrintService {

	/**
	 * 获得患者就诊医嘱处方信息
	 * 
	 * @param ids
	 *            重打或补打处方时处方Id数组
	 * @return
	 * @throws BizException
	 */
	@Override
	public List<OrdPresDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))return null;
		//处方查询
		List<OrdPresDTO> preslist = this.getOrderList(this.getOrdInfoSqlQry(ids));
		//药品服务查询
		List<PresDrugDTO> druglist=this.getItemList(this.getItmInfoSqlQry(ids));
		
		Map<String,List<PresDrugDTO>> maps=new HashMap<String,List<PresDrugDTO>>();
		for(PresDrugDTO dto:druglist){
			if(maps.containsKey(dto.getId_pres())){
				maps.get(dto.getId_pres()).add(dto);
			}
			else{
				List<PresDrugDTO> lst=new ArrayList<PresDrugDTO>();
				lst.add(dto);
				maps.put(dto.getId_pres(), lst);
			}
		}
		if (preslist == null || preslist.size() == 0)return null;
		// 获得处方明细信息
		for (int i = 0; i < preslist.size(); i++) {// 遍历
			// 设置医嘱处方对应的处方明细信息
			preslist.get(i).setPresDrugList(maps.get(preslist.get(i).getId_pres()));
		}
		this.setOrdInfo(preslist);

		return preslist;
	}

	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append(" select distinct A.Id_Pres,ord.fg_vip,A.Id_Grp,A.id_dep_mp,A.ID_ORG,A.ID_PATI,B.Name_Pat as name_pati,C.Name as name_patica,A.id_entp,"
				+ " A.code_entp,B.code as id_en,pat.code_amr_oep as code_amr_oep,A.No_Drugwin,A.Fg_Prepay,"
				+ " A.Str_Name_Di,A.id_srvtp,A.Sd_Srvtp,A.Id_Prestp,A.sd_prestp,D.Name as name_prestp,A.code, "
				+ " A.name,A.Id_Dep_Or,E.NAME as name_dep_or,A.Id_Emp_Or as id_emp_or,F.Name as name_emp_or,A.Dt_Entry, "
				+ " M.Name as name_card,H.Barcode_chis as barcode,I.orgcode as regnum_org,G.Name as gender,0 as age,H.dt_birth,pat2.Id_Code as idno,H.workunit," // 打印新增行部分
				+ " '' as psn_agent,'' as idno_agent,K.name as name_dep_mp,'' as des_alcla,0 as amt_total,X.name as name_grp,Y.name as name_org,"// 打印新增行部分
				+ " J.Times_op as num_pv,ord.des_or as des_or,(case when A.sd_srvtp like '0103%' then freq.Code_disp  else '' end) as Name_freq,"
				+ " (case when A.sd_prestpword like '%08%' then '[特殊病]'  else '' end) as Fg_special,"
				+ " A.Fg_hecominsur as Fg_hecominsur, A.Hecominsurinfo as Hecominsurinfo, '' as Fg_hpbirth, '' as Name_research "
				+ " from ci_pres A "
				+ " left join en_ent B on A.Id_En = B.Id_Ent "
				+ " left join pi_pat_ca C on B.Id_Patca = C.Id_Patca "
				+ " left join pi_pat pat on A.Id_pati = pat.Id_pat "
				+ " left join bd_udidoc D on A.Id_Prestp=D.Id_Udidoc "
				+ " left join bd_dep E on A.Id_Dep_Or = E.Id_Dep "
				+ " left join bd_psndoc F on A.id_emp_or = F.ID_PSNDOC "
				+ " left outer join bd_udidoc G on B.Id_Sex_Pat=G.Id_Udidoc " // 打印新增行部分
				+ " left outer join pi_pat H on A.Id_Pati=H.Id_Pat "// 打印新增行部分
				+ " left outer join pi_pat pat2 on A.Id_Pati = pat2.Id_Pat  and pat2.sd_idtp = '01' "// 获取身份证号患者
				+ " left outer join bd_org I on A.Id_Org=I.Id_Org "
				+ " left outer join en_ent_op J on A.Id_En = J.Id_Ent "// 打印新增行部分
				+ " left join bd_dep K on A.Id_Dep_mp = K.Id_Dep "
				+ " left outer join bd_udidoc M on M.Id_Udidoc=H.Id_idtp "
				+ " left outer join bd_grp X on X.id_grp = A.id_grp "
				+ " left outer join bd_org Y on Y.id_org = A.id_org "
				+ " left join (select distinct id_pres,id_or from ci_or_srv) srv on A.Id_Pres = srv.id_pres "
				+ " left join ci_order ord on srv.id_or = ord.id_or "
				+ " left outer join bd_freq freq on freq.Id_Freq = ord.Id_Freq ");
		String wherestr = "";
		if (ids != null && !"".equals(ids)) {
			if (wherestr != "") {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " A.Id_Pres in (" + ids + ")";
		}
		if (!wherestr.equals("")) {
			str.append(wherestr);
		}
		return str.toString();
	}

	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append(" select B.id_pres,B.id_or,B.id_srvtp,B.sd_srvtp,B.id_srv,B.code_srv,J.Printname as name_srv,B.Id_Medu as id_unit_med,D.Name as name_unit_med,B.Quan_Medu as quan_med,"
				+ " B.id_freq,E.Code_disp as name_freq,B.id_route,F.Name as name_route,B.id_routedes,G.Name as name_routedes, "
				+ " B.id_boil,H.Name as name_boil,B.id_boildes,I.Name as name_boildes,B.fg_bl,C.Price_Pgku_Cur as price,C.id_mm,J.Name as name_mm,J.Spec as spec_mm, "
				+ " C.quan_cur,C.Id_Pgku_Cur as id_unit_sale,D1.Name as name_unit_sale,"
				+ " C.quan_num_base,C.quan_den_base,'一次' || C.quan_num_base || (case when C.quan_den_base!=1 then '/' || C.quan_den_base  else '' end)  || D2.Name  as des_uselevel,"
				+ "L.Name as name_hpsrvtp,N.Name_Agent as psn_agent, N.Idno_Agent, P.Name as Name_card_agent ,K.Orders,K.Des_or" // 打印新增行
				+ " from ci_or_srv B "
				+ " left outer join ci_or_srv_mm C on B.Id_Orsrv = C.Id_Orsrv "
				+ " left outer join bd_mm J ON C.Id_Mm=J.Id_Mm "
				+ " left outer join bd_measdoc D on B.Id_Medu = D.Id_Measdoc "
				+ " left outer join bd_measdoc D1 on C.Id_Pgku_Cur = D1.Id_Measdoc "
				+ " left outer join bd_measdoc D2 on C.Id_Pgku_Base = D2.Id_Measdoc "
				+ " left outer join bd_freq E on B.Id_Freq = E.Id_Freq "
				+ " left outer join bd_route F on B.id_route = F.Id_Route "
				+ " left outer join bd_route_des G on B.Id_Routedes = G.Id_Routedes "
				+ " left outer join bd_boil H on B.Id_Boil = H.Id_Boil "
				+ " left outer join bd_boil_des I on B.Id_Boildes = I.Id_Boildes "
				+ " left outer join ci_order K on B.Id_Or = K.Id_Or"
				+ " left outer join bd_udidoc L on L.Id_Udidoc=B.Id_Hpsrvtp " // 打印新增行
				+ " left outer join ci_orsrv_agent N on B.Id_Orsrv = N.Id_Orsrv "
				+ " left outer join bd_udidoc P on P.Id_Udidoc=N.Id_idtp_agent ");
		String wherestr = "";
		if (ids != null && !"".equals(ids)) {
			if (wherestr != "") {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " B.Id_Pres in (" + ids + ")";
		}
		if (!wherestr.equals("")) {
			str.append(wherestr);
		}

		str.append(" order by B.Sortno");

		return str.toString();
	}
}
