package iih.en.pv.s.bp.ip.ws;



import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.request.GetIpInfoRequestBean;
import iih.en.pv.s.bp.ip.ws.param.GetIpInfoParam;
import xap.mw.core.data.BizException;
/**
 * 根据患者编码和住院次数查询住院患者信息
 * 
 * @author liubin
 *
 */
public class GetIpInfoByPatBP extends AbstractGetIpInfoBP{

	/**
     * 组装入参和参数校验
     * 
     * @param param
     * @return
     */
	@Override
	protected GetIpInfoParam assemlyInParam(GetIpInfoRequestBean param) throws BizException {
    	if(param == null)
    		throw new BizException("GetIpInfoByPat入参解析错误！");
    	GetIpInfoParam inParam = new GetIpInfoParam();

    	if(EnValidator.isEmpty(param.getPatCode()))
    		throw new BizException("患者编码不能为空!");
    	inParam.setPatCodes(param.getPatCode().split(","));
    	if(!EnValidator.isEmpty(param.getTimes_ip())){
    		try{
        		Integer times_ent = Integer.valueOf(param.getTimes_ip());
        		inParam.setTimes_ent(times_ent);
        	}catch(Exception ex){
        		throw new BizException("就诊次数必须为数字!");
        	}
    	}
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
		EnLogUtil.getInstance().logInfo("方法GetIpInfoByPatBP入参 :" + requestXML);
	}  
}