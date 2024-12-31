package iih.en.que.s.bp.pharm;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresRService;
import iih.en.comm.validator.EnValidator;
import iih.en.que.i.ICalcPriService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取可发药窗口
 * @author yank
 *
 */
public class GetCanDispenseSiteBP {
	/**
	 * 获取可发药窗口
	 * @param entId 就诊id
	 * @param pharmDepId 药房科室id
	 * @param presId 处方id
	 * @param presTpId 处方类型id
	 * @return 站点集合
	 * @throws BizException
	 */
	public QueSiteDO[] exec(String entId,String pharmDepId,String presId,String presTpId) throws BizException{
		EnValidator.validateParam("就诊id", entId);
		EnValidator.validateParam("药房科室id", pharmDepId);
		EnValidator.validateParam("处方id", presId);
		EnValidator.validateParam("处方类型id", presTpId);
		
		
		//1、获取科室所有可用站点
		GetDeptSiteBP getDeptSiteBP = new GetDeptSiteBP();
		QueSiteDO[] sites = getDeptSiteBP.exec(pharmDepId);
		if(sites==null || sites.length==0){
			return null;
		}
		
		//2、匹配合理站点
		//2.1 加载优先级DTO
		ICalcPriService calcPriService = ServiceFinder.find(ICalcPriService.class);
		PriorityDTO priDTO = calcPriService.getEntInfo4CalPri(entId);
		this.setPres(priDTO, presId);// 设置处方数据
		
		//2.2 过滤出匹配的站点
		CheckSiteMatchBP checkMatchBP = new CheckSiteMatchBP();	
		List<QueSiteDO> siteList = new ArrayList<>();
		for(QueSiteDO site : sites){
			if(!FBoolean.TRUE.equals(priDTO.getFg_base())){
				if(!PauseEnum.ONLINE.equals(site.getEu_pause()))
					continue;
			}
			if(checkMatchBP.isMeet(site.getId_quesite(), priDTO)){
				siteList.add(site);//添加匹配的站点
			}
		}		
		return siteList.toArray(new QueSiteDO[0]);
	}
	/**
	 * 设置处方数据
	 * 
	 * @param priDTO
	 * @param presId 处方ID
	 * @throws BizException
	 */
	private void setPres(PriorityDTO priDTO, String presId) throws BizException {
		IPresRService presRService = ServiceFinder.find(IPresRService.class);
		CiPresDO presDO = presRService.findById(presId);
		if (presDO != null) {
			priDTO.setId_prestp(presDO.getId_prestp());// 处方类型
			priDTO.setFg_base(presDO.getFg_base());// 是否基数药
		}
	}
}
