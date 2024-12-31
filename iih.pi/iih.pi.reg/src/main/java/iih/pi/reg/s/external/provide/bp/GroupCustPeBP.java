package iih.pi.reg.s.external.provide.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.cust.d.CustDO;
import iih.bd.pp.cust.i.ICustDOCudService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.picustpedto.d.PiCustPeDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.patcust.d.PatCustRelationEnum;
import iih.pi.reg.patcust.d.PiPatCustDO;
import iih.pi.reg.patcust.i.IPatcustCudService;
import iih.pi.reg.s.bp.util.PiGetDefaultDataUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 新增团检客户信息
 * 
 * @author houll 2018/11/27
 *
 */
public class GroupCustPeBP {
	public CustDO[] exec(PiCustPeDTO[] custDTO) throws BizException {
		if (custDTO == null || custDTO.length <= 0) {
			throw new BizException("入参为空");
		}

		CustDO[] custDo = new CustDO[custDTO.length];
		for (int i = 0; i <= custDTO.length - 1; i++) {
			CustDO cust = new CustDO();
			custDo[i] = cust;
			if (custDTO[i].getCust_code() == null) {
				throw new BizException("入参code为空");
			}
			if (custDTO[i].getCust_name() == null) {
				throw new BizException("入参name为空");
			}
			custDo[i].setCode(custDTO[i].getCust_code());
			custDo[i].setName(custDTO[i].getCust_name());
			custDo[i].setId_grp(Context.get().getGroupId());
			custDo[i].setId_org(Context.get().getOrgId());
			// 五笔码
			custDo[i].setWbcode(AppUtils.getWbCode(custDTO[i].getCust_name()));
			// 助记码
			custDo[i].setPycode(AppUtils.getPyCode(custDTO[i].getCust_name()));
			// 拼音码
			custDo[i].setMnecode(AppUtils.getPyCode(custDTO[i].getCust_code()));
			// 客户分类
			String custca = new PiParams().PIPAT0015();
			if (!StringUtil.isEmpty(custca)) {
				custDo[i].setId_custca(custca);
			}
			custDo[i].setStatus(DOStatus.NEW);

		}
		// 新增团体对应的患者
		PatiAggDO[] aggDo = this.addPiPat(custDo);

		ICustDOCudService service = ServiceFinder.find(ICustDOCudService.class);
		CustDO[] custDos = service.save(custDo);
		// 新增团体患者关系
		this.addPiPatCusts(aggDo, custDos);

		return custDo;
	}

	/**
	 * 新增团体患者关系
	 * 
	 * @param patDos
	 * @param custDos
	 * @throws BizException
	 */
	private void addPiPatCusts(PatiAggDO[] aggDo, CustDO[] custDos) throws BizException {
		PiPatCustDO[] patPatCustDos = new PiPatCustDO[custDos.length];
		for (int i = 0; i < patPatCustDos.length; i++) {
			PiPatCustDO patCustDO = new PiPatCustDO();
			// 组织
			patCustDO.setId_org(Context.get().getOrgId());
			// 集团
			patCustDO.setId_grp(Context.get().getGroupId());
			// 客户id
			patCustDO.setId_cust(custDos[i].getId_cust());
			// 患者id
			patCustDO.setId_pat(aggDo[i].getParentDO().getId_pat());
			// 关系类型
			patCustDO.setEu_relation(PatCustRelationEnum.RELATION_ONE);
			patCustDO.setStatus(DOStatus.NEW);
			patPatCustDos[i] = patCustDO;
			
		}
		IPatcustCudService service = ServiceFinder.find(IPatcustCudService.class);
		service.save(patPatCustDos);
	}

	/**
	 * 新增团体对应的患者
	 * 
	 * @param custDo
	 * @throws BizException
	 */
	private PatiAggDO[] addPiPat(CustDO[] custDo) throws BizException {
		// 查重
		List<String> list = this.getSamePatByOther(custDo);
		if (list != null && list.size() > 0) {
			throw new BizException("团检名称重复！");
		}
		// 患者信息赋值
		PatiAggDO[] aggDo = this.setPatInfo(custDo);
		IPatiCudService patCService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO[] result = patCService.save(aggDo);
		return result;
	}

	/**
	 * 患者信息赋值
	 * 
	 * @param custDo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] setPatInfo(CustDO[] custDos) throws BizException {
		PatiAggDO[] aggDo = new PatiAggDO[custDos.length];
		for (int i = 0; i < aggDo.length ; i++) {
			PatiAggDO PatiAggDO = new PatiAggDO();
			PatDO pat = new PatDO();
			pat.setStatus(DOStatus.NEW);
			// 组织
			pat.setId_org(Context.get().getOrgId());
			// 集团
			pat.setId_grp(Context.get().getGroupId());
			// 编码
			IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
			String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
			pat.setCode(code);
			// 助记码
			pat.setMnecode(code);
			// 名称
			pat.setName(custDos[i].getName());
			
			pat.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			pat.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			pat.setId_code("1");
			// 是否实名认证
			pat.setFg_realname(FBoolean.FALSE);
			// 出生日期 取 注册时间
			pat.setDt_birth(AppUtils.getServerDateTime().getDate());
			// 默认价格分类 患者分类
			PiPatCaDO caDo = PiGetDefaultDataUtil.getDefPatCa();
			if (caDo != null) {
				pat.setId_paticate(caDo.getId_patca());
				pat.setId_patpritp(caDo.getId_patpritp());
				pat.setId_patcrettp(caDo.getId_patcrettp());
			}
			// 建档来源
			pat.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_OTHER);
			pat.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_OTHER);
			// 默认中国
			CountryZoneDO china = PiGetDefaultDataUtil.getChina();
			if (china != null) {
				pat.setId_country(china.getId_countryzone());
				pat.setSd_country(china.getCode());
			}
			// 失效标志
			pat.setFg_invd(FBoolean.FALSE);
			aggDo[i] = PatiAggDO;
			aggDo[i].setParentDO(pat);
		}
		return aggDo;
	}

	/**
	 * 查询患者编码是否重复
	 * 
	 * @param custDos
	 * @return
	 * @throws BizException
	 */
	private List<String> getSamePatByOther(CustDO[] custDos) throws BizException {
		List<String> resultList = new ArrayList<String>();
		for (CustDO custDO : custDos) {
			StringBuffer sql = new StringBuffer();
			sql.append("select code from pi_pat where fg_invd = 'N' ");
			sql.append("   and name =? ");
			SqlParam param = new SqlParam();
			param.addParam(custDO.getName());
			String orgSql = EnvContextUtil.processEnvContext(null, new PatDO(), false);
			sql.append(" and " + orgSql);
			DAFacade daf = new DAFacade();
			String patCode = (String) daf.execQuery(sql.toString(), param, new ColumnHandler());
			if (custDO.getCode().equals(patCode)) {
				resultList.add(patCode);
			}
		}
		return null;
	}
}
