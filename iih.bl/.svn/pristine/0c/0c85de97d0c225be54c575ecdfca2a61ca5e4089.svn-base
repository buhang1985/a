package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.d.BlIpFeeInfo;
import iih.bl.params.BlParams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.measdoc.d.MeasDocDO;

public class GetBlIpInfoDataBp {
	public BlIpFeeInfo[] exec(String id_ent, String[] idList) throws BizException {
		if (StringUtils.isEmptyWithTrim(id_ent) || ArrayUtils.isEmpty(idList)) {
			throw new BizException("查询患者服务记账明细时，就诊id和服务id不能为空！");
		}
		// srvId 转换 in 字符串
		String sqlSrvIds = SqlUtils.getInSqlByBigIds("cg.id_srv", idList);// SqlUtils.arrayToStr(srvIds);
		// 查询正方向明细
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append(
				" select cg.id_ent,cg.id_cgip, cg.name_srv, cg.name_mm, cg.quan*cg.eu_direct as quan, cg.srvu, cg.price_ratio, ");
		sb.append(" cg.id_dep_or, cg.id_emp_or,cg.id_dep_mp, cg.id_dep_cg,cg.id_emp_cg,cg.dt_cg,cg.sd_srvtp, ");
		sb.append("  cg.spec, cg.price, cg.amt*cg.eu_direct as amt, cg.amt_ratio*cg.eu_direct as amt_ratio, ");
		sb.append(" cg.id_srv, cg.id_srvca, cg.id_srvtp, cg.code_srv, cg.fg_mm, ");
		sb.append(" cg.id_pripat, cg.fg_additm, cg.id_mm, cg.id_mmtp, cg.code_mm, cg.cd_batch, cg.pgku_base, ");
		sb.append(" cg.pgku_cur, cg.onlycode, cg.fg_bb, cg.code_inccaitm, cg.name_inccaitm,  ");
		sb.append("  0 as quan_mend,0 as quan_refunded,mm.fg_charge ");
		sb.append(" from bl_cg_ip cg left join bd_mm mm on mm.id_mm = cg.id_mm  ");
		sb.append(" where   cg.eu_direct = 1  and cg.fg_st = 'N' ");
		sb.append(" and ").append(sqlSrvIds);
		FBoolean isMerge = BlParams.BLSTIP0005();
		String whereStr = " ";
		if (FBoolean.TRUE.equals(isMerge)) {
			whereStr += " and ( cg.id_ent = ? or cg.id_ent_mom = ?  ) ";
			param.addParam(id_ent);
		} else {
			whereStr += " and cg.id_ent = ?  ";
		}
		sb.append(whereStr);
		param.addParam(id_ent);

		sb.append(" order by cg.dt_cg desc, cg.name_srv");
		@SuppressWarnings("unchecked")
		List<BlIpFeeInfo> feeList = (List<BlIpFeeInfo>)new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(BlIpFeeInfo.class));
		//查询负方向明细
		StringBuilder sql = new StringBuilder();
		sql.append(
				" select cg.id_ent,cg.id_cgip, cg.name_srv, cg.name_mm, cg.quan*cg.eu_direct as quan, cg.srvu, cg.price_ratio, ");
		sql.append(" cg.id_dep_or, cg.id_emp_or,cg.id_dep_mp, cg.id_dep_cg,cg.id_emp_cg,cg.sd_srvtp, ");
		sql.append(" cg.spec, cg.price, cg.amt*cg.eu_direct as amt, cg.amt_ratio*cg.eu_direct as amt_ratio, ");
		sql.append(" cg.id_srv, cg.id_srvca, cg.id_srvtp, cg.code_srv, cg.fg_mm, ");
		sql.append(" cg.id_pripat, cg.fg_additm, cg.id_mm, cg.id_mmtp, cg.code_mm, cg.cd_batch, cg.pgku_base, ");
		sql.append(" cg.pgku_cur, cg.onlycode, cg.fg_bb, cg.dt_cg, cg.code_inccaitm, cg.name_inccaitm, cg.id_par  ");
		sql.append(" from bl_cg_ip cg  where cg.eu_direct = -1 and cg.fg_st = 'N'  ");
		sql.append(" and ").append(sqlSrvIds);	
		sql.append(whereStr);
		sql.append(" order by cg.dt_cg desc ");
		List<BlIpFeeInfo> list = (List<BlIpFeeInfo>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlIpFeeInfo.class));
		//从正向明细中扣除已退的数量和已退金额
		for(BlIpFeeInfo itm :feeList) {
			for(BlIpFeeInfo dto : list) {
				if(itm.getId_cgip().equals(dto.getId_par())) {
					//itm.setQuan_mend(itm.getQuan_mend().sub(dto.getQuan().abs()));
					itm.setQuan_refunded(itm.getQuan_refunded().add(dto.getQuan().abs()));
				}
			}
		}	
		//获取计量单位
		Map<String,MeasDocDO> measMap = this.getMeasdocInfos();
		//获取部门名称
		Map<String,DeptDO> deptMap = this.getDeptDOInfos();
		//获取人员名称
		Map<String,PsnDocDO> psnMap = this.getPsnDocDOInfos();
		
		for(BlIpFeeInfo dto : feeList) {
			//计量单位
			if(!StringUtils.isEmptyWithTrim(dto.getSrvu()) && measMap.get(dto.getSrvu()) != null) {
		    	dto.setName_srvu(measMap.get(dto.getSrvu()).getName());
		    }
			//开单科室
			if(!StringUtils.isEmptyWithTrim(dto.getId_dep_or()) && deptMap.get(dto.getId_dep_or()) != null) {
				dto.setName_dep_or(deptMap.get(dto.getId_dep_or()).getName());
			}
			//开单医生
			if(!StringUtils.isEmptyWithTrim(dto.getId_emp_or()) && psnMap.get(dto.getId_emp_or()) != null) {
				dto.setName_emp_or(psnMap.get(dto.getId_emp_or()).getName());
			}
			//执行科室
			if(!StringUtils.isEmptyWithTrim(dto.getId_dep_mp()) && deptMap.get(dto.getId_dep_mp()) != null) {
				dto.setName_dep_mp(deptMap.get(dto.getId_dep_mp()).getName());	
			}
			//记账科室
			if(!StringUtils.isEmptyWithTrim(dto.getId_dep_cg()) && deptMap.get(dto.getId_dep_cg()) != null) {
				dto.setName_dep_cg(deptMap.get(dto.getId_dep_cg()).getName());
			}
			//记账人员
			if(!StringUtils.isEmptyWithTrim(dto.getId_emp_cg()) && psnMap.get(dto.getId_emp_cg()) != null) {	
				dto.setName_emp_cg(psnMap.get(dto.getId_emp_cg()).getName());
			}
		}
		return feeList.toArray(new BlIpFeeInfo[]{});
	}
	
	/**
	 * 获取单位信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	private Map<String,MeasDocDO> getMeasdocInfos() throws BizException{
		Map<String,MeasDocDO> measMap = new HashMap<String,MeasDocDO>();
		DAFacade dafacade=new DAFacade();
		List<MeasDocDO> measLst=(List<MeasDocDO>)dafacade.execQuery("SELECT ID_MEASDOC,CODE,NAME FROM BD_MEASDOC", new BeanListHandler(MeasDocDO.class));
		if(measLst == null || measLst.size() == 0){
			throw new BizException("计量单位信息不存在！");
		}
		for(MeasDocDO measDocDO : measLst){
			measMap.put(measDocDO.getId_measdoc(), measDocDO);
		}
		return measMap;
	}
	
	/**
	 * 获取部门名称
	 * @return
	 * @throws BizException
	 */
	private Map<String,DeptDO> getDeptDOInfos() throws 	BizException{
		Map<String,DeptDO> measMap = new HashMap<String,DeptDO>();
		DAFacade dafacade=new DAFacade();
		List<DeptDO> measLst=(List<DeptDO>)dafacade.execQuery("SELECT ID_DEP,CODE,NAME FROM BD_DEP", new BeanListHandler(DeptDO.class));
		if(measLst == null || measLst.size() == 0){
			throw new BizException("部门信息不存在！");
		}
		for(DeptDO measDocDO : measLst){
			measMap.put(measDocDO.getId_dep(), measDocDO);
		}
		return measMap;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String,PsnDocDO> getPsnDocDOInfos() throws 	BizException{
		Map<String,PsnDocDO> measMap = new HashMap<String,PsnDocDO>();
		DAFacade dafacade=new DAFacade();
		List<PsnDocDO> measLst=(List<PsnDocDO>)dafacade.execQuery("SELECT ID_PSNDOC,CODE,NAME FROM BD_PSNDOC", new BeanListHandler(PsnDocDO.class));
		if(measLst == null || measLst.size() == 0){
			throw new BizException("人员信息不存在！");
		}
		for(PsnDocDO measDocDO : measLst){
			measMap.put(measDocDO.getId_psndoc(), measDocDO);
		}
		return measMap;
	}
}
