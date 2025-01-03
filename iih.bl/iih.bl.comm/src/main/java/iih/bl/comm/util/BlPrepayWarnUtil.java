package iih.bl.comm.util;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.TypeEnum;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.dto.d.BlPrepayWarnHitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 预交金警告策略数据处理工具类
 * @author ly 2019/03/03
 *
 */
public class BlPrepayWarnUtil {

	private static final FDouble MIN = new FDouble(-100000000);
	
	/**
	 * 获取预交金警告策略
	 * @param codeEntp 就诊类型
	 * @param depIds 就诊科室
	 * @param patcaIds 患者分类
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
 	public static BdPreWarnDO[] getPreWarnSetting(String codeEntp) throws BizException {

		//String whereSql = "code_entp = ? and (eu_prewarntp = ? or (eu_prewarntp = ? and %s)) and %s";
		//String depCond = SqlUtils.getInSqlByIds("id_dep", depIds);
		//String patcaCond = SqlUtils.getInSqlByIds("id_patca", patcaIds);
		//whereSql = String.format(whereSql, depCond, patcaCond);
		
		String whereSql = "code_entp = ? ";
		whereSql = EnvContextUtil.processEnvContext(whereSql, new BdPreWarnDO(), false);		
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(codeEntp);
		//sqlParam.addParam(TypeEnum.WHOLEHOS);
		//sqlParam.addParam(TypeEnum.DEPARTMENT);
		//for (String str : depIds) {
		//	sqlParam.addParam(str);
		//}
		//for (String str : patcaIds) {
		//	sqlParam.addParam(str);
		//}
		
		DAFacade daf = new DAFacade();
		List<BdPreWarnDO> warnDOList = (List<BdPreWarnDO>)daf.findByCond(BdPreWarnDO.class, whereSql, sqlParam);
		
		if(ListUtil.isEmpty(warnDOList))
			return null;
		
		return warnDOList.toArray(new BdPreWarnDO[0]);
	}
	
	/**
	 * 命中警告策略
	 * (带上下文缓存处理)
	 * @param warnDos
	 * @param depId 科室
	 * @param patcaId 患者分类
	 * @param nurId 病区
	 * @param hppatcaId 医保患者分类
	 * @return
	 * @throws BizException
	 */
	public static BdPreWarnDO hitPreWarnSetting(BdPreWarnDO[] warnDos, BlPrepayWarnHitDTO warnhitDto) throws BizException {
		
		if(ArrayUtil.isEmpty(warnDos))
			return null;
		
		BdPreWarnDO warnDO = null;
		
		String key = IBlFlowKeyConst.BL_FLOW_KEY + warnhitDto.getDepId() + warnhitDto.getNurId() + warnhitDto.getPatcaId() + warnhitDto.getHppatcaId();
		Object obj = Context.get().getAttribute(key);
		if (obj != null) {
			warnDO = (BdPreWarnDO) obj;
			return warnDO;
		}
		
		//科室及病区配置
		warnDO = hitPreWarnDepAndNur(warnDos, warnhitDto);
		if(warnDO != null){
			Context.get().setAttribute(key, warnDO);
			resetWarn(warnDO);
			return warnDO;
		}
		
		//科室配置
		warnDO = hitPreWarnDep(warnDos, warnhitDto);
		if(warnDO != null){
			Context.get().setAttribute(key, warnDO);
			resetWarn(warnDO);
			return warnDO;
		}
		
		//病区配置
		warnDO = hitPreWarnNur(warnDos, warnhitDto);
		if(warnDO != null){
			Context.get().setAttribute(key, warnDO);
			resetWarn(warnDO);
			return warnDO;
		}
		
		//全院配置
		warnDO = hitPreWarnWhole(warnDos, warnhitDto);
		if(warnDO != null){
			Context.get().setAttribute(key, warnDO);
			resetWarn(warnDO);
		}
		
		return warnDO;
	}
	
	/**
	 * 命中科室病区策略
	 * @param warnDos
	 * @param warnhitDto
	 * @return
	 */
	private static BdPreWarnDO hitPreWarnDepAndNur(BdPreWarnDO[] warnDos,BlPrepayWarnHitDTO warnhitDto){
		
		if(StringUtil.isEmpty(warnhitDto.getDepId()) || StringUtil.isEmpty(warnhitDto.getNurId()))
			return null;
		
		BdPreWarnDO warnDO = null;
		List<BdPreWarnDO> leastHitList = new ArrayList<BdPreWarnDO>();
		
		for (BdPreWarnDO warnSet : warnDos) {
			
			if (!TypeEnum.WARDANDDEPT.equals(warnSet.getEu_prewarntp()))
				continue;
		
			if(!warnhitDto.getDepId().equals(warnSet.getId_dep()) || !warnhitDto.getNurId().equals(warnSet.getId_dep_nur()))
				continue;
			
			leastHitList.add(warnSet);
		}
		
		if(!ListUtil.isEmpty(leastHitList)){
			warnDO = hitPreWarnPatCa(leastHitList.toArray(new BdPreWarnDO[0]), warnhitDto);
		}
		
		return warnDO;
	}
	
