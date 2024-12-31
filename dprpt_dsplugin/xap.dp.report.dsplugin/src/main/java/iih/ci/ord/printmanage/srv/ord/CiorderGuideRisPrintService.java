package iih.ci.ord.printmanage.srv.ord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.HeadDTO;
import iih.ci.ord.printmanage.dto.ItemDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.coreitf.d.FDouble;

/** 
 * 南大检查导引单
 * @code 
 * @author LiYue
 * @date 2019年4月25日,下午7:43:30
 */
public class CiorderGuideRisPrintService  extends CiorderBaseOrdPrintService {

		@Override
		public List<HeadDTO> exec(String ids) throws Exception {
			if (StringUtils.isNullOrEmpty(ids))return null;
			//获取检查申请单打印数据ID集合
			String strIdciapprissheets=getIDciapprissheets(ids);
			if(StringUtils.isNullOrEmpty(strIdciapprissheets))return null;
			//患者就诊信息查询
			List<HeadDTO> headDTOs = this.getOrderList(this.getOrdInfoSqlQry(strIdciapprissheets, true));
			//明细
			List<ItemDTO> itemDTOs = this.getItemList(this.getItmInfoSqlQry(strIdciapprissheets));
			
			//新数据组合
			List<HeadDTO> headDTOlist = new ArrayList<>();
			List<ItemDTO> itemDTOlist = new ArrayList<>() ;

			Map<String,List<ItemDTO>> maps=new HashMap<String,List<ItemDTO>>();
			for(ItemDTO dto:itemDTOs){
				if(maps.containsKey(dto.getId_ciapprissheet())){
					maps.get(dto.getId_ciapprissheet()).add(dto);
				}
				else{
					List<ItemDTO> lst=new ArrayList<ItemDTO>();
					lst.add(dto);
					maps.put(dto.getId_ciapprissheet(), lst);
				}
			}
			/**
			 * 总金额
			 */
			FDouble pri = FDouble.ZERO_DBL;
			for (List<ItemDTO> DTOlist : maps.values()) {
				ItemDTO dto = new ItemDTO();
				int number = 0;
				
				for (ItemDTO itemDTO : DTOlist) {
					number++;
					if(StringUtils.isNullOrEmpty(dto.getName_srv())){
						dto.setName_srv(number+"、"+itemDTO.getName_srv());//名称拼接
						pri = pri.add(itemDTO.getAmount());//金额叠加
						dto.setName_dep_mp(itemDTO.getName_dep_mp());//执行科室
						dto.setId_ciapprissheet(itemDTO.getId_ciapprissheet());
					}else
					{
						dto.setName_srv(dto.getName_srv()+number+"、"+itemDTO.getName_srv());
						pri = pri.add(itemDTO.getAmount());//金额叠加
					}
				}
				itemDTOlist.add(dto);
			}
			
			if(headDTOs == null || headDTOs.size() == 0)return null;
			
			headDTOlist.add(headDTOs.get(0));
			headDTOlist.get(0).setAmt_total(pri);
			this.setOrdInfo(headDTOlist);
			for(int i = 0; i < headDTOlist.size(); i++){
				headDTOs.get(i).setItemdtolist(maps.get(headDTOs.get(i).getId_ciapprissheet()));
				headDTOs.get(i).setItemdtolist(itemDTOlist);
				if (headDTOs.get(i).getSd_sampcollecttimetp() == "0101") {
					headDTOs.get(i).setName_sampcoltime("");
				} else {
					String name = headDTOs.get(i).getName_sampcoltime();
					if (name != null && !("").equals(name)) {
						headDTOs.get(i).setName_sampcoltime("建议执行时间：" + name);
					}
				}
				if("Y".equals(headDTOs.get(i).getFg_specill())){
					headDTOs.get(i).setFg_orhp("N");
				}
				headDTOs.get(i).setDataMatrix(this.getQRCodeById_or(ids));
			}
			
			
			
			return headDTOlist;
	}
	
