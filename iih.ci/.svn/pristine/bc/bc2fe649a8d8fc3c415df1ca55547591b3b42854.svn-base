package iih.ci.event.ord.bps.zcommon.parambp;

import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventParamDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.mw.core.data.BizException;
/**
 * 参数获取共同BP(用继承好于直接调用，方便以后，
 * 也可以直接new这个类去调，不过不利于扩展，说不定哪天加个别的参数，
 * 这里最好是采用接口，加上设计模式)
 * @author F
 *
 * @date 2019年11月27日下午5:11:37
 *
 * @classpath iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP
 */
public class CommonParamBP {
	
	private OrdEventParamDTO ordEventSqlDTO;
	
	public CommonParamBP(){
		if(OrdEventUtil.isEmpty(ordEventSqlDTO)) {
			ordEventSqlDTO = new OrdEventParamDTO();
		}
	}

	public OrdEventParamDTO getOrdEventSqlDTO() {
		return this.ordEventSqlDTO;
	}

	public void setOrdEventSqlDTO(OrdEventParamDTO ordEventSqlDTO) {
		this.ordEventSqlDTO = ordEventSqlDTO;
	}
	/**
	 * 获取参数映射
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	public String getParamCodeEntp(String codeEntp){
		if(OrdEventUtil.isEmpty(codeEntp)) {
			return null;
		}
		String codeEntpMapping = null;
		switch (codeEntp) {
		case OrdEventUtil.OP:
			codeEntpMapping = ordEventSqlDTO.getOP();
			break;
		case OrdEventUtil.LS:
			codeEntpMapping = ordEventSqlDTO.getFLOW();
			break;
		case OrdEventUtil.QJ:
			codeEntpMapping = ordEventSqlDTO.getFSTAID();
			break;
		case OrdEventUtil.LG:
			codeEntpMapping = ordEventSqlDTO.getOBS();
			break;
			case OrdEventUtil.IP:
			codeEntpMapping = ordEventSqlDTO.getIP();
			break;
		default:
			break;
		}
		OrdEventLogger.info(CommonParamBP.class.getSimpleName(), "查询到的就诊类型编码:"+codeEntp+",映射转换后的自定义配置编码[CIOR0526]:"+codeEntpMapping);
		return codeEntpMapping;
	}
}
