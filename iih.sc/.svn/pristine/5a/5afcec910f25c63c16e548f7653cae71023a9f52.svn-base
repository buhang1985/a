package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.op.CancAptOpBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 口腔科退约BP
 * 
 * @author zhengcm
 * @date 2016-09-29 15:14:21
 *
 */
public class CancOralAptBP {

	/**
	 * 口腔科退约
	 *
	 * @param aptId
	 * @param isCheckChl
	 * @param msgType
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String aptId, FBoolean isCheckChl, int msgType) throws BizException {
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
		ScLogUtil.getInstance().logInfo("[退约前]口腔退约：(患者：" + aptDO.getId_pat() + "),排班：" + schDO.toString());

		// 3、创建OpAptDTO对象
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(aptDO.getId_apt());
		aptDTO.setId_tick(aptDO.getId_tick());
		if (FBoolean.TRUE.equals(aptDO.getFg_payment())) {
			String cond = String.format("id_apt = '%s'", aptDO.getId_apt());
			IScAptOpDORService opAptQryService = ServiceFinder.find(IScAptOpDORService.class);
			ScAptOpDO[] opAptDOs = opAptQryService.find(cond, null, FBoolean.FALSE);
			if (!ArrayUtil.isEmpty(opAptDOs)) {
				aptDTO.setId_ent(this.getEntId(aptDO.getId_apt()));
				// 渠道
				ISchedulechlMDORService chlService = ServiceFinder.find(ISchedulechlMDORService.class);
				SchedulechlDO chlDO = chlService.findById(aptDO.getId_scchl());
				String sd_chltp = null;
				if (null != chlDO) {
					sd_chltp = chlDO.getSd_scchltp();
				}
				aptDTO.setSd_pttp(this.getPttpByChl(sd_chltp));
			}
		}

		// 4、退约
		aptDTO.setType_msg(msgType);
		new CancAptOpBP().exec(aptDTO);

		// 记录日志
		schDO = new OralAptEP().getSch(aptDO.getId_sch());
		ScLogUtil.getInstance().logInfo("[退约后]口腔退约：(患者：" + aptDO.getId_pat() + "),排班：" + schDO.toString());
	}

	/**
	 * 检查预约状态：已预约但没有取号的才可退约
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
			throw new BizException(IScMsgConst.SC_APT_SCORAL_NOTCANCEL);
		} else if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_CANCEL)) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_CANCEL_CANCELED);
		}
	}

	/**
	 * 获取就诊Id
	 * 
	 * @param aptId
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String getEntId(String aptId) throws DAException {
		String sql = "select op.id_ent from en_ent_op op where op.id_schapt = ? ";
		SqlParam param = new SqlParam();
		param.addParam(aptId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if (!ListUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 获取支付类型
	 *
	 * @author zhengcm
	 * 
	 * @param chlTp
	 * @return
	 */
	private String getPttpByChl(String chlTp) {
		String sd_pttp = null;
		switch (chlTp) {
		case IScDictCodeConst.SD_SCCHLTP_HOSPITAL_SELF:
			sd_pttp = IBlDictCodeConst.SD_PTTP_SELF_TERMINAL;
			break;
		case IScDictCodeConst.SD_SCCHLTP_PATIENT_MOBILE:
			sd_pttp = IBlDictCodeConst.SD_PTTP_PHONE_APP;
			break;
		case IScDictCodeConst.SD_SCCHLTP_PATIENT_WEIXIN:
			sd_pttp = IBlDictCodeConst.SD_PTTP_WEIXIN;
			break;
		default:
			sd_pttp = IBlDictCodeConst.SD_PTTP_WINDOW;
			break;
		}
		return sd_pttp;
	}

}
