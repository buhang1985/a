package iih.mp.ot.mtprcfm.i;


import iih.mp.ot.dto.confirm.d.MpOtCondDTO;
import iih.mp.ot.dto.confirm.d.MpOtOrInfoDTO;
import iih.mp.ot.dto.confirm.d.MpOtPatDTO;
import xap.mw.core.data.BizException;

public interface IMtprcfmService {
	
	/**
	 * 医技确认之医嘱确认查询
	 * @param  cond 查询条件
	 * @return MpOtPatDTO[] 患者信息
	 * @throws BizException
	 */
	public abstract MpOtPatDTO[] getConfirmOrd(MpOtCondDTO cond) throws BizException;
	
	/**
	 * 查询医技取消患者列表
	 * @param  cond 查詢條件
	 * @return MpOtPatDTO[] 患者信息
	 * @throws BizException
	 */
	public abstract MpOtPatDTO[] getCancelPats(MpOtCondDTO cond) throws BizException;
	
	/**
	 * 取得患者可取消医嘱列表
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrInfoDTO[] getCancelOrdByPat(MpOtCondDTO cond) throws BizException;
	
	/**
	 * 医技确认
	 * @param condition
	 * @param mpOtOrInfoDTOs
	 * @throws BizException
	 */
	public abstract void confirmPerformance(MpOtCondDTO condition,MpOtOrInfoDTO[] mpOtOrInfoDTOs) throws BizException;
	
	/**
	 * 医技取消
	 * @param condition
	 * @param mpOtOrInfoDTOs
	 * @throws BizException
	 */
	public abstract void cancelPerformance(MpOtCondDTO condition,MpOtOrInfoDTO[] mpOtOrInfoDTOs) throws BizException;
}
