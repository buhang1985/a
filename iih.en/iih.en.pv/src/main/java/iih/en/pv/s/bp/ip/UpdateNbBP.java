package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mp.nr.dto.vtevent.d.VtEventParamDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新新生儿记录BP
 * 
 * @author zhengcm
 * @date 2016-08-10 09:23:51
 *
 */
public class UpdateNbBP {
	/**
	 * 更新新生儿记录
	 * 
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public void exec(NewbornDTO nbDTO) throws BizException {
	    if (null == nbDTO) {
            return;
        }
        NewbornDO nbDO = new NewbornDO();
        try {
            BeanUtils.copyProperties(nbDO, nbDTO);
            nbDO.setWeight_reg(nbDO.getWeight());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new BizException("更新新生儿记录失败!");
        }
		if (null == nbDO) {
			return;
		}
		// 1、更新新生儿患者信息
		this.updateNewbornPatInfo(nbDO);

		// 2、更新新生儿患者就诊信息
        this.updateNewbornEntInfo(nbDO,nbDTO);

		// 3、更新新生儿记录信息
		// new NbEP().updateNbDOs(new NewbornDO[] { nbDO });

		// 4、同步新生儿父亲信息
		this.syncBabyFatherInfo(nbDO);

	}

	/**
	 * 更新新生儿患者信息
	 * 
	 * @author zhengcm
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 */
	private void updateNewbornPatInfo(NewbornDO nbDO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO nbPatDO = patEP.getPatById(nbDO.getId_pat_bb());
		if (null == nbPatDO) {
			return;
		}

		// 新生儿母亲患者信息
		PatDO momPatInfo = patEP.getPatById(nbDO.getId_pat_mom());
		// 校验新生儿的出生日期与母亲的出生日期
		if (momPatInfo.getDt_birth().after(nbDO.getDt_birth().getDate())) {
			throw new BizException("新生儿出生日期不能早于母亲出生日期！");
		}
		// 新生儿的出生日期应大于母亲的入院时间-24小时
		PatiVisitDO momEntDO = new PvEP().getPvById(nbDO.getId_ent_mom());
		FDateTime momDate = momEntDO.getDt_acpt().addSeconds(-24 * 3600);
		if (momDate.after(nbDO.getDt_birth())) {
			throw new BizException("新生儿出生日期不能早于母亲入院时间前24小时！");
		}

		nbPatDO.setStatus(DOStatus.UPDATED);
		nbPatDO.setName(nbDO.getName_bb());
		nbPatDO.setId_sex(nbDO.getId_sex());
		nbPatDO.setSd_sex(nbDO.getSd_sex());
		nbPatDO.setName_sex(nbDO.getName_sex());
		nbPatDO.setDt_birth(nbDO.getDt_birth().getBeginDate());
		nbPatDO.setDt_birth_hms(nbDO.getDt_birth());
		
		IPatiCudService service = ServiceFinder.find(IPatiCudService.class);

		PatiAggDO aggDo = new PatiAggDO();
		
		nbPatDO.setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
		aggDo.setParentDO(nbPatDO);
		aggDo = service.update(new PatiAggDO[] { aggDo })[0];
//		patEP.updatePatDOs(new PatDO[] { nbPatDO });
	}

