package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blredapply.d.BlRefundApplyDO;
import iih.bl.cg.blredapply.i.IBlredapplyCudService;
import iih.bl.cg.blwardrefund.d.BlRefundItemDO;
import iih.bl.cg.blwardrefund.d.BlRefundTpEnum;
import iih.bl.cg.blwardrefund.i.IBlwardrefunddetailedCudService;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 保存退费申请
 * @author xy.zhou
 *
 */
public class BlSaveRefundApplyBP {

	public BlRefundApplyDO exec(NurseCompFeeItmDTO [] nFeeItmDTOs,String pattern) throws BizException{
		
		if(ArrayUtil.isEmpty(nFeeItmDTOs)){
			throw new BizException("申请退费数据为空！");
		}

		//生成退费单
		BlRefundApplyDO refundApply = this.saveRefundApply(nFeeItmDTOs);
		
		//回写关联记录fg_active
		updateRefundItem(nFeeItmDTOs);
		
		//生成退费单明细
		this.savaBlRefundItem(nFeeItmDTOs, refundApply);
		
		return refundApply;
		
	}
	
	/**
	 * 保存退费单
	 * @param nFeeItmDTOs
	 * @return
	 * @throws BizException
	 */
	private BlRefundApplyDO  saveRefundApply(NurseCompFeeItmDTO [] nFeeItmDTOs)throws BizException{
		
		IBlredapplyCudService iBlredapplyCudService=ServiceFinder.find(IBlredapplyCudService.class);
		BlRefundApplyDO applyDO=new BlRefundApplyDO();
		applyDO.setCode_rfdap(null);
		applyDO.setId_dep_ap(Context.get().getDeptId());
		applyDO.setId_emp_ap(Context.get().getStuffId());
		applyDO.setDt_ap(new FDateTime());
		applyDO.setDes("");
		applyDO.setSd_rfdaptp(IBlCustomFileConst.SD_NURSE_APPLY);
		applyDO.setId_rfdaptp(IBlCustomFileConst.ID_NURSE_APPLY);
		applyDO.setFg_canc(FBoolean.FALSE);
		applyDO.setStatus(DOStatus.NEW);
		BlRefundApplyDO[] blRefundApplyDOs = iBlredapplyCudService.save(new BlRefundApplyDO[]{applyDO});
		return blRefundApplyDOs[0];
	}
	/**
	 * 保存退费明细项目
	 * @param nFeeItmDTOs
	 * @param blRefundApplyDO
	 * @return
	 * @throws BizException
	 */
	private BlRefundItemDO [] savaBlRefundItem(NurseCompFeeItmDTO [] nFeeItmDTOs ,BlRefundApplyDO blRefundApplyDO)throws BizException{
		
		IBlwardrefunddetailedCudService icBlwardrefunddetailedCudService=ServiceFinder.find(IBlwardrefunddetailedCudService.class);
		List<BlRefundItemDO> bList=new ArrayList<>();
		for (int i = 0; i < nFeeItmDTOs.length; i++) {
			BlRefundItemDO blItemDO=new BlRefundItemDO();
			blItemDO.setId_pat(nFeeItmDTOs[i].getId_pat());
			blItemDO.setId_ent(nFeeItmDTOs[i].getId_ent());
			blItemDO.setId_rfdap(blRefundApplyDO.getId_rfdap());
			blItemDO.setSortno(i+1);
			blItemDO.setEu_rfditmtp(BlRefundTpEnum.CGDETAILED);
			blItemDO.setQuan(nFeeItmDTOs[i].getQuan_mend());
			blItemDO.setId_cgip(nFeeItmDTOs[i].getId_cgip());
			blItemDO.setId_or(nFeeItmDTOs[i].getId_or());
			blItemDO.setDes("");
			blItemDO.setSd_rfdaptp(IBlCustomFileConst.SD_NURSE_APPLY);
			blItemDO.setId_rfdaptp(IBlCustomFileConst.ID_NURSE_APPLY);
			blItemDO.setSd_su_rdfitm(IBlCustomFileConst.SD_INAPPLY);
			blItemDO.setId_su_rdfitm(IBlCustomFileConst.ID_INAPPLY);
			blItemDO.setFg_active(FBoolean.TRUE);
			blItemDO.setStatus(DOStatus.NEW);
			bList.add(blItemDO);
		}
		BlRefundItemDO[] blRefundItemDOs = icBlwardrefunddetailedCudService.save(bList.toArray(new BlRefundItemDO []{}));
		return blRefundItemDOs;
	}
	/**
	 * 回写项目明细活动状态
	 * @param nFeeItmDTOs
	 * @throws BizException
	 */
	private void updateRefundItem(NurseCompFeeItmDTO [] nFeeItmDTOs) throws BizException{
		
		List<String> cgipList=new ArrayList<>();
		for (NurseCompFeeItmDTO nurseCompFeeItmDTO : nFeeItmDTOs) {
			cgipList.add(nurseCompFeeItmDTO.getId_cgip());
		}
		StringBuilder str=new StringBuilder();
		str.append("update bl_rfd_itm set fg_active='N' where ");
		str.append(SqlUtils.getInSqlByIds("id_cgip",cgipList));
		new DAFacade().execUpdate(str.toString());
	}
}
