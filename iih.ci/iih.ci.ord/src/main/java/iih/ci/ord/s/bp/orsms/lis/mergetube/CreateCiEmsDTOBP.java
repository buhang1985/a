package iih.ci.ord.s.bp.orsms.lis.mergetube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.dto.ems.EmsCreateParamDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.tl.JudgeOrderTemplateApplicationTable;
import iih.ci.ord.s.bp.ems.CiEmsDefaultValueSetBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通过服务id_srv,创建CiEmsDTO,用于生成医嘱
 * 
 * @author zhangwq
 *
 */
public class CreateCiEmsDTOBP {
	/**
	 * 上下文信息
	 */
	private CiEnContextDTO ctx;
	private DiagOutlineInfo diagOutlineInfo;
	// 是否有申请表
	private JudgeOrderTemplateApplicationTable apptable;

	private CreateCiEmsDTOBP() {
	};

	public CreateCiEmsDTOBP(CiEnContextDTO ctx) {
		this.ctx = ctx;
		apptable = new JudgeOrderTemplateApplicationTable();
	}

	public List<CiEmsDTO> exec(EmsCreateParamDTO[] params) throws BizException {
		if (params == null || params.length == 0) {
			return null;
		}
		Map<String, EmsCreateParamDTO> tempSampPriItmMap = new HashMap<String, EmsCreateParamDTO>();
		for (EmsCreateParamDTO itm : params) {
			if (!tempSampPriItmMap.containsKey(itm.getId_srv())) {
				tempSampPriItmMap.put(itm.getId_srv(), itm);
			}
		}
		List<CiEmsDTO> list = new ArrayList<CiEmsDTO>();
		MedSrvDO[] medSrvDOs = this.getMedSrvDOs(tempSampPriItmMap.keySet().toArray(new String[0]));
		if (medSrvDOs == null || medSrvDOs.length == 0 || medSrvDOs.length != tempSampPriItmMap.keySet().size()) {
			OrdBizLogger.info(ctx, "检验合管生成采集费和容器费时，查询的服务为空,请检查关联的采集费和容器费是否启用");
		}
		// 如果 medSrvDOs的数量和sampPriItms的数量不一致，需要有提示
		for (MedSrvDO medSrvDO : medSrvDOs) {
			if (!tempSampPriItmMap.containsKey(medSrvDO.getId_srv())) {
				continue;
			}
			EmsCreateParamDTO param = tempSampPriItmMap.get(medSrvDO.getId_srv());
			CiEmsDTO ciEmsDTO = createCiEmsDTO(medSrvDO, param);
			list.add(ciEmsDTO);
		}
		if (list.size() > 0) {
			apptable.JudgeOrederTemplateAppTabel(list.toArray(new CiEmsDTO[0]), this.ctx);
		}
		return list;
	}

	/**
	 * 根据服务关联策略生成CiEmsDTO
	 * 
	 * @param feeSrvdo
	 * @param medSrv
	 * @param orderdo
	 * @return
	 * @throws BizException
	 */
	public CiEmsDTO exec(UsageRelFeeSrvDO feeSrvdo, MedSrvDO medSrvDO, CiOrderDO orderdo) throws BizException {
		CiEmsDTO ciEmsDTO = createCiEmsDTO(medSrvDO, feeSrvdo, orderdo);
		apptable.JudgeOrederTemplateAppTabel(new CiEmsDTO[] { ciEmsDTO }, this.ctx);
		return ciEmsDTO;
	}

