package iih.en.doc.s.bp.preg.s;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnCodeAmrIpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.endoc.d.EntDocDO;
import iih.en.doc.endoc.i.IDocCudService;
import iih.en.doc.endoc.i.IDocRService;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.i.IPregdocMDOCudService;
import iih.en.doc.pregdoc.i.IPregdocMDORService;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存建档信息
 * 
 * @author renying
 *
 */
public class SavePregDocBP {

	/**
	 * 保存建档信息
	 * 
	 * @param pregdocDto
	 * @return
	 * @throws BizException
	 */
	public void exec(PregDocDTO pregDocDTO) throws BizException {
		this.validateParam(pregDocDTO);
		//更新患者信息
		this.savePatInfo(pregDocDTO);
		//更新建档表
		this.updateDoc(pregDocDTO);
		//更新产科建档表
		this.updateDocPreg(pregDocDTO);
		return;
	}

	/**
	 * 更新建档表
	 * 
	 * @param pregDocDTO
	 * @throws BizException
	 */
	private void updateDoc(PregDocDTO pregDocDTO) throws BizException {
		IDocRService docRService = ServiceFinder.find(IDocRService.class);
		EntDocDO entDocDO = docRService.findById(pregDocDTO.getId_entdoc());
		entDocDO.setName_pat(pregDocDTO.getName_pat());
		entDocDO.setId_sex(pregDocDTO.getId_sex());
		entDocDO.setSd_sex(pregDocDTO.getSd_sex());
		entDocDO.setDt_birth_pat(pregDocDTO.getDt_birth());
		entDocDO.setTelno_pat(pregDocDTO.getTel_admdiv());
		entDocDO.setId_admdiv_addr(pregDocDTO.getId_admdiv());
		entDocDO.setSd_admdiv_addr(pregDocDTO.getSd_admdiv());
		entDocDO.setAddr_pat(pregDocDTO.getAddr_pat());
		IDocCudService docCudService = ServiceFinder.find(IDocCudService.class);
		docCudService.update(new EntDocDO[] { entDocDO });
	}

	/**
	 * 更新产科建档表
	 * 
	 * @param pregDocDTO
	 * @throws BizException
	 */
	private void updateDocPreg(PregDocDTO pregDocDTO) throws BizException {
		IPregdocMDORService pregdocMDORService = ServiceFinder.find(IPregdocMDORService.class);
		PregDocDO pregDocDO = pregdocMDORService.findById(pregDocDTO.getId_pregdoc());
		pregDocDO.setId_admdiv_husb(pregDocDTO.getId_admdiv_husb());
		pregDocDO.setSd_admdiv_husb(pregDocDTO.getSd_admdiv_husb());
		pregDocDO.setFg_born_here(pregDocDTO.getFg_born_here());
		pregDocDO.setEu_status(pregDocDTO.getEu_status());
		pregDocDO.setDt_doc(pregDocDTO.getDt_doc());
		pregDocDO.setId_patcont(pregDocDTO.getId_patcont());
		IPregdocMDOCudService pregdocMDOCudService = ServiceFinder.find(IPregdocMDOCudService.class);
		pregdocMDOCudService.update(new PregDocDO[] { pregDocDO });
	}
	
