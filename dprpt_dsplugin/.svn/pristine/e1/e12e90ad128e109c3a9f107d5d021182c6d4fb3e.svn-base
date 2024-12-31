package iih.ci.ord.printmanage.srv.ord;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.CiAppBtItemSheetDTO;
import iih.ci.ord.printmanage.dto.CiAppBtSheetDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;

/**
 * 备血申请单打印服务
 * @author Young
 *
 */
public class CiorderBtPrintService implements ICiorderPrintService<CiAppBtSheetDTO, CiAppBtItemSheetDTO> {
	
	protected String Bl_State = ICiorderPrintConst.BLSTATE_UNPAID;
	
	/**
	 * 获取备血申请单数据集
	 */
	@Override
	public List<CiAppBtSheetDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		List<CiAppBtSheetDTO> ordlist = this.getOrderList(this.getOrdInfoSqlQry(ids));
		if (ordlist == null || ordlist.size() <= 0)
			return null;
		String strIdciappbtsheets = "";
		for (CiAppBtSheetDTO dto : ordlist) {
			strIdciappbtsheets += ",'" + dto.getId_ciappbtsheet() + "'";
		}
		List<CiAppBtItemSheetDTO> itemDTOs = this.getItemList(this.getItmInfoSqlQry(strIdciappbtsheets.substring(1)));
		Map<String, List<CiAppBtItemSheetDTO>> maps = new HashMap<String, List<CiAppBtItemSheetDTO>>();
		for (CiAppBtItemSheetDTO dto : itemDTOs) {
			if (maps.containsKey(dto.getId_ciappbtsheet())) {
				maps.get(dto.getId_ciappbtsheet()).add(dto);
			} else {
				List<CiAppBtItemSheetDTO> lst = new ArrayList<CiAppBtItemSheetDTO>();
				lst.add(dto);
				maps.put(dto.getId_ciappbtsheet(), lst);
			}
		}
		CiOrderPrintDiagService diag = new CiOrderPrintDiagService();
		for(int i = 0; i < ordlist.size(); i++){
			//查最新诊断
			ordlist.get(i).setStr_name_di(diag.exec(ordlist.get(i).getId_en()));
			
			ordlist.get(i).setItemdtolist(maps.get(ordlist.get(i).getId_ciappbtsheet()));
			// 设置年龄（格式）
			if (ordlist.get(i).getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(ordlist.get(i).getDt_birth());
				FDate dt = new FDate(birth);
				ordlist.get(i).setAge(AgeCalcUtil.getAge(dt));
			}
		}

