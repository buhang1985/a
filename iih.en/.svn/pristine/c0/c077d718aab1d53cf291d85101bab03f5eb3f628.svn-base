package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntDiEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.pv.dto.d.ObservationDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountCudService;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.s.EnaccountCrudServiceImpl;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.inpatient.d.EntIpntDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IEnipntMDOCudService;
import iih.en.pv.inpatient.i.IEnipntMDORService;
import iih.en.pv.inpatient.i.IEnipntRService;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.s.EnipntMDOCrudServiceImpl;
import iih.en.pv.inpatient.s.InpatientCrudServiceImpl;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.pv.pativisit.s.PativisitCrudServiceImpl;
import iih.pi.dic.creditcategory.d.PiPatCretDO;
import iih.pi.dic.creditcategory.i.ICreditcategoryRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatHpDORService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 急诊留观登记BP
 * 
 * @author licheng
 *
 */
public class ObsRegistBP {

	public ObsRegistBP() {
		
	}

	/**
	 * 根据就诊id查询许可
	 * 
	 * @param entId
	 * @return
	 */
	public ObservationDTO getPermitByEntId(String entId) throws BizException {

		PatQryBP bp = new PatQryBP();
		IPativisitRService service = new PativisitCrudServiceImpl();
		PatiVisitDO pdo = service.findById(entId);
		ObservationDTO obs = new ObservationDTO();		
		IPatiMDORService patservice = ServiceFinder.find(IPatiMDORService.class);
		PatDO pat = patservice.findById(pdo.getId_pat()); //todo 又是agg
		// 查询是否有许可证
		IEnipntMDORService ipntservice = ServiceFinder.find(IEnipntMDORService.class);
		EntIpntDO[] Ipndos = ipntservice.find("id_ent='" + entId + "'", null,
				FBoolean.FALSE);

		String adress = bp.getPresentAddress(pat.getId_pat());
		if (Ipndos.length > 0) {
			EntIpntDO entIpntDO = Ipndos[0];
			obs = this.setObs(pat, entIpntDO, obs, adress);
			return obs;

		} else {
			if (pdo != null && pdo.getId_pat() != null) {

				obs.setCode_pat(pat.getCode());// 患者编码
				obs.setId_ent(entId);// entid
				obs.setSd_idtp(pat.getSd_idtp());// 身份证明
				obs.setId_code(pat.getId_code());// 身份证明
				obs.setId_pat(pat.getId_pat());
				// 获取患者地址
				obs.setAddress(adress);
				// 主要诊断
				EntDiEP entDiBP = new EntDiEP();
				EntDiDO entdi = entDiBP.getMainDi(entId,IEnDictCodeConst.SD_DI_SUNJ_TYPE_WEST);
				if (entdi != null) {
					obs.setId_diag_op_maj(entdi.getId_di());
					obs.setDesc_diag_op_maj(entdi.getSupplement());
					obs.setName_di_main(entdi.getName_didef_dis());
					obs.setDesc_di_main(entdi.getSupplement());
				}
				if (entdi == null) {
					entdi = entDiBP.getMainDi(entId, IEnDictCodeConst.SD_DI_SUNJ_TYPE_CHINA);
					if (entdi != null) {
						obs.setId_diag_op_maj_tcm(entdi.getId_di());
						obs.setDesc_diag_op_maj_tcm(entdi.getSupplement());
						obs.setName_di_main(entdi.getName_didef_dis());
						obs.setDesc_di_main(entdi.getSupplement());
					}
				}
				return obs;
			}
		}
		return null;
	}

