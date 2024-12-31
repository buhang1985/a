package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import iih.ci.ord.iemsg.d.IEOpConsulationDTO;
import iih.ci.ord.iemsg.d.IEOpConsultationDeptDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiConsulationDeptQry;
import iih.ci.ord.s.bp.iemsg.qry.CiConsulationQry;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台会诊服务数据信息操作BP
 * zhoudl
 */
public class GetIEMsgInfo4ConBP {
	/**
	 * 生成集成平台会诊服务数据信息(BS318)
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(String id_ors,Map<String,Object> confirminfo) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors)) {
			return null;
		}
		//根据查询条件获取会诊(BS318)的主表数据集合
		IEOpConsulationDTO[] ieOpConsulationDTOs = getConsulationDTOs(id_ors);
		//根据查询条件获取会诊(BS318)的子表数据集合
		IEOpConsultationDeptDTO[] ieOpConsultationDeptDTOs = getConsulationDeptDTOs(id_ors);
		if(!(CiOrdUtils.isEmpty(ieOpConsulationDTOs) && CiOrdUtils.isEmpty(ieOpConsultationDeptDTOs))) {
			CiOrdUtils.array2FArrayList2(ieOpConsultationDeptDTOs);
			for(IEOpConsulationDTO dto:ieOpConsulationDTOs) {
				//计算年龄
				if(!CiOrdUtils.isEmpty(dto.getBirthdate())) {
					dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getBirthdate().toString())));
				}
				//根据主表与子表的共同的主表id进行关联  当一致时 将子表集合添加到主表内
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpConsultationDeptDTO deptDto:ieOpConsultationDeptDTOs) {
					if(!(CiOrdUtils.isEmpty(deptDto.getId_conculation()) && CiOrdUtils.isEmpty(dto.getId_conculation()))
							&& dto.getId_conculation().equals(deptDto.getId_conculation())) {
						fArrayList2.add(deptDto);
					}
				}
				dto.setIeopcondeptlist(fArrayList2);
			}
		}
		return ieOpConsulationDTOs;
	}
	/**
	 * 根据查询条件获取会诊(BS318)的主表数据集合
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpConsulationDTO[] getConsulationDTOs(String id_ors) throws BizException{
		CiConsulationQry ciConsulationQry = new CiConsulationQry(id_ors);
		IEOpConsulationDTO[] rtn = (IEOpConsulationDTO[])AppFwUtil.getDORstWithDao(ciConsulationQry, IEOpConsulationDTO.class);
		 return rtn;
	}
	/**
	 * 根据查询条件获取会诊(BS318)的子表数据集合
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpConsultationDeptDTO[] getConsulationDeptDTOs(String id_ors) throws BizException{
		CiConsulationDeptQry ciConsulationQry = new CiConsulationDeptQry(id_ors);
		IEOpConsultationDeptDTO[] rtn = (IEOpConsultationDeptDTO[])AppFwUtil.getDORstWithDao(ciConsulationQry, IEOpConsultationDeptDTO.class);
		 return rtn;
	}
}
