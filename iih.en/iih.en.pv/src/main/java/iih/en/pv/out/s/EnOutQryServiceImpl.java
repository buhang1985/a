package iih.en.pv.out.s;

import iih.en.comm.ep.PiPatEP;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.dto.d.PatInfo4HDDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;
import iih.en.pv.out.bp.qry.EntHasStateBP;
import iih.en.pv.out.bp.qry.EntHasTagBP;
import iih.en.pv.out.bp.qry.GetEntOpVitalSignsBP;
import iih.en.pv.out.bp.qry.GetErPreEntDisBP;
import iih.en.pv.out.bp.qry.GetIpBasicsInfoBP;
import iih.en.pv.out.bp.qry.GetMomBabyInfosBP;
import iih.en.pv.out.bp.qry.GetTransDeptFlowsBP;
import iih.en.pv.out.bp.qry.HandlePiBannerErPreInfoBP;
import iih.en.pv.out.bp.qry.IsFreeZeBP;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import iih.en.pv.out.i.IEn4CiQryService;
import iih.en.pv.out.i.IEn4EiQryService;
import iih.en.pv.out.i.IEn4HDService;
import iih.en.pv.out.i.IEn4MbService;
import iih.en.pv.out.i.IEn4MrQryService;
import iih.en.pv.out.i.IEn4PiQryService;
import iih.en.pv.out.i.IEn4ScQryService;
import iih.en.pv.out.mr.d.EnTransDeptFlowDTO;
import iih.en.pv.s.EnIpCmdServiceImpl;
import iih.en.pv.s.bp.GetPatientInfoBp;
import iih.en.pv.s.bp.ip.CheckAppBp;
import iih.en.pv.s.bp.ip.CheckEnterDepBP;
import iih.en.pv.s.bp.ip.CheckTransOutBP;
import iih.en.pv.s.bp.ip.GetPeCmpyBalanceBP;
import iih.en.pv.s.bp.ip.GetPeCmpyBalancesBP;
import iih.en.pv.s.bp.ip.qry.GetTransDepPatInfoBP;
import iih.en.pv.s.bp.op.GetScSchPrintIdentBP;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.i.IEnQueOutQryService;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;

import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;

