package iih.ci.mr.i;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IIPMrService {
	
	/**
	 * 保存病历源内容
	 * @param ciMrSourceDOs
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean saveSource(CiMrSourceDO[] ciMrSourceDOs) throws BizException;
	
	/**
	 * 删除病历源内容
	 * @param idMrs
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean deleteSource(String[] idMrs) throws BizException;

	/**
     * 本次就诊的死亡时间
     * @param id_ent
     * @return
     * @throws BizException
     */
	public abstract FDateTime  getDeathDateTime(String id_ent)throws BizException;
	
	/**
     * 本次就诊的出院时间
     * @param id_ent
     * @return
     * @throws BizException
     */
	//public abstract FDateTime  getLeaveHospitalDateTime(String id_ent)throws BizException;
	
	/**
	 * 获取处置模板信息
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 getDefaultMrPreFormats(String id_dept) throws BizException;

	/**
	 * 获取患者出院带药同步到病历数据
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	//public abstract FMap2 getPresOutpOrderMrDtoFlushList(String id_ent) throws BizException;
	
	/**
	 * 发送病历召回申请消息
	 * @param ciMrRecallDO
	 * @throws BizException
	 */
	public abstract Boolean sendRecallApplyMsg(CiMrRecallDO ciMrRecallDO) throws BizException;
	
	/**
	 * 发送病历召回申请消息
	 * @param ciMrRecallDO
	 * @throws BizException
	 */
	public abstract Boolean sendRecallAuditMsg(CiMrRecallDO ciMrRecallDO) throws BizException;
	
	/**
	 * 获取文书二进制返回
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrFsDO getCiMrFsDO(CiMrDO ciMrDO) throws BizException;
	
	/**
	 * 保存二进制返回
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 saveCiMrFsDO(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException;
	
	/**
	 * 物理删除
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @throws BizException
	 */
	public abstract FBoolean deleteCiMrFsDO(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException;
	/***
	 * 根据患者就诊id和医生id获取此次就诊该医生的上级医师id
	 * fanlq
	 * @param id_ent
	 * @param id_psn
	 * @return
	 * @throws BizException
	 */
	//public abstract String[] GetPatEntSuperiorDocList(String id_ent, String id_psn,String id_dep) throws BizException;
	/**
	 * 发送病历驳回消息
	 * @param ciMrRecallDO
	 * @throws BizException
	 */
	public abstract Boolean sendRejectMrfpMsg(PatiVisitDO patiVisitDO) throws BizException;
}
	
