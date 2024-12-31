package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 得到医生出诊队列
 * 
 * @author liu bin
 *
 */
public class GetQueBP {
	
	/**
	 * 找到医生出诊队列
	 * 
	 * @param siteInfo 站点信息
	 * @return 
	 * 		出诊队列DO
	 * @throws BizException
	 */
	public QueDO[] exec(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if(siteInfo == null)
			return null;
		//1.获取该科室该医生已有排班对应的队列
		QueDO[] ques = this.getSchQue(siteInfo);
		if(!EnValidator.isEmpty(ques)){
			return ques;
		}
		//2.获取该科室该医生已有计划对应的队列
		return this.getPlQue(siteInfo.getId_emp(), siteInfo.getId_dep());
	}
	/**
	 * 获取该科室该医生已有排班对应的队列
	 * 
	 * @param empId
	 * @param deptId
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getSchQue(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		List<QueDO> list = new LinkedList<>();
		//1.找指定医生对应排班的出诊队列（专家队列和医疗组队列）
		QueDO[] empWgQues = this.getEmpAndWgSchQues(siteInfo);
		if(!EnValidator.isEmpty(empWgQues)){
			//有排班医生是否可以使用科室普通号
			if(!EnParamUtils.isUseDeptSch(siteInfo.getId_dep()))
				return empWgQues;
			list.addAll(Arrays.asList(empWgQues));
		}
		//2.找出诊科室对应排班的出诊队列
		QueDO[] depQues = this.getDepSchQues(siteInfo);
		if(!EnValidator.isEmpty(depQues)){
			list.addAll(Arrays.asList(depQues));
		}
		return EnValidator.isEmpty(list)?null:list.toArray(new QueDO[0]);
	}
	/**
	 * 获取该科室该医生已有计划对应的队列
	 * 
	 * @param empId
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getPlQue(String empId, String deptId)throws BizException{
		//1.找指定医生对应的出诊队列（专家队列和医疗组队列）
		List<QueDO> list = new LinkedList<>();
		QueDO[] empWgQues = this.getEmpAndWgPlQues(empId, deptId);
		if(!EnValidator.isEmpty(empWgQues)){
			list.addAll(Arrays.asList(empWgQues));
		}
		//2.找出诊科室对应的出诊队列
		QueDO[] depQues = this.getDepPlQues(deptId);
		if(!EnValidator.isEmpty(depQues)){
			list.addAll(Arrays.asList(depQues));
		}
		return EnValidator.isEmpty(list)?null:list.toArray(new QueDO[0]);
	}
	/**
	 * 获取指定医生对应排班的专家队列或医疗组队列
	 * 
	 * @param empId
	 * @param deptId
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getEmpAndWgSchQues(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(EnValidator.isEmpty(siteInfo.getId_dep()) 
				|| EnValidator.isEmpty(siteInfo.getId_emp()) 
				|| EnValidator.isEmpty(siteInfo.getId_dayslot()))
			return null;
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BD_QUE.ID_QUE ");
		builder.append("FROM BD_QUE BD_QUE ");
		builder.append("INNER JOIN SC_PL SC_PL ON BD_QUE.ID_DEP = SC_PL.ID_DEP AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES AND BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ");
		builder.append("INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL ");
		builder.append("INNER JOIN SC_RES SC_RES ON SC_PL.ID_SCRES = SC_RES.ID_SCRES ");
		builder.append("WHERE BD_QUE.FG_ACTIVE = ? ");
		builder.append("AND SC_RES.SD_SCRESTP = ? ");
		builder.append("AND SC_RES.ID_EMP = ? ");
		builder.append("AND BD_QUE.ID_DEP = ? ");
		builder.append("AND SC_SCH.D_SCH = ? ");
		builder.append("AND SC_SCH.ID_DAYSLOT = ? ");
		builder.append("AND BD_QUE.SD_QUETP = ? ");
		builder.append("UNION ");
		builder.append("SELECT BD_QUE.ID_QUE ");
		builder.append("FROM BD_QUE BD_QUE ");
		builder.append("INNER JOIN SC_PL SC_PL ON BD_QUE.ID_DEP = SC_PL.ID_DEP AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES AND BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ");
		builder.append("INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL ");
		builder.append("INNER JOIN SC_RES SC_RES ON SC_PL.ID_SCRES = SC_RES.ID_SCRES ");
		builder.append("INNER JOIN BD_EMP_WG BD_EMP_WG ON BD_EMP_WG.ID_WG = SC_RES.ID_WG ");
		builder.append("WHERE BD_QUE.FG_ACTIVE = ? ");
		builder.append("AND SC_RES.SD_SCRESTP = ? ");
		builder.append("AND BD_EMP_WG.ID_EMP = ? ");
		builder.append("AND BD_QUE.ID_DEP = ? ");
		builder.append("AND SC_SCH.D_SCH = ? ");
		builder.append("AND SC_SCH.ID_DAYSLOT = ? ");
		builder.append("AND BD_QUE.SD_QUETP = ? ");
		builder.append("AND NVL(BD_EMP_WG.D_B, ?) <= ? ");
		builder.append("AND NVL(BD_EMP_WG.D_E, ?) >= ?  ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		param.addParam(siteInfo.getId_emp());
		param.addParam(siteInfo.getId_dep());
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(IScDictCodeConst.SD_SCRESTP_WG);
		param.addParam(siteInfo.getId_emp());
		param.addParam(siteInfo.getId_dep());
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		FDate date = EnAppUtils.getServerDate();
		param.addParam(date);
		param.addParam(date);
		param.addParam(date);
		param.addParam(date);
		return this.getQues(sql, param);
	}
	/**
	 * 得到有排班的普通队列
	 * 
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getDepSchQues(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(EnValidator.isEmpty(siteInfo.getId_dep()) 
				|| EnValidator.isEmpty(siteInfo.getId_dayslot()))
			return null;
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BD_QUE.ID_QUE ");
		builder.append("FROM BD_QUE BD_QUE ");
		builder.append("INNER JOIN SC_PL SC_PL ON BD_QUE.ID_DEP = SC_PL.ID_DEP AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES AND BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ");
		builder.append("INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL ");
		builder.append("INNER JOIN SC_RES SC_RES ON SC_PL.ID_SCRES = SC_RES.ID_SCRES ");
		builder.append("WHERE BD_QUE.FG_ACTIVE = ? ");
		builder.append("AND SC_RES.SD_SCRESTP = ? ");
		builder.append("AND SC_RES.ID_DEP = ? ");
		builder.append("AND BD_QUE.ID_DEP = ? ");
		builder.append("AND SC_SCH.D_SCH = ? ");
		builder.append("AND SC_SCH.ID_DAYSLOT = ? ");
		builder.append("AND BD_QUE.SD_QUETP = ? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(IScDictCodeConst.SD_SCRESTP_DEP);
		param.addParam(siteInfo.getId_dep());
		param.addParam(siteInfo.getId_dep());
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
        param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		return this.getQues(sql, param);
	}
	/**
	 * 得到专家队列或医疗组队列
	 * 
	 * @param empId
	 * @param deptId
	 * @return
	 * @throws BizException 
	 */
	private QueDO[] getEmpAndWgPlQues(String empId, String deptId) throws BizException{
		if(EnValidator.isEmpty(deptId) || EnValidator.isEmpty(empId))
			return null;
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT QUE.ID_QUE ");
		builder.append("FROM BD_QUE QUE ");
		builder.append("INNER JOIN SC_RES RES ON QUE.ID_SCRES=RES.ID_SCRES ");
		builder.append("WHERE RES.ID_EMP = ? ");
		builder.append("AND QUE.ID_DEP = ? ");
		builder.append("AND RES.SD_SCRESTP = ? ");
		builder.append("AND QUE.FG_ACTIVE = ? ");
		builder.append("AND QUE.SD_QUETP = ? ");
		builder.append("UNION ");
		builder.append("SELECT DISTINCT QUE.ID_QUE ");
		builder.append("FROM BD_QUE QUE ");
		builder.append("INNER JOIN SC_RES RES ON QUE.ID_SCRES=RES.ID_SCRES ");
		builder.append("INNER JOIN BD_EMP_WG BD_EMP_WG ON BD_EMP_WG.ID_WG = RES.ID_WG ");
		builder.append("WHERE BD_EMP_WG.ID_EMP = ? ");
		builder.append("AND QUE.ID_DEP= ? ");
		builder.append("AND QUE.FG_ACTIVE = ? ");
		builder.append("AND QUE.SD_QUETP = ? ");
		builder.append("AND NVL(BD_EMP_WG.D_B, ?) <= ? ");
		builder.append("AND NVL(BD_EMP_WG.D_E, ?) >= ?  ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(empId);
		param.addParam(deptId);
		param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		param.addParam(FBoolean.TRUE);
        param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(empId);
		param.addParam(deptId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		FDate date = EnAppUtils.getServerDate();
		param.addParam(date);
		param.addParam(date);
		param.addParam(date);
		param.addParam(date);
		return this.getQues(sql, param);
	}
	/**
	 * 得到普通队列
	 * 
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getDepPlQues(String deptId) throws BizException{
		if(EnValidator.isEmpty(deptId))
			return null;
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT QUE.ID_QUE ");
		builder.append("FROM BD_QUE QUE ");
		builder.append("INNER JOIN SC_RES RES ON QUE.ID_SCRES=RES.ID_SCRES ");
		builder.append("WHERE QUE.ID_DEP = ? ");
		builder.append("AND RES.SD_SCRESTP = ? ");
		builder.append("AND QUE.FG_ACTIVE = ? ");
		builder.append("AND QUE.SD_QUETP = ? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(deptId);
		param.addParam(IScDictCodeConst.SD_SCRESTP_DEP);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		return this.getQues(sql, param);
	}
	/**
	 * 得到QueDO集合
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getQues(String sql, SqlParam param) throws BizException{
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return ServiceFinder.find(IQueRService.class).findByIds(list.toArray(new String[0]), FBoolean.FALSE);
		}
		return null;
	}
}
