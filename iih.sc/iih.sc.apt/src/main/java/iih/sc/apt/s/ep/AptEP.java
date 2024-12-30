package iih.sc.apt.s.ep;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScAptMtDOCudService;
import iih.sc.apt.scapt.i.IScAptMtDORService;
import iih.sc.apt.scapt.i.IScaptCudService;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约扩展类
 * 
 * @author yank
 *
 */
public class AptEP {
	/**
	 * 根据ID获取预约DO
	 * 
	 * @param aptId 预约ID
	 * @return
	 * @throws BizException
	 */
	public ScAptDO getById(String aptId) throws BizException {
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO scAptDO = aptRService.findById(aptId);// 获取预约数据
		return scAptDO;
	}

	/**
	 * 根据where条件查询预约
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScAptDO[] getByWhere(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		return aptRService.find(where, null, FBoolean.FALSE);
	}

	/**
	 * 修改预约支付状态
	 * 
	 * @param aptDO
	 * @throws BizException
	 */
	public void settle(ScAptDO aptDO) throws BizException {
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_PAY); // 状态
		aptDO.setFg_payment(FBoolean.TRUE); // 已支付
		aptDO.setFg_bill(FBoolean.TRUE); // 已记费标志
		aptDO.setStatus(DOStatus.UPDATED);
		this.save(aptDO);
	}

	/**
	 * 取消预约
	 * 
	 * @param aptId 预约id
	 * @throws BizException
	 */
	public void cancApt(String aptId) throws BizException {
		ScAptDO scAptDO = this.getById(aptId);// 获取预约数据
		if (scAptDO == null) {
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		}
		// 1、校验预约状态，暂只校验已取消的。
		// if
		// (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(scAptDO.getSd_status()))
		// {
		// // throw new BizException(IScMsgConst.SC_APT_OP_HAS_TAKEN);
		// } else
		IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = service.findById(scAptDO.getId_sch());
		if(scSchDO.getFg_transed().booleanValue()){
			throw new BizException("相关号位数据转移到sc_tickb表中，无法进行退号处理");
		}
		if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_CANCELED);
		}

		// 2.取消预约
		this.cancApt(null,scAptDO);
	}

	/**
	 * 取消预约
	 * 
	 * @param aptDO 预约DO
	 * @return
	 * @throws BizException
	 */
	public ScAptDO cancApt(MtAppDTO mtAppDTO,ScAptDO aptDO) throws BizException {
		if(mtAppDTO != null){
			ScLogUtil.getInstance().logError("1.【AptEP_进行手术预约记录的取消,开始】sd_sctp_"+aptDO.getSd_sctp()+",患者:"+mtAppDTO.getName_pat()+",预约记录id:"+aptDO.getId_apt()+"申请单id:"+mtAppDTO.getId_apt_appl());
		}else{
			ScLogUtil.getInstance().logError("1.【AptEP_进行手术预约记录的取消,开始】sd_sctp_"+aptDO.getSd_sctp()+",预约记录id:"+aptDO.getId_apt());
		}
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_CANCEL);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_CANCEL);
		aptDO.setFg_canc(FBoolean.TRUE);
		aptDO.setDt_canc(ScAppUtils.getServerDateTime());
		aptDO.setId_emp_canc(ScContextUtils.getPsnId());// 取消 人员为当前登录人员
		if (mtAppDTO != null) {
			aptDO.setNote_canc(mtAppDTO.getNote_canc());// 取消原因
		}
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO = this.save(aptDO);
		if(mtAppDTO != null){
			ScLogUtil.getInstance().logError("2.【AptEP_进行手术预约记录的取消,结束】sd_sctp_"+aptDO.getSd_sctp()+",患者:"+mtAppDTO.getName_pat()+",预约记录id:"+aptDO.getId_apt()+"申请单id:"+mtAppDTO.getId_apt_appl());
		}else{
			ScLogUtil.getInstance().logError("2.【AptEP_进行手术预约记录的取消,结束】sd_sctp_"+aptDO.getSd_sctp()+",预约记录id:"+aptDO.getId_apt());
		}
		return aptDO;
	}

	/**
	 * 保存预约信息
	 * 
	 * @param aptDO 预约DO
	 * @return
	 * @throws BizException
	 */
	public ScAptDO save(ScAptDO aptDO) throws BizException {
		ScAptDO[] aptDOs = this.save(new ScAptDO[] { aptDO });
		return aptDOs[0];
	}

	/**
	 * 保存预约信息
	 * 
	 * @param aptDOs 预约DO数组
	 * @return
	 * @throws BizException
	 */
	public ScAptDO[] save(ScAptDO[] aptDOs) throws BizException {
		IScaptMDOCudService aptCudService = ServiceFinder.find(IScaptMDOCudService.class);
		aptDOs = aptCudService.save(aptDOs);
		return aptDOs;
	}

	/**
	 * 保存预约聚合DO
	 *
	 * @author zhengcm
	 * 
	 * @param aggDOs 预约聚合DO数组
	 * @return 保存后的聚合DO数组
	 * @throws BizException
	 */
	public ScaptAggDO[] save(ScaptAggDO[] aggDOs) throws BizException {
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		IScaptCudService cudSrv = ServiceFinder.find(IScaptCudService.class);
		return cudSrv.save(aggDOs);
	}
	/**
	 * 修改预约完成状态
	 * 
	 * @param aptDO
	 * @throws BizException
	 */
	public ScAptDO finish(ScAptDO aptDO) throws BizException {
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH); // 状态
		aptDO.setFg_canc(FBoolean.FALSE);
		//aptDO.setDt_canc(new FDateTime());
		//aptDO.setId_emp_canc("");// 取消 人员为空
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO = this.save(aptDO);
		return aptDO;
	}
	/**
	 * 修改预约状态为术前确认
	 * 
	 * @param aptDO
	 * @throws BizException
	 */
	public ScAptDO befConf(ScAptDO aptDO) throws BizException {
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_BEF_CONF);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_BEF_CONF); // 状态
		aptDO.setFg_canc(FBoolean.FALSE);
		aptDO.setDt_canc(new FDateTime());
		aptDO.setId_emp_canc("");// 取消 人员为空
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO = this.save(aptDO);
		return aptDO;
	}
	/**
	 * 修改预约为预约状态
	 * 
	 * @param aptDO
	 * @throws BizException
	 */
	public ScAptDO aptStatus(ScAptDO aptDO) throws BizException {
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_ORDER);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_ORDER); // 状态
		aptDO.setFg_canc(FBoolean.FALSE);
		aptDO.setDt_canc(new FDateTime());
		aptDO.setId_emp_canc("");// 取消 人员为空
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO = this.save(aptDO);
		return aptDO;
	}
	/**
	 * 根据where条件查询预约
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author yzh
	 */
	public ScAptMtDO[] getAptMtByWhere(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		IScAptMtDORService aptRService = ServiceFinder.find(IScAptMtDORService.class);
		return aptRService.find(where, null, FBoolean.FALSE);
	}
	/**
	 * 更新医技预约数据
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author yzh
	 */
	public ScAptMtDO save(ScAptMtDO aptmt) throws BizException {
		ScAptMtDO[] aptMtDOs = this.save(new ScAptMtDO[] { aptmt });
		return aptMtDOs[0];
	}
	
	/**
	 * 保存医技预约信息
	 * 
	 * @param aptMtDOs 预约DO数组
	 * @return
	 * @throws BizException
	 */
	public ScAptMtDO[] save(ScAptMtDO[] aptMtDOs) throws BizException {
		IScAptMtDOCudService aptCudService = ServiceFinder.find(IScAptMtDOCudService.class);
		aptMtDOs = aptCudService.save(aptMtDOs);
		return aptMtDOs;
	}
}
