package iih.bd.pp.baseprisrv.s.bp;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.pp.accountsrv.d.AccountSrvDO;
import iih.bd.pp.accountsrv.i.IAccountsrvExtCudService;
import iih.bd.pp.accountsrvrel.d.MedsrvAccountRelDTO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import iih.bd.pp.incca.i.IInccaitmrelRService;
import iih.bd.pp.primd.d.PrimdDO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPrimdRService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedSrvCodeSetDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvCodeSetDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateMDORService;
import iih.bd.utils.BdPpParamUtils;
import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 保存价格服务
 * 
 * @author hao_wu 2019-12-17
 *
 */
public class SavePriSrvBp {

	public PriSrvDO[] exec(PriSrvDO[] priSrvDOs) throws BizException {

		// 生成主键
		updateId(priSrvDOs);

		// 保存账单项信息
		saveIncca(priSrvDOs);

		// 保存核算体系
		saveAcc(priSrvDOs);

		// 保存外部标准编码
		saveExStdCode(priSrvDOs);

		// 保存医疗服务
		saveMedSrv(priSrvDOs);

		updateState(priSrvDOs);

		return priSrvDOs;
	}

	/**
	 * 更新服务主键</br>
	 * 先生成主键，保存所有子数据
	 * 
	 * @param aggs
	 */
	private void updateId(PriSrvDO[] priSrvDO) {
		for (PriSrvDO priSrvDo : priSrvDO) {
			String srvId = priSrvDo.getId_srv();
			if (StringUtils.isBlank(srvId)) {
				srvId = new DBUtil().getOIDs(1)[0];
				priSrvDo.setId_srv(srvId);
			}
		}
	}

