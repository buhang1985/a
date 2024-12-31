package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.meterial.d.MeterialAggDO;
import xap.mw.core.data.BizException;

public class MaterialDeBeforeBp {
	
	public void exec(MeterialAggDO[] mmAggDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(mmAggDOS);
		
		// ■ 验证数据是否允许删除
		this.checkCanDelete(mmAggDOS);
	}

	private void validaPara(MeterialAggDO[] mmAggDOS) throws BizException {
		
		if(mmAggDOS == null || mmAggDOS.length <= 0) {
			
			throw new BizException("传入物品基本信息为空。");
		}
	}
	
	private void checkCanDelete(MeterialAggDO[] mmAggDOS) throws BizException {
		
		MeterialRefCheckBp chkBp = new MeterialRefCheckBp();
		String[] mmIdList = this.getMmIdList(mmAggDOS);
		//判断物品是否关联了自定义项目
		if(chkBp.isRefByCustCategory(mmIdList)) {
			
			throw new BizException("物品关联了自定义分类项目，不允许删除。");
		}
		//判断物品是否存在期初数据
		if(chkBp.isStockPerInitExist(mmIdList)) {
			
			throw new BizException("物品存在期初数据，不允许删除。");
		}
		//判断物品是否有入库数据
		if(chkBp.isStockIn(mmIdList)) {
			
			throw new BizException("物品存在入库数据，不允许删除。");
		}
		//判断物品是否存在结存数据
		if(chkBp.isStockExist(mmIdList)) {
			
			throw new BizException("物品存在结存数据，不允许删除。");
		}
	}

	private String[] getMmIdList(MeterialAggDO[] mmAggDOS) {
		
		List<String> mmIdList = new ArrayList<String>();
		for(MeterialAggDO mmAggDO : mmAggDOS) {
			
			mmIdList.add(mmAggDO.getParentDO().getId_mm());
		}
		
		return mmIdList.toArray(new String[mmIdList.size()]);
	}
}