	/**
	 * 命中科室策略
	 * @param warnDos
	 * @param warnhitDto
	 * @return
	 */
	private static BdPreWarnDO hitPreWarnDep(BdPreWarnDO[] warnDos, BlPrepayWarnHitDTO warnhitDto){
		
		if(StringUtil.isEmpty(warnhitDto.getDepId()))
			return null;
		
		BdPreWarnDO warnDO = null;
		List<BdPreWarnDO> leastHitList = new ArrayList<BdPreWarnDO>();
		
		for (BdPreWarnDO warnSet : warnDos) {

			if (!TypeEnum.DEPARTMENT.equals(warnSet.getEu_prewarntp()))
				continue;
			
			if(!warnhitDto.getDepId().equals(warnSet.getId_dep()))
				continue;
			
			leastHitList.add(warnSet);
		}
		
		if(!ListUtil.isEmpty(leastHitList)){
			warnDO = hitPreWarnPatCa(leastHitList.toArray(new BdPreWarnDO[0]), warnhitDto);
		}
		
		return warnDO;
	}
	
	/**
	 * 命中病区策略
	 * @param warnDos
	 * @param warnhitDto
	 * @return
	 */
	private static BdPreWarnDO hitPreWarnNur(BdPreWarnDO[] warnDos, BlPrepayWarnHitDTO warnhitDto){
		
		if(StringUtil.isEmpty(warnhitDto.getNurId()))
			return null;
		
		BdPreWarnDO warnDO = null;
		List<BdPreWarnDO> leastHitList = new ArrayList<BdPreWarnDO>();
		
		for (BdPreWarnDO warnSet : warnDos) {

			if (!TypeEnum.WARD.equals(warnSet.getEu_prewarntp()))
				continue;
			
			if(!warnhitDto.getNurId().equals(warnSet.getId_dep_nur()))
				continue;
			
			leastHitList.add(warnSet);
		}
		
		if(!ListUtil.isEmpty(leastHitList)){
			warnDO = hitPreWarnPatCa(leastHitList.toArray(new BdPreWarnDO[0]), warnhitDto);
		}
		
		return warnDO;
	}
	
	/**
	 * 命中全局策略
	 * @param warnDos
	 * @param warnhitDto
	 * @return
	 */
	private static BdPreWarnDO hitPreWarnWhole(BdPreWarnDO[] warnDos, BlPrepayWarnHitDTO warnhitDto){
		
		BdPreWarnDO warnDO = null;
		List<BdPreWarnDO> leastHitList = new ArrayList<BdPreWarnDO>();
		
		for (BdPreWarnDO warnSet : warnDos) {

			if (!TypeEnum.WHOLEHOS.equals(warnSet.getEu_prewarntp()))
				continue;
			
			leastHitList.add(warnSet);
		}
		
		if(!ListUtil.isEmpty(leastHitList)){
			warnDO = hitPreWarnPatCa(leastHitList.toArray(new BdPreWarnDO[0]), warnhitDto);
		}
		
		return warnDO;
	}

	/**
	 * 命中匹配患者分类患者医保分类最佳策略
	 * @param warnDos
	 * @param warnhitDto
	 * @return
	 */
	private static BdPreWarnDO hitPreWarnPatCa(BdPreWarnDO[] warnDos, BlPrepayWarnHitDTO warnhitDto) {
		
		//全匹配直接返回
		//只匹配患者分类3分
		//只匹配医保患者分类2分
		//全空1分
		
		int maxWeight = 0;
		BdPreWarnDO warn = null;
		for (BdPreWarnDO bdPreWarnDO : warnDos) {
			
			if(!StringUtil.isEmpty(bdPreWarnDO.getId_patca()) && 
					!StringUtil.isEmpty(bdPreWarnDO.getId_hppatca())){
			
				if(bdPreWarnDO.getId_patca().equals(warnhitDto.getPatcaId()) && 
						bdPreWarnDO.getId_hppatca().equals(warnhitDto.getHppatcaId())){
					return bdPreWarnDO;
				}
				continue;
			}
			
			if(!StringUtil.isEmpty(bdPreWarnDO.getId_patca())){
				if(bdPreWarnDO.getId_patca().equals(warnhitDto.getPatcaId())){
					
					if (maxWeight < 3) {
						maxWeight = 3;
						warn = bdPreWarnDO;
					}
				}
				continue;
			}
			
			if(!StringUtil.isEmpty(bdPreWarnDO.getId_hppatca())){
				if(bdPreWarnDO.getId_patca().equals(warnhitDto.getPatcaId())){
					
					if (maxWeight < 2) {
						maxWeight = 2;
						warn = bdPreWarnDO;
					}
				}
				continue;
			}
			
			maxWeight = 1;
			warn = bdPreWarnDO;
		} 
		
		return warn;
	}
	
	/**
	 * 不控制时重设金额
	 * @param warnDO
	 */
	private static void resetWarn(BdPreWarnDO warnDO){
		
		if(FBoolean.FALSE.equals(warnDO.getFg_prewarn())){
			warnDO.setLimit(MIN);
			warnDO.setP_control(MIN);
			warnDO.setF_control(MIN);
		}else{
			if(warnDO.getF_control() == null){
				warnDO.setF_control(MIN);
			}
		}
	}
}
