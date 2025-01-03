package iih.ei.std.s.v1.bp.bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.pp.accountsubject.d.AccountSubjectDO;
import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.baseprisrv.i.IBasePriSrvExtCudService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvCudService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvMDOCudService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvMDORService;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.modifypriplan.d.EuModifyPriMd;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.d.ModifypriplanAggDO;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanDODesc;
import iih.bd.pp.modifypriplan.i.IModifyPriPlanExtCudService;
import iih.bd.pp.modifypriplan.i.IModifypriplanCudService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.utils.BdPpParamUtils;
import iih.bd.utils.UdidocUtils;
import iih.ei.std.d.v1.bd.sync.prisrvdoc.d.PriceSrvDTO;
import iih.ei.std.d.v1.bd.sync.prisrvdoc.d.PriceSrvListDTO;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.s.bp.IIHServiceParamUtils;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 同步价格服务档案
 * 
 * @author hao_wu 2019-12-16
 *
 */
public class SyncPriSrvDocBp extends IIHServiceBaseBP<PriceSrvListDTO, NoParamDTO> {

	/**
	 * 价格服务DTO字典
	 */
	private HashMap<String, PriceSrvDTO> _priSrvDtoMap;
	/**
	 * 价格服务DO字典
	 */
	private HashMap<String, PriSrvDO> _priSrvDoMap;
	/**
	 * 服务类型字典
	 */
	private HashMap<String, UdidocDO> _srvTpMap;
	/**
	 * 服务分类字典
	 */
	private HashMap<String, SrvCateDO> _srvCaMap;
	/**
	 * 单位字典
	 */
	private HashMap<String, MeasDocDO> _unitMap;
	/**
	 * 门诊账单项字典
	 */
	private HashMap<String, IncCaItmDO> _opIncMap;
	/**
	 * 住院账单项字典
	 */
	private HashMap<String, IncCaItmDO> _ipIncMap;
	/**
	 * 收费分类字典
	 */
	private HashMap<String, UdidocDO> _priTpMap;
	/**
	 * 门诊核算体系字典
	 */
	private HashMap<String, AccountSubjectDO> _opAccMap;
	/**
	 * 住院核算体系字典
	 */
	private HashMap<String, AccountSubjectDO> _ipAccMap;
	/**
	 * 共享核算体系字典
	 */
	private HashMap<String, AccountSubjectDO> _shareAccMap;

	private ModifyPriPlanDO _planDo;

	private DAFacade _daFacade = new DAFacade();

	/**
	 * 使用财务核算体系
	 */
	private FBoolean _useAccountSystem;

	/**
	 * 共享财务核算体系
	 */
	private FBoolean _shareAcountSystem;

	public SyncPriSrvDocBp() throws BizException {
		this._priSrvDtoMap = new HashMap<>();
		this._priSrvDoMap = new HashMap<>();
		this._srvTpMap = new HashMap<>();
		this._srvCaMap = new HashMap<>();
		this._unitMap = new HashMap<>();
		this._opIncMap = new HashMap<>();
		this._ipIncMap = new HashMap<>();
		this._priTpMap = new HashMap<>();
		this._opAccMap = new HashMap<>();
		this._ipAccMap = new HashMap<>();
		this._shareAccMap = new HashMap<>();

		this._useAccountSystem = BdPpParamUtils.getUseAccountSystemFlag();
		this._shareAcountSystem = BdPpParamUtils.getShareAcountSystemFlag();
	}

