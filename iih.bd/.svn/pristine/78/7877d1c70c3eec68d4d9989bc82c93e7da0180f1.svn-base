package iih.bd.fc.orwf.s.bp;

import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.OrwfAggDO;
import iih.bd.fc.orwf.i.IOrwfCudService;
import iih.bd.fc.orwf.i.IOrwfRService;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.i.IWfCudService;
import iih.bd.fc.wf.i.IWfRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:医嘱流向删除
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月23日 下午3:54:18 创建
 */
public class OrWfCfgDeleteBp {

	/**
	 * 主入口
	 * @param inParams
	 * @throws BizException
	 */
	public void exec(String[] inParams) throws BizException {

		if (inParams == null || inParams.length < 1)
			return;

		WfAggDO[] wfs = getWfAggs(inParams);

		OrwfAggDO[] wfCfgs = getWfCfgAggs(inParams);

		delete(wfs, wfCfgs);
	}

	/**
	 * 获取医嘱流向
	 * @param id_wfs
	 * @return
	 * @throws BizException
	 */
	private WfAggDO[] getWfAggs(String[] id_wfs) throws BizException {
		return ServiceFinder.find(IWfRService.class).findByIds(id_wfs, FBoolean.FALSE);
	}

	/**
	 * 获取医嘱流向配置
	 * @param id_wfs
	 * @return
	 * @throws BizException
	 */
	private OrwfAggDO[] getWfCfgAggs(String[] id_wfs) throws BizException {
		return ServiceFinder.find(IOrwfRService.class).findByAttrValStrings(OrWfCfgDO.ID_WF, id_wfs);
	}

	/**
	 * 删除
	 * @param wfs
	 * @param wfCfgs
	 * @throws BizException
	 */
	private void delete(WfAggDO[] wfs, OrwfAggDO[] wfCfgs) throws BizException {
		if (wfs != null && wfs.length > 0)
			ServiceFinder.find(IWfCudService.class).delete(wfs);
		if (wfCfgs != null && wfCfgs.length > 0)
			ServiceFinder.find(IOrwfCudService.class).delete(wfCfgs);
	}
}
