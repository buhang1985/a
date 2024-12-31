package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院属性EP
 * 
 * @author zhengcm
 * @date 2016-07-07 11:35:40
 *
 */
public class IpEP {

	/**
	 * 根据就诊id获取住院属性DO数据
	 * 
	 * @param entId
	 *            门诊id
	 * @return 住院属性DO数组
	 * @throws BizException
	 */
	public InpatientDO[] getIpDOByEntId(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		// 住院信息查询服务
		IInpatientRService qryService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] ipDOs = qryService.findByAttrValString(InpatientDO.ID_ENT, entId);
		return ipDOs;
	}
	
	/**
	 * 根据entid 查找在院的患者
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public InpatientDO[] getIpDOsInHos(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		// 住院信息查询服务
		IInpatientRService qryService = ServiceFinder.find(IInpatientRService.class);
		String whereStr = String.format("Id_ent = '%s' and Sd_status = '%s'", entId, IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);
		InpatientDO[] ipDOs = qryService.find(whereStr, null, FBoolean.FALSE);
		return ipDOs;
	}
	
	/**
	 * 根据就诊id获取住院DO
	 * 就诊和住院信息是1对1关系
	 * 
	 * @param entId 就诊id
	 * @return 住院属性DO
	 * @throws BizException
	 * @author yank
	 */
	public InpatientDO getIpByEntId(String entId) throws BizException {
		InpatientDO[] ipDOs = getIpDOByEntId(entId);
		if(EnValidator.isEmpty(ipDOs)) {
			return null;
		}
		return ipDOs[0];
	}
	/**
	 * 根据就诊ID删除就诊住院信息
	 * 
	 * @author zhengcm
	 * @param entId
	 *            就诊ID
	 * @throws BizException
	 */
	public void deleteByEntId(String entId) throws BizException {
		InpatientDO[] nbIpDOs = getIpDOByEntId(entId);
		if (EnValidator.isEmpty(nbIpDOs)) {
			return;
		}
		IInpatientCudService cmdService = ServiceFinder.find(IInpatientCudService.class);
		cmdService.delete(nbIpDOs);
	}

	/**
	 * 新增就诊住院信息
	 * 
	 * @author zhengcm
	 * @param dos
	 *            就诊住院DO数组
	 * @throws BizException
	 */
	public InpatientDO[] insertIpDOs(InpatientDO[] dos) throws BizException {
		if (EnValidator.isEmpty(dos)) {
			return null;
		}
		// 就诊住院维护服务
		IInpatientCudService cmdService = ServiceFinder.find(IInpatientCudService.class);
		return cmdService.insert(dos);
	}

	/**
	 * 更新就诊住院信息
	 * 
	 * @author zhengcm
	 * @param dos
	 *            就诊住院信息DO数组
	 * @return 更新后的就诊住院DO数据
	 * @throws BizException
	 */
	public InpatientDO[] updateIpDOs(InpatientDO[] dos) throws BizException {
		if (EnValidator.isEmpty(dos)) {
			return null;
		}
		// 就诊住院维护服务
		IInpatientCudService cmdService = ServiceFinder.find(IInpatientCudService.class);
		return cmdService.update(dos);
	}

	/**
	 * 判断是不是有住院数据
	 * @param idPat
	 * @throws DAException
	 */
	public FBoolean IsInHos(String idPat) throws DAException
	{
		StringBuffer sqlSb = new StringBuffer();
	
		sqlSb.append(" Select ent.id_ent,");
		sqlSb.append(" ip.id_inpatient");
	
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip");
		sqlSb.append(" on ent.id_ent = ip.id_ent");
	
		sqlSb.append(" where ent.id_pat = ? ");
		sqlSb.append(" and ent.fg_canc = ? ");
		sqlSb.append("  and ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" 																								
					+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
		
		SqlParam param = new SqlParam();
		param.addParam(idPat);
		param.addParam(FBoolean.FALSE);
		
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		if(!EnValidator.isEmpty(list))
			return FBoolean.TRUE;
		return FBoolean.FALSE;
	}
	/**
	 * 批量更新住院表的床位信息 
	 * @param entList
	 * @throws BizException 
	 */
	public void updateIpBedInfo(ArrayList<String> entList,String nameBed,String idBed) throws BizException{
		if(EnValidator.isEmpty(entList)){
			return;
		}
	//	IInpatientRService RService = ServiceFinder.find(IInpatientRService.class);
		IInpatientCudService cudService = ServiceFinder.find(IInpatientCudService.class);
	//	String entStr = EnSqlUtils.buildIdStr(entList);
	//	String str = InpatientDODesc.TABLE_ALIAS_NAME+".id_ent in ("+entStr+")"+"  and "+ InpatientDODesc.TABLE_ALIAS_NAME+".sd_status = '"+IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN+"'";
		InpatientDO[] inpatientDOs = this.getInpatientDOs(entList);
		if(EnValidator.isEmpty(inpatientDOs)){
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		for(InpatientDO ipDO :inpatientDOs){
			ipDO.setStatus(DOStatus.UPDATED); 
			ipDO.setId_bed(idBed); 
			ipDO.setName_bed(nameBed);	
		}
		cudService.update(inpatientDOs);
	}

	/**
	 * 批量查询住院数据
	 * @param entList
	 * @return
	 * @throws BizException
	 */
	public InpatientDO[] getInpatientDOs(List<String> entList) throws BizException{				
		if(EnValidator.isEmpty(entList))
			return null;
		IInpatientRService RService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = RService.findByAttrValStrings(InpatientDO.ID_ENT, entList.toArray(new String[0]));
		if(EnValidator.isEmpty(inpatientDOs)){
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		return inpatientDOs;
	}
	/**
	 * 更新在径标志
	 * @param entId 就诊ID
	 * @param fgIncp 是否在径
	 * @throws BizException
	 * @author yank
	 */
	public void updateIncpFlag(String entId,String status) throws BizException{
		EnValidator.validateParam("就诊ID", entId);
		EnValidator.validateParam("入径状态", status);
		
		//1、查询住院信息
		InpatientDO[] ipDOs = this.getIpDOByEntId(entId);
		if(EnValidator.isEmpty(ipDOs)){
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		
		//2、更新住院信息
		ipDOs[0].setEu_incp(status);
		ipDOs[0].setStatus(DOStatus.UPDATED);
		this.save(ipDOs[0]);
	}
	/**
	 * 保存住院信息
	 * @param ipDO 住院DO
	 * @throws BizException
	 */
	public void save(InpatientDO ipDO) throws BizException {
		IInpatientCudService ipCudService = ServiceFinder.find(IInpatientCudService.class);
		ipCudService.save(new InpatientDO[] { ipDO });
	}
	/**
	 * 保存住院信息
	 * @param ipDO 住院DO
	 * @throws BizException
	 */
	public void save(InpatientDO[] ipDOs) throws BizException {
		IInpatientCudService ipCudService = ServiceFinder.find(IInpatientCudService.class);
		ipCudService.save( ipDOs);
	}
	
	/**
	 * 校验患者是不是在院
	 * @param patId
	 * @throws BizException
	 */
	public void validateInpatientDO(String patId) throws BizException{
		
		StringBuffer ipntBuffer = new StringBuffer();
		ipntBuffer.append("select ip.sd_status,ent.id_ent ");
		ipntBuffer.append(" from en_ent ent");
		ipntBuffer.append(" inner join en_ent_ip  ip");
		ipntBuffer.append(" on ip.id_ent  = ent.id_ent");
		ipntBuffer.append(" where  ent.id_pat = ?  and ent.fg_canc = ? and (ip.sd_status = ? or ip.sd_status= ?) and ent.fg_canc= 'N'");
		
		

		String ipntSql = ipntBuffer.toString();
		SqlParam ipntParam = new SqlParam();
		ipntParam.addParam(patId);
		ipntParam.addParam(FBoolean.FALSE);
		ipntParam.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		ipntParam.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);

		@SuppressWarnings("unchecked")
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade().execQuery(ipntSql, ipntParam, new BeanListHandler(InpatientDO.class));
		if (!list.isEmpty()) {
			if( IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(list.get(0).getSd_status())){
				throw new BizException(IEnMsgConst.ERROR_SD_STATUS_INHOS);
			}
			if( IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(list.get(0).getSd_status() )){
				throw new BizException(IEnMsgConst.ERROR_SD_STATUS_INREG);
			}
		}
	}
	
	/**
	 * 校验患者状态
	 * 
	 * @param inpatientDO
	 * @throws BizException
	 */
	public void validateInpatientDO(InpatientDO inpatientDO) throws BizException {
		if (!(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(inpatientDO.getSd_status()))) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_INDEPT);
		}
	}
	
	/**
	 * 患者数据发生状态改变，页面数据没刷新的情况
	 * @param endId
	 * @throws BizException
	 */
	public void validateInpatientDOStatus(String entId) throws BizException{
		if(EnValidator.isEmpty(entId))
			return;
		InpatientDO[] inpados = this.getIpDOByEntId(entId);
		
		if(EnValidator.isEmpty(inpados)){
			return ;
		}
		if (!inpados[0].getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN) &&!inpados[0].getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
	}
	
	
	
	/**
	 * 校验患者状态
	 * 
	 * @param inpatientDO
	 * @throws BizException
	 */
	public void validateInpatientDOByEntId(String entId) throws BizException {			
		InpatientDO[] inpados = this.getIpDOsInHos(entId);
		if(EnValidator.isEmpty(inpados)){
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
		if (!inpados[0].getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
	}
	/**
	 * 设置入院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public int setIpTimes(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		/*sql.append(" select  max(nvl(times_ip,0))  times_ip from en_ent_ip  ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");*/
		//住院次数取患者表中的last_times_ip - zhangpp 2019.07.03
		sql.append(" select nvl(last_times_ip,0) times_ip from pi_pat ");
		sql.append(" where id_pat = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);

		//FArrayList list = AppFwUtil.getMapListWithDao(sql.toString());
        Integer times_ip = (Integer)new DAFacade().execQuery(sql.toString(), param, new ColumnHandler());
		if (times_ip == null || times_ip < 0) {
			times_ip = 0;
		}
		return times_ip + 1;
	}
		
	/**
	 * 设置患者表的出院次数 
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public int setPatTimes(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  max(nvl(times_ip,0)) times_ip from en_ent_ip ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");
		sql.append(" where id_pat = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);
        Integer times_ip = (Integer)new DAFacade().execQuery(sql.toString(), param, new ColumnHandler());
		if (times_ip == null || times_ip <= 0 ) {
			times_ip = 0;
			}
		return times_ip;
		}
	/**
	 * 设置出院次数(住院次数-1)
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public int setCanCelTimes(String patId) throws BizException {
		int times = 0;
		StringBuilder sql = new StringBuilder();
		sql.append(" select nvl(last_times_ip,0) times_ip from pi_pat ");
		sql.append(" where id_pat = '");
		sql.append(patId);
		sql.append("'");

		FArrayList list = AppFwUtil.getMapListWithDao(sql.toString());
		if (!EnValidator.isEmpty(list)) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			if ((Integer) map.get("times_ip") != null) {
				times = (Integer) map.get("times_ip");
			}
		}

		return times - 1;
	}
}
