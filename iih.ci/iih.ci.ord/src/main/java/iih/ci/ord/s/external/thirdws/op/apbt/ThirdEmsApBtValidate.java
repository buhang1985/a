package iih.ci.ord.s.external.thirdws.op.apbt;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtBloodItemDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtentDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtordDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtsrvDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtviewitemDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.base.StringList;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;
/**
 * 第三方备血医疗单校验
 * @author zhangwq
 *
 */
public class ThirdEmsApBtValidate extends OpBaseValidate {
	
	//就诊节点
	private static final String ENT=" 就诊节点";
	//医嘱节点
	private static final String ORDER=" 医嘱节点";
	//检验节点
	private static final String CHECK=" 检验节点";
	//服务费用节点
	private static final String SRV=" 服务费用节点";
	
	private static final String BLOODITEM="血液成分";
	
	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		EmsValidateRstDTO validateRstDTO=new EmsValidateRstDTO();
		 StringList msgList=new StringList();
		if(CiOrdUtils.isEmpty(dataSource)) {
			msgList.add("未能获取到-就诊信息");
			validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
			validateRstDTO.setMsgInfoList(msgList);
			return validateRstDTO;//没有就诊信息直接反  后面没必要
		}
		//----------------校验数据信息----------
		EmsapbtentDTO entDTO = (EmsapbtentDTO) dataSource;
		//1.校验就诊信息
		validateEnt(entDTO,msgList);
		List<EmsapbtordDTO> ordList=entDTO.getOrdList();
		if(CiOrdUtils.isEmpty(ordList)) {
			msgList.add(ENT+":未能获取到-医嘱信息");
			validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
			validateRstDTO.setMsgInfoList(msgList);
			return validateRstDTO;//医嘱为空 直接反  无需后面校验
		}
		int i=0;
		for(EmsapbtordDTO ordDTO:ordList) {
			i++;
			//1.1校验医嘱信息
			validateOrder(i,ordDTO,msgList);
			//1.1.1校验服务信息
			List<EmsCommonSrvDTO> srvList=ordDTO.getSrvList();
			//费用项可以为空
//			if(CiOrdUtils.isEmpty(srvList)) {
//				validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
//				msgList.add(ORDER+"["+i+"]:未能获取到费用明细信息");
//				validateRstDTO.setMsgInfoList(msgList);
//				return validateRstDTO;//服务信息 没有 直接反
//			}
			int j=0;
			if(srvList!=null) {
			for(EmsCommonSrvDTO commonSrvDTO:srvList) {
				j++;
				EmsapbtsrvDTO srvDto=(EmsapbtsrvDTO)commonSrvDTO;
				//校验服务
				validateSrv(i,j,srvDto,msgList);
			}
			}
			//1.1.2校验检验信息
			List<EmsapbtviewitemDTO> checkList=ordDTO.getCheckList();
			//检验项可以为空
//			if(CiOrdUtils.isEmpty(checkList)) {
//				validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
//				msgList.add(ORDER+"["+i+"]:未能获取到检验信息");
//				validateRstDTO.setMsgInfoList(msgList);
//				return validateRstDTO;//检验信息 没有 直接反
//			}
			int k=0;
			if(checkList!=null) {
			for(EmsapbtviewitemDTO check:checkList) {
				k++;
				//校验检验详细
				validateCheck(i,k,check,msgList);
			}
			}
			
			List<EmsapbtBloodItemDTO> items=ordDTO.getBloodItemList();
			if(CiOrdUtils.isEmpty(items)) {
			validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
			msgList.add(ORDER+"["+i+"]:未能获取到血液成分");
			validateRstDTO.setMsgInfoList(msgList);
			return validateRstDTO;//血液成分信息 没有 直接反
		}
			int ii=0;
			for (EmsapbtBloodItemDTO emsapbtBloodItemDTO : items) {
				ii++;
				validateBloodItem(i, ii, emsapbtBloodItemDTO, msgList);
			}
		}
		if(!CiOrdUtils.isEmpty(msgList)) {
			validateRstDTO.setMsgInfoList(msgList);
			validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
			return validateRstDTO;
		}
		return null;
	}
	/**
	 * 校验就诊信息<ent/>
	 * @param entDTO
	 * @param msgList
	 */
	private void validateEnt(EmsapbtentDTO entDTO,List<String> msgList) {
		if(StringUtils.isEmpty(entDTO.getCode_org())) {
			msgList.add(ENT+":未能获取到-所属组织");
		}
		if(StringUtils.isEmpty(entDTO.getCode_pat())) {
			msgList.add(ENT+":未能获取到-患者");
		}
		if(StringUtils.isEmpty(entDTO.getCode_en())) {
			msgList.add(ENT+":未能获取到-就诊编码");
		}
		if(StringUtils.isEmpty(entDTO.getCode_entp())) {
			msgList.add(ENT+":未能获取到-就诊类型编码");
		}
		if(StringUtils.isEmpty(entDTO.getCode_dep_phy())) {
			msgList.add(ENT+":未能获取到-当前就诊科室");
		}
		if(StringUtils.isEmpty(entDTO.getCode_emp_phy())) {
			msgList.add(ENT+":未能获取到-当前主管医生");
		}
		if(StringUtils.isEmpty(entDTO.getSd_bloodtype_pi())) {
			msgList.add(ENT+":未能获取到-患者血型编码");
		}
		if(StringUtils.isEmpty(entDTO.getSd_rhd_pi())) {
			msgList.add(ENT+":未能获取到-患者Rh(D)编码");
		}
	}
	/**
	 * 校验医嘱信息<order/>
	 * @param i
	 * @param ordDTO
	 * @param msgList
	 */
	private void validateOrder(int i,EmsapbtordDTO ordDTO,List<String> msgList) {
		if(StringUtils.isEmpty(ordDTO.getSortno_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-医嘱序号");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-医嘱编码");
		}
//		if(StringUtils.isEmpty(ordDTO.getCode_srv_or())) {
//			msgList.add(ORDER+"["+i+"]:未能获取到-备血项目编码");
//		}
//		if(StringUtils.isEmpty(ordDTO.getName_srv_or())) {
//			msgList.add(ORDER+"["+i+"]:未能获取到-备血项目名称");
//		}
		if(StringUtils.isEmpty(ordDTO.getNo_applyform())) {
			msgList.add(ORDER+"["+i+"]:未能获取到备血申请单号");
		}
		if(StringUtils.isEmpty(ordDTO.getSd_his_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-输血史标识编码");
		}
		if(StringUtils.isEmpty(ordDTO.getSd_pps_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-输血目的描述");
		}
		if(StringUtils.isEmpty(ordDTO.getSd_demandsu_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-输血需求状态");
		}
		if(StringUtils.isEmpty(ordDTO.getSd_mode_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-预定输血方式");
		}
		if(StringUtils.isEmpty(ordDTO.getDt_bt_pl())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-计划输血日期");
		}
		if(StringUtils.isEmpty(ordDTO.getSd_bloodtype_ap())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-申请血型编码");
		}
		if(StringUtils.isEmpty(ordDTO.getSd_rhd_ap())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-申请Rh(D)编码");
		}
//		if(StringUtils.isEmpty(ordDTO.getQuan_medu_bt())) {
//			msgList.add(ORDER+"["+i+"]:未能获取到-申请血量");
//		}
//		if(StringUtils.isEmpty(ordDTO.getCode_medu_bt())) {
//			msgList.add(ORDER+"["+i+"]:未能获取到-申请血量单位");
//		}
		if(StringUtils.isEmpty(ordDTO.getCode_dep_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立部门");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_emp_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立医生");
		}
		if(StringUtils.isEmpty(ordDTO.getDt_entry_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立日期");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_dep_mp_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-医嘱执行科室");
		}
	}
	
	
	private void validateBloodItem(int i,int j,EmsapbtBloodItemDTO srvDto,List<String> msgList) {
		
		if(StringUtils.isEmpty(srvDto.getCode_srv_or())) {
		msgList.add(ORDER+"["+i+"]"+BLOODITEM+"["+j+"]:未能获取到-备血项目编码");
	}
	if(StringUtils.isEmpty(srvDto.getName_srv_or())) {
		msgList.add(ORDER+"["+i+"]"+BLOODITEM+"["+j+"]:未能获取到-备血项目名称");
	}
		if(StringUtils.isEmpty(srvDto.getQuan_medu_bt())) {
		msgList.add(ORDER+"["+i+"]"+BLOODITEM+"["+j+"]:未能获取到-申请血量");
	}
	if(StringUtils.isEmpty(srvDto.getCode_medu_bt())) {
		msgList.add(ORDER+"["+i+"]"+BLOODITEM+"["+j+"]:未能获取到-申请血量单位");
	}

	}
	
	/**
	 * 校验服务<srv/>
	 * @param i
	 * @param j
	 * @param srvDto
	 * @param msgList
	 */
	private void validateSrv(int i,int j,EmsapbtsrvDTO srvDto,List<String> msgList) {
		if(StringUtils.isEmpty(srvDto.getCode_srv())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-费用项目编码");
		}
		if(StringUtils.isEmpty(srvDto.getName_srv())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-费用项目名称");
		}
		if(StringUtils.isEmpty(srvDto.getQuan_medu_srv())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-费用项目单次数量");
		}
		if(StringUtils.isEmpty(srvDto.getPri())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-单价");
		}
		if(StringUtils.isEmpty(srvDto.getPri_std())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-标准价");
		}
		if(StringUtils.isEmpty(srvDto.getPri_ratio())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-价格系数");
		}
		if(StringUtils.isEmpty(srvDto.getCode_dep_mp_srv())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-费用执行科室");
		}
	}
	/**
	 * 校验检验信息<check/>
	 * @param i
	 * @param k
	 * @param check
	 * @param msgList
	 */
	private void validateCheck(int i,int k,EmsapbtviewitemDTO check,List<String> msgList) {
		if(StringUtils.isEmpty(check.getSortno_viewitm())) {
			msgList.add(ORDER+"["+i+"]"+CHECK+"["+k+"]:未能获取到-序号");
		}
		if(StringUtils.isEmpty(check.getCode_srv_viewitm())) {
			msgList.add(ORDER+"["+i+"]"+CHECK+"["+k+"]:未能获取到-检验指标编码");
		}
		if(StringUtils.isEmpty(check.getName_or_viewitm())) {
			msgList.add(ORDER+"["+i+"]"+CHECK+"["+k+"]:未能获取到-检验指标简称");
		}
		if(StringUtils.isEmpty(check.getVal_rstrptla_viewitm())) {
			msgList.add(ORDER+"["+i+"]"+CHECK+"["+k+"]:未能获取到-项目结果值");
		}
	}
}
