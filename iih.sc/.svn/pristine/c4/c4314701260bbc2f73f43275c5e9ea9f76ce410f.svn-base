package iih.sc.apt.s.bp.ip;

import com.mysql.jdbc.StringUtils;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.comm.IScConst;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消住院预约
 * @author zhouliming
 *
 */
public class CancIpAptBP {
	/**
	 * 取消住院预约
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	public void exec(AptIpDTO aptDTO,String letParam) throws BizException{
		//校验数据有效性
		validate(aptDTO,letParam);
		String id_scaptip = aptDTO.getId_scaptip();
		String id_bed = aptDTO.getId_bed();
		
		//更新申请单状态
		IAptipMDORService rService = ServiceFinder.find(IAptipMDORService.class);
		IAptipMDOCudService cudService = ServiceFinder.find(IAptipMDOCudService.class);
		//TODO 这里查询原来的节点 没有加查询条件  具体看需求 如果没有查询到 应该throw 抛出异常 住院申请单在别处被修改
		AptIpDO	aptIpDO = rService.findById(id_scaptip);
		if(aptIpDO == null){
			throw new BizException(IScMsgConst.SC_QUERY_FAIL);
		}
		aptIpDO.setId_bed(null);//床位号
		aptIpDO.setId_emp_appt(null);//预约人
		aptIpDO.setDt_appt(null);//预约时间
		aptIpDO.setSd_status(EuStatus.APPY);//修改申请单状态为申请
		cudService.update(new AptIpDO[]{aptIpDO});
		//修改床位状态
		IBedMDORService bedRService = ServiceFinder.find(IBedMDORService.class);
		IBedMDOCudService bedCudService = ServiceFinder.find(IBedMDOCudService.class);
		Bdbed bdbed = bedRService.findById(id_bed);
		if(bdbed == null){
			throw new BizException(IScMsgConst.SC_QUERY_FAIL);
		}
		bdbed.setFg_appt(FBoolean.FALSE);//修改预约状态为否
		bedCudService.update(new Bdbed[]{bdbed});
	}
	/**
	 * 校验申请单是否可取消预约
	 * @param aptDTO
	 * @throws BizException 
	 */
	private void validate(AptIpDTO aptDTO,String letParam) throws BizException{
		if(aptDTO == null) return;
		//String sd_status = aptDTO.getSd_status();//预约状态
		String sd_status = this.getSdStatusBySql(aptDTO);//fanlq-2018.03.30
//		FBoolean fg_canc = aptDTO.getFg_canc();//预约状态
		if(IScConst.SC_IP_APPT.equals(letParam)){
			if(!StringUtils.isNullOrEmpty(sd_status) && !sd_status.equals(EuStatus.ARRANG)){
				throw new BizException(IScMsgConst.SC_APT_IP_CANCELAPT);
			}
		}
		if(IScConst.SC_IP_FEEDBACK.equals(letParam)){
			if(!StringUtils.isNullOrEmpty(sd_status) && !(sd_status.equals(EuStatus.ARRANG) || sd_status.equals(EuStatus.CONFIRM))){
				throw new BizException(IScMsgConst.SC_APT_IP_CANCELAPT_FEEDBACK);
			}
		}
	}
	
	/***
	 * 通过sql查询预约状态，判断是否可以取消预约
	 * @author fanlq 2018.03.30
	 * @param aptDTO
	 * @return
	 * @throws BizException
	 */
	private String getSdStatusBySql(AptIpDTO aptDTO) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT  ip.sd_status as sd_status ");
		sqlBuilder.append("from sc_apt_ip ip ");
		sqlBuilder.append("inner join en_ent ent on ent.id_ent = ip.id_ent ");
		sqlBuilder.append("where ent.code = ? ");
		SqlParam param = new SqlParam();
		param.addParam(aptDTO.getCode_ent());
		String sd_status = (String)new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return sd_status;
	}
}
