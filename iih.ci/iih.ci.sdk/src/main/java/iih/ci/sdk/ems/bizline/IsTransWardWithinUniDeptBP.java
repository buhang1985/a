package iih.ci.sdk.ems.bizline;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
  * 是否在相同就诊科室内部进行病区的转移判断操作BP
  * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
 */
public class IsTransWardWithinUniDeptBP {
	/**
	 * 是否在相同就诊科室内部进行病区的转移判断
	 * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CiOrderDO ordo)  throws BizException{
		//有效性判断
		if(ObjectUtils.isEmpty(ordo))return FBoolean.FALSE;
		
		//是否是转科医嘱
		if(!ordo.getSd_srvtp().contains(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT) ) {
			return FBoolean.FALSE;
		}
		
		//获得转科申请
		OrdApTransDO[] transdeptdos= ServiceFinder.find(ICiorapptransdeptRService.class).findByAttrValString(OrdApTransDO.ID_OR, ordo.getId_or());
		if(ObjectUtils.isEmpty(transdeptdos)) {
			return FBoolean.FALSE;
		}
		
		//是否是同一就诊科室下转病区医嘱判断
		if(!ObjectUtils.isEmpty(transdeptdos[0].getId_dep_from()) && 
				!ObjectUtils.isEmpty(transdeptdos[0].getId_dep_to()) && 
				transdeptdos[0].getId_dep_from().equals(transdeptdos[0].getId_dep_to())){
			return FBoolean.TRUE;
		}
		
		//返回值
		return FBoolean.FALSE;
	}
	/**
	 * 是否在相同就诊科室内部进行病区的转移判断
	 * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
	 * @param id_org
	 * @param id_dep_or
	 * @param id_ward_from
	 * @param id_ward_to
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_org,String id_dep_or,String id_ward_from,String id_ward_to)  throws BizException{
		//获得就诊科室对应的所有病区
		String[] depids=getDeptIDsOfWard8BizLine(id_org, id_dep_or, FBoolean.FALSE);
		
		//有效性判断
		if(ObjectUtils.isEmpty(depids))return FBoolean.FALSE;
		
		//返回值
		return isAllDeptsIn(depids,id_ward_from,id_ward_to);
	}
	
	/**
	 * 来源去向病区是否对应相同就诊病区判断
	 * @param depids
	 * @param id_ward_from
	 * @param id_ward_to
	 * @return
	 */
	private FBoolean isAllDeptsIn(String[] depids,String id_ward_from,String id_ward_to){
		boolean isF=false,isT=false;
		for(int i=0;i<depids.length;i++){
			if(depids[i].equals(id_ward_from)){isF=true;}
			if(depids[i].equals(id_ward_to)){isT=true;}
			if(isF && isT)return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 根据业务线概念获得病区对应的科室主键集合信息
	 * @param id_org
	 * @param id_ward
	 * @return
	 * @throws BizException
	 */
	private String[] getDeptIDsOfWard8BizLine(String id_org,String id_ward,FBoolean isward) throws BizException{
		GetDeptIDs8DepWardRelBlTpBP bp=new GetDeptIDs8DepWardRelBlTpBP();
		return bp.exec(id_org, id_ward,isward);
	}
}
