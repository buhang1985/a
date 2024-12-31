package iih.bd.res.dayslot.i;

import iih.bd.res.dayslot.d.DaysLotDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FTime;

/**
 * 日期分组查询服务
 * @author yank,liubin
 *
 */
public interface IDayslotQryService {
	/**
	 * 得到当前日期分组
	 * 
	 * @param scTp 排班类型编码
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * <li>IScDictCodeConst.SD_SCTP_JZ【05--急诊】</li>
	 * </ul> 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	DaysLotDO getRecentDayslot(String scTp) throws BizException;
	/**
	 * 获取当前和之后的日期分组集合
	 * 
	 * @param scTp 排班类型编码
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * <li>IScDictCodeConst.SD_SCTP_JZ【05--急诊】</li>
	 * </ul> 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	DaysLotDO[] getAvlDayslotList(String scTp) throws BizException;	
	/**
	 * 通过排班类型获取日期分组
	 * 
	 * @param scTp 排班类型编码
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * <li>IScDictCodeConst.SD_SCTP_JZ【05--急诊】</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	DaysLotDO[] getDaysLotsByScTp(String scTp) throws BizException;
	/**
	 * 获取午别开始时间
	 * @param dayslotId 日期分组ID
	 * @return
	 * @throws BizException
	 */
	FTime getDayslotStartTime(String dayslotId) throws BizException;
	/**
	 * 通过日期分诊分类获取日期分组
	 * 
	 * @param dayslotcaId
	 * @return
	 * @throws BizException
	 */
	DaysLotDO[] getDaysLotsByCaId(String dayslotcaId) throws BizException;
	
	/**
	 * 通过日期分诊分类获取日期分组（包含停用的）
	 * 
	 * @param dayslotcaId
	 * @return
	 * @throws BizException
	 */
	DaysLotDO[] getAllDaysLotsByCaId(String dayslotcaId) throws BizException;
}
