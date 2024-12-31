package iih.ci.ord.s.external.thirdws.base;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import xap.mw.core.data.BizException;
/**
 * 医疗单保存接口
 * @author zhangwq
 *
 */
public interface IEmsSaveBP {
	/**
	 * 保存医疗单
	 * @param entwsdto
	 * @return
	 */
	String save(EntWsDTO entwsdto) throws BizException ;
}