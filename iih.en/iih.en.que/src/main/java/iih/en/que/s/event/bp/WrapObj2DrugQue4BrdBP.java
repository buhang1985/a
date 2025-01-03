package iih.en.que.s.event.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.ScripRulConst;
import iih.en.comm.ep.BrdCallEP;
import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.bp.GetBrdNameRulScripBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.lock.PKLock;

public class WrapObj2DrugQue4BrdBP {

	/***
	 * 保存大屏站点信息
	 * 
	 * @author fanlq
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public EnBrdSiteDO[] setBrdSiteInfo(AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException {
		if (allQue4EsDTO == null)
			return null;
		// 1.获取发送的大屏站点DO数据
		EnBrdSiteDO brdSiteDO = this.getEnBrdSiteInfo(allQue4EsDTO,eventType);
		// 2.保存大屏站点DO到数据库中
		FDate today = EnAppUtils.getServerDate();
		boolean lock = PKLock.getInstance().addDynamicLock(brdSiteDO.getCode() + today.toStdtString(), 5 * 1000);
		EnBrdSiteDO[] rtns = new EnBrdSiteDO[] { brdSiteDO };
		return rtns;
	}

	/**
	 * 保存叫号信息
	 * 
	 * @author fanlq 2017年12月29日
	 * @param opQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public EnBrdCallDO[] setBrdCallInfo(AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException {
		if (allQue4EsDTO == null)
			return null;
		// 1.获取发送的叫号DO数据
		EnBrdCallDO brdCallDO = this.getBrdCallInfo(allQue4EsDTO,eventType);
		// 2.保存大屏叫号DO到数据库中
		EnBrdCallDO[] rtns = new BrdCallEP().save(new EnBrdCallDO[] { brdCallDO });	
		return rtns;
	}

	/***
	 * 获取发送的大屏站点DO数据
	 * 
	 * @author fanlq 2018年1月5日
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @param enBrdDO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private EnBrdSiteDO getEnBrdSiteInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException {	
		EnBrdSiteDO brdSiteDO = new EnBrdSiteDO();
		brdSiteDO.setName_dept(allQue4EsDTO.getName_dep());
		brdSiteDO.setName_site(allQue4EsDTO.getName_quesite());
		brdSiteDO.setName_dr(allQue4EsDTO.getName_doc());
		brdSiteDO.setAddr_brd(allQue4EsDTO.getAddr_board_site());// 站点屏幕地址
		brdSiteDO.setCode(allQue4EsDTO.getCode_quesite()); //窗口编码
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		String name_curpat = bp.exec(allQue4EsDTO.getName_pat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.CURPAT);
		brdSiteDO.setName_curpat(name_curpat);// 当前患者姓名
		brdSiteDO.setId_grp(EnContextUtils.getGrpId());
		brdSiteDO.setId_org(EnContextUtils.getOrgId());
		brdSiteDO.setNo_curpat(allQue4EsDTO.getTickno());// 就诊号
		brdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
		brdSiteDO.setCode_pat(allQue4EsDTO.getCode_pat());
		switch(eventType){
			case IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN://通用分诊-取消到诊
			case IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE://通用分诊-取消分诊
			case IEnEventConst.EVENT_EN_ALL_PASSNUM://通用分诊-过号
			case IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT://通用分诊-取消处置
			case IEnEventConst.EVENT_EN_ALL_DIAGEND://通用分诊- 处置完成
			case IEnEventConst.EVENT_DRUG_CALLNOARRIVAL://药房大屏-过号
			case IEnEventConst.EVENT_DRUG_DISPENSING://药房大屏-发药
			case IEnEventConst.EVENT_DRUG_OFFLIN://药房队列-下线
				brdSiteDO.setEu_status(BrdStatusEnum.DEL);
				break;
			case IEnEventConst.EVENT_EN_ALL_TRIAGE://通用分诊-分诊
			case IEnEventConst.EVENT_DRUG_ONLIN://药房队列-上线
			case IEnEventConst.EVENT_DRUG_SIGNIN:// 分派窗口
			case IEnEventConst.EVENT_DRUG_DOSAGE:// 配药
			case IEnEventConst.EVENT_DRUG_CALLNUM:// 叫号
				brdSiteDO.setEu_status(BrdStatusEnum.ADD);
		}
			return brdSiteDO;
	}

	/**
	 * 获取发送的叫号DO数据
	 * @author fanlq 2018年1月5日
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private EnBrdCallDO getBrdCallInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		EnBrdCallDO callDO = new EnBrdCallDO();
		callDO.setAddr_brd(allQue4EsDTO.getAddr_board_site());// 站点屏幕地址
		callDO.setCode_site(allQue4EsDTO.getCode_quesite());//窗口编码
		if(!EnValidator.isEmpty(allQue4EsDTO.getTickno())){
			callDO.setTick_no(Integer.valueOf(allQue4EsDTO.getTickno()));// 就诊号
		}
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		String name_callpat = bp.exec(allQue4EsDTO.getName_pat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.CALLPAT);
		callDO.setName_pat(name_callpat);// 患者姓名
		callDO.setName_call_pat(allQue4EsDTO.getName_pat());
		callDO.setDt_call(EnAppUtils.getServerDateTime());
		callDO.setDt_insert(EnAppUtils.getServerDateTime());
		callDO.setId_grp(EnContextUtils.getGrpId());
		callDO.setId_org(EnContextUtils.getOrgId());
		callDO.setCode_pat(allQue4EsDTO.getCode_pat());
		if (IEnEventConst.EVENT_DRUG_CALLNUM.equals(eventType) || IEnEventConst.EVENT_EN_ALL_CALLNUM.equals(eventType)) {
			callDO.setStatus(DOStatus.NEW);
		}
		return callDO;
	}
	
}
