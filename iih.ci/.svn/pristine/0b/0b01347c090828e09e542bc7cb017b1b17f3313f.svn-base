package iih.ci.event.ord.bps.sign.op.logicbp;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.bps.sign.op.query.OpOpSignAssistInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpOpSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpOpSignOperationInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import iih.ci.ord.iemsg.d.IESugAssistDTO;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊签署 手术处理逻辑BS007
 * @author F
 *
 * @date 2019年8月27日下午3:53:40
 *
 * @classpath iih.ci.event.ord.bps.sign.op.logicbp.OpOpSignLogicDealWithBP
 */
public class OpOpSignLogicDealWithBP extends CommonParamBP{
	
	/**
	 * 门诊 签署 手术信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public IEOpOpOrEnDTO[] exec(OrdEventFireDTO fireDTO) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(fireDTO.getIdors()))return null;
		//查询并获得返回值
		OpOpSignEntInfoQuery qry=new OpOpSignEntInfoQuery(fireDTO.getIdors());
		IEOpOpOrEnDTO[] rtn = (IEOpOpOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpOpOrEnDTO.class);
		if(!OrdEventUtil.isEmpty(rtn)){
			for (IEOpOpOrEnDTO ieOpOpOrEnDTO : rtn) {
				//设置值
				setValue(ieOpOpOrEnDTO);
				//手术医嘱集合
				setOperationInfoList(ieOpOpOrEnDTO, ieOpOpOrEnDTO.getIdor());
				//助手护士信息
				setIesugAssistList(ieOpOpOrEnDTO, ieOpOpOrEnDTO.getIdor());
			}
		}
		//手术等级名称转换：将BS007手术等级名称字段 一级 二级 三级 四级（IIH的） 对应成 小 中 大 特大（目前手麻和HIS用的是这个），否则手麻系统报错
		//changeOpName(rtn);
		return rtn;
	}
	/**
	 * 设置值
	 * @param ieOpOpOrEnDTO
	 */
	private void setValue(IEOpOpOrEnDTO ieOpOpOrEnDTO) {
		if(OrdEventUtil.isEmpty(ieOpOpOrEnDTO))return;
		//年龄
		if(!OrdEventUtil.isEmpty(ieOpOpOrEnDTO.getBirthday())) {
			ieOpOpOrEnDTO.setAge(AgeCalcUtil.getAge(ieOpOpOrEnDTO.getBirthday()));
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(ieOpOpOrEnDTO.getAdmit_times())) {
			ieOpOpOrEnDTO.setAdmit_times("0");
		}
		//就诊类别
		ieOpOpOrEnDTO.setVisittype(getParamCodeEntp(ieOpOpOrEnDTO.getVisittype()));
	}
	/**
	 * 改变手术名称
	 * @param rtn
	 */
//	private void changeOpName(IEOpOpOrEnDTO[] rtns){
//		if(OrdEventUtil.isEmpty(rtns)){
//			return;
//		}
//		for(IEOpOpOrEnDTO rtn:rtns){
//			String opLevel = rtn.getOp_scale();
//			if(!OrdEventUtil.isEmpty(opLevel)){
//				if(OrdEventUtil.SD_OP_SUG_LEVEL_CODE_IE_ONE.equals(opLevel)){
//					rtn.setOp_scale_name("一级");
//				}else if(OrdEventUtil.SD_OP_SUG_LEVEL_CODE_IE_TWO.equals(opLevel)){
//					rtn.setOp_scale_name("二级");
//				}else if(OrdEventUtil.SD_OP_SUG_LEVEL_CODE_IE_THREE.equals(opLevel)){
//					rtn.setOp_scale_name("三级");
//				}else if(OrdEventUtil.SD_OP_SUG_LEVEL_CODE_IE_FOUR.equals(opLevel)){
//					rtn.setOp_scale_name("四级");
//				}
//			}
//		}
//	}
	
	/**
	 * 查询获取手术医嘱集合
	 * @param dto
	 * @param id_or
	 * @throws BizException 
	 */
	public void setOperationInfoList(IEOpOpOrEnDTO dto, String id_ors) throws BizException {
		OpOpSignOperationInfoQuery qry = new OpOpSignOperationInfoQuery(id_ors);
		IEOperationInfoDTO[] rtn = (IEOperationInfoDTO[])AppFwUtil.getDORstWithDao(qry, IEOperationInfoDTO.class);
		//设置值
		setValue(rtn);
		dto.setIesugorders(OrdEventUtil.array2FArrayList2(rtn));//手术医嘱信息集合
	}
	/**
	 * 设置值
	 * @param rtn
	 */
	private void setValue(IEOperationInfoDTO[] rtn ) {
		if(OrdEventUtil.isEmpty(rtn)) {
			return;
		}
		//身高体重
		for(IEOperationInfoDTO infoDto:rtn) {
			if(StringUtils.isNotEmpty(infoDto.getId_ent())) {
				String idEntString = infoDto.getId_ent();
				IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
				try {
					String[] arrStrings=idEntString.split(",");
					EntOpVitalSignsDTO[] signsDTOs = service.getEntOpVitalSigns(arrStrings);
					if(!OrdEventUtil.isEmpty(signsDTOs)) {
						//体重
						if(!OrdEventUtil.isEmpty(signsDTOs[0].getWeight())) {
							infoDto.setWeight(signsDTOs[0].getWeight().toString());
						}
						//体重单位
						if(!OrdEventUtil.isEmpty(signsDTOs[0].getName_unit_weight())) {
							infoDto.setWeight_unit(signsDTOs[0].getName_unit_weight());
						}
						//身高
						if(!OrdEventUtil.isEmpty(signsDTOs[0].getHeight())) {
							infoDto.setHeight(signsDTOs[0].getHeight().toString());
						}
						//身高单位
						if(!OrdEventUtil.isEmpty(signsDTOs[0].getName_unit_height())) {
							infoDto.setHeight_unit(signsDTOs[0].getName_unit_height());
						}
					}
				} catch (BizException e) {
					infoDto.setWeight("");
					infoDto.setWeight_unit("");
					infoDto.setHeight("");
					infoDto.setHeight_unit("");
				}
			}
		}
	}
	/**
	 * 助手护士信息
	 * @throws BizException 
	 */
	public void setIesugAssistList(IEOpOpOrEnDTO dto, String id_or) throws BizException {
		//查询并获得返回值
		OpOpSignAssistInfoQuery qry = new OpOpSignAssistInfoQuery(id_or);
		IESugAssistDTO[] rtn = (IESugAssistDTO[])AppFwUtil.getDORstWithDao(qry, IESugAssistDTO.class);
		dto.setIesugassists(OrdEventUtil.array2FArrayList2(rtn));
	}
}
