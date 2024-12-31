package iih.ci.ord.printmanage.srv.pres;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

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
public class CiorderInjectPrintService extends CiorderBasePresPrintService {

	@Override
	public List<OrdPresDTO> exec(String ids)throws Exception {
		if (StringUtils.isNullOrEmpty(ids))return null;
		//获取打印数据ID集合
		String strIdciapptreatexecs=getIDciapptreatexecs(ids);
		if(StringUtils.isNullOrEmpty(strIdciapptreatexecs))return null;
		//处方查询
		List<OrdPresDTO> preslist=this.getOrderList(this.getOrdInfoSqlQry(strIdciapptreatexecs));
		//药品服务查询
		List<PresDrugDTO> druglist=this.getItemList(this.getItmInfoSqlQry(ids));
		
		Map<String,List<PresDrugDTO>> maps=new HashMap<String,List<PresDrugDTO>>();
		for(PresDrugDTO dto:druglist){
			if(maps.containsKey(dto.getId_ciapptreatexec())){
				maps.get(dto.getId_ciapptreatexec()).add(dto);
			}
			else{
				List<PresDrugDTO> lst=new ArrayList<PresDrugDTO>();
				lst.add(dto);
				maps.put(dto.getId_ciapptreatexec(), lst);
			}
		}
		
		if (preslist == null || preslist.size() == 0)return null;
		// 获得处方明细信息
		CiOrderPrintDiagService diag = new CiOrderPrintDiagService();
		for (int i = 0; i < preslist.size(); i++) {//遍历
			// 设置医嘱处方对应的处方明细信息
			setOrdItmsInfo(preslist.get(i),maps.get(preslist.get(i).getId_ciapptreatexec()));
			preslist.get(i).setStr_name_di(diag.exec(preslist.get(i).getId_ent()));
		}

		return preslist;
	}

	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select TREATEXEC.Id_ciapptreatexec as Id_ciapptreatexec, ");
		str.append("ENT.code as id_en, ");
		str.append("ENT.id_ent as Id_ent, ");
		str.append("TREATEXEC.id_pat as id_pati, ");// 患者信息
		str.append("PAT.name as name_pati, ");
		str.append("PAT.dt_birth as dt_birth, ");
		str.append("PAT.id_code as idno, ");
		str.append("PAT.barcode_chis as barcode, "); 
		str.append("PAT.mob as pat_tel, ");
		str.append("SEX.name as gender, ");
		str.append("PAT.Code_amr_oep as Code_amr_oep, "); 
		str.append("TREATEXEC.id_dep_app as id_dep_or, ");// 申请科室
		str.append("DEPOR.name as name_dep_or, "); 
		str.append("PSN.name as name_emp_or, ");// 申请医生
		str.append("TREATEXEC.dt_app as dt_entry, ");// 申请日期
		str.append("TREATEXEC.str_name_di, ");// 诊断明细拼接
		str.append("GRP.name as name_grp, "); 
		str.append("ORG.name as name_org, ");//组织名字
		str.append("ORG.Enname as name_org_en, ");//组织英文名字
		str.append("TREATEXEC.Fg_blsettled as Fg_blsettled ");
		
		str.append("from ci_app_treatexec TREATEXEC ");
		str.append("left join en_ent ENT on ENT.id_ent = TREATEXEC.id_en ");
		str.append("left join pi_pat PAT on PAT.id_pat = TREATEXEC.id_pat ");
		str.append("left outer join bd_udidoc SEX on SEX.id_udidoc = PAT.id_sex ");
		str.append("left join bd_dep DEPOR on DEPOR.id_dep = TREATEXEC.id_dep_app ");
		str.append("left join bd_psndoc PSN on PSN.id_psndoc = TREATEXEC.id_emp_app ");
		str.append("left join bd_grp GRP on GRP.id_grp = TREATEXEC.id_group ");
		str.append("left join bd_org ORG on ORG.id_org = TREATEXEC.id_org ");

