package iih.bl.cg.service;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgipmend.bp.BlCgIpMendBp;
import iih.bl.cg.blcgoep.bp.OepRePricingCgBp;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blrecgip.bp.IpRePricingCgBp;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.pub.dto.d.BlOepSrvEventInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

@Service(serviceInterfaces = { IBlCgMaintainService.class }, binding = Binding.JSONRPC)
public class BlCgMaintainServiceImpl implements IBlCgMaintainService {

	@Override
	public BlCgIpDO[] doBlCgIpInfoMend(String id_ent,BlCgIpDO[] blcgOrArr) throws BizException {
		BlCgIpMendBp blCgIpMendBp = new BlCgIpMendBp();
		return blCgIpMendBp.setBlCgIpInfoMend(id_ent, blcgOrArr);
	}

	/**
	 * 对指定就诊进行住院重划价
	 * @param id_ent 就诊ID
	 * @param id_pripat_from 原价格分类
	 * @param id_pripat_to 新价格分类
	 * @param operatorInfo 操作员人员信息
	 * @return 划价成功，返回FBoolean.true,失败返回FBoolean.false
	 * @throws BizException
	 * @author 唐婵懿
	 */
	@Override
	public FBoolean doIpRePricingCg(String id_ent,String id_pripat_from,String id_pripat_to,OperatorInfoDTO operatorInfo)
			throws BizException {
		// TODO Auto-generated method stub
		IpRePricingCgBp bp=new IpRePricingCgBp();
		return bp.ipRePricingCgBp(id_ent, id_pripat_from, id_pripat_to, operatorInfo);
		
	}

	/**
	 * 对指定就诊进行门诊重划价
	 * 备注：只针对补费产生的数据（即尽在CG表中存在的数据）。如果是医嘱产生的数据，则不能直接在计费阶段修改价格分类
	 * @param id_pat 患者ID
	 * @param id_pripat_from 原价格分类
	 * @param id_pripat_to 新价格分类 
	 * @param operatorInfo 操作员人员信息
	 * @return 划价成功，返回FBoolean.true,失败返回FBoolean.false
	 * @throws BizException
	 * @author 唐婵懿
	 */
	@Override
	public FBoolean doOepRePricingCg(String id_pat,String id_ent, String id_pripat_from,
			String id_pripat_to, OperatorInfoDTO operatorInfo)
			throws BizException {
		OepRePricingCgBp bp=new OepRePricingCgBp();
		return bp.oepRePricingCgBp(id_pat,id_ent, id_pripat_from, id_pripat_to, operatorInfo);
	}
	
	/**
	 * 根据患者id_pat 查询门诊记账明细表bl_cg_itm_oep 是否 含有挂起的数据
	 * @param id_pat
	 * @author liwq
	 */
	public BlRecgOepDTO[] getBlCgItmOepFgSuspInfo(String id_pat) throws BizException {
		OepRePricingCgBp bp=new OepRePricingCgBp();
		return bp.getBlCgItmOepFgSuspInfo(id_pat);
	}
	
	/**
	 * 预交金记账
	 * */
	public FBoolean doOrSrvInfoAccount(BlOrderAppendBillParamDTO[] orSrvArr, String code_entp) throws BizException{
		IBLOrderAppendBillService service = ServiceFinder.find(IBLOrderAppendBillService.class);
		service.SetOrderAppendBill_ByItms_ci_kljz(orSrvArr,code_entp);
		
		List<String> list = new ArrayList<String>();
		List<OpAcc4EsDTO> acclist=new ArrayList<OpAcc4EsDTO>();
		for(BlOrderAppendBillParamDTO billDTO : orSrvArr){
			OpAcc4EsDTO accDTO=new OpAcc4EsDTO();
			accDTO.setCode_apply(billDTO.getCode_apply());
			accDTO.setCode_applytp(billDTO.getCode_applytp());
			accDTO.setFg_acc(billDTO.getOutpBillDTO().getFg_acc());
			accDTO.setFg_additm(accDTO.getFg_additm());
			accDTO.setFg_free(accDTO.getFg_free());
			accDTO.setFg_hpcg(accDTO.getFg_hpcg());
			accDTO.setId_cgitmoep(accDTO.getId_cgitmoep());
			accDTO.setId_cgoep(accDTO.getId_cgoep());
			accDTO.setId_ent(accDTO.getId_ent());
			accDTO.setId_or(accDTO.getId_or());
			accDTO.setId_orsrv(accDTO.getId_orsrv());
			accDTO.setId_pres(accDTO.getId_pres());
			acclist.add(accDTO);
		}
		
		BusinessEvent oepSettlementEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_ACC,IEventType.TYPE_UPDATE_AFTER,
				acclist.toArray(new OpAcc4EsDTO[acclist.size()]));
		EventDispatcher.fireEvent(oepSettlementEvent);	
		return FBoolean.TRUE;
	}
}
