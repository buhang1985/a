package iih.sc.apt.s.bp.opt;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.s.bp.GetOptApplBP;
import iih.sc.comm.ScParamUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取手术申请单BP
 * 
 * @author zhengcm
 * @date 2018-02-27 08:18:14
 *
 */
public class GetOptAppBP {

	/**
	 * 获取手术申请单：患者ID与医嘱ID互斥
	 * 
	 * @author zhengcm
	 *
	 * @param id_pat 患者ID
	 * @param id_or 医嘱ID
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] exec(String id_pat, String id_or) throws BizException {
		// 校验参数
		if (StringUtil.isEmptyWithTrim(id_pat) && StringUtil.isEmpty(id_or)) {
			throw new BizException("患者ID与医嘱ID不能同时为空！");
		}
		GetOptApplBP applBP = new GetOptApplBP();
		StringBuilder sql = applBP.getSql();
		SqlParam param = new SqlParam();
		//手术类型
		sql.append(" and appl.sd_sctp = ? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OT);
		// 未预约申请单
		sql.append(" and appl.fg_comfirm = ? ");
		param.addParam(FBoolean.FALSE);
		if(!StringUtil.isEmpty(id_pat)){
			sql.append(" and appl.id_pi = ? ");
			param.addParam(id_pat);
		}
		if(!StringUtil.isEmpty(id_or)){
			sql.append(" and appl.id_or = ? ");
			param.addParam(id_or);
		}
		// 就诊类型: 门诊
		sql.append(" and ((appl.code_entp = '00') ");
		// 急诊
		sql.append("or appl.code_entp like (?)");
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET + "%");
		// 住院
		if(ScParamUtils.getScOptDepApprove()){//获取组织参数 SC0300 手术预约前是否需要临床科室确认
			sql.append(" or (appl.code_entp = '10' and opt.fg_need_confirm='Y' and opt.fg_confirm_phy='Y'))");
		} else {
			sql.append(" or (appl.code_entp = '10'))");
		}
		List<MtAppDTO> list = (List<MtAppDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(MtAppDTO.class));
		List<MtAppDTO> result = new ArrayList<MtAppDTO>();
		//设置就诊类型 过滤费用
		if(list.size()>0)
		{
			Map<String,Boolean> checkFeeMap = new HashMap<String,Boolean>();
			
			for (MtAppDTO mtAppDTO : list) {
				boolean isCheckFee = false;
				if(checkFeeMap.containsKey(mtAppDTO.getId_dep_mp())){
					
				 isCheckFee = checkFeeMap.get(mtAppDTO.getId_dep_mp());
				}else{
				 isCheckFee = ScParamUtils.getScAptMtChkFee(mtAppDTO.getId_dep_mp());
				 checkFeeMap.put(mtAppDTO.getId_dep_mp(), isCheckFee);
				}
				if(isCheckFee){
					if(mtAppDTO.getFg_bl() != null && mtAppDTO.getFg_bl().booleanValue()){
						result.add(mtAppDTO);
					}else{
						continue;
					}
				}else{
					result.add(mtAppDTO);
				}
				mtAppDTO.setAge(AgeCalcUtil.getAge(mtAppDTO.getDt_birth_pat())); //计算年龄
				if(IPiDictCodeConst.ID_SEX_FEMALE.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_FEMALE);
				}
				else if(IPiDictCodeConst.ID_SEX_MALE.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_MALE);
				}
				else if(IPiDictCodeConst.ID_SEX_UNEXPLAIN.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);
		}
				else if(IPiDictCodeConst.ID_SEX_UNKNOW.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_UNKNOW);
		}
				
				mtAppDTO.setName_enttp(applBP.getEnttpName(mtAppDTO.getSd_enttp()));
	}
		}
		return result.toArray(new MtAppDTO[0]);
	}

}
