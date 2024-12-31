package iih.bd.pp.service.i;

import iih.bd.pp.incca.d.IncCaItmDO;
import xap.mw.core.data.BizException;

/**
 * 票据查询
 * @author tcy
 *
 */
public interface IBdInccaQueService {
	/**
	 * 根据就诊类型和服务项目，获得所属发票归类信息（发票归类代码和发票归类名称）
	 * @param code_enttp 就诊类型
	 * @param id_srv 服务项目
	 * @return 发票归类信息（发票归类代码和发票归类名称）
	 * @throws BizException
	 */
	public abstract IncCaItmDO getInccaitmCodeAndName(String code_enttp,String id_srv) throws  BizException;

}
