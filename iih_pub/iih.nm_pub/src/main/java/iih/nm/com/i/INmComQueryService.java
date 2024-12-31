package iih.nm.com.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.dto.nurcond.d.NurCondDTO;
import iih.nm.nhr.nmpsndoc.d.NmNurDO;

public interface INmComQueryService {
	/**
	 * 根据条件编码获取护理人员挑选分类
	 * 
	 * @param code_cond条件编码
	 * @return
	 * @author Lijm
	 */
	public abstract NurCondDTO[] getNurPsnCaByCond(String code_cond) throws BizException;

	/**
	 * 根据护理人员分类查询护理人员
	 * 
	 * @param id_nur_ca护理人员分类id
	 * @param code_cond挑选条件编码
	 * @return
	 */
	public abstract NmNurDO[] getNurPsnsByNurCa(String id_nur_ca, String code_cond) throws BizException;

	/**
	 * 生成指定数量的OID
	 * 
	 * @param num
	 *            数量
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getOIDs(int bum) throws BizException;

	/**
	 * 获取组织参数
	 * 
	 * @param paramCode
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract String getOrgParamByCode(String paramCode) throws BizException;

	/**
	 * 获取当前科室护士长用户
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public abstract String[] getCurrDepNurse(String id_dep) throws BizException;

}
