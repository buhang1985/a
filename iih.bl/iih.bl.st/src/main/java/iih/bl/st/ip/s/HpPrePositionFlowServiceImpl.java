package iih.bl.st.ip.s;

import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.ip.i.IHpPrePositionFlowService;
import iih.bl.st.ip.s.bp.BliptfinUpdateFgHpBP;
import iih.bl.st.ip.s.bp.DoIpCancelSettleBP;
import iih.bl.st.ip.s.bp.GetHpPropDataBp;
import iih.bl.st.ip.s.bp.HpSettleBp;
import iih.bl.st.ip.s.bp.UpdateHpCgBackFlagBp;
import iih.bl.st.ip.s.bp.UploadMedicalDataBp;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

@Service(serviceInterfaces = { IHpPrePositionFlowService.class }, binding = Binding.JSONRPC)
public class HpPrePositionFlowServiceImpl implements IHpPrePositionFlowService {

	/**上传病案
	 * @param strIdEnt 就诊主键
	 * @param fg_xy 是否西医诊断
	 * @throws BizException
	 */
	@Override
	public void uploadMedicalData(String strIdEnt, FBoolean fg_xy) throws BizException {
		UploadMedicalDataBp handlerBp=new UploadMedicalDataBp();
		handlerBp.exec(strIdEnt, FBoolean.TRUE);
	}

	/**医保取消结算撤销更新记账数据
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean updateHpCgFlag(String strIdEnt,
			IpBillItmUploadHpDTO[] list, FBoolean isUploaded,FBoolean isFrontAfter)
			throws BizException {
		UpdateHpCgBackFlagBp handlerBp=new UpdateHpCgBackFlagBp();
		return handlerBp.exec(strIdEnt, list, isUploaded,isFrontAfter);
	}
	
	@Override
	public FBoolean updateHpCgByIdStIp(String strIdEnt, String strIdStIp, IpBillItmUploadHpDTO[] list) throws BizException {
		UpdateHpCgBackFlagBp handlerBp=new UpdateHpCgBackFlagBp();
		return handlerBp.exec(strIdEnt,strIdStIp, list);
	}

	/**结算操作
	 * @return 结算操作是否成功
	 * @throws BizException
	 */
	@Override
	public FBoolean doSettlement(InsureContext insureContext,String strIdEnt,String id_dep, String id_emp, FDateTime dt_end,InpPayRtnValDTO hpPayRtnValDto) throws BizException {
		HpSettleBp handerBp=new HpSettleBp();
		return handerBp.exec(insureContext,strIdEnt, id_dep, id_emp, dt_end,hpPayRtnValDto);
	}
	
	/**
	 * 根据记账主键进行结算
	 */
	@Override
	public FBoolean doSettlementByCgIps(InsureContext insureContext, String strIdEnt, String id_dep, String id_emp,
			FDateTime dt_end, InpPayRtnValDTO hpPayRtnValDto, String[] idCgIps) throws BizException {
		HpSettleBp handerBp=new HpSettleBp();
		return handerBp.exec2(insureContext,strIdEnt, id_dep, id_emp, dt_end,hpPayRtnValDto,idCgIps);
	}
	
	
	/**
	 * 住院取消结算
	 * 
	 * @param blStIpDO
	 *            结算DO
	 * @return
	 * @throws BizException
	 *
	 * @since 2017-7-13 11:33:26
	 */
	public FBoolean doCancelSettlement(InsureContext insureContext,BlStBaseInfo blStIpDO) throws BizException {
		DoIpCancelSettleBP cancelSettleBp = new DoIpCancelSettleBP();
		return cancelSettleBp.exec(insureContext,blStIpDO);
	}
	
	/** 修改业务逻辑，获取医保分摊数据
	 * @param insureContext
	 * @param blStIpDO
	 * @return
	 * @throws BizException
	 * @Date 2018-04-23
	 * @author yangyang
	 */
	@Override
	public CommonPropDataDTO getPropData(InsureContext insureContext, String strStId) throws BizException {
		GetHpPropDataBp handlerBp=new GetHpPropDataBp();
		return handlerBp.exec(insureContext, strStId);
	}

	@Override
	public BlCgIpTfInDO[] updateObject(BlCgIpTfInDO[] aggdos) throws BizException {
		// TODO Auto-generated method stub
		BliptfinUpdateFgHpBP bp = new BliptfinUpdateFgHpBP();
		return bp.exec(aggdos);
	}

	
}
