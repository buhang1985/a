package iih.bl.itf.std.bp.cc;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cc.dto.d.BlCcInParamDTO;
import iih.bl.cc.dto.d.BlCcOutParamDTO;
import iih.bl.cc.service.i.IBLCcMaintainService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.cc.WsParamCc;
import iih.bl.itf.std.bean.input.cc.sub.WsParamCcParam;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.cc.WsResultCc;
import iih.bl.itf.std.bp.BlItfBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 结账
 * 
 * @author shaokx 2020/05/13
 *
 */
public class CloseAccountBP extends BlItfBaseBP<WsParamCc,WsResultCc>{

	private static String[] TMINAL_TYPE_RANGE;//终端类型范围
	private static String[] CC_TYPE_RANGE;//结账类型范围
	
	static{
		TMINAL_TYPE_RANGE = new String[]{IBlDictCodeConst.SD_PTTP_WINDOW, 
				IBlDictCodeConst.SD_PTTP_SELF_TERMINAL,
				IBlDictCodeConst.SD_PTTP_WEIXIN, 
				IBlDictCodeConst.SD_PTTP_PHONE_APP,IBlDictCodeConst.SD_PTTP_H5};
		//00 门诊流程结账，01 门诊挂号结账，02 门诊收费结账，03 门诊预交金结账。10 住院流程结账  11住院预交金结账  12 住院收费结账
		CC_TYPE_RANGE = new String[]{"00","02","03","10","11","12"};
	}
	
	@Override
	protected String getBusiness() {
		
		return "结账";
	}

	@Override
	protected void checkParam(WsParamCc param) throws BizException {
		
		WsParamCcParam inputParam = param.getCcparam();
		
		if(StringUtil.isEmpty(inputParam.getCctime())){
			throw new BizException("结账区间截止时间不能为空");
		}
		
		if(StringUtil.isEmpty(inputParam.getCrossday())){
			throw new BizException("是否跨天不能为空");
		}
		
		if(!"Y".equals(inputParam.getCrossday()) && !"y".equals(inputParam.getCrossday()) && !"N".equals(inputParam.getCrossday()) && !"n".equals(inputParam.getCrossday())){
			throw new BizException("是否跨天值不正确");
		}
		
//		if(StringUtil.isEmpty(inputParam.getPttp())){
//			throw new BizException("终端类型编码不能为空");
//		}
//		
//		if(!this.checkTerminalType(inputParam.getPttp())){
//			throw new BizException("终端类型编码值不正确");
//		}
		
		if(StringUtil.isEmpty(inputParam.getCctp())){
			throw new BizException("结账类型编码不能为空");
		}
		
		if(!this.checkCcType(inputParam.getCctp())){
			throw new BizException("结账类型编码值不正确");
		}
		
		if(StringUtil.isEmpty(inputParam.getIdorg())){
			throw new BizException("组织id不能为空");
		}
		
		if(StringUtil.isEmpty(inputParam.getIdgrp())){
			throw new BizException("集团id不能为空");
		}
		
		if(!StringUtil.isEmpty(inputParam.getCreateblcc())){
			if(!"Y".equals(inputParam.getCreateblcc()) && !"y".equals(inputParam.getCreateblcc()) && !"N".equals(inputParam.getCreateblcc()) && !"n".equals(inputParam.getCreateblcc())){
				throw new BizException("若无实际业务数据时，是否产生结账数据值不正确");
			}
		}
		
		if(!StringUtil.isEmpty(inputParam.getBlccpsn())){
			// 设置人员上下文
			PsnDocDO psndocDO = super.getPsnInfo(inputParam.getBlccpsn());
			if (psndocDO == null) {
				throw new BizException("结账:未查询到人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}
	}
		
	@Override
	protected WsResultCc doWork(WsParamCc param) throws BizException {
		
		WsParamCcParam inputParam = param.getCcparam();
		
		//组装调用结账接口的入参
		FArrayList psnDocList = new FArrayList();
		psnDocList.add(Context.get().getStuffId());
		
		BlCcInParamDTO ccInParam = new BlCcInParamDTO();
		ccInParam.setCctp(inputParam.getCctp());
		ccInParam.setId_grp(inputParam.getIdgrp());
		ccInParam.setId_org(inputParam.getIdorg());
		ccInParam.setId_psndoc(psnDocList);
		ccInParam.setCrossday_flag(FBoolean.valueOf(inputParam.getCrossday()));
		ccInParam.setCctime(inputParam.getCctime());
		ccInParam.setCreateblcc_flag(StringUtil.isEmpty(inputParam.getCreateblcc()) ? FBoolean.FALSE : FBoolean.valueOf(inputParam.getCreateblcc()));
		
		//调用结账接口(结账接口支持传入多个结账人员进行多次结账，本接口现只传一个)
		IBLCcMaintainService ccService = ServiceFinder.find(IBLCcMaintainService.class);
		BlCcOutParamDTO[] blCcOutParamDTOs = ccService.doBlccCheckout(ccInParam);
		
		//出参赋值
		WsResultCc outParam = new WsResultCc();
		
		WsResultMsg msgRlt = new WsResultMsg();
		
		if(!ArrayUtil.isEmpty(blCcOutParamDTOs)){
			BlCcOutParamDTO outParamDTO = blCcOutParamDTOs[0];
			if(outParamDTO.getResult_flag() != null && outParamDTO.getResult_flag().booleanValue()){
				msgRlt.setCode(IBlWsConst.RLT_SUCCESS);
				msgRlt.setMessage("成功");
			}else{
				msgRlt.setCode(IBlWsConst.RLT_FAIL);
				msgRlt.setMessage(outParamDTO.getErrormsg());
			}
			
		}else{
			msgRlt.setCode(IBlWsConst.RLT_SUCCESS);
			msgRlt.setMessage("成功");
		}
		
		outParam.setRltMsg(msgRlt);
		
		return outParam;
	}
	
	/**
	 * 检测终端类型是否正确
	 * @param value
	 * @return
	 */
	private Boolean checkTerminalType(String value){
		for (String itm : TMINAL_TYPE_RANGE) {
			if(itm.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 检测结账类型是否正确
	 * @return
	 */
	private Boolean checkCcType(String value){
		for (String itm : CC_TYPE_RANGE) {
			if(itm.equals(value)){
				return true;
			}
		}
		return false;
	}
	
}
