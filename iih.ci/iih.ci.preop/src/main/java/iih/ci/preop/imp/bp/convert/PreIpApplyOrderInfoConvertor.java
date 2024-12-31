package iih.ci.preop.imp.bp.convert;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.preop.imp.utils.ImportPreUtils;
import iih.ci.sdk.cache.BDBoilInfoCache;
import iih.ci.sdk.cache.BDDeptInfoCache;
import iih.ci.sdk.cache.BDFreqInfoCache;
import iih.ci.sdk.cache.BDMeasInfoCache;
import iih.ci.sdk.cache.BDPsnInfoCache;
import iih.ci.sdk.cache.BDRouteDesInfoCache;
import iih.ci.sdk.cache.BDRouteInfoCache;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.tsip.d.CiTsOrDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 预住院申请导入，医嘱主信息转换类
 * @author mkp
 *
 */
public class PreIpApplyOrderInfoConvertor {
	// 上下文
	CiEnContextDTO ctx;

	public PreIpApplyOrderInfoConvertor(CiEnContextDTO ctx) {
		this.ctx = ctx;
	}

	/**
	 * 将治疗方案中医嘱相关信息转化至CiEmsDTO中
	 * 
	 * @param tsOrder
	 * @param ciEmsDTO
	 * @throws BizException 
	 */
	public void transfer(CiTsOrDO tsOrder, CiEmsDTO ciEmsDTO) throws BizException {
		// 获取医嘱主键
//		String id_or = new DBUtil().getOIDs(1)[0];
//		ciEmsDTO.setId_or(id_or);
		// 获取医嘱编码
		String codeOr = ServiceFinder.find(ICiOrdQryService.class).getCodeOr();
		ciEmsDTO.setCode(codeOr);

		ciEmsDTO.setName(tsOrder.getName_or());
		ciEmsDTO.setContent(tsOrder.getContent_or());

		// 设置就诊信息，设置为预住院类型就诊
		ciEmsDTO.setId_pat(tsOrder.getId_pat());
		ciEmsDTO.setId_en(ctx.getId_en());
		ciEmsDTO.setCode_entp(ctx.getCode_entp());
		ciEmsDTO.setId_entp(ctx.getId_entp());
		
		ciEmsDTO.setSd_srvtp(tsOrder.getSd_srvtp());
		ciEmsDTO.setId_srv(tsOrder.getId_srv());
		// 医嘱来源功能
		ciEmsDTO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
		ciEmsDTO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);

		// 查询基础服务信息
		MedSrvDO bdSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, tsOrder.getId_srv());
		if (bdSrvInfo != null) {
			ciEmsDTO.setId_srvtp(bdSrvInfo.getId_srvtp());			
			ciEmsDTO.setId_srvca(bdSrvInfo.getId_srvca());
			SrvCateDO srvCateDO = ServiceFinder.find(ISrvcateRService.class).findById(bdSrvInfo.getId_srvca());
			if (srvCateDO != null) {
				ciEmsDTO.setInnercode_srvca(srvCateDO.getInnercode());				
			}
			ciEmsDTO.setId_unit_med(bdSrvInfo.getId_unit_med());
			ciEmsDTO.setName_unit_med(BDMeasInfoCache.GetNameOfBdMeasInfo(bdSrvInfo.getId_unit_med()));
			// 总量
			ciEmsDTO.setQuan_medu(bdSrvInfo.getQuan_med());
		} else {
			throw new BizException(tsOrder.getCode_or() + " 对应的服务信息未找到");
		}

		ciEmsDTO.setFg_long(tsOrder.getFg_long());
		ciEmsDTO.setEmstype(getEmsType(tsOrder.getSd_srvtp()));
		
		// 服务套信息
		ciEmsDTO.setFg_set(tsOrder.getFg_set());
