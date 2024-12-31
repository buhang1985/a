package iih.en.er.bp.baspat;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErBasic4EditDTO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.EnvtAggDO;
import iih.en.pv.vt.i.IEnvtCudService;
import iih.en.pv.vt.i.IEnvtRService;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SaveEnErBasic4PatBP {

	public EnErBasic4EditDTO exec(EnErBasic4EditDTO enErBasic4EditDTO) throws BizException {
		if (null == enErBasic4EditDTO) {
			return null;
		}
		// 1、保存患者电话和地址信息
		this.saveEntInfo(enErBasic4EditDTO);
		// 2、保存患者信息
		this.savePatiInfo(enErBasic4EditDTO);
		// 3、保存就诊联系人信息
		new EnErBasicInfoBP().saveEntContInfo(enErBasic4EditDTO, 0);
		// 4、保存生命体征
		this.saveVitalSign(enErBasic4EditDTO);
		//5.保存预检信息，fanlq-2019-07-25
		this.saveEnErPreDO(enErBasic4EditDTO);
		return enErBasic4EditDTO;
	}
	
	/**
	 * 保存生命体征
	 * @param enErBasic4EditDTO
	 * @throws BizException
	 */
	private void saveVitalSign(EnErBasic4EditDTO enErBasic4EditDTO) throws BizException {
		Boolean isnew = false;
		if(enErBasic4EditDTO.getId_erpre() == null){
			isnew = true;//有问题,一直保存,会一直新增
		}
		//1.获取AggDO
		EnvtAggDO agg = getEnvtAggDO(enErBasic4EditDTO.getId_erpre());
		EnVtDO envtDO = agg.getParentDO();
		if(envtDO == null)
			envtDO = new EnVtDO();
		envtDO.setId_erpre(enErBasic4EditDTO.getId_erpre());
		agg.setParentDO(envtDO);

		//2.保存体征信息
		EnVtSrvDO[] enVtSrvDOs = agg.getEnVtSrvDO();
		List<EnVtSrvDO> enVtSrvList = new LinkedList<EnVtSrvDO>();
		if(!EnValidator.isEmpty(enVtSrvDOs))
			Collections.addAll(enVtSrvList, enVtSrvDOs);
		//2.1设置envtdo
		EnVtDO envtdo = agg.getParentDO();
		if(isnew){
			envtdo.setStatus(DOStatus.NEW);
		}else{
			envtdo.setStatus(DOStatus.UPDATED);
		}
		envtdo.setId_ent(enErBasic4EditDTO.getId_ent());
		envtdo.setDt_insert(EnAppUtils.getServerDateTime());
		//envtdo.setDt_vt(enErBasic4EditDTO.getDt_pick_vs());
		envtdo.setId_emp_rec(EnContextUtils.getPsnId());
		envtdo.setFg_last(new FBoolean(true));
		// 2.2设置srvdo
		if (enErBasic4EditDTO.getVs_list() != null && !enErBasic4EditDTO.getVs_list().isEmpty()) {
			for (Object obj : enErBasic4EditDTO.getVs_list()) {
				PhySignDTO phySign = (PhySignDTO) obj;
				EnVtSrvDO enVtSrvDO = null;
				if (isnew) {
					enVtSrvDO = new EnVtSrvDO();
					enVtSrvDO.setStatus(DOStatus.NEW);
					enVtSrvDO.setId_ent(enErBasic4EditDTO.getId_ent());
					enVtSrvDO.setId_srv(phySign.getId_srv());
				} else {
					for (EnVtSrvDO enVtSrvDO2 : enVtSrvList) {
						if (enVtSrvDO2.getId_srv().equals(phySign.getId_srv())) {
							enVtSrvDO = enVtSrvDO2;
							enVtSrvDO.setStatus(DOStatus.UPDATED);
						}
						// 没有相应项的情况（不常出现）
						if (enVtSrvDO == null) {
							enVtSrvDO = new EnVtSrvDO();
							enVtSrvDO.setStatus(DOStatus.NEW);
							enVtSrvDO.setId_ent(enErBasic4EditDTO.getId_ent());
							enVtSrvDO.setId_srv(phySign.getId_srv());
							enVtSrvDO.setId_envt(envtDO.getId_envt());
						}
					}
				}
				// 没有相应项的情况（不常出现）
				if (enVtSrvDO == null) {
					enVtSrvDO = new EnVtSrvDO();
					enVtSrvDO.setStatus(DOStatus.NEW);
					enVtSrvDO.setId_ent(enErBasic4EditDTO.getId_ent());
					enVtSrvDO.setId_srv(phySign.getId_srv());
				}
				enVtSrvDO.setVal0(phySign.getVal0());
				enVtSrvDO.setVal1(phySign.getVal1());
				enVtSrvDO.setVal2(phySign.getVal2());
				enVtSrvDO.setVal3(phySign.getVal3());
				enVtSrvDO.setVal4(phySign.getVal4());
				enVtSrvList.add(enVtSrvDO);
			}
		}
		agg.setParentDO(envtDO);
		agg.setEnVtSrvDO(enVtSrvList.toArray(new EnVtSrvDO[0]));
		IEnvtCudService serv = ServiceFinder.find(IEnvtCudService.class);
		serv.update(new EnvtAggDO[]{agg});
	}
	/**
	 * 获取生命体征aggDO
	 * 
	 * @param erPreTriage
	 * @param id_erpre
	 * @return
	 * @throws BizException
	 */
	private EnvtAggDO getEnvtAggDO(String id_erpre) throws BizException{
		if(EnValidator.isEmpty(id_erpre))
			return new EnvtAggDO();
		IEnvtRService serv = ServiceFinder.find(IEnvtRService.class);
		EnvtAggDO[] aggs = serv.find(String.format(" ID_ERPRE = '%s' ",id_erpre),"", FBoolean.FALSE);
		if(aggs == null || aggs.length<=0)
			return new EnvtAggDO();
		EnvtAggDO agg = aggs[0];
		return agg;
	}
	/**
	 * 保存患者联系电话和地址信息（更新患者就诊表）
	 *
	 * @param dto
	 *            门诊基本信息维护DTO
	 * @throws BizException
	 */
	private void saveEntInfo(EnErBasic4EditDTO dto) throws BizException {
		// 患者就诊查询服务
		IPativisitRService qryService = ServiceFinder.find(IPativisitRService.class);
		// 患者就诊维护服务
		IPativisitCudService cmdService = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO pvDO = qryService.findById(dto.getId_ent());
		if (null != pvDO) {
			pvDO.setStatus(DOStatus.UPDATED);
			pvDO.setTelno_pat(dto.getTelno_pat());
			pvDO.setId_admdiv_addr(dto.getId_admdiv_addr());
			pvDO.setSd_admdiv_addr(dto.getSd_admdiv_addr());
			pvDO.setAddr_pat(dto.getAddr_pat());
			cmdService.update(new PatiVisitDO[] { pvDO });
		}
		
	}
	
	/**
	 * 保存患者信息
	 *
	 * @param dto
	 *            门诊基本信息维护DTO
	 * @return 患者基本信息AggDO数组
	 * @throws BizException
	 */
	private void savePatiInfo(EnErBasic4EditDTO dto) throws BizException {
		// 患者基本信息查询服务
		IPatiRService qryService = ServiceFinder.find(IPatiRService.class);
		// 患者基本信息维护服务
		IPatiCudService cmdService = ServiceFinder.find(IPatiCudService.class);
		// 查询患者信息聚合VO
		PatiAggDO aggDO = qryService.findById(dto.getId_pat());

		// 设置患者信息VO数据
		this.setPatInfo(aggDO, dto);
		// 设置患者地址VO数据
		this.setPatAddrInfo(aggDO, dto);

		// 保存患者信息AggDO
		cmdService.save(new PatiAggDO[] { aggDO });
	}
	/**
	 * 设置患者信息VO数据
	 *
	 * @param aggDO
	 *            患者信息聚合DO
	 * @param dto
	 *            门诊基本信息维护DTO
	 */
	private void setPatInfo(PatiAggDO aggDO, EnErBasic4EditDTO dto) {
		if (null == aggDO) {
			return;
		}
		aggDO.getParentDO().setStatus(DOStatus.UPDATED);
		aggDO.getParentDO().setId_idtp(dto.getId_idtp());// 证件类型id
		aggDO.getParentDO().setSd_idtp(dto.getSd_idtp());// 证件类型code
		aggDO.getParentDO().setId_code(dto.getCode_id());// 证件号码
		aggDO.getParentDO().setMob(dto.getTelno_pat());// 联系电话
	}
	/**
	 * 设置患者地址DO数据
	 *
	 * @param aggDO
	 *            患者信息聚合DO
	 * @param dto
	 *            门诊基本信息维护DTO
	 * @throws BizException
	 */
	private void setPatAddrInfo(PatiAggDO aggDO, EnErBasic4EditDTO dto) throws BizException {
		if (null == aggDO) {
			return;
		}
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
		PatiAddrDO[] addrDOs = (PatiAddrDO[]) aggDO.getChildren(PatiAddrDO.class);
		if (!EnValidator.isEmpty(addrDOs)) {
			for (PatiAddrDO addrDO : addrDOs) {
				patAddrList.add(addrDO);
			}
		}
		// 新增或更新现住址
		if (!EnValidator.isEmpty(dto.getId_admdiv_addr())) {// 现住址
			PatiAddrDO patAddrDO = this.setPatAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, addrDOs);
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO.setId_admdiv(dto.getId_admdiv_addr());
			patAddrDO.setAdmdiv_name(dto.getName_admdiv_addr());
			patAddrDO.setSd_admdiv(dto.getSd_admdiv_addr());
			patAddrDO.setStreet(dto.getAddr_pat());
			patAddrDO.setTel(dto.getTelno_pat());
			patAddrDO.setId_pat(dto.getId_pat());
			if (patAddrDO.getStatus() == DOStatus.NEW) {
				patAddrList.add(patAddrDO);
			} else if (patAddrDO.getStatus() == DOStatus.UPDATED) {
				for (PatiAddrDO addrDO : patAddrList) {
					if (addrDO.getId_pataddr().equals(patAddrDO.getId_pataddr())) {
						addrDO = patAddrDO;
						break;
					}
				}
			}
		}
		aggDO.setChildren(PatiAddrDO.class, patAddrList.toArray(new PatiAddrDO[] {}));
	}
	/**
	 * 设置患者地址DO状态
	 *
	 * @param addrTypeID
	 *            地址类型ID
	 * @param addrDOs
	 *            患者地址DO数组
	 * @return 患者地址DO
	 * @throws BizException
	 */
	private PatiAddrDO setPatAddrDOStatus(String addrTypeID, PatiAddrDO[] addrDOs) throws BizException {
		if (EnValidator.isEmpty(addrTypeID)) {
			return null;
		}
		PatiAddrDO patAddrDO = new PatiAddrDO();
		List<PatiAddrDO> list = new ArrayList<PatiAddrDO>();
		if (!EnValidator.isEmpty(addrDOs)) {
			for (PatiAddrDO ado : addrDOs) {
				if (addrTypeID.equals(ado.getId_addrtp())) {
					list.add(ado);
				}
			}
		}
		if (EnValidator.isEmpty(list)) {
			patAddrDO = new PatiAddrDO();
			patAddrDO.setStatus(DOStatus.NEW);
			return patAddrDO;
		}
		patAddrDO = list.get(0);
		patAddrDO.setStatus(DOStatus.UPDATED);
		return patAddrDO;
	}
	/**
	 * 保存预检信息,fanlq-2019-07-25
	 * @param enErBasic4EditDTO
	 * @throws BizException
	 */
	private void saveEnErPreDO(EnErBasic4EditDTO enErBasic4EditDTO) throws BizException{
		ErPreEP ep = new ErPreEP();
		EnErPreDO enErPreDO = ep.findById(enErBasic4EditDTO.getId_erpre());
		if(enErPreDO != null){
			enErPreDO.setDes_cmpt(enErBasic4EditDTO.getDes_cmpt());
			enErPreDO.setFg_refuse_exa(enErBasic4EditDTO.getFg_refuse_exa());
			enErPreDO.setStatus(DOStatus.UPDATED);
			ep.save(new EnErPreDO[]{enErPreDO});
//			IEarlywarnRService rService = ServiceFinder.find(IEarlywarnRService.class);
//			IEarlywarnCudService cudService = ServiceFinder.find(IEarlywarnCudService.class);
//			EarlyWarnDO[] earlyWarnDOs = rService.find("id_ent = '"+enErBasic4EditDTO.getId_erpre()+"' ", null, FBoolean.FALSE);
//			if(earlyWarnDOs != null && earlyWarnDOs.length > 0){
//				earlyWarnDOs[0].setId_conscious(enErBasic4EditDTO.getId_level_sense());
//				earlyWarnDOs[0].setSd_conscious(enErBasic4EditDTO.getSd_level_sense());
//				earlyWarnDOs[0].setStatus(DOStatus.UPDATED);
//			}
//			cudService.save(earlyWarnDOs);
		}
	}
	
}
