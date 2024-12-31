package iih.bl.cg.s.bp.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpOrdCgDTO;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import iih.bl.cg.s.bp.qry.GetNotOrderDetailedQry;
import iih.bl.cg.s.bp.qry.GetOrderDetailQry;
import iih.bl.cg.s.bp.qry.GetOrderDetailedQry;
import iih.bl.comm.IBlCgFuncConst;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.dg.dto.dgunchargedto.d.DgUnChargeDTO;
import iih.mp.dg.i.external.provide.IMpDgBlService;
import iih.mp.dg.ipdgapp.d.IpDgApdeItmDO;
import iih.mp.dg.ipdgapp.i.IIpdgapdeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取医嘱计价明细bp
 * @author xy.zhou
 * @date 2018年7月31日
 */
public class GetorderValuationDetailedBp {
	
	private String[] id_srvs = null;
	private String[] id_ors = null;
	private boolean isHp = false;
	private String code_entp = null;
	
	public BlIpOrdCgDTO [] exec(BlOrderValuationQueryParamDTO bQueryParamDTO)throws BizException{
		//参数校验
		paramCheck(bQueryParamDTO);
		
		//判断患者身份
		whereHp(bQueryParamDTO.getId_ent());

		List<BlIpOrdCgDTO> bList=new ArrayList<>();
		if (bQueryParamDTO.getDt_or_entry()==null&&bQueryParamDTO.getDt_or_end()==null
				&&bQueryParamDTO.getId_or()==null&&StringUtil.isEmpty(bQueryParamDTO.getFg_long())&&StringUtil.isEmpty(bQueryParamDTO.getEu_orsrcfun())) {
			//获取非医嘱记账
			BlIpCgDTO[] blIpCgDTOs2=(BlIpCgDTO[]) AppFwUtil.getDORstWithDao(new GetNotOrderDetailedQry(
					bQueryParamDTO.getId_ent(),id_srvs,
					bQueryParamDTO.getId_srvtp(),bQueryParamDTO.getFg_bb(),bQueryParamDTO.getId_emp_or()),BlIpCgDTO.class);

			//组装非医嘱信息
			if (!ArrayUtil.isEmpty(blIpCgDTOs2)) {
				List<BlIpOrdCgDTO> NotOrderList = setNotOrdCg(blIpCgDTOs2);
				bList.addAll(NotOrderList);
			}
		}
		//获取医嘱信息
		BlIpOrdCgDTO[] idulDtos1=(BlIpOrdCgDTO[]) AppFwUtil.getDORstWithDao(new GetOrderDetailQry(
				bQueryParamDTO.getId_ent(),bQueryParamDTO.getDt_or_entry(),bQueryParamDTO.getDt_or_end(),
				id_ors,bQueryParamDTO.getFg_long(),bQueryParamDTO.getId_srvtp(),this.id_srvs,bQueryParamDTO.getFg_bb(),bQueryParamDTO.getEu_orsrcfun(),bQueryParamDTO.getId_emp_or()),BlIpOrdCgDTO.class);
		if (!ArrayUtil.isEmpty(idulDtos1)) {
				
			List<BlIpCgDTO> bcgList=new ArrayList<>();
				if (ArrayUtil.isEmpty(this.id_ors)) {
					List<String> orList=new ArrayList<>();
					for (BlIpOrdCgDTO bOrdCgDTO : idulDtos1) {
						orList.add(bOrdCgDTO.getId_or());
					}
					//获取医嘱未记账的费用
					bcgList = setOrderNotCg(orList.toArray(new String []{}),bQueryParamDTO.getDt_or_entry(),bQueryParamDTO.getDt_or_end(), false);
				}else{
					//获取医嘱未记账的费用
					bcgList = setOrderNotCg(this.id_ors,bQueryParamDTO.getDt_or_entry(),bQueryParamDTO.getDt_or_end(), false);
				}
			//获取医嘱已记账的费用
			BlIpCgDTO[] blIpCgDTOs1=(BlIpCgDTO[]) AppFwUtil.getDORstWithDao(new GetOrderDetailedQry(
						bQueryParamDTO.getId_ent(),this.id_ors,this.id_srvs,bQueryParamDTO.getId_srvtp(),bQueryParamDTO.getFg_bb(),bQueryParamDTO.getEu_orsrcfun()),BlIpCgDTO.class);
			List<BlIpCgDTO> bcgList2 = Arrays.asList(blIpCgDTOs1);
			setCodeDgipap(bcgList2);
				if (bcgList!=null) { 
					bcgList.addAll(bcgList2);
					//将未记账+记账数据组装到医嘱信息中
					List<BlIpOrdCgDTO> orderList= setOrdCg(Arrays.asList(idulDtos1),bcgList);
					bList.addAll(orderList);
				}else {
					//将记账数据组装到医嘱信息中
					List<BlIpOrdCgDTO> orderList= setOrdCg(Arrays.asList(idulDtos1),bcgList2);
					bList.addAll(Arrays.asList(idulDtos1));
				}
		}
		//添加医保相关字段设值
		this.addHpRelatedField(bList);
		return bList.toArray(new BlIpOrdCgDTO[]{});
	}
	/**
	 * 设置申领单号
	 * @param bcgList
	 */
	private void setCodeDgipap(List<BlIpCgDTO> bcgList){
		List<String> orList=new ArrayList<>();
		List<String> outPresList = new ArrayList<>();//出院带药集合，元素是id_or(出院带药是在病区统领单发送时记账，没有执行点Id_or_pr_srv)
		for (BlIpCgDTO ipcgDTO : bcgList) {
			if(ipcgDTO.getId_or_pr_srv() != null && ipcgDTO.getFg_mm().booleanValue()){
				orList.add(ipcgDTO.getId_or_pr_srv());
			}
			if(ipcgDTO.getFg_mm().booleanValue() && StringUtil.isEmpty(ipcgDTO.getId_or_pr_srv()) && !StringUtil.isEmpty(ipcgDTO.getId_or())){
				//出院带药
				outPresList.add(ipcgDTO.getId_or());
			}
		}
		IIpdgapdeRService ipdgapdeRService = ServiceFinder.find(IIpdgapdeRService.class);
		try {
			if(orList.size() > 0){
				IpDgApdeItmDO[] itmDos = ipdgapdeRService.findByAttrValStrings("Id_or_pr_srv", orList.toArray(new String []{}));
				if(ArrayUtil.isEmpty(itmDos))
					return;
				for (IpDgApdeItmDO itmDo : itmDos) {
					for (BlIpCgDTO ipcgDTO : bcgList) {
						if(ipcgDTO.getFg_mm().booleanValue() && ipcgDTO.getCode_dgipap() == null && itmDo.getId_or_pr_srv().equals(ipcgDTO.getId_or_pr_srv()) 
								&& (ipcgDTO.getEu_direct() == 1 && itmDo.getQuan_ap().intValue() > 0 
										|| ipcgDTO.getEu_direct() == -1 && itmDo.getQuan_ap().intValue() < 0)){
							ipcgDTO.setCode_dgipap(itmDo.getCode_dgipap());
						}
					}
				}
			}
			
			if(outPresList.size() > 0){
				IpDgApdeItmDO[] itmDos = ipdgapdeRService.findByAttrValStrings("Id_or", outPresList.toArray(new String []{}));
				if(ArrayUtil.isEmpty(itmDos))
					return;
				for (IpDgApdeItmDO itmDo : itmDos) {
					for (BlIpCgDTO ipcgDTO : bcgList) {
						if(ipcgDTO.getFg_mm().booleanValue() && ipcgDTO.getCode_dgipap() == null && itmDo.getId_or().equals(ipcgDTO.getId_or()) 
								&& (ipcgDTO.getEu_direct() == 1 && itmDo.getQuan_ap().intValue() > 0 
										|| ipcgDTO.getEu_direct() == -1 && itmDo.getQuan_ap().intValue() < 0)){
							ipcgDTO.setCode_dgipap(itmDo.getCode_dgipap());
						}
					}
				}
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @Description: 处理传入的id值
	 * @param:  ids     
	 * @author: xy.zhou     
	 * @throws
	 */
	private  String [] parameterProcessing(String ids)throws BizException{
		if (ids==null) {
			return null;
		}
		String[] split = ids.split(",");
		return split;
	}
	/**
	 * 
	 * @Description: 判断自费医保    
	 * @author: xy.zhou     
	 * @throws
	 */
	protected void whereHp(String id_ent) throws BizException{
		IPativisitRService ipRService=ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = ipRService.findById(id_ent);
		if (patiVisitDO!=null) {
			if (patiVisitDO.getId_hp()!=null) {
				this.isHp=true;
			}
		}
		this.code_entp=patiVisitDO.getCode_entp();
	}
	/**
	 * 
	 * @Description: 参数校验 处理
	 * @param:  bQueryParamDTO
	 * @author: xy.zhou     
	 * @throws
	 */
	protected void paramCheck(BlOrderValuationQueryParamDTO bQueryParamDTO) throws BizException{
		if (StringUtil.isEmpty(bQueryParamDTO.getId_ent())) {
			throw new BizException("医嘱计价查询未获取到就诊主键");
		}
		if (bQueryParamDTO.getId_or()!=null) {
			id_ors = parameterProcessing(bQueryParamDTO.getId_or());
		}
		if (bQueryParamDTO.getId_srv()!=null) {
			id_srvs = parameterProcessing(bQueryParamDTO.getId_srv());
		}
	}
	/**
	 * 
	 * @Description: 组装非医嘱费用      
	 * @author: xy.zhou     
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	protected List<BlIpOrdCgDTO> setNotOrdCg(BlIpCgDTO[] idulDtos){
		List<BlIpOrdCgDTO> bIpOrdCgDTOs=new ArrayList<>();
		BlIpOrdCgDTO bOrdCgDTO1=null;
		BlIpOrdCgDTO bOrdCgDTO2=null;
		BlIpOrdCgDTO bOrdCgDTO3=null;
		BlIpOrdCgDTO bOrdCgDTO4=null;
		BlIpOrdCgDTO bOrdCgDTO5=null;
		BlIpOrdCgDTO bOrdCgDTO6=null;
		BlIpOrdCgDTO bOrdCgDTO7=null;
		BlIpOrdCgDTO bOrdCgDTO8=null;
		
		FArrayList fList1=new FArrayList();
		FArrayList fList2=new FArrayList();
		FArrayList fList3=new FArrayList();
		FArrayList fList4=new FArrayList();
		FArrayList fList5=new FArrayList();
		FArrayList fList6=new FArrayList();
		FArrayList fList7=new FArrayList();
		FArrayList fList8=new FArrayList();
		//可以再sql中计算出来，先这么写
		FDouble amt1=new FDouble();
		FDouble amt2=new FDouble();
		FDouble amt3=new FDouble();
		FDouble amt4=new FDouble();
		FDouble amt5=new FDouble();
		FDouble amt6=new FDouble();
		FDouble amt7=new FDouble();
		FDouble amt8=new FDouble();
		for (BlIpCgDTO bDto : idulDtos) {
			//无医嘱费用记账标志
			bDto.setFg_cg(FBoolean.TRUE);
			switch (bDto.getSrcfunc_des()) {
			case IBlCgFuncConst.FUNC_IPBL_NURSE_ADDREFUNDCOST:
				bOrdCgDTO1=new BlIpOrdCgDTO();
				fList1.add(bDto);
				amt1=amt1.add(bDto.getAmt_ratio());
				bOrdCgDTO1.setContent_or("病区录入费用");
				bOrdCgDTO1.setAmt_ratio(amt1);
				bOrdCgDTO1.setCg_details(fList1);
				if (bOrdCgDTO1.getId_ent()==null){
					bOrdCgDTO1.setId_ent(bDto.getId_ent());
				}
				break;
			case IBlCgFuncConst.FUNC_IPBL_COLLECTOR_ADDREFUNDCOST:
				bOrdCgDTO2=new BlIpOrdCgDTO();
				fList2.add(bDto);
				amt2=amt2.add(bDto.getAmt_ratio());
				bOrdCgDTO2.setContent_or("住院处录入费用");
				bOrdCgDTO2.setAmt_ratio(amt2);
				bOrdCgDTO2.setCg_details(fList2);
				if (bOrdCgDTO2.getId_ent()==null){
					bOrdCgDTO2.setId_ent(bDto.getId_ent());
				}
				break;
			case IBlCgFuncConst.FUNC_IPBL_BACKKEEPACCOUNT:
				bOrdCgDTO3=new BlIpOrdCgDTO();  
				fList3.add(bDto);
				amt3=amt3.add(bDto.getAmt_ratio());
				bOrdCgDTO3.setContent_or("后台计价费用");
				bOrdCgDTO3.setAmt_ratio(amt3);
				bOrdCgDTO3.setCg_details(fList3);
				if (bOrdCgDTO3.getId_ent()==null){
					bOrdCgDTO3.setId_ent(bDto.getId_ent());
				}
				break;
			case IBlCgFuncConst.FUNC_OPMP_OTCONFIRM:
				bOrdCgDTO4=new BlIpOrdCgDTO();
				fList4.add(bDto);
				amt4=amt4.add(bDto.getAmt_ratio());
				bOrdCgDTO4.setContent_or("医技执行确认(含取消)节点录入费用");
				bOrdCgDTO4.setAmt_ratio(amt4);
				bOrdCgDTO4.setCg_details(fList4);
				if (bOrdCgDTO4.getId_ent()==null){
					bOrdCgDTO4.setId_ent(bDto.getId_ent());
				}
				break;
			
			case IBlCgFuncConst.FUNC_OPMP_OTADDCOST:
				bOrdCgDTO5=new BlIpOrdCgDTO();
				fList5.add(bDto);
				amt5=amt5.add(bDto.getAmt_ratio());
				bOrdCgDTO5.setContent_or("医技补录(含退)节点录入费用");
				bOrdCgDTO5.setAmt_ratio(amt5);
				bOrdCgDTO5.setCg_details(fList5);
				if (bOrdCgDTO5.getId_ent()==null){
					bOrdCgDTO5.setId_ent(bDto.getId_ent());
				}
				break;
			case IBlCgFuncConst.FUNC_IPMP_NURWORKSTATION:
				bOrdCgDTO6=new BlIpOrdCgDTO();
				fList6.add(bDto);
				amt6=amt6.add(bDto.getAmt_ratio());
				bOrdCgDTO6.setContent_or("护士工作站节点录入费用");
				bOrdCgDTO6.setAmt_ratio(amt6);
				bOrdCgDTO6.setCg_details(fList6);
				if (bOrdCgDTO6.getId_ent()==null){
					bOrdCgDTO6.setId_ent(bDto.getId_ent());
				}
				break;
			case IBlCgFuncConst.FUNC_IPBL_REGISTER:
				bOrdCgDTO7=new BlIpOrdCgDTO();
				fList7.add(bDto);
				amt7=amt7.add(bDto.getAmt_ratio());
				bOrdCgDTO7.setContent_or("入院登记产生费用");
				bOrdCgDTO7.setAmt_ratio(amt7);
				bOrdCgDTO7.setCg_details(fList7);
				if (bOrdCgDTO7.getId_ent()==null){
					bOrdCgDTO7.setId_ent(bDto.getId_ent());
				}
				break;
			default:
				bOrdCgDTO8=new BlIpOrdCgDTO();
				fList8.add(bDto);
				amt8=amt8.add(bDto.getAmt_ratio());
				bOrdCgDTO8.setContent_or("其它科室补费");
				bOrdCgDTO8.setAmt_ratio(amt8);
				bOrdCgDTO8.setCg_details(fList8);
				if (bOrdCgDTO8.getId_ent()==null){
					bOrdCgDTO8.setId_ent(bDto.getId_ent());
				}
				break;
			}
		}
		bIpOrdCgDTOs.add(bOrdCgDTO1);
		bIpOrdCgDTOs.add(bOrdCgDTO2);
		bIpOrdCgDTOs.add(bOrdCgDTO3);
		bIpOrdCgDTOs.add(bOrdCgDTO4);
		bIpOrdCgDTOs.add(bOrdCgDTO5);
		bIpOrdCgDTOs.add(bOrdCgDTO6);
		bIpOrdCgDTOs.add(bOrdCgDTO7);
		bIpOrdCgDTOs.add(bOrdCgDTO8);
		bIpOrdCgDTOs.removeAll(Collections.singleton(null));
		return bIpOrdCgDTOs;
	}
	/**
	 * 
	 * @Description: 组装医嘱信息     
	 * @author: xy.zhou     
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	protected List<BlIpOrdCgDTO>  setOrdCg(List<BlIpOrdCgDTO> blOrdCgDTOs,List<BlIpCgDTO> idulDtos){
		ListSort(idulDtos);
		Map<String, FArrayList> ordMap=new HashMap<>();
		for (BlIpCgDTO blIpCgDTO : idulDtos) {
			if (isHp) {
				if (blIpCgDTO.getFg_selfpay()!=null) {
					if (blIpCgDTO.getFg_selfpay().booleanValue()) {
						blIpCgDTO.setFg_hpin(FBoolean.TRUE);
					}
				}
			}else {
				blIpCgDTO.setFg_hpin(FBoolean.FALSE);
			}
			
			if (blIpCgDTO.getFg_cg()==null) {
				blIpCgDTO.setFg_cg(FBoolean.TRUE);
			}
			
//			else {
//				blIpCgDTO.setFg_cg(FBoolean.FALSE);
//			}
			
			if(ordMap.containsKey(blIpCgDTO.getId_or())){
				ordMap.get(blIpCgDTO.getId_or()).add(blIpCgDTO);
			}else {
				FArrayList cgList=new FArrayList();
				cgList.add(blIpCgDTO);
				ordMap.put(blIpCgDTO.getId_or(),cgList);
			}
			
		}
		ICiOrdBlService iCiOrdBlService=ServiceFinder.find(ICiOrdBlService.class);
		for (BlIpOrdCgDTO bOrdCgDTO : blOrdCgDTOs) {
			//设置医嘱展示状态
			String sd_or_show=iCiOrdBlService.getOrderStatus(this.code_entp, bOrdCgDTO.getSd_su_or(), bOrdCgDTO.getSd_su_mp(),bOrdCgDTO.getFg_stop());
			bOrdCgDTO.setSd_or_show(sd_or_show);
			if (bOrdCgDTO.getDt_end()!=null) {
				if (bOrdCgDTO.getDt_end().compareTo(new FDateTime())>0) {
					bOrdCgDTO.setDt_end(null);
				}
			}
			FArrayList list = ordMap.get(bOrdCgDTO.getId_or());
			FDouble amt=new FDouble(0);
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					BlIpCgDTO blIpCgDTO=(BlIpCgDTO)list.get(i);
					//如果是科研不计算金额,如果是未记账不计算金额
					if (bOrdCgDTO.getFg_research()!=null) {
						blIpCgDTO.setFg_research(bOrdCgDTO.getFg_research());//未记账费用没有返回科研标志
						if (!blIpCgDTO.getFg_research().booleanValue()&&blIpCgDTO.getFg_cg().booleanValue()) {
							amt = amt.add(blIpCgDTO.getAmt_ratio());
						}					
					}
				}
				if (list!=null) {
					bOrdCgDTO.setCg_details(list);
				}
			}
			bOrdCgDTO.setAmt_ratio(amt);
		}
		return blOrdCgDTOs;
	}
 

	/**
	 * 添加医保相关字段
	 * @param bList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected void addHpRelatedField(List<BlIpOrdCgDTO> bList) throws BizException{
		
//		if(ListUtil.isEmpty(bList))
//			return;
//		
//		IPpQueService ppService = ServiceFinder.find(IPpQueService.class);
//		FMap hpMap = ppService.getHpIdForHpCatalog(new String[]{bList.get(0).getId_ent()});
//		
//		String hpId = (String)hpMap.get(bList.get(0).getId_ent());
//		
//		List<String> srvIdList = new ArrayList<String>();
//		List<String> mmIdList = new ArrayList<String>();
//		for (BlIpOrdCgDTO ordDto : bList) {
//			if (ordDto.getCg_details()==null) {//未记账的医嘱费用明细目前为空
//				continue;
//			}
//			for (int i = 0; i < ordDto.getCg_details().size(); i++) {
//				BlIpCgDTO cgDto = (BlIpCgDTO)ordDto.getCg_details().get(i);
//				
//				if(!StringUtil.isEmpty(cgDto.getId_mm())){
//					if(!mmIdList.contains(cgDto.getId_mm())){
//						mmIdList.add(cgDto.getId_mm());
//					}
//				}else{
//					if(!srvIdList.contains(cgDto.getId_srv())){
//						srvIdList.add(cgDto.getId_srv());
//					}
//				}
//			}
//		}
//		
//		IMiBdDirCompQryService miService = ServiceFinder.find(IMiBdDirCompQryService.class);
//		ThreeDirCompInfoDTO[] compDtos =  miService.findThreeDirCompByHisSrvIdsAndDrugIds(hpId,
//				srvIdList.toArray(new String[0]),
//				mmIdList.toArray(new String[0]));
//		
//		if(ArrayUtil.isEmpty(compDtos))
//			return;
//		
//		//获取医保控制策略
//		IBdHpQryService hpQryService = ServiceFinder.find(IBdHpQryService.class);
//		BdHpSrvctrDO[] srvCtrDos = hpQryService.findSrvCtrByHisSrvIdsAndDrugIds(hpId,
//				srvIdList.toArray(new String[0]),
//				mmIdList.toArray(new String[0]));
//		
//		Map<String,ThreeDirCompInfoDTO> compMap = (Map<String,ThreeDirCompInfoDTO>)
//				MapUtils.convertArrayToMap(compDtos, "Id_srv,Id_drug");
//		
//		Map<String,BdHpSrvctrDO> hpSrvCtrMap = new HashMap<String,BdHpSrvctrDO>();
//		if (!ArrayUtil.isEmpty(srvCtrDos)) {
//			for (BdHpSrvctrDO bdHpSrvctrDO : srvCtrDos) {
//				String key = StringUtil.isEmpty(bdHpSrvctrDO.getId_mm()) ? bdHpSrvctrDO
//						.getId_srv() : bdHpSrvctrDO.getId_mm();
//				hpSrvCtrMap.put(key, bdHpSrvctrDO);
//			}
//		}
//		
//		for (BlIpOrdCgDTO ordDto : bList) {
//			if (ordDto.getCg_details()==null) {//未记账的医嘱费用明细目前为空
//				continue;
//			}
//			for (int i = 0; i < ordDto.getCg_details().size(); i++) {
//				BlIpCgDTO cgDto = (BlIpCgDTO)ordDto.getCg_details().get(i);
//				String key = StringUtil.isEmpty(cgDto.getId_mm()) ? cgDto.getId_srv() :cgDto.getId_mm();
//				ThreeDirCompInfoDTO compDto = compMap.get(key);
//				
//				if(compDto == null ){
//					cgDto.setName_hpsrvtp(IBdPpCodeTypeConst.NAME_HP_BJ_THREE);
//					
//				}else{
//					cgDto.setHp_des(compDto.getDes());
//					cgDto.setSd_hpsrvtp(compDto.getSd_hpsrvtp());
//					/*if(IBdPpCodeTypeConst.SD_HP_BJ_ONE.equals(cgDto.getSd_hpsrvtp())){
//						cgDto.setName_hpsrvtp(IBdPpCodeTypeConst.NAME_HP_BJ_ONE);
//						if (isHp) {
//							cgDto.setFg_hpin(FBoolean.TRUE);
//						}
//					}else if(IBdPpCodeTypeConst.SD_HP_BJ_ONE.equals(cgDto.getSd_hpsrvtp())){
//						cgDto.setName_hpsrvtp(IBdPpCodeTypeConst.NAME_HP_BJ_TOW);
//						if (isHp) {
//							cgDto.setFg_hpin(FBoolean.TRUE);
//						}
//					}else{
//						cgDto.setName_hpsrvtp(IBdPpCodeTypeConst.NAME_HP_BJ_THREE);
//						if (isHp) {
//							cgDto.setFg_hpin(FBoolean.FALSE);
//						}
//					}*/
//				}
//				
//				cgDto.setFg_hpin(FBoolean.TRUE.equals(cgDto.getFg_selfpay()) ? 
//						FBoolean.FALSE : FBoolean.TRUE);
//				
//				BdHpSrvctrDO ctrDO = hpSrvCtrMap.get(key);
//				if(ctrDO != null){
//					cgDto.setHis_des(ctrDO.getHis_des());
//				}
//			}
//		}
	}
	/**
	 * 
	 * @Description: 获取医嘱未记账的费用	·    
	 * @author: xy.zhou     
	 * @throws
	 */
	protected List<BlIpCgDTO> setOrderNotCg(String [] id_ors,FDateTime entry,FDateTime end, Boolean fg_emgstry)throws BizException{
		
		IMpDgBlService iMpDgBlService=ServiceFinder.find(IMpDgBlService.class);
		DgUnChargeDTO[] dgUnChargeDTOs = iMpDgBlService.findUnChargeList(id_ors, entry, end);
		if (ArrayUtil.isEmpty(dgUnChargeDTOs)) {
			return null;
		}
		List<BlIpCgDTO> bCgDTOs=new ArrayList<>();
		
		for (DgUnChargeDTO dChargeDTO : dgUnChargeDTOs) {
			BlIpCgDTO cgDTO=new BlIpCgDTO();
			cgDTO.setId_ent(dChargeDTO.getId_ent());
			cgDTO.setFg_cg(FBoolean.FALSE);
			cgDTO.setId_pat(dChargeDTO.getId_pat());
			cgDTO.setId_srv(dChargeDTO.getId_srv());
			cgDTO.setName_srv(dChargeDTO.getName_srv());
			cgDTO.setName_mm(dChargeDTO.getName_mm());
			cgDTO.setId_mm(dChargeDTO.getId_mm());
			cgDTO.setSpec(dChargeDTO.getSpec());
			cgDTO.setPrice_ratio(dChargeDTO.getPrice());
			cgDTO.setQuan_mend(dChargeDTO.getQuan());
			if (dChargeDTO.getAmt()==null) {
				cgDTO.setAmt_ratio(new FDouble());
			}else {
				cgDTO.setAmt_ratio(dChargeDTO.getAmt());
			}
			cgDTO.setName_dep_or(dChargeDTO.getName_dep_or());
			cgDTO.setName_dep_mp(dChargeDTO.getName_dep_mp());
			cgDTO.setSrvu(dChargeDTO.getName_measdoc());
			cgDTO.setFg_bb(dChargeDTO.getFg_bb());
			cgDTO.setId_or(dChargeDTO.getId_or());
			cgDTO.setEu_direct(1);
			cgDTO.setDt_mp_plan(dChargeDTO.getDt_mp_plan());
			cgDTO.setCode_dgipap(dChargeDTO.getCode_dgipap());
			cgDTO.setFg_selfpay(dChargeDTO.getFg_selfpay());
			bCgDTOs.add(cgDTO);
		}
		return bCgDTOs;
	}
	
	
	 private  void ListSort(List<BlIpCgDTO> list) {
		Collections.sort(list, new Comparator<BlIpCgDTO>() {
			@Override
			public int compare(BlIpCgDTO o1, BlIpCgDTO o2) {

				String dt1 = o1.getDt_mp_plan() == null ? "" : o1.getDt_mp_plan().toString();
				String dt2 = o2.getDt_mp_plan() == null ? "" : o2.getDt_mp_plan().toString();
				
				return dt1.compareTo(dt2);
			}
		});
	    }

}
