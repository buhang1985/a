package iih.bl.st.s.bp.ip;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.i.IBlStCmdService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 针对前置流程，住院退费时，需要重新结算
 * @author yangyang
 *
 */
public class BackPayReDoStBp {

	public void exec(String id_stip,InsureContext insureContext) throws BizException
	{
		//1、重构结算信息
		IBlstipRService iRService=ServiceFinder.find(IBlstipRService.class);
		//获取结算存储服务
		IBlstipCudService iCudSerivce=ServiceFinder.find(IBlstipCudService.class);
		//获取到原正向结算记录
		BlStIpDO blStIpDO = iRService.findById(id_stip);
		IBlStCmdService stCmdService=ServiceFinder.find(IBlStCmdService.class);
		//2、重做费用审核
		OperatorInfoDTO operatorInfoDto=new OperatorInfoDTO();
		operatorInfoDto.setId_dep(Context.get().getDeptId());
		operatorInfoDto.setId_emp(Context.get().getStuffId());
		operatorInfoDto.setId_grp(Context.get().getGroupId());
		operatorInfoDto.setId_org(Context.get().getOrgId());
		//重做住院审核
		stCmdService.saveIpAudit(blStIpDO.getId_ent(), operatorInfoDto);
		//重做医保审核
		stCmdService.saveHpAudit(blStIpDO.getId_ent(), operatorInfoDto);
		//这里需要重做自费结算
		stCmdService.doSettlement(blStIpDO.getId_pat(),blStIpDO.getId_ent(),"*",Context.get().getStuffId(),AppUtils.getServerDateTime());
		String strWhere=String.format(" id_ent='%s' and fg_pay='N'", blStIpDO.getId_ent());
		//获取最新的结算记录
		BlStIpDO[] stIpDoArr=iRService.find(strWhere, null,FBoolean.FALSE);
		if(ArrayUtils.isEmpty(stIpDoArr))
			throw new BizException("未查询到新生成的结算记录！");
		stIpDoArr[0].setCode_st(blStIpDO.getCode_st());
		stIpDoArr[0].setStatus(DOStatus.UPDATED);
		iCudSerivce.save(stIpDoArr);
		//3、更新原分摊数据
		HisPropertyRefHpDTO hisPropertyDTO=new HisPropertyRefHpDTO();
		InsureFacade facade=new InsureFacade(insureContext);
		hisPropertyDTO.setId_refold(id_stip);
		hisPropertyDTO.setId_ref(stIpDoArr[0].getId_stip());
		FArrayList fArrayList = facade.updateTmpPropDataOep(hisPropertyDTO);
	}
}
