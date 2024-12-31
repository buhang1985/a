package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpConSignDeptInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpConSignEntInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpConsulationDTO;
import iih.ci.ord.iemsg.d.IEOpConsultationDeptDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院签署 会诊逻辑处理BS318
 * @author F
 *
 * @date 2019年8月27日下午5:13:36
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpConSignLogicDealWithBP
 */
public class IpConSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台会诊服务数据信息(BS318)
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BaseDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors())) {
			return null;
		}
		//根据查询条件获取会诊(BS318)的主表数据集合
		IEOpConsulationDTO[] ieOpConsulationDTOs = getConsulationDTOs(firedto.getIdors());
		//根据查询条件获取会诊(BS318)的子表数据集合
		IEOpConsultationDeptDTO[] ieOpConsultationDeptDTOs = getConsulationDeptDTOs(firedto.getIdors());
		if(!(OrdEventUtil.isEmpty(ieOpConsulationDTOs) && OrdEventUtil.isEmpty(ieOpConsultationDeptDTOs))) {
			OrdEventUtil.array2FArrayList2(ieOpConsultationDeptDTOs);
			for(IEOpConsulationDTO dto:ieOpConsulationDTOs) {
				//设置值
				setValue(dto);
				//根据主表与子表的共同的主表id进行关联  当一致时 将子表集合添加到主表内
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpConsultationDeptDTO deptDto:ieOpConsultationDeptDTOs) {
					if(!(OrdEventUtil.isEmpty(deptDto.getId_conculation()) && OrdEventUtil.isEmpty(dto.getId_conculation()))
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
	 * 设置值
	 */
	private void setValue(IEOpConsulationDTO dto) {
		//计算年龄
		if(!OrdEventUtil.isEmpty(dto.getBirthdate())) {
			dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getBirthdate().toString())));
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(dto.getVisittimes())) {
			dto.setVisittimes(0);
		}
		//就诊类别
		dto.setVisittype(getParamCodeEntp(dto.getVisittype()));
	}
	/**
	 * 根据查询条件获取会诊(BS318)的主表数据集合
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpConsulationDTO[] getConsulationDTOs(String id_ors) throws BizException{
		IpConSignEntInfoQuery ciConsulationQry = new IpConSignEntInfoQuery(id_ors);
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
		IpConSignDeptInfoQuery ciConsulationDeptQry = new IpConSignDeptInfoQuery(id_ors);
		IEOpConsultationDeptDTO[] rtn = (IEOpConsultationDeptDTO[])AppFwUtil.getDORstWithDao(ciConsulationDeptQry, IEOpConsultationDeptDTO.class);
		 return rtn;
	}
}
