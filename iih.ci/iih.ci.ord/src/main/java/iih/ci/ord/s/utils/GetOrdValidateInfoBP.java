package iih.ci.ord.s.utils;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkOrDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltItmDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkSrvDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 校验【医嘱流向整体控制】节点科室排斥信息
 * @author F
 *
 * @date 2019年12月26日上午10:45:50
 *
 * @classpath iih.ci.ord.s.utils.GetOrdValidateInfoBP
 */
public class GetOrdValidateInfoBP {
	
	/**
	 * mantis:0176396 获取【医嘱流向整体控制】排斥信息 门诊住院 模板 服务 直接开立用到该逻辑 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public String getOrdWhDeptValidateInfo(CiEmsDTO ems) throws BizException{
		if(CiOrdUtils.isEmpty(ems)) {//医疗单为空返回
			return null;
		}
		//组装主表入参
		List<OrWfOvalChkOrDTO> fArrayList=new ArrayList<OrWfOvalChkOrDTO>();
		OrWfOvalChkOrDTO orDTO=new OrWfOvalChkOrDTO();
		orDTO.setCode_or(ems.getCode());//医嘱编码(统一用的医疗单编号，唯一就行)
		orDTO.setCode_entp(ems.getCode_entp());//就诊类型
		orDTO.setFg_urgent(ems.getFg_urgent());//加急标识
		orDTO.setFg_pres_outp(ems.getFg_pres_outp());//出院带药标识
		//组装子表集合入参
		FArrayList list=ems.getEmssrvs();
		if(CiOrdUtils.isEmpty(list)) {
			return null;
		}
		FArrayList newList=new FArrayList();
		for(int i=0;i<list.size();i++) {
			CiEmsSrvDTO ciEmsSrvDTO=(CiEmsSrvDTO)list.get(i);
			//删除的 没有仓库的不校验
			if(CiOrdUtils.isEmpty(ciEmsSrvDTO) || ciEmsSrvDTO.getStatus()==DOStatus.DELETED || CiOrdUtils.isEmpty(ciEmsSrvDTO.getId_dep_wh())) {
				continue;
			}
			OrWfOvalChkSrvDTO chkSrvDTO=new OrWfOvalChkSrvDTO();
			chkSrvDTO.setSd_srvtp(ciEmsSrvDTO.getSd_srvtp());//服务类型编码
			chkSrvDTO.setId_dep_wh(ciEmsSrvDTO.getId_dep_wh());//仓库
			chkSrvDTO.setId_dep_mp(ems.getId_dep_mp());//执行科室
			chkSrvDTO.setFg_or(ciEmsSrvDTO.getFg_or());//主医嘱标识
			chkSrvDTO.setFg_mm(ciEmsSrvDTO.getFg_mm());//物品标识
			chkSrvDTO.setFg_outdeptadmt(FBoolean.FALSE);//目标科室外执行
			newList.add(chkSrvDTO);
		}
		if (CiOrdUtils.isEmpty(newList)) {
			return null;//组装完的子表集合有为空的情况，传去后会提示异常信息，故直接返回
		}
		orDTO.setArraysrv(newList);
		fArrayList.add(orDTO);
		//调用接口校验
		IBdFcQryService service = (IBdFcQryService)ServiceFinder.find(IBdFcQryService.class.getName());
		OrWfOvalChkRltDTO[] result=service.getOrWfOvalChkRlt(fArrayList.toArray(new OrWfOvalChkOrDTO[0]));
		//获取返回信息 拼接
		String errorMsg="";
		errorMsg=concatErrorMsgString(errorMsg, result);
		if(!CiOrdUtils.isEmpty(errorMsg)) {
			return errorMsg;
		}
		return null;
	}
	/**
	 * mantis:0176396 获取【医嘱流向整体控制】排斥信息 门诊住院复制 门诊历史用到该逻辑
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	public String getOrdWhDeptValidateInfo(CiorderAggDO[] aggDOs) throws BizException{
		if(CiOrdUtils.isEmpty(aggDOs)) {
			return null;
		}
		String errorMsg="";
		for(CiorderAggDO aggDO:aggDOs) {
			CiOrderDO ciOrderDO=aggDO.getParentDO();
			OrdSrvDO[] ordSrvDOs=aggDO.getOrdSrvDO();
			if(CiOrdUtils.isEmpty(ciOrderDO)||CiOrdUtils.isEmpty(ordSrvDOs)) {
				continue;
			}
			List<OrWfOvalChkOrDTO> fArrayList=new ArrayList<OrWfOvalChkOrDTO>();
			OrWfOvalChkOrDTO orDTO=new OrWfOvalChkOrDTO();
			orDTO.setCode_or(ciOrderDO.getCode_or());
			orDTO.setCode_entp(ciOrderDO.getCode_entp());
			orDTO.setFg_urgent(CiOrdUtils.getFgUrgent(ciOrderDO.getId_srv(), ciOrderDO.getCode_entp()));//bug:0179687;加急改造，修改2020-01-14 liyuelong 如果就诊历史和医嘱模板开立服务时，决定是否显示加急，和加急赋值由诊疗项目中维护决定的，跟之前加急是什么没关系
			orDTO.setFg_pres_outp(ciOrderDO.getFg_pres_outp());
			FArrayList newList=new FArrayList();
			for(int i=0;i<ordSrvDOs.length;i++) {
				OrdSrvDO ordSrvDO=(OrdSrvDO)ordSrvDOs[i];
				if(CiOrdUtils.isEmpty(ordSrvDO) || ordSrvDO.getStatus()==DOStatus.DELETED || CiOrdUtils.isEmpty(ordSrvDO.getId_dep_wh())) {
					continue;
				}
				OrWfOvalChkSrvDTO chkSrvDTO=new OrWfOvalChkSrvDTO();
				chkSrvDTO.setSd_srvtp(ordSrvDO.getSd_srvtp());
				chkSrvDTO.setId_dep_wh(ordSrvDO.getId_dep_wh());
				chkSrvDTO.setId_dep_mp(ciOrderDO.getId_dep_mp());
				chkSrvDTO.setFg_or(ordSrvDO.getFg_or());
				chkSrvDTO.setFg_mm(ordSrvDO.getFg_mm());
				chkSrvDTO.setFg_outdeptadmt(FBoolean.FALSE);
				newList.add(chkSrvDTO);
			}
			if (CiOrdUtils.isEmpty(newList)) {
				continue;//直接跳过 不查询
			}
			orDTO.setArraysrv(newList);
			fArrayList.add(orDTO);
			IBdFcQryService service = (IBdFcQryService)ServiceFinder.find(IBdFcQryService.class.getName());
			OrWfOvalChkRltDTO[] result=service.getOrWfOvalChkRlt(fArrayList.toArray(new OrWfOvalChkOrDTO[0]));
			//拼接错误信息
			errorMsg=concatErrorMsgString(errorMsg,result);
		}
		if(!CiOrdUtils.isEmpty(errorMsg)) {
			return errorMsg;
		}
		return null;
	}
	/**
	 * 拼接错误信息
	 * @param errorMsg
	 * @param result
	 * @return
	 * @throws BizException
	 */
	private String concatErrorMsgString(String errorMsg,OrWfOvalChkRltDTO[] result)throws BizException{
		if(!CiOrdUtils.isEmpty(result)) {
			for(OrWfOvalChkRltDTO res:result) {
				if(res!=null && res.getFg_success()!=null && !res.getFg_success().booleanValue()) {
					if(!CiOrdUtils.isEmpty(res.getArraymsg())) {
						for(int i=0;i<res.getArraymsg().size();i++) {
							OrWfOvalChkRltItmDTO o=(OrWfOvalChkRltItmDTO)res.getArraymsg().get(i);
							if(o!=null && !errorMsg.contains(o.getDes_msg())) {
								errorMsg+=o.getDes_msg()+"\r\n";
							}
						}
					}
				}
			}
		}
		return errorMsg;
	}

}
