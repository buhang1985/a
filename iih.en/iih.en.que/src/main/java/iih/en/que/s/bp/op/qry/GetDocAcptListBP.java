package iih.en.que.s.bp.op.qry;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.util.EnParamUtils;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.s.bp.GetDiagnosedBP;
import iih.en.que.s.bp.GetNeedRtnEntBP;
import iih.en.que.s.bp.GetRegEntBP;
import iih.en.que.s.bp.GetWaitingBP;
import iih.en.que.s.bp.op.qry.benmgr.GetRegEnt4BenMgrBP;
import iih.en.que.s.bp.op.qry.benmgr.GetWaiting4BenMgrBP;
import xap.mw.core.data.BizException;

/**
 * 获取医生站患者列表
 * 
 * @author liubin
 *
 */
public class GetDocAcptListBP {

	public static final String NoTriage = "NoTriage";// 未分诊
	public static final String Wait = "Wait";// 候诊
	public static final String Acpt = "Acpt";// 已诊
	public static final String NeedRtn = "NeedRtn";// 待回诊

	/**
	 * 获取医生站患者列表
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param siteInfo
	 * @param type
	 *            列表类型
	 * @return
	 * @throws BizException
	 */
	public ReceptionQueDTO[] exec(QueDO que, QueSiteDO queSiteDO,
			EnTrDocSiteInfoDTO siteInfo, String type) throws BizException {
		// 判断是否是分诊台管理队列
		if (EnParamUtils.isBenQueMgr())
			return execBenQueMgr(que, queSiteDO, siteInfo, type);
		return execEmpQueMgr(que, queSiteDO, siteInfo, type);
	}

	/**
	 * 获取医生站患者列表（医生管理队列）
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param dayslotId
	 * @param type
	 * @return
	 * @throws BizException
	 */
	private ReceptionQueDTO[] execEmpQueMgr(QueDO que, QueSiteDO queSiteDO,
			EnTrDocSiteInfoDTO siteInfo, String type) throws BizException {
		switch (type) {
		case NoTriage:
			return new GetRegEntBP().exec(que, queSiteDO, siteInfo);
		case Wait:
			return new GetWaitingBP().exec(que, queSiteDO, siteInfo);
		case Acpt:
			return new GetDiagnosedBP().exec(siteInfo);
		case NeedRtn:
			return new GetNeedRtnEntBP().exec(siteInfo);
		}
		return null;
	}

	/**
	 * 获取医生站患者列表（分诊台管理队列）
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param siteInfo
	 * @param type
	 * @return
	 * @throws BizException
	 */
	private ReceptionQueDTO[] execBenQueMgr(QueDO que, QueSiteDO queSiteDO,
			EnTrDocSiteInfoDTO siteInfo, String type) throws BizException {
		switch (type) {
		case NoTriage:
			return new GetRegEnt4BenMgrBP().exec(queSiteDO, siteInfo);
		case Wait:
			return new GetWaiting4BenMgrBP().exec(queSiteDO, siteInfo);
		case Acpt:
			return new GetDiagnosedBP().exec(siteInfo);
		case NeedRtn:
			return new GetNeedRtnEntBP().exec(siteInfo);
		}
		return null;
	}
}