		return ordlist;
	}
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CiAppBtSheetDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		this.Bl_State = blstatetp;
		return this.exec(ids);
	}

	/**
	 * 拼接查询主SQL
	 */
	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select APPBT.Id_ciappbtsheet,");
		str.append("APPBT.Code_app_bt,");
		str.append("PAT.Name as Name_pati,");
		str.append("PAT_SEX.Name as Gender,");
		str.append("PAT.Dt_birth,");
		str.append("PAT.Id_code as Idno,");
		str.append("PAT.Code_amr_oep,");
		str.append("ENT.Code as Code_en,");
		str.append("ENT.Id_ent as Id_en,");
		str.append("DEPUNIT.Name as Unit,");
		str.append("ENTIP.Name_bed as Bed_num,");
		str.append("GRP.Name as Name_grp,");
		str.append("ORG.Name as Name_org,");
		
		str.append("SRV.Name as Name_srv,");
		str.append("DEMANDSU.Name as Name_demandsu_bt,");
		str.append("HISBT.Name as Name_his_bt,");
		str.append("APPBT.Quan_medu_bt as Quan_medu_bt,");
		str.append("MEASDOC.Name as Name_medu_unit,");
		str.append("APPBT.Pregnant_num,");
		str.append("APPBT.Parturition_cnt,");
		str.append("PPSBT.Name as Name_pps_bt,");
		str.append("APPBT.Str_name_di,");
		str.append("(select listagg(name,',') within GROUP (order by code) from bd_udidoc where id_udidoc in (select REGEXP_SUBSTR(APPBT.Id_mode_bt, '[^,]+',1,rownum) ");
		str.append("from dual CONNECT BY ROWNUM <= LENGTH(APPBT.Id_mode_bt) - LENGTH(REPLACE(APPBT.Id_mode_bt,',', '')) + 1)) as Name_mode_bt,");
		str.append("BLOODTP.Name as Name_app_bloodtype,");
		str.append("RHD.Name as Name_app_rhd,");
		str.append("APPBT.Des_or,");
		str.append("APPBT.Dt_pl_bt,");
		str.append("APPBT.Str_rpt,");
		str.append("PSNDOC.Name as Name_emp_bt,");
		str.append("APPBT.Dt_app_bt ");

		str.append("from ci_app_bt APPBT ");
		str.append("left outer join ci_ap_bt APBT on APBT.Id_apbt = APPBT.Id_apbt ");
		str.append("left outer join bd_udidoc DEMANDSU on DEMANDSU.Id_udidoc = APBT.Id_demandsu_bt ");
		str.append("left outer join ci_order ORD on APPBT.Id_or = ORD.Id_or ");
		str.append("left outer join bd_srv SRV on APPBT.Id_srv = SRV.Id_srv ");
		str.append("left outer join pi_pat PAT on APPBT.Id_pat = PAT.Id_pat ");
		str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
		str.append("left outer join bd_grp GRP on GRP.Id_grp = APPBT.Id_grp ");
		str.append("left outer join bd_org ORG on ORG.Id_org = APPBT.Id_org ");
		str.append("left outer join en_ent ENT on APPBT.Id_en = ENT.Id_ent ");
		str.append("left outer join en_ent_ip ENTIP on APPBT.Id_en = ENTIP.Id_ent ");
		str.append("left outer join bd_dep DEPUNIT on DEPUNIT.Id_dep = ENTIP.Id_dep_nuradm ");
		str.append("left outer join bd_udidoc HISBT on HISBT.Id_udidoc = APPBT.Id_his_bt ");
		str.append("left outer join bd_measdoc MEASDOC on APPBT.id_medu_unit = MEASDOC.Id_measdoc ");
		str.append("left outer join bd_udidoc PPSBT on APPBT.Id_pps_bt = PPSBT.Id_udidoc ");
		str.append("left outer join bd_psndoc PSNDOC on APPBT.Id_emp_bt = PSNDOC.Id_psndoc ");
		str.append("left outer join bd_udidoc BLOODTP on APPBT.Id_app_bloodtype = BLOODTP.Id_udidoc ");
		str.append("left outer join bd_udidoc RHD on APPBT.Id_app_rhd = RHD.Id_udidoc ");
		
		str.append("where ORD.sd_su_bl!=2 and APPBT.Id_or in (" + ids + ")  order by APPBT.Sv");
				return str.toString();
	}

	/**
	 * 执行查询主
	 */
	@Override
	public List<CiAppBtSheetDTO> getOrderList(String sqlQry) throws Exception {
		return CiorderPrintUtils.GetQueryResulte(CiAppBtSheetDTO.class, sqlQry);
	}

	/**
	 * 拼接查询子SQL
	 */
	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select APPBTITM.Id_ciappbtsheet,");
		str.append("APPBTITM.Name_srv,");
		str.append("APPBTITM.Val_rstrptla,");
		str.append("APPBTITM.Name_unit ");

		str.append("from ci_app_bt_item APPBTITM ");
		
		str.append("where APPBTITM.Id_ciappbtsheet in (" + ids + ") order by APPBTITM.Sortno");
		
		return str.toString();
	}
	
	/**
	 * 执行查询子
	 */
	@Override
	public List<CiAppBtItemSheetDTO> getItemList(String sqlQry) throws Exception {
		return CiorderPrintUtils.GetQueryResulte(CiAppBtItemSheetDTO.class, sqlQry);
	}

	/**
	 * 
	 */
	@Override
	public void setOrdInfo(List<CiAppBtSheetDTO> dtos) throws Exception {

	}
}
