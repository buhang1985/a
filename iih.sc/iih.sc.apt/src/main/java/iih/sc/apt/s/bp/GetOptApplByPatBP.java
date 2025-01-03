package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.comm.ScParamUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOptApplByPatBP {

	public MtAppDTO[] exec (MtAppQryDTO appDTO,String sd_sctp,  String where)throws BizException
	{
		GetOptApplBP applBP = new GetOptApplBP();
		StringBuilder sql = applBP.getSql();
		sql.append(where);
		SqlParam param = new SqlParam();
		//手术类型
		sql.append(" and appl.sd_sctp = ? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OT);
		//执行科室
		sql.append(" and appl.id_dep_mp = ? ");
		param.addParam(appDTO.getId_dep());
		//时间
		sql.append(" and appl.d_b = ?");
		param.addParam(appDTO.getD_begin());
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
