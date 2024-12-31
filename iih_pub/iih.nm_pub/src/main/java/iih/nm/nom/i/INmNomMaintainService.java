package iih.nm.nom.i;

import iih.nm.nhr.nmpsndoc.d.NmNurDO;
import iih.nm.nom.msgrec.d.NomMsgRecDO;
import iih.nm.nom.nomquality.d.NomNurQualityDO;
import iih.nm.nom.nomwkitmapp.d.NomwkitmappAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public interface INmNomMaintainService {

	/**
	 * 护理管理工作量录入保存
	 * 
	 * @param nomwkitmappAggDo
	 * @return
	 * @throws BizException
	 */
	public NomwkitmappAggDO saveNomWkitmappAggData(NomwkitmappAggDO nomwkitmappAggDo) throws BizException;

	/**
	 * 护理管理工作量录入刷新
	 * 
	 * @param date
	 * @param id_dep_nur
	 * @throws BizException
	 */
	public void saveRefreshStatistics(String date, String id_dep_nur) throws BizException;

	/**
	 * 护理工作量更新状态
	 * 
	 * @param id_dep_nur
	 * @param dt_b
	 * @param dt_e
	 * @throws BizException
	 */
	public void updateNomWkitmAppDOStatus(String id_dep_nur, FDateTime dt_b, FDateTime dt_e) throws BizException;

	/**
	 * 手动刷新病房患者日志
	 * 
	 * @param date
	 * @param id_dep_nur
	 * @throws BizException
	 */
	public void refreshBedwardStatistics(FDate date, String id_dep_nur) throws BizException;

	/**
	 * 更新病房患者日志上报状态。
	 * 
	 * @param id_dep_mp
	 * @param dt_begin
	 * @param dt_end
	 * @throws BizException
	 */
	public void updateNmBedwardRecordsStatus(String id_dep_mp, FDate dt_begin, FDate dt_end) throws BizException;

	/**
	 * 护理质量监控保存逻辑
	 * 
	 * @param nomNurQualityDO
	 * @throws BizException
	 */
	public void saveNomNurQualityDO(NomNurQualityDO nomNurQualityDO, boolean isWard, boolean isFg_comfirm) throws BizException;

	/**
	 * 护理部消息推送
	 * 
	 * @author 王鹏
	 * @throws BizException
	 */
	public NomMsgRecDO[] saveSendMsgRec(NomMsgRecDO msgRecDO, NmNurDO[] recevicePsnDOs) throws BizException;
}
