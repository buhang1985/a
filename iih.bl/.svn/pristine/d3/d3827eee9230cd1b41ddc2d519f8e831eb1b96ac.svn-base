package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blrefundaudit.d.BlRefundAuditDO;
import iih.bl.cg.blrefundaudit.i.IBlrefundauditCudService;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.dto.d.BlRefundSrvItemDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存明细模式退费审核
 * @author xy.zhou
 *
 */
public class BlSaveDetailedApplyAuditBP {

	public void exec (BlRefundSrvItemDTO [] bItemDTOs) throws BizException{
		
		if(ArrayUtil.isEmpty(bItemDTOs)){
			throw new BizException("未获取到待审核保存的数据");
		}
		
		List<String> rejectList=new ArrayList<>();
		List<String> adoptList=new ArrayList<>();
		List<BlRefundSrvItemDTO> adoptItemList=new ArrayList<>();
		
		for (BlRefundSrvItemDTO blRefundSrvItemDTO : bItemDTOs) {
			
			if(FBoolean.TRUE.equals(blRefundSrvItemDTO.getFg_adopt())){
				adoptList.add(blRefundSrvItemDTO.getId_rfditm());
				adoptItemList.add(blRefundSrvItemDTO);
			}else{
				rejectList.add(blRefundSrvItemDTO.getId_rfditm());
			}
		}
		
		//审核记录
		BlRefundAuditDO blRefundAuditDO = this.saveBlRefundAuditDO();
		
		//保存通过
		this.updateAdoptItem(blRefundAuditDO, adoptList);
		
		//保存驳回
		this.updateRejectItem(blRefundAuditDO, rejectList);
		
		//调用记账接口记账
		this.addBlCgIp(adoptItemList);
	}
	
	/**
	 * 保存审核记录
	 * @return
	 * @throws BizException
	 */
	private BlRefundAuditDO saveBlRefundAuditDO()throws BizException{
		
		BlRefundAuditDO blAuditDO=new BlRefundAuditDO();
		IBlrefundauditCudService ibCudService=ServiceFinder.find(IBlrefundauditCudService.class);
		blAuditDO.setId_dep_chk(Context.get().getDeptId());
		blAuditDO.setId_emp_chk(Context.get().getStuffId());
		blAuditDO.setDt_chk(new FDateTime());
		BlRefundAuditDO[] blRefundAuditDOs = ibCudService.save(new BlRefundAuditDO[]{blAuditDO});
		return blRefundAuditDOs[0];
	}
	
	/**
	 * 回写通过的项目
	 * @throws BizException
	 */
	private void updateAdoptItem (BlRefundAuditDO blRefundAuditDO,List<String> adoptList)throws BizException{
		
		if(ListUtil.isEmpty(adoptList)){
			return;
		}
		StringBuilder str=new StringBuilder();
		str.append(" update bl_rfd_itm set id_rfdchk=?," );
		str.append(" sd_su_rdfitm='").append(IBlCustomFileConst.SD_AUDIT_ADOPT).append("',");
		str.append(" id_su_rdfitm='").append(IBlCustomFileConst.ID_AUDIT_ADOPT).append("' ");
		str.append(" where ");
		str.append(SqlUtils.getInSqlByIds("id_rfditm", adoptList));
		SqlParam param=new SqlParam();
		param.addParam(blRefundAuditDO.getId_rfdchk());
		new DAFacade().execUpdate(str.toString(),param);
	}
	
	/**
	 * 回写驳回的项目
	 * @throws BizException
	 */
	private void updateRejectItem (BlRefundAuditDO blRefundAuditDO,List<String> rejectList)throws BizException{
		
		if(ListUtil.isEmpty(rejectList)){
			return;
		}
		StringBuilder str=new StringBuilder();
		str.append(" update bl_rfd_itm set id_rfdchk=?," );
		str.append(" sd_su_rdfitm='").append(IBlCustomFileConst.SD_AUDIT_NOTADOPT).append("',");
		str.append(" id_su_rdfitm='").append(IBlCustomFileConst.ID_AUDIT_NOTADOPT).append("' ");
		str.append(" where ");
		str.append(SqlUtils.getInSqlByIds("id_rfditm", rejectList));
		SqlParam param=new SqlParam();
		param.addParam(blRefundAuditDO.getId_rfdchk());
		new DAFacade().execUpdate(str.toString(),param);
	}
	
	/**
	 * 新增退记账
	 * @param adoptItemList
	 * @throws BizException
	 */
	private void addBlCgIp(List<BlRefundSrvItemDTO> adoptItemList)throws BizException{
		
		if(ListUtil.isEmpty(adoptItemList)){
			return;
		}
		
		List<BlCgRefundAccountDTO> accDtoList = new ArrayList<BlCgRefundAccountDTO>();
		
		for (BlRefundSrvItemDTO blRefundSrvItemDTO : adoptItemList) {
			BlCgRefundAccountDTO accDto = new BlCgRefundAccountDTO();
			accDto.setId_ent(blRefundSrvItemDTO.getId_ent());
			accDto.setId_cg(blRefundSrvItemDTO.getId_cgip());
			accDto.setQuan(blRefundSrvItemDTO.getQuan());
			accDtoList.add(accDto);
		}
		
		BlCgRefundAccountSetDTO setDto = new BlCgRefundAccountSetDTO();
		setDto.setSrcfunc_des(IBlCgFuncConst.FUNC_IPBL_COLLECTOR_ADDREFUNDCOST);
		setDto.setEu_rfdmode(RefundModeEnum.CG_KEY);
		
		IBlCgAccountService cgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		cgAccountService.refundAccountForIp(accDtoList.toArray(new BlCgRefundAccountDTO[0]), setDto);
	}
}
