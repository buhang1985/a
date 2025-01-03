package iih.bl.pay.s.bp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.BdPreWarnItmDO;
import iih.bd.pp.bdprewarn.d.BdprewarnAggDO;
import iih.bd.pp.bdprewarn.d.ControlModelEnum;
import iih.bd.pp.bdprewarn.i.IBdprewarnRService;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.ICalcPriceService;
import iih.bl.comm.IBlConst;
import iih.bl.comm.dto.d.BlPrepayWarnHitDTO;
import iih.bl.comm.util.BlAccountUtil;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.bl.params.BlParams;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderInParamDTO;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderOutParamDTO;
import iih.bl.pay.blcontrolciorder.d.CiOrderSrvDTO;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.d.PrePaidDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 欠费控制是否可开立医嘱（费用）
 * Title: GetArrearsControlBP.java
 * @author zhang.hw
 * @date 2019年10月9日  
 * @version 1.0
 */
public class GetArrearsControlBP {
	/**
	 * 婴儿是否使用母亲账户
	 */
	public FBoolean blstip0026;
	
	public GetArrearsControlBP(){
		blstip0026 = BlParams.BLSTIP0026();
	}
	
	@SuppressWarnings("unchecked")
	public ArrearsControlOrderOutParamDTO[] exec(ArrearsControlOrderInParamDTO[] list) throws BizException{
		//1、查询患者就诊信息
		PatiVisitDO enDO = this.getEntData(list[0].getId_ent());
		//2、根据患者就诊信息查询欠费控制策略主表和预交金欠费控制策略明细表，获取不受控制的服务项目
		//BdprewarnAggDO bdprewarnAggDO = this.getWhiteSrv(enDO,list);
		
		BdPreWarnDO[] warnDos = BlPrepayWarnUtil.getPreWarnSetting(enDO.getCode_entp());
		BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
		hitDto.SetDepId(enDO.getId_dep_phy());
		hitDto.SetNurId(enDO.getId_dep_nur());
		hitDto.SetPatcaId(enDO.getId_patca());
		
		DAFacade daf = new DAFacade();
		List<EntHpDO> entHpList = (List<EntHpDO>)daf.findByAttrValString(EntHpDO.class, EntHpDO.ID_ENT, enDO.getId_ent(), 
				new String[]{EntHpDO.ID_ENT,EntHpDO.ID_HPPATCA, EntHpDO.FG_MAJ});
		if(!ListUtil.isEmpty(entHpList)){
			for (EntHpDO entHpDO : entHpList) {
				if(FBoolean.TRUE.equals(entHpDO.getFg_maj())){
					hitDto.SetHppatcaId(entHpDO.getId_hppatca());
				}
			}
		}
		BdPreWarnDO brPreWarnDO = BlPrepayWarnUtil.hitPreWarnSetting(warnDos, hitDto);
		if(brPreWarnDO == null)
			return null;
		
		//3、获取控制等级
		String sd_arslv = this.getSdarslv(enDO, list, brPreWarnDO);
		
		IBdprewarnRService prewarnRService = ServiceFinder.find(IBdprewarnRService.class);
		BdprewarnAggDO bdprewarnAggDO = prewarnRService.findById(brPreWarnDO.getId_prewarn());
		//3、判断每条医嘱下收费项目是否可开
		return this.getCheckIsOpen(enDO,list,bdprewarnAggDO.getBdPreWarnItmDO(),bdprewarnAggDO.getParentDO().getFg_white(),sd_arslv);
	}
	
