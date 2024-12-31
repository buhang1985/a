package iih.ci.ord.s.external.thirdws.op.treat;
import java.util.List;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EmstreatOrdDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EmstreatSrvDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EntWstreatDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;
/**
 * 第三方治疗医疗单校验
 * @author zhangwq
 *
 */
public class ThirdEmsTreatValidate extends OpBaseValidate {

	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		
		//校验就诊
		EntWstreatDTO entdto = (EntWstreatDTO) dataSource;
		checkEmpty(entdto.getCode_org(),"所属组织",rstDTO);
		checkEmpty(entdto.getCode_pat(),"患者",rstDTO);
		checkEmpty(entdto.getCode_entp(),"就诊类型编码",rstDTO);
		checkEmpty(entdto.getCode_dep_phy(),"当前就诊科室",rstDTO);
		checkEmpty(entdto.getCode_emp_phy(),"当前主管医生",rstDTO);
		
		//校验医嘱
		List<EmstreatOrdDTO> ordList = entdto.getOrdList();
		for (EmstreatOrdDTO emstreatOrdDTO : ordList) {
//			checkEmpty( emstreatOrdDTO.getSortno_or() ,"医嘱序号",rstDTO);
//			checkEmpty( emstreatOrdDTO.getCode_or() ,"医嘱编码",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_srv_or() ,"医嘱项目编码",rstDTO);
			checkEmpty( emstreatOrdDTO.getName_srv_or() ,"医嘱项目名称",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_freq_or() ,"医嘱频次",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_org_or() ,"开立机构",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_dep_or() ,"开立部门",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_emp_or() ,"开立医生",rstDTO);
			checkEmpty( emstreatOrdDTO.getDt_entry_or() ,"开立日期",rstDTO);
			checkEmpty( emstreatOrdDTO.getQuan_medu_or() ,"医嘱单次数量",rstDTO);
			checkEmpty( emstreatOrdDTO.getQuan_cur_or() ,"医嘱总量",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_org_mp_or() ,"医嘱执行机构",rstDTO);
			checkEmpty( emstreatOrdDTO.getCode_dep_mp_or() ,"医嘱执行科室",rstDTO);
			
		//校验服务
		List<EmstreatSrvDTO> srvList = emstreatOrdDTO. getSrvtreatList();
		for (EmstreatSrvDTO emsCommonSrvDTO : srvList) {
			checkEmpty( emsCommonSrvDTO.getCode_srv() ,"费用项目编码",rstDTO);
			checkEmpty( emsCommonSrvDTO.getName_srv() ,"费用项目名称",rstDTO);
			checkEmpty( emsCommonSrvDTO.getCode_freq_srv() ,"费用项目频次",rstDTO);
			checkEmpty( emsCommonSrvDTO.getQuan_medu_srv() ,"费用项目单次数量",rstDTO);
			checkEmpty( emsCommonSrvDTO.getQuan_cur_srv() ,"费用项目总量",rstDTO);
			checkEmpty( emsCommonSrvDTO.getPri() ,"单价",rstDTO);
			checkEmpty( emsCommonSrvDTO.getPri_std() ,"标准价",rstDTO);
			checkEmpty( emsCommonSrvDTO.getPri_ratio() ,"价格系数",rstDTO);
			checkEmpty( emsCommonSrvDTO.getCode_org_mp_srv() ,"费用执行机构",rstDTO);
			checkEmpty( emsCommonSrvDTO.getCode_dep_mp_srv() ,"费用执行科室",rstDTO);
			
		}
		}
		
		return rstDTO;
	}

}
