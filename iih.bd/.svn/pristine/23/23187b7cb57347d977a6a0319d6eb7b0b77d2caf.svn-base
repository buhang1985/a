package iih.bd.res.bizgrp.s.bp;

import iih.bd.res.bed.d.BedAttrDO;
import iih.bd.res.bed.i.IBedAttrDORService;
import iih.bd.res.bizgrp.d.BizGrpBedDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 对业务组床位计算字段床位特征赋值bp
 * @author guoyang
 *
 */
public class UpdateBedAttrsBp {
	
	public void exec(String[] ids, BizGrpBedDO[] bizGrpBedDOs) throws BizException {
		IBedAttrDORService bedAttrDORService = ServiceFinder.find(IBedAttrDORService.class);
		BedAttrDO[] bedAtttr = bedAttrDORService.findByAttrValStrings(BizGrpBedDO.ID_BED, ids);
		if (bedAtttr == null || bedAtttr.length <= 0) {
			return;
		}
		for (BizGrpBedDO bizGrpBedDO : bizGrpBedDOs) {
			updateAttrs(bizGrpBedDO, bedAtttr);
		}
	}

	/**
	 * 循环遍历床位特征集合，满足条件后赋值
	 * @param bizGrpBedDO
	 * @param bedAtttr
	 */
	private void updateAttrs(BizGrpBedDO bizGrpBedDO, BedAttrDO[] bedAtttr) {
		String bedAttr = "";
		for (BedAttrDO bedAttrDO : bedAtttr) {
			if (bedAttrDO.getId_bed().equals(bizGrpBedDO.getId_bed())) {
				bedAttr += ("".equals(bedAttr) ? bedAttr : "； ")
						+ (bedAttrDO.getBedattr_tp_name() + "：" + bedAttrDO.getAttrdef_name());
			}
		}
		bizGrpBedDO.setBedattrs(bedAttr);
	}
}
