package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blredapply.d.BlRefundApplyDO;
import iih.bl.cg.blredapply.i.IBlredapplyCudService;
import iih.bl.cg.blwardrefund.d.BlRefundItemDO;
import iih.bl.cg.blwardrefund.d.BlRefundTpEnum;
import iih.bl.cg.blwardrefund.i.IBlwardrefunddetailedCudService;
import iih.bl.cg.dto.d.BlOrderRefundListDTO;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 保存医嘱退费申请
 * @author xy.zhou
 *
 */
public class BlSaveOrdReundDataBP {


	public void  exec (BlOrderRefundListDTO [] ords)throws BizException{
		
		//数据校验与初始化
		List<BlCgIpDO> blList = this.DataVerificationAndInit(ords);
		
		//保存退费单
		BlRefundApplyDO refundApplyDO = this.saveRefundApply();
		
		//回写活动标志(一定要在保存退费明细之前)
		this.updateRefundItem(blList);
		
		//保存退费明细
		this.savaBlRefundItem(blList, refundApplyDO);
		

	}
	
	/**
	 * 数据校验与初始化
	 * @param ords
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BlCgIpDO> DataVerificationAndInit(BlOrderRefundListDTO [] ords)throws BizException{
		
		if(ArrayUtil.isEmpty(ords)){
			throw new BizException("退费医嘱为空！");
		}
		
		List<String> orIds=new ArrayList<>();
		for (BlOrderRefundListDTO blOrderRefundListDTO : ords) {
			orIds.add(blOrderRefundListDTO.getId_or());
		}
		List<BlCgIpDO> blList=(List<BlCgIpDO>)new DAFacade().findByAttrValStrings(BlCgIpDO.class, 
				BlCgIpDO.ID_OR, orIds.toArray(new String []{}), 
				new String []{BlCgIpDO.ID_CGIP,BlCgIpDO.QUAN,BlCgIpDO.QUAN_RET,BlCgIpDO.ID_ENT,BlCgIpDO.ID_PAT,BlCgIpDO.ID_OR});
		
		if(ListUtil.isEmpty(blList)){
			throw new BizException("未获取到医嘱对应明细数据！");
		}
		return blList;
	}
	/**
	 * 保存退费单
	 * @param nFeeItmDTOs
	 * @return
	 * @throws BizException
	 */
	private BlRefundApplyDO  saveRefundApply()throws BizException{
		
		IBlredapplyCudService iBlredapplyCudService=ServiceFinder.find(IBlredapplyCudService.class);
		BlRefundApplyDO applyDO=new BlRefundApplyDO();
		applyDO.setCode_rfdap(null);
		applyDO.setId_dep_ap(Context.get().getDeptId());
		applyDO.setId_emp_ap(Context.get().getStuffId());
		applyDO.setDt_ap(new FDateTime());
		applyDO.setDes("");
		applyDO.setSd_rfdaptp(IBlCustomFileConst.SD_DOCTOR_APPLY);
		applyDO.setId_rfdaptp(IBlCustomFileConst.ID_DOCTOR_APPLY);
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
	private BlRefundItemDO [] savaBlRefundItem( List<BlCgIpDO> blCgIpDOs ,BlRefundApplyDO blRefundApplyDO)throws BizException{
		
		IBlwardrefunddetailedCudService icBlwardrefunddetailedCudService=ServiceFinder.find(IBlwardrefunddetailedCudService.class);
		List<BlRefundItemDO> bList=new ArrayList<>();
		for (int i = 0; i < blCgIpDOs.size(); i++) {
			BlRefundItemDO blItemDO=new BlRefundItemDO();
			blItemDO.setId_pat(blCgIpDOs.get(i).getId_pat());
			blItemDO.setId_ent(blCgIpDOs.get(i).getId_ent());
			blItemDO.setId_rfdap(blRefundApplyDO.getId_rfdap());
			blItemDO.setSortno(i+1);
			blItemDO.setEu_rfditmtp(BlRefundTpEnum.CIORDER);
			if(blCgIpDOs.get(i).getQuan_ret()==null){
				blCgIpDOs.get(i).setQuan(new FDouble(0));
			}
			blItemDO.setQuan(blCgIpDOs.get(i).getQuan().sub(blCgIpDOs.get(i).getQuan_ret()));
			blItemDO.setId_cgip(blCgIpDOs.get(i).getId_cgip());
			blItemDO.setId_or(blCgIpDOs.get(i).getId_or());
			blItemDO.setDes("");
			blItemDO.setSd_rfdaptp(IBlCustomFileConst.SD_DOCTOR_APPLY);
			blItemDO.setId_rfdaptp(IBlCustomFileConst.ID_DOCTOR_APPLY);
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
	private void updateRefundItem( List<BlCgIpDO> blCgIpDOs) throws BizException{
		
		List<String> cgipList=new ArrayList<>();
		for (BlCgIpDO cgIpDO : blCgIpDOs) {
			cgipList.add(cgIpDO.getId_cgip());
		}
		StringBuilder str=new StringBuilder();
		str.append("update bl_rfd_itm set fg_active='N' where ");
		str.append(SqlUtils.getInSqlByIds("id_cgip",cgipList));
		new DAFacade().execUpdate(str.toString());
	}
}
