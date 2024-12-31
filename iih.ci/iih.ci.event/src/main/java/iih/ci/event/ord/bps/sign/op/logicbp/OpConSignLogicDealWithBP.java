package iih.ci.event.ord.bps.sign.op.logicbp;

import iih.ci.event.ord.bps.sign.op.query.OpConSignDeptInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpConSignEntInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpOpConsulationDTO;
import iih.ci.ord.iemsg.d.IEOpOpConsultationDeptDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊签署 会诊逻辑处理BS318
 * @author F
 *
 * @date 2019年11月19日下午3:53:42
 *
 * @classpath iih.ci.event.ord.bps.sign.op.logicbp.OpConSignLogicDealWithBP
 */
public class OpConSignLogicDealWithBP extends CommonParamBP{


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
		IEOpOpConsulationDTO[] ieOpConsulationDTOs = getConsulationDTOs(firedto.getIdors());
		//根据查询条件获取会诊(BS318)的子表数据集合
		IEOpOpConsultationDeptDTO[] ieOpConsultationDeptDTOs = getConsulationDeptDTOs(firedto.getIdors());
		if(!(OrdEventUtil.isEmpty(ieOpConsulationDTOs) && OrdEventUtil.isEmpty(ieOpConsultationDeptDTOs))) {
			OrdEventUtil.array2FArrayList2(ieOpConsultationDeptDTOs);
			for(IEOpOpConsulationDTO dto:ieOpConsulationDTOs) {
				//设置值
				setValue(dto);
				//根据主表与子表的共同的主表id进行关联  当一致时 将子表集合添加到主表内
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpOpConsultationDeptDTO deptDto:ieOpConsultationDeptDTOs) {
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
	private void setValue(IEOpOpConsulationDTO dto) {
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
	private IEOpOpConsulationDTO[] getConsulationDTOs(String id_ors) throws BizException{
		OpConSignEntInfoQuery ciConsulationQry = new OpConSignEntInfoQuery(id_ors);
		IEOpOpConsulationDTO[] rtn = (IEOpOpConsulationDTO[])AppFwUtil.getDORstWithDao(ciConsulationQry, IEOpOpConsulationDTO.class);
		 return rtn;
	}
	/**
	 * 根据查询条件获取会诊(BS318)的子表数据集合
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpOpConsultationDeptDTO[] getConsulationDeptDTOs(String id_ors) throws BizException{
		OpConSignDeptInfoQuery ciConsulationDeptQry = new OpConSignDeptInfoQuery(id_ors);
		IEOpOpConsultationDeptDTO[] rtn = (IEOpOpConsultationDeptDTO[])AppFwUtil.getDORstWithDao(ciConsulationDeptQry, IEOpOpConsultationDeptDTO.class);
		 return rtn;
	}
}
