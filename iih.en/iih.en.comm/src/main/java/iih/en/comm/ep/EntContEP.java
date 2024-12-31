package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpRegPiContDTO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.i.IEntcontCudService;
import iih.en.pv.pativisit.i.IEntcontRService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatContDORService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊联系人EP
 * 
 * @author zhengcm
 * @date 2016-06-24 16:56:24
 *
 */

public class EntContEP {

	public EntContEP() {

	}

	/**
	 * 根据就诊id查询就诊联系人
	 * 
	 * @param entId就诊id
	 * @return 就诊联系人DO数组
	 * @throws BizException
	 */
	public EntContDO[] getEntContByEntId(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		IEntcontRService qryService = ServiceFinder.find(IEntcontRService.class);
		return qryService.findByAttrValString(EntContDO.ID_ENT, entId);
	}

	/**
	 * 保存entcont
	 * 
	 * @param picontDO
	 * @param entId
	 * @throws BizException
	 */
	public void SaveEntCont(PiPatContDO picontDO, String entId) throws BizException {
		if (picontDO == null) {
			return;
		}
		IEntcontRService contRService = ServiceFinder.find(IEntcontRService.class);
		IEntcontCudService contService = ServiceFinder.find(IEntcontCudService.class);
		EntContDO[] entConts = contRService.find(
				"id_ent = '" + entId + "' and eu_entconttp='" + EuEntContTp.CONTACT.intValue() + "'", "",
				FBoolean.FALSE);

		if (!EnValidator.isEmpty(entConts)) {
			contService.delete(entConts);
		}
		int sortno = this.getSortNo(entId);
		EntContDO entCont = this.setEntConts(picontDO, entId, EuEntContTp.CONTACT.intValue(), ++sortno);
		contService.save(new EntContDO[] { entCont });
	}

	/**
	 * 删除就诊联系人
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void deleteEntCont(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return;
		IEntcontRService contRService = ServiceFinder.find(IEntcontRService.class);
		IEntcontCudService contService = ServiceFinder.find(IEntcontCudService.class);
		EntContDO[] entConts = contRService.find(
				"id_ent = '" + entId + "' and eu_entconttp='" + EuEntContTp.CONTACT.intValue() + "'", "",
				FBoolean.FALSE);
		if (!EnValidator.isEmpty(entConts)) {
			contService.delete(entConts);
		}
	}

	/**
	 * 保存父母联系人
	 * 
	 * @param picontDOs
	 * @param entId
	 * @throws BizException
	 */
	public void SaveParentCont(PiPatContDO[] picontDOs, String entId) throws BizException {
		if (EnValidator.isEmpty(picontDOs))
			return;
		IEntcontRService contRService = ServiceFinder.find(IEntcontRService.class);
		IEntcontCudService contService = ServiceFinder.find(IEntcontCudService.class);
		// 查找父母就诊联系人
		EntContDO[] entConts = contRService.find(
				"id_ent = '" + entId + "' and eu_entconttp in ('" + EuEntContTp.FATHER.intValue() + "' ,'"
						+ EuEntContTp.MOTHER.intValue() + "')", "", FBoolean.FALSE);
		// 删除父母就诊联系人
		if (!EnValidator.isEmpty(entConts)) {
			contService.delete(entConts);
		}
		int sortno = this.getSortNo(entId);
		List<EntContDO> list = new ArrayList<EntContDO>();
		for (PiPatContDO contDO : picontDOs) {
			if (contDO.getSd_fmrole().equals(IPiDictCodeConst.SD_PARENT_MOTHER)) {
				EntContDO entCont = this.setEntConts(contDO, entId, EuEntContTp.MOTHER.intValue(), ++sortno);
				list.add(entCont);
			}
			if (contDO.getSd_fmrole().equals(IPiDictCodeConst.SD_PARENT_FATHER)) {
				EntContDO entCont = this.setEntConts(contDO, entId, EuEntContTp.FATHER.intValue(), ++sortno);
				list.add(entCont);
			}

		}
		contService.save(list.toArray(new EntContDO[] {}));
	}

