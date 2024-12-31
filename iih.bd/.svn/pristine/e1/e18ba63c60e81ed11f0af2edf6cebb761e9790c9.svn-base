package iih.bd.pp.s.samppri.bp;

import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppri.i.IBdSampPriItmDOCudService;
import iih.bd.pp.samppri.i.ISamppriMDOCudService;
import iih.bd.pp.samppri.i.ISamppriMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @Description:标本费用对照,标本费用明细保存
 * @author zheng.yx@founder.com.cn
 * @version：2019年4月11日 下午13:29:63 创建
 */
public class SaveSamppriBp {

	/**
	 * 主入口
	 * 
	 * @param sampPriDO
	 * @param bdSampPriItmDO
	 * @throws BizException
	 */
	public void exec(SampPriDO sampPriDO, BdSampPriItmDO bdSampPriItmDO) throws BizException {

		// 1.校验
		valadation(sampPriDO, bdSampPriItmDO);

		// 2.更新或新增
		SampPriDO rtn = updateOrNew(sampPriDO);

		// 3.保存
		save(rtn, bdSampPriItmDO);
	}

	/**
	 * 校验
	 * 
	 * @param sampPriDO
	 * @param bdSampPriItmDO
	 * @throws BizException
	 */
	private void valadation(SampPriDO sampPriDO, BdSampPriItmDO bdSampPriItmDO) throws BizException {
		if (sampPriDO == null || bdSampPriItmDO == null)
			throw new BizException("标本费用对照：标本信息不能为null！");
	}

	/**
	 * 更新或新增
	 * 
	 * @param sampPriDO
	 * @return
	 * @throws BizException
	 */
	private SampPriDO updateOrNew(SampPriDO sampPriDO) throws BizException {
		String id_samptp = sampPriDO.getId_samptp();
		SampPriDO[] sampPriDOs = ServiceFinder.find(ISamppriMDORService.class).findByAttrValString(SampPriDO.ID_SAMPTP, id_samptp);
		if (sampPriDOs == null) {
			sampPriDO.setStatus(DOStatus.NEW);
		} else {
			sampPriDOs[0].setStatus(DOStatus.UPDATED);
			return sampPriDOs[0];
		}
		return sampPriDO;

	}

	/**
	 * 保存
	 * 
	 * @param rtn
	 * @param bdSampPriItmDO
	 * @throws BizException
	 */
	private void save(SampPriDO rtn, BdSampPriItmDO bdSampPriItmDO) throws BizException {
		// 保存标本费用
		SampPriDO[] sampPriDOs = ServiceFinder.find(ISamppriMDOCudService.class).save(new SampPriDO[] { rtn });

		String id_samp_pri = sampPriDOs[0].getId_samp_pri();

		// 保存标本费用明细
		bdSampPriItmDO.setId_samp_pri(id_samp_pri);
		ServiceFinder.find(IBdSampPriItmDOCudService.class).save(new BdSampPriItmDO[] { bdSampPriItmDO });

	}

}
