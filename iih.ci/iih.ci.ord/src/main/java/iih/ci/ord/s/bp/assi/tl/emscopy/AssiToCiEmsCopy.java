package iih.ci.ord.s.bp.assi.tl.emscopy;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDORService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.tl.config.AssiConifigBP;
import iih.ci.ord.s.bp.assi.tl.config.ExtensionPointEu;
import iih.ci.ord.s.bp.assi.tl.impl.CopyCommonCiEmsServiceImpl;
import iih.ci.ord.s.bp.assi.tl.impl.CopyContextCiEmsServiceImpl;
import iih.ci.ord.s.bp.assi.tl.impl.CopyEmssrvsServiceImpl;
import iih.ci.ord.s.bp.assi.tl.impl.CopyMedSrvToCiEmsServiceImpl;
import iih.ci.ord.s.bp.assi.tl.impl.CopySrvsetitmsServiceImpl;
import iih.ci.ord.s.bp.assi.tl.service.AbstractAssiCalcuate;
import iih.ci.ord.s.bp.assi.tl.service.AbstractAssiCopy;
import iih.ci.ord.s.bp.quantum.times.QuanFirstDayMpBP;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class AssiToCiEmsCopy {

	// 频次
	protected IFreqdefMDORService ifreqdefMDORService;
	// 用法
	protected IMedusageRService imedusageRService;
	// 用法要求
	protected IMedusagedesRService imedusagedesRService;
	// 煎法
	protected ICherbboilmdMDORService icherbboilmdMDORService;
	// 煎法要求
	protected ICHerbBoilDesDORService icHerbBoilDesDORService;
	// 医疗服务服务
	protected IMedsrvMDORService imedsrvMDORService;
	// 套定义服务
	protected IMedSrvSetItemDORService srvSetItemRSercie;
	// 检查属性
	protected IMedSrvRisDORService imedSrvRisDORService = null;
	// 诊断服务接口
	protected ICidiagQryService icidiagQryService;

	public AssiToCiEmsCopy() {

		ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		imedusageRService = (IMedusageRService) ServiceFinder.find(IMedusageRService.class);
		imedusagedesRService = (IMedusagedesRService) ServiceFinder.find(IMedusagedesRService.class);
		icherbboilmdMDORService = (ICherbboilmdMDORService) ServiceFinder.find(ICherbboilmdMDORService.class);
		icHerbBoilDesDORService = (ICHerbBoilDesDORService) ServiceFinder.find(ICHerbBoilDesDORService.class);
		imedsrvMDORService = (IMedsrvMDORService) ServiceFinder.find(IMedsrvMDORService.class);
		srvSetItemRSercie = (IMedSrvSetItemDORService) ServiceFinder.find(IMedSrvSetItemDORService.class);
		imedSrvRisDORService = (IMedSrvRisDORService) ServiceFinder.find(IMedSrvRisDORService.class);
		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
	}
	
	/**
	 * 获取医嘱模板转换为CiEmsDTO
	 * 
	 * @param envinfo
	 * @param ciOrtmplAggDTO
	 * @return
	 * @throws BizException
	 */
	public List<CiEmsDTO> ConvertCiOrTmplToCiEms(CiEnContextDTO envinfo, CiOrTmplDTO[] ciOrtmplAggDTO)
			throws BizException {

		if (ciOrtmplAggDTO == null || ciOrtmplAggDTO.length == 0)
			return null;

		// 初始化相关的服务、物品、检查、上下文就诊环境
		InitAssiParamBP bp = new InitAssiParamBP();
		AssiParamDTO paramDTO = bp.initAssiParam(envinfo, ciOrtmplAggDTO);

		List<CiEmsDTO> ciEmsDTOList = new ArrayList<CiEmsDTO>();
		for (int i = 0; i < ciOrtmplAggDTO.length; i++) {

			CiOrTmplDTO ciOrTmpl = ciOrtmplAggDTO[i];
			CiEmsDTO ciEms = this.getCiEmsDTOCopy(paramDTO, ciOrTmpl);
			ciEmsDTOList.add(ciEms);
		}
		return ciEmsDTOList;
	}

	/**
	 * 获取CiEmsDTO对象拷贝
	 * 
	 * @param envinfo 当前上下文就诊环境
	 * @param ciOrTmpl 医嘱标准模板
	 * @return
	 * @throws BizException
	 */
	public CiEmsDTO getCiEmsDTOCopy(AssiParamDTO paramDTO, CiOrTmplDTO ciOrTmpl) throws BizException {

		CiEmsDTO ciEms = new CiEmsDTO();

		ciEms.setId_srv(ciOrTmpl.getId_srv());
		MedSrvDO medSrvDO = imedsrvMDORService.findById(ciEms.getId_srv());
		if (medSrvDO == null) {
			throw new BizException("标准模板转CiEmsDTO时根据id_srv[" + ciEms.getId_srv() + "]未获取到服务项目");
		}
		
		// 拷贝当前上下文环境就诊信息
		AbstractAssiCopy<CiEnContextDTO, CiEmsDTO> copyContextService = new CopyContextCiEmsServiceImpl();
		copyContextService.setAssiParam(paramDTO);
		copyContextService.startCopy(paramDTO.getEnvinfo(), ciEms);

		// 拷贝CiEms公共部分
		AbstractAssiCopy<CiOrTmplDTO, CiEmsDTO> copyCommonCiEmsService = new CopyCommonCiEmsServiceImpl();
		copyCommonCiEmsService.setAssiParam(paramDTO);
		copyCommonCiEmsService.startCopy(ciOrTmpl, ciEms);

		// 拷贝MedSrvDO属性
		AbstractAssiCopy<MedSrvDO, CiEmsDTO> copyMedSrvService = new CopyMedSrvToCiEmsServiceImpl();
		copyMedSrvService.setAssiParam(paramDTO);
		copyMedSrvService.startCopy(medSrvDO, ciEms);

		// 拷贝套内项目
		AbstractAssiCopy<CiOrTmplDTO, CiEmsDTO> copySrvsetItmsService = new CopySrvsetitmsServiceImpl();
		copySrvsetItmsService.setAssiParam(paramDTO);
		copySrvsetItmsService.startCopy(ciOrTmpl, ciEms);
		
		// 拷贝服务项目
		AbstractAssiCopy<CiOrTmplDTO, CiEmsDTO> copyEmssrvsService = new CopyEmssrvsServiceImpl();
		copyEmssrvsService.setAssiParam(paramDTO);
		copyEmssrvsService.startCopy(ciOrTmpl, ciEms);
		
		// 拷贝计算结果
		AbstractAssiCalcuate<CiEmsDTO> ciEmsConfig = AssiConifigBP.getDynamicC(ExtensionPointEu.StartCiEms, paramDTO.getEnvinfo(),
				ciEms.getSd_srvtp());
		if (ciEmsConfig != null) {
			ciEmsConfig.setAssiParam(paramDTO);
			ciEmsConfig.calcuateProperty(ciEms);
		}
		//住院西成药时需要给頻次為天的首日执行次数赋值
		if(ciEms.getCode_entp()!=null&&ciEms.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)&&ciEms.getSd_srvtp() != null
						&& (ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)||
								ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG))&&ciEms.getSd_frequnitct()!=null&&ciEms.getSd_frequnitct().equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)) {
			ciEms.setTimes_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(ciEms.getId_freq(), ciEms.getDt_begin(),null,ciEms.getSd_srvtp(),ciEms.getCode_entp(),null,null));
		}
		return ciEms;
	}

}
