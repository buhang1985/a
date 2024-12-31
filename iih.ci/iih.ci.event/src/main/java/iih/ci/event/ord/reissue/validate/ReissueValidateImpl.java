package iih.ci.event.ord.reissue.validate;

import org.apache.commons.lang.StringUtils;

import iih.ci.event.i.reissue.IReissueValidate;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
/**
 * 消息补发，针对入参的校验
 * @author zhangwq
 *
 */
public class ReissueValidateImpl implements IReissueValidate{

	@Override
	public String validate(IEMsgReissueDTO reissuedto) {
		//校验不能为空的数据 msgId orderExamOrLab serviceId visitTypeCode visitOrdNo patientLid encounterCardNo hospitalCode
		StringBuilder errMsg = new StringBuilder();
		if (StringUtils.isEmpty(reissuedto.getOrdertype())) {
			errMsg.append("入参中医嘱小分类不可为空！");
		} else if (StringUtils.isEmpty(reissuedto.getOrderexamorlab())) {
			errMsg.append("入参中医嘱补发类型不可为空！");
		} else if (StringUtils.isEmpty(reissuedto.getVisittypecode())) {
			errMsg.append("入参中医嘱就诊类型不可为空！");
		}
		return errMsg.toString();
	}

}
