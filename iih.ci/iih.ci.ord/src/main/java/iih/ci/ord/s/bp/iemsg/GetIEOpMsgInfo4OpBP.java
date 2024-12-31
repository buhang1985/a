package iih.ci.ord.s.bp.iemsg;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import iih.ci.ord.iemsg.d.IESugAssistDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiSugAssistInfoQry;
import iih.ci.ord.s.bp.iemsg.qry.CiSugOpAssistInfoQry;
import iih.ci.ord.s.bp.iemsg.qry.CiSugOpOrQry;
import iih.ci.ord.s.bp.iemsg.qry.CiSugOrInfoQry;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台手术申请服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4OpBP {
	/**
	 * 生成集成平台手术申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOpOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiSugOpOrQry qry=new CiSugOpOrQry(id_ors);
	    //	String sql = qry.getQrySQLStr();
		IEOpOpOrEnDTO[] rtn = (IEOpOpOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpOpOrEnDTO.class);
		if(!CiOrdUtils.isEmpty(rtn)){
			for (IEOpOpOrEnDTO ieOpOpOrEnDTO : rtn) {
				ieOpOpOrEnDTO.setAge(AgeCalcUtil.getAge(ieOpOpOrEnDTO.getBirthday()));
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
	 * 改变手术名称
	 * @param rtn
	 */
//	private void changeOpName(IEOpOpOrEnDTO[] rtns){
//		if(CiOrdUtils.isEmpty(rtns)){
//			return;
//		}
//		for(IEOpOpOrEnDTO rtn:rtns){
//			String opLevel = rtn.getOp_scale();
//			if(!CiOrdUtils.isEmpty(opLevel)){
//				if(IBdSrvDictCodeConst.SD_OP_SUG_LEVEL_CODE_IE_ONE.equals(opLevel)){
//					rtn.setOp_scale_name("一级");
//				}else if(IBdSrvDictCodeConst.SD_OP_SUG_LEVEL_CODE_IE_TWO.equals(opLevel)){
//					rtn.setOp_scale_name("二级");
//				}else if(IBdSrvDictCodeConst.SD_OP_SUG_LEVEL_CODE_IE_THREE.equals(opLevel)){
//					rtn.setOp_scale_name("三级");
//				}else if(IBdSrvDictCodeConst.SD_OP_SUG_LEVEL_CODE_IE_FOUR.equals(opLevel)){
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
		CiSugOrInfoQry qry = new CiSugOrInfoQry(id_ors);
		IEOperationInfoDTO[] rtn = (IEOperationInfoDTO[])AppFwUtil.getDORstWithDao(qry, IEOperationInfoDTO.class);
		//身高体重
		if(!CiOrdUtils.isEmpty(rtn)) {
			for(IEOperationInfoDTO infoDto:rtn) {
				if(StringUtils.isNotEmpty(infoDto.getId_ent())) {
					String idEntString = infoDto.getId_ent();
					IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
					try {
						String[] arrStrings=idEntString.split(",");
						EntOpVitalSignsDTO[] signsDTOs = service.getEntOpVitalSigns(arrStrings);
						if(!CiOrdUtils.isEmpty(signsDTOs)) {
							//体重
							if(!CiOrdUtils.isEmpty(signsDTOs[0].getWeight())) {
								infoDto.setWeight(signsDTOs[0].getWeight().toString());
							}
							//体重单位
							if(!CiOrdUtils.isEmpty(signsDTOs[0].getName_unit_weight())) {
								infoDto.setWeight_unit(signsDTOs[0].getName_unit_weight());
							}
							//身高
							if(!CiOrdUtils.isEmpty(signsDTOs[0].getHeight())) {
								infoDto.setHeight(signsDTOs[0].getHeight().toString());
							}
							//身高单位
							if(!CiOrdUtils.isEmpty(signsDTOs[0].getName_unit_height())) {
								infoDto.setHeight_unit(signsDTOs[0].getName_unit_height());
							}
						}
					} catch (BizException e) {
						e.printStackTrace();
					}
				}
				//
				//收费状态标识
				String code_or = infoDto.getYz_no();
				if(StringUtils.isNotEmpty(code_or)) {
					OrdSrvDO[] ordSrvDOs;
					try {
						ordSrvDOs = GetPayFlagHelper.getOrdSrvDO(CiOrderDO.CODE_OR, code_or);
						if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
							infoDto.setPayflag(ordSrvDOs[0].getSd_su_bl());
						}
					} catch (BizException e) {
						infoDto.setPayflag("");
						e.printStackTrace();
					}
				}
			}
		}
		dto.setIesugorders(CiOrdUtils.array2FArrayList2(rtn));//手术医嘱信息集合
	}
	
	/**
	 * 助手护士信息
	 * @throws BizException 
	 */
	public void setIesugAssistList(IEOpOpOrEnDTO dto, String id_or) throws BizException {
		
		//查询并获得返回值
		CiSugOpAssistInfoQry qry = new CiSugOpAssistInfoQry(id_or);
		IESugAssistDTO[] rtn = (IESugAssistDTO[])AppFwUtil.getDORstWithDao(qry, IESugAssistDTO.class);
		dto.setIesugassists(CiOrdUtils.array2FArrayList2(rtn));
	}
}
