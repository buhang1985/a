package iih.ci.ord.printmanage.srv.ord;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.HeadDTO;
import iih.ci.ord.printmanage.dto.ItemDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.coreitf.d.FDouble;

import com.mysql.jdbc.StringUtils;

/**
 * 病理打印数据查询服务
 * @author Young
 *
 */
public class CiorderPathgyOrdPrintService extends CiorderBaseOrdPrintService {

	/**
	 * 执行查询
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<HeadDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		//获取检验申请单打印数据ID集合
		String strIdciapppathgysheets = getIDciapppathgysheets(ids);
		if (StringUtils.isNullOrEmpty(strIdciapppathgysheets))
			return null;
		List<HeadDTO> ordlist = this.getOrderList(this.getOrdInfoSqlQry(strIdciapppathgysheets));
		
		List<ItemDTO> itmlist = this.getItemList(this.getItmInfoSqlQry(strIdciapppathgysheets));
		
		Map<String, List<ItemDTO>> mapItemDTOs = new HashMap<String, List<ItemDTO>>();
		Map<String, FDouble> mapColls = new HashMap<String, FDouble>();
		for (ItemDTO dto : itmlist) {
			if (mapItemDTOs.containsKey(dto.getId_ciapppathgysheet())) {
				mapItemDTOs.get(dto.getId_ciapppathgysheet()).add(dto);
			} else {
				List<ItemDTO> lst = new ArrayList<ItemDTO>();
				lst.add(dto);
				mapItemDTOs.put(dto.getId_ciapppathgysheet(), lst);
			}
			
			if (mapColls.containsKey(dto.getId_ciapppathgysheet())) {
				FDouble count = mapColls.get(dto.getId_ciapppathgysheet());
				mapColls.put(dto.getId_ciapppathgysheet(), count.add(dto.getQuan_coll()));
			}
			else{
				mapColls.put(dto.getId_ciapppathgysheet(), dto.getQuan_coll());
			}
		}
		if (ordlist == null || ordlist.size() == 0)
			return null;

		CiOrderPrintDiagService diag = new CiOrderPrintDiagService();
		for(int i = 0; i < ordlist.size(); i++){
			ordlist.get(i).setStr_name_di(diag.exec(ordlist.get(i).getId_en()));
			ordlist.get(i).setItemdtolist(mapItemDTOs.get(ordlist.get(i).getId_ciapppathgysheet()));
			ordlist.get(i).setQuan_coll(mapColls.get(ordlist.get(i).getId_ciapppathgysheet()));
		}
		this.setOrdInfo(ordlist);
		return ordlist;
	}
	
	/**
	 * 主DO查询SQL
	 * 
	 * @param ids
	 * @return
	 */
	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select PATHGY.Id_pat as Id_pati,");
		str.append("PAT.Name as Name_pati,");
		str.append("PAT.Dt_birth,");
		str.append("PAT_SEX.Code as Gender_code,");
		str.append("PAT_SEX.Name as Gender,");
		str.append("0 as Age,");
		str.append("PAT.Id_code as Idno,");
		str.append("PAT.Workunit,");
		str.append("PAT.Code_amr_oep,");
		str.append("PAT.Mob as Pat_tel,");
		str.append("PATHGY.Id_en,");
		str.append("PATHGY.Id_entp,");
		str.append("PATHGY.Code_entp,");
		str.append("PAT.Barcode_chis as Barcode,");
		str.append("ENT.Times_op as Num_pv,");
		str.append("PATHGY.Name_diag as Str_name_di,");
		
		str.append("PATHGY.Id_ciapppathgysheet,");
		str.append("PATHGY.Id_or,");
		str.append("PATHGY.No_applyform,");
		str.append("PATHGY.No_applyform as No_pathgy,");
		str.append("PATHGY.Code_app as Code,");
		str.append("'病理检查申请单' as Name_srvca,");
		str.append("CONCAT(PATHGY.Name_app,'[]') as Name_srv,");
		str.append("PATHGY.Fg_set,");
		str.append("PATHGY.Des_sympsign,");
		str.append("PATHGY.Fg_outer,");
		str.append("PATHGY.No_pathgy_old,");
		str.append("PATHGY.Dt_pathgy_old,");
		str.append("PATHGY.Di_pathgy_old,");
		str.append("PATHGY.Org_pathgy_old,");
		str.append("PATHGY.Dt_rptpathgy,");
		str.append("PATHGY.Collectdes,");
		str.append("PATHGY.Id_emp as Id_emp_coll,");
		str.append("PSN_COLL.Name as Name_emp_coll,");
		str.append("PATHGY.Id_dep as Id_dep_coll,");
		str.append("DEP_COLL.Name as Name_dep_coll,");
		str.append("PATHGY.Dt_coll,");
		str.append("PATHGY.Amt_app as Amt_total,");
		str.append("GRP.Name as Name_grp,"); 
		str.append("ORG.Name as Name_org,");
		str.append("ORG.ENName as Name_org_en,");//检查机构英文名称
		str.append("ORG.Shortname as Name_org_short,");//机构简称
		str.append("ENT.Id_ent as Id_en,");
		str.append("picard.code as PiCardCode,");//患者卡号
		//导引信息
		str.append("dep_mp.id_plc as Guidance, ");
		//科室地点
		str.append("dep_mp.id_plc as address,");
		str.append("PAT.Code_amr_ip as Code_amr_ip, ");//住院号
		str.append("PATHGY.Id_dep_app as Id_dep_or,");
		str.append("DEP_APP.Name as Name_dep_or,");
		str.append("PATHGY.Id_emp_app as Id_emp_or,");
		str.append("PSNDOC.Name as Name_emp_or,");
		str.append("PATHGY.Dt_app as Dt_entry,");
		str.append("PATHGY.Id_dep_mp as Id_mp_dep,");
		str.append("DEP_EMP.Name as Name_mp_dep,");

