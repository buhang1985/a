package iih.pi.reg.i.external.provide;

import xap.mw.core.data.BizException;

/**
 * 患者提供给就诊服务接口
 * 
 * @author hao_wu 2018-8-5
 *
 */
public interface IPiRegEnService {

	/**
	 * 入院登记(儿童)根据母亲名称、证件类型、证件号查询母亲的患者主键
	 * 
	 * @param patName
	 *            母亲姓名
	 * @param idTpCode
	 *            证件类型编码
	 * @param idNum
	 *            证件号
	 * @return 母亲患者主键
	 * @throws BizException
	 */
	public abstract String findMomIdByNameAndIdNum4RegChild(String patName, String idTpCode, String idNum)
			throws BizException;
}