	@Override
	protected void checkParam(PriceSrvListDTO param) throws BizException {
		if (param == null || param.getPricesrv() == null || param.getPricesrv().size() <= 0) {
			throw new BizException("价格服务不允许为空。");
		}

		FArrayList priSrvList = param.getPricesrv();
		if (priSrvList.size() > 500) {
			throw new BizException("价格服务数量不允许大于500");
		}
		for (int i = 0; i < priSrvList.size(); i++) {
			PriceSrvDTO priceSrvDTO = (PriceSrvDTO) priSrvList.get(i);
			if (priceSrvDTO == null) {
				String msg = String.format("第【%s】个价格服务为空。", i + 1);
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(priceSrvDTO.getCode())) {
				String msg = String.format("第【%s】个价格服务的编码为空。", i + 1);
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(priceSrvDTO.getName())) {
				String msg = String.format("价格服务的名称为空，编码【%s】。", priceSrvDTO.getCode());
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(priceSrvDTO.getSd_srvtp())) {
				String msg = String.format("价格服务的服务类型编码为空，编码【%s】。", priceSrvDTO.getCode());
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(priceSrvDTO.getSd_pritp())) {
				String msg = String.format("价格服务的收费分类编码为空，编码【%s】。", priceSrvDTO.getCode());
				throw new BizException(msg);
			}

			if (priceSrvDTO.getPri() == null) {
				String msg = String.format("价格服务的价格为空，编码【%s】。", priceSrvDTO.getCode());
				throw new BizException(msg);
			}

			if (priceSrvDTO.getFg_active() == null) {
				String msg = String.format("价格服务的启用标志为空，编码【%s】。", priceSrvDTO.getCode());
				throw new BizException(msg);
			}

			if (this._priSrvDtoMap.containsKey(priceSrvDTO.getCode())) {
				String msg = String.format("价格服务的编码重复，编码【%s】。", priceSrvDTO.getCode());
				throw new BizException(msg);
			}

			this._priSrvDtoMap.put(priceSrvDTO.getCode(), priceSrvDTO);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected NoParamDTO process(PriceSrvListDTO param) throws BizException {
		FArrayList priSrvList = param.getPricesrv();
		final PriceSrvDTO[] priSrvDtos = (PriceSrvDTO[]) priSrvList.toArray(new PriceSrvDTO[0]);

		// 1.初始化数据字典
		initDataMap(priSrvDtos);

		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						syncPriSrvInTrans(priSrvDtos);
						return null;
					} catch (BizException e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
				}
			});
		} catch (BizRuntimeException e) {
			if (e.getCause() instanceof BizException) {
				throw (BizException) e.getCause();
			} else {
				throw e;
			}
		}

		// 执行调价计划
		execModifyPriPlan();

		return null;
	}

	/**
	 * 执行调价计划<br/>
	 * 因调价计划的执行依赖数据库的数据，所以放在事务后处理
	 * 
	 * @throws BizException
	 */
	private void execModifyPriPlan() throws BizException {
		if (_planDo != null) {
			IModifyPriPlanExtCudService planExtCudService = ServiceFinder.find(IModifyPriPlanExtCudService.class);
			planExtCudService.modifyPriceByIds(new String[] { this._planDo.getId_modifypriplan() });
		}
	}

	/**
	 * 事务内同步价格服务信息
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	protected void syncPriSrvInTrans(PriceSrvDTO[] priSrvDtos) throws BizException {
		// 1.新增/更新数据
		updatePriSrv(priSrvDtos);

		// 2.启用/停用
		activePriSrv(priSrvDtos);

		// 3.制定调价计划
		modifyPri(priSrvDtos);
	}

	/**
	 * 调价
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void modifyPri(PriceSrvDTO[] priSrvDtos) throws BizException {

		List<ModifyPriPlanItmDO> modifyPlanItmList = new ArrayList<>();
		for (PriceSrvDTO priceSrvDTO : priSrvDtos) {
			String srvCode = priceSrvDTO.getCode();
			PriSrvDO priSrvDO = this._priSrvDoMap.get(srvCode);
			if (this.isEquals(priceSrvDTO.getPri(), priSrvDO.getPri())) {
				continue;
			}

			ModifyPriPlanItmDO planItmDO = new ModifyPriPlanItmDO();
			planItmDO.setId_grp(Context.get().getGroupId());
			planItmDO.setId_org(Context.get().getOrgId());
			planItmDO.setId_srv(priSrvDO.getId_srv());
			planItmDO.setPrice_old(priSrvDO.getPri());
			planItmDO.setPrice(priceSrvDTO.getPri());

			modifyPlanItmList.add(planItmDO);
		}

		if (modifyPlanItmList.size() <= 0) {
			return;
		}

		ModifypriplanAggDO modifypriplanAggDO = new ModifypriplanAggDO();

		ModifyPriPlanDO planDo = new ModifyPriPlanDO();
		planDo.setId_grp(Context.get().getGroupId());
		planDo.setId_org(Context.get().getOrgId());
		planDo.setEu_modifyprimd(EuModifyPriMd.STANPRIADJUST);

		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = billcodeManage.getBillCode_RequiresNew(ModifyPriPlanDODesc.CLASS_FULLNAME, planDo);
		planDo.setCode(code);
		planDo.setMnecode(code);

		String exCode = IIHServiceParamUtils.getExternalCode();
		String name = String.format("%s_%s", exCode, code);
		planDo.setName(name);
		planDo.setPycode(AppUtils.getPyCode(name));
		planDo.setWbcode(AppUtils.getWbCode(name));

		planDo.setDes(exCode);

		planDo.setDt_creat(AppUtils.getServerDateTime());
		planDo.setDt_modifypriplan(AppUtils.getServerDateTime());
		planDo.setId_emp_plan(Context.get().getUserId());
		planDo.setFg_active(FBoolean.FALSE);
		planDo.setFg_complete(FBoolean.FALSE);
		modifypriplanAggDO.setParentDO(planDo);

		modifypriplanAggDO.setModifyPriPlanItmDO(modifyPlanItmList.toArray(new ModifyPriPlanItmDO[0]));

		IModifypriplanCudService planCudService = ServiceFinder.find(IModifypriplanCudService.class);
		modifypriplanAggDO = planCudService.insert(new ModifypriplanAggDO[] { modifypriplanAggDO })[0];

		IModifyPriPlanExtCudService planExtCudService = ServiceFinder.find(IModifyPriPlanExtCudService.class);
		planDo = planExtCudService.enable(new ModifyPriPlanDO[] { modifypriplanAggDO.getParentDO() })[0];
		this._planDo = planDo;
	}

	/**
	 * 启用/停用价格服务
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void activePriSrv(PriceSrvDTO[] priSrvDtos) throws BizException {

		ArrayList<PriSrvDO> enablePriSrvDoList = new ArrayList<>();
		ArrayList<PriSrvDO> disablePriSrvDoList = new ArrayList<>();
		for (PriceSrvDTO priceSrvDTO : priSrvDtos) {
			String srvCode = priceSrvDTO.getCode();
			PriSrvDO priSrvDO = this._priSrvDoMap.get(srvCode);
			if (this.isEquals(priceSrvDTO.getFg_active(), priSrvDO.getFg_active())) {
				continue;
			}

			if (FBoolean.TRUE.equals(priceSrvDTO.getFg_active())) {
				enablePriSrvDoList.add(priSrvDO);
			} else {
				disablePriSrvDoList.add(priSrvDO);
			}
		}

		IBasePriSrvExtCudService priSrvExtCudService = ServiceFinder.find(IBasePriSrvExtCudService.class);
		if (enablePriSrvDoList.size() > 0) {
			PriSrvDO[] result = priSrvExtCudService.enable(enablePriSrvDoList.toArray(new PriSrvDO[0]));
			this.addToPriSrvDoMap(result);
		}

		if (disablePriSrvDoList.size() > 0) {
			PriSrvDO[] result = priSrvExtCudService.disable(disablePriSrvDoList.toArray(new PriSrvDO[0]));
			this.addToPriSrvDoMap(result);
		}
	}

	/**
	 * 判定两个对象相同
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	private boolean isEquals(Object obj1, Object obj2) {
		return !this.isNotEquals(obj1, obj2);
	}

	/**
	 * 更新价格服务
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void updatePriSrv(PriceSrvDTO[] priSrvDtos) throws BizException {
		List<BaseprisrvAggDO> newPriSrvList = new ArrayList<>();
		List<PriSrvDO> savePriSrvList = new ArrayList<>();
		for (PriceSrvDTO priceSrvDTO : priSrvDtos) {
			String code = priceSrvDTO.getCode();
			if (this._priSrvDoMap.containsKey(code)) {
				PriSrvDO priSrvDO = this._priSrvDoMap.get(code);
				boolean isChanged = this.isChanged(priceSrvDTO, priSrvDO);
				if (!isChanged) {
					continue;
				}
				updatePriSrvDo(priSrvDO, priceSrvDTO);
				savePriSrvList.add(priSrvDO);
			} else {
				BaseprisrvAggDO baseprisrvAggDO = buildPriSrvDo(priceSrvDTO);
				newPriSrvList.add(baseprisrvAggDO);
			}
		}

		if (savePriSrvList.size() > 0) {
			IBaseprisrvMDOCudService baseprisrvMDOCudService = ServiceFinder.find(IBaseprisrvMDOCudService.class);
			PriSrvDO[] result = baseprisrvMDOCudService.update(savePriSrvList.toArray(new PriSrvDO[0]));

			this.addToPriSrvDoMap(result);
		}

		if (newPriSrvList.size() > 0) {
			IBaseprisrvCudService baseprisrvCudService = ServiceFinder.find(IBaseprisrvCudService.class);
			BaseprisrvAggDO[] result = baseprisrvCudService.insert(newPriSrvList.toArray(new BaseprisrvAggDO[0]));
			this.addToPriSrvDoMap(result);
		}

	}

	/**
	 * 添加价格服务到字典
	 * 
	 * @param result
	 */
	private void addToPriSrvDoMap(BaseprisrvAggDO[] result) {
		for (BaseprisrvAggDO baseprisrvAggDO : result) {
			PriSrvDO priSrvDO = baseprisrvAggDO.getParentDO();
			this._priSrvDoMap.put(priSrvDO.getCode(), priSrvDO);
		}
	}

	/**
	 * 添加价格服务到字典
	 * 
	 * @param result
	 */
	private void addToPriSrvDoMap(PriSrvDO[] result) {
		for (PriSrvDO priSrvDO : result) {
			this._priSrvDoMap.put(priSrvDO.getCode(), priSrvDO);
		}
	}

	/**
	 * 构建价格服务
	 * 
	 * @param priceSrvDTO
	 * @return
	 * @throws BizException
	 */
	private BaseprisrvAggDO buildPriSrvDo(PriceSrvDTO priceSrvDTO) throws BizException {
		BaseprisrvAggDO newData = new BaseprisrvAggDO();

		PriSrvDO priSrvDo = new PriSrvDO();
		newData.setParentDO(priSrvDo);

		priSrvDo.setId_grp(Context.get().getGroupId());
		priSrvDo.setId_org(Context.get().getOrgId());
		priSrvDo.setFg_active(FBoolean.FALSE);
		priSrvDo.setEu_blmd(MedSrvBlModeEnum.AUTOBL);
		priSrvDo.setDes(priceSrvDTO.getDes());

		SrvCateDO srvCateDO = this.getSrvCateByCode(priceSrvDTO.getCode_srvca());
		priSrvDo.setId_srvca(srvCateDO.getId_srvca());
		priSrvDo.setName_srvca(srvCateDO.getName());

		UdidocDO srvTpDo = this.getSrvTpByCode(priceSrvDTO.getSd_srvtp());
		priSrvDo.setId_srvtp(srvTpDo.getId_udidoc());
		priSrvDo.setSd_srvtp(srvTpDo.getCode());
		priSrvDo.setName_srvtp(srvTpDo.getName());

		MeasDocDO unitDo = this.getMeasdocByCode(priceSrvDTO.getCode_unit());
		priSrvDo.setId_unit_med(unitDo.getId_measdoc());
		priSrvDo.setName_unit_med(unitDo.getName());

		IncCaItmDO opIncCaItm = this.getOpIncCaItmByCode(priceSrvDTO.getCode_inc_op());
		priSrvDo.setId_incca_op(opIncCaItm.getId_inccaitm());
		priSrvDo.setName_incca_op(opIncCaItm.getName());

		IncCaItmDO ipIncCaItm = this.getIpIncCaItmByCode(priceSrvDTO.getCode_inc_ip());
		priSrvDo.setId_incca_ip(ipIncCaItm.getId_inccaitm());
		priSrvDo.setName_incca_ip(ipIncCaItm.getName());

		UdidocDO priTpDo = this.getPriTpByCode(priceSrvDTO.getSd_pritp());
		priSrvDo.setId_pritp(priTpDo.getId_udidoc());
		priSrvDo.setSd_pritp(priTpDo.getCode());
		priSrvDo.setName_pritp(priTpDo.getName());

		if (FBoolean.TRUE.equals(this._useAccountSystem) && FBoolean.FALSE.equals(this._shareAcountSystem)) {
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_op())) {
				AccountSubjectDO opAcc = this.getOpAccByCode(priceSrvDTO.getCode_acc_op());
				priSrvDo.setId_acc_op(opAcc.getId_accountca());
			}

			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_ip())) {
				AccountSubjectDO ipAcc = this.getIpAccByCode(priceSrvDTO.getCode_acc_ip());
				priSrvDo.setId_acc_ip(ipAcc.getId_accountca());
			}
		}

		if (FBoolean.TRUE.equals(this._useAccountSystem) && FBoolean.TRUE.equals(this._shareAcountSystem)) {
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_share())) {
				AccountSubjectDO shareAcc = this.getShareAccByCode(priceSrvDTO.getCode_acc_share());
				priSrvDo.setId_acc_share(shareAcc.getId_accountca());
			}
		}

		String code = priceSrvDTO.getCode();
		priSrvDo.setCode(code);
		priSrvDo.setMnecode(code);

		String name = priceSrvDTO.getName();
		priSrvDo.setName(name);
		priSrvDo.setPycode(AppUtils.getPyCode(name));
		priSrvDo.setWbcode(AppUtils.getWbCode(name));
		priSrvDo.setPri(priceSrvDTO.getPri());

		SrvPriDO srvPriDo = new SrvPriDO();
		srvPriDo.setStatus(DOStatus.NEW);
		newData.setSrvPriDO(new SrvPriDO[] { srvPriDo });

		srvPriDo.setId_grp(Context.get().getGroupId());
		srvPriDo.setId_org(Context.get().getOrgId());
		srvPriDo.setDt_b(AppUtils.getServerDateTime());
		srvPriDo.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		srvPriDo.setPrice(priceSrvDTO.getPri());

		String exCode = IIHServiceParamUtils.getExternalCode();
		srvPriDo.setDes(exCode);

		return newData;
	}

	/**
	 * 根据编码获取收费分类
	 * 
	 * @param priTpCode
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getPriTpByCode(String priTpCode) throws BizException {
		if (this._priTpMap.containsKey(priTpCode)) {
			return this._priTpMap.get(priTpCode);
		}
		String msg = String.format("根据编码【%s】获取收费分类失败。", priTpCode);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取服务类型
	 * 
	 * @param srvTpCode
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getSrvTpByCode(String srvTpCode) throws BizException {
		if (this._srvTpMap.containsKey(srvTpCode)) {
			return this._srvTpMap.get(srvTpCode);
		}
		String msg = String.format("根据编码【%s】获取服务类型失败。", srvTpCode);
		throw new BizException(msg);
	}

	/**
	 * 更新价格服务
	 * 
	 * @param priSrvDO
	 * @param priceSrvDTO
	 * @throws BizException
	 */
	private void updatePriSrvDo(PriSrvDO priSrvDO, PriceSrvDTO priceSrvDTO) throws BizException {
		priSrvDO.setStatus(DOStatus.UPDATED);
		priSrvDO.setName(priceSrvDTO.getName());
		priSrvDO.setDes(priceSrvDTO.getDes());

		UdidocDO srvTp = this.getSrvTpByCode(priceSrvDTO.getSd_srvtp());
		priSrvDO.setId_srvtp(srvTp.getId_udidoc());
		priSrvDO.setSd_srvtp(srvTp.getCode());

		SrvCateDO srvCateDO = this.getSrvCateByCode(priceSrvDTO.getCode_srvca());
		priSrvDO.setId_srvca(srvCateDO.getId_srvca());

		MeasDocDO measDocDO = this.getMeasdocByCode(priceSrvDTO.getCode_unit());
		priSrvDO.setId_unit_med(measDocDO.getId_measdoc());

		IncCaItmDO opIncCaItm = this.getOpIncCaItmByCode(priceSrvDTO.getCode_inc_op());
		priSrvDO.setId_incca_op(opIncCaItm.getId_inccaitm());

		IncCaItmDO ipIncCaItm = this.getIpIncCaItmByCode(priceSrvDTO.getCode_inc_ip());
		priSrvDO.setId_incca_ip(ipIncCaItm.getId_inccaitm());

		UdidocDO priTp = this.getPriTpByCode(priceSrvDTO.getSd_pritp());
		priSrvDO.setId_pritp(priTp.getId_udidoc());
		priSrvDO.setSd_pritp(priTp.getCode());

		if (FBoolean.TRUE.equals(this._useAccountSystem) && FBoolean.FALSE.equals(this._shareAcountSystem)) {
			priSrvDO.setId_acc_op(null);
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_op())) {
				AccountSubjectDO opAcc = this.getOpAccByCode(priceSrvDTO.getCode_acc_op());
				priSrvDO.setId_acc_op(opAcc.getId_accountca());
			}

			priSrvDO.setId_acc_ip(null);
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_ip())) {
				AccountSubjectDO ipAcc = this.getIpAccByCode(priceSrvDTO.getCode_acc_ip());
				priSrvDO.setId_acc_ip(ipAcc.getId_accountca());
			}
		}

		if (FBoolean.TRUE.equals(this._useAccountSystem) && FBoolean.TRUE.equals(this._shareAcountSystem)) {
			priSrvDO.setId_acc_share(null);
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_share())) {
				AccountSubjectDO shareAcc = this.getShareAccByCode(priceSrvDTO.getCode_acc_share());
				priSrvDO.setId_acc_share(shareAcc.getId_accountca());
			}
		}
	}

	/**
	 * 判定价格服务是否需要修改
	 * 
	 * @param priceSrvDTO
	 * @param priSrvDO
	 * @return
	 * @throws BizException
	 */
	private boolean isChanged(PriceSrvDTO priceSrvDTO, PriSrvDO priSrvDO) throws BizException {
		if (this.isNotEquals(priSrvDO.getName(), priceSrvDTO.getName())) {
			return true;
		}
		if (this.isNotEquals(priSrvDO.getSd_srvtp(), priceSrvDTO.getSd_srvtp())) {
			return true;
		}

		SrvCateDO srvCateDO = this.getSrvCateByCode(priceSrvDTO.getCode_srvca());
		if (this.isNotEquals(srvCateDO.getId_srvca(), priSrvDO.getId_srvca())) {
			return true;
		}

		MeasDocDO measDocDO = this.getMeasdocByCode(priceSrvDTO.getCode_unit());
		if (this.isNotEquals(measDocDO.getId_measdoc(), priSrvDO.getId_unit_med())) {
			return true;
		}

		IncCaItmDO opIncCaItm = this.getOpIncCaItmByCode(priceSrvDTO.getCode_inc_op());
		if (this.isNotEquals(opIncCaItm.getId_inccaitm(), priSrvDO.getId_incca_op())) {
			return true;
		}

		IncCaItmDO ipIncCaItm = this.getIpIncCaItmByCode(priceSrvDTO.getCode_inc_ip());
		if (this.isNotEquals(ipIncCaItm.getId_inccaitm(), priSrvDO.getId_incca_ip())) {
			return true;
		}

		if (this.isNotEquals(priSrvDO.getSd_pritp(), priceSrvDTO.getSd_pritp())) {
			return true;
		}

		if (this.isNotEquals(priSrvDO.getDes(), priceSrvDTO.getDes())) {
			return true;
		}

		if (FBoolean.TRUE.equals(this._useAccountSystem) && FBoolean.FALSE.equals(this._shareAcountSystem)) {
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_op())) {
				AccountSubjectDO opAcc = this.getOpAccByCode(priceSrvDTO.getCode_acc_op());
				if (this.isNotEquals(opAcc.getId_accountca(), priSrvDO.getId_acc_op())) {
					return true;
				}
			} else if (StringUtils.isNotBlank(priSrvDO.getId_acc_op())) {
				return true;
			}

			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_ip())) {
				AccountSubjectDO ipAcc = this.getIpAccByCode(priceSrvDTO.getCode_acc_ip());
				if (this.isNotEquals(ipAcc.getId_accountca(), priSrvDO.getId_acc_ip())) {
					return true;
				}
			} else if (StringUtils.isNotBlank(priSrvDO.getId_acc_ip())) {
				return true;
			}

		}

		if (FBoolean.TRUE.equals(this._useAccountSystem) && FBoolean.TRUE.equals(this._shareAcountSystem)) {
			if (StringUtils.isNotBlank(priceSrvDTO.getCode_acc_share())) {
				AccountSubjectDO shareAcc = this.getShareAccByCode(priceSrvDTO.getCode_acc_share());
				if (this.isNotEquals(shareAcc.getId_accountca(), priSrvDO.getId_acc_share())) {
					return true;
				}
			} else if (StringUtils.isNotBlank(priSrvDO.getId_acc_share())) {
				return true;
			}

		}

		return false;
	}

	/**
	 * 判定两个对象不相同
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	private boolean isNotEquals(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return false;
		}

		if (obj1 == null) {
			return isNotEquals(obj2, obj1);
		}

		return !obj1.equals(obj2);
	}

	/**
	 * 根据编码获取门诊核算体系
	 * 
	 * @param code 编码
	 * @return
	 * @throws BizException
	 */
	private AccountSubjectDO getOpAccByCode(String code) throws BizException {
		if (this._opAccMap.containsKey(code)) {
			return this._opAccMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取门诊核算体系失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取住院核算体系
	 * 
	 * @param code 编码
	 * @return
	 * @throws BizException
	 */
	private AccountSubjectDO getIpAccByCode(String code) throws BizException {
		if (this._ipAccMap.containsKey(code)) {
			return this._ipAccMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取住院核算体系失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取共用核算体系
	 * 
	 * @param code 编码
	 * @return
	 * @throws BizException
	 */
	private AccountSubjectDO getShareAccByCode(String code) throws BizException {
		if (this._shareAccMap.containsKey(code)) {
			return this._shareAccMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取共用核算体系失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取住院账单项
	 * 
	 * @param code 编码
	 * @return
	 * @throws BizException
	 */
	private IncCaItmDO getIpIncCaItmByCode(String code) throws BizException {
		if (this._ipIncMap.containsKey(code)) {
			return this._ipIncMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取住院账单项失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取门诊账单项
	 * 
	 * @param code 编码
	 * @return
	 * @throws BizException
	 */
	private IncCaItmDO getOpIncCaItmByCode(String code) throws BizException {
		if (this._opIncMap.containsKey(code)) {
			return this._opIncMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取门诊账单项失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取计量单位
	 * 
	 * @param code_unit 编码
	 * @return
	 * @throws BizException
	 */
	private MeasDocDO getMeasdocByCode(String unitCode) throws BizException {
		if (this._unitMap.containsKey(unitCode)) {
			return this._unitMap.get(unitCode);
		}
		String msg = String.format("根据编码【%s】获取计量单位失败。", unitCode);
		throw new BizException(msg);
	}

	/**
	 * 根据编码获取服务分类
	 * 
	 * @param srvCaCode 编码
	 * @return
	 * @throws BizException
	 */
	private SrvCateDO getSrvCateByCode(String srvCaCode) throws BizException {
		if (this._srvCaMap.containsKey(srvCaCode)) {
			return this._srvCaMap.get(srvCaCode);
		}
		String msg = String.format("根据编码【%s】获取服务分类失败。", srvCaCode);
		throw new BizException(msg);
	}

	/**
	 * 初始化数据字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void initDataMap(PriceSrvDTO[] priSrvDtos) throws BizException {

		this.initPriSrvDoMap(priSrvDtos);

		this.initSrvTpMap(priSrvDtos);

		this.initSrvCaMap(priSrvDtos);

		this.initUnitMap(priSrvDtos);

		this.initOpIncMap(priSrvDtos);

		this.initIpIncMap(priSrvDtos);

		this.initPriTpMap(priSrvDtos);

		this.initOpAccMap(priSrvDtos);

		this.initIpAccMap(priSrvDtos);

		this.initShareAccMap(priSrvDtos);
	}

	/**
	 * 初始化服务类型字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void initSrvTpMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] srvTpCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Sd_srvtp", String.class);
		if (ArrayUtils.isEmpty(srvTpCodes)) {
			return;
		}
		UdidocDO[] srvTpDos = UdidocUtils.getUdidocByCodes(IBdSrvDictCodeTypeConst.SD_SRVTP, srvTpCodes);
		if (ArrayUtils.isEmpty(srvTpDos)) {
			return;
		}
		for (UdidocDO srvTpDo : srvTpDos) {
			this._srvTpMap.put(srvTpDo.getCode(), srvTpDo);
		}
	}

	/**
	 * 初始化服务分类字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initSrvCaMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] srvCaCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_srvca", String.class);
		if (ArrayUtils.isEmpty(srvCaCodes)) {
			return;
		}
		List<SrvCateDO> srvCaList = (List<SrvCateDO>) _daFacade.findByAttrValStrings(SrvCateDO.class, SrvCateDO.CODE,
				srvCaCodes, null);
		if (srvCaList == null || srvCaList.size() <= 0) {
			return;
		}
		for (SrvCateDO srvCateDO : srvCaList) {
			this._srvCaMap.put(srvCateDO.getCode(), srvCateDO);
		}
	}

	/**
	 * 初始化单位字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initUnitMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] unitCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_unit", String.class);
		if (ArrayUtils.isEmpty(unitCodes)) {
			return;
		}
		List<MeasDocDO> measDocDOs = (List<MeasDocDO>) _daFacade.findByAttrValStrings(MeasDocDO.class, MeasDocDO.CODE,
				unitCodes, null);
		if (measDocDOs == null || measDocDOs.size() <= 0) {
			return;
		}
		for (MeasDocDO measDocDO : measDocDOs) {
			this._unitMap.put(measDocDO.getCode(), measDocDO);
		}
	}

	/**
	 * 初始化门诊账单项字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initOpIncMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] opIncCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_inc_op", String.class);
		if (ArrayUtils.isEmpty(opIncCodes)) {
			return;
		}
		String wherePart = String.format("sd_incca = '%s' and %s", IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE,
				SqlUtils.getInSqlByIds(IncCaItmDO.CODE, opIncCodes));
		List<IncCaItmDO> opIncList = (List<IncCaItmDO>) _daFacade.findByCond(IncCaItmDO.class, wherePart);
		if (opIncList == null || opIncList.size() <= 0) {
			return;
		}
		for (IncCaItmDO incCaItmDO : opIncList) {
			this._opIncMap.put(incCaItmDO.getCode(), incCaItmDO);
		}
	}

	/**
	 * 初始化住院账单项字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initIpIncMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] ipIncCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_inc_ip", String.class);
		if (ArrayUtils.isEmpty(ipIncCodes)) {
			return;
		}
		String wherePart = String.format("sd_incca = '%s' and %s", IBdInccaCodeConst.CODE_INHOS_INVOICE,
				SqlUtils.getInSqlByIds(IncCaItmDO.CODE, ipIncCodes));
		List<IncCaItmDO> ipIncList = (List<IncCaItmDO>) _daFacade.findByCond(IncCaItmDO.class, wherePart);
		if (ipIncList == null || ipIncList.size() <= 0) {
			return;
		}
		for (IncCaItmDO incCaItmDO : ipIncList) {
			this._ipIncMap.put(incCaItmDO.getCode(), incCaItmDO);
		}
	}

	/**
	 * 初始化收费分类字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void initPriTpMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] priTpCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Sd_pritp", String.class);
		if (ArrayUtils.isEmpty(priTpCodes)) {
			return;
		}
		UdidocDO[] priTpDos = UdidocUtils.getUdidocByCodes(IBdPpCodeTypeConst.SD_PRITP, priTpCodes);
		if (ArrayUtils.isEmpty(priTpDos)) {
			return;
		}
		for (UdidocDO priTpDo : priTpDos) {
			this._priTpMap.put(priTpDo.getCode(), priTpDo);
		}
	}

	/**
	 * 初始化门诊核算体系字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initOpAccMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		if (FBoolean.FALSE.equals(this._useAccountSystem) || FBoolean.TRUE.equals(this._shareAcountSystem)) {
			return;
		}

		String[] opAccCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_acc_op", String.class);
		if (ArrayUtils.isEmpty(opAccCodes)) {
			return;
		}

		String wherePart = String.format("Id_account = '%s' and %s", IBdPpDictCodeConst.ID_ACCOUNT_MZ,
				SqlUtils.getInSqlByIds(AccountSubjectDO.CODE, opAccCodes));
		List<AccountSubjectDO> opAccDos = (List<AccountSubjectDO>) _daFacade.findByCond(AccountSubjectDO.class,
				wherePart);
		if (opAccDos == null || opAccDos.size() <= 0) {
			return;

		}
		for (AccountSubjectDO opAccDo : opAccDos) {
			this._opAccMap.put(opAccDo.getCode(), opAccDo);
		}
	}

	/**
	 * 初始化住院核算体系字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initIpAccMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		if (FBoolean.FALSE.equals(this._useAccountSystem) || FBoolean.TRUE.equals(this._shareAcountSystem)) {
			return;
		}

		String[] ipAccCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_acc_ip", String.class);
		if (ArrayUtils.isEmpty(ipAccCodes)) {
			return;
		}
		String wherePart = String.format("Id_account = '%s' and %s", IBdPpDictCodeConst.ID_ACCOUNT_ZY,
				SqlUtils.getInSqlByIds(AccountSubjectDO.CODE, ipAccCodes));
		List<AccountSubjectDO> ipAccDos = (List<AccountSubjectDO>) _daFacade.findByCond(AccountSubjectDO.class,
				wherePart);
		if (ipAccDos == null || ipAccDos.size() <= 0) {
			return;
		}
		for (AccountSubjectDO ipAccDo : ipAccDos) {
			this._ipAccMap.put(ipAccDo.getCode(), ipAccDo);
		}
	}

	/**
	 * 初始化共享核算体系字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initShareAccMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		if (FBoolean.FALSE.equals(this._useAccountSystem) || FBoolean.FALSE.equals(this._shareAcountSystem)) {
			return;
		}

		String[] shareAccCodes = DoUtils.getAttrValArrNotNull(priSrvDtos, "Code_acc_share", String.class);
		if (ArrayUtils.isEmpty(shareAccCodes)) {
			return;
		}

		String wherePart = String.format("Id_account = '%s' and %s", IBdPpDictCodeConst.ID_ACCOUNT_GY,
				SqlUtils.getInSqlByIds(AccountSubjectDO.CODE, shareAccCodes));
		List<AccountSubjectDO> shareAccDos = (List<AccountSubjectDO>) _daFacade.findByCond(AccountSubjectDO.class,
				wherePart);
		if (shareAccDos == null || shareAccDos.size() <= 0) {
			return;

		}
		for (AccountSubjectDO opAccDo : shareAccDos) {
			this._shareAccMap.put(opAccDo.getCode(), opAccDo);
		}
	}

	/**
	 * 初始化价格服务DO字典
	 * 
	 * @param priSrvDtos
	 * @throws BizException
	 */
	private void initPriSrvDoMap(PriceSrvDTO[] priSrvDtos) throws BizException {
		String[] codes = DoUtils.getAttrValArr(priSrvDtos, "Code", String.class);
		IBaseprisrvMDORService baseprisrvMDORService = ServiceFinder.find(IBaseprisrvMDORService.class);
		PriSrvDO[] priSrvDoList = baseprisrvMDORService.find2(SqlUtils.getInSqlByIds("bd_srv.code", codes), null, "",
				FBoolean.FALSE);

		// 放入字典
		if (ArrayUtils.isEmpty(priSrvDoList)) {
			return;
		}
		for (PriSrvDO priSrvDO : priSrvDoList) {
			this._priSrvDoMap.put(priSrvDO.getCode(), priSrvDO);
		}
	}
}