//		ciEmsDTO.setId_srv_pkg(tsOrder.getId_srv_pkg());
		
		// 频次信息
		FreqDefDO freqInfo = BDFreqInfoCache.GetFreqInfo(tsOrder.getId_freq());
		if (freqInfo != null) {
			ciEmsDTO.setId_freq(tsOrder.getId_freq());
			ciEmsDTO.setName_freq(freqInfo.getName());
			ciEmsDTO.setFreqct(freqInfo.getFreqct());
			ciEmsDTO.setFrequnitct(freqInfo.getFrequnitct());
			ciEmsDTO.setSd_frequnitct(freqInfo.getSd_frequnitct());			
		}
		ciEmsDTO.setTimes_cur(tsOrder.getTimes_cur());
		ciEmsDTO.setDays_or(tsOrder.getDays_or());
		ciEmsDTO.setOrders(tsOrder.getOrders());

		// 用法信息
		ciEmsDTO.setId_route(tsOrder.getId_route());
		ciEmsDTO.setName_route(BDRouteInfoCache.GetNameOfBdRouteInfo(tsOrder.getId_route()));
		ciEmsDTO.setId_routedes(tsOrder.getId_routedes());
		if (tsOrder.getId_routedes() != null && tsOrder.getId_routedes().length() > 0) {
			ciEmsDTO.setName_routedes(BDRouteDesInfoCache.GetNameOfBdRouteDesInfo(tsOrder.getId_routedes()));			
		}
		ciEmsDTO.setId_boil(tsOrder.getId_boil());
		if (tsOrder.getId_boil() != null && tsOrder.getId_boil().length() > 0) {
			ciEmsDTO.setName_boil(BDBoilInfoCache.GetNameOfBdBoilInfo(tsOrder.getId_boil()));					
		}

		// ciEmsDTO.setNote();
		ciEmsDTO.setDes_or(tsOrder.getDes_or());

		// 设置医生、科室、病区信息
		// 开立医生，根据参数判断
		String id_emp_create = "";
		FBoolean hasDoctor = ParamsetQryUtil.getParaBoolean(ctx.getId_org(), "CIOR0805");
		if (hasDoctor != null && hasDoctor.booleanValue()) {
		    id_emp_create = ctx.getId_psndoc();
		} else {
		    id_emp_create = tsOrder.getId_emp_create();
		}
		PsnDocDO psn = BDPsnInfoCache.GetPsnInfoOfIdPsn(id_emp_create);
		ciEmsDTO.setId_emp_phy(id_emp_create);
		ciEmsDTO.setName_emp_phy(psn.getName());
		// 就诊科室、病区
		ciEmsDTO.setId_dep_phy(ctx.getId_dep_en());
		ciEmsDTO.setName_dep_phy(BDDeptInfoCache.GetNameOfBDeptInfo(ctx.getId_dep_en()));
		ciEmsDTO.setId_dept_ns(ctx.getId_dep_ns());

		// 医疗组
		ciEmsDTO.setId_wg_or(ctx.getId_wg_or());
		// 在院执行标志，保存时会计算
//		ciEmsDTO.setFg_mp_in();
		// 加急标识
		ciEmsDTO.setFg_urgent(FBoolean.FALSE);

		// 时间处理
		ciEmsDTO.setDt_begin(ServiceFinder.find(TimeService.class).getUFDateTime());
//		ciEmsDTO.setDt_end(tsOrder.getDt_end());

		ciEmsDTO.setFg_or_doc(FBoolean.TRUE);
		// 设置医嘱状态
		ciEmsDTO.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
		ciEmsDTO.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
		
		// 设置医疗单的路径和id_srvof
		SrvMatchEmsRstDTO emsmatchrst = ImportPreUtils.getFuncClassStr(ctx, bdSrvInfo);
		if (emsmatchrst != null) {
			ciEmsDTO.setFuncclassstr(emsmatchrst.getFuncclassstr());
			ciEmsDTO.setId_srvof(emsmatchrst.getId_ems());			
		}

		// 设置医嘱来源字段
		ciEmsDTO.setEu_orsrcmdtp(OrSourceFromEnum.IIHPREIPAPP);
		
		// 非径内医嘱
		ciEmsDTO.setEu_uncporjudge(-1);
		
		// 费用项是否计算
