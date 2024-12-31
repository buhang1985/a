package iih.bd.res.bizgrp.s.bp;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDORService;
import iih.bd.res.bizgrp.d.BizGrpBedDO;
import iih.bd.res.bizgrp.d.BizgrpAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 对查询出的业务组agg的子DO业务组床位数据进行更新操作，
 * 赋上计算字段，床位所属病区，床位状态，床位特征
 * @author guoyang
 *
 */
public class UpdateBizGrpBedBp {

	public void exec(BizgrpAggDO bizgrpAggDO) throws BizException {
		
		if(bizgrpAggDO == null)
			return;
		
		BizGrpBedDO[] bizGrpBedDOs = bizgrpAggDO.getBizGrpBedDO();
		if(bizGrpBedDOs == null || bizGrpBedDOs.length <= 0)
			return;
		
		String[] ids = getIdbed(bizGrpBedDOs);
		updateDeptNameAndsuName(ids, bizGrpBedDOs);
		updateBedAttrs(ids, bizGrpBedDOs);
	}

	/**
	 * 更新业务组床位的计算字段床位所属病区，床位状态
	 * @param ids 
	 * @param bizGrpBedDO
	 * @throws BizException 
	 */
	private void updateDeptNameAndsuName(String[] ids, BizGrpBedDO[] bizGrpBedDOs) throws BizException {
		IBedMDORService bdBedMDORService = ServiceFinder.find(IBedMDORService.class);
		Bdbed[] beds = bdBedMDORService.findByIds(ids, FBoolean.FALSE);
		if (beds == null || beds.length <= 0) {
			 return;
		}
		for (BizGrpBedDO bizGrpBedDO : bizGrpBedDOs) {
			updateDeptName(bizGrpBedDO, beds);
			updateSuName(bizGrpBedDO, beds);
		}
	}

	/**
	 * 循环拿到的床位数据进行遍历，符合条件进行状态名称赋值
	 * @param bizGrpBedDO
	 * @param bed
	 */
	private void updateDeptName(BizGrpBedDO bizGrpBedDO, Bdbed[] beds) {
		for (Bdbed bdbed : beds) {
			if (bdbed.getId_bed().equals(bizGrpBedDO.getId_bed())) {
				bizGrpBedDO.setDept_name(bdbed.getDept_name());
				break;
			}
		}
	}
	
	/**
	 * 循环拿到的床位数据进行遍历, 符合条件进行病区名称赋值
	 * @param bizGrpBedDO
	 * @param beds
	 */
	private void updateSuName(BizGrpBedDO bizGrpBedDO, Bdbed[] beds) {
		for (Bdbed bdbed : beds) {
			if (bdbed.getId_bed().equals(bizGrpBedDO.getId_bed())) {
				bizGrpBedDO.setBedsu_name(bdbed.getBedsu_name());
				break;
			}
		}
	}

	/**
	 * 更新业务组床位的计算字段床位特征
	 * @param ids 
	 * @param bizGrpBedDO
	 * @throws BizException 
	 */
	private void updateBedAttrs(String[] ids, BizGrpBedDO[] bizGrpBedDOs) throws BizException {
		UpdateBedAttrsBp bp = new UpdateBedAttrsBp();
		bp.exec(ids, bizGrpBedDOs);
	}
	
	/**
	 * 获取业务组床位的集合的床位id
	 * @param bizGrpBedDOs
	 * @return
	 */
	private String[] getIdbed(BizGrpBedDO[] bizGrpBedDOs) {
		String[] ids = new String[bizGrpBedDOs.length];
		for (int i = 0; i < bizGrpBedDOs.length; i++) {
			ids[i] = bizGrpBedDOs[i].getId_bed();
		}
		return ids;
	}

}
