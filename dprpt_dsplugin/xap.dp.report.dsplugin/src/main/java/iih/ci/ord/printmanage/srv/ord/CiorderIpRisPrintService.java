package iih.ci.ord.printmanage.srv.ord;

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
 * 住院检查合单打印数据查询服务
 * @author Young
 *
 */
public class CiorderIpRisPrintService extends CiorderBaseOrdPrintService {

	@Override
	public List<HeadDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		// 获取检查申请单打印数据ID集合
		String strIdciapprissheets = this.getIDciapprissheets(ids);
		if(StringUtils.isNullOrEmpty(strIdciapprissheets))
			return this.getHeadDTOs_Old(ids);

		return this.getHeadDTOs_New(strIdciapprissheets);
	}
	
	private List<HeadDTO> getHeadDTOs_New(String strIdciapprissheets)
			throws Exception {
		List<HeadDTO> ordlist = this.getOrderList(this
				.getOrdInfoSqlQry(strIdciapprissheets, true));

		List<ItemDTO> itemDTOs = this.getItemList(this
				.getItmInfoSqlQry(strIdciapprissheets));

		if (ordlist == null || ordlist.size() == 0)
			return null;
		this.setRisBodyName_New(itemDTOs);
		Map<String, List<ItemDTO>> maps = new HashMap<String, List<ItemDTO>>();
		for (ItemDTO dto : itemDTOs) {
			if (maps.containsKey(dto.getId_ciapprissheet())) {
				maps.get(dto.getId_ciapprissheet()).add(dto);
			} else {
				List<ItemDTO> lst = new ArrayList<ItemDTO>();
				lst.add(dto);
				maps.put(dto.getId_ciapprissheet(), lst);
			}
		}

		for (int i = 0; i < ordlist.size(); i++) {
			List<ItemDTO> items = maps.get(ordlist.get(i).getId_ciapprissheet());
			String strName = "";
			FDouble amount = new FDouble();
			String fg_urgent = "N";
			for (int j = 0; j < items.size(); j++) {
				strName += "，" + items.get(j).getName_srv();
				amount = amount.add(items.get(j).getAmount());
				if ("N".equals(fg_urgent)
						&& "Y".equals(items.get(j).getFg_urgent())) {
					fg_urgent = "Y";
				}
			}
			ordlist.get(i).setName_srv(strName.substring(1));
			ordlist.get(i).setAmt_total(amount);
			
			ordlist.get(i).setStr_name_di(items.get(0).getStr_name_di());
			ordlist.get(i).setDt_plan(items.get(0).getDt_plan());
			ordlist.get(i).setDes_sympsign(items.get(0).getDes_sympsign());
			ordlist.get(i).setAnnouncements(items.get(0).getAnnouncements());
			ordlist.get(i).setName_pps(items.get(0).getName_pps());
			ordlist.get(i).setDes_pps(items.get(0).getDes_pps());
			ordlist.get(i).setClinicalzztz(items.get(0).getClinicalzztz());
			ordlist.get(i).setPastillness(items.get(0).getPastillness());
			ordlist.get(i).setAuximtexam(items.get(0).getAuximtexam());
			ordlist.get(i).setBiopsy(items.get(0).getBiopsy());
			
			ordlist.get(i).setName_srvca(items.get(0).getName_srvca());
			ordlist.get(i).setName_emp_or(items.get(0).getName_emp_or());
			ordlist.get(i).setName_dep_or(items.get(0).getName_dep_or());
			ordlist.get(i).setName_mp_dep(items.get(0).getName_dep_mp());
			ordlist.get(i).setDt_entry(items.get(0).getDt_entry());
			
			ordlist.get(i).setFg_urgent(fg_urgent);
			ordlist.get(i).setFg_prepay(items.get(0).getFg_prepay());
			ordlist.get(i).setFg_orhp(items.get(0).getFg_orhp());
		}

		this.setOrdInfo(ordlist);

		return ordlist;
	}

	private List<HeadDTO> getHeadDTOs_Old(String ids) 
			throws Exception {
		List<HeadDTO> ordlist = this.getOrderList(this.getOrdInfoSqlQry(ids, false));

		if (ordlist == null || ordlist.size() == 0)
			return null;
		this.setOrdInfo(ordlist);
		this.setRisBodyName_Old(ordlist);
        
		for (HeadDTO headDTO : ordlist) {
			headDTO.setDataMatrix(this.getQRCodeById_or(ids));
		}
		return ordlist;
	}
	
	private String getOrdInfoSqlQry(String ids, boolean bNew) {
		StringBuilder str = new StringBuilder();
		if(bNew){
			str.append("select APPRIS.Id_ciapprissheet,");//检查申请打印ID
			
			str.append("PAT.Name as Name_pati,");//患者姓名
			str.append("PAT.Dt_birth,");//患者生日
			str.append("PAT_SEX.Name as Gender,");//患者性别
			str.append("0 as Age,");//患者年龄
			str.append("PAT.Id_code as Idno,");//患者证件号
			str.append("PAT.Workunit,");//患者工作单位
			str.append("PAT.Code_amr_oep,");//患者病案号
			str.append("PAT.Mob as Pat_tel,");//患者电话
			str.append("PAT.Barcode_chis as Barcode,");//患者条形码
			str.append("APPRIS.Code_entp,");//患者就诊Code
			str.append("ENT.Times_op as Num_pv,");//患者就诊次数
			
			str.append("APPRIS.No_applyform,");//检查申请号
			str.append("APPRIS.Code_app as Code,");//检查申请编码
			str.append("GRP.Name as Name_grp,");//检查组织
			str.append("ORG.Name as Name_org,");//检查机构

			str.append("APPRIS.Fg_opspecial as Fg_special,");//特殊门诊标识
			str.append("APPRIS.Fg_hecominsur,");//高端商报标识
			str.append("APPRIS.Hecominsurinfo,");//高端商报信息
			str.append("APPRIS.Researchinfo as Name_research,");//科研信息
			str.append("APPRIS.Fg_hpbirth,");//生育医保标识
			str.append("APPRIS.Fg_vip,");//VIP标识
			str.append("APPRIS.Fg_blsettled, ");//费用结算标识
			str.append("bd3.Name as Unit,");//病区
			str.append("bd4.Name as Bed_num ");//病床号
			
			str.append("from ci_app_ris APPRIS ");
			str.append("left outer join pi_pat PAT on APPRIS.Id_pat = PAT.Id_pat ");
			str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
			str.append("left outer join bd_grp GRP on GRP.Id_grp = APPRIS.Id_grp ");
			str.append("left outer join bd_org ORG on ORG.Id_org = APPRIS.Id_org ");
			str.append("left outer join en_ent_op ENT on APPRIS.Id_en = ENT.Id_ent ");
			
			 str.append("left outer join ci_app_ris_or r on APPRIS.id_ciapprissheet = r.id_ciapprissheet "); 
		     str.append("  left outer join  ci_order c  on r.ID_OR = c.ID_OR ");
			 str.append("left outer join en_ent_ip enip on c.Id_en = enip.Id_ent ");
			 str.append("left outer join bd_dep bd3    on bd3.id_dep = enip.id_dep_nuradm  ");
			 str.append("left outer join bd_bed bd4    on bd4.id_bed = enip.id_bed ");
			
			str.append(" where APPRIS.Id_ciapprissheet in (" + ids + ") order by APPRIS.Sv");
		}else{
			str.append("select APPRIS.Id_or,");
			str.append("APPRIS.Id_pat as Id_pati,");
			str.append("PAT.Name as Name_pati,");
			str.append("PAT.Dt_birth,");
 			str.append("PAT_SEX.Name as Gender,");
			str.append("0 as Age,");
			str.append("PAT.Id_code as Idno,");
			str.append("PAT.Workunit,");
			str.append("PAT.Code_amr_oep,");
			str.append("PAT.Mob as Pat_tel,");
			str.append("APPRIS.Id_en,");
			str.append("APPRIS.Id_entp,");
			str.append("APPRIS.Code_entp,");
			str.append("PAT.Barcode_chis as Barcode,");
			str.append("ENT.Times_op as Num_pv,");
			str.append("APPRIS.Name_diag as Str_name_di,");
			str.append("APPRIS.No_applyform,");
			str.append("APPRIS.Code_app as Code,");
			str.append("GRP.Name as Name_grp,");
			str.append("ORG.Name as Name_org,");
			str.append("APPRIS.Dt_plan,");
			str.append("APPRIS.Des_sympsign,");
			str.append("APPRIS.Fg_urgent,");
			str.append("APPRIS.Announcements,");
			str.append("PPS.Name as Name_pps,");
			str.append("APPRIS.Des_pps,");
			str.append("APPRIS.Clinicalzztz,");
			str.append("APPRIS.Pastillness,");
			str.append("APPRIS.Auximtexam,");
			str.append("APPRIS.Biopsy,");
			str.append("APPRIS.Fg_set,");
			str.append("(case SRV.Ismuldose when 'Y' then APPRIS.Name_app||'X'||ORSRV.Quan_total_medu||MEASDOC.Name else APPRIS.Name_app end) as Name_srv,");
			
			str.append("SRVCA.Name as Name_srvca,");
			str.append("APPRIS.Id_dep_app as Id_dep_or,");
			str.append("DEP_APP.Name as Name_dep_or,");
			str.append("APPRIS.Id_emp_app as Id_emp_or,");
			str.append("PSNDOC.Name as Name_emp_or,");
			str.append("APPRIS.Dt_app as Dt_entry,");
			str.append("APPRIS.Id_dep_mp as Id_mp_dep,");
			str.append("DEP_EMP.Name as Name_mp_dep,");

			str.append("APPRIS.Amt_app as Amt_total,");

			str.append("APPRIS.Fg_opspecial as Fg_special,");
			str.append("APPRIS.Fg_hecominsur,");
			str.append("APPRIS.Hecominsurinfo,");
			str.append("APPRIS.Researchinfo as Name_research,");
			str.append("APPRIS.Fg_hpbirth,");
			str.append("APPRIS.Fg_prepay,");
			str.append("APPRIS.Fg_hp as Fg_orhp,");
			str.append("APPRIS.Fg_vip,");
			str.append("APPRIS.Fg_blsettled, ");
			
			str.append("bd3.Name as Unit,");//病区
			str.append("bd4.Name as Bed_num ");//病床号

			str.append("from ci_app_ris APPRIS ");
			str.append("left outer join ci_order ORD on APPRIS.Id_or = ORD.Id_or ");
			str.append("left outer join ci_or_srv ORSRV on ORSRV.Id_or = APPRIS.Id_or and ORSRV.Id_srv = ORD.Id_srv ");
			str.append("left outer join pi_pat PAT on APPRIS.Id_pat = PAT.Id_pat ");
			str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
			str.append("left outer join bd_grp GRP on GRP.Id_grp = APPRIS.Id_grp ");
			str.append("left outer join bd_org ORG on ORG.Id_org = APPRIS.Id_org ");
			str.append("left outer join en_ent_op ENT on APPRIS.Id_en = ENT.Id_ent ");
			str.append("left outer join bd_udidoc PPS on APPRIS.Id_pps = PPS.Id_udidoc ");
			str.append("left outer join bd_dep DEP_APP on APPRIS.Id_dep_app = DEP_APP.Id_dep ");
			str.append("left outer join bd_psndoc PSNDOC on APPRIS.Id_emp_app = PSNDOC.Id_psndoc ");
			str.append("left outer join bd_dep DEP_EMP on DEP_EMP.Id_dep = APPRIS.Id_dep_mp ");
			str.append("left outer join bd_srv SRV ON SRV.Id_srv = APPRIS.Id_srv ");
			str.append("left outer join bd_srvca SRVCA ON SRVCA.Id_srvca = SRV.Id_srvca ");
			str.append("left outer join bd_measdoc MEASDOC on ORD.Id_unit_med = MEASDOC.Id_Measdoc ");
			
			str.append("left outer join ci_app_ris_or r  on APPRIS.id_ciapprissheet = r.id_ciapprissheet ");
			str.append("left outer join en_ent_ip enip on ORD.Id_en = enip.Id_ent ");
			str.append("left outer join bd_dep bd3    on bd3.id_dep = enip.id_dep_nuradm  ");
			str.append("left outer join bd_bed bd4    on bd4.id_bed = enip.id_bed  ");

			str.append(" where ORD.sd_su_bl!=2 and APPRIS.Id_or in (" + ids + ") order by APPRIS.Sv");
		}

		return str.toString();
	}
	
	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select distinct APP_RIS_OR.Id_ciapprissheet,");//检查申请打印ID
		str.append("APP_RIS_OR.Id_or,");//医嘱ID,用于查询检查部位信息
		str.append("APP_RIS_OR.Sortno,");//合单中检查序号
		
		//拼接     X总次数
		str.append("(case SRV.Ismuldose when 'Y' then APP_RIS_OR.Name_or||'X'||ORSRV.Quan_total_medu||MEASDOC.Name else APP_RIS_OR.Name_or end) as Name_srv,");
		str.append("APP_RIS_OR.Str_name_di as Str_name_di,");//诊断拼接
		str.append("APP_RIS_OR.Dt_plan,");//计划检查时间
		str.append("APP_RIS_OR.Des_sympsign,");//病情描述
		str.append("APP_RIS_OR.Announcements,");//注意事项
		str.append("PPS.Name as Name_pps,");//检查目的
		str.append("APP_RIS_OR.Des_pps,");//检查目的描述
		str.append("APP_RIS_OR.Clinicalzztz,");//临床症状及体征
		str.append("APP_RIS_OR.Pastillness,");//既往病史
		str.append("APP_RIS_OR.Auximtexam,");//其它检查所见
		str.append("APP_RIS_OR.Biopsy,");//检查组织描述
		
		str.append("SRVCA.Name as Name_srvca,");//检查服务分类名称
		str.append("PSNDOC.Name as Name_emp_or,");//开立医生
		str.append("DEPAPP.Name as Name_dep_or,");//开立科室
		str.append("DEPMP.Name as Name_dep_mp,");//执行科室
		str.append("APP_RIS_OR.Dt_app as Dt_entry,");//申请时间
		str.append("APP_RIS_OR.Or_total_pri as Amount,");//检查金额
		
		str.append("APP_RIS_OR.Fg_urgent,");//加急标识
		str.append("APP_RIS_OR.Fg_set,");//服务套标识
		str.append("APP_RIS_OR.Fg_prepay,");//预付费标识
        str.append("APP_RIS_OR.Fg_orhp,");//医保标识
		
        //扩展字段
		str.append("APP_RIS_OR.def1,APP_RIS_OR.def2,APP_RIS_OR.def3,APP_RIS_OR.def4,APP_RIS_OR.def5,");
		str.append("APP_RIS_OR.def6,APP_RIS_OR.def7,APP_RIS_OR.def8,APP_RIS_OR.def9,APP_RIS_OR.def10,");
		str.append("APP_RIS_OR.def11,APP_RIS_OR.def12,APP_RIS_OR.def13,APP_RIS_OR.def14,APP_RIS_OR.def15,");
		str.append("APP_RIS_OR.def16,APP_RIS_OR.def17,APP_RIS_OR.def18,APP_RIS_OR.def19,APP_RIS_OR.def20,");
		str.append("APP_RIS_OR.def21,APP_RIS_OR.def22,APP_RIS_OR.def23,APP_RIS_OR.def24,APP_RIS_OR.def25,");
		str.append("APP_RIS_OR.def26,APP_RIS_OR.def27,APP_RIS_OR.def28,APP_RIS_OR.def29,APP_RIS_OR.def30,");
		str.append("APP_RIS_OR.def31,APP_RIS_OR.def32,APP_RIS_OR.def33,APP_RIS_OR.def34,APP_RIS_OR.def35,");
		str.append("APP_RIS_OR.def36,APP_RIS_OR.def37,APP_RIS_OR.def38,APP_RIS_OR.def39,APP_RIS_OR.def40,");
		str.append("APP_RIS_OR.def41,APP_RIS_OR.def42,APP_RIS_OR.def43,APP_RIS_OR.def44,APP_RIS_OR.def45,");
		str.append("APP_RIS_OR.def46,APP_RIS_OR.def47,APP_RIS_OR.def48,APP_RIS_OR.def49,APP_RIS_OR.def50 ");
		
		str.append("from ci_app_ris_or APP_RIS_OR ");
		str.append("left outer join ci_order ORD on APP_RIS_OR.Id_or = ORD.Id_or ");
		str.append("left outer join ci_or_srv ORSRV on ORSRV.Id_srv = ORD.Id_srv and ORSRV.Id_or = ORD.Id_or ");
		str.append("left outer join bd_measdoc MEASDOC on ORD.Id_unit_med = MEASDOC.Id_Measdoc ");
		str.append("left outer join bd_srv SRV ON SRV.Id_srv = ORD.Id_srv ");
		str.append("left outer join bd_srvca SRVCA ON SRVCA.Id_srvca = SRV.Id_srvca ");
		
		str.append("left outer join bd_udidoc PPS on APP_RIS_OR.Id_pps = PPS.Id_udidoc ");
		str.append("left outer join bd_psndoc PSNDOC on APP_RIS_OR.Id_emp_app = PSNDOC.Id_psndoc ");
		str.append("left outer join bd_dep DEPAPP on APP_RIS_OR.Id_dep_app = DEPAPP.Id_dep ");
		str.append("left outer join bd_dep DEPMP on DEPMP.Id_dep = APP_RIS_OR.Id_dep_mp ");
		
		String wherestr = "where ORD.sd_su_bl!=2 and (ORD.eu_feereversetp is null or ORD.eu_feereversetp<>1) ";
		if (!StringUtils.isNullOrEmpty(ids)) {
			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " APP_RIS_OR.Id_ciapprissheet in (" + ids + ")";
		}
		str.append(wherestr);

		return "select * from ("+str.toString()+") order by Sortno";
	}

	private void setRisBodyName_New(List<ItemDTO> itemDTOs) throws Exception {
		ArrayList<String> lstIdsset = new ArrayList<String>();
		ArrayList<String> lstIds = new ArrayList<String>();
		for (ItemDTO dto : itemDTOs) {
			if ("Y".equals(dto.getFg_set()))
				lstIdsset.add(dto.getId_or());
			else
				lstIds.add(dto.getId_or());
		}

		List<UtilsDTO> lstRisBodyNamesSet = getRisBodyNames(lstIdsset.toArray(new String[lstIdsset.size()]), true);
		List<UtilsDTO> lstRisBodyNames = getRisBodyNames(lstIds.toArray(new String[lstIdsset.size()]), false);

		for (ItemDTO dto : itemDTOs) {
			boolean hasbody = false;
			if ("Y".equals(dto.getFg_set())) {
				if (lstRisBodyNamesSet != null && lstRisBodyNamesSet.size() > 0) {
					for (UtilsDTO udto : lstRisBodyNamesSet) {
						if (dto.getId_or().equals(udto.getDef1())) {
							if (udto.getDef2() != null) {
								dto.setName_srv(dto.getName_srv() + "[" + udto.getDef2().toString() + "]");
								hasbody = true;
							}
						}
					}
				}
			} else {
				if (lstRisBodyNames != null && lstRisBodyNames.size() > 0) {
					for (UtilsDTO udto : lstRisBodyNames) {
						if (dto.getId_or().equals(udto.getDef1())) {
							if (udto.getDef2() != null) {
								dto.setName_srv(dto.getName_srv() + "[" + udto.getDef2().toString() + "]");
								hasbody = true;
							}
						}
					}
				}
			}
			if (!hasbody)
				dto.setName_srv(dto.getName_srv() + "[]");
		}
	}

	private void setRisBodyName_Old(List<HeadDTO> ordlist) throws Exception {
		ArrayList<String> lstIdsset = new ArrayList<String>();
		ArrayList<String> lstIds = new ArrayList<String>();
		for (HeadDTO dto : ordlist) {
			if (dto.getFg_set().equals("Y"))
				lstIdsset.add(dto.getId_or());
			else
				lstIds.add(dto.getId_or());
		}

		List<UtilsDTO> lstRisBodyNamesSet = getRisBodyNames(lstIdsset.toArray(new String[lstIdsset.size()]), true);
		List<UtilsDTO> lstRisBodyNames = getRisBodyNames(lstIds.toArray(new String[lstIdsset.size()]), false);

		for (HeadDTO headdto : ordlist) {
			boolean hasbody = false;
			if (headdto.getFg_set().equals("Y")) {
				if (lstRisBodyNamesSet != null && lstRisBodyNamesSet.size() > 0) {
					for (UtilsDTO udto : lstRisBodyNamesSet) {
						if (headdto.getId_or().equals(udto.getDef1())) {
							if (udto.getDef2() != null) {
								headdto.setName_srv(headdto.getName_srv() + "[" + udto.getDef2().toString() + "]");
								hasbody = true;
							}
						}
					}
				}
			} else {
				if (lstRisBodyNames != null && lstRisBodyNames.size() > 0) {
					for (UtilsDTO udto : lstRisBodyNames) {
						if (headdto.getId_or().equals(udto.getDef1())) {
							if (udto.getDef2() != null) {
								headdto.setName_srv(headdto.getName_srv() + "[" + udto.getDef2().toString() + "]");
								hasbody = true;
							}
						}
					}
				}
			}
			if (!hasbody)
				headdto.setName_srv(headdto.getName_srv() + "[]");
		}
	}
	
	/**
	 * 查询检查部位信息
	 * @param ids
	 * @param isSet
	 * @return
	 * @throws Exception
	 */
	private List<UtilsDTO> getRisBodyNames(String[] ids, boolean isSet) throws Exception {
		String str = "";
		if (ids.length > 0) {
			for (String id : ids) {
				str += "'" + id + "',";
			}
			return CiorderPrintUtils.QryRisBodyName(str, isSet);
		}

		return null;
	}
	
	/**
	 * 
	 * @param strIdors
	 * @return
	 * @throws Exception
	 */
	private String getIDciapprissheets(String strIdors) throws Exception{
		String sql = "select distinct RISOR.id_ciapprissheet as def1 "
				+ "from ci_app_ris_or RISOR "
				+ "left outer join ci_order ORD on RISOR.Id_or = ORD.Id_or "
				+ "where ORD.sd_su_bl!=2 and (ORD.eu_feereversetp is null or ORD.eu_feereversetp<>1) and RISOR.id_or in (" + strIdors + ")";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, sql);
		String strIdciapprissheets = "";
		if (result != null && result.size() > 0) {
			for (UtilsDTO dto : result) {
				strIdciapprissheets += "'" + dto.getDef1() + "',";
			}
		}

		return strIdciapprissheets.length() > 0 ? strIdciapprissheets.substring(0, strIdciapprissheets.length() - 1)
				: strIdciapprissheets;
	}
}
