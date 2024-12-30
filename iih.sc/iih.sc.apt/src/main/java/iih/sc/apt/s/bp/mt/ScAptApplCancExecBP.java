package iih.sc.apt.s.bp.mt;


import java.util.HashSet;
import java.util.Set;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutCmdService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 提供 给MP域设置-取消执行状态
 * @author yaohl
 * @date 2019/07/05
 */
public class ScAptApplCancExecBP {

	/**
	 * 提供 给MP域设置-取消执行状态
	 * @param ids  医嘱id数组
	 * @param id_emp 操作人员id
	 * @param dt_opera 操作时间
	 * @throws BizException
	 */
	public void exec(String[] idOrs,String id_emp,String dt_canc) throws BizException{
		if(ArrayUtil.isEmpty(idOrs)) return;
		ScAptApplItmDO[] itms = this.getApplItmByIdOr(idOrs);
		Set<String> idsAppl = this.getIdsAppl(itms);
		for (String id_appl : idsAppl) {
			//1.查询预约记录、预约申请记录
			ScAptApplDO scApplDO = this.getScAptAppl(id_appl);//预约申请
			if(scApplDO != null)
			{
				//2.取消执行
				this.CancelAptAppl(scApplDO, id_emp, dt_canc);
				//3.取消预约
				ScAptDO scAptDO = this.getScApt(scApplDO.getId_scapt());//预约记录
				if(scAptDO != null)
				{
					if(!scAptDO.getFg_canc().booleanValue())
					{
						this.CancelScApt(scAptDO,scApplDO);
					}
				}
			}
		}
	}
	
