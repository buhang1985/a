package iih.bl.cg.s.bp.et;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.params.BlParams;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetEtEntFeeSrvsDepBp  
* @Description: 获取急诊患者可退费数据项目汇总 
* @author xy.zhou
* @date 2019年3月14日
 */
public class GetEtEntFeeSrvsDepBp {

	@SuppressWarnings("unchecked")
	public NurseCompFeeItmDTO[] exec(String entId, String dep_id, String condition)throws BizException{
		if(StringUtils.isEmptyWithTrim(entId))  {
			throw new BizException("查询患者已记账收费项目时，就诊id不能为空！");
		}	
		if(StringUtils.isEmptyWithTrim(dep_id))  {
			throw new BizException("查询患者本科室已记账收费项目时，科室id不能为空！");
		}
		
		Integer blst0002 = BlParams.BLST0002();
		String[] srvtps = getSrvtps();
		
		StringBuilder sqlStr = new StringBuilder();
		if(blst0002==1){
			sqlStr.append(" select item.id_srv,item.name_srv,sum(item.quan*cg.eu_direct) quan_mend,item.id_ent ");
			sqlStr.append(" from bl_cg_itm_oep item ");
			sqlStr.append(" left join bl_cg_oep cg on item.id_cgoep=cg.id_cgoep ");
			sqlStr.append(" left join bd_srv srv on item.id_srv = srv.id_srv ");
			sqlStr.append(" where 1=1");
			sqlStr.append(" and (item.id_dep_or=? or item.id_dep_mp=? or cg.id_dep_cg=? )");
			sqlStr.append("    and item.fg_refund = 'N' and cg.eu_direct = 1 ");
		}else if(blst0002==2){
			sqlStr.append(" select item.id_srv,item.name_srv,sum(item.eu_direct*item.quan)  quan_mend,item.id_ent ");
			sqlStr.append(" from bl_cg_ip item left join bd_srv srv on item.id_srv = srv.id_srv ");
			sqlStr.append(" where 1=1");
			sqlStr.append(" and (item.id_dep_or=? or item.id_dep_mp=? or item.id_dep_cg=? )" );
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误！该参数为"+blst0002);
		}	
		SqlParam param = new SqlParam();
		param.addParam(dep_id);
		param.addParam(dep_id);
		param.addParam(dep_id);
		
		//sqlStr.append("and  nvl(item.fg_research,'N')='N' ");
		sqlStr.append("  and (item.name_srv like '%").append(condition).append("%' or srv.pycode like '%").append(condition.toUpperCase()).append("%' ) ");
		sqlStr.append(" and item.fg_st='N' ");
		if (ArrayUtil.isEmpty(srvtps)) {
			sqlStr.append(" and item.fg_mm='N' ");
		}else {
			sqlStr.append(" and (item.fg_mm='N' or ").append(SqlUtils.getInSqlByIds("item.id_srvtp",srvtps)).append(") ");	
		}
		sqlStr.append(" and item.id_ent=? ");
		param.addParam(entId);
		sqlStr.append(" group by item.id_srv,item.name_srv,item.id_ent ");
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
