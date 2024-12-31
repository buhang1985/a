package iih.ci.ord.s.external.thirdws.op.lis;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisOrdDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisPrintDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EntWsLisDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;
/**
 * 第三方检验医疗单校验
 * @author zhangwq
 *
 */
public class ThirdEmsLisValidate extends OpBaseValidate{

	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		EntWsLisDTO entdto = (EntWsLisDTO) dataSource;
		
		List<EmsLisPrintDTO> printDTOs = entdto.getPrintList();
		//就诊信息校验
		checkEmpty(entdto.getCode_org(),"所属组织",rstDTO);
		checkEmpty(entdto.getCode_pat(),"患者",rstDTO);
		checkEmpty(entdto.getCode_entp(),"就诊类型编码",rstDTO);
		checkEmpty(entdto.getCode_dep_phy(),"当前就诊科室",rstDTO);
		checkEmpty(entdto.getCode_emp_phy(),"当前主管医生",rstDTO);
		//打印信息校验
		for (EmsLisPrintDTO emsLisPrintDTO : printDTOs) {		
			checkEmpty(emsLisPrintDTO.getCode_app(),"申请单打印号",rstDTO);
			checkEmpty(emsLisPrintDTO.getAmt_app(),"申请金额",rstDTO);
			
			List<EmsLisOrdDTO> ordList = emsLisPrintDTO.getOrdList();
			//医嘱信息校验
			for (EmsLisOrdDTO emsLisOrdDTO : ordList) {
				checkEmpty(emsLisOrdDTO.getSortno_or(),"医嘱序号",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_or(),"医嘱编码",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_srv_or(),"检验项目编码",rstDTO);
				checkEmpty(emsLisOrdDTO.getName_srv_or(),"检验项目名称",rstDTO);
				checkEmpty(emsLisOrdDTO.getNo_applyform(),"检验申请单号",rstDTO);
				checkEmpty(emsLisOrdDTO.getSd_samptp(),"标本类型",rstDTO);
				checkEmpty(emsLisOrdDTO.getDt_plan(),"计划检验日期",rstDTO);
				checkEmpty(emsLisOrdDTO.getQuan_medu_or(),"单次数量",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_org_or(),"开立机构",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_dep_or(),"开立部门",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_emp_or(),"开立医生",rstDTO);
				checkEmpty(emsLisOrdDTO.getDt_entry_or(),"开立日期",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_org_mp_or(),"医嘱执行机构",rstDTO);
				checkEmpty(emsLisOrdDTO.getCode_dep_mp_or(),"医嘱执行科室",rstDTO);
				//费用信息校验
				List<EmsCommonSrvDTO> srvList = emsLisOrdDTO.getSrvList();
				for (EmsCommonSrvDTO emsCommonSrvDTO : srvList) {
					checkEmpty(emsCommonSrvDTO.getCode_srv(),"费用项目编码",rstDTO);
					checkEmpty(emsCommonSrvDTO.getQuan_medu_srv(),"费用项目单次数量",rstDTO);
					checkEmpty(emsCommonSrvDTO.getPri(),"单价",rstDTO);
					checkEmpty(emsCommonSrvDTO.getPri_std(),"标准价",rstDTO);
					checkEmpty(emsCommonSrvDTO.getPri_ratio(),"价格系数",rstDTO);
					checkEmpty(emsCommonSrvDTO.getCode_org_mp_srv(),"费用执行机构",rstDTO);
					checkEmpty(emsCommonSrvDTO.getCode_dep_mp_srv(),"费用执行科室",rstDTO);	
				}
			}
		}
		return rstDTO;
	}
	
}