		str.append("PATHGY.Fg_opspecial as Fg_special,");
		str.append("PATHGY.Fg_hecominsur,");
		str.append("PATHGY.Hecominsurinfo,");
		str.append("PATHGY.Researchinfo as Name_research,");
		str.append("PATHGY.Fg_hpbirth,");
		str.append("PATHGY.Fg_prepay,");
		str.append("PATHGY.Fg_hp as Fg_orhp,");
		str.append("PATHGY.Fg_vip,");
		str.append("PATHGY.Fg_blsettled,");
		str.append("PATHGY.Fg_specill,");
		
		str.append("PATHGY.def1,");
		str.append("PATHGY.def2,");
		str.append("PATHGY.def3,");
		str.append("PATHGY.def4,");
		str.append("PATHGY.def5,");
		str.append("PATHGY.def6,");
		str.append("PATHGY.def7,");
		str.append("PATHGY.def8,");
		str.append("PATHGY.def9,");
		str.append("PATHGY.def10,");
		str.append("PATHGY.def11,");
		str.append("PATHGY.def12,");
		str.append("PATHGY.def13,");
		str.append("PATHGY.def14,");
		str.append("PATHGY.def15,");
		str.append("PATHGY.def16,");
		str.append("PATHGY.def17,");
		str.append("PATHGY.def18,");
		str.append("PATHGY.def19,");
		str.append("PATHGY.def20,");
		str.append("PATHGY.def21,");
		str.append("PATHGY.def22,");
		str.append("PATHGY.def23,");
		str.append("PATHGY.def24,");
		str.append("PATHGY.def25,");
		str.append("PATHGY.def26,");
		str.append("PATHGY.def27,");
		str.append("PATHGY.def28,");
		str.append("PATHGY.def29,");
		str.append("PATHGY.def30,");
		str.append("PATHGY.def31,");
		str.append("PATHGY.def32,");
		str.append("PATHGY.def33,");
		str.append("PATHGY.def34,");
		str.append("PATHGY.def35,");
		str.append("PATHGY.def36,");
		str.append("PATHGY.def37,");
		str.append("PATHGY.def38,");
		str.append("PATHGY.def39,");
		str.append("PATHGY.def40,");
		str.append("PATHGY.def41,");
		str.append("PATHGY.def42,");
		str.append("PATHGY.def43,");
		str.append("PATHGY.def44,");
		str.append("PATHGY.def45,");
		str.append("PATHGY.def46,");
		str.append("PATHGY.def47,");
		str.append("PATHGY.def48,");
		str.append("PATHGY.def49,");
		str.append("PATHGY.def50 ");

		str.append("from ci_app_pathgy PATHGY ");
		str.append("left outer join pi_pat PAT on PATHGY.Id_pat = PAT.Id_pat ");
		str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
		str.append("left outer join bd_grp GRP on GRP.Id_grp = PATHGY.Id_grp ");
		str.append("left outer join bd_org ORG on ORG.Id_org = PATHGY.Id_org ");
		str.append("left outer join en_ent_op ENT on PATHGY.Id_en = ENT.Id_ent ");
		str.append("left outer join bd_psndoc PSN_COLL on PATHGY.Id_emp = PSN_COLL.Id_psndoc ");
		str.append("left outer join bd_dep DEP_COLL on PATHGY.Id_dep = DEP_COLL.Id_dep ");
		
		str.append("left outer join bd_dep DEP_APP on PATHGY.Id_dep_app = DEP_APP.Id_dep ");
		str.append("left outer join bd_psndoc PSNDOC on PATHGY.Id_emp_app = PSNDOC.Id_psndoc ");
		str.append("left outer join bd_dep DEP_EMP on DEP_EMP.Id_dep = PATHGY.Id_dep_mp ");

		str.append(" where PATHGY.Id_ciapppathgysheet in (" + ids + ") "+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "PATHGY")+" order by PATHGY.Sv");

		return str.toString();
	}

	/**
	 * 子DO查询SQL
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select APP_PATHGY_SAMP.Id_ciapppathgysheet,");
		str.append("APP_PATHGY_SAMP.Sortno,");
		str.append("APP_PATHGY_SAMP.Name_labsamp,");
		str.append("APP_PATHGY_SAMP.Body_coll,");
		str.append("APP_PATHGY_SAMP.Quan_coll,");
		str.append("APP_PATHGY_SAMP.Fixative ");
		
		str.append("from ci_app_pathgy_samp APP_PATHGY_SAMP ");
		
		str.append("where APP_PATHGY_SAMP.Id_ciapppathgysheet in (" + ids + ") ");
		str.append("order by APP_PATHGY_SAMP.Sortno");
		return str.toString();
	}
	
	/**
	 * 
	 * @param strIdors
	 * @return
	 * @throws Exception
	 */
	private String getIDciapppathgysheets(String strIdors) throws Exception {
		String sql = "select distinct PATHGY.id_ciapppathgysheet as def1 "
				+ "from ci_app_pathgy PATHGY "
				+ "left outer join ci_order ORD on PATHGY.Id_or = ORD.Id_or "
				+ "where ORD.sd_su_bl!=2 and PATHGY.id_or in (" + strIdors + ")";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, sql);
		String strIdciapppathgysheets = "";
		if (result != null && result.size() > 0) {
			for (UtilsDTO dto : result) {
				strIdciapppathgysheets += "'" + dto.getDef1() + "',";
			}
		}

		return strIdciapppathgysheets.length() > 0 ? strIdciapppathgysheets.substring(0, strIdciapppathgysheets.length() - 1)
				: strIdciapppathgysheets;
	}
}
