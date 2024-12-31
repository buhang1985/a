package iih.ci.ord.ciordsheet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.ciordsheet.bp.GetOrdData4PrnBP;
import iih.ci.ord.ciordsheet.bp.GetPrnedData8IdenBP;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.util.AgeCalcUtil;

/**
 * 医嘱单数据查询服务
 * @author Young
 *
 */
public class CiOrdSheetQryService {

	public final static String Str_reformrow = "-------------重整医嘱-------------";
	public static final String STR_POSSIGNMODE_LINE = "______";
	
	/**
	 * 每种场景查询医嘱单打印数据
	 * @param id_ordsheet  医嘱单样式ID
	 * @param name_ordsheet  医嘱单名称：由医嘱单样式自定义档案维护
	 * @param print_mode  医嘱单打印场景
	 * @param id_ent 患者就诊ID
	 * @param fg_long 医嘱单长临标识：由医嘱单样式自定义档案维护，控制医嘱单打印长期or临时医嘱
	 * @param fg_herb 医嘱单草药标识：由医嘱单样式自定义档案维护，控制医嘱单是否打印草药医嘱
	 * @param page_no 指定已打印的页码
	 * @return
	 * @throws Exception
	 */
	public List<CiOrdSheetDTO> exec(String id_ordsheet, String name_ordsheet, String print_mode, String id_ent,
			String fg_long, String fg_herb, String page_no, String isPrnPresOutp, String isPrnCancChk,
			String isPrnNurseChk, String isPrnRisPart, String exeInfoSrc, String drugLinkMark) throws Exception {
		List<CiOrdSheetDTO> rst = new ArrayList<CiOrdSheetDTO>();
		if(StringUtils.isEmpty(id_ent) || StringUtils.isEmpty(print_mode)) {
			// 医嘱单空数据对象，仅用于显示医嘱单名称
			rst.add(this.getEmptyCiOrdSheetDTO(name_ordsheet));
			return rst;
		}
		
		//构造医嘱单参数对象
		CiOrdSheetParamDTO paramDTO = new CiOrdSheetParamDTO();
		paramDTO.setId_ordsheet(id_ordsheet);
		paramDTO.setName_ordsheet(name_ordsheet);
		paramDTO.setPrint_mode(print_mode);
		paramDTO.setId_en(id_ent);
		paramDTO.setFg_long(new FBoolean("Y".equals(fg_long)));
		paramDTO.setFg_herb(new FBoolean("Y".equals(fg_herb)));
		paramDTO.setIsPrnPresOutp(new FBoolean("True".equals(isPrnPresOutp)));
		paramDTO.setIsPrnCancChk(new FBoolean("Y".equals(isPrnCancChk)));
		paramDTO.setIsPrnNurseChk(new FBoolean("True".equals(isPrnNurseChk)));
		paramDTO.setIsPrnRisPart(new FBoolean("True".equals(isPrnRisPart)));
		paramDTO.setExeInfoSrc(exeInfoSrc);
		if (!StringUtils.isEmpty(page_no)) {
			paramDTO.setPage_no(Integer.parseInt(page_no));
		}
		
		List<CiOrdSheetDTO> qryDTOs = null;
		if ("1".equals(print_mode) || "2".equals(print_mode)) {
			// 一般续打、重整打印
			// 查询未打印的医嘱数据，在前台设置报表打印模式为：续打模式
			GetOrdData4PrnBP bpPrn = new GetOrdData4PrnBP();
			qryDTOs = bpPrn.exec(paramDTO, null);
			
			// 查询当前就诊已打印的医嘱数据
			GetPrnedData8IdenBP bpPrnedData = new GetPrnedData8IdenBP();
			List<CiOrdSheetDTO> qryDTOsPrned = bpPrnedData.exec(paramDTO, null);
			if ("2".equals(print_mode) && qryDTOs != null && !qryDTOs.isEmpty()) {
				// 添加重整标记行数据
				qryDTOs.add(0, this.getReformrowData(qryDTOs.get(0), name_ordsheet));
			}
			if (qryDTOsPrned != null && !qryDTOsPrned.isEmpty()) {
				// 组装已打印+未打印医嘱数据
				qryDTOs.addAll(0, qryDTOsPrned);
			}
		} else if ("3".equals(print_mode) || "4".equals(print_mode) || "5".equals(print_mode) || "6".equals(print_mode)) {
			// 作废打印、停止打印、查询已打印
			// 查询就诊已打印全部数据
			// 作废打印、停止打印，在前台设置报表打印模式为：补打模式，根据报表文件里面配置的脚本，判断是否需要补打相应信息
			// 查询已打印，在前台设置报表打印模式为：常规模式，点选单据可进行整页补打
			GetPrnedData8IdenBP bpPrnedData = new GetPrnedData8IdenBP();
			qryDTOs = bpPrnedData.exec(paramDTO, null);
		}
		// 设置各种服务类型医嘱内容格式
		this.setOrdMainInfo(name_ordsheet, id_ent, qryDTOs, rst, isPrnPresOutp, isPrnCancChk,
				isPrnNurseChk, isPrnRisPart, exeInfoSrc, drugLinkMark);
		
		//计算年龄
		if (rst != null && rst.size() > 0) {
			rst.get(0).setAge(this.setAgeInfo(rst.get(0)));
		}
		return rst;
	}
	
