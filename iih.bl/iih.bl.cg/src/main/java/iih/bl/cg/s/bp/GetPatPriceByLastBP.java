package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.GetCheckBedFeeBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.GetCheckFixFeeBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.GetCheckNurseFeeBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.GetCheckPrnOrderBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.GetCheckTotalFeeBP;
import iih.bl.comm.util.BlPeCmpyUtil;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.bl.st.dto.d.BlIpOutPatPriQryDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 出院患者的后台划价费用核查接口--展示患者的否已经自动做最后一次划价
 * 
 * @author LIM
 * @version ly 2018/08/11 添加团检患者判断
 */
public class GetPatPriceByLastBP {
	/**
	 * 出院患者的后台划价费用核查接口--展示患者的否已经自动做最后一次划价
	 * @param blIpOutPatPriQryDTO
	 * @param bErrExist 是否有错误就返回信息
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap exec(BlIpOutPatPriQryDTO[] blIpOutPatPriQryDTO,FBoolean bErrExist) throws BizException {
		FMap fmap = new FMap();
		if(ArrayUtils.isEmpty(blIpOutPatPriQryDTO)){
			throw new BizException("参数不能为空！");
		}
		
		FMap entpMap = getIpPreEnt(blIpOutPatPriQryDTO);

		for (BlIpOutPatPriQryDTO blOutPatPriQryDTO : blIpOutPatPriQryDTO) {
			
			// 每个患者的校验信息map
//			FMap patMap = new FMap();
			FArrayList blIpOutPatPriDTOList= new FArrayList();
			String id_ent = blOutPatPriQryDTO.getId_ent();
			FDateTime dt_end = blOutPatPriQryDTO.getDt_end();
			BlIpOutPatPriDTO blIpOutPatPriDTO=null;
			
			//判断是否团检患者 
			String pecmpyId = BlPeCmpyUtil.isPecmpy(id_ent);
			if (!StringUtil.isEmpty(pecmpyId)) {
				String message="";
				GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_BEDFEE, FBoolean.TRUE, message);
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_NURSEFEE, FBoolean.TRUE, message);
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_ORDERFEE, FBoolean.TRUE, message);
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_FIXFEE, FBoolean.TRUE, message);
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_TOTALFEE, FBoolean.TRUE, message);
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_TOTALQUAN, FBoolean.TRUE, message);
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				fmap.put(id_ent, blIpOutPatPriDTOList);
				continue;
			}
			
			// 1. 校验参数
			if (StringUtils.isEmpty(id_ent) || (dt_end == null || StringUtils.isEmpty(dt_end.toString()))) {
				throw new BizException("参数不能为空");
			}			
			// 2.检索床位费(只统计主床)是否划价      检索床位费数量核查接口
			GetCheckBedFeeBP checkBedFeeBP = new GetCheckBedFeeBP();
			blIpOutPatPriDTO=checkBedFeeBP.exec(id_ent, dt_end);
			if(blIpOutPatPriDTO!=null){
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				if(FBoolean.TRUE.equals(bErrExist) && FBoolean.FALSE.equals(blIpOutPatPriDTO.getFg_price())){
					fmap.put(id_ent, blIpOutPatPriDTOList);
					continue;
				}
			}			
			//3.检索护理费是否划价
			GetCheckNurseFeeBP checkNurseFeeBP = new GetCheckNurseFeeBP();
			blIpOutPatPriDTO=checkNurseFeeBP.exec(id_ent, dt_end);
			if(blIpOutPatPriDTO!=null){
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				if(FBoolean.TRUE.equals(bErrExist) && FBoolean.FALSE.equals(blIpOutPatPriDTO.getFg_price())){
					fmap.put(id_ent, blIpOutPatPriDTOList);
					continue;
				}
			}		
			//4.检索持续性医嘱是否划价
			GetCheckPrnOrderBP checkPrnOrderBP = new GetCheckPrnOrderBP();
			blIpOutPatPriDTO = checkPrnOrderBP.exec(id_ent, dt_end);
			if(blIpOutPatPriDTO!=null){
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				if(FBoolean.TRUE.equals(bErrExist) && FBoolean.FALSE.equals(blIpOutPatPriDTO.getFg_price())){
					fmap.put(id_ent, blIpOutPatPriDTOList);
					continue;
				}
			}	
			//5.检索固定收费包是否划价
			GetCheckFixFeeBP checkFixFeeBP = new GetCheckFixFeeBP();
			blIpOutPatPriDTO = checkFixFeeBP.exec(id_ent, dt_end);
			if(blIpOutPatPriDTO!=null){
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				if(FBoolean.TRUE.equals(bErrExist) && FBoolean.FALSE.equals(blIpOutPatPriDTO.getFg_price())){
					fmap.put(id_ent, blIpOutPatPriDTOList);
					continue;
				}
			}
			//6.检索是否有总数为负的项目
			GetCheckTotalFeeBP checkTotalFeeBP= new GetCheckTotalFeeBP();
			blIpOutPatPriDTO = checkTotalFeeBP.exec(id_ent, dt_end);
			if(blIpOutPatPriDTO!=null){
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				if(FBoolean.TRUE.equals(bErrExist) && FBoolean.FALSE.equals(blIpOutPatPriDTO.getFg_price())){
					fmap.put(id_ent, blIpOutPatPriDTOList);
					continue;
				}
			}
			//7.校验按时间收费的项目，不能超过在院时间
			/*GetCheckSrvDataBP  checkSrvDateBP= new GetCheckSrvDataBP();
			blIpOutPatPriDTO = checkSrvDateBP.exec(id_ent, dt_end);
			if(blIpOutPatPriDTO!=null){
				blIpOutPatPriDTOList.add(blIpOutPatPriDTO);
				if(FBoolean.TRUE.equals(bErrExist) && FBoolean.FALSE.equals(blIpOutPatPriDTO.getFg_price())){
					fmap.put(id_ent, blIpOutPatPriDTOList);
					continue;
				}
			}	*/	
			
