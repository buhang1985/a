package iih.bd.srv.s.bp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.oth.d.CommonIDVsDO;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.GetOrRtCtlInfo8RulesQry;
import iih.bd.srv.s.bp.qry.SrvRtCtlInfoNQry;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 获得受权限控制的服务数据集合信息操作BP
 */
public class GetSrvRtCtlInfosNBP {
	/**
	 * 获得受权限控制的服务数据集合信息
	 * @param rtctlparam
	 * @return
	 * @throws BizException
	 */
	public SrvRtCtlDTO[] exec(SrvRtCtlParam rtctlparam)throws BizException {
		//有效性检查
		if(BdSrvUtils.isEmpty(rtctlparam))return null;
		
		//创建查询条件
		SrvRtCtlInfoNQry qry = new SrvRtCtlInfoNQry(rtctlparam);
		SrvRtCtlDTO[] rtn = (SrvRtCtlDTO[])AppFwUtil.getDORstWithDao(qry, SrvRtCtlDTO.class);
		
		//返回值处理
		return getValidateVs(rtn,rtctlparam.getId_srvs());
		
	}
	
	/**
	 * 获得有效服务开立权限数据信息
	 * @param rtn
	 * @return
	 * @throws BizException 
	 */
	private SrvRtCtlDTO[] getValidateVs(SrvRtCtlDTO[] rtn, String id_srvs) throws BizException{
		//有效性校验
		if(BdSrvUtils.isEmpty(rtn))return null;
		
		Map<String, List<SrvRtCtlDTO>> mapSrvRtCtlDTOs = new HashMap<String, List<SrvRtCtlDTO>>();
		for (SrvRtCtlDTO dto : rtn) {
			if (mapSrvRtCtlDTOs.containsKey(dto.getId_srvrtca())) {
				mapSrvRtCtlDTOs.get(dto.getId_srvrtca()).add(dto);
			} else {
				List<SrvRtCtlDTO> lst = new ArrayList<SrvRtCtlDTO>();
				lst.add(dto);
				mapSrvRtCtlDTOs.put(dto.getId_srvrtca(), lst);
			}
		}
		List<String> ruleStrs = new ArrayList<String>();
		for(String key : mapSrvRtCtlDTOs.keySet()) {
			String ruleStr = "";
			for (SrvRtCtlDTO dto : mapSrvRtCtlDTOs.get(key)) {
				ruleStr+=BdSrvUtils.getWhenThenStr(dto.getRules(), dto.getId_srvrt());
			}
			ruleStrs.add( BdSrvUtils.LBRACE_STR + BdSrvUtils.CASE_STR 
					+ ruleStr
					+ BdSrvUtils.ELSE_STR + "''" + BdSrvUtils.END_STR + BdSrvUtils.RBRACE_STR);
		}
		
		//参数定义
		ArrayList<SrvRtCtlDTO> list = new ArrayList<SrvRtCtlDTO>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < rtn.length; i++) {
			if (BdSrvUtils.isTrue(rtn[i].getFg_ructr())) { // 规则表达处理
				if (!BdSrvUtils.isEmpty(rtn[i].getRules())) {
					map.put(rtn[i].getId_srvrt(), i);
				}
			} else {
				list.add(rtn[i]);
			}
		}
		
		//规则判断
		if(!BdSrvUtils.isEmpty(ruleStrs)){
			srvRtInfosHandle(ruleStrs.toArray(new String[0]), id_srvs, list, rtn, map);
		}
		
		if(BdSrvUtils.isEmpty(list))return null;
		return (SrvRtCtlDTO[]) list.toArray((SrvRtCtlDTO[]) Array.newInstance(SrvRtCtlDTO.class, 0));
	}
	
	/**
	 * 医嘱服务项目权限控制相关信息处理逻辑
	 * @param ruleStr  规则串
	 * @param id_srvs  开立医嘱项目串 
	 * @param list     需要开立权限的服务列表
	 * @throws BizException
	 */
	private void srvRtInfosHandle(String[] ruleStrs,String id_srvs,ArrayList<SrvRtCtlDTO> list,SrvRtCtlDTO[] srvctldto,HashMap<String,Integer> map) throws BizException{
		//获得医嘱服务项目是否为权限控制相关信息  id_srv,id_srvrt这个服务有这个权限
		GetOrRtCtlInfo8RulesQry qry = new GetOrRtCtlInfo8RulesQry(id_srvs, ruleStrs);
		CommonIDVsDO[] cmidvs = (CommonIDVsDO[]) AppFwUtil.getDORstWithDao(qry,
				CommonIDVsDO.class);
		
		//为空判断处理
		if(BdSrvUtils.isEmpty(cmidvs))return;
		
		String id_srvrt = "";
		// 遍历
		for (int i = 0; i < cmidvs.length; i++) {
			id_srvrt = cmidvs[i].getV1();
			if (BdSrvUtils.isEmpty(id_srvrt) || BdSrvUtils.isEmpty(map.get(id_srvrt)))
				continue;
			list.add(getSrvRtCtlDTO(srvctldto[map.get(id_srvrt)], cmidvs[i].getId_biz()));
		}
	}
	
	/**
	 * 创建开立服务权限控制数据
	 * @param srvctldto
	 * @param id_srv
	 * @return
	 */
	private SrvRtCtlDTO getSrvRtCtlDTO(SrvRtCtlDTO srvctldto,String id_srv){
		SrvRtCtlDTO rtn=new SrvRtCtlDTO();
		rtn.setId_srv(id_srv);
		rtn.setId_srvrtca(srvctldto.getId_srvrtca());
		rtn.setId_srvrt(srvctldto.getId_srvrt());
		rtn.setId_entp(srvctldto.getId_entp());
		rtn.setCode(srvctldto.getCode());
		rtn.setName(srvctldto.getName());
		rtn.setCtrl5(srvctldto.getCtrl5());
		return rtn;
	}
}
