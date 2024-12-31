package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blrefundapplycanc.d.BlRefundApplyCancDO;
import iih.bl.cg.blrefundapplycanc.i.IBlrefundapplycancCudService;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
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
 * 取消明细模式退费申请
 * @author xy.zhou
 *
 */
public class BlCancelDetailedRefundApplyBP {

	public void exec(NurseCompFeeItmDTO [] nFeeItmDTOs,String pattern) throws BizException{
		
		if(ArrayUtil.isEmpty(nFeeItmDTOs)){
			throw new BizException("取消申请退费数据为空！");
		}
		
		//生成撤销记录
		BlRefundApplyCancDO refundApplyCanc = this.saveRefundApplyCanc();
		//回写撤销项目
		this.updateSrvItm(nFeeItmDTOs, refundApplyCanc);
	}
	
	/**
	 * 生成撤销记录
	 * @return
	 * @throws BizException
	 */
	private BlRefundApplyCancDO saveRefundApplyCanc() throws BizException{
		IBlrefundapplycancCudService iBlrefundapplycancCudService=ServiceFinder.find(IBlrefundapplycancCudService.class);
		BlRefundApplyCancDO bCancDO=new BlRefundApplyCancDO();
		bCancDO.setId_dep_canc(Context.get().getDeptId());
		bCancDO.setId_emp_canc(Context.get().getStuffId());
		bCancDO.setDt_canc(new FDateTime());
		bCancDO.setStatus(DOStatus.NEW);
		BlRefundApplyCancDO[] blRefundApplyCancDOs = iBlrefundapplycancCudService.save(new BlRefundApplyCancDO []{bCancDO});
		return blRefundApplyCancDOs[0];
	}
	/**
	 * 回写明细撤销信息
	 * @param nFeeItmDTOs
	 * @param bApplyCancDO
	 * @throws BizException
	 */
	private void updateSrvItm(NurseCompFeeItmDTO [] nFeeItmDTOs,BlRefundApplyCancDO bApplyCancDO) throws BizException{
	
		List<String> rfdapList=new ArrayList<>();
		for (NurseCompFeeItmDTO nurseCompFeeItmDTO : nFeeItmDTOs) {
			rfdapList.add(nurseCompFeeItmDTO.getId_rfditm());
		}
		StringBuilder str=new StringBuilder();
		str.append(" update bl_rfd_itm set id_rfdcanc=?," );
		str.append(" sd_su_rdfitm='").append(IBlCustomFileConst.SD_REVOKE).append("',");
		str.append(" id_su_rdfitm='").append(IBlCustomFileConst.ID_REVOKE).append("' ");
		str.append(" where ");
		str.append(SqlUtils.getInSqlByIds("id_rfditm", rfdapList));
		SqlParam param=new SqlParam();
		param.addParam(bApplyCancDO.getId_rfdcanc());
		new DAFacade().execUpdate(str.toString(),param);
	}
}
