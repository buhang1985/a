package iih.en.pv.out.i;

import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 对CI提供查询接口
 * 
 * @author liubin
 *
 */
public interface IEn4CiQryService extends IEn4CommQryService{
	/**
	 * 就诊是否封账
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public FBoolean isFreeZe(String entId) throws BizException; 
	/**
	 * 获取患者预约渠道打印标识
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public String getScSchPrintIdent(String entId) throws BizException; 
	/**
	 * 获取门诊预检生命体征信息
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	EntOpVitalSignsDTO[] getEntOpVitalSigns(String[] idEnts) throws BizException;
	/**
	 * 获取前一次就诊的诊断信息
	 * 1.本次就诊没有前一次就诊，返回null
	 * 2.前一次就诊没有诊断，返回null
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	EntDiDO[] getErPreEntDis(String entId) throws BizException;
}
