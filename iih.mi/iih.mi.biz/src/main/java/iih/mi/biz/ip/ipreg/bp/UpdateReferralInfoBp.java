package iih.mi.biz.ip.ipreg.bp;

import iih.mi.biz.dto.d.ReferralVsPatInfoDTO;
import iih.mi.biz.mireferralinfo.d.MiReferralDO;
import iih.mi.biz.mireferralinfo.i.IMireferralinfoRService;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 更新转诊单信息
 * @author yangyang
 * @date 2018-02-01
 */
public class UpdateReferralInfoBp{
	public FBoolean exec(ReferralVsPatInfoDTO referralinfo) throws BizException
	{
		validateParam(referralinfo);
		IMireferralinfoRService referralRservice=ServiceFinder.find(IMireferralinfoRService.class);
		MiReferralDO[] miReferralDoarr=referralRservice.findByAttrValString(MiReferralDO.REFERRALCODE, referralinfo.getReferralcode());
		if(ArrayUtils.isEmpty(miReferralDoarr))
		{
			throw new BizException("未找到医保转诊单下载！");
		}
		MiReferralDO referralDo=miReferralDoarr[0];
		return null;
	}
	
	private void validateParam(ReferralVsPatInfoDTO referralinfo) throws BizException
	{
		if(referralinfo==null || StringUtil.isEmpty(referralinfo.getReferralcode()))
		{
			throw new BizException("入参输入有问题，未找到转诊单编码！");
		}
		if(StringUtil.isEmpty(referralinfo.getId_pat()))
		{
			throw new BizException("入参输入有问题，未找到患者编码！");
		}
		if(StringUtil.isEmpty(referralinfo.getId_ent()))
		{
			throw new BizException("入参输入有问题，未找到就诊主键！");
		}
		if(StringUtil.isEmpty(referralinfo.getEnt_code()))
		{
			throw new BizException("入参输入有问题，未找到就诊编码！");
		}
	}
}
