package iih.bl.cg.s.bp;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bl.comm.IBlMsgConst;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断是否可以使用预交金
 * 默认支持预交金
 * 北京市医保不支持预交金，高端商保记账，不支持预交金
 * 
 * @author yankan
 * @since 2017-06-22
 *
 */
public class CanUsePrepayBP {
	/**
	 * 判断是否可以使用预交金
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型,参见：iih.bl.pay.prepay.d.EuPrepayBizType
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	public FBoolean exec(String patId, String entId, String bizType) throws BizException {
		// 参数校验
		ParamValidator.validateNotNull("患者ID", patId);
		ParamValidator.validateNotNull("就诊ID", entId);

		// 获取就诊医保信息
		HPDO hpDO = this.getEntHp(entId);
		if (hpDO != null) {
			if (IBdPpCodeTypeConst.SD_HP_BJ.equals(hpDO.getCode())) {
				return FBoolean.FALSE;//北京市医保不支持预交金
			} else if (FBoolean.TRUE.equals(hpDO.getFg_hpcg())) {
				return FBoolean.FALSE;//高端商保记账，不支持预交金
			}
		}

		return FBoolean.TRUE;
	}

	/**
	 * 获取就诊医保信息
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	private HPDO getEntHp(String entId) throws BizException {
		// 获取就诊信息
		PatiVisitDO pvDO = this.getEntInfo(entId);
		if (pvDO == null) {
			throw new BizException(IBlMsgConst.ERROR_ENT_NOT_EXIST);
		}
		String hpId = pvDO.getId_hp();
		if (StringUtil.isEmpty(hpId)) {
			return null;
		}
		IHpMDORService hpRService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpDO = hpRService.findById(hpId);
		return hpDO;
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEntInfo(String entId) throws BizException {
		IEnOutQryService enQryService = ServiceFinder.find(IEnOutQryService.class);
		PatiVisitDO pvDO = enQryService.getEnInfo(entId);
		return pvDO;
	}
}
