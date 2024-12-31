package iih.bd.res.dayslot.s;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotQryService;
import iih.bd.res.dayslot.s.bp.DaysLotBP;
import iih.bd.res.dayslot.s.bp.GetDaysLotsByCaIdBP;
import iih.bd.res.dayslot.s.bp.GetDaysLotsByScTpBP;
import iih.bd.res.dayslot.s.bp.GetDayslotStartTimeBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FTime;

/**
 * 日期分组查询服务
 * @author liubin
 *
 */
@Service(serviceInterfaces={IDayslotQryService.class}, binding=Binding.JSONRPC)
public class DayslotQryServiceImpl implements IDayslotQryService {
	/**
	 * 得到当前时间分组
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
	@Override
	public DaysLotDO getRecentDayslot(String scTp) throws BizException{
		DaysLotBP daysLotBP = new DaysLotBP();		
		return daysLotBP.getNowDaysLot(scTp);
	}

	/**
	 * 获取当前和之后的午别集合
	 * 
	 * @param scTp 排班类型编码 <br/>
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * </ul>  
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	@Override
	public DaysLotDO[] getAvlDayslotList(String scTp) throws BizException{
		DaysLotBP daysLotBP = new DaysLotBP();		
		return daysLotBP.getAvlDayslotList(scTp);
	}
	/**
	 * 获取午别开始时间
	 * @param dayslotId 日期分组ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public FTime getDayslotStartTime(String dayslotId) throws BizException{
		GetDayslotStartTimeBP getBP = new GetDayslotStartTimeBP();
		return getBP.exec(dayslotId);
	}
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
	@Override
	public DaysLotDO[] getDaysLotsByScTp(String scTp) throws BizException {
		GetDaysLotsByScTpBP bp = new GetDaysLotsByScTpBP();
		return bp.getDaysLotsByScTp(scTp);
	}
	/**
	 * 通过日期分诊分类获取日期分组
	 * 
	 * @param dayslotcaId
	 * @return
	 * @throws BizException
	 */
	@Override
	public DaysLotDO[] getDaysLotsByCaId(String dayslotcaId) throws BizException {
		GetDaysLotsByCaIdBP bp = new GetDaysLotsByCaIdBP();
		return bp.exec(dayslotcaId);
	}
	
	/**
	 * 通过日期分诊分类获取日期分组（包含停用的）
	 * 
	 * @param dayslotcaId
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] getAllDaysLotsByCaId(String dayslotcaId) throws BizException{
		GetDaysLotsByCaIdBP bp = new GetDaysLotsByCaIdBP();
		return bp.exec2(dayslotcaId);
	}
}