	private CiEmsDTO createCiEmsDTO(MedSrvDO medSrvDO, UsageRelFeeSrvDO feeSrvdo, CiOrderDO orderdo)
			throws BizException {
		CiEmsDTO ciEmsDto = createCiEmsDTO(medSrvDO);
		ciEmsDto.setId_freq(orderdo.getId_freq());// 频次id
		ciEmsDto.setId_route(orderdo.getId_route());// 用法id
		ciEmsDto.setId_routedes(orderdo.getId_routedes());// 用法要求
		ciEmsDto.setId_boil(orderdo.getId_boil());// 设置煎法id
		ciEmsDto.setId_boildes(orderdo.getId_boildes());// 煎法要求id
		ciEmsDto.setName_freq(orderdo.getFreq_name());// 医嘱频次名称
		ciEmsDto.setFreqct(orderdo.getFreqct()); // 频次周期下次数
		ciEmsDto.setSd_frequnitct(orderdo.getSd_frequnitct()); // 频次周期类型编码
		ciEmsDto.setFrequnitct(orderdo.getFrequnitct());
		ciEmsDto.setName_route(orderdo.getRoute_name());// 用法名称
		ciEmsDto.setId_unit_med(feeSrvdo.getId_unit());// 医学单位
		ciEmsDto.setQuan_medu(feeSrvdo.getQuan_medu());
		ciEmsDto.setDt_begin(orderdo.getDt_effe());// 开始日期
		ciEmsDto.setId_dep_mp(orderdo.getId_dep_mp());
		// 明细项目
		FArrayList emssrvlist = new FArrayList();
		emssrvlist.add(createCiEmsSrvDTO(feeSrvdo, ciEmsDto, medSrvDO));
		ciEmsDto.setEmssrvs(emssrvlist);
		return ciEmsDto;
	}

	private CiEmsDTO createCiEmsDTO(MedSrvDO medSrvDO, EmsCreateParamDTO param) throws BizException {
		CiEmsDTO ciEmsDto = createCiEmsDTO(medSrvDO);
		ciEmsDto.setQuan_medu(param.getQuan_med());
		// 明细项目
		FArrayList emssrvlist = new FArrayList();
		emssrvlist.add(createCiEmsSrvDTO(param, ciEmsDto, medSrvDO));
		ciEmsDto.setEmssrvs(emssrvlist);
		return ciEmsDto;
	}

	public CiEmsDTO createCiEmsDTO(MedSrvDO medSrvDO) throws BizException {
		GetTotalTimesBP getTotalTimesBP = new GetTotalTimesBP();
		CiEmsDTO ciEmsDto = new CiEmsDTO();
		ciEmsDto.setStatus(DOStatus.NEW);
		ciEmsDto.setId_srv(medSrvDO.getId_srv());
		ciEmsDto.setId_pat(this.ctx.getId_pat());// 患者
		ciEmsDto.setId_en(this.ctx.getId_en());// 就诊
		ciEmsDto.setId_entp(this.ctx.getId_entp());// 就诊类型
		ciEmsDto.setCode_entp(this.ctx.getCode_entp());// 就诊类型编码
		ciEmsDto.setId_srvtp(medSrvDO.getId_srvtp());// 医嘱类型
		ciEmsDto.setSd_srvtp(medSrvDO.getSd_srvtp());// 医嘱类型编码
		ciEmsDto.setId_wg_or(this.ctx.getId_wg_or());
		ciEmsDto.setId_freq(medSrvDO.getId_freq());// 频次id
		ciEmsDto.setId_route(medSrvDO.getId_route());// 用法id
		ciEmsDto.setId_routedes(medSrvDO.getId_routedes());// 用法要求
		ciEmsDto.setId_boil(medSrvDO.getId_boil());// 设置煎法id
		ciEmsDto.setId_boildes(medSrvDO.getId_boildes());// 煎法要求id
		ciEmsDto.setDays_or(1);// 医嘱天数
		// 慢病标识
		if (ICiDoctorStationTypeConst.Type_Op_MbDoctor_Station.equals(this.ctx.getStationType())) {
			ciEmsDto.setId_excessive_reason(ICiDictCodeConst.ID_EXCESSIVE_REASON_CHRONIC);
			ciEmsDto.setSd_excessive_reason(ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC);
		}
		ciEmsDto.setFg_long(medSrvDO.getFg_long()); // 常临标识
													// 住院根据频次中定义的类型设置常临标识，门诊的都为false
		ciEmsDto.setName_freq(medSrvDO.getFreq_name());// 医嘱频次名称
		ciEmsDto.setFreqct(medSrvDO.getFreqct()); // 频次周期下次数
		ciEmsDto.setSd_frequnitct(medSrvDO.getSd_frequnitct()); // 频次周期类型编码
		ciEmsDto.setFrequnitct(medSrvDO.getFrequnitct());
		ciEmsDto.setName_route(medSrvDO.getRoute_name());// 用法名称
		ciEmsDto.setId_unit_med(medSrvDO.getId_unit_med());// 医学单位
		ciEmsDto.setName_unit_med(medSrvDO.getMed_name());// 医学单位名称
		ciEmsDto.setQuan_medu(medSrvDO.getQuan_med());

		ciEmsDto.setId_srvca(medSrvDO.getId_srvca());// 医嘱基本分类
		ciEmsDto.setInnercode_srvca(medSrvDO.getSrvca_innercode());// 服务分类内码
		ciEmsDto.setId_grp(this.ctx.getId_grp());// 所属集团
		ciEmsDto.setId_org(this.ctx.getId_org());// 所属组织
		ciEmsDto.setEmsappmode(this.ctx.getEmsappmode());// 医疗单应用场景
		// 总量开单方式，多频次，多剂量
		ciEmsDto.setSd_totalopenmode(medSrvDO.getSd_totalopenmode());
		ciEmsDto.setIsmulexec(medSrvDO.getIsmulexec());
		ciEmsDto.setIsmuldose(medSrvDO.getIsmuldose());
		ciEmsDto.setId_dept_en(this.ctx.getId_dep_en());// 就诊科室
		ciEmsDto.setId_dept_ns(this.ctx.getId_dep_ns());// 护理单元
		ciEmsDto.setFg_set(medSrvDO.getFg_set());// 是否是套
		ciEmsDto.setDes_or(medSrvDO.getDes());// 嘱托
		ciEmsDto.setFg_pres_outp(FBoolean.FALSE);// 出院带药标识

		SrvMatchEmsRstDTO emsmatch = getFuncClassStr(this.ctx, medSrvDO);
		if (emsmatch == null) {
			ciEmsDto.setEmstype(EmsType.COMMON);
			ciEmsDto.setFg_quickwflow(FBoolean.FALSE);
		} else {
			ciEmsDto.setFuncclassstr(emsmatch.getFuncclassstr());// 医疗单URL
			ciEmsDto.setId_srvof(emsmatch.getId_ems());// 医疗单
			ciEmsDto.setName_ems(emsmatch.getName_show());// 医疗单名称
			ciEmsDto.setFg_quickwflow(emsmatch.getFg_quickwflow());
		}
		ciEmsDto.setApplyno(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));// 申请单号