	private String getOrdInfoSqlQry(String ids, boolean bNew) {
		StringBuilder str = new StringBuilder();
		if(bNew){
			str.append("select APPRIS.Id_ciapprissheet,");//检查申请打印ID
			str.append("APPRIS.Code_entp,");
			str.append("NVL(NOTICE_PLACENOTICE.name,NOTICE_PLACENOTICESUP.name) AS PlaceNOTICE, ");//注意事项：地点
			str.append("NVL(NOTICE_PATNOTICE.name,NOTICE_PATNOTICESUP.name)     AS PatNOTICE, ");//注意事项：患者
			str.append("NVL(NOTICE_PHONENOTICE.name,NOTICE_PHONENOTICESUP.name) AS PhoneNOTICE,");//注意事项：电话
			str.append("PAT.Name as Name_pati,");//患者姓名
			str.append("PAT.id_pat as Id_pat,");//患者ID
			str.append("PAT.code as code_pat,");//患者code
			str.append("PAT.Dt_birth,");//患者生日
			str.append("PAT_SEX.Name as Gender,");//患者性别
			str.append("0 as Age,");//患者年龄
			str.append("PAT.Id_code as Idno,");//患者证件号
			str.append("PAT.Workunit,");//患者工作单位
			str.append("PAT.Code_amr_oep,");//患者病案号
			str.append("PAT.Mob as Pat_tel,");//患者电话
			//str.append("PAT.Barcode_chis as Barcode,");//患者条形码
			str.append("(case APPRIS.CODE_ENTP when '10' then ENTIP.code_amr_ip else PAT.code end) as Barcode,");//患者就诊Code
			str.append("ENTHP.No_hp as HpCode,");//医保卡号
			str.append("picard.code as PiCardCode,");//患者卡号
			str.append("patal.Des_alcla,");//患者过敏史
			str.append("dep.name as name_dep_or,");//患者科室
			//0122268: 住院检查检查申请单项目合并显示问题及就诊次数显示问题   由于门诊住院使用的同一个报表，所以未查询到就诊次数  在此对sql修改
			//解决方案：同时连接两个表  根据ci_app_ris的CODE_ENTP 就诊类型code判断是门诊还是住院 然后查询对应表字段
			//str.append("ENT.Times_op as Num_pv,");//患者就诊次数
			str.append("(case APPRIS.CODE_ENTP when '10' then ENTIP.Times_ip else ENTOP.Times_op end) as Num_pv,");//患者就诊次数
			str.append("cior.id_en, ");
			
			str.append("APPRIS.Code_app as Code,");//检查申请编码
			str.append("GRP.Name as Name_grp,");//检查组织
			str.append("ORG.Name as Name_org,");//检查机构
			str.append("ORG.ENName as Name_org_en,");//检查机构英文名称
			str.append("ORG.Shortname as Name_org_short,");//机构简称

			str.append("SRVCA.Name as Name_srvca,");//服务分类
			str.append("srvtp.name as Name_srvtp,");//服务类型
			str.append("APPRIS.Fg_opspecial as Fg_special,");//特殊门诊标识
			str.append("APPRIS.Fg_hecominsur,");//高端商报标识
			str.append("APPRIS.Hecominsurinfo,");//高端商报信息
			str.append("APPRIS.Researchinfo as Name_research,");//科研信息
			str.append("APPRIS.Fg_hpbirth,");//生育医保标识
			str.append("APPRIS.Fg_vip,");//VIP标识
			str.append("APPRIS.Fg_blsettled,");//费用结算标识
			str.append("APPRIS.Fg_specill,");//特殊病标识
			
			//郑州骨伤需求，检查增加显示住院号
			str.append("PAT.Code_amr_ip as Code_amr_ip, ");
			//0128618: 住院医嘱--检查打印出来申请单没有床位号，需要添加上
			str.append("ENTIP.NAME_BED as Bed_num, ");
			//病区
			str.append("dep_nur.name as Unit, ");
			//导引信息
			str.append("dep_mp.id_plc as Guidance ");
			
			str.append("from ci_app_ris APPRIS ");
			str.append("left outer join pi_pat PAT on APPRIS.Id_pat = PAT.Id_pat ");
			str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
			str.append("left outer join bd_grp GRP on GRP.Id_grp = APPRIS.Id_grp ");
			str.append("left outer join bd_org ORG on ORG.Id_org = APPRIS.Id_org ");
			str.append("left outer join bd_org ORG on ORG.Id_org = APPRIS.Id_org ");
			//0122268: 住院检查检查申请单项目合并显示问题及就诊次数显示问题   由于门诊住院使用的同一个报表，所以未查询到就诊次数  在此对sql修改
			//解决方案：同时连接两个表  根据ci_app_ris的CODE_ENTP 就诊类型code判断是门诊还是住院 然后查询对应表字段
			str.append("left outer join en_ent_ip ENTIP on APPRIS.Id_en = ENTIP.Id_ent ");
			str.append("left outer join en_ent_op ENTOP on APPRIS.Id_en = ENTOP.Id_ent ");
			str.append("left outer join en_ent_hp ENTHP on APPRIS.Id_en = ENTHP.Id_ent ");
			str.append("left join en_ent ent on ent.id_ent = ENTIP.Id_ent ");
			str.append("left outer join bd_dep dep_nur  on dep_nur.id_dep = ent.id_dep_nur ");
			str.append("left outer join (select max(id_or) id_or,id_ciapprissheet from ci_app_ris_or group by id_ciapprissheet) risor on risor.id_ciapprissheet=APPRIS.id_ciapprissheet ");
			str.append("left outer join ci_order cior ON cior.Id_or = risor.Id_or ");
			str.append("LEFT JOIN BD_NOTICE NOTICE_PLACENOTICE ON NOTICE_PLACENOTICE.sd_noticetp = '21' and NOTICE_PLACENOTICE.id_srvca = cior.id_srvca  ");
			str.append("LEFT JOIN BD_NOTICE NOTICE_PLACENOTICESUP ON NOTICE_PLACENOTICESUP.sd_noticetp = '21' AND NOTICE_PLACENOTICESUP.id_srvca   = '0001Z810000000001FSP' ");
			str.append("LEFT JOIN BD_NOTICE NOTICE_PATNOTICE ON NOTICE_PATNOTICE.sd_noticetp = '0' and NOTICE_PATNOTICE.id_srvca = cior.id_srvca ");
			str.append("LEFT JOIN BD_NOTICE NOTICE_PATNOTICESUP ON NOTICE_PATNOTICESUP.sd_noticetp = '0' AND NOTICE_PATNOTICESUP.id_srvca = '0001Z810000000001FSP' ");
			str.append("LEFT JOIN BD_NOTICE NOTICE_PHONENOTICE ON NOTICE_PHONENOTICE.sd_noticetp = '22' and NOTICE_PHONENOTICE.id_srvca = cior.id_srvca ");
			str.append("LEFT JOIN BD_NOTICE NOTICE_PHONENOTICESUP ON NOTICE_PHONENOTICESUP.sd_noticetp = '22' AND NOTICE_PHONENOTICESUP.id_srvca     = '0001Z810000000001FSP' ");
			str.append("left outer join bd_dep dep on dep.id_dep = cior.id_dep_or ");
			str.append("left outer join bd_srvca SRVCA ON SRVCA.Id_srvca = cior.Id_srvca ");
			str.append("left outer join bd_udidoc srvtp ON srvtp.Id_udidoc = cior.id_srvtp ");
			str.append("left outer join (select to_char(wm_concat(substr(al.dt_act,0,10)||'对'||mm.name||'过敏')) as Des_alcla,al.id_pat from pi_pat_al al inner join bd_mm mm on mm.id_mm = al.id_mm group by al.id_pat) patal");
			str.append(" on PAT.id_pat = patal.id_pat ");
			str.append("left outer join bd_dep dep_mp on cior.id_dep_mp=dep_mp.id_dep ");//执行科室
			str.append("left join pi_pat_card picard on picard.id_pat = PAT.Id_pat and picard.fg_def='Y' and picard.fg_act='Y' ");//患者的就诊卡
			str.append(" where APPRIS.Id_ciapprissheet in (" + ids + ") "+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "APPRIS")+" order by APPRIS.Sv");
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
			str.append("(case APPRIS.CODE_ENTP when '10' then ENTIP.code_amr_ip else PAT.Barcode_chis end) as Barcode,");
			//0122268: 住院检查检查申请单项目合并显示问题及就诊次数显示问题   由于门诊住院使用的同一个报表，所以未查询到就诊次数  在此对sql修改
			//解决方案：同时连接两个表  根据ci_app_ris的CODE_ENTP 就诊类型code判断是门诊还是住院 然后查询对应表字段
			//str.append("ENT.Times_op as Num_pv,");//患者就诊次数
			str.append("(case APPRIS.CODE_ENTP when '10' then ENTIP.Times_ip else ENTOP.Times_op end) as Num_pv,");//患者就诊次数
			
			str.append("APPRIS.Name_diag as Str_name_di,");
			str.append("APPRIS.No_applyform,");
			str.append("APPRIS.Code_app as Code,");
			str.append("GRP.Name as Name_grp,");
			str.append("ORG.Name as Name_org,");
			str.append("ORG.ENName as Name_org_en,");
			
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
			str.append("APPRIS.Fg_blsettled ");

			str.append("from ci_app_ris APPRIS ");
			str.append("left outer join ci_order ORD on APPRIS.Id_or = ORD.Id_or ");
			str.append("left outer join ci_or_srv ORSRV on ORSRV.Id_or = APPRIS.Id_or and ORSRV.Id_srv = ORD.Id_srv ");
			str.append("left outer join pi_pat PAT on APPRIS.Id_pat = PAT.Id_pat ");
			str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
			str.append("left outer join bd_grp GRP on GRP.Id_grp = APPRIS.Id_grp ");
			str.append("left outer join bd_org ORG on ORG.Id_org = APPRIS.Id_org ");
			//0122268: 住院检查检查申请单项目合并显示问题及就诊次数显示问题   由于门诊住院使用的同一个报表，所以未查询到就诊次数  在此对sql修改  
			//解决方案：同时连接两个表  根据ci_app_ris的CODE_ENTP 就诊类型code判断是门诊还是住院 然后查询对应表字段
			str.append("left outer join en_ent_ip ENTIP on APPRIS.Id_en = ENTIP.Id_ent ");
			str.append("left outer join en_ent_op ENTOP on APPRIS.Id_en = ENTOP.Id_ent ");
			
			str.append("left outer join bd_udidoc PPS on APPRIS.Id_pps = PPS.Id_udidoc ");
			str.append("left outer join bd_dep DEP_APP on APPRIS.Id_dep_app = DEP_APP.Id_dep ");
			str.append("left outer join bd_psndoc PSNDOC on APPRIS.Id_emp_app = PSNDOC.Id_psndoc ");
			str.append("left outer join bd_dep DEP_EMP on DEP_EMP.Id_dep = APPRIS.Id_dep_mp ");
			str.append("left outer join bd_srv SRV ON SRV.Id_srv = APPRIS.Id_srv ");
			str.append("left outer join bd_srvca SRVCA ON SRVCA.Id_srvca = SRV.Id_srvca ");
			str.append("left outer join bd_measdoc MEASDOC on ORD.Id_unit_med = MEASDOC.Id_Measdoc ");

			str.append(" where ORD.sd_su_bl!=2 and APPRIS.Id_or in (" + ids + ") "+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "APPRIS")+" order by APPRIS.Sv");
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
		str.append("(case when SRV.Ismuldose='Y' or SRV.Ismulexec='Y' then APP_RIS_OR.Name_or||'X'||ORSRV.Quan_total_medu||MEASDOC.Name else APP_RIS_OR.Name_or end) as Name_srv,");
		str.append("case   APP_RIS_OR.Str_name_di when null then  didef.name  else APP_RIS_OR.Str_name_di end Str_name_di,");//诊断拼接
		str.append("APP_RIS_OR.No_applyform,");//检查号
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
		str.append("left outer  join bd_di_def  didef  on   APP_RIS_OR.id_di = didef.id_didef ");
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