	/**
	 * 更新状态为UNCHANGED
	 * 
	 * @param aggs
	 */
	private void updateState(PriSrvDO[] priSrvDOs) {
		for (PriSrvDO priSrvDo : priSrvDOs) {
			priSrvDo.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 保存外部标准编码
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	private void saveExStdCode(PriSrvDO[] priSrvDOs) throws BizException {
		String[] srvIds = DoUtils.getAttrValArr(priSrvDOs, PriSrvDO.ID_SRV, String.class);

		IMedSrvCodeSetDORService codeRService = ServiceFinder.find(IMedSrvCodeSetDORService.class);

		String wherePart = String.format("sd_cdstd = '%s' and %s", IBdSrvDictCodeConst.SD_CDSTD_PRICE_PRICE,
				SqlUtils.getInSqlByIds("id_srv", srvIds));
		MedSrvCodeSetDO[] codeDos = codeRService.find(wherePart, "", FBoolean.FALSE);
		Map<String, MedSrvCodeSetDO> codeMap = MapUtils.convertArrayToMap(codeDos, MedSrvCodeSetDO.ID_SRV);

		UdidocDO priCdStdDocDo = UdidocUtils.getUdidocByCode(IBdSrvDictCodeTypeConst.SD_CDSTD,
				IBdSrvDictCodeConst.SD_CDSTD_PRICE_PRICE);

		ArrayList<MedSrvCodeSetDO> codeList = new ArrayList<MedSrvCodeSetDO>();
		for (PriSrvDO priSrvDo : priSrvDOs) {
			String exStdCode = priSrvDo.getCode_exstd();
			String srvId = priSrvDo.getId_srv();
			if (StringUtils.isNotBlank(exStdCode) && !codeMap.containsKey(srvId)) {
				// 新增
				MedSrvCodeSetDO newCodeDo = new MedSrvCodeSetDO();
				newCodeDo.setId_srv(priSrvDo.getId_srv());
				newCodeDo.setId_cdstd(priCdStdDocDo.getId_udidoc());
				newCodeDo.setSd_cdstd(IBdSrvDictCodeConst.SD_CDSTD_PRICE_PRICE);
				newCodeDo.setCode(exStdCode);
				newCodeDo.setStatus(DOStatus.NEW);
				codeList.add(newCodeDo);
			} else if (StringUtils.isNotBlank(exStdCode) && codeMap.containsKey(srvId)) {
				// 修改
				MedSrvCodeSetDO codeSetDo = codeMap.get(srvId);
				codeSetDo.setCode(exStdCode);
				codeSetDo.setStatus(DOStatus.UPDATED);
				codeList.add(codeSetDo);
			} else if (StringUtils.isBlank(exStdCode) && codeMap.containsKey(srvId)) {
				// 删除
				MedSrvCodeSetDO codeSetDo = codeMap.get(srvId);
				codeSetDo.setStatus(DOStatus.DELETED);
				codeList.add(codeSetDo);
			}
		}

		if (codeList.size() > 0) {
			IMedSrvCodeSetDOCudService codeDoCudService = ServiceFinder.find(IMedSrvCodeSetDOCudService.class);
			codeDoCudService.save(codeList.toArray(new MedSrvCodeSetDO[0]));
		}
	}

	/**
	 * 保存账单项
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	private void saveIncca(PriSrvDO[] priSrvDOs) throws BizException {
		String[] srvIds = DoUtils.getAttrValArr(priSrvDOs, PriSrvDO.ID_SRV, String.class);
		if (ArrayUtils.isEmpty(srvIds)) {
			return;
		}

		// 删除旧的账单信息
		IInccaitmrelRService inccaitmrelRService = ServiceFinder.find(IInccaitmrelRService.class);
		String wherePart = String.format("sd_incca in ('%s','%s') and %s", IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE,
				IBdInccaCodeConst.CODE_INHOS_INVOICE, SqlUtils.getInSqlByIds(AccountSrvDO.ID_SRV, srvIds));
		IncCaItmRelDO[] itmRels = inccaitmrelRService.find(wherePart, "", FBoolean.FALSE);
		IInccaitmrelCudService inccaitmrelCudService = ServiceFinder.find(IInccaitmrelCudService.class);
		inccaitmrelCudService.delete(itmRels);

		// 构建新的账单信息
		ArrayList<IncCaItmRelDO> inccaRelDoList = new ArrayList<IncCaItmRelDO>();
		for (PriSrvDO priSrvDO : priSrvDOs) {

			// 门诊账单项
			IncCaItmRelDO inccaRelDo = new IncCaItmRelDO();
			inccaRelDo.setStatus(DOStatus.NEW);
			inccaRelDo.setId_grp(priSrvDO.getId_grp());
			inccaRelDo.setId_org(priSrvDO.getId_org());
			inccaRelDo.setId_srv(priSrvDO.getId_srv());
			inccaRelDo.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
			inccaRelDo.setSd_incca(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
			inccaRelDo.setId_inccaitm(priSrvDO.getId_incca_op());
			inccaRelDoList.add(inccaRelDo);
			// 住院账单项
			inccaRelDo = new IncCaItmRelDO();
			inccaRelDo.setId_grp(priSrvDO.getId_grp());
			inccaRelDo.setId_org(priSrvDO.getId_org());
			inccaRelDo.setStatus(DOStatus.NEW);
			inccaRelDo.setId_srv(priSrvDO.getId_srv());
			inccaRelDo.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);
			inccaRelDo.setSd_incca(IBdInccaCodeConst.CODE_INHOS_INVOICE);
			inccaRelDo.setId_inccaitm(priSrvDO.getId_incca_ip());
			inccaRelDoList.add(inccaRelDo);
		}

		inccaitmrelCudService.insert(inccaRelDoList.toArray(new IncCaItmRelDO[0]));
	}

	/**
	 * 保存核算体系
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	private void saveAcc(PriSrvDO[] priSrvDOs) throws BizException {
		MedsrvAccountRelDTO[] srvAccRelDTOs = new MedsrvAccountRelDTO[priSrvDOs.length];
		for (int i = 0; i < priSrvDOs.length; i++) {
			PriSrvDO priSrvDo = priSrvDOs[i];

			MedsrvAccountRelDTO relDto = new MedsrvAccountRelDTO();
			relDto.setId_srv(priSrvDo.getId_srv());
			relDto.setId_account(priSrvDo.getId_acc_share());
			relDto.setId_account_op(priSrvDo.getId_acc_op());
			relDto.setId_account_ip(priSrvDo.getId_acc_ip());
			srvAccRelDTOs[i] = relDto;
		}

		IAccountsrvExtCudService accountsrvExtCudService = ServiceFinder.find(IAccountsrvExtCudService.class);
		accountsrvExtCudService.updateMedsrvAccountRel(srvAccRelDTOs);
	}

	private void saveMedSrv(PriSrvDO[] priSrvDOs) throws BizException {
		String[] srvIds = DoUtils.getAttrValArr(priSrvDOs, PriSrvDO.ID_SRV, String.class);
		Map<String, MedSrvDO> medSrvMap = findMedSrvMapByIds(srvIds);

		// 转换为医疗服务
		MedSrvDO[] medsrvDos = new MedSrvDO[priSrvDOs.length];
		for (int i = 0; i < priSrvDOs.length; i++) {
			PriSrvDO priSrvDO = priSrvDOs[i];
			MedSrvDO oldMedSrv = null;
			if (medSrvMap.containsKey(priSrvDO.getId_srv())) {
				oldMedSrv = medSrvMap.get(priSrvDO.getId_srv());
			}
			MedSrvDO medSrvDo = convertToMedSrvDo(priSrvDO, oldMedSrv);
			medsrvDos[i] = medSrvDo;
		}

		// 保存
		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		medsrvDos = medsrvMDOCudService.save(medsrvDos);

		// 信息回写价表服务
		for (int i = 0; i < priSrvDOs.length; i++) {
			PriSrvDO priSrvDO = priSrvDOs[i];
			MedSrvDO medSrvDo = medsrvDos[i];
			priSrvDO.setDs(medSrvDo.getDs());
			priSrvDO.setCreatedby(medSrvDo.getCreatedby());
			priSrvDO.setCreatedtime(medSrvDo.getCreatedtime());
			priSrvDO.setModifiedby(medSrvDo.getModifiedby());
			priSrvDO.setModifiedtime(medSrvDo.getModifiedtime());
			priSrvDO.setSv(medSrvDo.getSv());
		}
	}

	/**
	 * 根据服务主键查询医疗服务字典
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> findMedSrvMapByIds(String[] srvIds) throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] srvDos = medsrvMDORService.findByIds(srvIds, FBoolean.FALSE);

		return MapUtils.convertArrayToMap(srvDos, MedSrvDO.ID_SRV);
	}

	/**
	 * 将价表服务转换为医疗服务
	 * 
	 * @param priSrvDO
	 * @param oldMedSrv
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO convertToMedSrvDo(PriSrvDO priSrvDO, MedSrvDO oldMedSrv) throws BizException {
		if (oldMedSrv == null) {
			oldMedSrv = createPriMedSrv();
		}

		updateMedSrv(oldMedSrv, priSrvDO);
		return oldMedSrv;
	}

	/**
	 * 将价表服务的值更新到价表服务
	 * 
	 * @param oldMedSrv
	 * @param priSrvDO
	 * @throws BizException
	 */
	private void updateMedSrv(MedSrvDO oldMedSrv, PriSrvDO priSrvDO) throws BizException {

		oldMedSrv.setId_srv(priSrvDO.getId_srv());
		oldMedSrv.setId_grp(priSrvDO.getId_grp());
		oldMedSrv.setId_org(priSrvDO.getId_org());
		oldMedSrv.setCode(priSrvDO.getCode());
		oldMedSrv.setName(priSrvDO.getName());
		oldMedSrv.setPycode(priSrvDO.getPycode());
		oldMedSrv.setWbcode(priSrvDO.getWbcode());
		oldMedSrv.setMnecode(priSrvDO.getMnecode());
		oldMedSrv.setShortname(priSrvDO.getShortname());
		oldMedSrv.setId_srvtp(priSrvDO.getId_srvtp());
		oldMedSrv.setSd_srvtp(priSrvDO.getSd_srvtp());
		oldMedSrv.setId_srvca(priSrvDO.getId_srvca());
		oldMedSrv.setId_unit_med(priSrvDO.getId_unit_med());
		oldMedSrv.setEu_blmd(priSrvDO.getEu_blmd());
		oldMedSrv.setDes_pri(priSrvDO.getDes());
		oldMedSrv.setId_pritp(priSrvDO.getId_pritp());
		oldMedSrv.setSd_pritp(priSrvDO.getSd_pritp());
		oldMedSrv.setFg_active_bl(priSrvDO.getFg_active());
		oldMedSrv.setDef1(priSrvDO.getDef1());
		oldMedSrv.setDef2(priSrvDO.getDef2());
		oldMedSrv.setDef3(priSrvDO.getDef3());
		oldMedSrv.setDef4(priSrvDO.getDef4());
		oldMedSrv.setDef5(priSrvDO.getDef5());
		oldMedSrv.setDef6(priSrvDO.getDef6());
		oldMedSrv.setDef7(priSrvDO.getDef7());
		oldMedSrv.setDef8(priSrvDO.getDef8());
		oldMedSrv.setDef9(priSrvDO.getDef9());
		oldMedSrv.setDef10(priSrvDO.getDef10());

		ISrvcateMDORService srvcateMDORService = ServiceFinder.find(ISrvcateMDORService.class);
		SrvCateDO srvCaDo = srvcateMDORService.findById(priSrvDO.getId_srvca());
		if (srvCaDo != null) {
			oldMedSrv.setSrvca_innercode(srvCaDo.getInnercode());
		}

		if (oldMedSrv.getStatus() != DOStatus.NEW) {
			oldMedSrv.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 创建新的价格医疗服务
	 * 
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO createPriMedSrv() throws BizException {
		MedSrvDO priMedSrv = new MedSrvDO();
		priMedSrv.setStatus(DOStatus.NEW);
		priMedSrv.setFg_active(FBoolean.FALSE);
		priMedSrv.setFg_use_er(FBoolean.FALSE);
		priMedSrv.setFg_use_fm(FBoolean.FALSE);
		priMedSrv.setFg_use_ip(FBoolean.FALSE);
		priMedSrv.setFg_use_op(FBoolean.FALSE);
		priMedSrv.setFg_use_pe(FBoolean.FALSE);
		priMedSrv.setEu_blmd(0);
		priMedSrv.setQuan_med(new FDouble(1));
		priMedSrv.setIsmuldose(FBoolean.TRUE);
		priMedSrv.setIsmulexec(FBoolean.FALSE);
		priMedSrv.setFg_mm(FBoolean.FALSE);
		priMedSrv.setFg_bl(FBoolean.TRUE);
		priMedSrv.setFg_set(FBoolean.FALSE);

		// 定价模式 本服务定价
		IPrimdRService primdRService = ServiceFinder.find(IPrimdRService.class);
		PrimdDO[] primdDos = primdRService.findByAttrValString(PrimdDO.CODE, IBdPrimdCodeConst.CODE_PRI_SRV);
		if (ArrayUtils.isNotEmpty(primdDos)) {
			PrimdDO primdDo = primdDos[0];
			priMedSrv.setId_primd(primdDo.getId_pri());
			priMedSrv.setSd_primd(primdDo.getCode());
			priMedSrv.setPrimd_code(primdDo.getCode());
			priMedSrv.setPrimd_name(primdDo.getName());
		}

		// 频次
		IFreqdefMDORService freqdefMDORService = ServiceFinder.find(IFreqdefMDORService.class);
		FreqDefDO[] result = freqdefMDORService.findByAttrValString(FreqDefDO.CODE,
				IBdSrvDictCodeConst.CODE_FREQNUNITCT_ITEM_ONCE);
		if (ArrayUtils.isNotEmpty(result)) {
			FreqDefDO defaultFreq = result[0];
			priMedSrv.setId_freq(defaultFreq.getId_freq());
			priMedSrv.setFreq_code(defaultFreq.getCode());
			priMedSrv.setFreq_name(defaultFreq.getName());
			priMedSrv.setSd_frequnitct(defaultFreq.getSd_frequnitct());
			priMedSrv.setFrequnitct(defaultFreq.getFrequnitct());
			priMedSrv.setFreqct(defaultFreq.getFreqct());
			priMedSrv.setFg_prnor(defaultFreq.getFg_prnor());
			priMedSrv.setFg_long(defaultFreq.getFg_long());
		}

		FBoolean defaultFgOr = BdPpParamUtils.getDefaultFgOr();
		priMedSrv.setFg_or(defaultFgOr);

		return priMedSrv;
	}
}
