package iih.en.pv.s.bp.ip;

import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.d.desc.HpEntCodeDODesc;
import iih.bl.hp.hpentcode.i.IHpentcodeCudService;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.custom.EnIpCustomServiceUtils;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 住院医保取消登记
 * 
 * @author liubin
 *
 */
public class IpRegHpCancelBP {
	/**
	 * 住院医保取消登记
	 * 
	 * @param codeEnt
	 * @throws BizException
	 */
	public void exec(String codeEnt) throws BizException {
		//取消入院登记医保记录
		cancelEntCodeAh(codeEnt);
		//修改就诊记录为自费
		PatiVisitDO pv = updatePv(codeEnt);
		//修改en_ent_ip
		updateIp(pv);
		//删除就诊医保计划
		delEntHp(pv.getId_ent());
	}
	/**
	 * 取消入院登记医保记录
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void cancelEntCodeAh(String codeEnt) throws BizException{
		IHpentcodeRService rServ = ServiceFinder.find(IHpentcodeRService.class);
		String whereStr = String.format("%s.%s = '%s' and %s.%s = '%s' ", 
				HpEntCodeDODesc.TABLE_ALIAS_NAME, HpEntCodeDO.CODE_ENT, codeEnt,
				HpEntCodeDODesc.TABLE_ALIAS_NAME, HpEntCodeDO.FG_ACTIVE, FBoolean.TRUE);
		HpEntCodeDO[] entCodeAhs = rServ.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(entCodeAhs))
			return;
		HpEntCodeDO entCodeAh = entCodeAhs[0];
		entCodeAh.setFg_active(FBoolean.FALSE);
		entCodeAh.setFg_lock(FBoolean.FALSE);//解除锁定-fanlq-2018-11-06
		entCodeAh.setStatus(DOStatus.UPDATED);
		IHpentcodeCudService cudServ = ServiceFinder.find(IHpentcodeCudService.class);
		cudServ.update(new HpEntCodeDO[] { entCodeAh } );
	}
	/**
	 * 删除就诊医保计划
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void delEntHp(String entId) throws BizException{
		new EntHpEP().deleteByEntId(entId);
	}
	/**
	 * 修改就诊记录为自费
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private PatiVisitDO updatePv(String codeEnt) throws BizException{
		PatEP patEp = new PatEP();
		PiPatCaDO patCaDO = patEp.getPatDefaultCate();
		PvEP pvEp = new PvEP();
		String whereStr = String.format("Code = '%s'", codeEnt);
		PatiVisitDO[] pvs = pvEp.getPvByWhereStrWithOutRef(whereStr, null);
		PatiVisitDO pv = pvs[0];
		pv.setCode_hpmedkind(null);
		pv.setId_hp(null);
		pv.setId_patca(patCaDO.getId_patca());
		pv.setId_patcret(patCaDO.getId_patcrettp());
		pv.setId_pripat(patCaDO.getId_patpritp());
		pv.setStatus(DOStatus.UPDATED);
		pvEp.savePv(pv);
		return pv;
	}
	/**
	 * 住院信息修改
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	private void updateIp(PatiVisitDO pv) throws BizException{
		//根据医保设置医疗付费方式（调用客开方法处理）
		EnHpPatCaInParamsDTO inParam = new EnHpPatCaInParamsDTO();
		inParam.setId_ent(pv.getId_ent());
		inParam.setId_pat(pv.getId_pat());
		inParam.setId_patca(pv.getId_patca());
		inParam.setId_hp(pv.getId_hp());
		inParam.setCode_hpkind(null);
		inParam.setCode_hpmedkind(null);
		inParam.setCode_hppatca(null);
		inParam.setFg_selfpay(FBoolean.TRUE);
		UdidocDO payMethod = EnIpCustomServiceUtils.getPayMethodByHp(inParam);
		if(payMethod!=null){
			IpEP ep = new IpEP();
			InpatientDO ipInpatient = ep.getIpByEntId(pv.getId_ent());
			if(ipInpatient == null)
				throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
			ipInpatient.setStatus(DOStatus.UPDATED);
			ipInpatient.setSd_pay_mothod(payMethod.getCode());
			ipInpatient.setName_pay_mothod(payMethod.getName());
			ep.save(ipInpatient);
		}
	}
}
