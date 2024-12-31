package iih.en.que.s.bp.op.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 接诊时判断是否可以顺序接诊（刷卡模式）
 * 
 * @author liubin
 *
 */
public class CheckPvOrderAcptFgBP {
    /**
     * 接诊时判断是否可以顺序接诊（刷卡模式）
     * 
     * @param opReg
     * @param que
     * @param queSiteDO
     * @param siteInfo
     * @return
     * @throws BizException
     */
	public ResultDTO exec(OpRegDTO opReg, QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		ResultDTO result = new ResultDTO();
		result.setFlag(FBoolean.TRUE);
		//无分诊台，分诊台不在线，可不按顺序接诊
		if(!CheckListPvOrderAcptFgBP.isBenOnLine(queSiteDO == null? null : queSiteDO.getId_queben()))
			return result;
		result = CheckListPvOrderAcptFgBP.isFirstLevelOrNtn(opReg.getId_ent());
		if(FBoolean.TRUE.equals(result.getFlag()))
			return result;
		if(!IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(opReg.getSd_status_acpt())){
			if(isFirtWaitPat(opReg.getId_ent(), que, queSiteDO, siteInfo)){
				result.setFlag(FBoolean.TRUE);
				return result;
			}
		}
		return result;
	}
	/**
	 * 患者是否是第一个候诊患者
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private boolean isFirtWaitPat(String entId, QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		GetDocAcptListBP bp = new GetDocAcptListBP();
		ReceptionQueDTO[] ents = bp.exec(que, queSiteDO, siteInfo, GetDocAcptListBP.Wait);
		return !EnValidator.isEmpty(ents) && ents[0].getId_ent().equals(entId);
	}
}
