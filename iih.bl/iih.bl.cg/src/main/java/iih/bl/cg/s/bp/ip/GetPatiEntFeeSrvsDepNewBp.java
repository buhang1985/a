package iih.bl.cg.s.bp.ip;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.params.BlParams;

import java.util.ArrayList;
import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取当前科室相关的项目明细集合
 * @author xy.zhou
 * @date 2018年8月6日
 */
public class GetPatiEntFeeSrvsDepNewBp {
	
	public  NurseCompFeeItmDTO[] exec (String entId,String id_dep,String condition) throws BizException {
		if(StringUtils.isEmptyWithTrim(entId))  {
			throw new BizException("查询患者已记账收费项目时，就诊id不能为空！");
		}	
		if(StringUtils.isEmptyWithTrim(id_dep))  {
			throw new BizException("查询患者本科室已记账收费项目时，科室id不能为空！");
		}
		String[] srvtps = getSrvtps();
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select cg.id_srv,cg.name_srv,sum(cg.eu_direct*cg.quan)  quan_mend,cg.id_ent,cg.code_inccaitm,cg.name_inccaitm ");
		sqlStr.append(" from bl_cg_ip cg left join bd_srv srv on cg.id_srv = srv.id_srv ");
		sqlStr.append(" where cg.fg_real = 'Y' and nvl(cg.fg_research,'N')='N' and (cg.name_srv like '%").append(condition).append("%' or srv.pycode like '%").append(condition.toUpperCase()).append("%' ) ");
		SqlParam param = new SqlParam();
		FBoolean isMerge = BlParams.BLSTIP0005();
		if (FBoolean.TRUE.equals(isMerge)) {
			sqlStr.append(" and (cg.id_ent = ? ").append(" or cg.id_ent_mom = ? ) ");
			param.addParam(entId);
			param.addParam(entId);
		} else {
			sqlStr.append(" and (cg.id_ent = ? ) ");
			param.addParam(entId);
		}
		sqlStr.append(" and cg.fg_st='N' ");
		sqlStr.append(" and (cg.id_dep_or=? or cg.id_dep_mp=? or cg.id_dep_cg=? )" );//or cg.id_dep_nur = ? 
		param.addParam(id_dep);
		param.addParam(id_dep);
		param.addParam(id_dep);
		//param.addParam(id_dep);
		if (ArrayUtil.isEmpty(srvtps)) {
			sqlStr.append(" and cg.fg_mm='N' ");
		}else {
			sqlStr.append(" and (cg.fg_mm='N' or ").append(SqlUtils.getInSqlByIds("cg.id_srvtp",srvtps)).append(") ");	
		}
		sqlStr.append(" group by cg.id_srv,cg.name_srv,cg.id_ent,cg.code_inccaitm,cg.name_inccaitm ");
		DAFacade df = new DAFacade();
		List<NurseCompFeeItmDTO> srvList = (List<NurseCompFeeItmDTO>)df.execQuery(sqlStr.toString(), param, new BeanListHandler(NurseCompFeeItmDTO.class));
		if(ListUtil.isEmpty(srvList))
			return null;
		List<NurseCompFeeItmDTO> sCompFeeItmDTOs=new ArrayList<>();
		//过滤可退费数量小于等于0的费用
		for (int i = 0; i < srvList.size(); i++) {
			if (srvList.get(i).getQuan_mend().doubleValue()<=0) {		
			}else {
				sCompFeeItmDTOs.add(srvList.get(i));
			}
		}
		return sCompFeeItmDTOs.toArray(new NurseCompFeeItmDTO[]{});
	}
	/**
	 * 
	 * @Description: 获取额外可退的项目，例如大输液    
	 * @author: xy.zhou     
	 * @throws
	 */
	private  String [] getSrvtps()throws BizException{
		String id_srvtp = BlParams.BLCG0012();
		if (id_srvtp==null) {
			return null;
		}
		String[] srvtps = id_srvtp.split(",");
		return srvtps;
	}
}