	/**
	 * 获取欠费等级
	 * @author zhang.hw
	 * @date 2019年10月14日
	 * @param enDO
	 * @param bdprewarnAggDO
	 * @return
	 */
	private String getSdarslv(PatiVisitDO enDO,ArrearsControlOrderInParamDTO[] inParamDTO,BdPreWarnDO brPreWarnDO) throws BizException {
		//判断是不是婴儿患者	 获取当前住院预交金
		INewbornRService cmdService = ServiceFinder.find(INewbornRService.class);
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO[] borns = cmdService.findByAttrValString("Id_ent_bb", enDO.getId_ent());
		BalanceDTO balDTO = new BalanceDTO();
		if (borns!=null && borns.length>0 && FBoolean.TRUE.equals(this.blstip0026)) {
			balDTO = enService.getBalanceDTO(borns[0].getId_ent_mom());
		}else {
			balDTO = enService.getBalanceDTO(enDO.getId_ent());
		}
		
		FDouble amt_available = balDTO.getAvailable();
		if (FBoolean.TRUE.equals(BlParams.BLPREPAY0023())) {
			FDouble total = this.getAmtOver(inParamDTO);
			amt_available = amt_available.sub(total);
		}
		
		BlAccountDTO accDto = new BlAccountDTO();
		accDto.setAmt_available(amt_available);
		accDto.setAmt_prepay(balDTO.getAmt_prepay());
		accDto.setAmt_cred(balDTO.getAmt_cred());
		PrePaidDTO prepaiDto = BlAccountUtil.calcArrearsGrade(accDto, brPreWarnDO);
		
		/*if (bdprewarnAggDO.getParentDO() == null) {
			return IBlConst.ACC_PREWARN_NONE;
		}
		FDouble value= balDTO.getAvailable();
		switch (bdprewarnAggDO.getParentDO().getEu_control()){
			case ControlModelEnum.AMOUNTCONT://金额控制
				//value=balDTO.getAvailable();
				break;	
			case ControlModelEnum.DEPEQUALPRO://押金等额比例
				//value=balDTO.getAmt_bal().div(balDTO.getAmt_prepay().doubleValue()==0 ? new FDouble(1):balDTO.getAmt_prepay());
				//赋值警告值
				bdprewarnAggDO.getParentDO().setLimit(balDTO.getAmt_bal().multiply(bdprewarnAggDO.getParentDO().getLimit()));
				//赋值部分控制值
				bdprewarnAggDO.getParentDO().setP_control(balDTO.getAmt_bal().multiply(bdprewarnAggDO.getParentDO().getP_control()));
				//赋值完全控制值
				bdprewarnAggDO.getParentDO().setF_control(balDTO.getAmt_bal().multiply(bdprewarnAggDO.getParentDO().getF_control()));
				break;	
			case ControlModelEnum.PRESCALE://预交金比例
				//value=balDTO.getAvailable().div(balDTO.getAmt_prepay().add(balDTO.getAmt_cred()).doubleValue()==0 ? new FDouble(1):balDTO.getAmt_prepay().add(balDTO.getAmt_cred()));
				//赋值警告值
				bdprewarnAggDO.getParentDO().setLimit(balDTO.getAmt_prepay().multiply(bdprewarnAggDO.getParentDO().getLimit()));
				//赋值部分控制值
				bdprewarnAggDO.getParentDO().setP_control(balDTO.getAmt_prepay().multiply(bdprewarnAggDO.getParentDO().getP_control()));
				//赋值完全控制值
				bdprewarnAggDO.getParentDO().setF_control(balDTO.getAmt_bal().multiply(bdprewarnAggDO.getParentDO().getF_control()));
				break;	
		}
		//是否包含新开立的医嘱项目
//		if (FBoolean.TRUE.equals(BlParams.BLPREPAY0023())) {
//			value = this.getAmtOver(inParamDTO);
//		}
		
		if (bdprewarnAggDO.getParentDO().getF_control() != null && value.compareTo(bdprewarnAggDO.getParentDO().getF_control()) < 0) {
			// 可用余额<完全控制:完全控制，则控制等级：3；
			return IBlConst.ACC_PREWARN_FCONTROL;
		} else if (bdprewarnAggDO.getParentDO().getP_control() != null && value.compareTo(bdprewarnAggDO.getParentDO().getP_control()) < 0) {
			// 可用余额<部分控制:部分控制，则控制等级：2；
			return IBlConst.ACC_PREWARN_PCONTROL;
		} else if (bdprewarnAggDO.getParentDO().getLimit() != null && value.compareTo(bdprewarnAggDO.getParentDO().getLimit()) < 0) {
			// 可用余额<警告值：部分控制，则控制等级：1；
			return IBlConst.ACC_PREWARN_LIMIT;
		} else { // 可用余额>警告值，则控制等级：0；
			return IBlConst.ACC_PREWARN_NONE;
		}*/
		return prepaiDto.getSd_arslv();
	}
	
