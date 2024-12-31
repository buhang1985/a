package iih.ci.ord.s.bp.validate;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.cior.d.CiorderAggExtDO;
import iih.ci.ord.cior.d.OrReactType;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrValidFgLongOrQryBP;
import iih.ci.ord.s.bp.CiOrValidGrpInReactOrQryBP;
import iih.ci.ord.s.bp.exception.ExcludeAllGrpInCoExistException;
import iih.ci.ord.s.bp.exception.ExcludeAllOrCntGt1Exception;
import iih.ci.ord.s.bp.exception.ExcludeAllOrSrvMultiException;
import iih.ci.ord.s.bp.exception.GrpInExcludeSrvMutliException;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/*
 * 医嘱中服务互斥检查与处理操作BP
 * 医嘱保存时使用
 */
public class SrvMutexValidateBP {
	/**
	 * 医嘱中服务互斥检查与处理
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		//有效性校验
		if(aggors==null||aggors.length>0)return;
		
		//获得医嘱集合中医嘱服务项目的互斥服务集合
		SrvReactDTO[] srvreacts=getOrSrvReactInfos(aggors);
		if(srvreacts==null || srvreacts.length==0)return;//医嘱互斥项目检查
		
		//对服务互斥数据进行分组处理
		Hashtable<String, ArrayList<SrvReactDTO>> reactht = CiOrdUtils
				.getSrvReactHt(srvreacts);
		
		//存在全排医嘱
		if(reactht.containsKey(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL)){
			ArrayList<SrvReactDTO> reactalls=reactht.get(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL);
			if(reactalls.size()>1){
				throw new ExcludeAllOrSrvMultiException();  //医嘱保存时，医嘱项目中存在多个全排项目错误！
			}
			if(reactht.size()>1){
				throw new ExcludeAllGrpInCoExistException();//医嘱保存时，医嘱项目中全排与组内排斥项目同时存在错误!
			}
		}else{
			if(reactht.size()>0){//组内排斥医嘱的情况
				ArrayList<SrvReactDTO> grpinreactlist=null;
				for(String key:reactht.keySet()){
					grpinreactlist=reactht.get(key);
					if(grpinreactlist!=null && grpinreactlist.size()>1){
						throw new GrpInExcludeSrvMutliException();//医嘱保存时，医嘱项目中同组内排斥项目同时存在异常
					}
				}
			}
		}
	}
	
	/**
	 * 医嘱中服务互斥检查与处理
	 * @throws BizException
	 */
	public String exec4Ip(CiorderAggDO[] aggors) throws BizException{
		// 有效性校验
		if (aggors == null || aggors.length > 0)
			return null;
		
		// 获得医嘱集合中医嘱服务项目的互斥服务集合
		SrvReactDTO[] srvreacts = getOrSrvReactInfos(aggors);
		if (srvreacts == null || srvreacts.length == 0)
			return null;// 医嘱互斥项目检查
		
		//对服务互斥数据进行分组处理
		Hashtable<String, ArrayList<SrvReactDTO>> reactht = CiOrdUtils.getSrvReactHt(srvreacts);
		
		//存在全排医嘱
		if(reactht.containsKey(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL)){
			ArrayList<SrvReactDTO> reactalls=reactht.get(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL);
			if (reactalls.size() > 1) {
				return "医嘱项目中存在多个全排项目错误"; // 医嘱保存时，医嘱项目中存在多个全排项目错误！
			}
			if (reactht.size() > 1) {
				return "医嘱项目中全排与组内排斥项目同时存在错误"; // 医嘱保存时，医嘱项目中全排与组内排斥项目同时存在错误!
			}
		}else{
			if (reactht.size() > 0) {// 组内排斥医嘱的情况
				ArrayList<SrvReactDTO> grpinreactlist = null;
				for (String key : reactht.keySet()) {
					grpinreactlist = reactht.get(key);
					if (grpinreactlist != null && grpinreactlist.size() > 1) {
						return "医嘱项目中同组内排斥项目同时存在异常"; // 医嘱保存时，医嘱项目中同组内排斥项目同时存在异常
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 临床医嘱签署时，获得服务互斥信息数据
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private SrvReactDTO[] getOrSrvReactInfos(CiorderAggDO[] aggors) throws BizException{
		CiOrSignOrSrvReactInfoGetBP bp=new CiOrSignOrSrvReactInfoGetBP();
		return bp.exec(aggors);
	}
	
	/**
	 * 医嘱互斥检查与处理
	 * 返回 要停止的医嘱
	 * @param aggors
	 * @param dt_cur
	 * @return 
	 * @throws BizException
	 */
	public List<ReactExtOrsAndStopOrsDO> exec(CiorderAggDO[] aggors, FDateTime dt_effe) throws BizException{
		//有效性校验
		if(!validateCheck(aggors))return null;
		List<String> errorList=new ArrayList<String>();
		List<ReactExtOrsAndStopOrsDO> rtns=new ArrayList<ReactExtOrsAndStopOrsDO>();
		
		//获得医嘱集合中医嘱服务项目的互斥服务集合
		SrvReactDTO[] srvreacts=getOrSrvReactInfos(aggors);
		if(srvreacts==null || srvreacts.length==0)return null;//医嘱互斥项目检查
		String id_en=aggors[0].getParentDO().getId_en();
		//参数设置
		CiOrderDO[] willstoporders=null;

		//设置医嘱的排斥类型
		CiorderAggExtDO[] oraggextinfos=getReactExtAggDOInfo(aggors,srvreacts);

		//获得全排相关医嘱信息 0全排个数 1长期医嘱个数  2全排医嘱索引号   3长期医嘱索引号
		int[] iexallinfos=getExcludeAllOrInfos(oraggextinfos);

		//全排斥判断逻辑
		if(iexallinfos[0]==1){
			//只有一条全排医嘱时，停止所有已签署、未作废确认、未停止确认的长期医嘱
			ReactExtOrsAndStopOrsDO rtnDTO=new ReactExtOrsAndStopOrsDO();
			rtnDTO.setSd_reacttp(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL);
			rtnDTO.setReactextdo(oraggextinfos[iexallinfos[2]].getAggdo());
			dt_effe=oraggextinfos[iexallinfos[2]].getAggdo().getParentDO().getDt_effe();
			rtnDTO.setStopordos(getExcludeAllValidFgLongOrs(id_en,dt_effe));
			rtns.add(rtnDTO);
		}else if(iexallinfos[0]>1){
			//全排医嘱为多个时，提示不可签署
			StringBuffer errorMsg=new StringBuffer();
			for(CiorderAggExtDO ordAggExt:oraggextinfos){
				if(OrReactType.EXCLUDEALL.equals(ordAggExt.getReacttype())){
					errorMsg.append("、");
					errorMsg.append(ordAggExt.getAggdo().getParentDO().getName_or());
				}
			}

			if(errorMsg.length()>0){
				errorList.add(errorMsg.toString().substring(1,errorMsg.length()) + "为全排医嘱，不允许同时签署");
			}
		}
		//非全排情形的业务逻辑
		//获得组内排斥相关信息 
		//组内排斥医嘱个数  组内排斥组所对应的医嘱集合  排斥组id串
		Object[] oexgrpininfos=getExcludeGrpInOrInfos(oraggextinfos);
		if(oexgrpininfos.length>0){
			//组内排斥判断逻辑
			if((int)oexgrpininfos[0]!=0){
				Hashtable<String,ArrayList<CiorderAggExtDO>> ht=(Hashtable<String,ArrayList<CiorderAggExtDO>>)oexgrpininfos[1];
				String key=isReactGrpMutliOr(ht);
				if(!CiOrdUtils.isEmpty(key)){//待签医嘱中，同一个排斥组是否存在多个医嘱判断
					ArrayList<CiorderAggExtDO> list=ht.get(key); 
					//					throw new GrpInReactExistMultiOrException(getOrNames(list));
					StringBuffer errorMsg=new StringBuffer();
					for(CiorderAggExtDO ordAggExt:list){
						errorMsg.append("、");
						errorMsg.append(ordAggExt.getAggdo().getParentDO().getName_or());
					}

					if(errorMsg.length()>0){
						errorList.add(errorMsg.toString().substring(1,errorMsg.length()) + "为同组组排医嘱，不允许同时签署");
					}

				}else{
					//组排医嘱时，停止所有已签署、未作废确认、未停止确认的同组长期医嘱
					ReactExtOrsAndStopOrsDO rtnDTO=new ReactExtOrsAndStopOrsDO();
					rtnDTO.setSd_reacttp(IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE);
					rtnDTO.setReactextdo(oraggextinfos[0].getAggdo());
					dt_effe=oraggextinfos[0].getAggdo().getParentDO().getDt_effe();
					rtnDTO.setStopordos(getGrpInValidFgLongOrs(id_en,(String)oexgrpininfos[2],dt_effe));
					rtns.add(rtnDTO);
				}
			}			
		}
		if(errorList.size()>0){
			StringBuffer errorMsg=new StringBuffer();
			int sortn=1;
			for(String erro:errorList){
				errorMsg.append(sortn+"."+erro);
				errorMsg.append("\n");
				sortn++;
			}
			throw new ExcludeAllOrCntGt1Exception(errorMsg.toString());
		}
		//返回排斥相关停止的医嘱集合
		return rtns;

	}
	/**
	 * 校验存在互斥服务项目时，有几个医嘱（医嘱互斥时，排斥医嘱限制单条操作，如果多条，请提示“XX医嘱为排斥医嘱，请先确认其他医嘱！）
	 * @param aggors
	 * @param srvreacts
	 * @return
	 * @throws BizException 
	 */
	private List<CiorderAggDO> getReactOrds(CiorderAggDO[] aggors,SrvReactDTO[] srvreacts){
		List<CiorderAggDO> reactAggs = new ArrayList<CiorderAggDO>();
		for(CiorderAggDO agg : aggors){
			OrdSrvDO[] srvDOs = agg.getOrdSrvDO();
			for(OrdSrvDO srvdo : srvDOs){
				for(SrvReactDTO react : srvreacts){
					if(srvdo.getId_srv().equals(react.getId_srv())){
						if(!reactAggs.contains(agg)){
							reactAggs.add(agg);
						}
					}
				}
			}
		}
		return reactAggs;
	}
	/**
	 * 获得医嘱名称数组
	 * @param list
	 * @return
	 */
	private String[] getOrNames(ArrayList<CiorderAggExtDO> list){
		//有效性校验
		if(list==null || list.size()==0)return null;

		//参数定义
		String[] rtns=new String[list.size()];

		//遍历
		for(int i=0;i<list.size();i++){
			rtns[i]=list.get(i).getAggdo().getParentDO().getName_or();
		}
		return rtns;
	}

	/**
	 * 待签医嘱中，同一个排斥组是否存在多个医嘱判断
	 * @param ht
	 * @return
	 */
	private String isReactGrpMutliOr(Hashtable<String,ArrayList<CiorderAggExtDO>> ht){
		for(String key:ht.keySet()){
			if(ht.get(key).size()>1){
				return key;
			}
		}
		return null;
	}

//	/**
//	 * 临床医嘱签署时，获得服务互斥信息数据
//	 * @param aggors
//	 * @return
//	 * @throws BizException
//	 */
//	private SrvReactDTO[] getOrSrvReactInfos(CiorderAggDO[] aggors) throws BizException{
//		CiOrSignOrSrvReactInfoGetBP bp=new CiOrSignOrSrvReactInfoGetBP();
//		return bp.exec(aggors);
//	}

	/**
	 * 获得医嘱聚集扩展信息实体（设置医嘱的排斥类型）
	 * @param aggors
	 * @param srvreacts
	 * @return
	 * @throws BizException
	 */
	private CiorderAggExtDO[] getReactExtAggDOInfo(CiorderAggDO[] aggors,SrvReactDTO[] srvreacts) throws BizException{
		CiOrSignReactExtAggDOGetBP bp=new CiOrSignReactExtAggDOGetBP();
		return bp.exec(aggors, srvreacts);
	}

	/**
	 * 获得医嘱全排相关信息
	 * @param oraggextinfos
	 * @return
	 */
	private int[] getExcludeAllOrInfos(CiorderAggExtDO[] oraggextinfos){
		ArrayList<CiorderAggDO> reactallors=new ArrayList<CiorderAggDO>();
		int iL_fglong=0,fglong_index=-1,reactall_index=-1;
		for(int i=0;i<oraggextinfos.length;i++){
			//全排医嘱判断
			if(OrReactType.EXCLUDEALL.equals(oraggextinfos[i].getReacttype())){//BdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL
				reactall_index=i;
				reactallors.add(oraggextinfos[i].getAggdo());
			}else{//非全排时是否存在长期医嘱判断
				if(oraggextinfos[i].getAggdo().getParentDO().getFg_long().booleanValue()){
					iL_fglong+=1;
					fglong_index=i;
				}
			}
		}
		return new int[]{reactallors.size(),iL_fglong,reactall_index,fglong_index};
	}




	/**
	 * 获得医嘱组排相关信息
	 * 组内排斥医嘱个数  组内排斥组所对应的医嘱集合  排斥组id串
	 * @param oraggextinfos
	 * @return
	 */
	private Object[] getExcludeGrpInOrInfos(CiorderAggExtDO[] oraggextinfos){
		//参数设置
		int iL_grpin=0;
		String[] tms=null;
		String key="";
		String grpinreactids="";
		Hashtable<String,ArrayList<CiorderAggExtDO>> ht=new Hashtable<String,ArrayList<CiorderAggExtDO>>();
		ArrayList<CiorderAggExtDO> list=null;
		//遍历
		for(int i=0;i<oraggextinfos.length;i++){
			if(OrReactType.EXCLUDEGRPIN_SINGLE.equals(oraggextinfos[i].getReacttype()) || 
					OrReactType.EXCLUDEGRPIN_MULTI.equals(oraggextinfos[i].getReacttype())){
				iL_grpin+=1;
				tms=oraggextinfos[i].getId_reacts().split(CiOrdUtils.COMMA_STR);
				for(int j=0;j<tms.length;j++){
					key=tms[j];
					if(ht.containsKey(key)){
						ht.get(key).add(oraggextinfos[i]);
					}else{
						grpinreactids+=CiOrdUtils.COMMA_STR+key;
						list=new ArrayList<CiorderAggExtDO>();
						list.add(oraggextinfos[i]);
						ht.put(key,list);
					}
				}
			}
		}
		if(!grpinreactids.equals(""))grpinreactids=grpinreactids.substring(1);
		return new Object[]{iL_grpin,ht,grpinreactids};
	}

	/**
	 * 获得临床在执行的有效长期医嘱（全排斥时使用）
	 * @param id_en
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] getExcludeAllValidFgLongOrs(String id_en,FDateTime dt_cur) throws BizException{
		//获得在执行的有效长期医嘱
		CiOrValidFgLongOrQryBP bp=new CiOrValidFgLongOrQryBP();
		return bp.exec(id_en, dt_cur);
	}

	/**
	 * 获得临床在执行的有效长期医嘱（组内排斥时使用）
	 * @param id_en
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] getGrpInValidFgLongOrs(String id_en,String id_srvreacts,FDateTime dt_cur) throws BizException{
		//获得在执行的有效长期医嘱
		CiOrValidGrpInReactOrQryBP bp=new CiOrValidGrpInReactOrQryBP();
		return bp.exec(id_en,id_srvreacts, dt_cur);

	}

	/**
	 * 有效性校验
	 * @param aggors
	 * @return
	 */
	public boolean validateCheck(CiorderAggDO[] aggors){
		if(aggors==null || aggors.length==0)return false;
		if(!CiOrdUtils.isIpWf(aggors[0].getParentDO().getCode_entp()))return false;

		return true;
	}

}
