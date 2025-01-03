package iih.ci.ord.i.external.provide;

import java.util.List;

import iih.ci.ord.i.external.provide.meta.mr.d.CiOrdInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDateTime;

/**
 * 临床提供给病历的对外接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdMrService {
	/**
	 * 处置手动刷新到病历 by yzh 2017-06-06 09:56:54
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp) throws BizException;

	/**
	 * 诊断刷新到病历 by yzh 2017-06-06 11:30:15
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract String getDiagList(String id_ent) throws BizException;
		
	/**
	 * 获取患者出院带药同步到病历数据
	 * @param id_en 就诊id
	 * @return
	 * @throws BizException
	 *//*
	public abstract FMap2 getPresOutpOrderMrDtoFlushList(String id_en) throws BizException;
	
	  *//**
     * 获取死亡医嘱的生效时间
     * @param id_en
     * @return
     * @throws BizException
     */
	public abstract FDateTime  getDeathDateTime(String id_en)throws BizException;
	
	/**
     * 获取出院医嘱的生效时间
     * @param id_en
     * @return
     * @throws BizException
     *//*
	public abstract FDateTime  getPatLeaveHospitalTime(String id_en)throws BizException;
	*//**
	 * 获取出院或死亡医嘱的信息
	 * @param id_en
	 * @return
	 * @throws DAException
	 *//*
	public abstract OutHospOrderInfoDTO getOutHospitalInfoByIdEn(String id_en) throws BizException;
	*//**
	 * 获取本次就诊最新诊断
	 * @param id_en
	 * @return
	 * @throws DAException
	 *//*
	public abstract CiDiagInfoDTO[] getCiDiInfoByIden(String id_en) throws BizException;*/
	
	/**
	 * 获取该患者门诊所有医嘱信息
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public abstract List<CiOrdInfoDTO> getCiOrdInfoByIden(String id_en) throws BizException;
}
