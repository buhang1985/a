package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.bps.sign.ip.query.IpOpSignAssistInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpOpSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpOpSignOperationInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import iih.ci.ord.iemsg.d.IESugAssistDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 住院签署 手术逻辑处理BS007
 * @author F
 *
 * @date 2019年8月27日下午3:46:30
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpOpSignLogicDealWithBP
 */
public class IpOpSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台手术申请服务数据信息
	 * （住院）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOpOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		
		//查询并获得返回值
		IpOpSignEntInfoQuery qry=new IpOpSignEntInfoQuery(firedto.getIdors());
		IEOpOpOrEnDTO[] rtn = (IEOpOpOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpOpOrEnDTO.class);
		// 组装手术数据
		if(!OrdEventUtil.isEmpty(rtn)){
			for (IEOpOpOrEnDTO ieOpOpOrEnDTO : rtn) {
				//设置值
				setValue(ieOpOpOrEnDTO);
				setOperationInfoList(ieOpOpOrEnDTO, ieOpOpOrEnDTO.getIdor());//手术医嘱信息集合
				setIesugAssistList(ieOpOpOrEnDTO, ieOpOpOrEnDTO.getIdor());//助手护士信息集合
			}
		}
		return rtn;
	}
	/**
	 * 设置值
	 * @param ieOpOpOrEnDTO
	 */
	private void setValue(IEOpOpOrEnDTO ieOpOpOrEnDTO) {
		if(OrdEventUtil.isEmpty(ieOpOpOrEnDTO)) {
			return;
		}
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
	 * 查询获取手术医嘱集合
	 * @param dto
	 * @param id_or
	 * @throws BizException 
	 */
	public void setOperationInfoList(IEOpOpOrEnDTO dto, String id_ors) throws BizException {
		IpOpSignOperationInfoQuery qry = new IpOpSignOperationInfoQuery(id_ors);
		IEOperationInfoDTO[] rtn = (IEOperationInfoDTO[])AppFwUtil.getDORstWithDao(qry, IEOperationInfoDTO.class);
		if(!OrdEventUtil.isEmpty(rtn)) {
			for(IEOperationInfoDTO infoDto:rtn) {
				//收费状态标识
				String id_or = infoDto.getId_or();
				if(StringUtils.isNotEmpty(id_or)) {
					OrdSrvDO[] ordSrvDOs;
					try {
						ordSrvDOs = OrdEventHelper.getOrdSrvDO(id_or);
						if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
							infoDto.setPayflag(ordSrvDOs[0].getSd_su_bl());
						}
					} catch (BizException e) {
						infoDto.setPayflag("");
						e.printStackTrace();
					}
				}
			}
		}
		dto.setIesugorders(OrdEventUtil.array2FArrayList2(rtn));//手术医嘱信息集合
	}
	
	/**
	 * 助手护士信息
	 * @throws BizException 
	 */
	public void setIesugAssistList(IEOpOpOrEnDTO dto, String id_or) throws BizException {
		
		//查询并获得返回值
		IpOpSignAssistInfoQuery qry = new IpOpSignAssistInfoQuery(id_or);
		IESugAssistDTO[] rtn = (IESugAssistDTO[])AppFwUtil.getDORstWithDao(qry, IESugAssistDTO.class);
		dto.setIesugassists(OrdEventUtil.array2FArrayList2(rtn));
	}
}
