package iih.ci.ord.s.bp.ordprn.ref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.utils.ContextUtils;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 *曲阜医嘱单内容拼接
 *@Author:杨栋
 *@Since:2019年5月10日
 */
public class QufuOrdPrintContentAssembleBp extends DefaultOrdPrintContentAssembleBP{
	
	
	/**
	 * 设置非药品医嘱拼接格式
	 * @param qryDTOs
	 * @throws Exception
	 */
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception{
		List<String> strIdors_ris_set_list = new ArrayList<String>();//检查(套)医嘱ID
		List<String> strIdors_ris_list = new ArrayList<String>();//检查(非套)医嘱ID
		for (int i = 0; i < qryDTOs.length; i++) {
			if (qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				if ("Y".equals(qryDTOs[i].getFg_set())) {
					strIdors_ris_set_list.add(qryDTOs[i].getId_or()) ;
				} else {
					strIdors_ris_list.add(qryDTOs[i].getId_or()) ;
				}
			//0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果 判断皮试结果code 阴性显示-阳性显示+
			}else if(qryDTOs[i].getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST)){
				if(StringUtils.isNotEmpty(qryDTOs[i].getRst_skintest())){
					if(qryDTOs[i].getRst_skintest().equals("0")){
						qryDTOs[i].setContent_or_prn_sub("(-)");
					}else{
						qryDTOs[i].setContent_or_prn_sub("(+)");
					}					
				}
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)
					||qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI)){
				//治疗或卫材拼接格式：	项目X单次剂量
//				qryDTOs[i].setName_srv(qryDTOs[i].getName_srv() 
//						+ (StringUtils.isNotEmpty(qryDTOs[i].getQuan_medu()) ? " X " + qryDTOs[i].getQuan_medu() : ""));
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
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)){
				qryDTOs[i].setName_srv("取"+qryDTOs[i].getName_srv().replaceAll("配", ""));
			}else if(qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)){
				//0132923: 住院医生-医嘱打印-会诊医嘱打印错误,显示医嘱内容
				if(qryDTOs[i].getName_srv().contains("会诊")){
					qryDTOs[i].setName_srv(qryDTOs[i].getContent_or().split("\\|")[2].split("&")[0]);
				}
			}
			if(qryDTOs[i].getFg_long()!=null&&qryDTOs[i].getFg_long().booleanValue()&&qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)){//添加嘱托类
				/*if(qryDTOs[i].getRoute_name()==null||"".equals(qryDTOs[i].getRoute_name())||"null".equals(qryDTOs[i].getRoute_name())){
					qryDTOs[i].setContent_or_prn_sub(qryDTOs[i].getFreq_name()+" ");
				}else{
					qryDTOs[i].setContent_or_prn_sub(qryDTOs[i].getFreq_name()+" "+qryDTOs[i].getRoute_name() );
				}*/
				
			}/*else if(qryDTOs[i].getFg_long()!=null&&!qryDTOs[i].getFg_long().booleanValue()&&qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)){
				if(qryDTOs[i].getRoute_name()==null||"".equals(qryDTOs[i].getRoute_name())||"null".equals(qryDTOs[i].getRoute_name())){
					qryDTOs[i].setName_srv(qryDTOs[i].getName_srv()+"    "+qryDTOs[i].getFreq_name()+" ");
				}else{
				qryDTOs[i].setName_srv(qryDTOs[i].getName_srv()+"    "+qryDTOs[i].getFreq_name()+" "+qryDTOs[i].getRoute_name() );
				}
			}*/
			//长期医嘱拼接频次
			//0133711: 1.住院医生站，医嘱打印，成组的用法频次在该组最后一行显示打印 2.持续医嘱的，持续二字不要显示打印
			if(qryDTOs[i].getFg_long()!=null&&qryDTOs[i].getFg_long().booleanValue()&&!StringUtils.isEmpty(qryDTOs[i].getSd_srvtp())&&qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
				if (qryDTOs[i].getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT)) {
					
				}else{
					if(!qryDTOs[i].getFreq_name().equals("持续")){
						qryDTOs[i].setContent_or_prn_sub(qryDTOs[i].getFreq_name());
					}	
				}			
			}
			
			if(qryDTOs[i].getFg_long()!=null&&qryDTOs[i].getFg_long().booleanValue()&&!StringUtils.isEmpty(qryDTOs[i].getSd_srvtp())&&qryDTOs[i].getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)) {
				//qryDTOs[i].setContent_or_prn_sub(qryDTOs[i].getFreq_name()); //护理添加频次
			}
			
		}
		// 检查拼接部位
		Map<String, String> mapBodyNames = new HashMap<String, String>();
		if (strIdors_ris_set_list != null && strIdors_ris_set_list.size() > 0) {
			List<Map<String, Object>> lstBodyNames = getRisBodyName((String[])strIdors_ris_set_list.toArray(new String[strIdors_ris_set_list.size()]), true);
			if (lstBodyNames != null && lstBodyNames.size() > 0) {
				for (Map<String, Object> map : lstBodyNames) {
					if (map.get("def2") != null) {
						mapBodyNames.put(map.get("def1").toString(), map.get("def2").toString());
					}
				}
			}
		}
		if(strIdors_ris_list != null && strIdors_ris_list.size()>0){
			List<Map<String, Object>> lstBodyNames = getRisBodyName((String[])strIdors_ris_list.toArray(new String[strIdors_ris_list.size()]), false);
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
				}else{
					qryDTOs[i].setName_srv(qryDTOs[i].getName_srv());
				}
			}
			if(FBoolean.TRUE.equals(qryDTOs[i].getFg_urgent())) {
				qryDTOs[i].setName_srv(qryDTOs[i].getName_srv()+"  加急");
			}
			assembleDes_or(qryDTOs[i]);
		}
	}
}
