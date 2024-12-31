package iih.bd.res.empdep.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.res.empdep.d.DepsEmpDTO;
import iih.bd.res.empdep.d.EmpDepDO;
import iih.bd.res.empdep.i.IEmpdepCudService;
import iih.bd.res.empdep.i.IEmpdepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 科室员工关系维护BP
 * @author liubin
 *
 */
public class DepsEmpBP {
	/**
	 * 获取科室下的员工集合
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public DepsEmpDTO[] getDepsEmpList(String depId) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EMPDEP.ID_EMPDEP AS ID_EMPDEP,");
		sb.append("EMPDEP.ID_EMP AS ID_EMP,");
		sb.append("EMP.CODE AS CODE_EMP,");
		sb.append("EMP.NAME AS NAME_EMP,");
		sb.append("EMP.BIRTHDAY AS D_BRITH,");
		sb.append("JOB.ID_JOB AS ID_JOB,");
		sb.append("JOB.NAME AS NAME_JOB,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("DEP.NAME AS NAME_DEP_BELONG,");
		sb.append("EMP.MOBILE AS MOB,");
		sb.append("EMPDEP.ID_DEP AS ID_DEP,");
		sb.append("EMPDEP.D_B AS D_B,");
		sb.append("EMPDEP.D_E AS D_E ");
		sb.append("FROM BD_EMP_DEP EMPDEP ");
		sb.append("LEFT JOIN BD_PSNDOC EMP ON EMPDEP.ID_EMP = EMP.ID_PSNDOC ");
		sb.append("LEFT JOIN BD_JOB JOB ON EMPDEP.ID_EMPDUTY = JOB.ID_JOB ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON EMP.SEX = SEX.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_DEP DEP ON EMP.ID_DEP = DEP.ID_DEP ");
		sb.append("WHERE EMPDEP.ID_DEP = ? ");
		sb.append("ORDER BY EMPDEP.ID_EMPDEP ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(depId);
		List<DepsEmpDTO> list = (List<DepsEmpDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(DepsEmpDTO.class));
		if(!ListUtil.isEmpty(list)){
			return list.toArray(new DepsEmpDTO[0]);
		}
		return null;
	}
	/**
	 * 保存
	 * @param empDTOs
	 */
	public void save(DepsEmpDTO[] empDTOs) throws BizException{
		if(ArrayUtil.isEmptyNoNull(empDTOs)){
			throw new BizException("保存数据为空！");
		}
		String[] empDepIds = getEmpDepIds(empDTOs);
		EmpDepDO[] empDepDOs = null;
		if(!ArrayUtil.isEmptyNoNull(empDepIds)){
			IEmpdepRService empDepRservice = ServiceFinder.find(IEmpdepRService.class);
			empDepDOs = empDepRservice.findByIds(empDepIds, FBoolean.FALSE);
		}
		List<EmpDepDO> list = new ArrayList<EmpDepDO>();
		for(DepsEmpDTO empDTO : empDTOs){
			EmpDepDO empDepDO = null;
			if(empDTO.getStatus() == DOStatus.NEW){
				empDepDO = new EmpDepDO();
				empDepDO.setId_grp(Context.get().getGroupId());
				empDepDO.setId_org(Context.get().getOrgId());
				empDepDO.setStatus(DOStatus.NEW);
			}
			else if(empDTO.getStatus() == DOStatus.UPDATED||empDTO.getStatus() == DOStatus.DELETED){
				empDepDO = getEmpDepDO(empDTO.getId_empdep(), empDepDOs);
				if(empDepDO==null){
					throw new BizException("数据保存出错！");
				}
				empDepDO.setStatus(empDTO.getStatus());
			}else{
				continue;
			}
			empDepDO.setId_dep(empDTO.getId_dep());
			empDepDO.setId_emp(empDTO.getId_emp());
			empDepDO.setId_empduty(empDTO.getId_job());
			empDepDO.setD_b(empDTO.getD_b());
			empDepDO.setD_e(empDTO.getD_e());
			list.add(empDepDO);
		}
		IEmpdepCudService empDepCudService = ServiceFinder.find(IEmpdepCudService.class);
		empDepCudService.save(list.toArray(new EmpDepDO[0]));
	}
	
	private EmpDepDO getEmpDepDO(String empDepId,EmpDepDO[] empDepDOs){
		EmpDepDO empDepDO = null;
		if(!ArrayUtil.isEmptyNoNull(empDepDOs)){
			for (EmpDepDO empDO : empDepDOs) {
				if(empDepId!=null&&empDepId.equals(empDO.getId_empdep())){
					empDepDO = empDO;
					break;
				}
			}
		}
		return empDepDO;
	}
	
	/**
	 * 得到DepsEmpDTO的id_empdep主键集合
	 * 
	 * @param empDTOs
	 * @return
	 */
	private String[] getEmpDepIds(DepsEmpDTO[] empDTOs){
		if(ArrayUtil.isEmptyNoNull(empDTOs))
			return null;
		List<String> list = new ArrayList<String>();
		for(DepsEmpDTO empDTO : empDTOs){
			if(!StringUtil.isEmptyWithTrim(empDTO.getId_empdep())){
				list.add(empDTO.getId_empdep());
			}
		}
		if(list.size()>0){
			return list.toArray(new String[0]);
		}
		return null;
	}
}
