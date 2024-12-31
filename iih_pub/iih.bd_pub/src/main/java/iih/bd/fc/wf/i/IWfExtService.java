package iih.bd.fc.wf.i;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.org.d.OrgDO;

public interface IWfExtService {

	/**
	 * 获取流向（拼装子表Srvtp）
	 * 
	 * @param Code_entp
	 * @return
	 * @throws BizException
	 */
	public WfAggDO[] GetWfAggList(String Code_entp) throws BizException;

	/**
	 * 获取就诊类型列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract EnTypeDO[] getEntpList() throws BizException;

	/**
	 * 医嘱流向保存
	 * 
	 * @param AggDO
	 * @return
	 * @throws BizException
	 */
	public abstract WfAggDO save(WfAggDO AggDO) throws BizException;

	/**
	 * 获取机构信息
	 * 
	 * @param wfDepDO
	 * @return
	 * @throws BizException
	 */
	public abstract OrgDO getOrgDetail(String Id_dep) throws BizException;

	/**
	 * 获取医嘱流向主do分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<WfDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException;

	/**
	 * 根据医嘱流向主键获取aggdo
	 * 
	 * @param wfId
	 * @return
	 * @throws BizException
	 */
	public abstract WfAggDO findWfAggDOById(String wfId) throws BizException;
	
	/**
	 * 根据WFDO中的计算字段去保存子表BD_WF_SRVTP
	 * @param wf
	 * @return 
	 * @throws BizException
	 */
	public abstract WfDO saveWf(WfDO wf) throws BizException;
	
	/**
	 * 获取执行科室列表排序
	 * @param idwf
	 * @return
	 * @throws BizException
	 */
	public abstract int getMaxNo(String idwf) throws BizException;
}
