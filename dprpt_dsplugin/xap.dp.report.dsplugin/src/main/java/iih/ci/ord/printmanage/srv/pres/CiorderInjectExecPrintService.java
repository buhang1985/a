package iih.ci.ord.printmanage.srv.pres;

import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 注射治疗打印单查询服务类
 * @author Young
 *
 */
public class CiorderInjectExecPrintService extends CiorderInjectPrintService {

	@Override
	public List<OrdPresDTO> exec(String ids)throws Exception {
		if (StringUtils.isNullOrEmpty(ids))return null;
		//处方查询
		List<OrdPresDTO> preslist=this.getOrderList(this.getOrdInfoSqlQry(ids));
		//药品服务查询
		List<PresDrugDTO> druglist=this.getItemList(this.getItmInfoSqlQry(ids));
		//雾化药品末尾排序
		preslist = atomizationSort(preslist);
		//拼接医嘱内容,年龄
		assembleContentOr(preslist,druglist);
		return preslist;
	}
	/**
	 * 雾化药品末尾排序
	 * @param preslist
	 * @param druglist
	 */
	private List<OrdPresDTO> atomizationSort(List<OrdPresDTO> preslist) {
		//雾化药品
		ArrayList<OrdPresDTO>atomizaList = new ArrayList<OrdPresDTO>();
		//非雾化药品
		ArrayList<OrdPresDTO>notAtomizaList = new ArrayList<OrdPresDTO>();
		
		for (OrdPresDTO presdto : preslist) {
			//玉溪暂定：用法包含“雾”属于雾化药品
			if (presdto.getName_route().indexOf("雾") != -1) {
				atomizaList.add(presdto);
			} else {
				notAtomizaList.add(presdto);
			}

		}
		for(OrdPresDTO presdto:atomizaList) {
			notAtomizaList.add(presdto);
		}
		preslist = notAtomizaList;
		return preslist;
	}
	/**
	 * 拼接医嘱内容,年龄
	 * @param preslist
	 * @param druglist
	 * @throws ParseException 
	 */
	private void assembleContentOr(List<OrdPresDTO> preslist,List<PresDrugDTO> druglist) throws ParseException{
		for(OrdPresDTO presdto:preslist){
			String id_or = presdto.getId_or();
			String content_or = "";
			for(PresDrugDTO presDrug:druglist){
				if(id_or.equals(presDrug.getId_or())){
					content_or+=(presDrug.getName_mm()+"["+presDrug.getSpec_mm()+"]"+" "+presDrug.getQuan_med()+presDrug.getName_unit_med()
					+" "+presDrug.getName_freq()+"<br/>");
				}
			}
			presdto.setContent_or(content_or);
			if (presdto.getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(presdto.getDt_birth());
				FDate dt = new FDate(birth);
				presdto.setAge(AgeCalcUtil.getAge(dt));
			}
		}
	}
	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select ci.content_or as content_or, ");
		str.append("ENT.code as id_en, ");
		str.append("ci.id_pat as id_pati, ");// 患者信息
		str.append("PAT.name as name_pati, ");
		str.append("PAT.dt_birth as dt_birth, ");
		str.append("PAT.id_code as idno, ");
		str.append("PAT.barcode_chis as barcode, "); 
		str.append("PAT.mob as pat_tel, ");
		str.append("SEX.name as gender, ");
		str.append("PAT.Code_amr_oep as Code_amr_oep, "); 
		str.append("ci.id_dep_or as id_dep_or, ");// 申请科室
		str.append("DEPOR.name as name_dep_or, "); 
		str.append("PSN.name as name_emp_or, ");// 申请医生
		str.append("ci.dt_effe as dt_entry, ");// 申请日期
		str.append("GRP.name as name_grp, "); 
		str.append("ORG.name as name_org, ");//组织名字
		str.append("ORG.Enname as name_org_en, ");//组织英文名字
		str.append("route.name as name_route,");//用法
		str.append("ci.id_or as id_or, ");//用法
		str.append("TREATEXEC.str_name_di, ");// 诊断明细拼接
		str.append("ci.des_or Des_or ");// 备注
		
