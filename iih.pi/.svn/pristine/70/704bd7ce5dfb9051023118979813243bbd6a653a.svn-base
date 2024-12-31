package iih.pi.reg.s.customer.guoji;

import java.sql.CallableStatement;
import java.sql.SQLException;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.s.customer.guoji.util.PiGjLogUtil;
import iih.pi.reg.s.customer.guoji.util.PiPatProcCallBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * chis建档(医保病人)
 * @author ly 2017/08/23
 *
 */
public class PiPatCreateByChisMedInsBP extends PiPatProcCallBaseBP{

	@Override
	protected String getProcName() {
		return "{call SP_SST_MZ_DAXXDJ(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	}

	@Override
	protected void setParam(CallableStatement ps, PatiAggDO patAgg) throws SQLException{
		
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
		
		PiPatHpDO patHpDo = null;
		for (PiPatHpDO hpDo : patAgg.getPiPatHpDO()) {
			if(FBoolean.TRUE.equals(hpDo.getFg_chisuse())){
				patHpDo = hpDo;
			}
		}
		
		ps.setString(1, IPiPatConst.CHIS_CREATE_TERMINAL); //终端编号（操作员号 5位）需his首先维护每台自助机的用户名
		ps.setString(2, null);//参保机构代码（AAAAAA新农合、000000异地医保）
		ps.setString(3, null);//病人卡号 
		ps.setString(4, null);//保险编号
		
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDo.getSd_idtp())){
			ps.setString(5, patDo.getId_code());//身份证号码
		}else{
			ps.setString(5, null);//身份证号码
		}
		
		ps.setString(6, patDo.getName());//姓名
		ps.setString(7, IPiDictCodeConst.SD_SEX_UNKNOW.equals(patDo.getSd_sex()) ? IPiDictCodeConst.SD_SEX_UNEXPLAIN : patDo.getSd_sex());//性别
		ps.setString(8, null);//病人年龄
		ps.setString(9, null);//人员类别
		ps.setString(10, this.getBirthDate(patDo));//出生日期
		ps.setString(11, null);//分中心名称
		ps.setString(12, patDo.getWorkunit());//工作单位名称
		ps.setFloat(13, 0f);//个人账户余额
		ps.setString(14, StringUtil.isEmpty(patDo.getMob()) ? patDo.getTel() : patDo.getMob());//手机号码
		ps.setString(15, patHpDo.getNo_hp());//备用入参 医保卡号
		ps.setString(16, patDo.getInput_psw());//密码
		
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
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDo.getSd_idtp())){
			logArgs[4] = patDo.getId_code();
		}else{
			logArgs[4] = "";
		}
		logArgs[5] = patDo.getName();
		logArgs[6] = IPiDictCodeConst.SD_SEX_UNKNOW.equals(patDo.getSd_sex()) ? IPiDictCodeConst.SD_SEX_UNEXPLAIN : patDo.getSd_sex();
		logArgs[7] = "";
		logArgs[8] = "";
		logArgs[9] =  this.getBirthDate(patDo);
		logArgs[10] = "";
		logArgs[11] = patDo.getWorkunit();
		logArgs[12] = "0";
		logArgs[13] = StringUtil.isEmpty(patDo.getMob()) ? patDo.getTel() : patDo.getMob();
		logArgs[14] = patHpDo.getNo_hp();
		logArgs[15] = patDo.getInput_psw();
		if(addrDo!= null){
			logArgs[16] = addrDo.getSd_admdiv();
			logArgs[17] = addrDo.getStreet();
		}else{
			logArgs[16] = "";
			logArgs[17] = "";
		}
		PiGjLogUtil.logChisCreateIns(logArgs);
	}

	@Override
	protected void dealCallBack(CallableStatement ps, PatiAggDO patAgg) throws BizException,SQLException {
		
		PiGjLogUtil.logChisCreateInsRlt(ps);
		
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
