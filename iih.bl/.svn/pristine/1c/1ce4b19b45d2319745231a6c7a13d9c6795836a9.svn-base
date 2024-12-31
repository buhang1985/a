package iih.bl.comm.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.utils.WsXmlUtils;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.util.BlAdivceConvertUtil;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.wxpublic.WsParamWxPublic;
import iih.bl.itf.std.bean.input.wxpublic.sub.WsParamWxPublicPatient;
import iih.bl.itf.std.bean.output.wxpublic.WsResultWxPublic;
import iih.bl.params.BlSmsConst;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pis.ivx.i.IPisivxApiService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 费用发送微信通知类
 * @author zhangxin
 * @date 2019年11月6日
 */
public class BlSendWXPublicMsgBP {
	/**
	 * 设置消息传输dto
	 * 
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public WsParamWxPublic setBlSendWxPublicDTO(String id_pat, String id_enttp, FDouble amt, FDateTime dt_pay,
			String id_ent, String tempcode, int eu_direct) throws BizException {
		WsParamWxPublic wxDto = new WsParamWxPublic();
		WsParamWxPublicPatient patient = new WsParamWxPublicPatient();
		// 获取患者信息
		PatDO patDo = BlAdivceConvertUtil.getPatData(id_pat);
		// 患者id
		patient.setId_pat(patDo.getId_pat());
		// 患者编码
		patient.setCodepat(patDo.getCode());
		// 患者姓名
		patient.setNamepat(patDo.getName());
		EnTypeDO enTypeDO = BlAdivceConvertUtil.getEntpDo(id_enttp);
		// // 如果是住院
		if (IEnDictCodeConst.SD_ENTP_INPATIENT.equals(enTypeDO.getCode()) && id_ent != null) {
			// 查询住院号
			IInpatientRService inpatint = ServiceFinder.find(IInpatientRService.class);
			InpatientDO[] inpatientDOs = inpatint.findByAttrValString(InpatientDO.ID_ENT, id_ent);
			if (!ArrayUtil.isEmpty(inpatientDOs)) {
				patient.setIpcode(inpatientDOs[0].getCode_amr_ip());
			}
		}
		patient.setTemplcode(tempcode);
		List<String> param = new ArrayList<>();

		if (BlSmsConst.BL_ACC_PREPAY_MSG.equals(tempcode)) {
			param.add(enTypeDO.getName() + "预交金");
		} else if (BlSmsConst.BL_OP_CHARGE_MSG.equals(tempcode)) {
			param.add("门诊收费");
		} else if (BlSmsConst.BL_OP_REFUND_MSG.equals(tempcode)) {
			param.add("门诊退费");
		}
		String eudirect = BlAdivceConvertUtil.getFeeEudirect(eu_direct);
		// 收费或者退费
		param.add(eudirect);
		// 金额
		param.add(amt.toString());
		// 时间
		param.add(dt_pay.toStdString());

		wxDto.setPatient(patient);
		wxDto.setInfo(param);
		return wxDto;
	}
	


	/**
	 * 发生微信公众号通知
	 * @param patCode 患者编码
	 * @param msgCode 消息编码
	 * @param smsDto  内容dto
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(WsParamWxPublic wsParanWxPublic) throws BizException {
		//校验
		this.validator(wsParanWxPublic);
		//调用微信公众号接口发送 模板消息
		IPisivxApiService apiService = ServiceFinder.find(IPisivxApiService.class);
		String xml= WsXmlUtils.serialize(wsParanWxPublic);
		BLThirdItfLogger.info("发生微信公众号通知 调用入参  "+xml);
		String sentTmplMsg = apiService.sentTmplMsg(xml);
		BLThirdItfLogger.info("发生微信公众号通知 返回出参  "+sentTmplMsg);
		//反序列化返回值 
		WsResultWxPublic wsResultWxPublic = WsXmlUtils.deSerializeBaseDO(sentTmplMsg, WsResultWxPublic.class);
		//返回成功 则返回true
		if(wsResultWxPublic!=null&&IBlWsConst.RLT_SUCCESS.equals(wsResultWxPublic.getSuscess())){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
    /**
     * 校验入参
     * @param wsParanWxPublic
     * @throws BizException
     */
	private void validator(WsParamWxPublic wsParanWxPublic) throws BizException {
		if(wsParanWxPublic==null){
			throw new BizException("发生微信公众号通知 入参dto为空");
		}
		if(wsParanWxPublic.getPatient()==null||StringUtil.isEmpty(wsParanWxPublic.getPatient().getCodepat())){
			throw new BizException("发生微信公众号通知 患者信息或者编码为空");
		}
		if(StringUtil.isEmpty(wsParanWxPublic.getPatient().getTemplcode())){
			throw new BizException("发生微信公众号通知  模板编号为空");
		}
		if(ListUtil.isEmpty(wsParanWxPublic.getInfo())){
			throw new BizException("发生微信公众号通知 模板内容为空");
		}
		
	}
	
}
