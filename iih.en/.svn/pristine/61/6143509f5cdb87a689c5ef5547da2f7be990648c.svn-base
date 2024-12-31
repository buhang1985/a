package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.request.GetIpInfoRequestBean;
import iih.en.pv.s.bp.ip.ws.param.GetIpInfoParam;
import xap.mw.core.data.BizException;

/**
 * 根据住院号查询住院患者信息
 * 
 * @author liubin
 *
 */
public class GetIpInfoByIpCodeBP extends AbstractGetIpInfoBP{
	/**
     * 组装入参和参数校验
     * 
     * @param param
     * @return
     */
	@Override
	protected GetIpInfoParam assemlyInParam(GetIpInfoRequestBean param) throws BizException {
		if(param == null)
    		throw new BizException("GetIpInfoByIpCode入参解析错误！");
		GetIpInfoParam inParam = new GetIpInfoParam();
    	if(EnValidator.isEmpty(param.getIpCode()))
    		throw new BizException("患者住院号不能为空!");
    	inParam.setIpCodes(param.getIpCode().split(","));
    	inParam.setStatus(param.getStatus());
    	return inParam;
	} 
	/**
     * 记录入参日志
     * 
     * @param requestXML
     */
	@Override
	protected void log(String requestXML) {
		EnLogUtil.getInstance().logInfo("方法GetIpInfoByIpCodeBP入参 :" + requestXML);
	} 
}