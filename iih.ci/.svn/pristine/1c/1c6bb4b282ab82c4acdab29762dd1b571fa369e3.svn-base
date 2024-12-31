package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import iih.ci.ord.iemsg.d.IESugAssistDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiSugAssistInfoQry;
import iih.ci.ord.s.bp.iemsg.qry.CiSugIpOrQry;
import iih.ci.ord.s.bp.iemsg.qry.CiSugOrInfoQry;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 生成集成平台手术申请服务数据信息操作BP
 * （住院）
 * 
 */
public class GetIEIpMsgInfo4OpBP {
	/**
	 * 生成集成平台手术申请服务数据信息
	 * （住院）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOpOrEnDTO[] exec(String id_ors, String id_en) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiSugIpOrQry qry=new CiSugIpOrQry(id_ors);
		IEOpOpOrEnDTO[] rtn = (IEOpOpOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpOpOrEnDTO.class);
		String sql = qry.getQrySQLStr();
		SqlParam param = qry.getQryParameter(new StringBuffer());
		// 组装手术数据
		List<Map<String, Object>> maps=CiOrdUtils.getRsMapList(sql,param);
		// 查询诊断数据
		EntDiDO[] entDiInfos = ServiceFinder.find(IEntdiRService.class).find(String.format(" id_ent = '%s'", id_en), "sv desc", FBoolean.FALSE);
		// 取值当前最新诊断
		EntDiDO entDiInfo = null;
		if (!CiOrdUtils.isEmpty(entDiInfos)) {
			entDiInfo = entDiInfos[0];
		}
		List<IEOpOpOrEnDTO> list = new ArrayList<IEOpOpOrEnDTO>();
		if(!CiOrdUtils.isEmpty(rtn)){
			for (IEOpOpOrEnDTO ieOpOpOrEnDTO : rtn) {
				ieOpOpOrEnDTO.setAge(AgeCalcUtil.getAge(ieOpOpOrEnDTO.getBirthday()));
				setOperationInfoList(ieOpOpOrEnDTO, ieOpOpOrEnDTO.getIdor());//手术医嘱信息集合
				setIesugAssistList(ieOpOpOrEnDTO, ieOpOpOrEnDTO.getIdor());//助手护士信息集合
				if (entDiInfo != null) {
					ieOpOpOrEnDTO.setDiag_code(entDiInfo.getCode_didef_dis());//疾病编码
					ieOpOpOrEnDTO.setDiag_str(entDiInfo.getName_didef_dis());//疾病名称
					if(!CiOrdUtils.isEmpty(entDiInfo)) {
						if(FBoolean.TRUE.equals(entDiInfo.getFg_maj())) {
							ieOpOpOrEnDTO.setDiag_type("12");//诊断类别编码
							ieOpOpOrEnDTO.setDiag_type_name("主要诊断");//诊断类别名称
						} else if(FBoolean.FALSE.equals(entDiInfo.getFg_maj())) {
							ieOpOpOrEnDTO.setDiag_type("13");//诊断类别编码
							ieOpOpOrEnDTO.setDiag_type_name("次要诊断");//诊断类别名称
						}
					}
				}
				list.add(ieOpOpOrEnDTO);
			}
		}
		return list.toArray(new IEOpOpOrEnDTO[list.size()]);
	}
	
	/**
	 * 查询获取手术医嘱集合
	 * @param dto
	 * @param id_or
	 * @throws BizException 
	 */
	public void setOperationInfoList(IEOpOpOrEnDTO dto, String id_ors) throws BizException {
		CiSugOrInfoQry qry = new CiSugOrInfoQry(id_ors);
		IEOperationInfoDTO[] rtn = (IEOperationInfoDTO[])AppFwUtil.getDORstWithDao(qry, IEOperationInfoDTO.class);
		if(!CiOrdUtils.isEmpty(rtn)) {
			for(IEOperationInfoDTO infoDto:rtn) {
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
		CiSugAssistInfoQry qry = new CiSugAssistInfoQry(id_or);
		IESugAssistDTO[] rtn = (IESugAssistDTO[])AppFwUtil.getDORstWithDao(qry, IESugAssistDTO.class);
		dto.setIesugassists(CiOrdUtils.array2FArrayList2(rtn));
	}
}
