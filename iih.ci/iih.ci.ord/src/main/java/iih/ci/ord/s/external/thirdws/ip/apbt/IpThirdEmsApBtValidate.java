package iih.ci.ord.s.external.thirdws.ip.apbt;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtentDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtordDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.base.StringList;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.external.thirdws.ip.base.EntInfoUtils;
import iih.ci.ord.s.external.thirdws.ip.base.IpBaseValidate;
import xap.mw.core.data.BizException;

public class IpThirdEmsApBtValidate extends IpBaseValidate{
	
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

		List<EmsapbtordDTO> ordList=entDTO.getOrdList();
		if(CiOrdUtils.isEmpty(ordList)) {
			msgList.add(":未能获取到-医嘱信息");
			validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
			validateRstDTO.setMsgInfoList(msgList);
			return validateRstDTO;//医嘱为空 直接反  无需后面校验
		}
		if(StringUtils.isEmpty(dataSource.getCode_en())) {
			if(StringUtils.isEmpty(dataSource.getTimes_en())||StringUtils.isEmpty(dataSource.getCode_pat())) {
				msgList.add("就诊编码和就诊次数不能同时为空！");
				validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
				validateRstDTO.setMsgInfoList(msgList);
				return validateRstDTO;//医嘱为空 直接反  无需后面校验
			}else {
				String code_en=null;
				try {
					code_en=EntInfoUtils.getipent(dataSource.getCode_pat(), dataSource.getTimes_en());
				} catch (BizException e) {
					// TODO Auto-generated catch block

				}
				if(StringUtils.isEmpty(code_en)) {
					msgList.add("未查询到就诊信息！");
					validateRstDTO.setLevel(EmsValidateRstDTO.ERROR);
					validateRstDTO.setMsgInfoList(msgList);
					return validateRstDTO;//
				}
				dataSource.setCode_en(code_en);
			}
			
		}
		return null;
	}

}
