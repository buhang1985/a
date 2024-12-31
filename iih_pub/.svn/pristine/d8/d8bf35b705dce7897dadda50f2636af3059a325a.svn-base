package iih.nm.nqm.qctplmaintenance.i;

import iih.nm.nqm.qctplelemaintenance.d.QctplelemaintenanceAggDO;
import iih.nm.nqm.qctplmaintenance.d.NmQctplDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 质量模板扩展服务
 * 
 * @author lijm DateTime: 2017-2-9 11:56:24
 */

public interface IQctplmaintenanceExtService {

	/**
	 * 保存（模板、模板元素同一事物保存）
	 * 
	 * @param tplDo
	 *            模板DO
	 * @param aggDOs
	 *            模板元素Agg集合
	 * @throws BizException
	 */
	public abstract NmQctplDO save(NmQctplDO tplDo, QctplelemaintenanceAggDO[] aggDOs) throws BizException;

	public abstract NmQctplDO tplUpDateGrade(NmQctplDO tplDo) throws BizException;
}
