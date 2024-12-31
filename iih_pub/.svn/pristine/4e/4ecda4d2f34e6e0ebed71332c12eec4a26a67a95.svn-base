package iih.ci.ord.i.external.obtain;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 临床调用患者域接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdPiRService {

	/**
	 * 获取患者就诊卡类型接口
	 * 
	 * @return key 就诊卡类型编码，就诊卡名称
	 * @throws BizException
	 */
	public FMap getPatCardType(String id_grp, String id_org) throws BizException;

	/**
	 * 根据就诊id查询患者分类
	 * 
	 * @param id_en 患者本次就诊id
	 * @return
	 * @throws BizException
	 */
	public String getPatcaCodeByIden(String id_en) throws BizException;
}
