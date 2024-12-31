package iih.en.comm.ep;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.exception.ArgumentNullException;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.i.IEnpecmpyaccCudService;
import iih.en.pv.enfee.i.IEnpecmpyaccRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 团检账户扩展类
 * @author ly 2018/03/26
 *
 */
public class EnPeCmpyAccEP {

	/**
	 * 团检账户充值
	 * 
	 * @param pecmpyId 团检记录id
	 * @param money 金额
	 * @throws BizException
	 * @author ly 2018/03/26
	 */
	public void recharge(String pecmpyId, FDouble money) throws BizException {

		if(EnValidator.isEmpty(pecmpyId)){
			throw new ArgumentNullException("团检账户充值", "团检记录id");
		}
		
		if(money == null){
			throw new ArgumentNullException("团检账户充值", "金额");
		}
		
		EnPeCmpyACCDO acc = this.getPecmpyAcc(pecmpyId);
		if(acc == null){
			throw new BizException(IEnMsgConst.ERROR_PECMPY_ACCOUNT_NOT_EXIST);
		}
		
		if (acc.getAmt_prepay() == null) {
			acc.setAmt_prepay(new FDouble(0));
		}
		acc.setAmt_prepay(acc.getAmt_prepay().add(money));
		IEnpecmpyaccCudService cudService = ServiceFinder.find(IEnpecmpyaccCudService.class);
		cudService.update(new EnPeCmpyACCDO[] { acc });
	}
	
	/**
	 * 团检消费
	 * 
	 * @param pecmpyId 团检记录id
	 * @param money 金额
	 * @throws BizException
	 * @author ly 2018/03/26
	 */
	public void consume(String pecmpyId, FDouble money) throws BizException {
		
		if(EnValidator.isEmpty(pecmpyId)){
			throw new ArgumentNullException("团检账户消费", "团检记录id");
		}
		
		if(money == null){
			throw new ArgumentNullException("团检账户消费", "金额");
		}
		
		EnPeCmpyACCDO acc = this.getPecmpyAcc(pecmpyId);
		if(acc == null){
			throw new BizException(IEnMsgConst.ERROR_PECMPY_ACCOUNT_NOT_EXIST);
		}
		
		if (acc.getAmt_uncg() == null) {
			acc.setAmt_uncg(new FDouble(0));
		}
		
		acc.setAmt_uncg(acc.getAmt_uncg().add(money));
		IEnpecmpyaccCudService cudService = ServiceFinder.find(IEnpecmpyaccCudService.class);
		cudService.update(new EnPeCmpyACCDO[] { acc });
	}

	/**
	 * 获取团检账户
	 * @param pecmpyId
	 * @return
	 * @throws BizException
	 */
	private EnPeCmpyACCDO getPecmpyAcc(String pecmpyId) throws BizException {
		IEnpecmpyaccRService rService = ServiceFinder.find(IEnpecmpyaccRService.class);
		EnPeCmpyACCDO[] accDos = rService.findByAttrValString(EnPeCmpyACCDO.ID_PECMPY, pecmpyId);
		if(EnValidator.isEmpty(accDos))
			return null;
		
		return accDos[0];
	}
}