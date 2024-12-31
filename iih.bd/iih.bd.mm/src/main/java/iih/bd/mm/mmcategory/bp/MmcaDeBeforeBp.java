package iih.bd.mm.mmcategory.bp;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;

public class MmcaDeBeforeBp {
	
	public void exec(MMCategoryDO[] mmcaDOS) throws BizException {
		
		if(mmcaDOS == null || mmcaDOS.length <= 0) {
			
			return;
		}
		
		// ■ 验证物品基本分类是否允许删除
		this.checkCanDelete(mmcaDOS);
	}

	private void checkCanDelete(MMCategoryDO[] mmcaDOS) throws BizException {
		
		CategoryRefCheckBp bp = new CategoryRefCheckBp();
		bp.checkCanDelete(mmcaDOS);
	}
}
