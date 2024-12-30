package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 设置预约状态BP
 * 
 * @author zhengcm
 * @date 2017-11-13 16:29:42
 *
 */
public class SetAptStatusBP {

	/**
	 * 设置预约状态
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @param sd_status
	 * @throws BizException
	 */
	public void exec(String id_apt, String sd_status) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_apt", id_apt);
		ScValidator.validateParam("sd_status", sd_status);

		// 2、检查状态编码
		this.checkSdStatus(sd_status);

		// 3、更新状态
		this.updateStatus(id_apt, sd_status);

	}

	/**
	 * 更新状态
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @param sd_status
	 * @throws BizException
	 */
	private void updateStatus(String id_apt, String sd_status) throws BizException {
		AptEP aptEP = new AptEP();
		ScAptDO aptDO = aptEP.getById(id_apt);
		if (null == aptDO) {
			return;
		}
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setId_status(this.getStatusId(sd_status));
		aptDO.setSd_status(sd_status);
		aptEP.save(aptDO);
	}

	/**
	 * 获取状态ID
	 *
	 * @author zhengcm
	 * 
	 * @param sd_status
	 * @return
	 * @throws BizException
	 */
	private String getStatusId(String sd_status) throws BizException {
		String id_status = null;
		switch (sd_status) {
		case IScDictCodeConst.SD_APTSTATUS_ORDER:// 预约
			id_status = IScDictCodeConst.ID_APTSTATUS_ORDER;
			break;
		case IScDictCodeConst.SD_APTSTATUS_PAY:// 支付
			id_status = IScDictCodeConst.ID_APTSTATUS_PAY;
			break;
		case IScDictCodeConst.SD_APTSTATUS_FINISH:// 完成
			id_status = IScDictCodeConst.ID_APTSTATUS_FINISH;
			break;
		case IScDictCodeConst.SD_APTSTATUS_CANCEL:// 取消
			id_status = IScDictCodeConst.ID_APTSTATUS_CANCEL;
			break;
		}
		return id_status;
	}

	/**
	 * 检查状态编码
	 *
	 * @author zhengcm
	 * 
	 * @param sd_status
	 * @throws BizException
	 */
	private void checkSdStatus(String sd_status) throws BizException {
		if (!(sd_status.equals(IScDictCodeConst.SD_APTSTATUS_ORDER)
				|| sd_status.equals(IScDictCodeConst.SD_APTSTATUS_PAY)
				|| sd_status.equals(IScDictCodeConst.SD_APTSTATUS_FINISH) || sd_status
					.equals(IScDictCodeConst.SD_APTSTATUS_CANCEL))) {
			throw new BizException("状态编码不正确，请检查！");
		}
	}
}