	/**
	 * 更新新生儿患者就诊信息
	 * 
	 * @author zhengcm
	 * @param nbDO 新生儿记录DO
	 * @param nbDTO 
	 * @throws BizException
	 */
	private void updateNewbornEntInfo(NewbornDO nbDO, NewbornDTO nbDTO) throws BizException {
		PvEP pvEP = new PvEP();
		PatiVisitDO nbEntDO = pvEP.getPvById(nbDO.getId_ent_bb());
		if (null == nbEntDO) {
			return;
		}
		nbEntDO.setStatus(DOStatus.UPDATED);
		nbEntDO.setId_pripat(nbDTO.getId_pripat());//renzhi 2018年06月15日
		nbEntDO.setName_pat(nbDO.getName_bb());
		nbEntDO.setId_sex_pat(nbDO.getId_sex());
		nbEntDO.setSd_sex_pat(nbDO.getSd_sex());
		nbEntDO.setName_sex(nbDO.getName_sex());
		nbEntDO.setDt_birth_pat(nbDO.getDt_birth().getBeginDate());
		// 取母亲的入院日期与新生儿出生日期的最大值
		PatiVisitDO momEntDO = pvEP.getPvById(nbDO.getId_ent_mom());
		if (momEntDO.getDt_acpt().after(nbDO.getDt_birth())) {
			nbEntDO.setDt_entry(momEntDO.getDt_acpt());
			nbEntDO.setDt_acpt(momEntDO.getDt_acpt());
		} else {
			nbEntDO.setDt_entry(nbDO.getDt_birth());
			nbEntDO.setDt_acpt(nbDO.getDt_birth());
		}
		pvEP.savePv(nbEntDO);
		
		VtEventParamDTO vtParam = new VtEventParamDTO();
		vtParam.setId_ent(nbEntDO.getId_ent());
		vtParam.setDt_vt_exec(nbEntDO.getDt_acpt());
		//新生儿登记处修改新生儿出生日期
		IForeignService iForeignService = ServiceFinder.find(IForeignService.class);
		iForeignService.updateEventInfo(new VtEventParamDTO[]{vtParam});
	}

	/**
	 * 同步新生儿父亲信息
	 * 
	 * @author zhengcm
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 */
	private void syncBabyFatherInfo(NewbornDO nbDO) throws BizException {
		NbEP nbEP = new NbEP();
		NewbornDO[] allBabys = nbEP.getNbListByMomEnt(nbDO.getId_ent_mom());
		if (EnValidator.isEmpty(allBabys)) {
			return;
		}
		// 对当前新生儿的信息赋值
		for (NewbornDO babyDO : allBabys) {
			if (babyDO.getNo_bb() == nbDO.getNo_bb()) {
				babyDO.setStatus(DOStatus.UPDATED);
				babyDO.setName_bb(nbDO.getName_bb());
				babyDO.setId_sex(nbDO.getId_sex());
				babyDO.setSd_sex(nbDO.getSd_sex());
				babyDO.setDt_birth(nbDO.getDt_birth());
				babyDO.setId_birthtp(nbDO.getId_birthtp());
				babyDO.setSd_birthtp(nbDO.getSd_birthtp());
				babyDO.setWeight(nbDO.getWeight());
				babyDO.setWeight_reg(nbDO.getWeight_reg());
				if(FDoubleUtils.isNullOrZero(babyDO.getWeight_reg()))
					babyDO.setWeight_reg(babyDO.getWeight());
				babyDO.setHeight(nbDO.getHeight());
				babyDO.setGestation(nbDO.getGestation());
				babyDO.setNo_birthcert(nbDO.getNo_birthcert());
				babyDO.setId_newbb_health(nbDO.getId_newbb_health());
				babyDO.setSd_newbb_health(nbDO.getSd_newbb_health());
				babyDO.setGestation(nbDO.getGestation());
				babyDO.setGestation_dis(nbDO.getGestation_dis());
			}
		}

		// 当第一个婴儿的父亲信息修改后同步到其他婴儿对应字段上
		if (nbDO.getNo_bb() == 1) {

			if (EnValidator.isEmpty(allBabys) || allBabys.length <= 0) {
				return;
			}
			for (NewbornDO babyDO : allBabys) {
				babyDO.setStatus(DOStatus.UPDATED);
				babyDO.setName_dad(nbDO.getName_dad());
				babyDO.setAge_dad(nbDO.getAge_dad());
				babyDO.setId_country_dad(nbDO.getId_country_dad());
				babyDO.setSd_country_dad(nbDO.getSd_country_dad());
				babyDO.setId_nation_dad(nbDO.getId_nation_dad());
				babyDO.setId_idtp_dad(nbDO.getId_idtp_dad());
				babyDO.setSd_idtp_dad(nbDO.getSd_idtp_dad());
				babyDO.setNo_id_dad(nbDO.getNo_id_dad());
			}
		}
		// 同步
		nbEP.updateNbDOs(allBabys);
	}
}
