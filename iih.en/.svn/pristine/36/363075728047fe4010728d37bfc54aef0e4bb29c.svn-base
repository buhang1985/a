package iih.en.pv.s.rule;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.ChgHp4EsDTO;
import iih.en.pv.inpatient.dto.d.EuChgHpTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.event.IpHpChgEvent;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

public class IpHpChgRule implements IRule<PatiVisitDO> {

	private PatiVisitDO[] originvos;
	
	public IpHpChgRule(PatiVisitDO[] originvos){
		this.originvos = originvos;
	}

	@Override
	public void process(PatiVisitDO... params) throws BizException {
		if(EnValidator.isEmpty(params) || EnValidator.isEmpty(originvos))
			return;
		@SuppressWarnings("unchecked")
		Map<String, PatiVisitDO> map = (Map<String, PatiVisitDO>) MapUtils.convertArrayToMap(originvos, PatiVisitDO.ID_ENT);
		for(PatiVisitDO param : params) {
			if(map.containsKey(param.getId_ent()))
				this.fireChgHpEvent(map.get(param.getId_ent()), param);
		}
	}
	/**
	 * 发送住院医保改变事件
	 * 
	 * @param originvo
	 * @param curPaVisit
	 * @throws BizException
	 */
	private void fireChgHpEvent(PatiVisitDO originvo, PatiVisitDO curPaVisit) throws BizException {
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(curPaVisit.getCode_entp()))
			return;
		ChgHp4EsDTO es = new ChgHp4EsDTO();
		String euChgHpTp = null;
		if(EnValidator.isEmpty(originvo.getId_hp())){
			if(!EnValidator.isEmpty(curPaVisit.getId_hp())){
				euChgHpTp = EuChgHpTp.SELFTOHPPAY;
				es.setId_hp(curPaVisit.getId_hp());
			}
		}else{
			if(EnValidator.isEmpty(curPaVisit.getId_hp()))
				euChgHpTp = EuChgHpTp.HPTOSELFPAY;
			else {
				if(!originvo.getId_hp().equals(curPaVisit.getId_hp())){
					euChgHpTp = EuChgHpTp.HPTOOTHERHPPAY;
					es.setId_hp(curPaVisit.getId_hp());
				}
			}
		}
		if(EnValidator.isEmpty(euChgHpTp))
			return;
		es.setId_ent(curPaVisit.getId_ent());
		es.setId_pat(curPaVisit.getId_pat());
		es.setEu_chghp(euChgHpTp);
		new IpHpChgEvent().invoke(es);
	}
}