	/**
	 * 开急诊留观许可证
	 * 
	 * @param obsDTO
	 *            留观DTO
	 * @throws BizException
	 */
	public void openPermit(ObservationDTO obsDTO) throws BizException {

		IPativisitRService service = new PativisitCrudServiceImpl();
		ObservationDTO obs = new ObservationDTO();
		PatiVisitDO pdo = service.findById(obsDTO.getId_ent());
		IEnipntRService ipservice = ServiceFinder.find(IEnipntRService.class);
		
		IEnipntMDORService ipntservice = ServiceFinder.find(IEnipntMDORService.class);
		EntIpntDO[] Ipndos = ipntservice.find("id_ent='" + obsDTO.getId_ent()
				+ "'", null, FBoolean.FALSE);
		EntIpntDO IpenDo = null;
		IPatiMDORService patservice = ServiceFinder.find(IPatiMDORService.class);
		PatDO pat = patservice.findById(pdo.getId_pat()); //todo 又是agg
		//todo 更新与插入用同一逻辑，只是状态不同
		if (Ipndos.length > 0) {
			IpenDo = Ipndos[0];	
		} else {
			IpenDo = new EntIpntDO();
		}
		
		saveEntIpnt(obsDTO, pdo, IpenDo, pat);

	}

	private void saveEntIpnt(ObservationDTO obsDTO, PatiVisitDO pdo,
			EntIpntDO IpenDo, PatDO pat) throws BizException {
		
		
		IpenDo.setId_ent(obsDTO.getId_ent());
		IpenDo.setId_entip(obsDTO.getId_ent());
		IpenDo.setId_pat(obsDTO.getId_pat());
		IpenDo.setName_pat(pat.getName());
		IpenDo.setSd_status_pat(obsDTO.getSd_status_pat());
		IpenDo.setDt_brith_pat(pat.getDt_birth());
		IpenDo.setId_hp(pdo.getId_hp());
		// 获取医保编号
		IPiPatHpDORService hpservice = ServiceFinder
				.find(IPiPatHpDORService.class);
		PiPatHpDO[] pathp = hpservice.find(
				PiPatHpDODesc.TABLE_ALIAS_NAME + ".id_hp='" + pdo.getId_hp()
						+ "' and " + PiPatHpDODesc.TABLE_ALIAS_NAME
						+ ". id_pat='" + obsDTO.getId_pat() + "' and "
						+ PiPatHpDODesc.TABLE_ALIAS_NAME + ". fg_act='Y'",
				null, FBoolean.FALSE);
		if (pathp.length > 0)
			IpenDo.setCode_hp(pathp[0].getNo_hp());// 医保编号
		IpenDo.setId_dep_op(obsDTO.getId_dep_op());
		IpenDo.setName_dep_op(obsDTO.getName_dep_op());
		IpenDo.setId_dep_phy_ip(obsDTO.getId_dep_phy_ip());
		IpenDo.setName_emp_phy_op(obsDTO.getName_dep_phy_ip());
		IpenDo.setId_diag_op_maj(obsDTO.getId_diag_op_maj());
		IpenDo.setDesc_diag_op_maj(obsDTO.getDesc_diag_op_maj());
		IpenDo.setId_status_pat(obsDTO.getId_status_pat());
		IpenDo.setId_dep_phy_ip(obsDTO.getId_dep_phy_ip());
		IpenDo.setId_dep_nur_ip(obsDTO.getId_dep_nur_ip());
		IpenDo.setSd_bedtype(null);
		FDateTime now = EnAppUtils.getServerDateTime();
		IpenDo.setDa_notice(now);
		IpenDo.setId_emp_notice(null);
		IpenDo.setName_emp_notice(null);
		IpenDo.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE);
		IpenDo.setDt_valid(null);
		IpenDo.setNote(obsDTO.getNote());
		IpenDo.setDt_admit_plan(obsDTO.getDt_admit_plan());// 转留观时间
		IpenDo.setAmt_deposit(obsDTO.getAmt_prepay());// 预交金

		// 校验床位
		IBedMDOCudService bedRser = ServiceFinder.find(IBedMDOCudService.class);// todo
																				// 两个bed服务，应该命名根据功能而定
		IBedMDORService bedCUDservice = ServiceFinder
				.find(IBedMDORService.class);

