package iih.en.pv.inpatient.d;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 出院检查信息
 * @author yank
 *
 */
public class OutDepChkInfo {
	//转科
	public static final String FLAG_CFG_LENTH_TRANS = "Trans_dept";
	//出院
	public static final String FLAG_CFG_LENTH_LEAVE = "Leave_hos";
	
	private String checkTp;//核查类型
	private Integer fg_or;//医嘱
	private Integer fg_mp;//执行
	private Integer fg_mm;//药品
	private Integer fg_mt;//医技
	private Integer fg_bl;//费用
	
	public String getCheckTp() {
		return checkTp;
	}
	public void setCheckTp(String checkTp) {
		this.checkTp = checkTp;
	}
	public Integer getFg_or() {
		return fg_or;
	}
	public void setFg_or(Integer fg_or) {
		this.fg_or = fg_or;
	}
	public Integer getFg_mp() {
		return fg_mp;
	}
	public void setFg_mp(Integer fg_mp) {
		this.fg_mp = fg_mp;
	}
	public Integer getFg_mm() {
		return fg_mm;
	}
	public void setFg_mm(Integer fg_med) {
		this.fg_mm = fg_med;
	}
	public Integer getFg_mt() {
		return fg_mt;
	}
	public void setFg_mt(Integer fg_mt) {
		this.fg_mt = fg_mt;
	}
	public Integer getFg_bl() {
		return fg_bl;
	}
	public void setFg_bl(Integer fg_bl) {
		this.fg_bl = fg_bl;
	}

	/**
	 * 从参数配置中加载
	 * 
	 * @param cfg  参数配置字符串 每个字符代表一个标志。
	 * 			 0-表示不检查 1-表示有内容警示 2-表示有内容强制不允许出院 
	 *            第1位：医嘱未处理
	 *            第2位：医嘱未执行确认 
	 *            第3位： 药品未发药。 
	 *            第4位： 医技项目未执行确认。
	 *            第5位：费用
	 * 
	 * @return
	 */
	public static OutDepChkInfo loadFromCfg(String cfg, String outDepTp) throws BizException{
		OutDepChkInfo chkInfo = new OutDepChkInfo();
		chkInfo.setCheckTp(outDepTp);
		if (FLAG_CFG_LENTH_LEAVE.equals(outDepTp)) {
			//出院
			if(StringUtil.isEmptyWithTrim(cfg) || cfg.length() != 5)
				throw new BizException("出院核查内容参数配置错误!");
			chkInfo.setFg_or(Integer.parseInt(String.valueOf(cfg.charAt(0))));
			chkInfo.setFg_mp(Integer.parseInt(String.valueOf(cfg.charAt(1))));
			chkInfo.setFg_mm(Integer.parseInt(String.valueOf(cfg.charAt(2))));
			chkInfo.setFg_mt(Integer.parseInt(String.valueOf(cfg.charAt(3))));
			chkInfo.setFg_bl(Integer.parseInt(String.valueOf(cfg.charAt(4))));
		}
		if (FLAG_CFG_LENTH_TRANS.equals(outDepTp)) {			
			//转科转出
			if(StringUtil.isEmptyWithTrim(cfg) || cfg.length() != 4)
				throw new BizException("转科核查内容参数配置错误!");
			chkInfo.setFg_or(Integer.parseInt(String.valueOf(cfg.charAt(0))));
			chkInfo.setFg_mp(Integer.parseInt(String.valueOf(cfg.charAt(1))));
			chkInfo.setFg_mm(Integer.parseInt(String.valueOf(cfg.charAt(2))));
			chkInfo.setFg_mt(Integer.parseInt(String.valueOf(cfg.charAt(3))));
		}

		return chkInfo;
	}
}
