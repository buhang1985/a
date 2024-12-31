package iih.bd.fc.wf.s;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.i.IWfExtService;
import iih.bd.fc.wf.s.bp.GetMaxSortNOBp;
import iih.bd.fc.wf.s.bp.SaveBp;
import iih.bd.fc.wf.s.bp.WfSaveBp;
import iih.bd.fc.wf.s.bp.getEntpListBp;
import iih.bd.fc.wf.s.bp.getOrgDetailBp;
import iih.bd.fc.wf.s.bp.getWfAggDoBp;
import iih.bd.fc.wf.s.bp.getWfAggListBp;
import iih.bd.fc.wf.s.bp.getWfDoPageDataBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.orgfw.org.d.OrgDO;

@Service(serviceInterfaces = { IWfExtService.class }, binding = Binding.JSONRPC)
public class IWfExtServiceImpl implements IWfExtService {

	/**
	 * 获取流向（拼装子表Srvtp）
	 */
	@Override
	public WfAggDO[] GetWfAggList(String Code_entp) throws BizException {

		getWfAggListBp bp = new getWfAggListBp();

		return bp.exec(Code_entp);
	}

	/**
	 * 获取就诊类型列表
	 */
	@Override
	public EnTypeDO[] getEntpList() throws BizException {

		getEntpListBp bp = new getEntpListBp();

		return bp.exec();
	}

	/**
	 * 医嘱流向保存
	 */
	@Override
	public WfAggDO save(WfAggDO AggDO) throws BizException {

		SaveBp bp = new SaveBp();

		return bp.exec(AggDO);
	}

	/**
	 * 获取机构信息
	 * 
	 * @param wfDepDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrgDO getOrgDetail(String Id_dep) throws BizException {

		getOrgDetailBp bp = new getOrgDetailBp();

		return bp.exec(Id_dep);
	}

	/**
	 * 获取医嘱流向主do分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<WfDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		getWfDoPageDataBp bp = new getWfDoPageDataBp();
		PagingRtnData<WfDO> rtn = bp.exec(pg, wherePart, orderByPart);
		return rtn;
	}

	/**
	 * 根据医嘱流向主DOid获取医嘱流向AggDO
	 */
	@Override
	public WfAggDO findWfAggDOById(String wfId) throws BizException {
		getWfAggDoBp bp = new getWfAggDoBp();
		return bp.exec(wfId);
	}

	/**
	 * 医嘱流向保存
	 */
	@Override
	public WfDO saveWf(WfDO wf) throws BizException {
		WfSaveBp bp = new WfSaveBp();
		return bp.exec(wf);
	}

	/**
	 * 获取最大值
	 */
	@Override
	public int getMaxNo(String idwf) throws BizException {
		GetMaxSortNOBp bp = new GetMaxSortNOBp();
		return bp.exec(idwf);
	}
}