	/**
	 * 保存患者信息
	 * 
	 * @param pregDocDTO
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO savePatInfo(PregDocDTO pregDocDTO) throws BizException{
		//1.得到patDO
		PatDO patdo = this.getPatDO(pregDocDTO.getId_pat());
		patdo.setStatus(DOStatus.UPDATED);
		//2.组装patDO
		this.setPatDOContent(patdo, pregDocDTO);
		//3.得到pataddrDO  患者地址
		List<PatiAddrDO> addrList = this.setPatAddrContent(pregDocDTO);
		//4.组装patcontDO  患者联系人
		List<PiPatContDO> patContDOList = this.setPatContContent(pregDocDTO);
		//5.组装patiAggDo
		PatiAggDO patiaggdo = new PatiAggDO();
		patiaggdo.setParentDO(patdo);
		patiaggdo.setPatiAddrDO(addrList.toArray(new PatiAddrDO[] {}));
		
		if (!EnValidator.isEmpty(patContDOList)) {
			patiaggdo.setPiPatContDO(patContDOList.toArray(new PiPatContDO[] {}));
		}
		//6.保存patiAggDo
		IPiRegMaintainService patiService = ServiceFinder.find(IPiRegMaintainService.class);
		patiaggdo = patiService.savePatForHosReg( patiaggdo);
		if (patiaggdo != null && patiaggdo.getPiPatContDO() != null && patiaggdo.getPiPatContDO().length > 0) {
			pregDocDTO.setId_patcont(patiaggdo.getPiPatContDO()[0].getId_patcont());
		} else {
			pregDocDTO.setId_patcont(null);
		}
		return patiaggdo;
	}

	/**
	 * 获取患者do
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatDO(String patId) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patdo = patRService.findById(patId);
		if (patdo == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		return patdo;
	}
	
	/**
	 * 组装patdo
	 * 
	 * @param patdo
	 * @param pregDocDTO
	 * @throws BizException
	 */
	private void setPatDOContent(PatDO patdo, PregDocDTO pregDocDTO) throws BizException {
		if (EnValidator.isEmpty(patdo.getCode_amr_ip())) {
			patdo.setCode_amr_ip(new EnCodeAmrIpEP().createIpAmrCode());
		}
		patdo.setName(pregDocDTO.getName_pat());		//患者姓名
		patdo.setId_idtp(pregDocDTO.getId_idtp());		//主身份标志类型
		patdo.setSd_idtp(pregDocDTO.getSd_idtp());		//主身份标志类型编码
		patdo.setId_code(pregDocDTO.getId());			//主身份标识号码
		patdo.setId_sex(pregDocDTO.getId_sex());		//性别
		patdo.setSd_sex(pregDocDTO.getSd_sex());		//性别编码
		patdo.setDt_birth(pregDocDTO.getDt_birth());	//出生日期
		patdo.setWorkunit(pregDocDTO.getWorkplace());	//工作单位
		patdo.setPhoto(pregDocDTO.getPhoto());			//照片
		patdo.setWbcode(EnAppUtils.getWbCode(patdo.getName()));	//五笔
		patdo.setPycode(EnAppUtils.getPyCode(patdo.getName()));	//拼音
	}

	/**
	 * 设置患者联系人
	 * 
	 * @param pregDocDTO
	 * @return
	 * @throws BizException
	 */
	private List<PiPatContDO> setPatContContent(PregDocDTO pregDocDTO) throws BizException {
		if (EnValidator.isEmpty(pregDocDTO.getName_patcontref()) && EnValidator.isEmpty(pregDocDTO.getName_conttp()) && EnValidator.isEmpty(pregDocDTO.getConttel()) && EnValidator.isEmpty(pregDocDTO.getContaddr()))
			return null;// 如果患者联系人姓名、类型、电话、地址都为空，就返回空
		PiPatContDO piContDO = null;
		int sortNo = 0;
		PatEP patep = new PatEP();
		PiPatContDO[] patConts = patep.getContDO(pregDocDTO.getId_pat());
		if (!EnValidator.isEmpty(patConts)) {
			for (PiPatContDO contDO : patConts) {
				if (!EnValidator.isEmpty(pregDocDTO.getId_patcont())) {
					if (contDO.getId_patcont().equals(pregDocDTO.getId_patcont())) {
						piContDO = contDO;
						piContDO.setStatus(DOStatus.UPDATED);
					}
				}
				if (contDO.getSortno() != null && contDO.getSortno() > sortNo) {
					sortNo = contDO.getSortno();
				}
			}
		}
		
		if (piContDO == null) {
			piContDO = new PiPatContDO();
			piContDO.setStatus(DOStatus.NEW);
			piContDO.setSortno(sortNo + 1);
		}

		piContDO.setId_pat(pregDocDTO.getId_pat());
		piContDO.setId_conttp(pregDocDTO.getId_conttp());
		piContDO.setSd_conttp(pregDocDTO.getSd_conttp());
		piContDO.setName(pregDocDTO.getName_patcontref());
		piContDO.setConttel(pregDocDTO.getConttel());
		piContDO.setContaddr(pregDocDTO.getContaddr());
		List<PiPatContDO> list = new ArrayList<PiPatContDO>();
		list.add(piContDO);
		return list;
	}
	
