package iih.ci.ord.s.external.thirdws.diag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.base.StringList;
import iih.ci.ord.i.external.thirdws.diag.d.EmsDiagDto;
import iih.ci.ord.i.external.thirdws.diag.d.EntWsDiagDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpBaseValidate;

public class ThirdEmsDiagValidate extends OpBaseValidate {

	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		EntWsDiagDTO entWsDiagDTO =(EntWsDiagDTO)dataSource;
		StringList MsgInfoList =new StringList();
		if(StringUtils.isEmpty(entWsDiagDTO.getCode_org())){
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的所属组织不能为空\n");
		}
		if (StringUtils.isEmpty(entWsDiagDTO.getCode_pat())) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的患者编码不能为空\n");
		}
		if (StringUtils.isEmpty(entWsDiagDTO.getCode_entp())) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
			MsgInfoList.add("就诊信息中的就诊类型编码不能为空\n");
			}
		List<EmsDiagDto> diagList = entWsDiagDTO.getDiagList();
		for(int i=0;i<diagList.size();i++){
			EmsDiagDto emsDiagDto = diagList.get(i);
			if (StringUtils.isEmpty(emsDiagDto.getCode_dep_create())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个诊断信息中的开立医生编码不能为空\n");
			}
			if (StringUtils.isEmpty(emsDiagDto.getDt_create())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个诊断信息中的开立时间不能为空\n");
			}
			if (StringUtils.isEmpty(emsDiagDto.getSortno())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个诊断信息中的序号不能为空\n");
			}
			if (StringUtils.isEmpty(emsDiagDto.getName_didef())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个诊断信息中的诊断编码不能为空\n");
			}
			if (StringUtils.isEmpty(emsDiagDto.getName_didef_syn())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("第"+(i+1)+"个诊断信息中的证候诊断名称不能为空\n");
			}
			
		}
		rstDTO.setMsgInfoList(MsgInfoList);
		return null;
	}
	
	
}
