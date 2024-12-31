package iih.ci.ord.s.external.thirdws.op.apbu;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtordDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtsrvDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuentDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuordDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbusrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.base.StringList;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.op.ValidateOrderAndDiagBP;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;
/**
 * 第三方用血医疗单校验
 * @author zhangwq
 *
 */
public class ThirdEmsApBuValidate extends OpBaseValidate {

	//就诊节点
	private static final String ENT=" 就诊节点";
	//医嘱节点
	private static final String ORDER=" 医嘱节点";
	//服务费用节点
	private static final String SRV=" 服务费用节点";
	
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
		EmsapbuentDTO entDTO = (EmsapbuentDTO) dataSource;
		//1.校验就诊信息
		validateEnt(entDTO,msgList);
		List<EmsapbuordDTO> ordList=entDTO.getOrdlist();
		if(CiOrdUtils.isEmpty(ordList)) {
			msgList.add(ENT+":未能获取到-医嘱信息");
			validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
			validateRstDTO.setMsgInfoList(msgList);
			return validateRstDTO;//医嘱为空 直接反  无需后面校验
		}
		int i=0;
		for(EmsapbuordDTO ordDTO:ordList) {
			i++;
			//1.1校验医嘱信息
			validateOrder(i,ordDTO,msgList);
			//1.1.1校验服务信息
			List<EmsCommonSrvDTO> srvList=ordDTO.getSrvList();
			if(CiOrdUtils.isEmpty(srvList)) {
				validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
				msgList.add(ORDER+"["+i+"]:未能获取到费用明细信息");
				validateRstDTO.setMsgInfoList(msgList);
				return validateRstDTO;//服务信息 没有 直接反
			}
			int j=0;
			for(EmsCommonSrvDTO commonSrvDTO:srvList) {
				j++;
				//EmsapbusrvDTO srvDto=(EmsapbusrvDTO)commonSrvDTO;
				//校验服务详细信息
				validateSrv(i,j,commonSrvDTO,msgList);
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
	 * 校验就诊<ent/>
	 * @param entDTO
	 * @param msgList
	 */
	private void validateEnt(EmsapbuentDTO entDTO,List<String> msgList) {
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
	private void validateOrder(int i,EmsapbuordDTO ordDTO , List<String> msgList) {
		if(StringUtils.isEmpty(ordDTO.getSortno_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-医嘱序号");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-医嘱编码");
		}
		if(StringUtils.isEmpty(ordDTO.getNo_applyform_bu())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-用血申请单号");
		}
		if(StringUtils.isEmpty(ordDTO.getNo_applyform_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-备血申请单号");
		}
		if(StringUtils.isEmpty(ordDTO.getDt_bu_plan())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-计划用血日期");
		}
		if(StringUtils.isEmpty(ordDTO.getQuan_medu_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-申请用量");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_medu_bt())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-申请用量单位");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_dep_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立部门");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_emp_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立医生");
		}
		if(StringUtils.isEmpty(ordDTO.getDt_entry_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立日期");
		}
		if(StringUtils.isEmpty(ordDTO.getDt_entry_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-开立日期");
		}
		if(StringUtils.isEmpty(ordDTO.getCode_dep_mp_or())) {
			msgList.add(ORDER+"["+i+"]:未能获取到-医嘱执行科室");
		}
	}
	/**
	 * 校验服务费用详细信息<srv/>
	 * @param i
	 * @param j
	 * @param srvDto
	 * @param msgList
	 */
	private void validateSrv(int i,int j,EmsCommonSrvDTO srvDto,List<String> msgList) {
		if(StringUtils.isEmpty(srvDto.getCode_srv())) {
			msgList.add(ORDER+"["+i+"]"+SRV+"["+j+"]:未能获取到-费用项目编码");
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

}
