package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.blrefundaudit.d.BlRefundAuditDO;
import iih.bl.cg.blrefundaudit.i.IBlrefundauditCudService;
import iih.bl.cg.blwardrefund.d.BlRefundItemDO;
import iih.bl.cg.blwardrefund.i.IBlwardrefunddetailedCudService;
import iih.bl.cg.blwardrefund.i.IBlwardrefunddetailedRService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.dto.d.BlRefundApplyDetailDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 *   退费申请明细审核通过处理
 * @author Administrator
 *
 */
public class BlIpRefunfAuditApproveBP {
    public FBoolean exec(BlRefundApplyDetailDTO[] SelectApplyDetailDto) throws BizException{
    	  //退费审核增删改服务
    	 IBlrefundauditCudService blrefundauditCrudService =ServiceFinder.find(IBlrefundauditCudService.class);
    	 //退费明细查询服务
         IBlwardrefunddetailedRService iBlwardrefunddetailedRService =ServiceFinder.find(IBlwardrefunddetailedRService.class);
         //退费明细增删改服务
         IBlwardrefunddetailedCudService iBlwardrefunddetailedCudService =ServiceFinder.find(IBlwardrefunddetailedCudService.class);
         //退记账服务
         IBlCgAccountService iblcgAccountService = ServiceFinder.find(IBlCgAccountService.class);
    	 List<String> idcgList =new ArrayList<String>();
         for (BlRefundApplyDetailDTO dtos : SelectApplyDetailDto)
         {
             idcgList.add(dtos.getId_rfditm());
         }
         //生成确认申请单数据
         BlRefundAuditDO blRefundAudit =new BlRefundAuditDO();
         //确认时间
         blRefundAudit.setDt_chk(new FDateTime());
         //确认科室
         blRefundAudit.setId_dep_chk(Context.get().getDeptId());
         //确认人员
         blRefundAudit.setId_emp_chk(Context.get().getUserId());
         blRefundAudit.setStatus(DOStatus.NEW);
        //保存退费审核数据
         BlRefundAuditDO[] blRefundAudits =blrefundauditCrudService.save(new BlRefundAuditDO[] { blRefundAudit });
         if (!ArrayUtil.isEmpty(blRefundAudits))
         {
             //找到原申请明细
             BlRefundItemDO[] blRefundItems = iBlwardrefunddetailedRService.findByAttrValStrings("Id_cgip", idcgList.toArray(new String[]{}));
             for(BlRefundItemDO blRefundItemDo : blRefundItems)
             {
                 //审核通过
            	 blRefundItemDo.setId_su_rdfitm(IBlCustomFileConst.ID_AUDIT_ADOPT);
                 blRefundItemDo.setSd_su_rdfitm(IBlCustomFileConst.SD_AUDIT_ADOPT); 
                 blRefundItemDo.setId_rfdchk(blRefundAudits[0].getId_rfdchk());
                 blRefundItemDo.setStatus(DOStatus.UPDATED);
             }
             //更新原申请明细状态
             iBlwardrefunddetailedCudService.save(blRefundItems);
             //执行退记账操作
             BlCgRefundAccountSetDTO blCgAccountSetDTO = new BlCgRefundAccountSetDTO();
				blCgAccountSetDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
				blCgAccountSetDTO.setEu_rfdmode(RefundModeEnum.CG_KEY);
				List<BlCgRefundAccountDTO> cgRefundList= this.getBlCgRefundAccountDTO(blRefundItems);
                BlCgAccountRltDTO refundAccountForIp = iblcgAccountService.refundAccountForIp(cgRefundList.toArray(new BlCgRefundAccountDTO[]{}), blCgAccountSetDTO);
                if(refundAccountForIp.getFg_success().booleanValue()){
                	return FBoolean.TRUE;
                }else {
                	throw new BizException(refundAccountForIp.getErr_msg());
                }
         }
    	return FBoolean.FALSE;
    }
    /**
     * 组装退记账数据
     * @param blRefundItems
     * @return
     */
	private List<BlCgRefundAccountDTO> getBlCgRefundAccountDTO(BlRefundItemDO[] blRefundItems) {
		List<BlCgRefundAccountDTO> listDto = new ArrayList<BlCgRefundAccountDTO>();
		for (BlRefundItemDO itemDo : blRefundItems) {
			BlCgRefundAccountDTO dto =new BlCgRefundAccountDTO();
			dto.setId_cg(itemDo.getId_cgip());
			dto.setId_ent(itemDo.getId_ent());
			dto.setId_pat(itemDo.getId_pat());
			dto.setQuan(itemDo.getQuan());
			listDto.add(dto);
		}
		return listDto;
	}
}
