package iih.bd.srv.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.MrtplvtAggDO;
import xap.mw.core.data.BizException;

public interface IMrvEmrExtService {

	/**
	 * 获取全部体征模板
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract MrtplVtDO[] getMrtplVtList() throws BizException;

	/**
	 * 保存
	 * 
	 * @param AggDO
	 * @param MrtplDO
	 * @return
	 * @throws BizException
	 */
	public abstract MrtplVtDO Save(MrtplvtAggDO AggDO, EmrTplDO MrtplDO) throws BizException;

	/**
	 * 删除
	 * 
	 * @param dataObj
	 * @throws BizException
	 */
	public abstract void Delete(MrtplVtDO dataObj) throws BizException;
}
