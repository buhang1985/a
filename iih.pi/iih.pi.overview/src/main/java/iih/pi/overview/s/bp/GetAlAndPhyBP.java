package iih.pi.overview.s.bp;

import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.overview.overview.d.PiPatPhyDO;
import iih.pi.overview.overview.s.OverviewMDOCrudServiceImpl;
import iih.pi.overview.overview.s.PiPatAlDOCrudServiceImpl;
import iih.pi.overview.overview.s.PiPatPhyDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 只查询过敏史和生理状况类
 * @author ly
 *
 */
public class GetAlAndPhyBP {

	/**
	 * 只查询过敏史和生理状态
	 * @param patid 患者id
	 * @return
	 * @throws BizException
	 */
	public OverviewAggDO exec(String patid) throws BizException {
		
		if(StringUtil.isEmptyWithTrim(patid))
			return null;
		
		OverviewAggDO result = new OverviewAggDO();
		
		OverviewMDOCrudServiceImpl mService = new OverviewMDOCrudServiceImpl();
		PiPatDO patDo = mService.findById(patid);
		
		if(patDo == null){
			return null;
		}
		
		if(FBoolean.TRUE.equals(patDo.getFg_invd())){
			throw new BizException("该患者已失效,患者id：" + patid);
		}
		
		String whereSql = "id_pat = '" + patid + "'";
		
		PiPatAlDOCrudServiceImpl alService = new PiPatAlDOCrudServiceImpl();
		PiPatAlDO[] alDos = alService.find(whereSql, "", FBoolean.FALSE);
		
		PiPatPhyDOCrudServiceImpl phyService = new PiPatPhyDOCrudServiceImpl();
		PiPatPhyDO[] phyDos = phyService.find(whereSql, "", FBoolean.FALSE);
		
		result.setParentDO(patDo);
		result.setPiPatAlDO(alDos);
		result.setPiPatPhyDO(phyDos);
		
		return result;
	}
}