	/**
	 * 设置年龄
	 * @param dto
	 */
	private String setAgeInfo(CiOrdSheetDTO dto){
		if (dto.getAge() != null) {
			FDateTime dt = new FDateTime(dto.getAge());
			//在院的新生儿使用当前时间计算年龄，其他情况使用入院时间计算年龄
			if(FBoolean.TRUE.equals(dto.getFg_ip())&&FBoolean.TRUE.equals(dto.getFg_newborn())){
				return AgeCalcUtil.getAge(dt);
			}else{
				if(dto.getDt_acpt()==null){
					return AgeCalcUtil.getAge(dt);
				}else{
					return AgeCalcUtil.getAge(dt,dto.getDt_acpt());
				}	
			}
		}
		return null;
	}
	
	
	/**
	 * 获取重整标记行数据
	 * @param qryDTO
	 * @param name_ordsheet
	 * @return
	 */
	private CiOrdSheetDTO getReformrowData(CiOrdSheetDTO qryDTO, String name_ordsheet) {
		// 构建重整标记行
		CiOrdSheetDTO sheetDTO = new CiOrdSheetDTO();
		sheetDTO.setFg_reformrow(FBoolean.TRUE);
		sheetDTO.setName_orprn(name_ordsheet);
		sheetDTO.setId_org(qryDTO.getId_org());
		sheetDTO.setCode_or(Str_reformrow);
		sheetDTO.setName_org(qryDTO.getName_org());
		sheetDTO.setId_en(qryDTO.getId_en());
		sheetDTO.setName_pat_en(qryDTO.getName_pat_en());
		sheetDTO.setName_dep_phy(qryDTO.getName_dep_phy());
		sheetDTO.setName_dep_nur(qryDTO.getName_dep_nur());
		sheetDTO.setName_bed(qryDTO.getName_bed());
		sheetDTO.setCode_amr_ip(qryDTO.getCode_amr_ip());
		sheetDTO.setDiag_name(qryDTO.getDiag_name());
		sheetDTO.setId_orsrv_key("reformrow_key");
		sheetDTO.setName_srv(Str_reformrow);
		return sheetDTO;
	}
	