	/**
	 * 获取所开所有医嘱的项目费用
	 * @author zhang.hw
	 * @date 2019年10月14日
	 * @param condDto
	 * @return
	 * @throws BizException
	 */
	private FDouble getAmtOver(ArrearsControlOrderInParamDTO[] inParamDTOs) throws BizException {
		FDouble amt_over = FDouble.ZERO_DBL;
		for(ArrearsControlOrderInParamDTO inParamDTO:inParamDTOs){
			CiOrderSrvDTO[] ciOrderSrvDTO = (CiOrderSrvDTO[]) inParamDTO.getCiorlist().toArray(new CiOrderSrvDTO[inParamDTO.getCiorlist().size()]);
			for(int i=0;i<ciOrderSrvDTO.length;i++){
				if (ciOrderSrvDTO[i].getPrice()==null||ciOrderSrvDTO[i].getQuan()==null) {
					//throw new BizException("新开医嘱服务项目的单价或数量为空！");
					amt_over = amt_over.add(FDouble.ZERO_DBL);
				}else {
					amt_over = amt_over.add(ciOrderSrvDTO[i].getPrice().multiply(ciOrderSrvDTO[i].getQuan()));
				}
			}
		}
		return amt_over;
	}

	/**
	 * 判断每条医嘱下收费项目是否可开
	 * @author zhang.hw
	 * @date 2019年10月12日
	 * @param list
	 * @param bdPreWarnItmDOs
	 * @return
	 */
	private ArrearsControlOrderOutParamDTO[] getCheckIsOpen(PatiVisitDO enDO,ArrearsControlOrderInParamDTO[] list,
			BdPreWarnItmDO[] bdPreWarnItmDOs,FBoolean fg_white,String sd_arslv) throws BizException {
		ArrearsControlOrderOutParamDTO[] outParamDTOs = new ArrearsControlOrderOutParamDTO[]{};
		switch (sd_arslv) {
		case IBlConst.ACC_PREWARN_FCONTROL://完全控制
			outParamDTOs = getFcontrol(list,FBoolean.FALSE);
			break;
		case IBlConst.ACC_PREWARN_PCONTROL://部分控制
			outParamDTOs = getPcontrol(list,bdPreWarnItmDOs,fg_white);
			break;
		default://警告
			outParamDTOs = getFcontrol(list,FBoolean.TRUE);
			break;
		}
		return outParamDTOs;
		
		
	}

	/**
	 * 部分控制设置开立状态
	 * @author zhang.hw
	 * @date 2019年10月14日
	 * @param list
	 * @param bdPreWarnItmDOs
	 * @param fg_white
	 * @return
	 */
	private ArrearsControlOrderOutParamDTO[] getPcontrol(ArrearsControlOrderInParamDTO[] list,
			BdPreWarnItmDO[] bdPreWarnItmDOs, FBoolean fg_white) {
		//子项目可开数量
		int srvor=0;
		List<ArrearsControlOrderOutParamDTO> outlist = new ArrayList<ArrearsControlOrderOutParamDTO>();
		HashSet<String> idsrvSet = new HashSet<String>();
		if (bdPreWarnItmDOs!=null) {
			for(int a=0;a<bdPreWarnItmDOs.length;a++){
				idsrvSet.add(bdPreWarnItmDOs[a].getId_srv());
			}
		}
		for(ArrearsControlOrderInParamDTO inParamDTO:list){
			CiOrderSrvDTO[] ciOrderSrvDTOs = (CiOrderSrvDTO[]) inParamDTO.getCiorlist().toArray(new CiOrderSrvDTO[inParamDTO.getCiorlist().size()]);
			for(int i=0;i<ciOrderSrvDTOs.length;i++){
				//是否是白名单
				boolean isWhite = FBoolean.TRUE.equals(fg_white);
				//开立医嘱项目是否和受限制项目相同
				boolean isIdsrv = idsrvSet.contains(ciOrderSrvDTOs[i].getId_srv());
				if (isWhite && isIdsrv) {//白名单且包含
					ciOrderSrvDTOs[i].setFg_or(FBoolean.TRUE);
				}else if (!isWhite && !isIdsrv) {//黑名单且不包含
					ciOrderSrvDTOs[i].setFg_or(FBoolean.TRUE);
				}else {
					ciOrderSrvDTOs[i].setFg_or(FBoolean.FALSE);
					ciOrderSrvDTOs[i].setDes("当前为部分控制等级，且该项目为黑名单项目，不能开立！");
					if (srvor==0) {
						srvor -= 1;
					}
				}
			}
			//出参
			ArrearsControlOrderOutParamDTO outParamDTO = new ArrearsControlOrderOutParamDTO();
			FArrayList fArrayList = new FArrayList(ciOrderSrvDTOs.length);
			Collections.addAll(fArrayList, ciOrderSrvDTOs);
			outParamDTO.setCiorlist(fArrayList);
			if (srvor<0) {//医嘱是否允许开单
				FBoolean blprepay0022 = BlParams.BLPREPAY0022();
				if (FBoolean.TRUE.equals(blprepay0022)) {
					outParamDTO.setFg_open(FBoolean.TRUE);
				}else{
					outParamDTO.setFg_open(FBoolean.FALSE);
				}
			}else{
				outParamDTO.setFg_open(FBoolean.TRUE);
			}
			outParamDTO.setId_or(inParamDTO.getId_or());
			outlist.add(outParamDTO);
		}
		return outlist.toArray(new ArrearsControlOrderOutParamDTO[outlist.size()]);
	}

