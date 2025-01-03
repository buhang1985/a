package iih.en.pv.s.bp.op;

import iih.en.comm.bp.GetBannerDefBP;
import iih.en.comm.ep.DayslotEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.reg.i.IPiPatUniqueManageQrySerice;
import iih.pi.reg.i.IPiRegQryService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 门急诊医生站Banner查询就诊或患者信息
 * 
 * @author liubin
 *
 */
public class GetOpRegOrPat4BannerBP {
	
	private static final String KEY_ENT = "ent";
	private static final String KEY_PAT = "pat";
	/*
	 * 禁止跨科接诊
	 */
	private static final String EN_OP_DEPCTRL_FG_NO = "3";
	/**
	 * 门急诊医生站Banner查询就诊或患者信息
	 * 
	 * @param whereStr
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	public FMap exec(String whereStr, String[] selectConditions, String inputValue, EnTrDocSiteInfoDTO enSiteInfo) throws BizException{
		EnLogUtil.getInstance().logInfo(String.format("GetOpRegOrPat4BannerBP inputValue[%s]", inputValue));
		if(EnValidator.isEmpty(whereStr) || EnValidator.isEmpty(inputValue))
			return null;
		inputValue = inputValueHandle(inputValue);
		FMap map = new FMap();
		map.put(KEY_ENT, null);
		map.put(KEY_PAT, null);
		//查询就诊
		OpRegDTO[] regs = this.getOpRegs(inputValue, selectConditions, enSiteInfo);
		//按跨科参数过滤挂号信息
		regs = filterOpRegs(regs);
		if(!EnValidator.isEmpty(regs)){
			map.put(KEY_ENT, EnCollectionUtils.toFArrayList(regs));
			return map;
		}
		//查询患者
		PatientBannerDTO[] pats = this.getPatBannerDTOs(selectConditions, inputValue);
		if(!EnValidator.isEmpty(pats)){
			map.put(KEY_PAT, EnCollectionUtils.toFArrayList(pats));
			return map;
		}
		return map;
	}
	/**
	 * 查询就诊
	 * 
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] getOpRegs(String inputValue, String[] selectConditions, EnTrDocSiteInfoDTO enSiteInfo) throws BizException{
		String[] entIds = new GetBannerDefBP().getEntIdFromEntBanner(selectConditions, inputValue);
		if(EnValidator.isEmpty(entIds))
		{
			if(!EnValidator.isEmpty(inputValue)){
				//从第三方患者唯一管理平台同步患者信息
				IPiRegQryService piRegQryService = ServiceFinder.find(IPiRegQryService.class);
				PatientBannerDTO patientBannerDTO = piRegQryService.getPatiBannerFromThirdSystem(inputValue);
				if(!EnValidator.isEmpty(patientBannerDTO)){
					entIds = new GetBannerDefBP().getEntIdFromEntBanner(selectConditions, patientBannerDTO.getCode());
				}
			}
		}
		if(EnValidator.isEmpty(entIds))
		{
			return null;
		}
		FDateTime curTime = EnAppUtils.getAcptQryDateTime(enSiteInfo.getDate(), enSiteInfo.getId_dayslot());
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT EN.ID_ENT FROM EN_ENT EN INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append(" WHERE EN.FG_CANC = 'N' ");
		sb.append(" AND OP.DT_VALID_B <= ? ");
		sb.append(" AND OP.DT_VALID_E >= ? ");
		sb.append(" AND ").append(EnSqlUtils.getOpOrErTpSql("EN", enSiteInfo.getCode_entp()));
		sb.append(" AND ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		param.addParam(EnAppUtils.getAdvanceAcptTime(curTime));
		param.addParam(curTime);
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), param, new ColumnListHandler());
		if(EnValidator.isEmpty(list))
			return null;
		GetOpRegListByPatBP bp = new GetOpRegListByPatBP();
		OpRegDTO[] opregs = bp.getOpRegByEntIds(list.toArray(new String[0]), FBoolean.TRUE);
		this.reSetDayslot(opregs, entIds);
		return opregs;
	}
	/***
	 * @Description:重新设置午别
	 * @param opregs
	 * @param entIds
	 * @throws BizException
	 */
	private void reSetDayslot(OpRegDTO[] opregs,String[] entIds) throws BizException{
		Map<String,OpRegDTO> map = new DayslotEP().getDayslotMapByEntId(entIds);
		if(opregs != null && opregs.length > 0 && map.size() > 0){
			for(OpRegDTO opreg : opregs){
				OpRegDTO dto = map.get(opreg.getId_ent());
				if(dto != null){
					opreg.setId_dateslot(dto.getId_dateslot());
					opreg.setName_dateslot(dto.getName_dateslot());
				}
			}
		}
	}
	/**
	 * 获取患者BannerDTO
	 * @param whereStr
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	private PatientBannerDTO[] getPatBannerDTOs(String[] selectConditions, String inputValue) throws BizException{
		String[] patIds = new GetBannerDefBP().getPatIdFromEntBanner(selectConditions, inputValue);
		if(EnValidator.isEmpty(patIds))
			return null;
		String whereStr = EnSqlUtils.getInSqlByIds(" and id_pat ", patIds);
		IPiRegQryService serv = ServiceFinder.find(IPiRegQryService.class);
		return serv.getPatiBanner(null, whereStr, null, inputValue);
	}
	/**
	 * 按跨科参数过滤挂号信息
	 * 
	 * @param opRegs
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] filterOpRegs(OpRegDTO[] opRegs) throws BizException{
		if(EnValidator.isEmpty(opRegs))
			return null;
		String curDeptId = EnContextUtils.getDeptId();
		if(EnValidator.isEmpty(curDeptId))
			return opRegs;
		String crossDeptAcptFlagOfDep = EnParamUtils.getCrossDepAcpt(curDeptId);
		if(!EN_OP_DEPCTRL_FG_NO.equals(crossDeptAcptFlagOfDep))
			return opRegs;
		//该科室禁止跨科接诊
		Set<OpRegDTO> set = new HashSet<>();
		for(OpRegDTO opReg : opRegs)
			if(curDeptId.equals(opReg.getId_dep_reg()))
				set.add(opReg);
		return set.isEmpty()?null:set.toArray(new OpRegDTO[0]);
	}
	/**
	 * 输入编码处理
	 * 
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	private String inputValueHandle(String inputValue) throws BizException {
		try{
			IPiPatUniqueManageQrySerice serv = ServiceFinder.find(IPiPatUniqueManageQrySerice.class);
			if(serv == null)
				return inputValue;
			String newInputValue = serv.substrPatCode(inputValue);
			return EnValidator.isEmpty(newInputValue) ? inputValue : newInputValue;
		}catch(BizException ex){
			throw ex;
		}catch(Exception ex){
			EnLogUtil.getInstance().logError(String.format("调用IPiPatUniqueManageQrySerice出错, inputValue[%s]", inputValue), ex);
			return inputValue;
		}
	}
}