		if (IpenDo.getId_ent_ipnt() != null) {
			// 释放原来床位
			BedEP bedbp = new BedEP();
			bedbp.releaseBed(null, IpenDo.getId_bed());
			IpenDo.setStatus(DOStatus.UPDATED);

		} else {
			IpenDo.setStatus(DOStatus.NEW);
		}
		// 锁定新的床位  obsDTO.getId_bed()
	
		BedEP bedbp = new BedEP();
		bedbp.useBed2(obsDTO.getId_bed());
		IpenDo.setId_bed(obsDTO.getId_bed());
		IEnipntMDOCudService ipntcudservice = ServiceFinder
				.find(IEnipntMDOCudService.class);
		ipntcudservice.save(new EntIpntDO[] { IpenDo });
	}

	/**
	 * 取消作废许可
	 * 
	 * @param obsDTO
	 * @throws BizException
	 */
	public void cancelPermit(ObservationDTO obsDTO) throws BizException {

		IPativisitRService service = new PativisitCrudServiceImpl();
		// ObservationDTO obs=new ObservationDTO();
		PatiVisitDO pdo = service.findById(obsDTO.getId_ent());
		// IIpntRService ipservice=new IpntCrudServiceImpl();
		IEnipntMDOCudService pntservice = new EnipntMDOCrudServiceImpl();
		IEnipntMDORService ipservice = new EnipntMDOCrudServiceImpl();
		EntIpntDO[] Ipndos = ipservice.find("id_ent='" + obsDTO.getId_ent()
				+ "'", null, FBoolean.FALSE);
		EntIpntDO IpenDo = Ipndos[0];


		if (IpenDo != null) {

			if (IpenDo.getSd_status().equals(IEnDictCodeConst.SD_STATUS_NOTICE_INHOS)) {

				// return null;
			} else {
				EntIpntDO aggdo = new EntIpntDO();
				IpenDo.setStatus(DOStatus.DELETED);

				pntservice.delete(new EntIpntDO[] { aggdo });
				IBedMDOCudService bedCUDser = ServiceFinder
						.find(IBedMDOCudService.class);
				IBedMDORService bedRservice = ServiceFinder
						.find(IBedMDORService.class);
				Bdbed beddo = bedRservice.findById(IpenDo.getId_bed()); 
				if(beddo!=null){
				beddo.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_EMPTY);
				beddo.setStatus(DOStatus.UPDATED);
				bedCUDser.update(new Bdbed[] { beddo });
				}

			}
		}

	}

	/**
	 * 获取急诊留观许可证
	 * 
	 * @param patId
	 *            患者id
	 * @return
	 * @throws BizException
	 */
	public ObservationDTO[] getPermit(String patId) throws BizException {

		IPatiRService patservice = ServiceFinder.find(IPatiRService.class);
		PatiAggDO patagg = patservice.findById(patId);
		PatDO pat = patagg.getParentDO();
		// 查地址
		PatQryBP bp = new PatQryBP();
		String adress = bp.getPresentAddress(patId);
		
		Date date = new Date();
		Date s = new Date(date.getTime() - 24 * 3600 * 1000); //todo 直接写在where条件中
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String time = sdf.format(s);
		IEnipntMDORService ipservice = new EnipntMDOCrudServiceImpl();
		EntIpntDO[] Ipndos = ipservice.find("id_pat='" + patId + "' and (To_Date(dt_admit_plan, 'yyyy-mm-dd hh24:mi:ss') - To_Date('"+time+"', 'yyyy-mm-dd hh24:mi:ss'))>0", null,
				FBoolean.FALSE);
		List<ObservationDTO> listObs = new ArrayList<ObservationDTO>();
		for (EntIpntDO entIpntDO : Ipndos) {
			ObservationDTO obs = new ObservationDTO();

			obs = setObs(pat, entIpntDO, obs, adress);

			listObs.add(obs);
		}
		if (listObs.size() > 0)
			return listObs.toArray(new ObservationDTO[0]);
		else
			return null;
	}

	private ObservationDTO setObs(PatDO pat, EntIpntDO entIpntDO,
			ObservationDTO obs, String adress) throws BizException {
		obs.setDt_admit_plan(entIpntDO.getDt_admit_plan());// 留观时间
		obs.setCode_pat(pat.getCode());// 患者编码
		obs.setId_ent(entIpntDO.getId_ent());// entid
		obs.setSd_idtp(pat.getSd_idtp());// 身份证明
		obs.setId_code(pat.getId_code());// 身份证明
		obs.setId_pat(pat.getId_pat());
		obs.setAmt_prepay(entIpntDO.getAmt_deposit());
		obs.setNote(entIpntDO.getNote());

		// 获取病区
		obs.setId_dep_nur_ip(entIpntDO.getId_dep_nur_ip());
		IDeptRService depservice = ServiceFinder.find(IDeptRService.class);
		DeptDO dep = depservice.findById(entIpntDO.getId_dep_nur_ip());
		if (dep != null) {
			obs.setName_dep_nur_ip(dep.getName());
			// 获取床位
			obs.setId_bed(entIpntDO.getId_bed());
			IBedMDORService bedservice = ServiceFinder
					.find(IBedMDORService.class);
			Bdbed bed = bedservice.findById(entIpntDO.getId_bed());
			if (bed != null)
				obs.setName_bed(bed.getName());
		}
		// 病情状况
		obs.setId_status_pat(entIpntDO.getId_status_pat());
		obs.setSd_status_pat(entIpntDO.getSd_status_pat());
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		UdidocDO udi = service.findById(entIpntDO.getId_status_pat());
		if (udi != null)
			obs.setNamestatuspat(udi.getName());

		// 获取患者地址
		obs.setAddress(adress);
		// 主要诊断
		EntDiEP entDiBP = new EntDiEP();
		EntDiDO entdi = entDiBP.getMainDi(entIpntDO.getId_ent(),IEnDictCodeConst.SD_DI_SUNJ_TYPE_WEST);
		if (entdi != null) {
			obs.setId_diag_op_maj(entdi.getId_di());
			obs.setDesc_diag_op_maj(entdi.getSupplement());
			obs.setName_di_main(entdi.getName_didef_dis());
			obs.setDesc_di_main(entdi.getSupplement());
		}
		if (entdi == null) {
			entdi = entDiBP.getMainDi(entIpntDO.getId_ent(), IEnDictCodeConst.SD_DI_SUNJ_TYPE_CHINA);
			if (entdi != null) {
				obs.setId_diag_op_maj_tcm(entdi.getId_di());
				obs.setDesc_diag_op_maj_tcm(entdi.getSupplement());
				obs.setName_di_main(entdi.getName_didef_dis());
				obs.setDesc_di_main(entdi.getSupplement());
			}
		}
		// 通知单状态
		obs.setSd_status(entIpntDO.getSd_status());
		return obs;
	}

	/**
	 * 留观许可确认
	 * 
	 * @param obsDTO
	 *            留观DTO
	 * @throws BizException
	 */
	public void confirmPermit(ObservationDTO obsDTO) throws BizException {

		IEnipntMDORService ipntservice = ServiceFinder.find(IEnipntMDORService.class);
		IEnipntMDOCudService ipntcudservice = ServiceFinder.find(IEnipntMDOCudService.class);
		IPativisitRService service = new PativisitCrudServiceImpl();
		IPativisitCudService cudservice = new PativisitCrudServiceImpl();
		EntIpntDO[] Ipndos = ipntservice.find("id_ent='" + obsDTO.getId_ent()
				+ "'", null, FBoolean.FALSE);
		if (Ipndos.length > 0) {

			EntIpntDO pndo = Ipndos[0];
			if (pndo.getSd_status().equals(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE)
					|| pndo.getSd_status().equals(IEnDictCodeConst.SD_STATUS_NOTICE_NOTIFY)) {
				// 修改en_ent
				PatiVisitDO pdo = service.findById(obsDTO.getId_ent());
				pdo.setCode_entp("33");
				pdo.setStatus(DOStatus.UPDATED);
				cudservice.save(new PatiVisitDO[] { pdo });
				// 保存表en_ent_ip
				IInpatientCudService ipservice = new InpatientCrudServiceImpl();
				InpatientDO ipdo = new InpatientDO();
				ipdo.setId_ent(pndo.getId_ent());
				ipdo.setId_dep_phyadm(pndo.getId_dep_phy_ip());
				ipdo.setId_dep_nuradm(pndo.getId_dep_nur_ip());
				ipdo.setId_bed(pndo.getId_bed());
				ipdo.setFg_surg(FBoolean.FALSE);
				ipdo.setSd_level_nur(null);
				ipdo.setSd_level_nutr(null);
				ipdo.setFg_newborn(FBoolean.FALSE);
				ipdo.setNum_newborn(0);
				ipdo.setSd_outcomes(null);
				ipdo.setSd_referalsrc("2");

				PiPatContDO picodo = this.setPiCont(pndo.getId_pat(), 0);
				if (picodo != null) {
					ipdo.setId_patcont(picodo.getId_patcont());
					ipdo.setCont_name(picodo.getName());
					ipdo.setCont_tel(picodo.getConttel());
				}
				ipdo.setSd_gowhere(null);
				ipdo.setId_dep_phydisc(null);
				ipdo.setId_dep_nurdisc(null);
				ipdo.setFg_doc_commit(null);
				ipdo.setDt_doc_commit(null);
				ipdo.setSd_doc_status(null);
				ipdo.setStatus(DOStatus.NEW);
				ipservice.save(new InpatientDO[] { ipdo });
				// ipdo.setsd
				pndo.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_INHOS);
				pndo.setStatus(DOStatus.UPDATED);
				ipntcudservice.save(new EntIpntDO[] { pndo });

				// 保存en_ent_acc
				EnAccountDO accdo = new EnAccountDO();
				IEnaccountCudService accser = new EnaccountCrudServiceImpl();
				accdo.setId_ent(obsDTO.getId_ent());
				accdo.setId_pat(pdo.getId_pat());
				// 信用额度
				ICreditcategoryRService credser = ServiceFinder
						.find(ICreditcategoryRService.class);
				PiPatCretDO[] picats = credser.find(
						"id_patcret='" + pdo.getId_patcret() + "'", null,
						FBoolean.FALSE);
				if (picats.length > 0) {
					accdo.setAmt_cred(picats[0].getEncred());
				}

				accdo.setAmt_prepay(obsDTO.getAmt_prepay());
				accdo.setAmt_uncg(new FDouble(0));
				accdo.setAmt_owelimit(new FDouble(0));
				accdo.setDt_backcg(pdo.getDt_entry());//记录入院时间，给定一个默认值，同入院登记
				accdo.setDt_backcglastact(pdo.getDt_entry());
				accdo.setStatus(DOStatus.NEW);
				
				IEnaccountMDOCudService enaccCrudService = ServiceFinder.find(IEnaccountMDOCudService.class);
				enaccCrudService.save(new EnAccountDO[] { accdo });
			}
		}

	}
	//todo 命名与返回值不符合
	private PiPatContDO setPiCont(String patid, int sno) throws DAException {
		StringBuilder sb = new StringBuilder();
		sb.append("select *  from pi_pat_cont  ");
		sb.append("where id_pat=? and sortno=? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(patid);
		sqlParam.addParam(sno);
		PiPatContDO result = (PiPatContDO) new DAFacade().execQuery(
				sb.toString(), sqlParam, new BeanHandler(PiPatContDO.class));
		return result;
	}

}
