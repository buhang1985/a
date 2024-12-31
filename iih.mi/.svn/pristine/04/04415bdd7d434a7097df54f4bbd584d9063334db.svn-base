package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.limitpsd.d.MiMcLimitPsdDO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeMsgUtilBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeSetErrMsgBP;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 单方校验规则
 * @author LIM
 * @since 2019-09-23
 */
public class MiCheckSinglePresRule {
	/**
	 * 单方校验规则 单方是指一个中草药处方中只有一味药材，防止医生单独开立比较昂贵的药材
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto)throws BizException{
		//1.设置返回参数
		MiMcWholeRuleOutParamDTO outParamDto= new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);//默认通过校验		
		//2.验证待校验医嘱
		FArrayList orderList= inParamDto.getCiorderlist();
		if(StringUtil.isEmpty(inParamDto.getId_hp()) || ListUtil.isEmpty(orderList)){
			return outParamDto;
		}			
		//3.获取草药ID集合
		List<String> srvIdList = this.getSinglePresSrvIdList(orderList);
		if (ListUtil.isEmpty(srvIdList)) {
			return outParamDto;// 单方服务为空，则为通过
		}
		//4.获取医保单方限制集合
		List<MiMcLimitPsdDO> hpLimitList = this.getLimitPsdByIdHp(inParamDto.getId_hp(), srvIdList.toArray(new String[0]));	
		//5.获取医保单方限制的服务集合
		List<String> hpLimitSrvIdList = this.getLimitSrvIdList(hpLimitList);
		//6.校验单方限制
		outParamDto = this.checkPsd(orderList, hpLimitSrvIdList);
		return outParamDto;
	}
	
	/**
	 * 单方校验
	 * 
	 * @param savingOrList
	 *            待保存医嘱集合
	 * @param hpLimitSrvIdList
	 *            医保单方限制服务集合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private MiMcWholeRuleOutParamDTO checkPsd(FArrayList savingOrList, List<String> hpLimitSrvIdList) throws BizException {
		MiMcWholeRuleOutParamDTO checkResult = new MiMcWholeRuleOutParamDTO();
		checkResult.setFg_checkflag(FBoolean.TRUE);// 默认通过校验
		if (ListUtil.isEmpty(hpLimitSrvIdList)) {
			return checkResult;
		}
		FArrayList failSrvlist = new FArrayList();
		for (Object item : savingOrList) {
			MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) item;
			if (ciOrderDO == null) {
				continue;
			}
			if (this.isSinglePresOrd(ciOrderDO.getOrdsrvlist())) {
				MiMcOrdSrvDTO ordSrvDo = (MiMcOrdSrvDTO) ciOrderDO.getOrdsrvlist().get(0);
				if (hpLimitSrvIdList.contains(ordSrvDo.getId_srv())) {
					checkResult.setFg_checkflag(FBoolean.FALSE);// 校验不通过
		
					MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
					MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
					String errMsg= MiCheckWholeMsgUtilBP.getSinglePresErrorMsg(ordSrvDo.getName_srv(),ordSrvDo.getName_mm());
					itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO,ordSrvDo, MiMcCheckFailResultEnum.SINGLEIDSRV,errMsg);
					if (itmChkRstDTO != null) {
						failSrvlist.add(itmChkRstDTO);
					}
				}
			}
		}
		checkResult.setErroritm_list(failSrvlist);
		return checkResult;
	}
	
	/**
	 * 获取单方的服务ID集合
	 * 
	 * @param hpQryOrderDoLst
	 * @return
	 */
	private List<String> getSinglePresSrvIdList(FArrayList orderList) {
		List<String> srvIdList = new ArrayList<String>();
		for (Object item : orderList) {
			MiMcOrderDTO miMcOrderDTO = (MiMcOrderDTO) item;
			if (miMcOrderDTO == null)
				continue;
			// 医嘱服务明细列表,只处理单方
			if (this.isSinglePresOrd(miMcOrderDTO.getOrdsrvlist())) {
				MiMcOrdSrvDTO ordSrvDo = (MiMcOrdSrvDTO) miMcOrderDTO.getOrdsrvlist().get(0);
				srvIdList.add(ordSrvDo.getId_srv());
			}
		}
		return srvIdList;
	}
	
	/**
	 * 是否为单方医嘱 医嘱服务有且仅有一个，且为草药
	 * 
	 * @param ordsrvList
	 * @return
	 */
	private boolean isSinglePresOrd(FArrayList ordsrvList) {
		if (ordsrvList != null && ordsrvList.size() == 1) {
			MiMcOrdSrvDTO ordSrv = (MiMcOrdSrvDTO) ordsrvList.get(0);
			return ordSrv != null && ordSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
		}
		return false;
	}
	
	/**
	 * 获取医保单方限制服务集合
	 * 
	 * @param hpLimitPsnList
	 *            医保单方限制集合
	 * @return 限制服务ID集合
	 */
	private List<String> getLimitSrvIdList(List<MiMcLimitPsdDO> hpLimitPsnList) {
		if (ListUtil.isEmpty(hpLimitPsnList)) {
			return null;
		}
		List<String> limitSrvIdList = new ArrayList<String>();
		for (MiMcLimitPsdDO hplimit : hpLimitPsnList) {
			if (hplimit == null || StringUtil.isEmpty(hplimit.getId_srv())) {
				continue;
			}
			if (!limitSrvIdList.contains(hplimit.getId_srv())) {
				limitSrvIdList.add(hplimit.getId_srv());
			}
		}
		return limitSrvIdList;
	}
	
	/**
	 * 获取医保单方限制集合
	 * 
	 * @param id_hp 医保ID
	 * @param srvIds 服务ID集合
	 * @return 医保单方限制集合
	 */
	public List<MiMcLimitPsdDO> getLimitPsdByIdHp(String id_hp, String[] srvIds) throws BizException {
		// 拼写查询条件
		StringBuilder whereBuilder = new StringBuilder("1=1");
		if (StringUtil.isEmpty(id_hp)) {
			whereBuilder.append(" AND ").append("id_hp='"+ id_hp +"'");
		}
		String srvIdwherePart = SqlUtils.getInSqlByIds(MiMcLimitPsdDO.ID_SRV, srvIds);
		if (StringUtil.isEmpty(srvIdwherePart)) {
			whereBuilder.append(" AND ").append(srvIdwherePart);
		}
		// 查询字段
		String[] fields = new String[] { MiMcLimitPsdDO.ID_HP, MiMcLimitPsdDO.ID_SRV , MiMcLimitPsdDO.ID_MM};
		@SuppressWarnings("unchecked")
		List<MiMcLimitPsdDO> hpLimitPsdList = (List<MiMcLimitPsdDO>) new DAFacade().findByCond(MiMcLimitPsdDO.class,
				whereBuilder.toString(), fields);
		if (ListUtil.isEmpty(hpLimitPsdList)) {
			return null;
		}
		return hpLimitPsdList;
	}
}