	/**
	 * 创建新的就诊联系人do
	 * 
	 * @param picontDO
	 * @param entId
	 * @param sdtp
	 * @return
	 */
	private EntContDO setEntConts(PiPatContDO picontDO, String entId, int sdtp, int sortno) {
		EntContDO entCont = new EntContDO();
		entCont.setStatus(DOStatus.NEW);
		entCont.setId_ent(entId);
		entCont.setSortno(sortno);
		entCont.setEu_entconttp(sdtp);// EuEntContTp.CONTACT.intValue());
		entCont.setId_conttp(picontDO.getId_conttp());
		entCont.setSd_conttp(picontDO.getSd_conttp());
		entCont.setId_patcontid(picontDO.getId_patcont());// 联系人
		entCont.setName(picontDO.getName());
		entCont.setConttel(picontDO.getConttel());
		entCont.setContaddr(picontDO.getContaddr());
		entCont.setZip(picontDO.getZip());
		if (!EnValidator.isEmpty(picontDO.getName())) {
			entCont.setWbcode(EnAppUtils.getWbCode(picontDO.getName()));
			entCont.setPycode(EnAppUtils.getPyCode(picontDO.getName()));
		}
		entCont.setIdcode(picontDO.getContid());
		return entCont;
	}

	/**
	 * 取得联系人当前最大的序号
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public int getSortNo(String entId) throws BizException {
		int sortno = 0;
		IEntcontRService contRService = ServiceFinder.find(IEntcontRService.class);
		// 查找父母就诊联系人
		EntContDO[] entConts = contRService.find("id_ent = '" + entId + "'", "", FBoolean.FALSE);
		if (!EnValidator.isEmpty(entConts)) {
			for (EntContDO entCont : entConts) {
				if (entCont.getSortno() == null){
					continue;
				}
				if (entCont.getSortno() > sortno) {
					sortno = entCont.getSortno();
				}
			}
		}
		return sortno;
	}

	/**
	 * 取得患者联系人当前最大的序号
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public int getPatContSortNo(String patId) throws BizException {
		int sortno = 0;
		IPiPatContDORService contRService = ServiceFinder.find(IPiPatContDORService.class);
		// 查找父母就诊联系人
		PiPatContDO[] conts = contRService.findByAttrValString(PiPatContDO.ID_PAT, patId);
		if (!EnValidator.isEmpty(conts)) {
			for (PiPatContDO cont : conts) {
				if (cont.getSortno() > sortno) {
					sortno = cont.getSortno();
				}
			}
		}
		return sortno;
	}

	/**
	 * 根据就诊id和联系人类型查询就诊联系人
	 * 
	 * @param entId
	 *            就诊id
	 * @param contType
	 *            联系人类型
	 * @param order排序条件
	 * @return 就诊联系人DO数组
	 * @throws BizException
	 */
	public EntContDO[] getEntConts(String entId, int contType, String order) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		EnValidator.validateParam("就诊联系人类型", contType);
		// 就诊联系人查询服务
		IEntcontRService qryService = ServiceFinder.find(IEntcontRService.class);
		String where = "ID_ENT = '" + entId + "' AND EU_ENTCONTTP = " + contType;
		return qryService.find(where, order, FBoolean.FALSE);
	}

	/**
	 * 根据就诊联系人id批量查询
	 * 
	 * @param ids
	 *            就诊联系人id数组
	 * @return 就诊联系人DO数组
	 * @throws BizException
	 */
	public EntContDO[] getEntContByIds(String[] ids) throws BizException {
		EnValidator.validateParam("就诊ID", ids);
		// 就诊联系人查询服务
		IEntcontRService qryService = ServiceFinder.find(IEntcontRService.class);
		return qryService.findByIds(ids, FBoolean.FALSE);
	}

	/**
	 * 根据就诊联系人id查询就诊联系人
	 * 
	 * @param id_entcont就诊联系人id
	 * @return 就诊联系人DO
	 * @throws BizException
	 */
	public EntContDO getEntContById(String id_entcont) throws BizException {
		EnValidator.validateParam("就诊联系人ID", id_entcont);
		// 就诊联系人查询服务
		IEntcontRService entQryService = ServiceFinder.find(IEntcontRService.class);
		return entQryService.findById(id_entcont);
	}

	/**
	 * 根据DO状态保存就诊联系人
	 * 
	 * @param datas
	 *            就诊联系人List
	 * @throws BizException
	 */
	public void saveEntContByStatus(List<EntContDO> datas) throws BizException {
		if (EnValidator.isEmpty(datas)) {
			return;
		}
		// 就诊联系人维护服务
		IEntcontCudService cmdService = ServiceFinder.find(IEntcontCudService.class);
		cmdService.save(datas.toArray(new EntContDO[] {}));
	}

	/**
	 * 根据id查询患者联系人
	 * 
	 * @param id_patcont
	 *            患者联系人id
	 * @return 患者联系人DO
	 * @throws BizException
	 */
	public PiPatContDO getPatContById(String id_patcont) throws BizException {
		EnValidator.validateParam("患者联系人ID", id_patcont);
		// 患者联系人查询服务
		IPiPatContDORService qryService = ServiceFinder.find(IPiPatContDORService.class);
		return qryService.findById(id_patcont);
	}

	/**
	 * 新增患者联系人
	 * 
	 * @param contDO
	 *            患者联系人DO
	 * @return 新增后的患者联系人DO
	 * @throws BizException
	 */
	public PiPatContDO insertPatContDO(PiPatContDO contDO) throws BizException {
		if (null == contDO) {
			return null;
		}
		IPatiRService patQryService = ServiceFinder.find(IPatiRService.class);
		IPatiCudService patCmdService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO aggDO = patQryService.findById(contDO.getId_pat());
		aggDO.getParentDO().setStatus(DOStatus.UPDATED);
		aggDO.setPiPatContDO(new PiPatContDO[] { contDO });
		aggDO = patCmdService.save(new PatiAggDO[] { aggDO })[0];
		return aggDO.getPiPatContDO()[0];
	}

	/**
	 * 更新患者联系人
	 * 
	 * @param contDO
	 *            患者联系人DO
	 * @throws BizException
	 */
	public void updatePatContDO(PiPatContDO contDO) throws BizException {
		if (null == contDO) {
			return;
		}
		IPatiRService patQryService = ServiceFinder.find(IPatiRService.class);
		IPatiCudService patCmdService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO aggDO = patQryService.findById(contDO.getId_pat());
		aggDO.getParentDO().setStatus(DOStatus.UPDATED);
		aggDO.setPiPatContDO(new PiPatContDO[] { contDO });
		patCmdService.save(new PatiAggDO[] { aggDO });
	}

	/**
	 * 删除就诊联系人
	 * 
	 * @author zhengcm
	 * @param entId
	 *            就诊ID
	 * @throws BizException
	 */
	public void deleteEntContByEntId(String entId) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			return;
		}
		EntContDO[] contDOs = this.getEntContByEntId(entId);
		if (EnValidator.isEmpty(contDOs)) {
			return;
		}
		// 就诊联系人维护服务
		IEntcontCudService cmdService = ServiceFinder.find(IEntcontCudService.class);
		cmdService.delete(contDOs);
	}

	/**
	 * 根据就诊ID批量获取新生儿就诊联系人（母亲）
	 *
	 * @param entIds
	 *            就诊ID数组
	 * @return 就诊联系人DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public EntContDO[] getBabyMomEntContByEntIds(String[] entIds) throws BizException {
		if (EnValidator.isEmpty(entIds)) {
			return null;
		}
		String entIdStr = "eu_entconttp = 4 and " + EnSqlUtils.getInSqlByIds("id_ent", entIds);
		// 就诊联系人查询服务
		IEntcontRService qryService = ServiceFinder.find(IEntcontRService.class);
		return qryService.find(entIdStr, "sortno", FBoolean.FALSE);
	}

	/**
	 * 删除就诊联系人
	 *
	 * @param entContDOs
	 *            就诊联系人DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deleteEntContDO(EntContDO[] entContDOs) throws BizException {
		if (EnValidator.isEmpty(entContDOs)) {
			return;
		}
		// 就诊联系人维护服务
		IEntcontCudService cmdService = ServiceFinder.find(IEntcontCudService.class);
		cmdService.delete(entContDOs);
	}

	/**
	 * 保存就诊联系人
	 * 
	 * @param entId
	 * @param regPiCont
	 * @throws BizException
	 */
	public void saveEntCont(String entId, OpRegPiContDTO regPiCont) throws BizException {
		PiPatContDO piPatContDO = this.getPatContById(regPiCont.getId_patcont());
		if (piPatContDO == null)
			return;
		EntContDO newEntCont = this.setEntConts(piPatContDO, entId, EuEntContTp.CONTACT, 1);
		// 就诊联系人维护服务
		this.saveEntContByStatus(Arrays.asList(newEntCont));
	}
}
