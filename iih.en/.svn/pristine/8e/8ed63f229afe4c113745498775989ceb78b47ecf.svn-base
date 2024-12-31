package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.ListToArrayUtil;

/**
 * 保存门诊基本信息BP
 * 
 * @author zhengcm
 * @date 2016-06-01 11:42:44
 *
 */
public class SaveOpBasicInfoBP {
	
	//状态
	public static final String CONSTANT_STATUS_SUCCESS = "1"; 
	public static final String CONSTANT_STATUS_FAIL = "0"; 
	/**
	 * 保存门诊基本信息
	 *
	 * @param opBasicDTO
	 *            门诊基本信息维护DTO
	 * @throws BizException
	 */
	public void exec(OpBasic4EditDTO opBasicDTO) throws BizException {
		if (null == opBasicDTO) {
			return;
		}
		// 1、保存患者电话和地址信息
		this.saveEntInfo(opBasicDTO);

		// 2、保存患者信息
		this.savePatiInfo(opBasicDTO);

		// 3、保存就诊联系人信息
		new OpBasicInfoBP().saveEntContInfo(opBasicDTO, 0);
	}

	/**
	 * 保存患者信息
	 *
	 * @param dto
	 *            门诊基本信息维护DTO
	 * @return 患者基本信息AggDO数组
	 * @throws BizException
	 */
	private void savePatiInfo(OpBasic4EditDTO dto) throws BizException {
		// 患者基本信息查询服务
		IPatiRService qryService = ServiceFinder.find(IPatiRService.class);
		// 患者基本信息维护服务
		IPatiCudService cmdService = ServiceFinder.find(IPatiCudService.class);
		// 查询患者信息聚合VO
		PatiAggDO aggDO = qryService.findById(dto.getId_pat());
		//String deletePiPatInfo = this.deletePiPatInfo(aggDO, dto);
		// 设置患者信息VO数据
		this.setPatInfo(aggDO, dto);
		// 设置患者地址VO数据
		this.setPatAddrInfo(aggDO, dto);
		// 保存患者信息AggDO
		cmdService.save(new PatiAggDO[] { aggDO });
	}
	/**
	 * 删除地址信息
	 *
	 * @return 患者基本信息AggDO数组
	 * 	 * @param dto
	 *            门诊基本信息维护DTO
	 * @throws BizException
	 */
	private String deletePiPatInfo(PatiAggDO aggDO, OpBasic4EditDTO dto) throws BizException{
		if (null == aggDO || CONSTANT_STATUS_FAIL.equals(String.valueOf(aggDO.getChildrenDO().length))) {
			return CONSTANT_STATUS_SUCCESS;
		}
		IPatiAddrDOCudService cmdAddrService = ServiceFinder.find(IPatiAddrDOCudService.class);
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
		PatiAddrDO[] addrDOs = (PatiAddrDO[]) aggDO.getChildren(PatiAddrDO.class);
		String status = CONSTANT_STATUS_SUCCESS;
		List<PatiAddrDO> pList = new ArrayList<PatiAddrDO>();
		if (!EnValidator.isEmpty(addrDOs)) {
			for (PatiAddrDO addrDO : addrDOs) {
				patAddrList.add(addrDO);
			}
		}
			
		for (PatiAddrDO patiAddrDO : addrDOs) {
	
			if(null==dto.getId_admdiv_addr()&&null == dto.getId_admdiv_resi()){
				patiAddrDO.setStatus(DOStatus.DELETED);
				pList.add(patiAddrDO);
				aggDO.setChildren(PatiAddrDO.class, null);
				status = CONSTANT_STATUS_FAIL; 
			}else{
				if(EnValidator.isEmpty(dto.getId_admdiv_addr())){
					patiAddrDO.setStatus(DOStatus.DELETED);
					pList.add(patiAddrDO);
					aggDO.setChildren(PatiAddrDO.class, null);
					status = CONSTANT_STATUS_SUCCESS;
				}else if(EnValidator.isEmpty(dto.getId_admdiv_resi())){
					patiAddrDO.setStatus(DOStatus.DELETED);
					pList.add(patiAddrDO);
					aggDO.setChildren(PatiAddrDO.class, null);
					status = CONSTANT_STATUS_SUCCESS;
				}
			}
			
		}
		
		ListToArrayUtil<PatiAddrDO> listToArrayUtil = new ListToArrayUtil<>();
		if(!EnValidator.isEmpty(pList)){
			//删除地址信息
			cmdAddrService.delete( listToArrayUtil.convertToArray(pList));
		}
		return status;
	}

	/**
	 * 保存患者联系电话和地址信息（更新患者就诊表）
	 *
	 * @param dto
	 *            门诊基本信息维护DTO
	 * @throws BizException
	 */
	private void saveEntInfo(OpBasic4EditDTO dto) throws BizException {
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
		//保存诊断发病日期,fanlq-07-04
		OpEP ep = new OpEP();
		OutpatientDO opDO = ep.getOpByEntId(dto.getId_ent());
		if (null != pvDO) {
			opDO.setDt_di_mor(dto.getDt_di_mor());
			opDO.setStatus(DOStatus.UPDATED);
			ep.save(opDO);
		}
	}

	/**
	 * 设置患者信息VO数据
	 *
	 * @param aggDO
	 *            患者信息聚合DO
	 * @param dto
	 *            门诊基本信息维护DTO
	 */
	private void setPatInfo(PatiAggDO aggDO, OpBasic4EditDTO dto) {
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
	private void setPatAddrInfo(PatiAggDO aggDO, OpBasic4EditDTO dto) throws BizException {
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
			//patAddrDO.setTel(dto.getTelno_pat());
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
		//更新户籍
		if (!EnValidator.isEmpty(dto.getId_admdiv_resi())) {
			PatiAddrDO patAddrDO = this.setPatAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS, addrDOs);
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			patAddrDO.setId_admdiv(dto.getId_admdiv_resi());
			patAddrDO.setAdmdiv_name(dto.getName_admdiv_resi());
			patAddrDO.setSd_admdiv(dto.getSd_admdiv_resi());
			patAddrDO.setStreet(dto.getDetail_addr_resi());
			//patAddrDO.setTel(dto.getTelno_pat());
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
				if (ado.getId_addrtp().equals(addrTypeID)) {
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

}
