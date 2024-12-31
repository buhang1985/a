package iih.bd.fc.wf.s.bp;

import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.i.IWfRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class getWfAggListBp {

	/**
	 * 医嘱流向配置，获取流向列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public WfAggDO[] exec(String Code_entp) throws BizException {

		// 1、检索数据
		WfAggDO[] aggDOS = getAggDOList(Code_entp);

		// 2、组装数据
		packageAggDOS(aggDOS);

		return aggDOS;
	}

	/**
	 * 获取全部流向集合
	 * 
	 * @param Code_entp
	 * @return
	 * @throws BizException
	 */
	private WfAggDO[] getAggDOList(String Code_entp) throws BizException {

		IWfRService findService = ServiceFinder.find(IWfRService.class);

		String whereStr = " a0.ds=0";

		if (!StringUtil.isEmpty(Code_entp)) {

			whereStr = " and a0.code_entp='" + Code_entp + "'";
		}

		return findService.find(whereStr, "a0.name", FBoolean.FALSE);

	}

	/**
	 * 组装数据
	 * 
	 * @param aggDOS
	 * @throws BizException
	 */
	private void packageAggDOS(WfAggDO[] aggDOS) throws BizException {

		packageWfAggBp bp = new packageWfAggBp();

		bp.exec(aggDOS);
	}

}
