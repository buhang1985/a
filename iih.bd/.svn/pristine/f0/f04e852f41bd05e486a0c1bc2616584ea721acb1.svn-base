package iih.bd.mm.mmcategory.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MmcaCuBeforeBp {
	
	public void exec(MMCategoryDO[] mmcaDOS) throws BizException {
		
		// ■ 参数校验
	    Map<String, MMCategoryDO> mmcaMap = this.validaPara(mmcaDOS);
	    
	    // ■ 是否允许更新
	    this.checkCanUpdate(mmcaDOS, mmcaMap);
	}

	private Map<String, MMCategoryDO> validaPara(MMCategoryDO[] mmcaDOS) throws BizException {
		
		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		
		if(mmcaDOS == null || mmcaDOS.length <= 0) {
			
			throw new BizException("传入物品基本分类数据为空。");
		}
		
		Map<String, MMCategoryDO> result = new HashMap<String, MMCategoryDO>();
		String[] ids = this.getMmcaIds(mmcaDOS);
		MMCategoryDO[] mmcaDOList = mmcaRSrv.findByIds(ids, FBoolean.TRUE);
		if(mmcaDOList == null || mmcaDOList.length <= 0) {
			
			throw new BizException("物品基本分类已被删除。");
		}
		
		for(MMCategoryDO mmcaDO : mmcaDOList) {
			
			result.put(mmcaDO.getId_mmca(), mmcaDO);
		}
		
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			if(!result.containsKey(mmcaDO.getId_mmca())) {
				
				throw new BizException("物品基本分类已被删除。");
			}
		}
		
		return result;
	}

	private String[] getMmcaIds(MMCategoryDO[] mmcaDOS) {
		
		List<String> ids = new ArrayList<String>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			ids.add(mmcaDO.getId_mmca());
		}
		
		return ids.toArray(new String[ids.size()]);
	}
	
	
	private void checkCanUpdate(MMCategoryDO[] mmcaDOS, Map<String, MMCategoryDO> mmcaMap) throws BizException {
		
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			MMCategoryDO oldMmcaDO = mmcaMap.get(mmcaDO.getId_mmca());
			if(!oldMmcaDO.getFg_price().equals(mmcaDO.getFg_price()) || 
					!oldMmcaDO.getFg_batch().equals(mmcaDO.getFg_batch()) ||
					!String.valueOf(oldMmcaDO.getSd_primode()).equals(String.valueOf(mmcaDO.getSd_primode())) ||
					!String.valueOf(oldMmcaDO.getPap()).equals(String.valueOf(mmcaDO.getPap()))) {
				
				CategoryRefCheckBp bp = new CategoryRefCheckBp();
				bp.checkCanUpdate(mmcaDO);
			}
		}
	}
}