	/**
	 * 当为完全控制等级、为警告控制等级或无等级时，设置可开立状态
	 * @author zhang.hw
	 * @date 2019年10月14日
	 * @param list
	 * @return
	 */
	private ArrearsControlOrderOutParamDTO[] getFcontrol(ArrearsControlOrderInParamDTO[] list,FBoolean flag) {
		List<ArrearsControlOrderOutParamDTO> outlist = new ArrayList<ArrearsControlOrderOutParamDTO>();
		for(int i=0;i<list.length;i++){
			ArrearsControlOrderOutParamDTO outParamDTO = new ArrearsControlOrderOutParamDTO();
			outParamDTO.setFg_open(flag);
			outParamDTO.setId_or(list[i].getId_or());
			CiOrderSrvDTO[] ciOrderSrvDTO = (CiOrderSrvDTO[]) list[i].getCiorlist().toArray(new CiOrderSrvDTO[list[i].getCiorlist().size()]);
			for(int j=0;j<ciOrderSrvDTO.length;j++){
				ciOrderSrvDTO[j].setFg_or(flag);
				if (FBoolean.FALSE.equals(flag)) {
					ciOrderSrvDTO[j].setDes("控制等级为完全控制，不可开立！");
				}
				
			}
			FArrayList fArrayList = new FArrayList(ciOrderSrvDTO.length);
			Collections.addAll(fArrayList, ciOrderSrvDTO);
			outParamDTO.setCiorlist(fArrayList);
			outlist.add(outParamDTO);
		}
		return outlist.toArray(new ArrearsControlOrderOutParamDTO[outlist.size()]);
	}

	/**
	 * 根据患者就诊信息查询欠费控制策略主表和预交金欠费控制策略明细表，获取不受控制的服务项目
	 * @author zhang.hw
	 * @date 2019年10月11日
	 * @param enDO
	 */
/*	private BdprewarnAggDO getWhiteSrv(PatiVisitDO enDO,ArrearsControlOrderInParamDTO[] list) throws BizException {
		//1、查询不受控服务项目或受控服务项目
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		BdPreWarnDO preWarnDO = ppQryService.getPreWarnInfo(enDO.getId_dep_phy(), enDO.getId_patca(), enDO.getCode_entp());
		IBdprewarnRService bdprewarn = ServiceFinder.find(IBdprewarnRService.class);
		return bdprewarn.findById(preWarnDO.getId_prewarn());
		
	}*/

	/**
	 * 查询患者就诊信息
	 * @author zhang.hw
	 * @date 2019年10月11日
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEntData(String entId)  throws BizException {
		
		if(StringUtil.isEmpty(entId))
			return null;
		
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		return entService.findById(entId);
	}
}
