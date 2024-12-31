package iih.ei.std.s.v1.bp.en;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.en.cancapt.d.CancAptParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 取消预约
 * @author fanlq
 * @date: 2019年10月12日 上午11:12:26
 */
public class CancAptBP extends IIHServiceBaseBP<CancAptParamDTO, NoParamDTO> {

	@Override
	protected void checkParam(CancAptParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getId_apt())) {
			throw new BizException("预约id不能为空！");
		}
	}

	@Override
	protected NoParamDTO process(CancAptParamDTO param) throws BizException {
		ScAptDO apt = this.getScApt(param.getId_apt());
		//1.校验预约状态
		this.volidateAptStatus(apt);
		OpAptDTO aptDTO = new OpAptDTO();
		//2.组装OpAptDTO
		this.wrapOpApt(aptDTO, apt);
		//3.取消预约
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		serv.cancOpApt(aptDTO);
		return new NoParamDTO();
	}
	/**
	 * 获取预约记录
	 * 
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param requestDate 预约日期
	 * @param dayslotType 午别类型
	 * @param scsrvCode 服务编码
	 * @param seqNo 顺序号
	 * @return
	 * @throws BizException 
	 * @throws Exception 
	 */
	private ScAptDO getScApt(String aptId) throws BizException{
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}
	/***
	 * @Description:校验预约状态
	 * @param apt
	 * @throws BizException 
	 */
	private void volidateAptStatus(ScAptDO apt) throws BizException{
		if(apt == null) {
			throw new BizException("没找到对应预约记录");
		}
		if(FBoolean.TRUE.equals(apt.getFg_canc())){
			throw new BizException("该预约已经取消, 不能再次取消预约!");
		}
		if(IScDictCodeConst.SD_APTSTATUS_PAY.equals(apt.getSd_status())){
			throw new BizException("预约已经支付, 不能取消预约!");
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status())){
			throw new BizException("预约已经完成, 不能取消预约!");
		}
	}
	/**
	 * 组装OpAptDTO
	 * 
	 * @param aptDTO
	 * @param apt
	 * @throws BizException 
	 */
	private void wrapOpApt(OpAptDTO aptDTO, ScAptDO apt) throws BizException{
		aptDTO.setId_apt(apt.getId_apt());
		if(FBoolean.TRUE.equals(apt.getFg_payment())){
			throw new BizException("预约已经支付, 不能取消预约!");
		}
	}
}
