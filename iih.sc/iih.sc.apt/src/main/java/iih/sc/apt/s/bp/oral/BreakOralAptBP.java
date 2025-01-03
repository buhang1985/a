package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrCudService;
import iih.sc.apt.s.bp.GetPatBbrInvalidDateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.scapt.d.ScAptDO;
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
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 口腔科爽约BP
 * 
 * @author zhengcm
 * @date 2016-09-21 17:25:41
 *
 */
public class BreakOralAptBP {

	/**
	 * 口腔科爽约
	 *
	 * @param aptId
	 * @param isCheckChl
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String aptId, FBoolean isCheckChl) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("aptId", aptId);

		AptEP aptEP = new AptEP();
		ScAptDO aptDO = aptEP.getById(aptId);
		if (null == aptDO) {
			return;
		}

		// 检查渠道
		if (isCheckChl.booleanValue()) {
			new CheckOralChlBP().check(aptDO.getId_scchl());
		}

		// 2、检查预约状态
		this.checkAptStatus(aptDO);

		// 记录日志
		ScSchDO schDO = new OralAptEP().getSch(aptDO.getId_sch());
		ScLogUtil.getInstance().logInfo("[爽约前]爽约：(患者：" + aptDO.getId_pat() + "),排班：" + schDO.toString());

		// 3、退号
		this.drawbackTick(aptDO);

		// 4、更新预约
		this.updateApt(aptId);

		// 5、记录患者不良记录
		this.savePatBbr(aptDO);

		// 记录日志
		schDO = new OralAptEP().getSch(aptDO.getId_sch());
		ScLogUtil.getInstance().logInfo("[爽约后]爽约：(患者：" + aptDO.getId_pat() + "),排班：" + schDO.toString());
	}

	/**
	 * 退号
	 *
	 * @param aptDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void drawbackTick(ScAptDO aptDO) throws BizException {
		if (null == aptDO || StringUtil.isEmptyWithTrim(aptDO.getId_tick())) {
			return;
		}
		IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = service.findById(aptDO.getId_sch());
		if(scSchDO.getFg_transed().booleanValue()){
			ScLogUtil.getInstance().logInfo("相关号位数据转移到sc_tickb表中，无法进行退号处理");
			return;
		}
		// 判断是否需要补号
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		String supplyTicketType = qryService.getSupplyTicketType(null, aptDO.getId_apt());
		// 排班对外维护服务
		IScSchOutCmdService outCmdService = ServiceFinder.find(IScSchOutCmdService.class);
		// outCmdService.drawbackTick(aptDO.getId_tick());
		outCmdService.revokeTick(aptDO.getId_tick(), supplyTicketType);
	}

	/**
	 * 更新预约
	 *
	 * @param id_apt
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateApt(String id_apt) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_apt)) {
			return;
		}
		AptEP aptEP = new AptEP();
		ScAptDO aptDO = aptEP.getById(id_apt);
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_CANCEL);// 预约状态：取消
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_CANCEL);
		aptDO.setFg_canc(FBoolean.TRUE);
		aptDO.setDt_canc(ScAppUtils.getServerDateTime());
		aptDO.setId_emp_canc(ScContextUtils.getPsnId());
		aptDO.setNote_canc(IScMsgConst.SC_APT_SCORAL_BREAK_NOTE);
		aptEP.save(new ScAptDO[] { aptDO });
	}

	/**
	 * 记录患者的不良记录
	 *
	 * @param oralAptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePatBbr(ScAptDO aptDO) throws BizException {
		if (null == aptDO) {
			return;
		}
		// 不良记录失效日期
		FDateTime dt_disable = new GetPatBbrInvalidDateBP().exec(ScAppUtils.getServerDateTime(), IScDictCodeConst.ID_APT_SCORAL_BREAK_BBRTP);
		// 患者不良记录维护服务
		IPatbbrCudService cmdService = ServiceFinder.find(IPatbbrCudService.class);
		PiPatBbrDO patBbrDO = new PiPatBbrDO();
		patBbrDO.setStatus(DOStatus.NEW);
		patBbrDO.setId_grp(ScContextUtils.getGrpId());
		patBbrDO.setId_org(ScContextUtils.getOrgId());
		patBbrDO.setId_pat(aptDO.getId_pat());
		patBbrDO.setId_key(aptDO.getId_apt());
		patBbrDO.setId_bbrtp(IScDictCodeConst.ID_APT_SCORAL_BREAK_BBRTP);
		patBbrDO.setSd_bbrtp(IScDictCodeConst.SD_APT_SCORAL_BREAK_BBRTP);
		if(dt_disable != null){
			patBbrDO.setDt_disable(dt_disable);
		}
		patBbrDO.setDes_reason(IScMsgConst.SC_APT_SCORAL_BREAK_NOTE);
		// 记录预约日期 changed by zhengcm 2018-03-01
		patBbrDO.setDt_act(aptDO.getDt_b());
		patBbrDO.setId_emp(ScContextUtils.getPsnId());
		patBbrDO.setFg_active(FBoolean.TRUE);
		cmdService.insert(new PiPatBbrDO[] { patBbrDO });
	}

	/**
	 * 检查预约状态：已预约但没有取号的才可爽约
	 *
	 * @param aptDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkAptStatus(ScAptDO aptDO) throws BizException {
		if (null == aptDO || StringUtil.isEmptyWithTrim(aptDO.getSd_status())) {
			return;
		}
		if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_FINISH)) {
			throw new BizException(IScMsgConst.SC_APT_SCORAL_NOTBREAK);
		} else if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_CANCEL)) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_BREAK_CANCELED);
		}
	}

}
