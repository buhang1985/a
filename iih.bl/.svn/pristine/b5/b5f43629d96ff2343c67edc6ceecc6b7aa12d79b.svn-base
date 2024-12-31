package iih.bl.cg.s.bp.ip;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.params.BlParams;
import iih.en.pv.i.IEnIpQryService;

import java.util.ArrayList;
import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 查询会诊患者执行科室为当前科室的费用
 * @author liwenqiang 2018.11.01
 *
 */
public class GetConsEntFeeSrvsDepBP {

	/**
	 * 查询会诊患者执行科室为当前科室的费用
	 * @param entId
	 * @param condition
	 * @return
	 * @throws BizException 
	 */
	public NurseCompFeeItmDTO[] exec(String entId,String condition) throws BizException{
		if(StringUtils.isEmptyWithTrim(entId))  {
			throw new BizException("查询患者已记账收费项目时，就诊id不能为空！");
		}	
		
		// 1.根据业务线，查询病区的科室集合
		IEnIpQryService enIpService = ServiceFinder.find(IEnIpQryService.class);
		DeptDO[] deptArr = enIpService.getDepListByDepl(Context.get()
				.getDeptId(), IBdResDictCodeConst.SD_DEPROlE_NUR);
		
		List<String> depIdList=new ArrayList<String>();
		depIdList.add(Context.get().getDeptId());
		
		if (!ArrayUtil.isEmpty(deptArr)) {
			for (DeptDO depDo : deptArr) {
				depIdList.add(depDo.getId_dep());
			}
		}
		
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select cg.id_srv,cg.name_srv,sum(cg.eu_direct*cg.quan)  quan_mend,cg.id_ent ");
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
		sqlStr.append(" and  cg.id_dep_mp in (" );
		sqlStr.append(SqlUtils.arrayToStr(depIdList.toArray(new String[0])));
		sqlStr.append(" ) ");
		sqlStr.append(" and cg.fg_mm='N' ");
		sqlStr.append(" group by cg.id_srv,cg.name_srv,cg.id_ent ");
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
	
}
