package iih.ci.ord.s.bp.ordprn.ref;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.utils.ContextUtils;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.util.AgeCalcUtil;

/**
 * @code 治疗加用法
 * @author LiYue
 * @date 2020年3月16日,下午6:22:42
 */
public class RouteAddTreatOrdPrintContentAssembleBP {
	public static final String STR_POSSIGNMODE_DOCTOR = "责任医生：";
	public static final String STR_POSSIGNMODE_NURSE = "责任护士：";
	public static final String STR_POSSIGNMODE_LINE = "______";
	//药品连接符
	private String drugLinkMark;
	public OrdPrintDataDTO[] assemble(OrdPrintParamDTO paramDTO,OrdPrintDataDTO[] qryDTOs) throws Exception{
		List<OrdPrintDataDTO> lstResult = new ArrayList<OrdPrintDataDTO>();
		if (qryDTOs != null && qryDTOs.length > 0) {
			//设置签字信息
			this.setPosSignInfo(paramDTO.getPosSignMode(), paramDTO.getFg_long(), paramDTO.getName_orprn(), qryDTOs);
			
			//组装草药医嘱
			this.setHerbInfo(qryDTOs, lstResult);
			
			//组装西成药医嘱
			this.setDrugInfo(qryDTOs, paramDTO.getFg_long());
			
			//组装非药品医嘱
			this.setNotDrugInfo(qryDTOs);
		}
         // 处理开始时间  
		setDt_effe(lstResult);//成组的显示一个时间
		return lstResult.toArray(new OrdPrintDataDTO[] {});
	}
	/**
	 * 医嘱打印 成组的显示一个时间
	 * @param lstResult
	 */
	protected void setDt_effe(List<OrdPrintDataDTO> lstResult) {
//		if(lstResult != null && lstResult.size() >0) {
//			String id_or = null;
//			for(OrdPrintDataDTO dataDTO: lstResult) {
//				if(!org.apache.commons.lang3.StringUtils.isBlank(id_or) && id_or.equals(dataDTO.getId_or())) {
//					dataDTO.setDt_effe(null);
//				}
//				id_or = dataDTO.getId_or();
//			}
//		}
	}
	
	
	/**
	 * 设置草药拼接格式
	 * @param qryDTOs
	 * @param lstResult
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	protected void setHerbInfo(OrdPrintDataDTO[] qryDTOs, List<OrdPrintDataDTO> lstResult) throws ClassNotFoundException, IOException{
		//获取草药医嘱集合
		Map<String, List<OrdPrintDataDTO>> mapDTOs_herb = new HashMap<String, List<OrdPrintDataDTO>>();
		for (int i = 0; i < qryDTOs.length; i++) {
			if (qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				if (mapDTOs_herb.containsKey(qryDTOs[i].getId_or())) {
					mapDTOs_herb.get(qryDTOs[i].getId_or()).add(qryDTOs[i]);
				} else {
					List<OrdPrintDataDTO> lst = new ArrayList<OrdPrintDataDTO>();
					lst.add(qryDTOs[i]);
					mapDTOs_herb.put(qryDTOs[i].getId_or(), lst);
				}
			}
		}
		//拼接草药医嘱内容字符串
		Map<String, List<OrdPrintDataDTO>> mapDTOs_herb_rst = new HashMap<String, List<OrdPrintDataDTO>>();
		if (mapDTOs_herb.size() > 0) {
			for (String key : mapDTOs_herb.keySet()) {
				List<OrdPrintDataDTO> lstDTOs = mapDTOs_herb.get(key);
				List<OrdPrintDataDTO> lstDTOs_detl = new ArrayList<OrdPrintDataDTO>();
				int n = 0;//每行药个数标记，不计自备药
				for (int i = 0; i < lstDTOs.size(); i++) {
					if (lstDTOs.get(i).getFg_self().booleanValue()) {
						lstDTOs.get(i).setName_srv("(自备)" + lstDTOs.get(i).getName_srv());//自备草药
					}else if (n > 0 && !lstDTOs.get(i - 1).getFg_self().booleanValue() && n < 4) {
						//四味草药成一行，自备药单独一行（第一味药不拼接，自备药不拼接）
						lstDTOs.get(i).setName_srv(lstDTOs.get(i - 1).getName_srv() + "," + lstDTOs.get(i).getName_srv());
						lstDTOs.get(i).setName_mm(lstDTOs.get(i - 1).getName_mm() + "," + lstDTOs.get(i).getName_mm());
					}
					Boolean isNew = n >= 3;//是否每行最后一味药
					if (i == lstDTOs.size() - 1 || n >= 3 
							|| lstDTOs.get(i).getFg_self().booleanValue()
							|| lstDTOs.get(i + 1).getFg_self().booleanValue()) {
						//当每一行已经有四味药，或者已经是整个医嘱最后一味药，或者当前是自备药，或者下一味是自备药；则该行数据结束。
						OrdPrintDataDTO herbdto_detl = this.deepClone(lstDTOs.get(i));//深度复制对象
						lstDTOs_detl.add(herbdto_detl);
						n = 0;//一行结束，初始化每行药个数标记
					}
					if(!lstDTOs.get(i).getFg_self().booleanValue() && !isNew){
						n++;//每行药个数标记递增，不计自备药
					}
				}
				//草药方剂，每行拼接成组括弧标记
				if (lstDTOs_detl.size() > 1) {
					for (int i = 0; i < lstDTOs_detl.size(); i++) {
//						String space = getStringSpace(length_max - getStringLength(lstDTOs_detl.get(i).getName_srv()));
						if (i <= 0) {
							lstDTOs_detl.get(i).setContent_or_prn_sub("┐");
						} else if (i + 1 == lstDTOs_detl.size()) {
							lstDTOs_detl.get(i).setContent_or_prn_sub("┘");
						} else {
							lstDTOs_detl.get(i).setContent_or_prn_sub(getDrugLinkMark());
						}
					}
				}
				//拼接草药医嘱头信息
				OrdPrintDataDTO herbdto_sum = this.deepClone(lstDTOs.get(0));
				herbdto_sum.setName_srv("草药" + herbdto_sum.getOrders() + "剂：" + (StringUtils.isEmpty(herbdto_sum.getDes_or())?"":herbdto_sum.getDes_or())+getDrugRecModel(herbdto_sum.getFg_pres_outp(),herbdto_sum.getFg_wholepack()));
				lstDTOs_detl.add(herbdto_sum);
				mapDTOs_herb_rst.put(lstDTOs_detl.get(0).getId_or(), lstDTOs_detl);
			}
		}
		//替换草药医嘱信息
		List<String> lstidors = new ArrayList<String>();
		for (int i = 0; i < qryDTOs.length; i++) {
			if (qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				if (!lstidors.contains(qryDTOs[i].getId_or()) && mapDTOs_herb_rst.containsKey(qryDTOs[i].getId_or())) {
					for (int j = 0; j < mapDTOs_herb_rst.get(qryDTOs[i].getId_or()).size(); j++) {
						lstResult.add(mapDTOs_herb_rst.get(qryDTOs[i].getId_or()).get(j));
					}
					lstidors.add(qryDTOs[i].getId_or());
				}
			} else {
				lstResult.add(qryDTOs[i]);
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
	 * 设置西成药拼接格式
	 * @param qryDTOs
	 */
	private void setDrugInfo(OrdPrintDataDTO[] qryDTOs, FBoolean fg_long){
		List<OrdPrintDataDTO> lstDTOs_drug = new ArrayList<OrdPrintDataDTO>();
		for (int i = 0; i < qryDTOs.length; i++) {
			//原液皮试设置皮试结果
			if(FBoolean.TRUE.equals(qryDTOs[i].getFg_skintest())){
				if(StringUtils.isNotEmpty(qryDTOs[i].getRst_skintest())){
					if(qryDTOs[i].getRst_skintest().equals("0")){
						qryDTOs[i].setContent_or_prn_skintest("(-)");
					}else{
						qryDTOs[i].setContent_or_prn_skintest("(+)");
					}					
				}
			}
			if (qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) 
					&& !qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				if (qryDTOs[i].getFg_self().booleanValue()) {
					qryDTOs[i].setName_srv("(自备)" + qryDTOs[i].getName_srv());////自备药
				}
				lstDTOs_drug.add(qryDTOs[i]);
			}
			if (lstDTOs_drug.size() > 0 && (i + 1 >= qryDTOs.length || !qryDTOs[i].getId_or().equals(qryDTOs[i + 1].getId_or()))) {
				if (lstDTOs_drug.size() <= 1) {
					//非成组西成药格式拼接:商品打印名称（商品规格）   单次剂量+剂量单位  用法(备注) 频次
					lstDTOs_drug.get(0).setName_srv(this.getDrugNameStr(lstDTOs_drug.get(0))
							+ this.getQuanTotalMedu(lstDTOs_drug.get(0).getFg_pres_outp(), lstDTOs_drug.get(0).getFg_wholepack(),lstDTOs_drug.get(0).getQuan_cur(),lstDTOs_drug.get(0).getName_unit_sale()) 
							+ (StringUtils.isNotEmpty(lstDTOs_drug.get(0).getRoute_name()) ? (" "+lstDTOs_drug.get(0).getRoute_name()) : "") 
							+ (StringUtils.isNotEmpty(lstDTOs_drug.get(0).getDes_or()) ? "(" + lstDTOs_drug.get(0).getDes_or() + ")" : "") 
							+ this.getDrugRecModel(lstDTOs_drug.get(0).getFg_pres_outp(), lstDTOs_drug.get(0).getFg_wholepack()));
					if(StringUtils.isNotEmpty(qryDTOs[i].getFreq_name())&&!qryDTOs[i].getFreq_name().equals("持续")&&!qryDTOs[i].getFreq_name().equals("一次")){
						lstDTOs_drug.get(0).setContent_or_prn_sub(StringUtils.isNotEmpty(lstDTOs_drug.get(0).getFreq_name()) ? lstDTOs_drug.get(0).getFreq_name() : "");
					}
				} else {
					//成组西成药格式拼接:
					for (int j = 0; j < lstDTOs_drug.size(); j++) {
						lstDTOs_drug.get(j).setName_srv(this.getDrugNameStr(lstDTOs_drug.get(j)));
						lstDTOs_drug.get(j).setName_srv(lstDTOs_drug.get(j).getName_srv()
								+ this.getQuanTotalMedu(lstDTOs_drug.get(j).getFg_pres_outp(), lstDTOs_drug.get(j).getFg_wholepack(),lstDTOs_drug.get(j).getQuan_cur(),lstDTOs_drug.get(j).getName_unit_sale()));
						//0133711: 1.住院医生站，医嘱打印，成组的用法频次在该组最后一行显示打印 2.持续医嘱的，持续二字不要显示打印
						if (j <= 0) {
							lstDTOs_drug.get(j).setContent_or_prn_sub("┐");
						} else if (j < lstDTOs_drug.size() - 1) {
							lstDTOs_drug.get(j).setContent_or_prn_sub(getDrugLinkMark());
						} else {
							lstDTOs_drug.get(j).setContent_or_prn_sub("┘  " 
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
	 * 西药信息拼接（商品打印名称   单次剂量+剂量单位）
	 * @param dto
	 * @return
	 */
	protected String getDrugNameStr(OrdPrintDataDTO dto){
//		return dto.getName_prn() + "(" + dto.getSpec() + ") " + dto.getQuan_medu() + dto.getMedu_name();
		return dto.getName_prn() + "  " + dto.getQuan_medu() + dto.getMedu_name();
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
	 * 设置非药品医嘱拼接格式
	 * @param qryDTOs
	 * @throws Exception
	 */
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception{
		String strIdors_ris_set = "";//检查(套)医嘱ID
		String strIdors_ris = "";//检查(非套)医嘱ID
		for (int i = 0; i < qryDTOs.length; i++) {
			if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				continue;
			}
			if (qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				if ("Y".equals(qryDTOs[i].getFg_set())) {
					strIdors_ris_set += ",'" + qryDTOs[i].getId_or() + "'";
				} else {
					strIdors_ris += ",'" + qryDTOs[i].getId_or() + "'";
				}
			//0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果 判断皮试结果code 阴性显示-阳性显示+
			}else if(qryDTOs[i].getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST)){
				if(StringUtils.isNotEmpty(qryDTOs[i].getRst_skintest())){
					if(qryDTOs[i].getRst_skintest().equals("0")){
						qryDTOs[i].setContent_or_prn_skintest("(-)");
					}else{
						qryDTOs[i].setContent_or_prn_skintest("(+)");
					}					
				}
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){
				//手术拼接格式：拟于+【计划手术日期】+在【麻醉方式】下行+【手术项目】
				String[] content_or = qryDTOs[i].getContent_or().split("\\|");
				String nameSrv = content_or[2];
				if (content_or.length > 3 && !"null".equals(StringUtils.trimToEmpty(content_or[3]))) {
					nameSrv += " " + StringUtils.trimToEmpty(content_or[3]);
				}
				
				//0122281: 临时医嘱单---手术医嘱显示结尾多显示个0  
				//Reason ：医嘱单不展示手术价格 此处截取掉
				//qryDTOs[i].setName_srv(nameSrv.replace("&", ""));
				int index = nameSrv.lastIndexOf("&");
				if(index!=-1){
					qryDTOs[i].setName_srv(nameSrv.substring(0,index));
				}
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)){
				qryDTOs[i].setName_srv("配"+qryDTOs[i].getName_srv() + qryDTOs[i].getQuan_medu() + qryDTOs[i].getMedu_name());
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)){
				qryDTOs[i].setName_srv("输"+qryDTOs[i].getName_srv() + qryDTOs[i].getQuan_medu() + qryDTOs[i].getMedu_name());
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)){
				//0132923: 住院医生-医嘱打印-会诊医嘱打印错误,显示医嘱内容SD_SRVTP_TREAT
				if(qryDTOs[i].getName_srv().contains("会诊")){
					qryDTOs[i].setName_srv(qryDTOs[i].getContent_or().split("\\|")[2].split("&")[0]);
				}
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
				//0186801: 【工单】住院医嘱---简洁医疗单---选择的用法需要在医嘱内容里面显示并且医嘱打印处能打印出来
				if( StringUtils.isNotEmpty(qryDTOs[i].getRoute_name()) && !qryDTOs[i].getName_srv().contains( qryDTOs[i].getRoute_name())){
					qryDTOs[i].setContent_or_prn_sub( qryDTOs[i].getRoute_name());
				}
			}
			if(StringUtils.isNotEmpty(qryDTOs[i].getFreq_name())&&!qryDTOs[i].getFreq_name().equals("持续")&&!qryDTOs[i].getFreq_name().equals("一次")){
				qryDTOs[i].setContent_or_prn_sub((StringUtils.isNotEmpty(qryDTOs[i].getContent_or_prn_sub())?(qryDTOs[i].getContent_or_prn_sub()+" "):"")+qryDTOs[i].getFreq_name());
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
		FBoolean ShowBodyName = ParamUtils.GetOrgParamFBooleanValue(ContextUtils.getOrgId(), ICiOrdCustomSysParamConst.LL_PARAM_RISBODY_ISSHOW);
		for (int i = 0; i < qryDTOs.length; i++) {
			if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				continue;
			}
			if (mapBodyNames.containsKey(qryDTOs[i].getId_or())) {
				if(ShowBodyName.booleanValue()){					
					qryDTOs[i].setName_srv(qryDTOs[i].getName_srv() + "(" + mapBodyNames.get(qryDTOs[i].getId_or()) + ")");
				}
			}
			if(FBoolean.TRUE.equals(qryDTOs[i].getFg_urgent())) {
				qryDTOs[i].setName_srv(qryDTOs[i].getName_srv()+"  加急");
			}
			assembleDes_or(qryDTOs[i]);
		}
	}
	
	/**
	 * 根据医嘱单签字模式设置签字信息
	 * @param posSignMode
	 * @param fg_long
	 * @param name_orprn
	 * @param dtos
	 */
	protected void setPosSignInfo(String posSignMode, FBoolean fg_long, String name_orprn, OrdPrintDataDTO[] dtos) {
		Map<String, String> map_id_emp_doctor = new HashMap<String, String>();
		Map<String, String> map_id_emp_nurse = new HashMap<String, String>();
		Map<String, String> map_name_doctor = new HashMap<String, String>();
		Map<String, String> map_name_nurse = new HashMap<String, String>();
		Integer rownum = 1;
		for (OrdPrintDataDTO dto : dtos) {
			Integer pagenum = rownum / 26 + 1;
			//医嘱单签字模式，拼接签字信息
			if (ICiOrdNSysParamConst.PARAM_POSSIGNMODE_ALLPAGE_AUTO.equals(posSignMode)
					|| ICiOrdNSysParamConst.PARAM_POSSIGNMODE_ALLPAGE_MANU.equals(posSignMode)) {
				dto.setLabel_name_emp_sign(STR_POSSIGNMODE_DOCTOR);
				dto.setLabel_name_emp_check(STR_POSSIGNMODE_NURSE);
				
				if(ICiOrdNSysParamConst.PARAM_POSSIGNMODE_ALLPAGE_AUTO.equals(posSignMode)){
					if (StringUtils.isNotEmpty(dto.getId_emp_sign()) && StringUtils.isNotEmpty(dto.getName_emp_sign())) {
						setStrPosSignInfo(map_id_emp_doctor,map_name_doctor,dto.getId_emp_sign(),dto.getName_emp_sign(),pagenum);
					}
					if (fg_long.booleanValue() && StringUtils.isNotEmpty(dto.getId_emp_stop()) && StringUtils.isNotEmpty(dto.getName_emp_stop())) {
						setStrPosSignInfo(map_id_emp_doctor,map_name_doctor,dto.getId_emp_stop(),dto.getName_emp_stop(),pagenum);
					}
					if (StringUtils.isNotEmpty(dto.getId_emp_chk()) && StringUtils.isNotEmpty(dto.getName_emp_chk())) {
						setStrPosSignInfo(map_id_emp_nurse,map_name_nurse,dto.getId_emp_chk(),dto.getName_emp_chk(),pagenum);
					}
					if (fg_long.booleanValue() && StringUtils.isNotEmpty(dto.getId_emp_chk_stop()) && StringUtils.isNotEmpty(dto.getName_emp_chk_stop())) {
						setStrPosSignInfo(map_id_emp_nurse,map_name_nurse,dto.getId_emp_chk_stop(),dto.getName_emp_chk_stop(),pagenum);
					}
				}

			} else if (ICiOrdNSysParamConst.PARAM_POSSIGNMODE_EVERY_MANU.equals(posSignMode)) {
				dto.setName_emp_sign(null);
				dto.setName_emp_stop(null);
				dto.setName_emp_chk(null);
				dto.setName_emp_chk_stop(null);
			} else if (ICiOrdNSysParamConst.PARAM_POSSIGNMODE_EVERY_AUTO.equals(posSignMode)) {
			} else if (ICiOrdNSysParamConst.PARAM_POSSIGNMODE_ELEC.equals(posSignMode)) {
			}
			rownum++;
		}
		rownum = 1;
		for (OrdPrintDataDTO dto : dtos) {
			Integer pagenum = rownum / 26 + 1;
			dto.setStr_name_emp_sign(map_name_doctor.get(pagenum.toString()));
			dto.setStr_name_emp_check(map_name_nurse.get(pagenum.toString()));
			rownum++;
			dto.setName_orprn(name_orprn);//设置医疗单据名称（长期医嘱单、临时医嘱单、中医医嘱单）
			setAgeInfo(dto);//设置年龄格式
		}
	}
	
	private void setStrPosSignInfo(Map<String, String> map_id, Map<String, String> map_name, String id_emp, String name_emp, Integer page_num) {
        if (map_id.containsKey(page_num.toString())) {
            if (!map_id.get(page_num.toString()).contains(id_emp)) {
            	map_id.put(page_num.toString(), map_id.get(page_num.toString()) + id_emp);
            	map_name.put(page_num.toString(),map_name.get(page_num.toString()) + name_emp + STR_POSSIGNMODE_LINE);
            }
        }
        else {
        	map_id.put(page_num.toString(), id_emp);
        	map_name.put(page_num.toString(), name_emp + STR_POSSIGNMODE_LINE);
        }
    }
	
	/**
	 * 设置年龄
	 * @param dto
	 */
	private void setAgeInfo(OrdPrintDataDTO dto){
		if (dto.getAge() != null) {
			if(dto.getAge().contains("岁"))return;
			FDateTime dt = new FDateTime(dto.getAge());
			//在院的新生儿使用当前时间计算年龄，其他情况使用入院时间计算年龄
			if(FBoolean.TRUE.equals(dto.getFg_ip())&&FBoolean.TRUE.equals(dto.getFg_newborn())){
				dto.setAge(AgeCalcUtil.getAge(dt));
			}else{
				if(dto.getDt_acpt()==null){
					dto.setAge(AgeCalcUtil.getAge(dt));
				}else{
					dto.setAge(AgeCalcUtil.getAge(dt,dto.getDt_acpt()));
				}	
			}
		}
	}
	
	/**
	 * 日期格式转换
	 * @param srcDateStr
	 * @return
	 */
	private Date convertStrToDate(String srcDateStr) {
		if (srcDateStr == null || srcDateStr.trim().length() == 0)
			return null;
		try {
			SimpleDateFormat format = null;
			if (srcDateStr.indexOf("/") > 0) {
				format = new SimpleDateFormat("yyyy/MM/dd");
			} else if (srcDateStr.indexOf("-") > 0) {
				format = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				format = getDayFormat();
			}

			return format.parse(srcDateStr);
		} catch (ParseException e) {
		}
		return null;
	}
	
	/**
	 * 日期格式
	 * @return
	 */
	private SimpleDateFormat getDayFormat() {
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fmt = (SimpleDateFormat) dayFormat.clone();
		return fmt;
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
//				+ "replace(to_char(wmsys.wm_concat(udi.name||decode(nvl(pos.name,'~'),'~','','-'||pos.name)) over (partition by orsrvset.id_or order by orsrvset.Sortno)),',','、') as def2 "
                + "replace(to_char(listagg(udi.name||decode(nvl(pos.name,'~'),'~','','-'||pos.name),',') within group (order by orsrvset.Sortno) over (partition by orsrvset.id_or)),',','、') as def2 "
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
	 * 获取空格字符串
	 * @param n
	 * @return
	 */
	private String getStringSpace(int n) {
		StringBuffer space = new StringBuffer();
		for (int i = 0; i < n; i++) {
			space.append(" ");
		}
		return space.toString();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private int getStringLength(String str){
		String reg = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				count++;
			}
		}

		return 2 * count + str.length() - count;
	}
	
	/**
	 * 深复制对象
	 * @param dto
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private OrdPrintDataDTO deepClone(OrdPrintDataDTO dto) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(dto);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (OrdPrintDataDTO) ois.readObject();
	}
	/**
	 * 组装备注信息
	 * @param qryDTOs
	 */
	protected void assembleDes_or(OrdPrintDataDTO qryDTOs){
		//0134345: 医嘱单打印-备注要上医嘱单
		if(!qryDTOs.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) && qryDTOs.getDes_or()!=null){
			String name_srv = qryDTOs.getName_srv()==null?"":qryDTOs.getName_srv();
			qryDTOs.setName_srv(name_srv+" "+qryDTOs.getDes_or());
		}
	}
	/**
	 * 药品连接符
	 * @return
	 */
	private String getDrugLinkMark(){
		if(drugLinkMark != null){
			return drugLinkMark;
		}
		try {
			drugLinkMark =  ParamUtils.getOrgParamStringValue(Context.get().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_ORDPRN_DRUG_MARK);
		} catch (BizException e) {
			return "┤";
		}
		return drugLinkMark;
	}
}