	/**
	 * 设置各种服务类型医嘱内容格式
	 * @param name_ordsheet
	 * @param id_ent
	 * @param qryDTOs
	 * @param rst
	 * @throws Exception
	 */
	private void setOrdMainInfo(String name_ordsheet, String id_ent, List<CiOrdSheetDTO> qryDTOs, List<CiOrdSheetDTO> rst, String isPrnPresOutp, 
			String isPrnCancChk, String isPrnNurseChk, String isPrnRisPart, String exeInfoSrc, String drugLinkMark) throws Exception {
		if (qryDTOs != null && qryDTOs.size() > 0) {
			// 用于判断是否成组
			Map<String, Integer> mapidors = new HashMap<String, Integer>();
			for (CiOrdSheetDTO qryDTO : qryDTOs) {
				if (FBoolean.TRUE.equals(qryDTO.getFg_reformrow()))
					continue;
				qryDTO.setName_orprn(name_ordsheet);
				if (mapidors.containsKey(qryDTO.getId_or())) {
					mapidors.put(qryDTO.getId_or(), mapidors.get(qryDTO.getId_or()).intValue() + 1);
				} else {
					mapidors.put(qryDTO.getId_or(), 1);
				}
			}
			// 设置草药拼接格式
			this.setHerbInfo(qryDTOs, rst, drugLinkMark);
			// 设置西成药拼接格式
			this.setDrugInfo(qryDTOs, mapidors, drugLinkMark);
			//组装非药品医嘱
			this.setNotDrugInfo(qryDTOs, isPrnRisPart);
		} 
		
		// 设置分组字段code_or
		Map<String, Integer> mapcnt = new HashMap<String, Integer>();
		String lastcodeor = "";
		for(CiOrdSheetDTO dto : rst) {
			if ( !dto.getCode_or().equals(lastcodeor)) {
				if(mapcnt.containsKey(dto.getCode_or())) {
					mapcnt.put(dto.getCode_or(), mapcnt.get(dto.getCode_or()) + 1);
				} else {
					mapcnt.put(dto.getCode_or(), 0);
				}
				lastcodeor = dto.getCode_or();
			}
			
			if(mapcnt.containsKey(dto.getCode_or()) && mapcnt.get(dto.getCode_or()).intValue() > 0) {
				dto.setCode_or(String.format("%s_%d", dto.getCode_or(), mapcnt.get(dto.getCode_or())));
			}
		}
	}
	
