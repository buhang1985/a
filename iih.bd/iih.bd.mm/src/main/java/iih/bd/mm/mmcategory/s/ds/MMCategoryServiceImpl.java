package iih.bd.mm.mmcategory.s.ds;

import iih.bd.mm.mmcategory.bp.MmcaImportBp;
import iih.bd.mm.mmcategory.bp.SynchroMmcaBp;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.ds.IMMCategoryService;
import xap.mw.core.data.BizException;

/**
 * 医疗物品基本分类相关的领域服务类
 * @author wu.junhui
 *
 */
public class MMCategoryServiceImpl implements IMMCategoryService {

	@Override
	public void importMmcategory(MMCategoryDO[] mmCategoryDOList) throws BizException {
		
		MmcaImportBp bp = new MmcaImportBp();
		
		bp.exec(mmCategoryDOList);
	}

	@Override
	public void synchroMmca() throws BizException {

		SynchroMmcaBp bp = new SynchroMmcaBp();
		
		bp.exec();
	}
}
