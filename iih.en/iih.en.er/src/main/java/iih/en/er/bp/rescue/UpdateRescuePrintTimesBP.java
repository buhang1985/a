package iih.en.er.bp.rescue;

import iih.en.comm.ep.ErPreEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.outpatient.i.IOutpatientRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 计算并更新腕带打印次数(抢救)
 * @author fanlq
 *
 */
public class UpdateRescuePrintTimesBP {
	/**
	 * 计算并更新腕带打印次数(抢救)
	 * 
	 * @param idEnt @throws BizException @throws
	 */
	public void exec(String idEnt) throws BizException {
		//获取首次就诊id
		EnErPreDO[] obsErPres = new ErPreEP().getErPreRServ().findByAttrValString(EnErPreDO.ID_ENT_LAST, idEnt);
		if(obsErPres != null && obsErPres.length > 0 && !EnValidator.isEmpty(obsErPres[0].getId_ent_fst())){
			idEnt = obsErPres[0].getId_ent_fst();
		}
		IOutpatientRService opRService = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] opPatientDos = opRService.findByAttrValString(OutpatientDO.ID_ENT, idEnt);
		Integer oldPrintTime = 0;
		if (opPatientDos != null && opPatientDos.length > 0 && opPatientDos[0].getTimes_print() == null) {
			opPatientDos[0].setStatus(DOStatus.UPDATED);
			opPatientDos[0].setTimes_print(1);
		} else if (opPatientDos != null && opPatientDos.length > 0) {
			oldPrintTime = opPatientDos[0].getTimes_print();
			opPatientDos[0].setStatus(DOStatus.UPDATED);
			opPatientDos[0].setTimes_print(opPatientDos[0].getTimes_print() + 1);
		}else
			return;
		IOutpatientCudService cudService = ServiceFinder.find(IOutpatientCudService.class);
		opPatientDos = cudService.save(opPatientDos);
		new EnEvtHandle().insertRescuePrintWrist(opPatientDos[0], oldPrintTime);
		// 更新移动端腕带打印次数
		//this.updatePrintTimesForMob(opPatientDos[0], idEnt);
	}
	
	/**
	 * 更新移动端腕带打印次数
	 * 
	 * @param inPatientDo
	 * @param idEnt
	 * @throws BizException
	 */
	/*
	private void updatePrintTimesForMob(OutpatientDO opPatientDo, String idEnt) throws BizException {
		//获取移动端webservice地址
		String url = EnParamUtils.getEnIfWristBandURL();
		EnLogUtil.getInstance().logInfo("急诊抢救-更新移动护理端腕带打印次数，webservice地址:" + url);
		if (EnValidator.isEmpty(url))
			return;
		ReferenceDefinition ref = ReferenceBuilder.builder().withServiceType(EHisHisWS.class).withBinding(Binding.WS)
				.addProperty(ReferenceProperties.REFERENCE_PROPERTY_URI, url).build();
		EHisHisWS ws = (EHisHisWS) ServiceFinder.find(ref);

		IPatiMDORService qryService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs = qryService.find(
				PatDODesc.TABLE_ALIAS_NAME + ".id_pat = (select id_pat from en_ent where id_ent = '" + idEnt + "')",
				null, FBoolean.FALSE);
		WristPrintTimesBean resultBean = new WristPrintTimesBean();
		resultBean.setPatient_id(patDOs[0].getCode());
		resultBean.setMrn(patDOs[0].getCode());
		resultBean.setSeries(opPatientDo.getTimes_op().toString());
		resultBean.setPrintTimes(opPatientDo.getTimes_print().toString());
		//生成xml
		String xmlString = WsXmlUtils.serialize(resultBean);
		EnLogUtil.getInstance().logInfo("急诊抢救-更新移动护理端腕带打印次数，XML:" + xmlString);
		try {
			boolean b = ws.uplodeWristbandInfoToEwell(xmlString);
			if (!b)
				throw new BizException("急诊抢救-更新移动护理端腕带打印次数失败！");
		} catch (Exception e) {
			throw new BizException("急诊抢救-更新移动护理端腕带打印次数失败！");
		}
	}
	*/
}