	/**
	 * 设置非药品医嘱拼接格式
	 * @param qryDTOs
	 * @throws Exception
	 */
	protected void setNotDrugInfo(List<CiOrdSheetDTO> qryDTOs, String isPrnRisPart) throws Exception{
		String strIdors_ris_set = "";//检查(套)医嘱ID
		String strIdors_ris = "";//检查(非套)医嘱ID
		for (int i = 0; i < qryDTOs.size(); i++) {
			if (FBoolean.TRUE.equals(qryDTOs.get(i).getFg_reformrow()))
				continue;
			if(qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_DRUG)){
				continue;
			}
			if (qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_RIS)) {
				if ("Y".equals(qryDTOs.get(i).getFg_set())) {
					strIdors_ris_set += ",'" + qryDTOs.get(i).getId_or() + "'";
				} else {
					strIdors_ris += ",'" + qryDTOs.get(i).getId_or() + "'";
				}
			//0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果 判断皮试结果code 阴性显示-阳性显示+
			}else if(qryDTOs.get(i).getSd_srvtp().equals(ICiorderPrintConst.SD_SRVTP_TREAT_SKINMINGANTEST)){
				if(!StringUtils.isEmpty(qryDTOs.get(i).getRst_skintest())){
					if(qryDTOs.get(i).getRst_skintest().equals("0")){
						qryDTOs.get(i).setContent_or_prn_sub("(-)");
					}else{
						qryDTOs.get(i).setContent_or_prn_sub("(+)");
					}					
				}
			}else if(qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_OP)){
				//手术拼接格式：拟于+【计划手术日期】+在【麻醉方式】下行+【手术项目】
				String[] content_or = qryDTOs.get(i).getContent_or().split("\\|");
				String nameSrv = content_or[2];
				if (content_or.length > 3 && !"null".equals(StringUtils.trimToEmpty(content_or[3]))) {
					nameSrv += " " + StringUtils.trimToEmpty(content_or[3]);
				}
				
				//0122281: 临时医嘱单---手术医嘱显示结尾多显示个0  
				//Reason ：医嘱单不展示手术价格 此处截取掉
				//qryDTOs.get(i).setName_srv(nameSrv.replace("&", ""));
				int index = nameSrv.lastIndexOf("&");
				if(index!=-1){
					qryDTOs.get(i).setName_srv(nameSrv.substring(0,index));
				}
			}else if(qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_BLOODPROD_PREPARE)){
				qryDTOs.get(i).setName_srv("配"+qryDTOs.get(i).getName_srv() + qryDTOs.get(i).getQuan_medu() + qryDTOs.get(i).getMedu_name());
			}else if(qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_BLOODPROD_USE)){
				qryDTOs.get(i).setName_srv("输"+qryDTOs.get(i).getName_srv() + qryDTOs.get(i).getQuan_medu() + qryDTOs.get(i).getMedu_name());
			}else if(qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)){
				//0132923: 住院医生-医嘱打印-会诊医嘱打印错误,显示医嘱内容
				if(qryDTOs.get(i).getName_srv().contains("会诊")){
					qryDTOs.get(i).setName_srv(qryDTOs.get(i).getContent_or().split("\\|")[2].split("&")[0]);
				}
			}
			if(StringUtils.isNotEmpty(qryDTOs.get(i).getFreq_name())&&!qryDTOs.get(i).getFreq_name().equals("持续")&&!qryDTOs.get(i).getFreq_name().equals("一次")){
				qryDTOs.get(i).setContent_or_prn_sub((StringUtils.isNotEmpty(qryDTOs.get(i).getContent_or_prn_sub())?(qryDTOs.get(i).getContent_or_prn_sub()+" "):"")+qryDTOs.get(i).getFreq_name());
			}

		}
		// 检查拼接部位
		Map<String, String> mapBodyNames = new HashMap<String, String>();
		if (strIdors_ris_set.length() > 0) {
			List<Map<String, Object>> lstBodyNames = getRisBodyName(strIdors_ris_set.substring(1), true);
			if (lstBodyNames != null && lstBodyNames.size() > 0) {
				for (Map<String, Object> map : lstBodyNames) {
					if (map.get("def2") != null) {
						mapBodyNames.put(map.get("def1").toString(), map.get("def2").toString());
					}
				}
			}
		}
		if(strIdors_ris.length()>0){
			List<Map<String, Object>> lstBodyNames = getRisBodyName(strIdors_ris.substring(1), false);
			if (lstBodyNames != null && lstBodyNames.size() > 0) {
				for (Map<String, Object> map : lstBodyNames) {
					if (map.get("def2") != null) {
						mapBodyNames.put(map.get("def1").toString(), map.get("def2").toString());
					}
				}
			}
		}
		//添加参数控制检查部位是否显示   LL_CIOR0410
		for (int i = 0; i < qryDTOs.size(); i++) {
			if (FBoolean.TRUE.equals(qryDTOs.get(i).getFg_reformrow()))
				continue;
			if(qryDTOs.get(i).getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_DRUG)){
				continue;
			}
			if (mapBodyNames.containsKey(qryDTOs.get(i).getId_or())) {
				if("True".equals(isPrnRisPart)){					
					qryDTOs.get(i).setName_srv(qryDTOs.get(i).getName_srv() + "(" + mapBodyNames.get(qryDTOs.get(i).getId_or()) + ")");
				}
			}
			if(FBoolean.TRUE.equals(qryDTOs.get(i).getFg_urgent())) {
				qryDTOs.get(i).setName_srv(qryDTOs.get(i).getName_srv()+"  加急");
			}
			assembleDes_or(qryDTOs.get(i));
		}
	}
	
	/**
	 * 组装备注信息
	 * @param qryDTOs
	 */
	protected void assembleDes_or(CiOrdSheetDTO qryDTO){
		//0134345: 医嘱单打印-备注要上医嘱单
		if(!qryDTO.getSd_srvtp().startsWith(ICiorderPrintConst.SD_SRVTP_DRUG) && qryDTO.getDes_or()!=null){
			String name_srv = qryDTO.getName_srv()==null?"":qryDTO.getName_srv();
			qryDTO.setName_srv(name_srv+" "+qryDTO.getDes_or());
		}
	}
	
	/**
	 * 查询检查部位信息
	 * @param strSql
	 * @param isSet
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> getRisBodyName(String strSql, boolean isSet) throws Exception {
		String sql = isSet ? "select distinct orsrvset.id_or as def1,"
				+ "replace(to_char(wmsys.wm_concat(udi.name||decode(nvl(pos.name,'~'),'~','','-'||pos.name)) over (partition by orsrvset.id_or order by orsrvset.Sortno)),',','、') as def2 "
				+ "from ci_or_srv_set orsrvset " 
				+ "left outer join bd_udidoc udi on udi.id_udidoc=orsrvset.id_body "
				+ "left outer join bd_udidoc pos on pos.id_udidoc=orsrvset.id_pos "
				+ "where orsrvset.id_or in (" + strSql + ")"
				: "select ord.id_or as def1,udi.name||decode(nvl(pos.name,'~'),'~','','-'||pos.name) as def2 from ci_ap_obs srvobs "
				+ "left outer join ci_order ord on ord.id_or=srvobs.id_or "
				+ "left outer join bd_udidoc udi on udi.id_udidoc=srvobs.id_body " 
				+ "left outer join bd_udidoc pos on pos.id_udidoc=srvobs.id_pos "
				+ "where ord.id_or in (" + strSql + ")";

		return (List<Map<String, Object>>)(new DAFacade().execQuery(sql, new MapListHandler()));
	}
	
	/**
	 * 获取空数据对象，用于空预览界面显示
	 * @param name_ordsheet
	 * @return
	 */
	private CiOrdSheetDTO getEmptyCiOrdSheetDTO(String name_ordsheet) {
		CiOrdSheetDTO sheetDTO = new CiOrdSheetDTO();
		sheetDTO.setName_orprn(name_ordsheet);
		sheetDTO.setId_orprn("");
		sheetDTO.setFg_chk_canc("N");
		sheetDTO.setFg_chk_stop("N");
		sheetDTO.setFg_canc_prn("N");
		sheetDTO.setFg_stop_prn("N");
		return sheetDTO;
	}
	
	
	private void setDrugInfo(List<CiOrdSheetDTO> qryDTOs, Map<String,Integer> mapidors, String drugLinkMark) {
		List<CiOrdSheetDTO> lstDTOs_drug = new ArrayList<CiOrdSheetDTO>();
		for (int i = 0; i < qryDTOs.size(); i++) {
			qryDTOs.get(i).setContent_or_prn_sub("");
			if (FBoolean.TRUE.equals(qryDTOs.get(i).getFg_reformrow()))
				continue;
			//原液皮试设置皮试结果
			if(FBoolean.TRUE.equals(qryDTOs.get(i).getFg_skintest())){
				if(StringUtils.isNotEmpty(qryDTOs.get(i).getRst_skintest())){
					if(qryDTOs.get(i).getRst_skintest().equals("0")){
						qryDTOs.get(i).setContent_or_prn_sub("(-)");
					}else{
						qryDTOs.get(i).setContent_or_prn_sub("(+)");
					}
				}
			}
			if (qryDTOs.get(i).getSd_srvtp().startsWith("01") 
					&& !qryDTOs.get(i).getSd_srvtp().startsWith("0103")) {
//				if ("Y".equals(qryDTOs.get(i).getFg_self())) {
//					qryDTOs.get(i).setName_srv(qryDTOs.get(i).getName_srv() + "(自备)");////自备药
//				}
				lstDTOs_drug.add(qryDTOs.get(i));
			}
			if (lstDTOs_drug.size() > 0 && (i + 1 >= qryDTOs.size() || !qryDTOs.get(i).getId_or().equals(qryDTOs.get(i + 1).getId_or()))) {
				if (lstDTOs_drug.size() <= 1) {
					//非成组西成药格式拼接:商品打印名称（商品规格）   单次剂量+剂量单位  用法(备注) 频次
					lstDTOs_drug.get(0).setName_srv(this.getDrugNameStr(lstDTOs_drug.get(0))
							+ this.getQuanTotalMedu(lstDTOs_drug.get(0).getFg_pres_outp(), lstDTOs_drug.get(0).getFg_wholepack(),lstDTOs_drug.get(0).getQuan_cur(),lstDTOs_drug.get(0).getName_unit_sale()) 
							+ (StringUtils.isNotEmpty(lstDTOs_drug.get(0).getRoute_name()) ? (" "+lstDTOs_drug.get(0).getRoute_name()) : "") 
							+ (StringUtils.isNotEmpty(lstDTOs_drug.get(0).getDes_or()) ? "(" + lstDTOs_drug.get(0).getDes_or() + ")" : "") 
							+ this.getDrugRecModel(lstDTOs_drug.get(0).getFg_pres_outp(), lstDTOs_drug.get(0).getFg_wholepack()));
					if(StringUtils.isNotEmpty(qryDTOs.get(i).getFreq_name())&&!qryDTOs.get(i).getFreq_name().equals("持续")&&!qryDTOs.get(i).getFreq_name().equals("一次")){
						lstDTOs_drug.get(0).setContent_or_prn_sub(StringUtils.isNotEmpty(lstDTOs_drug.get(0).getFreq_name()) ? lstDTOs_drug.get(0).getFreq_name() : "");
					}
				} 
				else {
					//成组西成药格式拼接:
					for (int j = 0; j < lstDTOs_drug.size(); j++) {
						lstDTOs_drug.get(j).setName_srv(this.getDrugNameStr(lstDTOs_drug.get(j)));
//						//0133711: 1.住院医生站，医嘱打印，成组的用法频次在该组最后一行显示打印 2.持续医嘱的，持续二字不要显示打印
						if (j <= 0) {
							lstDTOs_drug.get(j).setContent_or_prn_sub(qryDTOs.get(i).getContent_or_prn_sub()+"┐");
						} else if (j < lstDTOs_drug.size() - 1) {
							lstDTOs_drug.get(j).setContent_or_prn_sub(qryDTOs.get(i).getContent_or_prn_sub()+drugLinkMark);
						} else {
							lstDTOs_drug.get(j).setContent_or_prn_sub(qryDTOs.get(i).getContent_or_prn_sub()+"┘  " 
									+ ((StringUtils.isNotEmpty(lstDTOs_drug.get(j).getFreq_name()) ? lstDTOs_drug.get(j).getFreq_name() + " " : ""))
									+ (StringUtils.isNotEmpty(lstDTOs_drug.get(j).getRoute_name()) ? (" "+lstDTOs_drug.get(j).getRoute_name()) + " " : "")
									+ (StringUtils.isNotEmpty(lstDTOs_drug.get(j).getDes_or()) ? lstDTOs_drug.get(j).getDes_or() : "")
									+ this.getDrugRecModel(lstDTOs_drug.get(j).getFg_pres_outp(), lstDTOs_drug.get(j).getFg_wholepack()));
							
						}
					}
				}
				lstDTOs_drug.clear();
			}
		}
	}
	
	/**
	 * 拼接领药方式
	 * @param fg_pres_out
	 * @param fg_wholepack
	 * @return
	 */
	private String getDrugRecModel(FBoolean fg_pres_out,FBoolean fg_wholepack){
		if(FBoolean.TRUE.equals(fg_pres_out)){
			return "（出院带药）";
		}else if(FBoolean.TRUE.equals(fg_wholepack)){
			return "（在院整领）";
		}else{
			return "";
		}
	}
	
	/**
	 * 出院带药和在院获取总量
	 * @param fg_pres_out
	 * @param fg_wholepack
	 * @param quan_cur
	 * @param name_unit_sale
	 * @return
	 */
	private String getQuanTotalMedu(FBoolean fg_pres_out,FBoolean fg_wholepack,String quan_cur,String name_unit_sale){
		if(FBoolean.TRUE.equals(fg_pres_out)||FBoolean.TRUE.equals(fg_wholepack)){
			return " "+quan_cur+name_unit_sale;
		}
		return "";
	}
	
	/**
	 * 西药信息拼接（商品打印名称   单次剂量+剂量单位）
	 * @param dto
	 * @return
	 */
	protected String getDrugNameStr(CiOrdSheetDTO dto){
		
		return String.format("%s%s%s", dto.getName_prn(), dto.getQuan_medu(), dto.getMedu_name());
	}
	
	
	/**
	 * 设置草药拼接格式
	 * @param qryDTOs
	 * @param lstResult
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	private void setHerbInfo(List<CiOrdSheetDTO> qryDTOs, List<CiOrdSheetDTO> lstResult, String drugLinkMark) 
			throws IOException, ClassNotFoundException {
		//获取草药医嘱集合
		Map<String, List<CiOrdSheetDTO>> mapDTOs_herb = new HashMap<String, List<CiOrdSheetDTO>>();
		for (CiOrdSheetDTO qryDTO : qryDTOs) {
			if (FBoolean.TRUE.equals(qryDTO.getFg_reformrow()))
				continue;
			if (qryDTO.getSd_srvtp().startsWith("0103")) {
				if (mapDTOs_herb.containsKey(qryDTO.getId_or())) {
					mapDTOs_herb.get(qryDTO.getId_or()).add(qryDTO);
				} else {
					List<CiOrdSheetDTO> lst = new ArrayList<CiOrdSheetDTO>();
					lst.add(qryDTO);
					mapDTOs_herb.put(qryDTO.getId_or(), lst);
				}
			}
		}
		//拼接草药医嘱内容字符串
		Map<String, List<CiOrdSheetDTO>> mapDTOs_herb_rst = new HashMap<String, List<CiOrdSheetDTO>>();
		if (mapDTOs_herb.size() > 0) {
			for (String key : mapDTOs_herb.keySet()) {
				List<CiOrdSheetDTO> lstDTOs = mapDTOs_herb.get(key);
				List<CiOrdSheetDTO> lstDTOs_detl = new ArrayList<CiOrdSheetDTO>();
				int n = 0;//每行药个数标记，不计自备药
				for (int i = 0; i < lstDTOs.size(); i++) {
					if ("Y".equals(lstDTOs.get(i).getFg_self())) {
						lstDTOs.get(i).setName_srv("(自备)" + lstDTOs.get(i).getName_srv());//自备草药
					} else if (n > 0 && !"Y".equals(lstDTOs.get(i - 1).getFg_self()) && n < 4) {
						//四味草药成一行，自备药单独一行（第一味药不拼接，自备药不拼接）
						lstDTOs.get(i).setName_srv(lstDTOs.get(i - 1).getName_srv() + "," + lstDTOs.get(i).getName_srv());
						lstDTOs.get(i).setName_mm(lstDTOs.get(i - 1).getName_mm() + "," + lstDTOs.get(i).getName_mm());
					}
					Boolean isNew = n >= 3;//是否每行最后一味药
					if (i == lstDTOs.size() - 1 || n >= 3 || "Y".equals(lstDTOs.get(i).getFg_self())
							|| "Y".equals(lstDTOs.get(i + 1).getFg_self())) {
						//当每一行已经有四味药，或者已经是整个医嘱最后一味药，或者当前是自备药，或者下一味是自备药；则该行数据结束。
						lstDTOs_detl.add(deepClone(lstDTOs.get(i)));
						n = 0;//一行结束，初始化每行药个数标记
					}
					if(!"Y".equals(lstDTOs.get(i).getFg_self()) && !isNew){
						n++;//每行药个数标记递增，不计自备药
					}
				}
				//草药方剂，每行拼接成组括弧标记
				if (lstDTOs_detl.size() > 1) {
					for (int i = 0; i < lstDTOs_detl.size(); i++) {
						if (i <= 0) {
							lstDTOs_detl.get(i).setContent_or_prn_sub("┐");
						} else if (i + 1 == lstDTOs_detl.size()) {
							lstDTOs_detl.get(i).setContent_or_prn_sub("┘");
						} else {
							lstDTOs_detl.get(i).setContent_or_prn_sub(drugLinkMark);
						}
					}
				}
				//拼接草药医嘱头信息
				CiOrdSheetDTO herbdto_sum = new CiOrdSheetDTO();
				herbdto_sum = deepClone(lstDTOs.get(0));
				herbdto_sum.setName_srv(herbdto_sum.getOrders() == null ? "" : "草药" + herbdto_sum.getOrders() + "剂：" 
						+ (StringUtils.isEmpty(herbdto_sum.getDes_or()) ? "" : herbdto_sum.getDes_or()));
				herbdto_sum.setSortno(null);
				lstDTOs_detl.add(herbdto_sum);
				mapDTOs_herb_rst.put(lstDTOs_detl.get(0).getId_or(), lstDTOs_detl);
			}
		}
		//替换草药医嘱信息
		List<String> lstidors = new ArrayList<String>();
		for (int i = 0; i < qryDTOs.size(); i++) {
			if (!FBoolean.TRUE.equals(qryDTOs.get(i).getFg_reformrow()) && qryDTOs.get(i).getSd_srvtp().startsWith("0103")) {
				if (!lstidors.contains(qryDTOs.get(i).getId_or()) && mapDTOs_herb_rst.containsKey(qryDTOs.get(i).getId_or())) {
					for (int j = 0; j < mapDTOs_herb_rst.get(qryDTOs.get(i).getId_or()).size(); j++) {
						lstResult.add(mapDTOs_herb_rst.get(qryDTOs.get(i).getId_or()).get(j));
					}
					lstidors.add(qryDTOs.get(i).getId_or());
				}
			} else {
				lstResult.add(qryDTOs.get(i));
			}
		}
	}
	
	/**
	 * 深复制对象
	 * @param dto
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private CiOrdSheetDTO deepClone(CiOrdSheetDTO dto) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(dto);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (CiOrdSheetDTO) ois.readObject();
	}
}
