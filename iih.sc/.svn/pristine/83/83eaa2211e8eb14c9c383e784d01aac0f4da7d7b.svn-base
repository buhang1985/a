package iih.sc.apt.s.ep;

import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.desc.ScAptOpDODesc;
import iih.sc.apt.scapt.i.IScAptOpDOCudService;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊预约EP
 * 
 * @author yank
 *
 */
public class AptOpEP {
	/**
	 * 根据预约id获取门诊信息
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public ScAptOpDO getAptOpByAptId(String aptId) throws BizException {
		String whereStr = String.format("%s.id_apt='%s'", ScAptOpDODesc.TABLE_ALIAS_NAME, aptId);
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.find(whereStr, null, FBoolean.TRUE);
		if (ArrayUtil.isEmpty(aptOpDOs)) {
			return null;
		}
		return aptOpDOs[0];
	}
	/**
	 * 根据就诊id获取门诊预约信息
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public ScAptOpDO getAptOpByEntId(String entId) throws BizException {
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.findByAttrValString("Id_en", entId);
		if (ArrayUtil.isEmpty(aptOpDOs)) {
			return null;
		}
		return aptOpDOs[0];
	}
	/**
	 * 预约变就诊
	 * 
	 * @param aptId 预约ID
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	public void setAptToEn(String aptId, String entId) throws BizException {
		ScAptOpDO aptOpDO = this.getAptOpByAptId(aptId);
		if (aptOpDO == null) {
			throw new BizException(IScMsgConst.SC_APT_OP_NOT_EXIST);
		}
		this.setAptToEn(aptOpDO, entId);
	}
	/**
	 * 预约变就诊
	 * 
	 * @param aptOpDO 门诊预约DO
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	public void setAptToEn(ScAptOpDO aptOpDO, String entId) throws BizException {
		aptOpDO.setId_en(entId);// 就诊id
		aptOpDO.setDt_en(ScAppUtils.getServerDateTime());// 就诊时间
		aptOpDO.setFg_en(FBoolean.TRUE);// 就诊标识
		aptOpDO.setStatus(DOStatus.UPDATED);
		IScAptOpDOCudService aptOpCudService = ServiceFinder.find(IScAptOpDOCudService.class);
		aptOpCudService.save(new ScAptOpDO[] { aptOpDO });
	}
	/**
	 * 保存
	 *
	 * @param opAptDO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScAptOpDO save(ScAptOpDO opAptDO) throws BizException {
		if (null == opAptDO) {
			return null;
		}
		// 预约挂号维护服务
		IScAptOpDOCudService cmdService = ServiceFinder.find(IScAptOpDOCudService.class);
		return cmdService.save(new ScAptOpDO[] { opAptDO })[0];
	}
}
