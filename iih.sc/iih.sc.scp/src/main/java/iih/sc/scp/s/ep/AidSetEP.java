package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scp.aidset.d.ScPlanAidSetDO;
import iih.sc.scp.aidset.d.ScplanaidsetAggDO;
import iih.sc.scp.aidset.i.IScplanaidsetCudService;
import iih.sc.scp.aidset.i.IScplanaidsetMDORService;
import iih.sc.scp.aidset.i.IScplanaidsetRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 辅助样本设置EP
 * 
 * @author zhengcm
 * @date 2017-12-11 13:51:23
 *
 */
public class AidSetEP {

	/**
	 * 根据排班计划ID查询辅助设置AggDO
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 14:00:49
	 *
	 * @param id_scpl 计划ID
	 * @return 样本设置AggDO
	 * @throws BizException
	 */
	public ScplanaidsetAggDO getAggAidSetByPl(String id_scpl) throws BizException {
		ScValidator.validateParam("id_scpl", id_scpl);
		String where = String.format("id_scpl = '%s'", id_scpl);
		IScplanaidsetRService qryService = ServiceFinder.find(IScplanaidsetRService.class);
		ScplanaidsetAggDO[] aggDOs = qryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		return aggDOs[0];
	}

	/**
	 * 根据计划ID查询样本设置主DO
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 16:18:30
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 */
	public ScPlanAidSetDO getAidSetByPl(String id_scpl) throws BizException {
		ScValidator.validateParam("id_scpl", id_scpl);
		String where = String.format("id_scpl = '%s'", id_scpl);
		IScplanaidsetMDORService qryService = ServiceFinder.find(IScplanaidsetMDORService.class);
		ScPlanAidSetDO[] setDOs = qryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(setDOs)) {
			return null;
		}
		return setDOs[0];
	}

	/**
	 * 根据样本设置主键删除样本数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 14:03:08
	 *
	 * @param id_aidset 样本主键
	 * @throws BizException
	 */
	public void deleteAggAidSetById(String id_aidset) throws BizException {
		ScValidator.validateParam("id_aidset", id_aidset);
		IScplanaidsetRService qryService = ServiceFinder.find(IScplanaidsetRService.class);
		IScplanaidsetCudService cmdService = ServiceFinder.find(IScplanaidsetCudService.class);
		ScplanaidsetAggDO aggDO = qryService.findById(id_aidset);
		if (null != aggDO) {
			cmdService.delete(new ScplanaidsetAggDO[] { aggDO });
		}
	}

	/**
	 * 根据计划ID删除样本
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 20:00:51
	 *
	 * @param id_scpl
	 * @throws BizException
	 */
	public void deleteAggAidSetByPl(String id_scpl) throws BizException {
		ScplanaidsetAggDO aggDO = this.getAggAidSetByPl(id_scpl);
		if (null != aggDO) {
			IScplanaidsetCudService cmdService = ServiceFinder.find(IScplanaidsetCudService.class);
			cmdService.delete(new ScplanaidsetAggDO[] { aggDO });
		}
	}

	/**
	 * 新增样本设置AggDO
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 14:06:50
	 *
	 * @param aggDOs 样本设置AggDO数组
	 * @return 保存后的样本设置AggDO数组
	 * @throws BizException
	 */
	public ScplanaidsetAggDO[] insertAidSet(ScplanaidsetAggDO[] aggDOs) throws BizException {
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		IScplanaidsetCudService cmdService = ServiceFinder.find(IScplanaidsetCudService.class);
		return cmdService.insert(aggDOs);
	}

	/**
	 * 保存样本设置AggDO
	 * 
	 * @author zhengcm
	 * @date 2017-12-11 14:05:05
	 *
	 * @param aggDOs 样本设置AggDO数组
	 * @return 保存后的样本设置AggDO数组
	 * @throws BizException
	 */
	public ScplanaidsetAggDO[] saveAggAidSet(ScplanaidsetAggDO[] aggDOs) throws BizException {
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		IScplanaidsetCudService cmdService = ServiceFinder.find(IScplanaidsetCudService.class);
		return cmdService.save(aggDOs);
	}

}