	/**
	 * 获取预约申请记录
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO getScAptAppl(String id_appl) throws BizException
	{
		IScaptapplMDORService scaptapplRService =  ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] dos = scaptapplRService.find(" id_aptappl = '"+ id_appl +"' and fg_canc = 'N' and fg_reg_arv = 'N' and fg_canc_exec = 'N'", "", FBoolean.FALSE);
		if(dos == null || dos.length==0)
		{
			ScLogUtil.getInstance().logError("ScAptApplCancExecBP_未找到预约申请记录,id_appl:" + id_appl);
			return null;
		}
		return dos[0];
	}
	/**
	 * 取消执行 申请单执行标识设置为true
	 * @param scApplDO
	 * @param id_emp_canc
	 * @param dt_canc
	 * @throws BizException
	 */
	private void CancelAptAppl(ScAptApplDO scApplDO, String id_emp_canc, String dt_canc) throws BizException
	{
		if(scApplDO.getFg_canc_exec().booleanValue()){
			return;
		}
		MtAptEP mtAptEP = new MtAptEP();
		// 更新预约申请
		scApplDO.setStatus(DOStatus.UPDATED);
		scApplDO.setFg_canc_exec(FBoolean.TRUE);
		scApplDO.setId_emp_canc(id_emp_canc);
		scApplDO.setDt_canc(new FDateTime(dt_canc));
		mtAptEP.saveAptAppl(new ScAptApplDO[] { scApplDO });
	}
	/**
	 * 获取预约记录
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private ScAptDO getScApt(String id_apt)throws BizException
	{
		ScAptDO aptDO = new AptEP().getById(id_apt);
		if(aptDO != null) return aptDO;
		return null;
	}
	/**
	 * 取消预约
	 * @param scAptDO
	 * @param scApplDO
	 * @throws BizException
	 */
	private void CancelScApt(ScAptDO scAptDO,ScAptApplDO scApplDO)throws BizException
	{
		// 验证预约信息
		this.validateApt(scAptDO);

		// 处理票号
		this.processTick(scApplDO.getId_ent(), scAptDO);
		
		// 更新医嘱申请单状态
		if (scApplDO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_MT)) {
			this.updateOrderStatus(scApplDO.getId_or());
		} else {
			// 回写手术申请单状态
			this.rewriteOptAppStatus(scApplDO.getId_or());
		}
		// 更新预约申请表
		this.updateAptAppl(scApplDO);
	}
	/**
	 * 处理票号
	 *
	 * @param id_ent 就诊id
	 * @param scAptDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processTick(String id_ent,ScAptDO scAptDO) throws BizException {
		if (scAptDO.getFg_payment() == FBoolean.TRUE) {
			// 如果已经结算，直接走退号逻辑,需退钱
			IEnOutCmdService entService = ServiceFinder.find(IEnOutCmdService.class);
			OpAptDTO aptDTO = new OpAptDTO();
			aptDTO.setId_apt(scAptDO.getId_apt());
			aptDTO.setId_ent(id_ent);
			entService.cancEnt(aptDTO);
		} else {
			IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
			ScSchDO scSchDO = service.findById(scAptDO.getId_sch());
			if(scSchDO.getFg_transed().booleanValue()){
				throw new BizException("相关号位数据转移到sc_tickb表中，无法进行退号处理");
			}
			// 退号
			IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
			schService.drawbackTick(scAptDO.getId_tick());
			// 取消预约
			new AptEP().cancApt(null,scAptDO);
		}
	}
	/**
	 * 验证预约信息
	 * 
	 * @param scAptDO
	 * @throws BizException
	 */
	private void validateApt(ScAptDO scAptDO) throws BizException {
		if (scAptDO == null) {
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		}
		// 校验预约状态
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_TAKEN);
		} else if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_CANCELED);
		}
	}
	/**
	 * 更新医嘱状态
	 *
	 * @param mtAppDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateOrderStatus(String id_or) throws BizException {
		ScValidator.validateParam("id_or", id_or);
		new MtAptCiObsOperateBP().rewriteObsStatus(id_or, Boolean.FALSE,null);
	}
	/**
	 * 回写手术申请单状态
	 * @param appDTO
	 * @throws BizException
	 */
	private void rewriteOptAppStatus(String id_or) throws BizException {
		new OptAptCiObsOperateBP().rewriteCancApt(id_or);
	}
	/**
	 * 更新预约申请
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateAptAppl(ScAptApplDO aptApplDO) throws BizException {
		
		// 确认的申请单 改为未确认状态
		if (null == aptApplDO || null == aptApplDO.getFg_comfirm() || aptApplDO.getFg_comfirm().booleanValue()) {
			MtAptEP mtAptEP = new MtAptEP();
			aptApplDO.setStatus(DOStatus.UPDATED);
			aptApplDO.setFg_comfirm(FBoolean.FALSE);
			// 更新预约申请
			mtAptEP.saveAptAppl(new ScAptApplDO[] { aptApplDO });
		}
		return;
	}
	
	/**
	 * 根据医嘱ID获取医嘱DO
	 *
	 * @author yu.b
	 * 
	 * @param id_or 医嘱ID
	 * @return ScAptApplItmDO[]
	 * @throws BizException
	 */
	private ScAptApplItmDO[] getApplItmByIdOr(String[] ids_or) throws BizException {
		if (ArrayUtil.isEmpty(ids_or)) {
			return null;
		}
		IScAptApplItmDORService qryService = ServiceFinder.find(IScAptApplItmDORService.class);
		return qryService.findByAttrValStrings("Id_or", ids_or);
	}
	
	/**
	 * 根据医嘱DO对申请单ID进行去重
	 *
	 * @author yu.b
	 * 
	 * @param ScAptApplItmDO[]
	 * @return Set<String>
	 * @throws BizException
	 */
	private Set<String> getIdsAppl(ScAptApplItmDO[] itms) throws BizException {
		if (ArrayUtil.isEmpty(itms)) {
			return null;
		}
		Set<String> idsAppl = new HashSet<String>();
		for (ScAptApplItmDO itm : itms) {
			idsAppl.add(itm.getId_aptappl());
		}
		return idsAppl;
	}
}