/**
 * 就诊对外公共查询接口
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IEn4MbService.class, IEn4HDService.class,
		IEn4BlQryService.class, IEn4CiQryService.class, IEn4MrQryService.class,
		IEn4EiQryService.class, IEn4ScQryService.class, IEn4PiQryService.class }, binding = Binding.JSONRPC)
public class EnOutQryServiceImpl implements IEn4MbService, IEn4HDService,
		IEn4BlQryService, IEn4CiQryService, IEn4MrQryService, IEn4EiQryService, IEn4ScQryService, IEn4PiQryService{

	/****************IEn4CommQryService****************/
	/**
	 * 获取住院基本信息--批量接口
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpBasicDTO[] getIpBasicInfos(String[] idEnts) throws BizException {
		GetIpBasicsInfoBP bp = new GetIpBasicsInfoBP();
		return bp.exec(idEnts);
	}
	/**
	 * 患者是否有对应就诊状况
	 * 
	 * @param entId 
	 * 			就诊id
	 * @param sd_enstatetp
	 * 			就诊状况类型  (iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_ENSTATE_XXX)
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean entHasState(String entId, String sd_enstatetp) throws BizException {
		EntHasStateBP bp = new EntHasStateBP();
		return bp.exec(entId, sd_enstatetp);
	}
	/**
	 * 患者是否有对应标签
	 * 
	 * @param entId
	 * 			就诊id
	 * @param sd_tagtp
	 * 			标签类型（iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_TAGTP_XXX）
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean entHasTag(String entId, String sd_tagtp)
			throws BizException {
		EntHasTagBP bp = new EntHasTagBP();
		return bp.exec(entId, sd_tagtp);
	}
	
	/****************IEn4HDService*********************/
	/**
	 * 获取患者信息
	 * 
	 * @param patientID 患者在his的唯一码
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatInfo4HDDTO getPatientInfo(String patientID) throws BizException {
		GetPatientInfoBp bp = new GetPatientInfoBp();
		return bp.exec(patientID);
	}
	
	/****************IEn4MbService*********************/
	/**
	 * 入科服务
	 * 
	 * @param endepDTO 一条记录患者信息的入科DTO
	 * @return boolean 反应是否入科成功
	 * @throws BizException
	 */
	@Override
	public boolean enterDep(EnDepDTO enDepDTO) throws BizException {
		IEnIpCmdService cmdService = new EnIpCmdServiceImpl();
		return cmdService.enterDep(enDepDTO).booleanValue();
	}

	/**
	 * 转科转入申请确认
	 * 
	 * @param patDTO 申请患者
	 * @param endepDTO 入科信息
	 * @throws BizException 
	 */
	@Override
	public void cfmTransDepApp(TransDepPatDTO patDTO, EnDepDTO endepDTO) throws BizException {
		//转入前校验
		CheckEnterDepBP checkBp = new CheckEnterDepBP();
		checkBp.validateBeforeTransIn(patDTO, endepDTO);
		IEnIpCmdService cmdService = new EnIpCmdServiceImpl();
		cmdService.cfmTransDepApp(patDTO, endepDTO);
	}

	/**
	 * 转科转出确认
	 * 
	 * @param patDTO 患者信息
	 * @throws BizException 
	 */
	@Override
	public Integer applyTransDep(TransDepPatDTO[] patDTO) throws BizException {
		try {
			IEnIpCmdService cmdService = new EnIpCmdServiceImpl();
			cmdService.applyTransDep(patDTO);
		} catch (Exception e) {
			return 1;
		}
		return 0;
	}

	/**
	 * 出科
	 * @param appDTO 出院申请DTO
	 * @throws BizException
	 */
	@Override
	public void leaveHos(LvHosAppDTO appDTO) throws BizException {
		IEnIpCmdService cmdService = new EnIpCmdServiceImpl();
		cmdService.leaveHos(appDTO);
	}

	/**
	 * 查询出院检查项
	 * 
	 * @param idEnts 就诊ID
	 * @return
	 * @throws BizException 
	 */
	@Override
	public LvHosAppDTO[] checkApp(String[] idEnts) throws BizException {
		CheckAppBp bp = new CheckAppBp();
		return bp.exec(idEnts);
	}

	/**
	 * 转科转出前校验
	 * 
	 * @param idEnt
	 * @return
	 */
	@Override
	public Map<String, Boolean> checkTransOut(String idEnt)  throws BizException {
		CheckTransOutBP bp = new CheckTransOutBP();
		return bp.exec(idEnt);
	}
	
	/****************IEn4BlQryService*********************/
	/**
	 * 已转病区未出院的患者查询接口
	 * 
	 * @param idOldNur 原病区id
	 * @return
	 * @throws DAException 
	 * @throws BizException
	 */
	@Override
	public TransDepPatDTO[] getTransDepPatInfo(String idOldNur) throws BizException {
		GetTransDepPatInfoBP bp = new GetTransDepPatInfoBP();
		TransDepPatDTO[] transDepPats = bp.exec(idOldNur);
		return transDepPats;
	}

	/**
	 * 获取团检账户金额
	 * @param peCmpyId 团检记录id
	 * @return 账户金额信息
	 * @throws BizException
	 * @author ly 2018/06/04
	 */
	@Override
	public BalanceDTO getPeCmpyBalance(String peCmpyId) throws BizException{
		GetPeCmpyBalanceBP bp = new GetPeCmpyBalanceBP();
		return bp.exec(peCmpyId);
	}
	
	/**
	 * 获取团检账户金额(批量)
	 * @param peCmpyIds 团检记录id数组
	 * @return 账户金额信息
	 * @throws BizException
	 * @author ly 2018/06/26
	 */
	@Override
	public BalanceDTO[] getPeCmpyBalances(String[] peCmpyIds) throws BizException{
		GetPeCmpyBalancesBP bp = new GetPeCmpyBalancesBP();
		return bp.exec(peCmpyIds);
	}
	/**
	 * 获取母婴就诊数据接口
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 * @author lb
	 */
	@Override
	public EnMomBabyInfoDTO[] getMomBabyInfos(String[] entIds)
			throws BizException {
		GetMomBabyInfosBP bp = new GetMomBabyInfosBP();
		return bp.exec(entIds);
	}
	
	/****************IEn4CiQryService*********************/
	/**
	 * 就诊是否封账
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isFreeZe(String entId) throws BizException {
		IsFreeZeBP bp = new IsFreeZeBP();
		return bp.exec(entId);
	}
	/**
	 * 获取患者预约渠道打印标识
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getScSchPrintIdent(String entId) throws BizException {
		GetScSchPrintIdentBP bp = new GetScSchPrintIdentBP();
		return bp.exec(entId);
	}
	
	/**
	 * 获取门诊预检生命体征信息
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntOpVitalSignsDTO[] getEntOpVitalSigns(String[] idEnts)
			throws BizException {
		GetEntOpVitalSignsBP bp = new GetEntOpVitalSignsBP();
		return bp.exec(idEnts);
	}
	/**
	 * 获取前一次就诊的诊断信息
	 * 1.本次就诊没有前一次就诊，返回null
	 * 2.前一次就诊没有诊断，返回null
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntDiDO[] getErPreEntDis(String entId) throws BizException {
		GetErPreEntDisBP bp = new GetErPreEntDisBP();
		return bp.exec(entId);
	}
	
	/****************IEn4MrQryService*********************/
	/**
	 * 获取住院就诊转科流程记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnTransDeptFlowDTO[] getTransDeptFlows(String entId)
			throws BizException {
		GetTransDeptFlowsBP bp = new GetTransDeptFlowsBP();
		return bp.exec(entId);
	}
	
	
	/****************IEn4EiQryService*********************/
	/**
	 * 组装上屏DTO
	 * @param es
	 * @param eventType
	 * @return
	 * @throws BizException 
	 */
	@Override
	public OpQue4DispDTO getOpQueDTO4Disp(OpQue4EsDTO es, String eventType)
			throws BizException {
		IEnQueOutQryService service = ServiceFinder.find(IEnQueOutQryService.class);
		return  service.getOpQueDTO4Disp(es, eventType);
	}
	
	/****************IEn4ScQryService*********************/
	/**
	 * 获取预约自费付款患者分类
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public PiPatCaDO getAptSelfPayPatCa(String patId) throws BizException {
		return new PiPatEP().getAptSelfPayPatca(patId);
	}
	/****************IEn4ScQryService*********************/
	/**
	 * 患者banner处理预检信息
	 * 
	 * @param banners
	 * @throws BizException
	 */
	@Override
	public void handleBannerErPreInfo(PatientBannerDTO[] banners) throws BizException {
		new HandlePiBannerErPreInfoBP().exec(banners);
	}
}
