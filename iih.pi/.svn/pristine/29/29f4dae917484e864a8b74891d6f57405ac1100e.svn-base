package iih.pi.reg.s.customer.guoji;

import java.sql.CallableStatement;
import java.sql.SQLException;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.customer.guoji.util.PiGjLogUtil;
import iih.pi.reg.s.customer.guoji.util.PiPatProcCallBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;

/**
 * chis建档(自费病人)
 * @author ly 2017/08/23
 *
 */
public class PiPatCreateByChisSelfPayBP extends PiPatProcCallBaseBP{

	@Override
	protected String getProcName() {
		return "{call proc_phone_createPerson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

	@Override
	protected void setParam(CallableStatement ps, PatiAggDO patAgg) throws SQLException {
		PatDO patDo = patAgg.getParentDO();
		PatiAddrDO addrDo = null;
		if(!ArrayUtil.isEmpty(patAgg.getPatiAddrDO())){
			for (PatiAddrDO addr : patAgg.getPatiAddrDO()) {
				if(IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getSd_addrtp())){
					addrDo = addr;
					break;
				}
			}
		}
		
		ps.setString(1, IPiPatConst.CHIS_CREATE_TERMINAL); //终端编号（操作员号 5位）需his首先维护每台自助机的用户名
		ps.setString(2, null);//参保机构代码（AAAAAA新农合、000000异地医保）
		ps.setString(3, null);//病人卡号 
		ps.setString(4, null);//保险编号
		ps.setString(5, patDo.getSd_idtp());//证件类型
		ps.setString(6, patDo.getId_code());//证件号码
		ps.setString(7, patDo.getName());//姓名
		ps.setString(8, IPiDictCodeConst.SD_SEX_UNKNOW.equals(patDo.getSd_sex()) ? IPiDictCodeConst.SD_SEX_UNEXPLAIN : patDo.getSd_sex());//性别
		ps.setString(9, null);//病人年龄
		ps.setString(10, null);//人员类别
		ps.setString(11, this.getBirthDate(patDo));//出生日期
		ps.setString(12, null);//分中心名称
		ps.setString(13, patDo.getWorkunit());//工作单位名称
		ps.setDouble(14, 0d);//个人账户余额
		ps.setString(15, patDo.getMob());//手机号码
		ps.setString(16, null);//备用入参 
		if(addrDo!= null){
			ps.setString(17, addrDo.getSd_admdiv());//区域码
			ps.setString(18, addrDo.getStreet());//街道地址
		}else{
			ps.setString(17, null);//区域码
			ps.setString(18, null);//街道地址
		}
		ps.registerOutParameter(19, java.sql.Types.VARCHAR);//患者编码
		ps.registerOutParameter(20, java.sql.Types.VARCHAR);//患者条码
		ps.registerOutParameter(21, java.sql.Types.VARCHAR);//错误信息
		ps.registerOutParameter(22, java.sql.Types.VARCHAR);//
		
		//日志参数
		String[] logArgs = new String[18];
		logArgs[0] = IPiPatConst.CHIS_CREATE_TERMINAL;
		logArgs[1] = "";
		logArgs[2] = "";
		logArgs[3] = "";
		logArgs[4] = patDo.getSd_idtp();
		logArgs[5] = patDo.getId_code();
		logArgs[6] = patDo.getName();
		logArgs[7] = IPiDictCodeConst.SD_SEX_UNKNOW.equals(patDo.getSd_sex()) ? IPiDictCodeConst.SD_SEX_UNEXPLAIN : patDo.getSd_sex();
		logArgs[8] = "";
		logArgs[9] =  "";
		logArgs[10] = this.getBirthDate(patDo);
		logArgs[11] = "";
		logArgs[12] = patDo.getWorkunit();
		logArgs[13] = "0";
		logArgs[14] = patDo.getMob();
		logArgs[15] = "";
		if(addrDo!= null){
			logArgs[16] = addrDo.getSd_admdiv();
			logArgs[17] = addrDo.getStreet();
		}else{
			logArgs[16] = "";
			logArgs[17] = "";
		}
		PiGjLogUtil.logChisCreateSelf(logArgs);
	}

	@Override
	protected void dealCallBack(CallableStatement ps, PatiAggDO patAgg) throws BizException, SQLException {
			
		PiGjLogUtil.logChisCreateSelfRlt(ps);
		
		if(!"成功".equals(ps.getString(21)) || StringUtil.isEmpty(ps.getString(19))){
			throw new BizException(ps.getString(21));
		}
		
		//回写患者编码及chis码
		PatDO pat = patAgg.getParentDO();
		pat.setCode(ps.getString(19));
		pat.setMnecode(pat.getCode());
		pat.setBarcode_chis(ps.getString(20));
	}
}
