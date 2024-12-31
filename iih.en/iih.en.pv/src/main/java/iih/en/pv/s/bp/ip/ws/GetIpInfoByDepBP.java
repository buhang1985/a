package iih.en.pv.s.bp.ip.ws;
import iih.en.comm.IEnConst;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.request.GetIpInfoRequestBean;
import iih.en.pv.s.bp.ip.ws.param.GetIpInfoParam;
import xap.mw.core.data.BizException;

/**
 * 查询病区和科室 住院患者信息
 *      
 * @author liubin
 *
 */
public class GetIpInfoByDepBP extends AbstractGetIpInfoBP{
    /**
     * 组装入参和参数校验
     * 
     * @param param
     * @return
     */
	@Override
	protected GetIpInfoParam assemlyInParam(GetIpInfoRequestBean param) throws BizException {
    	GetIpInfoParam inParam = new GetIpInfoParam();
    	if(param == null)
    		throw new BizException("GetIpInfoByDep入参解析错误！");
    	inParam.setCode_dep(param.getDeptCode());
    	inParam.setCode_nur(param.getNurCode());
    	inParam.setDt_acpt_b(DateTimeUtils.convertToFDate(param.getDate_b_in()));
    	inParam.setDt_acpt_e(DateTimeUtils.convertToFDate(param.getDate_e_in()));
    	inParam.setDt_end_b(DateTimeUtils.convertToFDate(param.getDate_b_out()));
    	inParam.setDt_end_e(DateTimeUtils.convertToFDate(param.getDate_e_out()));
    	if(EnValidator.isEmpty(param.getStatus()))
    		throw new BizException("查询状态Status不能为空");
    	if(!IEnConst.STATUS_INHOS.equals(param.getStatus())
    			&& !IEnConst.STATUS_OUTHOS.equals(param.getStatus())
    			&& !IEnConst.STATUS_HOSPITALIN.equals(param.getStatus()))
    		throw new BizException("查询状态Status错误[1-在院;2-出院;3-入院登记和在院]！");
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
		EnLogUtil.getInstance().logInfo("方法GetIpInfoByDep入参 :" + requestXML);
	}
}
