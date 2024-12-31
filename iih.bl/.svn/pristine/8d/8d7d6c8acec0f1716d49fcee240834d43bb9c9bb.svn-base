package iih.bl.st.listrener.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class BlStLinstrenerBp {
	
	public PatDO getPatDOInfo(String id_pat){
		return null;
	}
	
	/**
	 * 获取就诊数据
	 * @throws BizException 
	 * */
	public PatiVisitDO getEntInfo(String id_ent) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = service.findById(id_ent);
		if(patiVisitDO == null){
			throw new BizException("就诊信息不存在！");
		}
		return patiVisitDO;
	}
	
	/**
	 * 获取就诊属性信息
	 * */
	public InpatientDO getEntIpInfo(String id_ent) throws BizException{
		IInpatientRService ipService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOArr = ipService.find(" id_ent = '" + id_ent + "'", null, FBoolean.FALSE);
		if(inpatientDOArr == null || inpatientDOArr.length == 0){
			throw new BizException("就诊属性不存在！");
		}
		return inpatientDOArr[0];
	}
	
	/**
	 * 获取就诊医保计划
	 * */
	public EntHpDO getEntHpInfo(String id_ent) throws BizException{
		IEnthpRService hpService = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = hpService.find(" id_ent = '" + id_ent + "'", null, FBoolean.FALSE);
		if(entHpDOArr == null || entHpDOArr.length == 0){
			//throw new BizException("就诊医保计划不存在！");
			return null;
		}
		return entHpDOArr[0];
	}
	
	/**
	 * 获取记账数据
	 * */
	public BlCgIpDO[] getBlCgIpInfo(String id_stip) throws BizException{
		IBlcgqueryRService cgRService = ServiceFinder.find(IBlcgqueryRService.class);
		StringBuffer sqlQur = new StringBuffer();
		sqlQur.append(" a0.ID_STIP = '").append(id_stip).append("' ");
		BlCgIpDO[] blCgIpDOArr = cgRService.find(sqlQur.toString(), null, FBoolean.FALSE);
		if(blCgIpDOArr == null || blCgIpDOArr.length == 0){
			throw new BizException("记账信息不存在！");
		}
		return blCgIpDOArr;
	}
	
	/**
	 * 根据结算获取账单信息
	 * @param id_stip 结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBdIncCgInfoByIdStIp(String id_stip) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM, SUM(X.AMT_STD * X.EU_DIRECT) AS AMT ")
		   .append("FROM BL_CG_IP X ")
		   .append("JOIN BD_SRVCA Y ON X.ID_SRVCA = Y.ID_SRVCA ")
		   .append("LEFT JOIN (SELECT B.ID_INCCAITM, B.NAME AS NAME_INCCAITM, B.CODE AS CODE_INCCAITM, ")
		   .append("C.EU_SRVORCA, C.ID_SRV, C.ID_SRVCA,  D.CODE AS CODE_SRVCA ")
		   .append("FROM BD_INCCA A ")
		   .append("JOIN BD_INCCA_ITM B ON A.ID_INCCA = B.ID_INCCA ")
		   .append("JOIN BD_INCCA_ITM_REL C ON B.ID_INCCAITM = C.ID_INCCAITM ")
		   .append("LEFT JOIN BD_SRVCA D ON C.ID_SRVCA = D.ID_SRVCA ")
		   .append("WHERE A.ID_INCCA = '").append(IBdInccaCodeConst.ID_INHOS_INVOICE).append("') Z ON X.ID_SRV = Z.ID_SRV ")
		   .append("OR Y.CODE LIKE NVL(Z.CODE_SRVCA, '空') || '%' ")
		   .append("WHERE X.ID_STIP = '").append(id_stip).append("' ")
		   .append("GROUP BY Z.ID_INCCAITM, Z.NAME_INCCAITM, Z.CODE_INCCAITM ");
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[]{});
	}
	
	/**
	 * 票据分类信息
	 * */
	@SuppressWarnings({ "unchecked" })
	public Map<String,IncCaItmRelDO> getInccaInfo() throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT R.ID_INCCAITMREL,R.ID_INCCAITM,R.ID_SRV,R.ID_INCCA,R.ID_SRVCA,R.EU_SRVORCA ")
			 .append("FROM BD_INCCA_ITM_REL R ")
			 .append("LEFT JOIN BD_INCCA C ON C.ID_INCCA = R.ID_INCCA  ")
			 .append("WHERE C.CODE = '12' ");
		List<IncCaItmRelDO> result = (List<IncCaItmRelDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(IncCaItmRelDO.class));
		Map<String,IncCaItmRelDO> map = new HashMap<String,IncCaItmRelDO>();
		if(result != null && result.size() > 0){
			for(IncCaItmRelDO incCaItmRelDO : result){
				map.put(incCaItmRelDO.getId_srv(), incCaItmRelDO);
			}
		}
		return map;
	}
	
	/**
	 * 获取科室信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,DeptDO> getDeptInfo() throws BizException{
		Map<String,DeptDO> depMap = new HashMap<String,DeptDO>();
		DAFacade dafacade=new DAFacade();
		List<DeptDO> deptList = (List<DeptDO>)dafacade.execQuery("select id_dep,code,name from bd_dep", new BeanListHandler(DeptDO.class));
		if(deptList == null || deptList.size() == 0){
			throw new BizException("科室信息不存在！");
		}
		for(DeptDO deptDO : deptList){
			depMap.put(deptDO.getId_dep(), deptDO);
		}
		return depMap;
	}
	
	/**
	 * 获取患者医保计划信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,HPDO> getPatHpTpInfo() throws BizException{
		Map<String,HPDO> map = new HashMap<String,HPDO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select code,name from bd_hp");
		DAFacade dafacade=new DAFacade();
		List<HPDO> hptList = (List<HPDO>)dafacade.execQuery(sql.toString(), new BeanListHandler(HPDO.class));
		if(hptList == null || hptList.size() == 0){
			throw new BizException("患者对应的医保计划信息不存在！");
		}
		for(HPDO hpDO : hptList){
			map.put(hpDO.getId_hp(), hpDO);
		}
		return map;
	}
	
	/**
	 * 获取处方信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,CiPresDO> getCiPresInfo() throws BizException{
		Map<String,CiPresDO> map = new HashMap<String,CiPresDO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select c.id_pres,c.id_prestp,c.sd_prestp,b.name as prestp_name ")
			.append("from ci_pres c ")
			.append("left join bd_udidoc b on b.id_udidoc = c.id_prestp");
		DAFacade dafacade=new DAFacade();
		List<CiPresDO> prestList = (List<CiPresDO>)dafacade.execQuery(sql.toString(), new BeanListHandler(CiPresDO.class));
		if(prestList == null || prestList.size() == 0){
			throw new BizException("处方信息不存在！");
		}
		for(CiPresDO ciPresDO : prestList){
			map.put(ciPresDO.getId_pres(), ciPresDO);
		}
		return map;
	}

	/**
	 * 获取部门编码
	 * @throws BizException 
	 * */
	public String getDeptCodeById(String id_dept) throws BizException{
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO deptDO = service.findById(id_dept);
		if(deptDO == null){
			throw new BizException("没有查到对应部门！");
		}
		return deptDO.getCode();
	}
}
