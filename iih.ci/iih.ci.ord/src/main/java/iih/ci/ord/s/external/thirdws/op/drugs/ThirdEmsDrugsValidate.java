package iih.ci.ord.s.external.thirdws.op.drugs;

import java.util.List;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsOrdDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsPresDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EntWsDrugsDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;

public class ThirdEmsDrugsValidate extends OpBaseValidate{

	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		EntWsDrugsDTO entdto = (EntWsDrugsDTO) dataSource;
		//就诊信息校验
		checkEmpty(entdto.getCode_org(),"所属组织",rstDTO);
		checkEmpty(entdto.getCode_pat(),"患者",rstDTO);
		checkEmpty(entdto.getCode_entp(),"就诊类型编码",rstDTO);
		checkEmpty(entdto.getCode_dep_phy(),"当前就诊科室",rstDTO);
		checkEmpty(entdto.getCode_emp_phy(),"当前主管医生",rstDTO);
		//处方信息校验
		List<EmsDrugsPresDTO> prelist = entdto.getPresList();
		for (EmsDrugsPresDTO emsDrugsPresDTO : prelist) {
			checkEmpty( emsDrugsPresDTO.getCode_pres(), "处方号",rstDTO);
			checkEmpty( emsDrugsPresDTO.getCodes_diag(), "临床诊断编码",rstDTO);
			checkEmpty( emsDrugsPresDTO.getNames_diag(), "临床诊断名称",rstDTO);
			checkEmpty( emsDrugsPresDTO.getSd_prestp(), "处方类型",rstDTO);
			
			//医嘱校验
			List<EmsDrugsOrdDTO> ordList = emsDrugsPresDTO.getOrdList();
			for (EmsDrugsOrdDTO emsDrugsOrdDTO : ordList) {
				checkEmpty( emsDrugsOrdDTO.getSortno_or(), "医嘱序号",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getCode_or(), "医嘱编码",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getCode_org_or(), "开立机构",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getCode_dep_or(), "开立部门",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getCode_emp_or(), "开立医生",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getDt_entry_or(), "开立日期",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getCode_org_mp_or(), "医嘱执行机构",rstDTO);
				checkEmpty( emsDrugsOrdDTO.getCode_dep_mp_or(), "医嘱执行科室",rstDTO);
				
				List<EmsCommonSrvDTO> srvList = emsDrugsOrdDTO.getSrvList();
				for (EmsCommonSrvDTO emsCommonSrvDTO : srvList) {
					checkEmpty( emsCommonSrvDTO.getSortno_srv(), "序号",rstDTO);
					checkEmpty( emsCommonSrvDTO.getFg_or(), "药品/费用标识",rstDTO);
					checkEmpty( emsCommonSrvDTO.getCode_mm(), "药品/费用项目编码",rstDTO);
					checkEmpty( emsCommonSrvDTO.getName_mm(), "药品/费用项目名称",rstDTO);
					checkEmpty( emsCommonSrvDTO.getQuan_medu_cur(), "界面录入单次用量",rstDTO);
					checkEmpty( emsCommonSrvDTO.getCode_medu_cur(), "界面录入单次用量单位",rstDTO);
					checkEmpty( emsCommonSrvDTO.getFactor_cur(), "界面录入单次用量单位和基本包装单位换算系数",rstDTO);
					checkEmpty( emsCommonSrvDTO.getQuan_cur(), "总量",rstDTO);
					checkEmpty( emsCommonSrvDTO.getCode_pgku_cur(), "总量单位",rstDTO);
					checkEmpty( emsCommonSrvDTO.getFactor_pgku_cur(), "总量单位换算系数",rstDTO);
					checkEmpty( emsCommonSrvDTO.getPri(), "单价",rstDTO);
					checkEmpty( emsCommonSrvDTO.getPri_std(), "标准价",rstDTO);
					checkEmpty( emsCommonSrvDTO.getPri_ratio(), "价格系数",rstDTO);
					checkEmpty( emsCommonSrvDTO.getCode_org_mp_srv(), "项目执行机构",rstDTO);
					checkEmpty( emsCommonSrvDTO.getCode_dep_mp_srv(), "项目执行科室",rstDTO);
				}
			}
		}
		
		return rstDTO;
	}

}
