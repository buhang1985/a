package iih.bd.mm.mmcategory.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class MmcaCuAfterBp {
	
	public void exec(MMCategoryDO[] mmcaDOS, MMCategoryDO[] oriMmcaDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(mmcaDOS, oriMmcaDOS);
		
		// ■ 物品基本分类信息物化处理
		this.synconizeCategoryMeterial(mmcaDOS, oriMmcaDOS);
	}

	private void validaPara(MMCategoryDO[] mmcaDOS, MMCategoryDO[] oriMmcaDOS) throws BizException {
		
		if(mmcaDOS == null || mmcaDOS.length <= 0) {
			
			throw new BizException("传入物品基本分类数据为空。");
		}
		
		if(oriMmcaDOS == null || oriMmcaDOS.length <= 0) {
			
			throw new BizException("传入物品基本分类数据为空。");
		}
	}
	
	private void synconizeCategoryMeterial(MMCategoryDO[] mmcaDOS, MMCategoryDO[] oriMmcaDOS) throws BizException {
		
		//原物品基本分类信息
		Map<String, MMCategoryDO> oriMmcaMap = this.getOriMmcaMap(oriMmcaDOS);
		
		//分类下物品信息获取
		Map<String, List<MeterialDO>> mmcaMmMap = this.getMmDOMap(oriMmcaMap);
		
		List<MeterialDO> result = new ArrayList<MeterialDO>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			MMCategoryDO oldMmcaDO = oriMmcaMap.get(mmcaDO.getId_mmca());
			if(!oldMmcaDO.getFg_price().equals(mmcaDO.getFg_price()) || 
					!oldMmcaDO.getFg_batch().equals(mmcaDO.getFg_batch()) ||
					!String.valueOf(oldMmcaDO.getSd_primode()).equals(String.valueOf(mmcaDO.getSd_primode())) ||
					!String.valueOf(oldMmcaDO.getPap()).equals(String.valueOf(mmcaDO.getPap()))) {
				
				if(mmcaMmMap.containsKey(mmcaDO.getId_mmca())) {
					
					List<MeterialDO> mmDOList = mmcaMmMap.get(mmcaDO.getId_mmca());
					for(MeterialDO mmDO : mmDOList) {
						
						this.synconizeCategoryMeterial(mmcaDO, mmDO);
						result.add(mmDO);
					}
				}
			}
		}
		
		if(result != null && result.size() > 0) {
			
			IMeterialMDOCudService mmCudSrv = ServiceFinder.find(IMeterialMDOCudService.class);
			mmCudSrv.update(result.toArray(new MeterialDO[result.size()]));
		}
	}

	private Map<String, MMCategoryDO> getOriMmcaMap(MMCategoryDO[] oriMmcaDOS) {
		
		Map<String, MMCategoryDO> oriMmcaMap = new HashMap<String, MMCategoryDO>();
		for(MMCategoryDO mmcaDO : oriMmcaDOS) {
			
			oriMmcaMap.put(mmcaDO.getId_mmca(), mmcaDO);
		}
		return oriMmcaMap;
	}
	
	private Map<String, List<MeterialDO>> getMmDOMap(Map<String, MMCategoryDO> oriMmcaMap) throws BizException {
		
        IMeterialMDORService mmRSrv = ServiceFinder.find(IMeterialMDORService.class);
		
        Map<String, List<MeterialDO>> mmcaMmMap = new HashMap<String, List<MeterialDO>>();
		String[] mmcaIds = oriMmcaMap.keySet().toArray(new String[oriMmcaMap.keySet().size()]);
		MeterialDO[] mmDOS = mmRSrv.findByAttrValStrings(MeterialDO.ID_MMCA, mmcaIds);
		if(mmDOS == null || mmDOS.length <= 0) {
			
			return mmcaMmMap;
		}
		
		for(MeterialDO mmDO : mmDOS) {
			
			if(mmcaMmMap.containsKey(mmDO.getId_mmca())) {
				
				List<MeterialDO> mmDOList = mmcaMmMap.get(mmDO.getId_mmca());
				mmDOList.add(mmDO);
			} else {
				
				List<MeterialDO> mmDOList = new ArrayList<MeterialDO>();
				mmDOList.add(mmDO);
				mmcaMmMap.put(mmDO.getId_mmca(), mmDOList);
			}
		}
		
		return mmcaMmMap;
	}
	
	private void synconizeCategoryMeterial(MMCategoryDO mmcaDO, MeterialDO mmDO) {
		
		//物化处理
		mmDO.setStatus(DOStatus.UPDATED);
		if(IBdMmDictCodeConst.SD_PAP_CATEGORY.equals(mmDO.getSd_pap())) {
			
			//默认零售价计算方式
			mmDO.setSd_primode(mmcaDO.getSd_primode());
			mmDO.setId_primode(mmcaDO.getId_primode());
			//加成率
			mmDO.setRate_pap(mmcaDO.getPap());
			//是否批次管理
			mmDO.setFg_batch(mmcaDO.getFg_batch());
			//是否价格管理
			mmDO.setFg_price(mmcaDO.getFg_price());
		}
		
		if(IBdMmDictCodeConst.SD_MMTP_WEISHENG_HIGH.equals(mmDO.getSd_mmtp()) 
				|| IBdMmDictCodeConst.SD_MMTP_WEISHENG_COMM.equals(mmDO.getSd_mmtp())) {
			
			//是否批次管理
			mmDO.setFg_batch(mmcaDO.getFg_batch());
			//是否价格管理
			mmDO.setFg_price(mmcaDO.getFg_price());
		}
	}
}
