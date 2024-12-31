package iih.ci.event.ord.reissue.action;

import iih.ci.event.i.reissue.IDeSerializeParamService;
import iih.ci.event.i.reissue.IReissueValidate;
import iih.ci.event.ord.reissue.common.ReissueDataAction;
import iih.ci.event.ord.reissue.common.ReissueRstXmlUtils;
import iih.ci.event.ord.reissue.validate.ReissueValidateImpl;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
import xap.mw.core.data.BizException;

public class ReissueAction {
	private IDeSerializeParamService deSerializeService;
	private IReissueValidate validateSerivce;
	public ReissueAction(){
		deSerializeService = new DeSerializeParamAction();
		validateSerivce = new ReissueValidateImpl();
	}
	public String exec(String xml) throws BizException{
		//将xml文件解析成dto
		IEMsgReissueDTO reissuedto = (IEMsgReissueDTO)deSerializeService.deserialize(xml);
		//校验入参
		if(validateSerivce != null){
			String errorInfo = validateSerivce.validate(reissuedto);
			if(!errorInfo.isEmpty()){
				return ReissueRstXmlUtils.ErrorMsg(errorInfo);
			}
		}
		//组装数据
		ReissueDataAction reissuedata = new ReissueDataAction();
		return ReissueRstXmlUtils.getRstMsg(reissuedata.asseble(reissuedto));
	}
}