		str.append("from ci_order ci ");
		str.append("left join en_ent ENT on ENT.id_ent = ci.id_en ");
		str.append("left join pi_pat PAT on PAT.id_pat = ci.id_pat ");
		str.append("left outer join bd_udidoc SEX on SEX.id_udidoc = PAT.id_sex ");
		str.append("left join bd_dep DEPOR on DEPOR.id_dep = ci.id_dep_or ");
		str.append("left join bd_psndoc PSN on PSN.id_psndoc = ci.id_emp_or ");
		str.append("left join bd_grp GRP on GRP.id_grp = ci.id_grp ");
		str.append("left join bd_org ORG on ORG.id_org = ci.id_org ");
		str.append("left join bd_route route on ci.id_route=route.id_route ");
		str.append("left join (select max(str_name_di) str_name_di,id_en from ci_app_treatexec group by id_en) TREATEXEC on TREATEXEC.id_en=ENT.id_ent");
		String wherestr = "";
		if (wherestr.length() > 0) {
			wherestr += " and ";
		} else {
			wherestr += " where ";
		}
		wherestr += " ci.id_or in (" + ids + ") ";

		str.append(wherestr);

		return str.toString();
	}
	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select TREATEXEC_OR.Id_ciapptreatexec,");
		str.append("SRV.id_srv,");
		str.append("SRV.id_or,");
		str.append("SRV.code_srv,");
		str.append("SRV.id_srvtp,");
		str.append("SRV.sd_srvtp,");
		str.append("MM.Printname as name_srv,");
		str.append("MM.Name as name_mm,");
		str.append("MM.Spec as spec_mm,");
		str.append("SRV.Quan_Medu as quan_med,");
		str.append("MEASDOC.Name as name_unit_med,");
		str.append("SRV_MM.Price_Pgku_Cur as price,");
		str.append("SRV_MM.quan_cur,");
		str.append("SRV.Fg_bl,");
		str.append("MEASDOC1.Name as name_unit_sale,");
		str.append("SRV_MM.quan_num_base,");
		str.append("SRV_MM.quan_den_base,");
		str.append("'一次' || SRV_MM.quan_num_base || (case when SRV_MM.quan_den_base!=1 then '/' || SRV_MM.quan_den_base  else '' end)  || MEASDOC2.Name  as des_uselevel,");
		str.append("FREQ.Code_disp as name_freq,");
		str.append("ROUTE.Name as name_route,");
		str.append("ROUTEDES.Name as name_routedes,");
		str.append("BOIL.Name as name_boil,");
		str.append("BOILDES.Name as name_boildes,"); 
		str.append("HPSRVTP.Name as name_hpsrvtp,");
		str.append("AGENT.Name_Agent as psn_agent,");
		str.append("AGENT.Idno_Agent ");

		str.append(" from ci_or_srv SRV ");
		str.append(" left outer join ci_app_treatexec_or TREATEXEC_OR on TREATEXEC_OR.id_or = SRV.id_or ");
		str.append(" left outer join ci_or_srv_mm SRV_MM on SRV.Id_Orsrv = SRV_MM.Id_Orsrv ");
		str.append(" left outer join bd_mm MM ON SRV_MM.Id_Mm=MM.Id_Mm ");
		str.append(" left outer join bd_measdoc MEASDOC on SRV.Id_Medu = MEASDOC.Id_Measdoc ");
		str.append(" left outer join bd_measdoc MEASDOC1 on SRV_MM.Id_Pgku_Cur = MEASDOC1.Id_Measdoc ");
		str.append(" left outer join bd_measdoc MEASDOC2 on SRV_MM.Id_Pgku_Base = MEASDOC2.Id_Measdoc ");
		str.append(" left outer join bd_freq FREQ on SRV.Id_Freq = FREQ.Id_Freq ");
		str.append(" left outer join bd_route ROUTE on SRV.id_route = ROUTE.Id_Route ");
		str.append(" left outer join bd_route_des ROUTEDES on SRV.Id_Routedes = ROUTEDES.Id_Routedes ");
		str.append(" left outer join bd_boil BOIL on SRV.Id_Boil = BOIL.Id_Boil ");
		str.append(" left outer join bd_boil_des BOILDES on SRV.Id_Boildes = BOILDES.Id_Boildes ");
		str.append(" left outer join bd_udidoc HPSRVTP on HPSRVTP.Id_Udidoc=SRV.Id_Hpsrvtp ");
		str.append(" left outer join ci_orsrv_agent AGENT on SRV.Id_Orsrv = AGENT.Id_Orsrv ");
		
		str.append(" where SRV.fg_or='Y' and SRV.sd_su_bl!=2 ");

		str.append(" and srv.id_or in (" + ids + ") "/*+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "TREATEXEC")*/);
		str.append(" order by srv.id_or,SRV.Sortno");

		return str.toString();
	}
}
