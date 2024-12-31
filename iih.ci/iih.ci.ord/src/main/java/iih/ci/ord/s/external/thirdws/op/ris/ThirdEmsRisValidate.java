package iih.ci.ord.s.external.thirdws.op.ris;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.base.StringList;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisOrdDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisPrintDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisSrvDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EntWsRisDTO;
import iih.ci.ord.s.external.thirdws.base.IValidate;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;
/**
 * 第三方检查好医疗单校验
 * @author zhangwq
 *
 */
public class ThirdEmsRisValidate extends OpBaseValidate {

	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		EntWsRisDTO entWsRisDTO=(EntWsRisDTO)dataSource;
		StringList MsgInfoList =new StringList();
		if(StringUtils.isEmpty(entWsRisDTO.getCode_org())){
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的所属组织不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_pat())) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的患者编码不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_entp())) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的就诊类型编码不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_dep_phy())) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的当前就诊科室不能为空\n");
		}
		if (StringUtils.isEmpty(entWsRisDTO.getCode_emp_phy())) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的当前主管医生不能为空\n");
		}
		List<EmsRisPrintDTO> printList = entWsRisDTO.getPrintList();
		for(int i=0;i<printList.size();i++){
			EmsRisPrintDTO emsRisPrintDTO = printList.get(i);
			if (StringUtils.isEmpty(emsRisPrintDTO.getCode_app())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个打印单据信息中的申请单打印号不能为空\n");
			}
			if (StringUtils.isEmpty(emsRisPrintDTO.getAmt_app())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个打印单据信息中的申请金额不能为空\n");
			}
			List<EmsRisOrdDTO> ordList = emsRisPrintDTO.getOrdList();
			for(int j=0;j<ordList.size();j++){
				EmsRisOrdDTO emsRisOrdDTO = ordList.get(j);
				if (StringUtils.isEmpty(emsRisOrdDTO.getSortno_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的医嘱序号 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的医嘱编码 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_srv_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的检验项目编码 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getName_srv_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的检验项目名称 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getNo_applyform())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的检验申请单号 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getDt_plan())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的计划检查日期不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getSd_pps())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的检查目的 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getQuan_medu_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的单次数量 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_org_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的开立机构 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_dep_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的开立部门 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_emp_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的开立医生 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getDt_entry_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的开立日期 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_org_mp_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的医嘱执行机构 不能为空\n");
				}
				if (StringUtils.isEmpty(emsRisOrdDTO.getCode_dep_mp_or())) {
					rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
					MsgInfoList.add("第"+(j+1)+"个医嘱信息中的医嘱执行科室 不能为空\n");
				}
				List<EmsCommonSrvDTO> srvList = emsRisOrdDTO.getSrvList();
				for(int k=0;k<srvList.size();k++){
					EmsRisSrvDTO srvDTO = (EmsRisSrvDTO) srvList.get(k);
					if (StringUtils.isEmpty(srvDTO.getCode_srv())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的费用项目编码不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getName_srv())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的费用项目名称不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getQuan_medu_srv())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的费用项目单次数量不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getPri())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的单价不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getPri_std())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的标准价不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getPri_ratio())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的价格系数不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getCode_org_mp_srv())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的费用执行机构不能为空\n");
					}
					if (StringUtils.isEmpty(srvDTO.getCode_dep_mp_srv())) {
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(k+1)+"个费用明细中的费用执行科室不能为空\n");
					}
				}
				
			}
		}
		rstDTO.setMsgInfoList(MsgInfoList);
		return rstDTO;
	}

}
