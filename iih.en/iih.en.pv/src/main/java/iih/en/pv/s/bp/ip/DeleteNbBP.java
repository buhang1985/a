package iih.en.pv.s.bp.ip;

import iih.bl.cg.service.i.IBLChargesService;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntWgEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.pi.reg.i.IPiRegMaintainService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除新生儿记录BP
 * 
 * @author zhengcm
 * @date 2016-08-10 09:22:53
 *
 */
public class DeleteNbBP {
	/**
	 * 删除新生儿记录
	 * 
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(NewbornDTO nbDTO) throws BizException {
	    if (null == nbDTO) {
            return;
        }
        NewbornDO nbDO = this.qryNewbornDO(nbDTO);
        
        nbDO.setStatus(DOStatus.DELETED);
		if (null == nbDO) {
			return;
		}
		// 1、校验是否可删除
		this.validate(nbDO);

		// 2、删除新生儿就诊住院信息
		new IpEP().deleteByEntId(nbDO.getId_ent_bb());

		// 3、删除新生儿就诊联系人信息
		new EntContEP().deleteEntContByEntId(nbDO.getId_ent_bb());

		// 4、删除新生儿就诊医疗组信息
		new EntWgEP().deleteEntWgByEntId(nbDO.getId_ent_bb());

		// 5、删除新生儿就诊人员信息
		new EntEmpEP().deleteEnEmpByEntId(nbDO.getId_ent_bb());

		// 6、删除新生儿记录信息
		new NbEP().deleteNbDOs(new NewbornDO[] { nbDO });

		// 7、删除新生儿患者联系人信息
		new PatEP().deletePatContByPatId(nbDO.getId_pat_bb());

		// 8、删除新生儿患者就诊信息
		new PvEP().deleteEntById(nbDO.getId_ent_bb());

		// 9、更新新生儿母亲就诊住院信息
		new NbEP().updateMomEntIpInfo(nbDO);

		// 10、调整新生儿出生顺序
		this.ajustBabyOrder(nbDO);

		// 11、删除新生儿患者信息
		this.deleteNewbornPatInfo(nbDO);
	}
	
	/**
     * 根据id查询do
     * @throws BizException 
     */
    private NewbornDO qryNewbornDO(NewbornDTO nbDTO) throws BizException {
        // 新生儿记录维护服务
        INewbornRService qryservice = ServiceFinder.find(INewbornRService.class);
        NewbornDO newbornDO = qryservice.findById(nbDTO.getId_entnb());
        return newbornDO;
    }

	/**
	 * 校验是否允许删除
	 *
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void validate(NewbornDO nbDO) throws BizException {
		// 检查费用
		if (this.checkConsume(nbDO.getId_ent_bb())) {
			throw new BizException(IEnMsgConst.ERROR_NEWBORN_HAS_FEE);
		}
		// 检查患者是否存在诊断
		if (this.checkPatDi(nbDO.getId_ent_bb())) {
			throw new BizException(IEnMsgConst.ERROR_NEWBORN_HAS_DI);
		}
		// 检查医嘱
		if (!EnValidator.isEmpty(this.checkOR(nbDO.getId_ent_bb()))) {
			throw new BizException(IEnMsgConst.ERROR_NEWBORN_HAS_ORDER);
		}
		// 检查患者是否存在住院病历
		if (this.checkPatMr(nbDO.getId_ent_bb())) {
			throw new BizException(IEnMsgConst.ERROR_NEWBORN_HAS_PAPER);
		}
		//检查患者是否是母婴分床状态，fanlq-2019-07-02
		if (FBoolean.TRUE.equals(nbDO.getFg_sepa())) {
			throw new BizException(IEnMsgConst.ERROR_NEWBORN_HAS_SEPA);
		}
	}

	/**
	 * 调整该母亲所有新生儿的出生顺序
	 * 
	 * @author zhengcm
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 */
	private void ajustBabyOrder(NewbornDO nbDO) throws BizException {
		NewbornDO[] allBabyDOs = new NbEP().getNbListByMomEnt(nbDO.getId_ent_mom());
		if (EnValidator.isEmpty(allBabyDOs)) {
			return;
		}
		int order = 0;
		for (NewbornDO babyDO : allBabyDOs) {
			order = order + 1;
			babyDO.setStatus(DOStatus.UPDATED);
			babyDO.setNo_bb(order);
		}
		new NbEP().updateNbDOs(allBabyDOs);
	}

	/**
	 * 检查费用
	 * 
	 * @author zhengcm
	 * @param entId 就诊ID
	 * @return 是否有费用的布尔值
	 * @throws BizException
	 */
	private boolean checkConsume(String entId) throws BizException {
		// 费用查询服务
		IBLChargesService blservice = ServiceFinder.find(IBLChargesService.class);
		FDouble amount = blservice.GetInpChargesByIdEnt(entId);
		if (amount.doubleValue() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 检查医嘱
	 * 
	 * @author zhengcm
	 * @param entId 就诊ID
	 * @return 检查医嘱的结果
	 * @throws BizException
	 */
	private String checkOR(String entId) throws BizException {
		// 医嘱查询服务
		ICiOrdQryService ciservice = ServiceFinder.find(ICiOrdQryService.class);
		String errorMsg = ciservice.canDischarge(entId);
		return errorMsg;
	}

	/**
	 * 检查是否存在诊断
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkPatDi(String id_ent) throws BizException {
		// 查询就诊临床诊断
		IEntdiRService diQryService = ServiceFinder.find(IEntdiRService.class);
		String cond = String.format("id_ent = '%s'", id_ent);
		EntDiDO[] diDOs = diQryService.find(cond, null, FBoolean.FALSE);
		if (EnValidator.isEmpty(diDOs)) {
			return false;
		}
		return true;
	}

	/**
	 * 检查是否存在住院病历
	 *
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkPatMr(String id_ent) throws BizException {
		ICiMrOutQryServices serv = ServiceFinder.find(ICiMrOutQryServices.class);
		return FBoolean.TRUE.equals(serv.hasCiMrDoByIdEnts(id_ent));
	}

	/**
	 * 删除新生儿对应的患者信息
	 * 
	 * @author zhengcm
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 */
	private void deleteNewbornPatInfo(NewbornDO nbDO) throws BizException {
		// 患者基本信息维护服务
		IPiRegMaintainService patService = ServiceFinder.find(IPiRegMaintainService.class);
		patService.deletePatient(nbDO.getId_pat_bb());
	}
}
