package iih.en.comm.ep;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊账户扩展
 * 
 * @author yank
 */
public class EnAccEP {
	/**
	 * 消费 消费可以出现正负，这里不再判定，如有限制，调用者处理，2015-12-24 tgq,yankan
	 * 
	 * @param entId 就诊id
	 * @param money 金额
	 * @throws BizException
	 */
	public void consume(String entId, FDouble money) throws BizException {
		EnAccountDO accountDO = this.getAccByEntId(entId);
		if (accountDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ACCOUNT_NOT_EXIST);
		}

		accountDO.setAmt_uncg(accountDO.getAmt_uncg().add(money));
		IEnaccountMDOCudService enaccCrudService = ServiceFinder.find(IEnaccountMDOCudService.class);
		enaccCrudService.update(new EnAccountDO[] { accountDO });
	}

	/**
	 * 充值 （预交金可能退，这里也不限定正值，调用者验证处理）
	 * 
	 * @param entId 就诊id
	 * @param money 金额
	 * @throws BizException
	 */
	public void recharge(String entId, FDouble money) throws BizException {
		EnAccountDO accountDO = this.getAccByEntId(entId);
		if (accountDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ACCOUNT_NOT_EXIST);
		}

		if (accountDO.getAmt_prepay() == null) {
			accountDO.setAmt_prepay(new FDouble(0));// 预交金为null，则置为0
		}

		// 充值
		accountDO.setAmt_prepay(accountDO.getAmt_prepay().add(money));
		IEnaccountMDOCudService enaccCrudService = ServiceFinder.find(IEnaccountMDOCudService.class);
		enaccCrudService.update(new EnAccountDO[] { accountDO });
	}

	/**
	 * 获取账户余额 余额=（预交金+信用额度）- 就诊未结算费用
	 * 
	 * @param accountDO 就诊账户DO
	 * @return 余额
	 * @throws BizException
	 */
	private FDouble getBalance(EnAccountDO accountDO) throws BizException {
		if (accountDO == null)
			throw new BizException("账户对象为空");
		// 余额=（预交金+信用额度）- 就诊未结算费用
		FDouble balance = accountDO.getAmt_prepay().add(accountDO.getAmt_cred()).sub(accountDO.getAmt_uncg());
		return balance;
	}

	/**
	 * 检查是否有就诊账户
	 * 
	 * @param entId 就诊id
	 * @return
	 */
	public EnAccountDO getAccByEntId(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		IEnaccountMDORService accRService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] enAccArray = accRService.findByAttrValString(EnAccountDO.ID_ENT, entId);
		if (!EnValidator.isEmpty(enAccArray)) {
			return enAccArray[0];
		}
		return null;
	}

	/**
	 * 获取就诊账户
	 * 
	 * @param entIds 就诊id集合
	 * @return 就诊账户集合
	 * @throws BizException
	 */
	public EnAccountDO[] getEnAccList(String[] entIds) throws BizException {
		if (EnValidator.isEmpty(entIds))
			return null;
		IEnaccountMDORService enaccRService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] accountDOs = enaccRService.findByAttrValStrings(EnAccountDO.ID_ENT, entIds);
		return accountDOs;
	}

	/**
	 * 登录患者就诊账户数据
	 * 
	 * @param entid
	 * @param patId
	 * @param dateTime//登记时间
	 * @param patCretID//患者信用分类
	 * @throws BizException
	 */

	public void saveEnAccData(String patId, String entid, FDateTime dateTime, String patCretID) throws BizException {
		EnAccEP enaccep = new EnAccEP();
		EnAccountDO enAccountDO = enaccep.getAccByEntId(entid);
		if (enAccountDO != null)
			return;
		enAccountDO = new EnAccountDO();
		enAccountDO.setStatus(DOStatus.NEW);
		enAccountDO.setId_ent(entid);
		enAccountDO.setId_pat(patId);
		enAccountDO.setAmt_cred(FDouble.ZERO_DBL);//信用额度
		enAccountDO.setAmt_prepay(FDouble.ZERO_DBL);
		enAccountDO.setAmt_uncg(FDouble.ZERO_DBL);
		enAccountDO.setAmt_owelimit(FDouble.ZERO_DBL);
		enAccountDO.setDt_backcg(dateTime);// 记录入院时间，给定一个默认值
		enAccountDO.setFg_freeze(FBoolean.FALSE);
		enAccountDO.setId_org(EnContextUtils.getOrgId());
		enAccountDO.setId_grp(EnContextUtils.getGrpId());
		enAccountDO.setAmt_hp(FDouble.ZERO_DBL);
		enAccountDO.setAmt_total(FDouble.ZERO_DBL);
		IEnaccountMDOCudService enaccCrudService = ServiceFinder.find(IEnaccountMDOCudService.class);
		enaccCrudService.insert(new EnAccountDO[] { enAccountDO });
	}

	/**
	 * 更新就诊账户
	 * 
	 * @param accDOs 就诊账户集合
	 * @throws BizException
	 */
	public void update(EnAccountDO[] accDOs) throws BizException {
		IEnaccountMDOCudService enaccCrudService = ServiceFinder.find(IEnaccountMDOCudService.class);
		enaccCrudService.update(accDOs);
	}
}