//		ciEmsDTO.setFg_prisrvhandled(FBoolean.TRUE);

		// 诊断信息
		ciEmsDTO.setId_didef(tsOrder.getId_di_def());
		DiagDefDO defDO = ServiceFinder.find(IDiagdefMDORService.class).findById(tsOrder.getId_di_def());
		if (!ObjectUtils.isEmpty(defDO)) {
			ciEmsDTO.setCode_didef(defDO.getCode());
			ciEmsDTO.setName_didef(defDO.getName());
			
		}
		
		// 计算执行科室
		OrWfDeptInfoDTO wfDeptInfoDTO = getExeWfDept(ciEmsDTO);
		if (wfDeptInfoDTO != null) {
		    ciEmsDTO.setId_dep_mp(wfDeptInfoDTO.getFirstid_mp_dept());
		    ciEmsDTO.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(wfDeptInfoDTO.getFirstid_mp_dept()));		    
		}
	}
	
	/**
     * 查询执行科室
     * 
     * @param ciOrderDO
     * @return
     * @throws BizException
     */
    private OrWfDeptInfoDTO getExeWfDept(CiEmsDTO ciOrderDO) throws BizException {
        // 获取上下文信息
        CiEnContextDTO context = ctx;
        OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
        paramdto.setEu_wftp(1); // 0执行与物资 1执行科室 2物资流向
        paramdto.setCode_entp(ciOrderDO.getCode_entp()); // 就诊类型
        paramdto.setId_dept_ns(context.getId_dep_ns()); // 就诊护理病区
        paramdto.setId_dept_or(context.getId_dep_or());// 开单科室
        paramdto.setId_dept_en(context.getId_dep_en()); // id_dept_en;//就诊科室
        // dto.Recurstr = ""; //长临需要的 不知道 就为空
        paramdto.setId_srv(ciOrderDO.getId_srv()); // 服务
        paramdto.setSd_srvtp(ciOrderDO.getSd_srvtp()); // 服务类型sd
        paramdto.setId_srvca(ciOrderDO.getId_srvca());// 服务分类

        paramdto.setId_usage(ciOrderDO.getId_route()); // 用法
        // dto.Weekno = "2";//生效日期时间相关的 周#与时间
        paramdto.setTimestr(ServiceFinder.find(TimeService.class).getUFDateTime().getUFTime());
        if (ciOrderDO.getFg_long() == null) {
            paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.NULL));
        } else if (ciOrderDO.getFg_long().booleanValue()) {
            paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.LONG));
        } else {
            paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.TEMP));
        }
        // paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); //只求执行科室
        // 执行科室（新的）
        ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
        OrWfDeptInfoDTO orWfDeptInfo = service.getExeDepts4CiOrSrvN(paramdto);
        return orWfDeptInfo;
    }
	
	/**
	 * 获得医疗单类型
	 * 
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	private Integer getEmsType(String sd_srvtp) throws BizException {
		if (StringUtils.isEmpty(sd_srvtp)) {
			return -1;
		}

		if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_REPL)) {
			return EmsType.IV;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG)) { // 药品其它
			return EmsType.COMMONDRUG;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) { //
			return EmsType.PATHGY;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS)) { //
			return EmsType.RIS;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST)) { //
			return EmsType.SKINTEST;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS)) { //
			return EmsType.LIS;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OP)) { //
			return EmsType.OPER;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) { //
			return EmsType.BT;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)) { //
			return EmsType.BTUSE;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) { //
			return EmsType.CONS;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)) { //
			return EmsType.TRANSDEPT;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD)) { //
			return EmsType.TRANSDEPT;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)) { //
			return EmsType.OUTHOSP;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT)) {
			return EmsType.DIET;
		} else if (StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_NORMAL)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_XIYANG)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_NSGREED)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_TREATNS)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A)
				|| StringUtils.startsWith(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OTHER)) {
			return EmsType.COMMON;
		}

		return -1;
	}
}
