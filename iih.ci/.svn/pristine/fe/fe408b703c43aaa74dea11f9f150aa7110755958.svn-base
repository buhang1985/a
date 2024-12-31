package iih.ci.event.ord.utils;

import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.IOrdEventParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class OrdEventParamDTO {

	//门诊
	private String OP;//普通门诊
	private String FLOW;//急诊流水
	private String FSTAID;//急诊抢救
	
	//住院
	private String OBS;//急诊留观
	private String IP;//普通住院
	public OrdEventParamDTO() {
		setCodeEntpParam();
	}
	/**
	 * 设置就诊参数根据自定义编码传的值
	 */
	public void setCodeEntpParam() {
		OrdEventLogger.info(CommonParamBP.class.getSimpleName(), "集成平台获取自定义就诊类别参数");
		String codeEnptParams = null;
		try {
			codeEnptParams = ParamsetQryUtil.getParaString(Context.get().getOrgId(), IOrdEventParams.SYS_PARAM_EVENT_CODE_ENTP);
		} catch (BizException e) {//有异常 设置默认值
			this.OP = OrdEventUtil.OP_XML;
			this.FLOW = OrdEventUtil.LS_XML;
			this.FSTAID = OrdEventUtil.QJ_XML;
			this.OBS = OrdEventUtil.LG_XML;
			this.IP = OrdEventUtil.IP_XML;
			OrdEventLogger.info(CommonParamBP.class.getSimpleName(), "集成平台获取自定义就诊类别参数异常："+e.toString());
		}
		if(!OrdEventUtil.isEmpty(codeEnptParams)) {
			OrdEventLogger.info(CommonParamBP.class.getSimpleName(), codeEnptParams.toString());
			String[] codeEntpArr = codeEnptParams.split(OrdEventUtil.COMMA_STR);
			if(!OrdEventUtil.isEmpty(codeEntpArr)) {
				try {
					this.OP = OrdEventUtil.isEmpty(codeEntpArr[0])?null:codeEntpArr[0].toString();
					this.FLOW = OrdEventUtil.isEmpty(codeEntpArr[1])?null:codeEntpArr[1].toString();
					this.FSTAID = OrdEventUtil.isEmpty(codeEntpArr[2])?null:codeEntpArr[2].toString();
					this.OBS = OrdEventUtil.isEmpty(codeEntpArr[3])?null:codeEntpArr[3].toString();
					this.IP = OrdEventUtil.isEmpty(codeEntpArr[4])?null:codeEntpArr[4].toString();
				} catch (Exception e) {
					;
				}
			}
		}
	}
	public String getOP() {
		return OP;
	}
	public void setOP(String oP) {
		OP = oP;
	}
	public String getFLOW() {
		return FLOW;
	}
	public void setFLOW(String fLOW) {
		FLOW = fLOW;
	}
	public String getFSTAID() {
		return FSTAID;
	}
	public void setFSTAID(String fSTAID) {
		FSTAID = fSTAID;
	}
	public String getOBS() {
		return OBS;
	}
	public void setOBS(String oBS) {
		OBS = oBS;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
}
