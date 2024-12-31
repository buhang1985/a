package iih.ci.mrfp.dto.i;

import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.inpatient.dto.d.EntForMedRecDTO;
import iih.pi.reg.dto.d.PatiInfoForMrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 住院病案首页 接口集合
 * 
 * @author 杨建兵
 *
 */
public interface CiMrFpService {

	/**
	 * 刘羽处查询的相关信息数据 查询患者信息
	 * 
	 * @param idPat
	 * @return
	 */
	PatiInfoForMrDTO getPatiInfoForMrDTO(String idPat, String idEnt) throws BizException;

	/**
	 * 颜刊处提供dto数据 查询当此就诊信息
	 * 
	 * @param idEnt
	 * @return
	 */
	EntForMedRecDTO getEntForMedRecDTO(String idEnt) throws BizException;

	/**
	 * 颜刊处提供dto数据 查询当此就诊信息
	 * 
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public IpDetailDTO getIpDetailInfo(String idEnt) throws BizException;

	/**
	 * 从医嘱中查询患者的护理天数 -by Vampire
	 * 
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getNurDaysInfo(String idEnt) throws BizException;

	/**
	 * 从病历元内容查询患者的病案首页手术
	 * 
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	CiMrFpSugDTO[] getCiMrFpSugDTO(String idEnt) throws BizException;
}