	/**
	 * 组装地址do
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private List<PatiAddrDO> setPatAddrContent(PregDocDTO pregDocDTO) throws BizException {
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
		// 现住址
		if (!(EnValidator.isEmpty(pregDocDTO.getId_admdiv()) && EnValidator.isEmpty(pregDocDTO.getAddr_pat())
				&& EnValidator.isEmpty(pregDocDTO.getPostcode_addr())
				&& EnValidator.isEmpty(pregDocDTO.getTel_admdiv()))) {
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, pregDocDTO.getId_pat(),
					false);
			patAddrDO_Now.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO_Now.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO_Now.setId_admdiv(pregDocDTO.getId_admdiv());
			patAddrDO_Now.setSd_admdiv(pregDocDTO.getSd_admdiv());
			patAddrDO_Now.setStreet(pregDocDTO.getAddr_pat());
			patAddrDO_Now.setZip(pregDocDTO.getPostcode_addr());
			patAddrDO_Now.setId_pat(pregDocDTO.getId_pat());
			patAddrDO_Now.setTel(pregDocDTO.getTel_admdiv());
			patAddrList.add(patAddrDO_Now);
		} else {
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, pregDocDTO.getId_pat(), true);
			if (patAddrDO_Now != null) {
				patAddrList.add(patAddrDO_Now);
			}
		}
		// 户口地址
		if (!(EnValidator.isEmpty(pregDocDTO.getId_admdiv_resi())
				&& EnValidator.isEmpty(pregDocDTO.getDetail_addr_resi())
				&& EnValidator.isEmpty(pregDocDTO.getPostcode_resi()))) {
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS,
					pregDocDTO.getId_pat(), false);
			patAddrDO_cencus.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setId_admdiv(pregDocDTO.getId_admdiv_resi());
			patAddrDO_cencus.setSd_admdiv(pregDocDTO.getSd_admdiv_resi());
			patAddrDO_cencus.setStreet(pregDocDTO.getAddr_resi());
			patAddrDO_cencus.setZip(pregDocDTO.getPostcode_resi());
			patAddrDO_cencus.setId_pat(pregDocDTO.getId_pat());
			patAddrList.add(patAddrDO_cencus);
		} else {
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS,
					pregDocDTO.getId_pat(), true);
			if (patAddrDO_cencus != null)
				patAddrList.add(patAddrDO_cencus);
		}
		// 工作地址
		if (!(EnValidator.isEmpty(pregDocDTO.getId_admdiv_work())
				&& EnValidator.isEmpty(pregDocDTO.getDetail_addr_work())
				&& EnValidator.isEmpty(pregDocDTO.getTel_work())
				&& EnValidator.isEmpty(pregDocDTO.getPostcode_work()))) {
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_WORK,
					pregDocDTO.getId_pat(), false);
			patAddrDO_work.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_WORK);
			patAddrDO_work.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_WORK);
			patAddrDO_work.setId_admdiv(pregDocDTO.getId_admdiv_work());
			patAddrDO_work.setSd_admdiv(pregDocDTO.getSd_admdiv_work());
			patAddrDO_work.setStreet(pregDocDTO.getAddr_work());
			patAddrDO_work.setZip(pregDocDTO.getPostcode_work());
			patAddrDO_work.setId_pat(pregDocDTO.getId_pat());
			patAddrDO_work.setTel(pregDocDTO.getTel_work());
			patAddrList.add(patAddrDO_work);
		} else {
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_WORK,
					pregDocDTO.getId_pat(), true);
			if (patAddrDO_work != null)
				patAddrList.add(patAddrDO_work);
		}
		return patAddrList;
	}

	/**
	 * 得到pataddrdo 地址do
	 * 
	 * @param addrTypeID
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO setAddrDOStatus(String addrTypeID, String patId, boolean isDel) throws BizException {
		PatiAddrDO patAddrDO = null;
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "' and "
				+ PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_addrtp = '" + addrTypeID + "'", "", FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)) {
			if (isDel)
				return null;
			patAddrDO = new PatiAddrDO();
			patAddrDO.setStatus(DOStatus.NEW);
			return patAddrDO;
		}

		patAddrDO = patAddrDOArr[0];
		if (isDel) {
			patAddrDO.setStatus(DOStatus.DELETED);
			return patAddrDO;
		}
		patAddrDO.setStatus(DOStatus.UPDATED);
		return patAddrDO;
	}

	/**
	 * 验证参数是否为空
	 * 
	 * @param pregdocDto
	 * @throws BizException
	 */
	private void validateParam(PregDocDTO pregdocDto) throws BizException {
		if (pregdocDto == null) {
			throw new BizException(IEnMsgConst.ERROR_PREGDOC_NULL);
		}
		if (EnValidator.isEmpty(pregdocDto.getId_pat())) {
			throw new BizException(IEnMsgConst.ERROR_DOC_PATID_NOT_EXIST);
		}
	}
}