		String wherestr = "";
		if (wherestr.length() > 0) {
			wherestr += " and ";
		} else {
			wherestr += " where ";
		}
		wherestr += " TREATEXEC.Id_ciapptreatexec in (" + ids + ") ";

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
		str.append("AGENT.Idno_Agent, ");
		str.append("ORD.days_or||'天' as use_days, ");
		str.append(" CASE WHEN ORD.id_srv = SRV.id_srv then ORD.fg_skintest else 'N' END fg_skintest ");//皮试标识

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
		str.append(" left outer join ci_order ORD on SRV.Id_Or = ORD.Id_Or ");
		str.append(" left outer join ci_skin_test skin on skin.id_or = srv.id_or_rel ");
		
		str.append(" where SRV.fg_or='Y' and SRV.sd_su_bl!=2 ");

		str.append(" and TREATEXEC_OR.id_or in (" + ids + ") "/*+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "TREATEXEC")*/);
		str.append(" order by srv.id_or,SRV.Sortno");

		return str.toString();
	}

	/**
	 * 获取处方药品信息
	 * @param dto
	 * @param sqlQry
	 * @throws BizException
	 */
	public void setOrdItmsInfo(OrdPresDTO presDTO,List<PresDrugDTO> lstDrugDTOs) throws Exception {
		// 有效性校验
		if (presDTO.equals(null))
			return;

		Iterator<PresDrugDTO> itor = lstDrugDTOs.iterator();
		int i=0;
		while (i<=0 && itor.hasNext()) {
			PresDrugDTO drugdto = itor.next();
			presDTO.setName_srv(drugdto.getName_srv());
			presDTO.setName_mm(drugdto.getName_mm());
			presDTO.setSpec_mm(drugdto.getSpec_mm());
			if (drugdto.getQuan_cur() != null)
				presDTO.setQuan_cur(drugdto.getQuan_cur().toDouble());
			if(drugdto.getQuan_med() != null)
				presDTO.setQuan_med(drugdto.getQuan_med().toDouble());
			presDTO.setName_unit_sale(drugdto.getName_unit_sale());
			presDTO.setName_unit_med(drugdto.getName_unit_med());
			presDTO.setName_freq(drugdto.getName_freq());
			presDTO.setName_route(drugdto.getName_route());
		//	itor.remove();
			i++;
		}

		// 设置处方对应的明细信息
		presDTO.setPresDrugList(lstDrugDTOs);

		if (lstDrugDTOs != null && lstDrugDTOs.size() != 0) {
			presDTO.setOrders(lstDrugDTOs.get(0).getOrders());
		}
		if (presDTO.getDt_birth() != null) {
			Date birth = new Date();
			birth = CiorderPrintUtils.ConvertStrToDate(presDTO.getDt_birth());
			FDate dt = new FDate(birth);
			presDTO.setAge(AgeCalcUtil.getAge(dt));
		}

		String des_alcla = CiorderPrintUtils.GetPatalcla(presDTO.getId_pati());
		if (!("").equals(des_alcla)) {
			presDTO.setDes_alcla(des_alcla);
		}
	}
	/**
	 * 获取打印数据ID集合
	 * @param strIdorsrvs
	 * @return
	 * @throws Exception
	 */
	private String getIDciapptreatexecs(String ids) throws Exception{
		String sql="select distinct TREATEXEC_OR.id_ciapptreatexec as def1 "
				+ "from ci_app_treatexec_or TREATEXEC_OR "
				+ "left outer join ci_order ORD on TREATEXEC_OR.Id_or = ORD.Id_or "
				+ "where  ORD.sd_su_bl!=2 and TREATEXEC_OR.Id_or in ("+ids+")";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class,sql);
		String strIdciapptreatexec="";
		if(result!=null&&result.size()>0){
			for(UtilsDTO dto:result){
				strIdciapptreatexec+="'"+dto.getDef1()+"',";
			}
		}	
		
		return strIdciapptreatexec.length()>0?strIdciapptreatexec.substring(0, strIdciapptreatexec.length()-1):strIdciapptreatexec;
	}
}