			// 8.预住院出院核查
			if (entpMap.containsKey(id_ent)) {
				GetIpPreToOpCheckBP ipPreToOpCheckBP= new GetIpPreToOpCheckBP();
				BlIpOutPatPriDTO[] blIpOutPatPriDTOArr = ipPreToOpCheckBP.exec(id_ent, dt_end);
				if(blIpOutPatPriDTOArr!=null && blIpOutPatPriDTOArr.length > 0){
					blIpOutPatPriDTOList.addAll(Arrays.asList(blIpOutPatPriDTOArr));
					if(FBoolean.TRUE.equals(bErrExist)){
						fmap.put(id_ent, blIpOutPatPriDTOList);
						continue;
					}
				}
			}
			
			fmap.put(id_ent, blIpOutPatPriDTOList);
		}

		return fmap;
	}

	/**
	 * 从出院列表中选择出预住院的就诊记录
	 * @param blIpOutPatPriQryDTO
	 * @return
	 * @throws BizException
	 */
	private FMap getIpPreEnt(BlIpOutPatPriQryDTO[] blIpOutPatPriQryDTO) throws BizException {

		FMap entpMap = new FMap();
		List<String> IdEntArr = new ArrayList<String>();
		for (BlIpOutPatPriQryDTO blOutPatPriQryDTO : blIpOutPatPriQryDTO) {
			IdEntArr.add(blOutPatPriQryDTO.getId_ent());
		}

		IPativisitRService patiSer = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] EntDos = patiSer.findByAttrValStrings(PatiVisitDO.ID_ENT, IdEntArr.toArray(new String[0]));
		for (PatiVisitDO entDo : EntDos) {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(entDo.getCode_entp()))
				entpMap.put(entDo.getId_ent(), entDo);
		}
		return entpMap;
	}

}
