package iih.ci.ord.s.bp.assi.tl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.external.obtain.bp.bl.GetArrearageCheckBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 将医嘱模板转换为MoreEmsParamDTO，避免各个类中都写
 * 
 * @author HUMS
 *
 */
public class CovertTmplToMoreEmsParamBP {

	public MoreEmsParamDTO exec(CiEnContextDTO envinfo, CiEmsDTO[] ciEmsDTOs,MoreEmsParamDTO moreEmsParam) throws BizException {
		if(moreEmsParam == null){
			moreEmsParam = new MoreEmsParamDTO();
		}

		//是否有申请表
		JudgeOrderTemplateApplicationTable apptable = new JudgeOrderTemplateApplicationTable();
		apptable.JudgeOrederTemplateAppTabel(ciEmsDTOs, envinfo);

		// 校验服务是否允许开立，不允许开立抛出业务异常
		List<CiEmsDTO> ciEmsLs = this.validateCiEmsDTO(envinfo, ciEmsDTOs,moreEmsParam);
		
		ciEmsDTOs = ciEmsLs.toArray(new CiEmsDTO[ciEmsLs.size()]);

		//系统参数判断 保存数据库还是进入医疗单
		//0  仅生成医疗单UI数据（非自动生成医嘱模式）
		//1  后台自动生成医嘱模式
		if (isSaveEmsDTO()) {
			//保存医嘱
			return SaveCiEmsDTOBP.SaveCiEmsDTO(envinfo, ciEmsDTOs,moreEmsParam);
		} else {
			FMap2 Errormap2 = new FMap2();
			//保存医嘱
			if(moreEmsParam.getErrormap2()!=null){
				Errormap2 = moreEmsParam.getErrormap2();
			}else{
				moreEmsParam.setErrormap2(Errormap2);
			}
			
			FArrayList ciEmsList = new FArrayList();
			for(CiEmsDTO dto : ciEmsDTOs){
				Errormap2.put(dto.getName(), ciEmsList);
			}
			return moreEmsParam;
		}
	}

	/**
	 * 0 仅生成医疗单UI数据（非自动生成医嘱模式） 1 后台自动生成医嘱模式
	 * 
	 * @return
	 * @throws BizException
	 */
	private Boolean isSaveEmsDTO() throws BizException {

		String isSave = CiOrdAppUtils.getCiOrdQryService().getCiOrAssMultiEmsHandleMode();
		if ("1".equals(isSave)) {
			return true;
		}
		return false;
	}
	/**
	 * 校验服务是否允许开立, 如果存在不允许开立的服务抛出异常
	 * 
	 * @param envinfo 当前就诊环境
	 * @param ciEmsDTOs 医疗单对象
	 * @throws BizException
	 */
	private List<CiEmsDTO> validateCiEmsDTO(CiEnContextDTO envinfo, CiEmsDTO[] ciEmsDTOs,MoreEmsParamDTO moreEmsParam) throws BizException {

		List<OrdSrvChangedInfoDTO> ordSrvStatusInfoList = new ArrayList<OrdSrvChangedInfoDTO>();
		
		// 开立欠费校验
		GetArrearageCheckBP arrearageCheckBP = new GetArrearageCheckBP();
		arrearageCheckBP.openCheckedArrearage(envinfo, ciEmsDTOs);
		
		for (CiEmsDTO ciEms : ciEmsDTOs) {
			if (FBoolean.TRUE.equals(ciEms.getFg_set())) {
				OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
				dto.setId_srv(ciEms.getId_srv());
				ordSrvStatusInfoList.add(dto);
			} else {
				// 遍历临床服务项目 
				FArrayList emsSrvList = ciEms.getEmssrvs();
				for (Object obj : emsSrvList) {

					CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) obj;
					OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
					dto.setId_srv(ciEmsSrv.getId_srv());

					if (FBoolean.TRUE.equals(ciEmsSrv.getFg_mm())) {
						dto.setId_mm(ciEmsSrv.getId_mm());
					}
					ordSrvStatusInfoList.add(dto);
				}
			}
		}

		OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();

		// 获取不可用服务集合，key：id_srv; value：不可用提示信息
		Map<String, String> ordSrvStatusMap = bp.exec(envinfo.getCode_entp(), ordSrvStatusInfoList);
		List<CiEmsDTO> ciEmsLs = new ArrayList<CiEmsDTO>();
		StringBuffer msgBuffer = new StringBuffer();
		for (CiEmsDTO ciEmsDTO : ciEmsDTOs) {
		if (ordSrvStatusMap != null && ordSrvStatusMap.size() > 0) {
				if (FBoolean.TRUE.equals(ciEmsDTO.getFg_set()) && ordSrvStatusMap.containsKey(ciEmsDTO.getId_srv())) {
					msgBuffer.append(ordSrvStatusMap.get(ciEmsDTO.getId_srv())).append(System.lineSeparator());
					moreEmsParam.addErrorEms(ciEmsDTO);
					continue;
				} else {
					// 遍历临床服务项目 
					FArrayList emsSrvList = ciEmsDTO.getEmssrvs();
					boolean isCanSave = true;
					for (Object obj : emsSrvList) {
						CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) obj;
						OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
						String key = ciEmsSrv.getId_srv();
						if (FBoolean.TRUE.equals(ciEmsSrv.getFg_mm())) {
							key += ("," + ciEmsSrv.getId_mm());
							dto.setId_mm(ciEmsSrv.getId_mm());
						}
						if (ordSrvStatusMap.containsKey(ciEmsDTO.getId_srv())) {
							msgBuffer.append(ordSrvStatusMap.get(key)).append(System.lineSeparator());
							isCanSave = false;
						}
					}
					if(!isCanSave){
						moreEmsParam.addErrorEms(ciEmsDTO);
						continue;
					}
				}
			}
			ciEmsLs.add(ciEmsDTO);
			}
		if(msgBuffer.length() > 0){
			moreEmsParam.setErrorinfo(msgBuffer.toString());
		}
		return ciEmsLs;
	}
}
