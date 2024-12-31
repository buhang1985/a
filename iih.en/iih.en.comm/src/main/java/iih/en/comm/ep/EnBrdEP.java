package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrddoMDORService;
import iih.en.que.board.i.IEnbrdsitedoCudService;
import iih.en.que.board.i.IEnbrdsitedoRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class EnBrdEP {
	/**
	 * 根据屏幕地址查询显示屏站点信息
	 * 
	 * @param enBrdSiteues
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO[] findByAddr(String addr) throws BizException{
		EnValidator.validateParam("addr", addr);
		IEnbrdsitedoRService brdCudService = ServiceFinder.find(IEnbrdsitedoRService.class);
		EnBrdSiteDO[] brdSites = brdCudService.findByAttrValString(EnBrdSiteDO.ADDR_BRD, addr);
		return brdSites;
	}
	/**
	 * 保存EnBrdSiteDO
	 * 
	 * @param enBrdSiteues
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO[] save(EnBrdSiteDO[] enBrdSiteues) throws BizException{
		EnValidator.validateParam("enBrdSiteues", enBrdSiteues);
		IEnbrdsitedoCudService brdCudService = ServiceFinder.find(IEnbrdsitedoCudService.class);
		EnBrdSiteDO[] brdSites = brdCudService.save(enBrdSiteues);
		return brdSites;
	}

	/**
	 * 根据唯一地址查询显示屏信息
	 * @param addr
	 * @return
	 * @throws BizException
	 */
	public EnBrdDO findEnBrdDOByAddr(String addr) throws BizException{
		EnValidator.validateParam("addr", addr);
		IEnbrddoMDORService brdCudService = ServiceFinder.find(IEnbrddoMDORService.class);
		EnBrdDO[] enBrds = brdCudService.findByAttrValString(EnBrdDO.ADDR, addr);
		return enBrds[0];
	}
}
