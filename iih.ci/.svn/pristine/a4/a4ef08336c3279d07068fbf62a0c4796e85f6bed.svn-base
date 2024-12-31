package iih.ci.ord.s.bp.ems.save.ip;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.op.GetCiRelSrvInfo8RelSrvTacticBP;
import xap.mw.core.data.BizException;

/*
 * 获得医疗单关联服务数据信息操作BP
 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息 
 */
public class GetRelBdSrv8InfluFactorsBP {
	/**
	 * 获得医疗单关联服务数据信息
	 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息
	 * @param param
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public UsageRelFeeSrvDO[] exec(BdRelSrvParamDTO param)  throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//有效性校验 
		if(!isValidateCheck(param))return null;
		
		//获得匹配的关联服务DO数据
		RelSrvTacticDO[] relsrvdos=CiOrdUtils.getRelSrvTacticDOs(param);
		if(CiOrdUtils.isEmpty(relsrvdos))return null; //有效性判断
		
		//获得关联服务数据信息
		return GetCiRelSrvInfo(relsrvdos,param);
	}
	/**
	 * 获得医疗单关联服务数据信息,管理单据的
	 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息
	 * @param param
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public UsageRelFeeSrvDO[] getOrdRelFees(BdRelSrvParamDTO param)  throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//有效性校验 
		if(!isValidateCheck(param))return null;
		
		//获得匹配的关联服务DO数据
		RelSrvTacticDO[] relsrvdos=CiOrdUtils.getRelSrvTacticDOs(param);
		if(CiOrdUtils.isEmpty(relsrvdos))return null; //有效性判断
		//管理医嘱类型的服务
		List<RelSrvTacticDO> relSheetSrvs = new ArrayList<RelSrvTacticDO>();
		for (RelSrvTacticDO relSrvTacticDO : relsrvdos) {
			if(ICiDictCodeConst.SD_RELSRVTRIGGERTP_ORDER.equals(relSrvTacticDO.getSd_relsrvtriggertp())){
				relSheetSrvs.add(relSrvTacticDO);
			}
		}
		relsrvdos = relSheetSrvs.toArray(new RelSrvTacticDO[0]);
		//获得关联服务数据信息
		return GetCiRelSrvInfo(relsrvdos,param);
	}
	/**
	 * 获得医疗单关联服务数据信息,管理单据的
	 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息
	 * @param param
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public UsageRelFeeSrvDO[] getSheetAppRelFees(BdRelSrvParamDTO param)  throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//有效性校验 
		if(!isValidateCheck(param))return null;
		
		//获得匹配的关联服务DO数据
		RelSrvTacticDO[] relsrvdos=CiOrdUtils.getRelSrvTacticDOs(param);
		if(CiOrdUtils.isEmpty(relsrvdos))return null; //有效性判断
		//管理单据类型的服务
		List<RelSrvTacticDO> relSheetSrvs = new ArrayList<RelSrvTacticDO>();
		for (RelSrvTacticDO relSrvTacticDO : relsrvdos) {
			if(ICiDictCodeConst.SD_RELSRVTRIGGERTP_APPSHEET.equals(relSrvTacticDO.getSd_relsrvtriggertp())){
				relSheetSrvs.add(relSrvTacticDO);
			}
		}
		relsrvdos = relSheetSrvs.toArray(new RelSrvTacticDO[0]);
		//获得关联服务数据信息
		return GetCiRelSrvInfo(relsrvdos,param);
	}
	/**
	 * 有效性校验
	 * @param param
	 * @return
	 */
	private boolean isValidateCheck(BdRelSrvParamDTO param){
		if(CiOrdUtils.isEmpty(param)) return false;
		if(CiOrdUtils.isEmpty(param.getId_org()) || 
				CiOrdUtils.isEmpty(param.getCode_entp()) ||
				CiOrdUtils.isEmpty(param.getId_bizs1()))return false;
		return true;
	}
	
	/**
	 * 获得临床关联服务数据信息
	 * @param relsrvdos
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private UsageRelFeeSrvDO[] GetCiRelSrvInfo(RelSrvTacticDO[] relsrvdos,BdRelSrvParamDTO param) throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		GetCiRelSrvInfo8RelSrvTacticBP bp=new GetCiRelSrvInfo8RelSrvTacticBP();
		return bp.exec(relsrvdos,param);
	}
	
}
