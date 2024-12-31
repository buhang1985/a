package iih.ci.ord.s.external.thirdws.op.opr;

import java.util.List;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprOrdDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EntWsOprDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;
/**
 * 第三方手术医疗单校验
 * @author zhangwq
 *
 */
public class ThirdEmsOprValidate extends OpBaseValidate {

	@Override
	public EmsValidateRstDTO validate(EntWsDTO entWs) {
		
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		EntWsOprDTO entWsOpr = (EntWsOprDTO) entWs;
		
		
		//就诊信息校验
		checkEmpty(entWsOpr.getCode_org(),"所属组织",rstDTO);
		checkEmpty(entWsOpr.getCode_pat(),"患者",rstDTO);
		checkEmpty(entWsOpr.getCode_entp(),"就诊类型编码",rstDTO);
		checkEmpty(entWsOpr.getCode_dep_phy(),"当前就诊科室",rstDTO);
		checkEmpty(entWsOpr.getCode_emp_phy(),"当前主管医生",rstDTO);
		//打印信息校验
		List<EmsOprOrdDTO> ordList = entWsOpr.getOrdList();
		
		
		//医嘱信息校验
		for (EmsOprOrdDTO oprOrd : ordList) {
			checkEmpty(oprOrd.getSortno_or(),"医嘱序号",rstDTO);
			checkEmpty(oprOrd.getCode_or(),"医嘱编码",rstDTO);
			
			checkEmpty(oprOrd.getCode_srv_or(),"手术项目编码",rstDTO);
			checkEmpty(oprOrd.getName_srv_or(),"手术项目名称",rstDTO);
			checkEmpty(oprOrd.getNo_applyform(),"手术申请单号",rstDTO);
			checkEmpty(oprOrd.getCode_emp_operate(),"主刀医生",rstDTO);
			checkEmpty(oprOrd.getCode_emp_helper(),"第一助手",rstDTO);
			checkEmpty(oprOrd.getDt_plan(),"计划手术时间",rstDTO);
			checkEmpty(oprOrd.getSd_anestp(),"麻醉方法",rstDTO);
			
			checkEmpty(oprOrd.getCode_org_or(),"开立机构",rstDTO);
			checkEmpty(oprOrd.getCode_dep_or(),"开立部门",rstDTO);
			checkEmpty(oprOrd.getCode_emp_or(),"开立医生",rstDTO);
			checkEmpty(oprOrd.getDt_entry_or(),"开立日期",rstDTO);
			checkEmpty(oprOrd.getCode_org_mp_or(),"医嘱执行机构",rstDTO);
			checkEmpty(oprOrd.getCode_dep_mp_or(),"医嘱执行科室",rstDTO);
			//费用信息校验
			List<EmsCommonSrvDTO> srvList = oprOrd.getSrvList();
			for (EmsCommonSrvDTO emsCommonSrvDTO : srvList) {
				checkEmpty(emsCommonSrvDTO.getCode_srv(),"费用项目编码",rstDTO);
				checkEmpty(emsCommonSrvDTO.getName_srv(),"费用项目名称",rstDTO);
				checkEmpty(emsCommonSrvDTO.getQuan_medu_srv(),"费用项目单次数量",rstDTO);
				checkEmpty(emsCommonSrvDTO.getPri(),"单价",rstDTO);
				checkEmpty(emsCommonSrvDTO.getPri_std(),"标准价",rstDTO);
				checkEmpty(emsCommonSrvDTO.getPri_ratio(),"价格系数",rstDTO);
				checkEmpty(emsCommonSrvDTO.getCode_org_mp_srv(),"费用执行机构",rstDTO);
				checkEmpty(emsCommonSrvDTO.getCode_dep_mp_srv(),"费用执行科室",rstDTO);	
			}
		}
	
		return rstDTO;
	}
	
}
