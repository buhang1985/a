package iih.pi.card.s.bp.cardrtnrpt;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.pi.card.act.d.PiCardActDO;
import iih.pi.card.act.i.IActCudService;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardCudService;
import iih.pi.card.card.i.ICardRService;
import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.card.iss.d.DirectEnum;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.desc.PiPatCardDODesc;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class CardBaceSaveBp {
	
	/**
	 * 退卡
	 * @param cardDto
	 * @throws BizException
	 */
	public void exec(CardrtnrptDTO cardDto) throws BizException{
		IBlpaypatCudService service = ServiceFinder.find(IBlpaypatCudService.class);
		IActCudService actservice = ServiceFinder.find(IActCudService.class);
		ICardRService cardFservice = ServiceFinder.find(ICardRService.class);
		ICardCudService cardSservice = ServiceFinder.find(ICardCudService.class);
		IPiPatCardDORService cardDoRservice = ServiceFinder.find(IPiPatCardDORService.class);
		IPiPatCardDOCudService cardDoCudservice = ServiceFinder.find(IPiPatCardDOCudService.class);
		
		if(cardDto==null)
			return;
		
		if(cardDto.getRefund()==FBoolean.TRUE){
			//患者预交金 INSERT 1条记录
			BlPrePayPatDO paypatdo = new BlPrePayPatDO();
			paypatdo.setStatus(DOStatus.NEW);
			paypatdo.setSd_paytp("17");
			paypatdo.setId_pat(cardDto.getId_pat());
			paypatdo.setEu_direct(DirectEnum.DISTRIBUTE);
			paypatdo.setAmt(cardDto.getBalance());
			paypatdo.setId_pm(cardDto.getPaymethod());
			paypatdo.setDt_pay(new FDateTime());
			paypatdo.setId_org_pay(Context.get().getOrgId());
			paypatdo.setId_dep_pay(Context.get().getDeptId());
			paypatdo.setId_emp_pay(Context.get().getStuffId());
			paypatdo.setFg_cc(FBoolean.FALSE);
			paypatdo.setId_incca(null);
			paypatdo.setCode_rep(null);
			paypatdo.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			paypatdo.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			
			service.save(new BlPrePayPatDO[]{paypatdo});
		}
		
		//就诊卡操作记录 INSERT 1条记录
		PiCardActDO actDo = new PiCardActDO();
		actDo.setStatus(DOStatus.NEW);
		actDo.setId_cardacttp(IPiDictCodeConst.ID_CARDACTTP_RETURN);
		actDo.setSd_cardacttp(IPiDictCodeConst.SD_CARDACTTP_RETURN);
		actDo.setId_emp_act(Context.get().getStuffId());
		actDo.setDt_act(new FDateTime());
		actDo.setId_cardiss(null);
		actDo.setId_patcard(cardDto.getId_patcard());
		actDo.setId_pat(cardDto.getId_pat());
		actDo.setId_card(cardDto.getId_card());
		actDo.setDes_act("退卡");
		
		//PI_CARD（就诊卡） UPDATE  1条记录
		PiCardDO caDo = cardFservice.findById(cardDto.getId_card());
		if(caDo!=null){
			caDo.setStatus(DOStatus.UPDATED);
			caDo.setEu_cardsu(0);
		}
				
		//删除对应的患者卡信息记录
		
		PiPatCardDO[] cardDos = cardDoRservice.find(PiPatCardDODesc.TABLE_ALIAS_NAME+".id_card ='"+cardDto.getId_card()
				+"'  and id_pat='"+cardDto.getId_pat()+"'", "", FBoolean.FALSE);
		if(cardDos!=null&&cardDos.length>0){
			cardDos[0].setStatus(DOStatus.DELETED);
			cardDos[0].setDs(1);
			cardDoCudservice.delete(new PiPatCardDO[]{cardDos[0]});
		}
				
		actservice.save(new PiCardActDO[]{actDo});
		cardSservice.save(new PiCardDO[]{caDo});
		
	}
}