		ciEmsDto.setFg_boil(FBoolean.FALSE);// 代煎标识

		ciEmsDto.setOrders(null);// 医嘱付数
		ciEmsDto.setOrders_boil(null);// 代煎付数
		ciEmsDto.setCode(medSrvDO.getCode());// 编码
		ciEmsDto.setName(medSrvDO.getName());// 医嘱名称
		ciEmsDto.setName(medSrvDO.getName());
		ciEmsDto.setId_emp_phy(this.ctx.getId_emp_or());// 开立医生
		ciEmsDto.setId_dep_phy(this.ctx.getId_dep_or());// 开立科室
		ciEmsDto.setId_wg_or(this.ctx.getId_wg_or());// 医疗组
		ciEmsDto.setDt_begin(CiOrdAppUtils.getServerDateTime());// 开始日期
		if (!CiOrdUtils.isEmpty(ciEmsDto.getDays_or())) {
			ciEmsDto.setDt_end(new FDateTime(ciEmsDto.getDt_begin().getBeginDate().getDateAfter(ciEmsDto.getDays_or()),
					ciEmsDto.getDt_begin().getUFTime()));// 结束日期
		}
		ciEmsDto.setFg_bb(this.ctx.getFg_bb());// 婴儿标识
		ciEmsDto.setNo_bb(this.ctx.getNo_bb());// 婴儿序号
		Integer times = getTotalTimesBP.getTotalTimes(ciEmsDto.getDt_begin(),ciEmsDto.getId_freq(), ciEmsDto.getDays_or());
		ciEmsDto.setTimes_cur(times);// 总次数
		ciEmsDto.setFg_mp_in(FBoolean.TRUE); // 在院执行状态
		CiEmsDefaultValueSetBP defaultSetbp = new CiEmsDefaultValueSetBP();
		defaultSetbp.exec(ciEmsDto);// 设置在院执行状态
		if (ciEmsDto.getFg_mp_in().booleanValue()) { // 在院执行时
			ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_cur());// 如果是在院执行，助手中的构造的医嘱等于总次数
		}
		ciEmsDto.setEu_orsrcmdtp(OrSourceFromEnum.IIHORRELAUTOGEN); // 数据来源类型
		ciEmsDto.setId_orsrc_main(ciEmsDto.getId_srv());// 数据来源id
		// 存在保外诊断时，医保就诊状态调整为不需要判断医保状态（非医保状态）
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(this.ctx.getEu_hpbeyond())) {
			ciEmsDto.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
		}

		ciEmsDto.setBhpjudgerst(this.ctx.getBhpjudgerst()); // 基本医保判断结果数据信息
		ciEmsDto.setDes_bhpjudgerst(this.ctx.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述
		// 诊断赋值
		DiagOutlineInfo diagOutlineInfo = this.getDiagInfo();
		if (diagOutlineInfo != null) {
			ciEmsDto.setId_didef(diagOutlineInfo.getId_didef());// 主诊断的主项目id
			ciEmsDto.setName_didef(diagOutlineInfo.getName_diag());// 主诊断名称
		}
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(this.ctx, medSrvDO.getId_srv(), "",ciEmsDto.getId_route(),ciEmsDto.getId_dep_mp(),ciEmsDto.getFg_long(),ciEmsDto.getFg_pres_outp(),ciEmsDto.getDt_begin());
		if (null != wf) {
			ciEmsDto.setId_dep_mp(wf.getFirstid_mp_dept());
			ciEmsDto.setName_dep_mp(wf.getFirstname_mp_dept());
		}
		return ciEmsDto;
	}

	private CiEmsSrvDTO createCiEmsSrvDTO(UsageRelFeeSrvDO feeSrvdo, CiEmsDTO ciEmsDTO, MedSrvDO medSrvDO)
			throws BizException {
		CiEmsSrvDTO srvdto = createCiEmsSrvDTO(ciEmsDTO, medSrvDO);
		srvdto.setQuan_med(feeSrvdo.getQuan_medu());// 医学单位数值（剂量）
		srvdto.setId_unit_med(feeSrvdo.getId_unit());// 医学单位(剂量单位)
		return srvdto;
	}

	private CiEmsSrvDTO createCiEmsSrvDTO(EmsCreateParamDTO param, CiEmsDTO ciEmsDTO, MedSrvDO medSrvDO)
			throws BizException {
		CiEmsSrvDTO srvdto = createCiEmsSrvDTO(ciEmsDTO, medSrvDO);
		srvdto.setQuan_med(param.getQuan_med());// 医学单位数值（剂量）
		srvdto.setId_unit_med(param.getId_unit_med());// 医学单位(剂量单位)
		return srvdto;
	}

	private CiEmsSrvDTO createCiEmsSrvDTO(CiEmsDTO ciEmsDTO, MedSrvDO medSrvDO) throws BizException {
		CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
		srvdto.setId_hp(this.ctx.getId_hp());
		srvdto.setStatus(DOStatus.NEW);
		srvdto.setId_dep_srv(this.ctx.getId_dep_or());// 开立科室
		srvdto.setId_ward_srv(this.ctx.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		srvdto.setId_emp_srv(this.ctx.getId_emp_or());// 开立人员
		srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		srvdto.setId_hp(this.ctx.getId_hp());// 主医保计划
		// 应该根据BdSampPriItmDO的类型判断
		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.SPECIMENRELFEE);// 医疗单项目数据来源方式
		// 频次
		srvdto.setId_freq(ciEmsDTO.getId_freq());
		// 设置用法id
		srvdto.setId_route(ciEmsDTO.getId_route());
		// 用法要求，设置用法要求id、名称
		srvdto.setId_routedes(ciEmsDTO.getId_routedes());
		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			throw new BizException("频次不能为空！");
		}
		srvdto.setId_freq(ciEmsDTO.getId_freq());
		srvdto.setName_freq(ciEmsDTO.getName_freq());// 医嘱频次名称
		srvdto.setFreqct(ciEmsDTO.getFreqct()); // 频次周期下次数
		srvdto.setSd_frequnitct(ciEmsDTO.getSd_frequnitct()); // 频次周期编码
		srvdto.setFrequnitct(ciEmsDTO.getFreqct());// TODO 频次周期数，使用混淆
		srvdto.setId_srv(ciEmsDTO.getId_srv());// 医疗服务
		srvdto.setId_srvtp(ciEmsDTO.getId_srvtp());// 服务类型
		srvdto.setSd_srvtp(ciEmsDTO.getSd_srvtp());// 服务类型编码
		srvdto.setCode_srv(ciEmsDTO.getCode());// 医疗服务编码
		srvdto.setName_srv(ciEmsDTO.getName());// 医疗服务名称
		srvdto.setId_srvca(ciEmsDTO.getId_srvca());// 服务项目基本分类
		//应该是临床的
		srvdto.setFg_or(FBoolean.TRUE);
		//srvdto.setFg_or(medSrvDO.getFg_or());
		srvdto.setFg_mm(medSrvDO.getFg_mm());// 物品标识
		srvdto.setFg_set(medSrvDO.getFg_set());// 服务套标识 套内项目全设置为False TODO
		srvdto.setFg_bl(medSrvDO.getFg_bl());// 费用标识
		srvdto.setEu_blmd(medSrvDO.getEu_blmd());// 划价方式
		srvdto.setFg_selfsrv(medSrvDO.getFg_ctm());// 自定义服务标识
		srvdto.setId_primd(medSrvDO.getId_primd());// 定价模式
		srvdto.setInnercode_srvca(medSrvDO.getSrvca_code());// 服务分类内码
		srvdto.setId_dep(ciEmsDTO.getId_dep_mp());
		// 医保就诊，并且都是保内诊断时为医保就诊，否则为自费（保外）
		if (this.ctx.getId_hp() != null && HpBeyondEnum.HPDIAG.equals(this.ctx.getEu_hpbeyond())) {
			srvdto.setFg_selfpay(FBoolean.FALSE);// 保内，非自费
		} else {
			srvdto.setFg_selfpay(FBoolean.TRUE);// 保外 、自费
		}
		// 计算非药品服务总量
		srvdto.setQuan_cur(
				ciEmsDTO.getQuan_medu() == null ? new FDouble(0) : ciEmsDTO.getQuan_medu().multiply(ciEmsDTO.getTimes_cur()));
		srvdto.setQuan_total_medu(srvdto.getQuan_cur());
		MedSrvPriceDO priceDO = calculatePrice(medSrvDO, this.ctx.getId_pripat());
		srvdto.setPrice(priceDO.getPrice_ratio());
		srvdto.setPri_ratio(priceDO.getRatio());
		srvdto.setPri_std(priceDO.getPrice_std());
		srvdto.setCode_srv(medSrvDO.getCode());
		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
		srvdto.setSortno(1);// 设置排序
		return srvdto;
	}

	/**
	 * 查询服务
	 * 
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] getMedSrvDOs(String[] id_srvs) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDOs = service.findByIds(id_srvs, FBoolean.FALSE);
		return medSrvDOs;
	}

	private MedSrvPriceDO calculatePrice(MedSrvDO medSrv, String id_pripat) throws BizException {
		MedSrvPriceDO price = new MedSrvPriceDO();
		price.setPrice_ratio(FDouble.ZERO_DBL);
		price.setPrice_std(FDouble.ZERO_DBL);
		price.setRatio(FDouble.ONE_DBL);
		price.setId_pripat(id_pripat);
		if (medSrv == null) {
			return price; // 套内临床项目为空时候，不计算价格
		}
		price = OrderEmsPriceUtils.calculatePrice(medSrv.getId_srv(), medSrv.getId_primd(), id_pripat);
		return price;
	}

	/**
	 * 医疗单匹配
	 * 
	 * @param envinfo
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, MedSrvDO medSrvDO) throws BizException {
		return CiOrdUtils.getFuncClassStr_GJ(envinfo, medSrvDO);
	}

	/**
	 * 诊断信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private DiagOutlineInfo getDiagInfo() throws BizException {
		if (diagOutlineInfo == null) {
			// 诊断赋值
			diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(this.ctx.getId_en());
		}
		return diagOutlineInfo;

	}

}
