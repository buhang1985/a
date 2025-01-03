package iih.sc.apt.s.bp.mt;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutCmdService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDOCudService;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消手术/医技预约
 * @author maxy
 * @date 2018年7月11日14:34:10
 */
public class CancScAptApplBP {

	/**
	 * 取消手术/医技预约
	 * @param id_or
	 * @param id_emp_canc
	 * @param dt_canc
	 * @param sd_su_or
	 * @throws BizException
	 */
	public void exec(String id_or, String id_emp_canc, FDateTime dt_canc, String sd_su_or) throws BizException{
		// 1、医技/手术判断
		String sd_sctp = IScDictCodeConst.SD_SCTP_MT;
		//1.查询预约记录明细、
		ScAptApplItmDO applItmDO = this.getAptApplItmByIdOr(id_or);
		if(applItmDO == null){
			sd_sctp = this.getSdScType(id_or);
		}
		if(IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp)){
			// 医技
			this.updateMtApplAndItm(id_or, id_emp_canc, dt_canc, sd_su_or, applItmDO);
		} else {
			// 手术
			this.updateOtApplAndItm(id_or, id_emp_canc, dt_canc, sd_su_or);
		}
	}

	/**
	 * 更新手术申请单相关信息
	 * @param id_or
	 * @param id_emp_canc
	 * @param dt_canc
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void updateOtApplAndItm(String id_or, String id_emp_canc, FDateTime dt_canc, String sd_su_or) throws BizException {
		//1.查询预约记录、预约申请记录
		ScAptApplDO scApplDO = this.getScAptAppl(id_or);//预约申请
		//2.取消申请单
		if(scApplDO != null)
		{
			this.CancelAptAppl(scApplDO, id_emp_canc, dt_canc);
			//3.取消预约
			ScAptDO scAptDO = this.getScApt(scApplDO.getId_scapt());//预约记录
			if(scAptDO != null)
			{
					MtAppDTO mtAppDTO = this.init(scAptDO, scApplDO, sd_su_or);
					new CancMtAptBP().exec(mtAppDTO, scApplDO.getSd_sctp());
			}
		}
	}

	/**
	 * 更新医技申请单/明细信息
	 * @param applItmDO2
	 * @throws BizException
	 */
	private void updateMtApplAndItm(String id_or, String id_emp_canc, FDateTime dt_canc, String sd_su_or, ScAptApplItmDO applItmDO) throws BizException {
		//1.查询预约记录明细、
		if(applItmDO == null){
			return;
		}
		//2.删除申请单明细
		this.delAptApplItm(applItmDO);
		//3.更新申请单信息
		this.updateAptApplByItm(applItmDO, id_emp_canc, dt_canc, sd_su_or);
	}

	/**
	 * 获取申请单类型编码
	 * @param id_or
	 * @throws BizException
	 */
	private String getSdScType(String id_or) throws BizException {
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] scAptAppls = iscaptapplmdorservice.find("id_or ='" + id_or + "'", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scAptAppls)){
			return null;
		}
		return scAptAppls[0].getSd_sctp();
	}

	/**
	 * 更新申请单
	 * @param applItmDO
	 * @param dt_canc
	 * @param id_emp_canc
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void updateAptApplByItm(ScAptApplItmDO applItmDO, String id_emp_canc, FDateTime dt_canc, String sd_su_or) throws BizException {
		// 获取申请单明细
		ScAptApplItmDO[] itmDOs = this.getAptApplItmByIdAppl(applItmDO.getId_aptappl());
		// 通过id_aptappl获取申请单
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO scAptApplDO = iscaptapplmdorservice.findById(applItmDO.getId_aptappl());
		if(itmDOs.length > 0){
			// 合单
			if(scAptApplDO == null){
				ScLogUtil.getInstance().logError("CancScAptApplBP_未找到预约申请记录sc_apt_appl,id_or:"+applItmDO.getId_or());
				return;
			}
			// 更新合单标志fg_multor
			if(itmDOs.length == 1){
				scAptApplDO.setFg_multor(FBoolean.FALSE);
			}
			//替换申请单上医嘱id避免退约时执行闭环报错
			scAptApplDO.setId_or(itmDOs[0].getId_or());
			scAptApplDO.setDt_effe_or(itmDOs[0].getDt_effe_or());
			scAptApplDO.setId_srv(itmDOs[0].getId_srv());
			// 更新医嘱内容content_or
			StringBuilder content_or = new StringBuilder();
			for (ScAptApplItmDO scAptApplItmDO : itmDOs) {
				content_or.append(scAptApplItmDO.getContent_or()).append("|");
			}
			scAptApplDO.setContent_or(content_or.substring(0, content_or.length()-1).toString());
			//3、付费标志fg_bl
			FBoolean fg_bl = FBoolean.FALSE;
			for (int i = 0; i < itmDOs.length; i++) {
				if(FBoolean.TRUE.equals(itmDOs[i].getFg_bl())){
					fg_bl = FBoolean.TRUE;
				}
			}
			scAptApplDO.setFg_bl(fg_bl);
			scAptApplDO.setStatus(DOStatus.UPDATED);
			IScaptapplMDOCudService scaptapplCudService= ServiceFinder.find(IScaptapplMDOCudService.class);
			scaptapplCudService.save(new ScAptApplDO[]{scAptApplDO});

			//如果已经预约需要执行闭环，住院无需执行此闭环
			if(scAptApplDO.getFg_comfirm().booleanValue() && (!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(scAptApplDO.getCode_entp()))){
				//执行逆向闭环
				RewriteOrClosedLoopState.exec(applItmDO.getId_or(), applItmDO.getDt_effe_or(), "43402610",1);
			}
		} else {
			// 非合单 - 取消申请单
			this.CancelAptAppl(scAptApplDO, id_emp_canc, dt_canc);
			//3.取消预约
			ScAptDO scAptDO = this.getScApt(scAptApplDO.getId_scapt());
			if(scAptDO != null)
			{
				MtAppDTO mtAppDTO = this.init(scAptDO, scAptApplDO, sd_su_or);
				new CancMtAptBP().exec(mtAppDTO, scAptApplDO.getSd_sctp());
					//this.CancelScApt(scAptDO,scApplDO);
		}
	}
	}

	/**
	 * 删除字串
	 * @param str1-主
	 * @param str2-子
	 * @return
	 */
	public String deleteSubString(String str1,String str2) {
		StringBuffer sb = new StringBuffer(str1);
		int index = sb.indexOf(str2);
		if(index == -1) {
			return str1;
		}
		sb.delete(index, index+str2.length());
		return sb.toString();
	}

	/**
	 * 删除申请单明细
	 * @param itmDO
	 * @author ltf
	 * @throws BizException
	 */
	private void delAptApplItm(ScAptApplItmDO itmDO) throws BizException {
		IScAptApplItmDOCudService cudService = ServiceFinder.find(IScAptApplItmDOCudService.class);
		itmDO.setStatus(DOStatus.DELETED);
		cudService.delete(new ScAptApplItmDO[]{itmDO});
	}

	/**
	 * 获取申请单明细
	 * @param id_or
	 * @throws BizException
	 * @author ltf
	 */
	private ScAptApplItmDO getAptApplItmByIdOr(String id_or) throws BizException {
		IScAptApplItmDORService rservice = ServiceFinder.find(IScAptApplItmDORService.class);
		ScAptApplItmDO[] aptApplItms = rservice.find("id_or ='"+id_or+"'", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aptApplItms)){
			ScLogUtil.getInstance().logError("CancScAptApplBP_未找到预约申请记录sc_apt_appl_itm,id_or:"+id_or);
			return null;
		}
		return aptApplItms[0];
	}

	/**
	 * 获取预约申请单明细
	 * @param idAptappl
	 * @throws BizException
	 */
	private ScAptApplItmDO[] getAptApplItmByIdAppl(String idAptappl) throws BizException {
		IScAptApplItmDORService rservice = ServiceFinder.find(IScAptApplItmDORService.class);
		ScAptApplItmDO[] aptApplItms = rservice.find("id_aptappl ='"+idAptappl+"'", null, FBoolean.FALSE);
		return aptApplItms;
	}

	/**
	 * 初始化入参
	 * @param aptDO
	 * @param scApplDO
	 * @param sd_su_or
	 * @return
	 */
	private MtAppDTO init(ScAptDO aptDO, ScAptApplDO scApplDO, String sd_su_or){
		MtAppDTO appDTO = new MtAppDTO();
		//FIXME 0188501: 【住院医生站】检查和手术类医嘱在作废时取消申请单,应改为在护士站作废确认时处理 这个bug解决后 要复原
		if(IScDictCodeConst.SD_SCTP_OT.equals(scApplDO.getSd_sctp())){
			appDTO.setOr_closed_flag(FBoolean.FALSE);
		}else{
			appDTO.setOr_closed_flag(FBoolean.TRUE);
		}
		// 设置医嘱状态
		appDTO.setOr_status(sd_su_or);
		appDTO.setId_apt(aptDO.getId_apt());
		appDTO.setSd_aptmd(scApplDO.getSd_aptmd());
		appDTO.setName_pat(scApplDO.getPi_name());
		appDTO.setName_or(scApplDO.getCode_or());
		appDTO.setId_dep_apply(scApplDO.getId_dep_appl());
		appDTO.setId_or(scApplDO.getId_or());
		appDTO.setId_pat(scApplDO.getId_pi());
		appDTO.setId_sch(aptDO.getId_sch());
		appDTO.setDt_effe_or(scApplDO.getDt_effe_or());
		appDTO.setId_apt_appl(scApplDO.getId_aptappl());
		return appDTO;
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
		StringBuilder sql = new StringBuilder();
		sql.append(" select t.* ");
		sql.append(" from sc_apt t");
		sql.append(" where t.id_apt = ? and fg_canc = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_apt);
		param.addParam(FBoolean.FALSE);
		List<ScAptDO> list = (List<ScAptDO>) new DAFacade().execQuery(sql.toString(),param,new BeanListHandler(ScAptDO.class));

		if(ListUtil.isEmpty(list))
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	/**
	 * 获取预约申请记录
	 * @param id_or
	 * @return
	 * @throws BizException
	 * @author ltf
	 */
	private ScAptApplDO getScAptAppl(String id_or) throws BizException
	{
		IScaptapplMDORService scaptapplRService =  ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] dos = scaptapplRService.find(" id_or = '"+ id_or +"' and  fg_canc='N' ", "", FBoolean.FALSE);
		if(dos == null || dos.length==0)
		{
			ScLogUtil.getInstance().logError("CancScAptApplBP_未找到预约申请记录,id_or:"+id_or);
			return null;
		}
		return dos[0];
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

		// 更新医嘱申请单状态--回写手术申请单状态
		new OptAptCiObsOperateBP().rewriteCancApt(scApplDO.getId_or());

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
	 * 更新预约申请
	 *
	 * @author zhengcm
	 *
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateAptAppl(ScAptApplDO aptApplDO) throws BizException {
		MtAptEP mtAptEP = new MtAptEP();
		// 未确认的申请单不取消
		if (null == aptApplDO || null == aptApplDO.getFg_comfirm() || !aptApplDO.getFg_comfirm().booleanValue()) {
			return;
		}
		aptApplDO.setStatus(DOStatus.UPDATED);
		aptApplDO.setFg_comfirm(FBoolean.FALSE);
		if(!aptApplDO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT))
		{
			aptApplDO.setId_emp_canc(ScContextUtils.getPsnId());
			aptApplDO.setDt_canc(ScAppUtils.getServerDateTime());
	}
		// 更新预约申请
		mtAptEP.saveAptAppl(new ScAptApplDO[] { aptApplDO });
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
	 *
	 * @author zhengcm
	 *
	 * @param appDTO
	 * @throws BizException
	 */
	private void rewriteOptAppStatus(String id_or) throws BizException {
		new OptAptCiObsOperateBP().rewriteCancApt(id_or);
	}

	/**
	 * 取消申请单
	 * @param scApplDO
	 * @param id_emp_canc
	 * @param dt_canc
	 * @throws BizException
	 */
	private void CancelAptAppl(ScAptApplDO scApplDO, String id_emp_canc, FDateTime dt_canc) throws BizException
	{
		scApplDO.setStatus(DOStatus.UPDATED);
		scApplDO.setFg_canc(FBoolean.TRUE);
		scApplDO.setFg_bl(FBoolean.FALSE);
		scApplDO.setFg_multor(FBoolean.FALSE);
		scApplDO.setId_emp_canc(id_emp_canc);
		scApplDO.setDt_canc(dt_canc);
		IScaptapplMDOCudService scaptapplCudService= ServiceFinder.find(IScaptapplMDOCudService.class);
		scaptapplCudService.save(new ScAptApplDO[]{scApplDO});
	}

	/**
	 * 取消申请单（合单）
	 * @param scApplDO
	 * @param id_emp_canc
	 * @param dt_canc
	 * @throws BizException
	 */
	private void cancelAptApplMultor(ScAptApplDO scApplDO, String id_emp_canc, FDateTime dt_canc) throws BizException {
		scApplDO.setStatus(DOStatus.UPDATED);
		scApplDO.setFg_canc(FBoolean.TRUE);
		scApplDO.setId_emp_canc(id_emp_canc);
		scApplDO.setDt_canc(dt_canc);
		IScaptapplMDOCudService scaptapplCudService= ServiceFinder.find(IScaptapplMDOCudService.class);
		scaptapplCudService.save(new ScAptApplDO[]{scApplDO});
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
			// 退号
			IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
			schService.drawbackTick(scAptDO.getId_tick());
			// 取消预约
			new AptEP().cancApt(null,scAptDO);
		}
	}
}
