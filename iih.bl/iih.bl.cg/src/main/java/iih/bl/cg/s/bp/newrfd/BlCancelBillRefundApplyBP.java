package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blrefundapplycanc.d.BlRefundApplyCancDO;
import iih.bl.cg.blrefundapplycanc.i.IBlrefundapplycancCudService;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消单据模式退费申请
 * @author xy.zhou
 *
 */
public class BlCancelBillRefundApplyBP {

	public void exec(String [] rdfapIds)throws BizException{
		
		if(ArrayUtil.isEmpty(rdfapIds)){
			throw new BizException("没有可以取消的退费单");
		}
		
		//生成撤销记录
		BlRefundApplyCancDO[] refundApplyCanc = this.saveRefundApplyCanc(rdfapIds);
		
		//回写申请单数据
		this.updateRefundApply(rdfapIds);
		
		//回写撤销明细
		this.updateSrvItm(refundApplyCanc);
	
	}
	/**
	 * 生成撤销记录
	 * @return
	 * @throws BizException
	 */
	private BlRefundApplyCancDO[]  saveRefundApplyCanc(String [] rdfapIds) throws BizException{
		IBlrefundapplycancCudService iBlrefundapplycancCudService=ServiceFinder.find(IBlrefundapplycancCudService.class);
		List<BlRefundApplyCancDO> bCancDOs=new ArrayList<>();
		for (String rdfapId  : rdfapIds) {
			BlRefundApplyCancDO bCancDO=new BlRefundApplyCancDO();
			bCancDO.setId_rfdap(rdfapId);
			bCancDO.setId_dep_canc(Context.get().getDeptId());
			bCancDO.setId_emp_canc(Context.get().getStuffId());
			bCancDO.setDt_canc(new FDateTime());
			bCancDO.setStatus(DOStatus.NEW);
			bCancDOs.add(bCancDO);
		}
	
		BlRefundApplyCancDO[] blRefundApplyCancDOs = iBlrefundapplycancCudService.save(bCancDOs.toArray(new BlRefundApplyCancDO []{} ));

		return blRefundApplyCancDOs;
	}
	
	/**
	 * 回写明细撤销信息
	 * @param nFeeItmDTOs
	 * @param bApplyCancDO
	 * @throws BizException
	 */
	private void updateSrvItm(BlRefundApplyCancDO[] refundApplyCanc) throws BizException{
	
		for (BlRefundApplyCancDO blRefundApplyCancDO : refundApplyCanc) {
			
			StringBuilder str=new StringBuilder();
			str.append(" update bl_rfd_itm set id_rfdcanc=?," );
			str.append(" sd_su_rdfitm='").append(IBlCustomFileConst.SD_REVOKE).append("',");
			str.append(" id_su_rdfitm='").append(IBlCustomFileConst.ID_REVOKE).append("' ");
			str.append(" where id_rfdap=? ");
			SqlParam param=new SqlParam();
			param.addParam(blRefundApplyCancDO.getId_rfdcanc());
			param.addParam(blRefundApplyCancDO.getId_rfdap());
			new DAFacade().execUpdate(str.toString(),param);
		}
	}
	/**
	 * 回写撤销明细
	 * @param rfdapIds
	 * @throws BizException
	 */
	private void updateRefundApply(String [] rfdapIds) throws BizException{
		
		StringBuilder str=new StringBuilder();
		str.append("update bl_rfd_ap set fg_canc='Y' where ");
		str.append(SqlUtils.getInSqlByBigIds("id_rfdap", rfdapIds));
		new DAFacade().execUpdate(str.toString());
	}
}
